<%@ page language="java" import="java.util.*,entity.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'student.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
.selectTr {
	background-color: deepskyblue !important;
}
</style>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var id = 0;
		$("#stuTable tr").click(function() {
			$("#stuTable tr").removeClass("selectTr");
			$(this).addClass("selectTr");
			id = $(this).data("id");

		})

		$("#modify").click(function() {

			location.href = "student?type=showModify&id=" + id;

		})
		$("#delete").click(function() {

			location.href = "student?type=delete&id=" + id;

		})

	})
</script>
</head>

<body>
	<div style="width:600px;margin:20px auto">

		<table id="stuTable" class="table table-bordered table-striped table-hover">
			<tr>
				<th>姓名</th>
				<th>性別</th>
				<th>年龄</th>
				<th>部门</th>
			</tr>
			<c:forEach var="emp" items="${emps}">
				<tr data-id="${stu.id}">
					<td>${emp.name}</td>
					<td>${emp.gender}</td>
					<td>${emp.age}</td>
					<td>${emp.bj.name}</td>
				</tr>
			</c:forEach>
		</table>

		<div class="btn-group">
			<a name="btn" class="btn btn-danger" href="student?type=showAdd">新增</a>
			<a id="modify" class="btn btn-primary">修改</a> <a id="delete"
				class="btn btn-primary">删除</a>
		</div>
	</div>
	<br>
</body>
</html>
