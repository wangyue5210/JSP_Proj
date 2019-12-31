<%@page import="domain.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%
	List<Student> list = (List<Student>) request.getAttribute("list");
	String username = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	text-align: center;
}

a {
	text-decoration: none;
}
</style>
<script type="text/javascript">

	function toAdd() {
		window.location.href="jsp/student/add.jsp";
	}

</script>

</head>
<body>
	欢迎,<%=username%><br />
	<hr/>
	<h3 align="center">学生信息管理系统</h3>
	<table border="1" width="70%" align="center" cellpadding="6">
		<tr>
		<td colspan="5">
			<button onclick="toAdd()">添加学生</button>
		</td>	
		</tr>
		<tr>
			<td>序号</td>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>


		<%
			for (int i = 0; i < list.size(); i++) {
				Student s = list.get(i);
		%>
		<tr>
			<td><%=i+1%></td>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getAge()%></td>
			<td><a href="student/edit.do?id=<%=s.getId()%>">修改</a>||<a href="student/delete.do?id=<%=s.getId()%>">刪除</a></td>
		</tr>
		<%
			}
		%>


	</table>
</body>
</html>