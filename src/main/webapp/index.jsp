<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InfoFilter</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
	<form action="crawl/start" method="post">
		<ul>
			<li class="red">种子链接<input type="text" name="urlSeed" style="width: 400px;"
				value="https://www.douban.com/group/zufan/discussion?start=0"></li>
			<li>最大结果数<input type="text" name="maxHint" value="10"></li>
			<li>最大抓取数<input type="text" name="maxCrawl" value="100"></li>
			<li>检索关键字<input type="text" name="keys" style="width: 600px;"></li>
			<li>过滤关键字<input type="text" name="filterKeys" style="width: 600px;"></li>
			<li><input type="submit" value="start"></li>
		</ul>
	</form>
</body>
</html>
