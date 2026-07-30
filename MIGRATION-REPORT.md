# ESPD-Service Migration Report

## Overview

This report documents the migration of the ESPD-Service multi-module Maven project from the legacy Java EE 8 stack to Jakarta EE 9+/Spring Boot 4, completed on the `feature/EE-10` branch.

| Aspect | Before | After |
|---|---|---|
| Spring Boot | `1.4.7.RELEASE` | `4.1.0` |
| Java | `1.7` | `17` |
| Servlet API | `javax.servlet.*` | `jakarta.servlet.*` |
| JAXB API | `javax.xml.bind.*` | `jakarta.xml.bind.*` |
| JSP/JSTL | Java EE (`javax.servlet.jsp.jstl`) | Jakarta EE (`jakarta.servlet.jsp.jstl`) |
| Groovy | `2.4.1` (groupId `org.codehaus.groovy`) | `4.0.24` (groupId `org.apache.groovy`) |
| Spock | `1.0-groovy-2.4` | `2.4-M5-groovy-4.0` |

The migration was driven by the need to run the application on modern JDKs and on servlet containers/Tomcat versions that only support the `jakarta.*` namespace (Tomcat 10+).

---

## Environment

- **Repository**: `C:\BigData\OtherProjects\ESPD-Service`
- **Branch**: `feature/EE-10`
- **Build tool**: Apache Maven 3.9+
- **JDK**: OpenJDK 17
- **Reactor modules** after migration:
  - `espd-libs` (new) - installs Jakarta-converted binary dependencies into the local Maven repository
  - `espd-web` - main web application (WAR)
  - `espd-docs` - Asciidoctor-based documentation

---

## 1. Root POM changes

**File**: `pom.xml`

- Updated Spring Boot parent from `1.4.7.RELEASE` to `4.1.0`.
- Set `<java.version>17</java.version>`.
- Bumped dependency version properties:
  - `groovy.version` to `4.0.24`
  - `spock.version` to `2.4-M5-groovy-4.0`
  - `lombok.version` to `1.18.36`
  - `guava.version` to `33.4.0-jre`
  - `wro4j.version` to `2.1.0`
  - `javamelody.version` to `2.8.0`
  - `espd-exchange-model.version` to `1.0.2-jakarta`
- Added `groovy-dateutil` to dependency management to restore Groovy date extension methods (`Date.plus()`, `Date.minus()`) removed in Groovy 4.
- Managed Groovy/Spock dependencies through `<dependencyManagement>` so that every module uses the same Groovy 4 artifacts.

---

## 2. `espd-web` POM changes

**File**: `espd-web/pom.xml`

### 2.1 Dependency replacements

| Removed | Added |
|---|---|
| `javax.servlet:jstl` | `jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api` + `org.glassfish.web:jakarta.servlet.jsp.jstl` |
| `org.apache.tiles:tiles-jsp` | `com.github.tntim96.apache.tiles:tiles-jsp` |
| `net.bull.javamelody:javamelody-core` | `net.bull.javamelody:javamelody-spring-boot-starter` |
| `eu.michael-simons:wro4j-spring-boot-starter:0.0.8` | `eu.michael-simons:wro4j-spring-boot-starter:1.0.0` |
| `javax.xml.bind:jaxb-api:2.3.1` | `jakarta.xml.bind:jakarta.xml.bind-api` + `org.glassfish.jaxb:jaxb-runtime` |

Additional dependencies added:
- `com.fasterxml.jackson.core:jackson-databind`
- `commons-collections:commons-collections:3.2.2`
- `org.jvnet.jaxb:jaxb2-basics-runtime:2.0.16-jakarta` (Jakarta-converted runtime for generated JAXB classes)

The transitive `org.jvnet.jaxb2_commons:jaxb2-basics-runtime:0.9.5` coming from `exchange-model` is now explicitly excluded.

### 2.2 Plugin updates

- `maven-resources-plugin`: extended `nonFilteredFileExtensions` to protect binary web assets (eot, gif, ico, jpeg, jpg, otf, pdf, png, svg, ttf, woff, woff2) from filtering corruption.
- `maven-enforcer-plugin`: updated to `3.5.0`; `requireJavaVersion` set to `[17,)`; `requireMavenVersion` set to `[3.9,)`.
- `gmavenplus-plugin`: updated to `4.2.0`; Groovy compilation goals renamed from `compile`/`testCompile` to `compile`/`compileTests`.
- `maven-surefire-plugin`: added `**/*Spec.groovy` to test class patterns.
- Removed the explicit `maven-compiler-plugin` configuration because Spring Boot 4 parent manages it.

