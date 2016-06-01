<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<h2>InfoFilter</h2>
	<form action="crawl/start" method="post">
		<ul>
			<li>种子链接<input type="text" name="urlSeed" style="width: 400px;"
				value="https://www.douban.com/group/zhufang/discussion?start=0"></li>
			<li>最大结果数<input type="text" name="maxHint" value="10"></li>
			<li>最大抓取数<input type="text" name="maxCrawl" value="100"></li>
			<li>检索关键字<input type="text" name="keys"></li>
			<li><input type="submit" value="post"></li>
		</ul>
	</form>
</body>
</html>
