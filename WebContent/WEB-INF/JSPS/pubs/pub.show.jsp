<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="/WEB-INF/tlds/pubtool.tld" %>
<h1>${PUB_TITLE}</h1>
<ul class="pubs-contents">
<c:forEach var="elem" items="${PUBCONTENTS}">
	<li>
	<c:forEach var="nElem" items="${elem.nameList}">
		<a href="${ABSPATH}/members/each/${nElem.memberID}">${nElem.memberName}</a>, 
	</c:forEach>
	<p:pubprn var="pubstr" format="${elem.formatID}" desc="${elem.pubDesc}">
		${pubstr}
	</p:pubprn>
	</li>
</c:forEach>
</ul>