<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>

<style type="text/css">
	td {
		text-align: center;
	}
	
	a {
		text-decoration: none;
	}
	.ghbs1{
		background-color:#f0f8ff;
	}
	.ghbs2{
		background-color:#faebd7;
	}
</style>
<script type="text/javascript">

	

</script>
<!-- <script type="text/javascript" src="js/jquery.min.js"></script> -->
<script type="text/javascript">
	$(function() {
		$("#addBtn").click(function(){
			window.location.href="jsp/student/add.jsp";
		})
		
		$("#editBtn").click(function(){
			$var= $("input[name='xz']:checked");
			
			if($var.length>1){
				alert("只能选择一条记录修改");
			}
			if($var.length==0){
				alert("请选择一条记录修改");	
						}
			if($var.length==1){
				var id=$var.val()
				//alert(id);
				window.location.href="student/edit.do?id="+id;
			}
		})
		
		$("#deleteBtn").click(function(){
			$xz= $("input[name='xz']:checked");
			
			if($xz.length>0){
				
				if(confirm("您确定要删除数据吗？")){
					//alert("666");
					path="student/deletes.do?";
					//servlet 路径不加/，不用绝对路径
					for(var i=0;i<$xz.length;i++){
						path+="id="+$xz[i].value;
						if(i<$xz.length-1){
							path+="&";
						}
						
					}
					//alert(path);
					window.location.href=path;
				}
				
				
			}
			if($xz.length==0){
				alert("请选择一条记录删除");	
						}
			
		})
		
		$("#qx").click(function () {
			//$("#qx")[0].checked
			//alert($("#qx")[0].checked);
			$xz= $("input[name='xz']");
			if($("#qx")[0].checked){
				
				for(var i=0;i<$xz.length;i++){
					$xz[i].checked=true;
				}
			}else{
				for(var i=0;i<$xz.length;i++){
					$xz[i].checked=false;
				}
			}
		})
		
		$("#tBody>tr:even").addClass("ghbs1");
		$("#tBody>tr:odd").addClass("ghbs2");
	})
	
	
</script>
</head>
<body>
	欢迎,${username}<br />
	<hr/>
	<h3 align="center">学生信息管理系统</h3>
	<table class="table table-hover" border="0" align="center"  style="width:70%">
		
		<tr >
			<td style="text-align: left" >
				<button class="btn btn-success" id="addBtn" >添加学生</button>
				<button class="btn btn-info" id="editBtn" >修改学生</button>
				<button class="btn btn-danger" id="deleteBtn" >删除学生</button>
			</td>	
		</tr>
	</table>
	<table class="table table-hover" border="1"  align="center" cellpadding="6" style="width:70%">
		<thead>
			<tr>
			<td>全选<input type="checkbox" id="qx"/></td>
			<td>序号</td>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody id="tBody">
			<c:if test="${empty list}">
			<tr>
				<td colspan="5">没有相关的信息</td>
				
			</tr>
		<!--  -->
		</c:if>
		
		<c:if test="${!empty list}">
			<c:forEach items="${list}" var="s" varStatus="vs" >
			
				<tr>
					<td><input type="checkbox" name="xz" value="${s.id}"/></td>
					<td>${vs.count}</td>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td><a href="student/edit.do?id=${s.id}">修改</a>||<a href="student/delete.do?id=${s.id}">刪除</a></td>
				</tr>
				
			</c:forEach>
		
		</c:if>
		</tbody>
		
		
		
		
		




	</table>
</body>
</html>