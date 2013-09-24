<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="/META-INF/tld/fmt.tld"%>
<%@ taglib prefix="c" uri="/META-INF/tld/c.tld"%>

<fmt:setBundle basename="/jstl-properties/page-i18n/gallery/createGallery/page" />

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="title" /> - <fmt:message key="all.title" /></title>
	<jsp:include page="../template/static_source.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="headerNav.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="span3">
				${ user.email }
			</div>
			<div class="span6">
				<div class="well">
					<p class="text-center text-error">
						<c:if test="${ userNotFoundError != null}">
							<fmt:bundle basename="/jstl-properties/error-i18n/error">
								<fmt:message key="${ userNotFoundError }"></fmt:message>
							</fmt:bundle>
						</c:if>
					</p>
					<form class="form-horizontal" action="./doCreateGallery.html" method="post">
						<div class="control-group">
							<label class="control-label" for="galleryName"> <fmt:message
									key="input.galleryName" />
							</label>
							<div class="controls">
								<input type="text" id="galleryName"
									placeholder="<fmt:message key="input.galleryName.placeholder" />"
									name="galleryName"
									value="<c:if test="${ emailPlaceholder != null}">${emailPlaceholder}</c:if>">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="galleryDescription"> <fmt:message
									key="input.galleryDescription" />
							</label>
							<div class="controls">
								<textarea rows="3" id="galleryDescription"
									placeholder="<fmt:message key="input.galleryDescription.placeholder" />"
									name="galleryDescription"></textarea>
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<button type="submit" class="btn btn-primary">
									<fmt:message key="button.submit" />
								</button>
								<a class="btn btn-warning" href="./register.html"><fmt:message
										key="button.cancel" /></a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="span3">
				
			</div>
		</div>
	</div>
	<jsp:include page="../template/static_source_body.jsp"></jsp:include>
</body>
</html>