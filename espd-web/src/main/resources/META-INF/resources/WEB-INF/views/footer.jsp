<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  ~
  ~ Copyright 2016 EUROPEAN COMMISSION
  ~
  ~ Licensed under the EUPL, Version 1.1 or – as soon they
  ~ will be approved by the European Commission - subsequent
  ~ versions of the EUPL (the "Licence");
  ~
  ~ You may not use this work except in compliance with the Licence.
  ~
  ~ You may obtain a copy of the Licence at:
  ~
  ~ https://joinup.ec.europa.eu/community/eupl/og_page/eupl
  ~
  ~ Unless required by applicable law or agreed to in
  ~ writing, software distributed under the Licence is
  ~ distributed on an "AS IS" basis,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
  ~ express or implied.
  ~ See the Licence for the specific language governing
  ~ permissions and limitations under the Licence.
  ~
  --%>

<c:set var="ESOP_SESSION" value="${not empty sessionScope.ESOP_VISITORID}"/>

<s:eval var="lastBuildDate" scope="page" expression='@espdConfiguration.lastBuildDate' />
<footer style="color: black" class="hidden-print container-fluid">
	<div class="row">
		<div class="col-lg-12">
			<span data-i18n="footer_last_update"><s:message code='footer_last_update'/></span>
			<span><c:out value="${lastBuildDate}"/></span>
		</div>
	</div>

    <c:if test="${ESOP_SESSION}">

        <style>
            #esop-popup-licence {
                width: 100%;
                min-height: 100%;
                /*background-color: rgba(0,0,0,0.5);*/
                overflow: hidden;
                position: fixed;
                top: 0px;
                z-index: 1000;
            }
            #esop-popup-licence-content {
                margin: 120px auto 0px auto;
                width: 300px;
                padding: 10px;
                background-color: white;
                border-radius: 5px;
                box-shadow: 0px 0px 10px #000;
            }
            #esop-popup-licence-content p {
                text-align: center;
            }

            #esop-popup-licence-close {
                text-decoration: none;
            }

            #esop-licence-link {
                position: absolute;
                right: 20%;
                text-decoration: underline;
                font-size: 12px;
                cursor: pointer;
            }

        </style>

        <div id="esop-popup-licence" style="display: none;">
            <div id="esop-popup-licence-content">
                <span class="licence-text"></span>
                <p><a id="esop-popup-licence-close" data-i18n="ok" style="cursor:pointer;">${i18n['ok']}</a></p>
            </div>
        </div>

        <script>
            $(function () {
                $('#esop-popup-licence-content .licence-text').load('/esop/guest/espd/html/espd_legal_disclaimer.htm' , function(responseTxt, statusTxt, xhr) {
                        if(statusTxt == "success") {
                            $('#esop-popup-licence').prependTo($('body'));
                            $('footer .row').append('<div id="esop-licence-link">Legal information</div>');
                            $('#esop-popup-licence-close').click(function(){$('#esop-popup-licence').hide()});
                            $('#esop-licence-link').click(function(){$('#esop-popup-licence').show()});
                        } else {
                            window.console && console.warn('No legal disclaimer available.');
                        }
                    }
                );
            });
        </script>

    </c:if>

</footer>
<s:eval var="piwikEnabled" scope="page" expression='@espdConfiguration.piwikEnabled' />
<s:eval var="piwikServer" scope="page" expression='@espdConfiguration.piwikServer' />
<s:eval var="piwikId" scope="page" expression='@espdConfiguration.piwikId' />
<c:if test="${piwikEnabled == true}">
	<%-- old sync piwik load
    <script type="text/javascript">
        var piwik = Piwik.getTracker("${piwikServer}", ${piwikId});
        piwik.enableLinkTracking(true);
        piwik.trackPageView();
    </script>
    <noscript><p><img src="${piwikServer}?idsite=${piwikId}" style="border:0;" alt="" /></p></noscript>
     --%>
    
    <%-- postponed piwik load --%>
	<script defer src="//europa.eu/webtools/load.js" type="text/javascript"></script>
	<script type="application/json"> { "utility": "piwik", "siteID": 401, "sitePath": ["ec.europa.eu\/tools\/espd"] } </script>
</c:if>
