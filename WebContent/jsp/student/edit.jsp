<%@page import="domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% String basePath=request.getScheme()+"://"+request.getServerName()+":"+
    request.getServerPort()+request.getContextPath()+"/";
    %>
    
<%
	Student s=(Student)request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">修改学生列表</h3>
<form action="student/update.do" method="post" align="center" >
	<input type="text" name="id" hidden value="<%=s.getId()%>" ><br>
	编辑姓名：<input type="text" name="name" value="<%=s.getName()%>"><br>
	编辑年龄：<input type="text" name="age" value="<%=s.getAge()%>"><br><br>
	<input type="submit" value="修改">
</form>
</body>
</html>