
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

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#addBtn").click(function(){
			window.location.href="jsp/student/add.jsp";
		})
	})
</script>

</head>
<body>
<h3 align="center">修改学生列表</h3>
<form action="student/update.do" method="post" align="center" >
	<input type="text" name="id" hidden value="${student.id}" ><br>
	编辑姓名：<input type="text" name="name" value="${student.name}"><br>
	编辑年龄：<input type="text" name="age" value="${student.age}"><br><br>
	<input type="submit" value="修改">
</form>
</body>
</html>