---

## 3. New `espd-libs` module

**File**: `espd-libs/pom.xml`

Two external artifacts still contained `javax.*` bytecode after the source-level migration, so they were converted to Jakarta using the Eclipse Transformer and packaged inside the repository:

- `exchange-model-1.0.2-jakarta.jar` (originally `eu.europa.ec.grow.espd:exchange-model:1.0.2`)
- `jaxb2-basics-runtime-2.0.16-jakarta.jar` (originally `org.jvnet.jaxb:jaxb2-basics-runtime:2.0.16`)

The `espd-libs` module runs `maven-install-plugin:install-file` during the `initialize` phase, installing both JARs into the local Maven repository before `espd-web` resolves its dependencies. This makes the build self-contained and CI-friendly.

The root POM declares `espd-libs` before `espd-web` in the module list to guarantee the correct reactor order.

---

## 4. Java source migration

All references to Jakarta EE APIs were migrated from `javax.*` to `jakarta.*`.

### 4.1 Servlet/JSP API

- `EspdController.java`
- `PermissionManager.java`
- `I18NFunc.java`

Imports updated: `Cookie`, `HttpServletRequest`, `HttpServletResponse`, `HttpSession`, `PageContext`.

### 4.2 JAXB API

- `EspdXmlImporter.java`
- `JaxbConfiguration.java`

Imports updated: `JAXBElement`, `Marshaller`.

### 4.3 Other source changes

- `EspdApplication.java`: `SpringBootServletInitializer` moved from `org.springframework.boot.web.support` to `org.springframework.boot.web.servlet.support`.
- `WebConfiguration.java`:
  - Updated imports to `jakarta.servlet.*`.
  - `CookieLocaleResolver` is now constructed with the cookie name in the constructor instead of `setCookieName()`.
- `Wro4jConfig.java`: added a constructor matching the new Spring Boot 4 auto-configuration signature `Wro4jAutoConfiguration(ApplicationContext, Optional<ResourceAuthorizationManager>)`.
- `HtmlToPdfTransformer.java`: updated to Jakarta-compatible FOP/XML transformer types.
- `EspdController.java`: adapted to Jakarta servlet types and Spring 6 controller patterns. The catch-all mapping `@RequestMapping("**/null/**")` was split into `@RequestMapping({"/null", "/null/**", "/**/null"})` because Spring 6 no longer allows multiple `**` segments in a single path pattern.

### 4.4 New Tiles support for Spring 6+

Spring Framework 6 removed the package `org.springframework.web.servlet.view.tiles3`, so the project now provides its own integration:

- `TilesConfigurer.java`
- `TilesView.java`
- `TilesViewResolver.java`

These classes are located in `espd-web/src/main/java/eu/europa/ec/grow/espd/config/tiles/`. They use the Jakarta-compatible fork `com.github.tntim96.apache.tiles:tiles-jsp` and expose the `TilesContainer` as a Spring bean.

The custom `TilesConfigurer` overrides `BasicTilesContainerFactory.getSources(...)` so that the definition locations configured in `WebConfiguration.tilesConfigurer()` (e.g. `classpath:tiles.xml`) are actually passed to the Tiles container. `classpath:` prefixes are translated to `/WEB-INF/classes/` paths because `ServletApplicationContext.getResource(...)` does not resolve Spring `classpath:` URLs.

The custom `TilesView` calls `TilesAccess.setCurrentContainer(tilesRequest, container)` before rendering. Without this step, the JSP Tiles tags (such as `<tiles:importAttribute>` and `<tiles:insertAttribute>`) cannot find the current container because the `ApplicationContext` is not attached to the request during the Tiles include.

---

### 4.5 JSP Spring form tags

Spring 6 removed support for the deprecated `commandName` attribute on `<form:form>`. The application used `commandName="espd"` (and `commandName="espdFilterParams"` in `filter.jsp`). When `commandName` is ignored, Spring form tags fall back to the default bean name `command`, causing:

```text
Neither BindingResult nor plain target object for bean name 'command' available as request attribute
```

