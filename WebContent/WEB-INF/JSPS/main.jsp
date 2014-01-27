<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Cache-Control" content="no-cache" />
	<title>${PDESC.title} - Software Architecture Laboratory</title>
	<link rel="stylesheet" href="${ABSPATH}/css/layout-properties.css" />
	<link rel="stylesheet" href="${ABSPATH}/css/background-properties.css" />
	<link rel="stylesheet" href="${ABSPATH}/css/border-line-properties.css" />
	<link rel="stylesheet" href="${ABSPATH}/css/font-properties.css" />
	<link rel="stylesheet" href="${ABSPATH}/css/style.css" />
	<link rel="stylesheet" href="${ABSPATH}/css/bug-handler.css" />
<c:forEach var="elem" items="${PDESC.pageCSS}">
	<link rel="stylesheet" href="${ABSPATH}/css/${elem}" />
</c:forEach>
	
	<script src="${ABSPATH}/js/jquery.js"></script>
	<script src="${ABSPATH}/js/salab.definitions.js"></script>
	<script src="${ABSPATH}/js/salab.js"></script>
	
<c:forEach var="elem" items="${PDESC.pageJS}">
	<script src="${ABSPATH}/js/${elem}"></script>
</c:forEach>
	<body>
		<div id="container">
			<header>
				<div id="banner">
					<div id="salab-logo-box" class="logo">
						<a id="salab-logo-link" href="${ABSPATH}">
							<img src="${ABSPATH}/img/SALAB_logo.png" alt="SALab logo" id="salab-logo" />
						</a>
					</div>
					<div id="salab-title">
						<h1>Software Architecture Laboratory</h1>
					</div>
					<div id="kaist-logo-box" class="logo">
						<a id="kaist-logo-link" href="http://www.kaist.ac.kr/" target = "_blank">
							<img src="${ABSPATH}/img/KAIST_logo.gif" alt="KAIST Logo" id="kaist-logo" />
						</a>
					</div>
					<br class="clearfix"/>
				</div>
				<nav id="nav-global">
					<jsp:include page="./globalnavs.jsp" />
				</nav>
			</header>

			<section class="${LNAVS == null ? 'no-local-nav':'' }">
<c:if test="${LNAVS != null}">
				<aside>
					<nav>
						<div id="nav-local">
							<jsp:include page="localnavs.jsp" />
						</div><!-- Home일경우 제외하고 나머지 모두 -->
					</nav>
					<br class="clearfix" />
				</aside>
</c:if>
				<article>
					<div id="page">
						<jsp:include page="${PDESC.pageFileName}" />
	     				<br class="clearfix" />
					</div>
					<br class="clearfix" />
				</article>
				<br class="clearfix" />
			</section>
			<footer>
				<div id="nav-history">
				</div>
				<div id="copyright">
					<p>Copyright 2013 SALab | Administrator <a href="mailto:imarch@kaist.ac.kr">imarch@kaist.ac.kr</a></p>
				</div>
				<div id="page-info">
				</div>
			</footer>
		</div>
	</body>
</html>