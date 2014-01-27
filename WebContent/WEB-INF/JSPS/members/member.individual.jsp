<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${MEMBERITEM.memberName}</h1>
<span>Email</span> <span><a href='mailto:${MEMBERITEM.email}'>${MEMBERITEM.email}</a></span><br />
<span>Private Web</span> <span>
	<c:choose>
		<c:when test="${MEMBERITEM.privateWeb == null}">
	None
		</c:when>
		<c:when test="${MEMBERITEM.privateWeb != null}">
	<a href='${MEMBERITEM.privateWeb}'>${MEMBERITEM.privateWeb}</a>
		</c:when>
	</c:choose>
</span>