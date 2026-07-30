/*
 *
 * Copyright 2016 EUROPEAN COMMISSION
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they
 * will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/community/eupl/og_page/eupl
 *
 * Unless required by applicable law or agreed to in
 * writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied.
 * See the Licence for the specific language governing
 * permissions and limitations under the Licence.
 *
 */

package eu.europa.ec.grow.espd.config.tiles;

import jakarta.servlet.ServletContext;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.TilesException;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.factory.BasicTilesContainerFactory;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.ApplicationResource;
import org.apache.tiles.request.servlet.ServletApplicationContext;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Tiles configurer for Spring Framework 6+ / Spring Boot 3+ with Jakarta EE.
 * <p>Replaces the removed {@code org.springframework.web.servlet.view.tiles3.TilesConfigurer}.</p>
 */
public class TilesConfigurer implements ServletContextAware, InitializingBean, DisposableBean {

    private ServletContext servletContext;
    private String[] definitions;

    public void setDefinitions(String... definitions) {
        this.definitions = definitions;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void afterPropertiesSet() throws TilesException {
        ApplicationContext applicationContext = new ServletApplicationContext(servletContext);
        BasicTilesContainerFactory factory = new BasicTilesContainerFactory() {
            @Override
            protected List<ApplicationResource> getSources(ApplicationContext applicationContext) {
                List<ApplicationResource> sources = new ArrayList<>();
                if (definitions != null) {
                    for (String definition : definitions) {
                        String path = definition;
                        if (path.startsWith("classpath:")) {
                            path = "/WEB-INF/classes/" + path.substring("classpath:".length());
                        }
                        sources.add(applicationContext.getResource(path));
                    }
                }
                return sources;
            }
        };
        TilesContainer container = factory.createContainer(applicationContext);
        TilesAccess.setContainer(applicationContext, container);
    }

    @Override
    public void destroy() throws Exception {
        if (servletContext != null) {
            ApplicationContext applicationContext = new ServletApplicationContext(servletContext);
            TilesAccess.setContainer(applicationContext, null);
        }
    }
}
