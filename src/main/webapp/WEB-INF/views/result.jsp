<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
<style type="text/css">
.list{margin:5px;}
.list a{color:#666; text-decoration:none;}
.list a:hover{color:#F60;}
</style>
</head>
<body>
	<ul>
		<c:forEach items="${urlList}" var="url">
			<li class="list"><a href="${url.href}">${url.title}</a></li>
		</c:forEach>
	</ul>
</body>
</html>