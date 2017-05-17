<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/welcomecode.js"></script>
<script type="text/javascript" src="js/islog.js"></script>

<title>${sessionScope.student.getName()} 的个人主页</title>
</head>
<body>
	<h1 id="welcome" class="infmation">Welcome!</h1>
	<div style="font-family:微软雅黑" id="userinformation" class="infmation">
		<h2>个人信息</h2>
			<div style="margin-left: 200px;margin-top: -32px;">
				<button data-dismiss="modal" class="btn btn-default" type="button" id="chgpassword">修改密码</button>
			</div>

		用户名：${sessionScope.student.getUsername()}
		<br>
		密码：${sessionScope.student.getPassword()}
		<br>
		昵称: ${sessionScope.student.getName()}
		<br>
		性别 : ${sessionScope.student.getSex()}
	</div>
	<br><br>	
	


	<div id="chgpage" >
		<div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true" id="reload1">×</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">修改密码</h4>
          </div>

          <form method="post" action="LogServlet">
          	<div class="modal-body">
          		<p>请输入新密码：</p>
          		<input type="password" name="passsword1" class="form-control" required="true" id="cpassword1">
          		<br>
          		<p>请再次输入:</p>
          		<input type="password" name="password2" class="form-control" required="true" id="cpassword2">
          	</div>

          	<div class="modal-footer">
          	<span id="tryagain" style="color: red"></span>	<span id="chgResult"></span>  
            <input data-dismiss="modal" class="btn btn-primary" type="submit" onclick="chg()" id="chgbtn" value="确认修改"></input>
            <!-- <button class="btn btn-default" type="button">提交</button> -->
          </div>
          </form>
          
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
	</div>






	
	<div style="margin-left:200px;font-family:微软雅黑; font-size:60px; " id="score">
		<a href="logscore">班委打分</a>
	</div>
	<br><br>

	<div id="logout" class="infmation">
		<form method="post" action="logout">
			<button data-dismiss="modal" class="btn btn-default" type="submit" id="tryreg">退出登录</button>
		</form>
	</div>
	
	
	
	
	
</body>
</html>