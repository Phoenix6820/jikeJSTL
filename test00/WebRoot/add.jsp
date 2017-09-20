<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	

  </head>
  
  <body>
      

				<div style="width:600px;margin:10px 150px">


					<form id="addStudent" class="form-horizontal"
						action="student" method="post">
						<input type="hidden" name="type"  value="add"/>
						<div class="form-group">
							<label class="col-sm-2 control-label"> 姓名： </label>
							<div class="col-sm-5">
								<input type="text" name="name" class="form-control"
									placeholder="请输入名称">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"> 性别： </label>
							<div class="col-sm-5">
								<input type="radio" name="sex" checked value="男">男 <input
									type="radio" name="sex" value="女">女

							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"> 年龄： </label>
							<div class="col-sm-5">
								<input type="text" name="age" class="form-control"
									placeholder="请输入年龄">
							</div>
						</div>
		


						<div class="form-group col-sm-7" style="text-align: center;">
							<input id="tijiao" type="submit" class="btn btn-primary"
								value="提交" /> <input type="reset" class="btn btn-primary" />

						</div>

					</form>
				</div>
	


  </body>
</html>
