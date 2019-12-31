<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% String basePath=request.getScheme()+"://"+request.getServerName()+":"+
    request.getServerPort()+request.getContextPath()+"/";
    %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">添加学生列表</h3>
<form action="student/save.do" method="post" align="center" >
	姓名：<input type="text" name="name"><br>
	年龄：<input type="text" name="age"><br>
	<input type="submit" value="添加">
</form>
</body>
</html>