All occurrences in the JSP views were replaced with `modelAttribute`:

```jsp
<!-- before -->
<form:form ... commandName="espd">

<!-- after -->
<form:form ... modelAttribute="espd">
```

Files updated under `espd-web/src/main/resources/META-INF/resources/WEB-INF/views/`:
- `filter.jsp`
- `print.jsp`
- `wizard/exclusionCA.jsp`
- `wizard/exclusionEO.jsp`
- `wizard/finish.jsp`
- `wizard/procedure.jsp`
- `wizard/selectionCA.jsp`
- `wizard/selectionEO.jsp`

## 5. web.xml

**File**: `espd-web/src/main/webapp/WEB-INF/web.xml`

- Namespace updated from `http://java.sun.com/xml/ns/javaee` to `https://jakarta.ee/xml/ns/jakartaee`.
- `xsi:schemaLocation` updated accordingly.
- `version` attribute set to `6.1` (Servlet 6.1, baseline of Spring Boot 4).

---

## 6. `application.properties` and profiles

**Files**:
- `application.properties`
- `application-dev.properties`
- `application-acc.properties`
- `application-prod.properties`
- `application-load.properties`

Renamed properties to match Spring Boot 4 conventions:

| Old property | New property |
|---|---|
| `server.context-path` | `server.servlet.context-path` |
| `spring.resources.cache-period` | `spring.web.resources.cache.period` |
| `spring.http.encoding.charset` | `server.servlet.encoding.charset` |
| `spring.http.encoding.force` | `server.servlet.encoding.force` |
| `multipart.enabled` | `spring.servlet.multipart.enabled` |
| `multipart.file-size-threshold` | `spring.servlet.multipart.file-size-threshold` |
| `multipart.max-file-size` | `spring.servlet.multipart.max-file-size` |
| `multipart.max-request-size` | `spring.servlet.multipart.max-request-size` |
| `spring.messages.cache-seconds` | `spring.messages.cache-duration` |

---

## 7. Test changes

- `AbstractEspdXmlMarshalling.groovy`: updated imports from `groovy.util.slurpersupport.GPathResult` and `groovy.util.XmlSlurper` to `groovy.xml.slurpersupport.GPathResult` and `groovy.xml.XmlSlurper`.
- Added `groovy-dateutil` dependency to restore `java.util.Date.plus()` / `minus()` extension methods used by several Spock specs.

All tests now run on JUnit Platform through Surefire 3.5.2.

---

## 8. Verification

### 8.1 Full clean build

```bash
mvn clean package
```

**Result**: `BUILD SUCCESS`

Reactor summary:

```text
[INFO] ESPD web application ............................... SUCCESS
[INFO] ESPD Jakarta converted libraries installer ......... SUCCESS
[INFO] espd-web Maven Webapp .............................. SUCCESS
[INFO] espd-docs .......................................... SUCCESS
[INFO] Tests run: 931, Failures: 0, Errors: 0, Skipped: 0
```

### 8.2 Clean build without pre-installed converted JARs

To verify that the `espd-libs` module is sufficient for a fresh CI environment, the locally installed artifacts were removed before the build:

```text
%USERPROFILE%\.m2\repository\eu\europa\ec\grow\espd\exchange-model\1.0.2-jakarta
%USERPROFILE%\.m2\repository\org\jvnet\jaxb\jaxb2-basics-runtime\2.0.16-jakarta
```

The subsequent `mvn clean package` rebuilt both artifacts and passed all tests.

### 8.3 Encoding check

A BOM check was run over all `.java`, `.xml`, and `.properties` files. No UTF-8 BOM (`EF BB BF`) was detected.

---

## 9. Known warnings

The following warnings are non-blocking but worth monitoring:

- **Wro4j font URL warnings**: the CSS DataUri processor reports missing font resources for URLs containing query strings (`?v=4.2.0`, `?#iefix`). This also existed before the migration and does not break the build.
- **Deprecated API usage**: `EspdExporter.java` uses deprecated APIs; `-Xlint:deprecation` can be enabled later for cleanup.
- **Unchecked/unsafe operations**: `EspdController.java` triggers a generic unchecked warning; this is pre-existing.
- **Lombok `EqualsAndHashCode`**: `EspdInitializationParameters.java` suggests adding `@EqualsAndHashCode(callSuper=false)`; this is a warning, not an error.
- **Asciidoctor callout/index warnings**: present in `xmlChanges.adoc`; unrelated to the migration.

