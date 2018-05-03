<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>demo_of_json</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<div id="div_json">
		<h5>录入数据</h5>
		<br />
		<form action="#" method="post">
			<label for="name">姓名 :</label> <input type="text" name="name" /> <label
				for="age">年龄 :</label> <input type="text" name="age" /> <label
				for="position">职务 :</label> <input type="text" name="position" /> <input
				type="button" class="btn" value="提交结果">
		</form>
		<br />
		<h5>显示结果</h5>
		<br />
		<ul>
			<li>姓名 : <span id="s_name">暂无数据</span></li>
			<li>年龄 : <span id="s_age">暂无数据</span></li>
			<li>职务 : <span id="s_position">暂无数据</span></li>

		</ul>
	</div>
	<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		function btn() {
			var $btn = $("input.btn");
			$btn.bind("click", function() {
	
				$.ajax({
					type : "post",
					url : "excuteAjaxJsonAction",
					data : {
						name : $("input[name=name]").val(),
						age : $("input[name=age]").val(),
						position : $("input[name=position]").val()
					},
					dataType : "json",
					success : function(data) {
						var d = eval("(" + data + ")");
						//得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
						$("#s_name").text("" + d.name + "");
						$("#s_age").text("" + d.age + "");
						$("#s_position").text("" + d.position + "");
					},
					error : function() {
						alert("系统异常，请稍后重试！");
					} //这里不要加","
				}); //ajax
			}); //bind
		}
	
		$(document).ready(function() {
			btn();
		});
	</script>
</body>
</html>