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
		$("#Btn").click(function(){
			$("#pid").html("<option>--请选择省份--</option>");
			$.post(
					"province/list.do",
					function(data){
						$(data.plist).each(function(){
							$("#pid").append("<option value='"+this.id+"'>"+this.name+"</option>");
						})
					},
					"json"
			
			);
			
		})
		
		$("#pid").change(function(){
			$("#cid").html("<option>--请选择城市--</option>");
			var pid=$("#pid").val();
			$.post(
				"city/list.do",
				{"pid":pid},
				function(data){
					//alert(data);
					$(data.clist).each(function(){
						$("#cid").append("<option value='"+this.id+"'>"+this.name+"</option>");
					})
				},
				"json"
			)
		})
	})
</script>
</head>
<body>
	<button id="Btn">显示省份</button>&nbsp;&nbsp;
	<select id="pid">
	<option>--请选择省份--</option>
	</select>
	&nbsp;&nbsp;
	<select id="cid">
	<option>--请选择城市--</option>
	</select>

</body>
</html>