---

## 10. Files changed

### POMs
- `pom.xml` (root)
- `espd-web/pom.xml`
- `espd-docs/pom.xml`
- `espd-libs/pom.xml` (new)

### Java sources
- `espd-web/src/main/java/eu/europa/ec/grow/espd/config/EspdApplication.java`
- `espd-web/src/main/java/eu/europa/ec/grow/espd/config/JaxbConfiguration.java`
- `espd-web/src/main/java/eu/europa/ec/grow/espd/config/WebConfiguration.java`
- `espd-web/src/main/java/eu/europa/ec/grow/espd/config/Wro4jConfig.java`
- `espd-web/src/main/java/eu/europa/ec/grow/espd/config/tiles/TilesConfigurer.java` (new)
- `espd-web/src/main/java/eu/europa/ec/grow/espd/config/tiles/TilesView.java` (new)
- `espd-web/src/main/java/eu/europa/ec/grow/espd/controller/EspdController.java`
- `espd-web/src/main/java/eu/europa/ec/grow/espd/interceptor/PermissionManager.java`
- `espd-web/src/main/java/eu/europa/ec/grow/espd/tenderned/HtmlToPdfTransformer.java`
- `espd-web/src/main/java/eu/europa/ec/grow/espd/util/I18NFunc.java`
- `espd-web/src/main/java/eu/europa/ec/grow/espd/xml/EspdXmlImporter.java`

### Resources
- `espd-web/src/main/resources/application.properties`
- `espd-web/src/main/resources/application-acc.properties`
- `espd-web/src/main/resources/application-dev.properties`
- `espd-web/src/main/resources/application-load.properties`
- `espd-web/src/main/resources/application-prod.properties`
- `espd-web/src/main/webapp/WEB-INF/web.xml`

### Tests
- `espd-web/src/test/groovy/eu/europa/ec/grow/espd/xml/base/AbstractEspdXmlMarshalling.groovy`

### Documentation
- `MIGRATION-PLAN.md` (translated to English)
- `MIGRATION-REPORT.md` (this file, new)

### Repository-tracked binary artifacts
- `espd-libs/libs/exchange-model-1.0.2-jakarta.jar`
- `espd-libs/libs/jaxb2-basics-runtime-2.0.16-jakarta.jar`
- `.gitignore` updated with `!espd-libs/libs/*.jar`

---

## 11. WildFly deployment notes

WildFly 31.0.1.Final provides its own SLF4J binding through the `org.slf4j` module (`slf4j-jboss-logmanager`). Spring Boot 4 ships `spring-boot-starter-logging` which bundles Logback. Including both bindings in the same deployment produces the following error:

```text
LoggerFactory is not a Logback LoggerContext but Logback is on the classpath.
Either remove Logback or the competing implementation
(class org.slf4j.impl.Slf4jLoggerFactory loaded from .../slf4j-jboss-logmanager-2.0.1.Final.jar).
```

To avoid the conflict:

- `spring-boot-starter-logging` is now **excluded** from `spring-boot-starter-web`.
- It is added back with `<scope>test</scope>` so unit tests still have a logging implementation.

For external servlet containers like WildFly, build the WAR with the existing `non-embedded` profile. This marks embedded Tomcat dependencies as `provided` and moves them to `WEB-INF/lib-provided`.

Also note that `javamelody-spring-boot-starter` targets Spring Boot 3.x and references the removed class `SchedulerFactoryBeanCustomizer`. For Spring Boot 4 the correct artifact is `javamelody-spring-boot4-starter`.

```bash
mvn clean package -Pnon-embedded -DskipTests
```

The deployable artifact is:

```text
espd-web/target/espd-web.war
```

Copy it to the WildFly deployment directory and start/restart the server.

## 12. How to build

From the repository root:

```bash
mvn clean package
```

To skip tests:

```bash
mvn clean package -DskipTests
```

To produce a WAR for WildFly:

```bash
mvn clean package -Pnon-embedded -DskipTests
```

The build is now fully self-contained: the `espd-libs` module installs the converted `exchange-model` and `jaxb2-basics-runtime` JARs into the local Maven repository before `espd-web` compiles.
