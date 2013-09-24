<%@ taglib prefix="fmt" uri="/META-INF/tld/fmt.tld"%>
<%@ taglib prefix="c" uri="/META-INF/tld/c.tld"%>

<fmt:setBundle basename="/jstl-properties/page-i18n/login/page" />
<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="/"><fmt:message key="all.nav.brand" /></a>
				<ul class="nav">
					
					<li><a href="/"><fmt:message
								key="all.nav.weibo" /></a></li>
					<li><a href="/projblog.html"><fmt:message
								key="all.nav.blog" /></a></li>
					<li class="active"><a href="gallery"><fmt:message
								key="all.nav.gallery" /></a></li>
				</ul>
			</div>
		</div>
	</div>