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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import java.util.Map;

/**
 * Custom Tiles view for Spring Framework 6+ / Spring Boot 3+ with Jakarta EE.
 * <p>Replaces the removed {@code org.springframework.web.servlet.view.tiles3.TilesView}.</p>
 */
public class TilesView extends AbstractUrlBasedView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ApplicationContext applicationContext = new ServletApplicationContext(request.getServletContext());
        ServletRequest tilesRequest = new ServletRequest(applicationContext, request, response);
        TilesContainer container = TilesAccess.getContainer(applicationContext);
        if (container == null) {
            throw new IllegalStateException("TilesContainer not found. "
                    + "Ensure that a TilesConfigurer is configured.");
        }
        TilesAccess.setCurrentContainer(tilesRequest, container);
        model.forEach(request::setAttribute);
        container.render(getUrl(), tilesRequest);
    }
}
