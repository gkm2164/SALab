<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Alumni ${YEAR}</h1>
<div id="alumni-year-nav">
	<ul>
	<c:forEach var="elem" items="${ALUMNIYEARS}">
		<li><a href="${ALUMNIPATH}/${elem.gradyear}">${elem.gradyear}</a></li>
	</c:forEach>
	</ul>
</div>
<c:forEach var="elem" items="${MEMBERLIST}">
<div class="name-card">
	<div class="name-card-personal">
		<div class="name-card-personal-info">
			<span class="name-card-name">${elem.memberName}</span>
			<span class="name-card-current-work">${elem.currentWork}</span>
			<span class="name-card-interest">${elem.areaName}</span>
			<br class="clearfix" />
		</div>
		<br class="clearfix" />
	</div>
	<div class="name-card-career">
		<h2>Publications</h2>
		<h3>International Conferences</h3>
		<ul>
			<li>Under construction</li>
		</ul>
		<h3>International Journals</h3>
		<ul>
			<li>Under construction</li>
		</ul>
	</div>
</div>
</c:forEach>