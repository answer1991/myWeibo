<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录 - myWeibo</title>
<jsp:include page="template/static_source.jsp"></jsp:include>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="/">myWeibo</a>
				<ul class="nav">
					<li class="active"><a href="/">微博</a></li>
					<li><a href="/projblog.html">项目</a></li>
					<li><a href="/gallery.html">相册</a></li>
					<li><a href="/resume/resume.html" target="_blank">简历</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="span3"></div>
			<div class="span6">
				<div class="well">
					<p class="text-center text-error">${ errorInfo }</p>
					<form class="form-horizontal" action="./doLogin.html" method="post">
						<div class="control-group">
							<label class="control-label" for="inputEmail">登录邮箱</label>
							<div class="controls">
								<input type="text" id="inputEmail" placeholder="Email"
									name="email">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputPassword">登录密码</label>
							<div class="controls">
								<input type="password" id="inputPassword" placeholder="Password"
									name="password">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<label class="checkbox"> <input type="checkbox">记住我
								</label>
								<button type="submit" class="btn btn-primary">登录</button>
								<a class="btn btn-warning" href="./register.html">注册</a>
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