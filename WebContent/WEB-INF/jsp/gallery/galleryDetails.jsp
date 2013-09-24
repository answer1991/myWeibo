<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="/META-INF/tld/fmt.tld"%>
<%@ taglib prefix="c" uri="/META-INF/tld/c.tld"%>

<fmt:setBundle
	basename="/jstl-properties/page-i18n/gallery/myGallery/page" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="title" /> - <fmt:message
		key="all.title" /></title>
<jsp:include page="../template/static_source.jsp"></jsp:include>
<jsp:include page="galleryStaticResource.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="headerNav.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="span3">${ user.email }</div>
			<div class="span6">
				<ul class="breadcrumb">
					<li><a href="#">${ gallery.user.email }</a> <span class="divider">/</span></li>
					<li><a href="../${ gallery.user.id }">${ gallery.user.email } 的相册</a> <span class="divider">/</span></li>
					<li class="active">${ gallery.name }</li>
				</ul>
				<div class="row-fluid">
					<ul class="thumbnails">
						<c:forEach items="${ gallery.photoes }" var="photo">
							<li class="span4"><a
								href="${ photo.photoUrl }"
								class="thumbnail" title="${ photo.name }"
								onclick="return hs.expand(this, config1 )"> <img
									data-src="holder.js/300x200"
									src="${ photo.photoUrl }"
									alt="">
							</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="span3"></div>
		</div>
	</div>
	<jsp:include page="../template/static_source_body.jsp"></jsp:include>
</body>
</html>