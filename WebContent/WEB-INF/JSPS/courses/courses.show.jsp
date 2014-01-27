<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${COURSESTITLE}</h1>
<c:forEach var="elem" items="${COURSELIST}">
	<h3>${elem.courseID} ${elem.courseName}</h3>
	<p><a href="${ABSPATH}/materials/${elem.courseID}">Course Materials</a></p>
	<p>${elem.courseDesc}</p>
	<hr />
</c:forEach>