<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="/META-INF/tld/fmt.tld"%>
<%@ taglib prefix="c" uri="/META-INF/tld/c.tld"%>

<fmt:setBundle
	basename="/jstl-properties/page-i18n/gallery/uploadPhoto/page" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="title" /> - <fmt:message
		key="all.title" /></title>
<jsp:include page="../template/static_source.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="headerNav.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="span3">${ user.email }</div>
			<div class="span6">
				<div class="well">
					<p class="text-center text-error">
						<c:if test="${ userNotFoundError != null}">
							<fmt:bundle basename="/jstl-properties/error-i18n/error">
								<fmt:message key="${ userNotFoundError }"></fmt:message>
							</fmt:bundle>
						</c:if>
					</p>
					<form class="form-horizontal" action="./doUploadPhoto.html" enctype="multipart/form-data"
						method="post">
						<div class="control-group">
							<label class="control-label" for="photoName"> <fmt:message
									key="input.photoName" />
							</label>
							<div class="controls">
								<input type="text" id="photoName"
									placeholder="<fmt:message key="input.photoName.placeholder" />"
									name="photoName"
									value="<c:if test="${ emailPlaceholder != null}">${emailPlaceholder}</c:if>">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="photoDescription"> <fmt:message
									key="input.photoDescription" />
							</label>
							<div class="controls">
								<textarea rows="3" id="photoDescription"
									placeholder="<fmt:message key="input.photoDescription.placeholder" />"
									name="photoDescription"></textarea>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="gallerySelect"> <fmt:message
									key="input.gallerySelect" />
							</label>
							<div class="controls">
								<select id="gallerySelect" name="gallerySelect">
									<c:forEach items="${ user.galleries }" var="gallery">
										<option value="${ gallery.id }">${ gallery.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="photoFile"> <fmt:message
									key="input.photoFile" />
							</label>
							<div class="controls">
								<input type="file" id="photoFile"
									name="photoFile">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<button type="submit" class="btn btn-primary">
									<fmt:message key="button.submit" />
								</button>
								<button type="reset" class="btn btn-warning"><fmt:message
										key="button.cancel" /></button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="span3"></div>
		</div>
	</div>
	<jsp:include page="../template/static_source_body.jsp"></jsp:include>
</body>
</html>