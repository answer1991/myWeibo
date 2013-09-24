
<%
	String path = request.getContextPath();
	String scheme = request.getScheme();
	int port = request.getServerPort();
	String basePath = "";
	if(80 == port) {
		basePath = scheme + "://"
				+ request.getHeader("Host")
				+ path + "/";
	}
	else {
		basePath = scheme + "://"
				+ request.getHeader("Host") + ":" + request.getServerPort()
				+ path + "/";
	}
	
%>
<!-- 
<base href="<%=basePath %>">
-->