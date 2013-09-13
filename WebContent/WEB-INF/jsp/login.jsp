<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="/META-INF/tld/fmt.tld"%>
<%@ taglib prefix="c" uri="/META-INF/tld/c.tld"%>

<fmt:setBundle basename="/jstl-properties/page-i18n/login/page" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="title" /> - <fmt:message key="all.title" /></title>
<jsp:include page="template/static_source.jsp"></jsp:include>
<jsp:include page="template/basePath.jsp"></jsp:include>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="/"><fmt:message key="all.nav.brand" /></a>
				<ul class="nav">
					<li class="active"><a href="/"><fmt:message
								key="all.nav.weibo" /></a></li>
					<li><a href="/projblog.html"><fmt:message
								key="all.nav.blog" /></a></li>
					<li><a href="/gallery.html"><fmt:message
								key="all.nav.gallery" /></a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="span3"></div>
			<div class="span6">
				<div class="well">
					<p class="text-center text-error">
						<c:if test="${ userNotFoundError != null}">
							<fmt:bundle basename="/jstl-properties/error-i18n/error">
								<fmt:message key="${ userNotFoundError }"></fmt:message>
							</fmt:bundle>
						</c:if>
					</p>
					<form class="form-horizontal" action="./doLogin.html" method="post">
						<div class="control-group">
							<label class="control-label" for="inputEmail"> <fmt:message
									key="input.email" />
							</label>
							<div class="controls">
								<input type="text" id="inputEmail"
									placeholder="<fmt:message key="input.email.placeholder" />"
									name="email"
									value="<c:if test="${ emailPlaceholder != null}">${emailPlaceholder}</c:if>">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputPassword"> <fmt:message
									key="input.password" />
							</label>
							<div class="controls">
								<input type="password" id="inputPassword"
									placeholder="<fmt:message key="input.password.placeholder" />"
									name="password">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<label class="checkbox"> <input type="checkbox">
								<fmt:message key="checkbox.remember" />
								</label>
								<button type="submit" class="btn btn-primary">
									<fmt:message key="button.submit" />
								</button>
								<a class="btn btn-warning" href="./register.html"><fmt:message
										key="button.register" /></a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="./js/bootstrap.min.js"></script>
</body>
</html>