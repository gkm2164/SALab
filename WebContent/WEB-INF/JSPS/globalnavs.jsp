<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
	<c:forEach var="elem" items="${NAVS}">
		<c:if test="${elem.exposeOnGlobalNav == true}">
	<li id="${elem.servletName}"><a href="${elem.servletPath}">${elem.name}</a>
		<c:if test="${elem.childSize() > 0 and elem.globalExposeChild == true}">
			<c:set var="NAVS" value="${elem.childNodes}" scope="request" />
			<jsp:include page="globalnavs.jsp" />
		</c:if>
	</li>
		</c:if>
	</c:forEach>
</ul>

