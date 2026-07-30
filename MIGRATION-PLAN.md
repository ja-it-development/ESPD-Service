# Migration Plan: Spring Boot 1.4.7 -> 4.1.0 + Jakarta EE

## Objective

Migrate the ESPD-Service application from:
- **Spring Boot 1.4.7.RELEASE** -> **Spring Boot 4.1.0**
- **Java 1.7** -> **Java 17+**
- **Java EE 8 (javax.\*)** -> **Jakarta EE (jakarta.\*)**

---

## Phase 1: Parent POM and base versions

**File**: `pom.xml` (root)

- Update `<parent>` from `spring-boot-starter-parent:1.4.7.RELEASE` to `spring-boot-starter-parent:4.1.0`
- Change `<java.version>` from `1.7` to `17`
- Update dependency version properties (see Phase 2)

---

## Phase 2: Dependencies in pom.xml

### 2.1 Dependencies to replace

| Current dependency | New dependency | Notes |
|---|---|---|
| `javax.servlet:jstl` | `jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api` + `org.glassfish.web:jakarta.servlet.jsp.jstl` (impl) | Jakarta JSTL 3.0 |
| `org.apache.tiles:tiles-jsp:3.0.4` | `com.github.tntim96.apache.tiles:tiles-jsp:3.1.0.0` | Jakarta EE fork of Tiles (the only one published on Maven Central) |
| `org.glassfish.jaxb:jaxb-runtime:2.2.11` | Managed by Spring Boot 4 BOM (jakarta.xml.bind 4.x) | Remove explicit version management |
| `net.bull.javamelody:javamelody-core:1.61.0` | `net.bull.javamelody:javamelody-spring-boot-starter:2.8.0` | Starter dedicated to Spring Boot 3/4, includes javamelody-core 2.x |
| `ro.isdc.wro4j:wro4j-core:1.8.0` | `ro.isdc.wro4j:wro4j-core:2.x` | Version 2.x migrated to Jakarta Servlet API |
| `eu.michael-simons:wro4j-spring-boot-starter:0.0.8` | `eu.michael-simons:wro4j-spring-boot-starter:1.0.x` | Version compatible with Spring Boot 4.0.x |
| `org.projectlombok:lombok:1.16.6` | `org.projectlombok:lombok:1.18.36` | Java 17+ support |
| `com.google.guava:guava:18.0` | `com.google.guava:guava:33.x` | Update required for Java 17 |
| `commons-fileupload:commons-fileupload:1.3.1` | To be evaluated for removal | Spring Boot 4 has native multipart support; may no longer be needed |
| `org.apache.commons:commons-lang3:3.9` | Update to `3.17.0` | Java 17 compatibility |

### 2.2 Test dependencies to replace

| Current dependency | New dependency | Notes |
|---|---|---|
| `org.spockframework:spock-core:1.0-groovy-2.4` | `org.spockframework:spock-core:2.4-M7-groovy-4.0` | Spock 2.x based on JUnit Platform |
| `org.codehaus.groovy:groovy-all:2.4.1` | `org.apache.groovy:groovy-all:4.0.24` | Groovy 4.x (groupId change!) |
| `cglib:cglib-nodep:3.1` | **Remove** | No longer needed with Spock 2.x |
| `org.objenesis:objenesis:2.1` | **Remove** | No longer needed with Spock 2.x |

> **Note on Spock + Spring Boot 4**: Spring Boot 4.0 removed official Spock integration because Spock did not yet support Groovy 5 at release time. However Spock 2.4 with Groovy 4.0 works correctly with Spring Framework 7 / Spring Boot 4. The only impact is that Spring test context caching may be less optimal (more contexts created). Functionally there are no issues.

### 2.3 External dependency to verify

- `eu.europa.ec.grow.espd:exchange-model:1.0.2` - External artifact. If it contains classes with `javax.*` (e.g. JAXB annotations) it may create conflicts. **Must be verified separately**.

---

## Phase 3: Java files - Namespace conversion

### 3.1 Imports to convert (javax -> jakarta)

Only packages that are part of Jakarta EE should be converted. `javax.*` packages that are part of the JDK (javax.naming, javax.sql, javax.xml.transform, javax.xml.parsers, etc.) **MUST NOT be changed**.

