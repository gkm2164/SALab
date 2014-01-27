<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
<c:forEach var="elem" items="${LNAVS}">
	<c:if test="${elem.exposeOnLocalNav == true}">
	<li id="${elem.servletName}"><a href="${elem.servletPath}">${elem.name}</a>
		<c:if test="${elem.childSize() > 0 and elem.localExposeChild == true}">
			<c:set var="LNAVS" value="${elem.childNodes}" scope="request" />
			<jsp:include page="localnavs.jsp" />
		</c:if>
	</li>
	</c:if>
</c:forEach>
</ul>