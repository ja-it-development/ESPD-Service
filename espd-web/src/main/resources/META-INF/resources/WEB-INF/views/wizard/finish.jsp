<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
<tiles:importAttribute name="agent"/>

<c:set var="ESOP_SESSION" value="${not empty sessionScope.ESOP_VISITORID}"/>

<form:form id="espdform" role="form" class="form-horizontal" method="post" commandName="espd" data-toggle="validator">
    <div class="panel-default">
        <tiles:insertDefinition name="progress">
            <tiles:putAttribute name="agent" value="${agent}"/>
            <tiles:putAttribute name="flow" value="${flow}"/>
            <tiles:putAttribute name="finish" value="true"/>
        </tiles:insertDefinition>

		<c:set var="finish_agent" value="${agent}" scope="request"/><%-- overrides agent for finish --%>
        <%@ include file="/WEB-INF/views/wizard/finishForm.jsp" %>

        <div class="panel panel-espd">
            <div class="panel-heading" data-toggle="collapse" data-target="#finish-statements-section">
                <h4 class="panel-title">
                    <c:choose>
                    <c:when test="${not ESOP_SESSION}">
                            ${span18n['createcafinish_export']}
                    </c:when>
                        <c:otherwise>
                            ${span18n['esop_createcafinish_export']}
                        </c:otherwise>
                    </c:choose>
                </h4>
            </div>
            <div id="finish-statements-section" class="collapse in">
                <div class="espd-panel-body panel-body">
                    <span data-i18n="createcafinish_export_content">
                        <c:choose>
                            <c:when test="${not ESOP_SESSION}">
                                <s:message code='createcafinish_export_content'/>
                            </c:when>
                            <c:when test="${finish_agent eq 'eo'}">
                                <s:message code="esop_createcafinish_export_content_seller"/>
                            </c:when>
                            <c:otherwise>
                                <s:message code="esop_createcafinish_export_content_buyer"/>
                            </c:otherwise>
                        </c:choose>
                    </span>
                </div>
            </div>
        </div>

    </div>

    <tiles:insertDefinition name="footerButtons">
        <tiles:putAttribute name="nextCode" value="export"/>
        <tiles:putAttribute name="prev" value="selection"/>
        <tiles:putAttribute name="next" value="overview"/>
        <tiles:putAttribute name="overview" value="${true}"/>
    </tiles:insertDefinition>

</form:form>