| Package | Action | Affected files |
|---|---|---|
| `javax.servlet.*` | -> `jakarta.servlet.*` | EspdController.java, PermissionManager.java, I18NFunc.java |
| `javax.xml.bind.*` | -> `jakarta.xml.bind.*` | EspdXmlImporter.java, JaxbConfiguration.java |
| `javax.naming.*` | **DO NOT TOUCH** (part of JDK) | ESOPDBConnector.java |
| `javax.sql.*` | **DO NOT TOUCH** (part of JDK) | ESOPDBConnector.java |
| `javax.xml.transform.*` | **DO NOT TOUCH** (part of JDK) | HtmlToPdfTransformer.java, XsltURIResolver.java, ApacheFopConfig.java, EspdXmlExporter.java, EspdXmlImporter.java |

### 3.2 Per-file detail

1. **EspdController.java** - 4 imports to convert:
   - `javax.servlet.http.Cookie` -> `jakarta.servlet.http.Cookie`
   - `javax.servlet.http.HttpServletRequest` -> `jakarta.servlet.http.HttpServletRequest`
   - `javax.servlet.http.HttpServletResponse` -> `jakarta.servlet.http.HttpServletResponse`
   - `javax.servlet.http.HttpSession` -> `jakarta.servlet.http.HttpSession`

2. **PermissionManager.java** - 3 imports to convert:
   - `javax.servlet.http.HttpServletRequest` -> `jakarta.servlet.http.HttpServletRequest`
   - `javax.servlet.http.HttpServletResponse` -> `jakarta.servlet.http.HttpServletResponse`
   - `javax.servlet.http.HttpSession` -> `jakarta.servlet.http.HttpSession`

3. **I18NFunc.java** - 1 import to convert:
   - `javax.servlet.jsp.PageContext` -> `jakarta.servlet.jsp.PageContext`

4. **EspdXmlImporter.java** - 1 import to convert:
   - `javax.xml.bind.JAXBElement` -> `jakarta.xml.bind.JAXBElement`

5. **JaxbConfiguration.java** - 1 import to convert:
   - `javax.xml.bind.Marshaller` -> `jakarta.xml.bind.Marshaller`

---

## Phase 4: Apache Tiles - Manual configuration

### Problem

Spring Framework 6+ has **completely removed** the package `org.springframework.web.servlet.view.tiles3` (TilesConfigurer, TilesViewResolver, TilesView). Apache Tiles is a retired project (attic) since 2018.

### Solution

1. Use the Jakarta EE fork: `com.github.tntim96.apache.tiles:tiles-jsp:3.1.0.0`
2. Create a Spring configuration class `TilesConfig.java` that:
   - Configures `TilesContainerFactory` and `TilesContainer` manually
   - Registers a custom `ViewResolver` based on `TilesContainer`
   - Loads definitions from `tiles.xml` (existing file: `src/main/resources/tiles.xml`)
3. Remove any reference to `org.springframework.web.servlet.view.tiles3.*`

### Affected files

- New file: `espd-web/src/main/java/eu/europa/ec/grow/espd/config/TilesConfig.java`
- Verify if a Tiles configuration already exists in the project (it may have been auto-configured by old Spring Boot)

---

## Phase 5: application.properties - Renamed properties

Update properties renamed between Spring Boot 1.x and 4.x.

**Affected files**: `application.properties` and all profiles (`application-dev.properties`, `application-acc.properties`, `application-prod.properties`, `application-load.properties`)

| Old property | New property | Notes |
|---|---|---|
| `server.context-path` | `server.servlet.context-path` | Renamed in Boot 2.0 |
| `spring.resources.cache-period` | `spring.web.resources.cache.period` | Renamed in Boot 2.6 |
| `spring.http.encoding.charset` | `server.servlet.encoding.charset` | Renamed in Boot 2.3 |
| `spring.http.encoding.force` | `server.servlet.encoding.force` | Renamed in Boot 2.3 |
| `multipart.enabled` | `spring.servlet.multipart.enabled` | Renamed in Boot 2.0 |
| `multipart.file-size-threshold` | `spring.servlet.multipart.file-size-threshold` | Renamed in Boot 2.0 |
| `multipart.max-file-size` | `spring.servlet.multipart.max-file-size` | Renamed in Boot 2.0 (value: use `5MB` not `5Mb`) |
| `multipart.max-request-size` | `spring.servlet.multipart.max-request-size` | Renamed in Boot 2.0 (value: use `5MB` not `5Mb`) |
| `spring.messages.cache-seconds=3` | `spring.messages.cache-duration=3s` | Now accepts Duration (Boot 2.6) |

