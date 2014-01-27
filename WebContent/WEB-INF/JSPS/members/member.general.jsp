<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="/WEB-INF/tlds/pubtool.tld" %>

<h1>${STATUSNAME}</h1>
<c:forEach var="elem" items="${MEMBERLIST}">
<div class="name-card">
	<div class="name-card-personal">
		<div class="name-card-personal-info">
			<span class="name-card-name">
				${elem.memberName}
	<c:choose>
		<c:when test="${elem.privateWeb == null}">
			<a href="${ABSPATH}/members/each/${elem.memberID}" target="_blank">detail</a>
		</c:when>
		<c:when test="${elem.privateWeb != null}">
			<a href="${elem.privateWeb}" target="_blank">detail</a>
		</c:when>
	</c:choose>
			</span>
			<span class="name-card-email"><a href="mailto:${elem.email}">${elem.email}</a></span>
			<span class="name-card-interest">${elem.areaName}</span>
			<br class="clearfix" />
		</div>
		<br class="clearfix" />
	</div>
	<div class="name-card-career">
		<h2>Publications</h2>
		<ul>
	<c:forEach var="pubElem" items="${elem.pubItem}">
			<li>
		<c:forEach var="nElem" items="${pubElem.nameList}">
				<a href="${ABSPATH}/members/each/${nElem.memberID}">${nElem.memberName}</a>, 
		</c:forEach>
				<p:pubprn var="pubstr" format="${pubElem.formatID}" desc="${pubElem.pubDesc}">
					${pubstr}
				</p:pubprn>
			</li>
	</c:forEach>
		</ul>
	</div>
</div>
</c:forEach>