---

## Phase 6: web.xml

**File**: `espd-web/src/main/webapp/WEB-INF/web.xml`

- Update namespace from `http://java.sun.com/xml/ns/javaee` to `https://jakarta.ee/xml/ns/jakartaee`
- Update `xsi:schemaLocation` accordingly
- Update `version` attribute to `6.1` (Servlet 6.1, baseline of Spring Boot 4)

---

## Phase 7: Maven plugins

**Files**: `pom.xml` (root) and `espd-web/pom.xml`

### 7.1 maven-enforcer-plugin
- Update plugin version (from `1.2` to `3.x`)
- Update `requireJavaVersion` to `[17,)`
- Update `requireMavenVersion` to `[3.9,)` (Boot 4 compatibility)
- Remove `<exclude>com.sun.xml.bind:jaxb-impl</exclude>` (no longer relevant)

### 7.2 gmavenplus-plugin
- Update from version `1.5` to `4.x` to support Groovy 4.x and Java 17

### 7.3 wro4j-maven-plugin
- Update from `${wro4j.version}` (1.8.0) to `2.x`

### 7.4 maven-compiler-plugin
- Explicit `<source>` and `<target>` configuration can be removed: Spring Boot parent manages Java 17 through the `java.version` property

### 7.5 spring-boot-maven-plugin
- No change required (managed by parent)

---

## Phase 8: Verification

1. **Build**: `mvn clean compile` - verify it compiles without errors
2. **Iterative fixes**: resolve compilation errors one at a time
3. **Tests**: `mvn test` - verify Spock tests work
4. **BOM check**: no file must start with `EF BB BF` (UTF-8 BOM)
5. **Residual import check**: no `import javax.servlet`, `import javax.xml.bind` should remain

---

## Risks and attention points

### HIGH risk
1. **Apache Tiles**: The `tntim96` fork is the only option published on Maven Central for Tiles + Jakarta EE. It has only one version (3.1.0.0, October 2024). Manual TilesConfigurer configuration requires custom code because Spring 6+ no longer provides integration classes.

2. **espd-exchange-model:1.0.2**: External dependency. If it uses `javax.xml.bind` annotations (JAXB 2.x) internally, an updated version to Jakarta JAXB 4.x or a bridge/adapter will be required.

### MEDIUM risk
3. **Spock + Spring Boot 4**: Spock integration was removed from Boot 4 but Spock 2.4 works. Test context caching may be less efficient (more ApplicationContexts created).

4. **Apache FOP 2.1**: Version from 2016. May have issues with Java 17+ (access to internal modules). May need to update to FOP 2.9+ or add `--add-opens` to the JVM.

5. **wro4j-spring-boot-starter 1.0.x**: Indicated as compatible with Boot 4.0.x in the official table. To be verified if it also works with 4.1.x.

### LOW risk
6. **JSP JSTL URI**: The URIs `http://java.sun.com/jsp/jstl/core` and `http://java.sun.com/jsp/jstl/fmt` used in the 49 JSP files continue to work with Jakarta JSTL (aliases maintained for backward compatibility). **JSP files do not need to be modified**.

7. **Spring Boot properties**: Well documented and deterministic mapping.

---

## Summary of files to modify

| File | Type of change |
|---|---|
| `pom.xml` (root) | Update parent, properties, dependencies, plugins |
| `espd-web/pom.xml` | Update dependencies, plugins |
| `espd-docs/pom.xml` | Update parent version |
| `EspdController.java` | 4 imports javax -> jakarta |
| `PermissionManager.java` | 3 imports javax -> jakarta |
| `I18NFunc.java` | 1 import javax -> jakarta |
| `EspdXmlImporter.java` | 1 import javax -> jakarta |
| `JaxbConfiguration.java` | 1 import javax -> jakarta |
| `TilesConfig.java` (NEW) | Manual Tiles configuration for Spring 6+ |
| `web.xml` | Namespace javaee -> jakartaee |
| `application.properties` | Renamed properties |
| `application-dev.properties` | Renamed properties (if same keys present) |
| `application-acc.properties` | Renamed properties (if same keys present) |
| `application-prod.properties` | Renamed properties (if same keys present) |
| `application-load.properties` | Renamed properties (if same keys present) |
