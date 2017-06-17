<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/code_welcome.js"></script>
	<script type="text/javascript" src="js/islog.js"></script>
	<script type="text/javascript" src="http://zxd-1253592841.file.myqcloud.com/js/moment.js"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="js/jPages.min.js"></script>
	
	
	
	<link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/welcomestyle.css">
	<link rel="stylesheet" href="css/jPages.css">
	<link rel="stylesheet" href="css/animate.css">
	
	
	
	
	<title>${sessionScope.student.getName()} 的个人主页</title>
</head>
<body >
	<!-- 吸顶的导航栏 -->
	
		<nav class="navbar navbar-default navbar-fixed-top" style="min-height: 40px;background-color:#0996D6;">
					
			
		    <div id="logout" class="infmation" style="float:right;  margin-top: 3px; margin-right: 25%; width:120px;">
				<form method="post" action="logout">
					<button data-dismiss="modal" class="btn btn-warning" type="submit" id="tryreg"
					style="margin-left: 20px;">退出登录</button>
				</form>
			</div>

			<div style="margin-right: 0px; float:right;  margin-top: 3px;">
				
				<button data-dismiss="modal" class="btn btn-info" type="button" id="chgpassword">修改密码</button>
			</div>


			<div style="margin-right: 10px;  margin-top: 8px;  float: right;">
				<font style="font-family: 微软雅黑 ;" id="js-name">${sessionScope.student.getName()} </font>
				<font style="font-family: 微软雅黑 ; visibility: hidden;" id="js-username">${sessionScope.student.getUsername()} </font>
			</div>	

		</nav>
		
	<div id="bgp">
		<!-- 顶部的个人信息 -->
		<div id="userinfo">
			<div id="user_picture" >


				<div id="chgpic" style=" display: none;">
					<a href="javascript:void(0)" style="font-family: 微软雅黑 ;" id="achgpic">修改头像</a>
				</div>

				<!-- <div class="col-xs-3 " style="min-height: 124px; min-width: 124px;"> -->
				    <!-- <a href="#" class="thumbnail"> -->
				      <img src="user_picture/${sessionScope.student.getUsername()}.jpg"  onerror="this.src='user_picture/default.jpg' "
				style="height: 100%;width: 100%; border-radius: 10px;">
				    <!-- </a> -->
				<!-- </div> -->

				<!-- <img src="user_picture/${sessionScope.student.getUsername()}.jpg"  onerror="this.src='user_picture/default.jpg' "
				style="height: 100%;width: 100%; border-radius: 10px;"> -->

				
				

			</div>
			<div id="username">
				<font style="font-family: 微软雅黑 ; font-size: 40px;">${sessionScope.student.getName()} </font>
			</div>

			<div id="uploadpic" style="display: none;">

				<div class="panel panel-info">
				  <div class="panel-heading">修改头像</div>

				  <div class="panel-body">
				    	<form action="uploadpic" method="post" enctype="multipart/form-data" class="a-upload">
				 			<input type="hidden" name="username" value="${sessionScope.student.getUsername()}"/>
				 			<label class="fileLabel" for="uppic">选择图片</label>
						  	<input type="file" name="doc" id="uppic" style="display: none;" /> 
						  	<br> <br>
						 	<input type="submit"  class="btn btn-info" value="上传" style="width: 120px;" onclick="window.location.reload(true)">
						 	<button type="button" class="btn btn-default" style="width: 120px; margin-left: 30px;" id="cancel">取消</button>
						</form>
						
				  </div>
				</div>
				
			</div>


			<div id="chgpage"  style="display: none;">
				<div class="modal-dialog">
		        <div class="modal-content">
		          <div class="modal-header">
		            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true" id="reload1">×</span><span class="sr-only">Close</span></button>
		            <h4 class="modal-title">修改密码</h4>
		          </div>

		          <form method="post" action="LogServlet">
		          	<div class="modal-body">
		          		<p>请输入新密码：</p>
		          		<input type="password" name="passsword1" class="form-control" required="" id="cpassword1">
		          		<br>
		          		<p>请再次输入:</p>
		          		<input type="password" name="password2" class="form-control" required="" id="cpassword2">
		          	</div>

		          	<div class="modal-footer">
		          	<span id="tryagain" style="color: red"></span>	<span id="chgResult"></span>  
		            <button data-dismiss="modal" class="btn btn-primary" type="button" onclick="chg()" id="chgbtn">确认修改</button>
		            <!-- <button class="btn btn-default" type="button">提交</button> -->
		          </div>
		          </form>
		          
		        </div><!-- /.modal-content -->
		      </div><!-- /.modal-dialog -->
			</div>

		</div>




		<!-- 左侧导航栏 -->
		<div id="left-nav">
			<ul class="nav navbar-default nav-stacked " style="width: 85%">
				<li><a href="newwelcome.jsp" class="list-group-item moduleItemLeft active">全部动态</a></li>
				<li><a href="my_newwelcome.jsp">我的动态</a></li>
				<li><a href="logscore">班委打分</a></li>				
				<li><a href="#">VB.Net</a></li>
				<li><a href="#">Java</a></li>
				<li><a href="#">PHP</a></li>
			</ul>


		</div>




		<!-- 主页信息 -->
		<div id="main-info">
			<!-- 发布动态的组件 -->
			<div id="input-text">
				<form action="publishMessage" method="post">
					<textarea  class="form-control" style="min-height: 82px;" id="saysomething"  placeholder="说点什么吧"></textarea>
					<button type="button" class="btn" id="publishmessage" style="margin-left:500px; margin-top:3px;margin-right: 30px;width: 120px; position:absolute; z-index: 12;">发布</button>
				</form>
			</div>



			

				<br>
					<div class="holder"></div>
					<div id="allmessages">
					<!-- 用struts2的标签遍历message				 -->

						<div id="msgdingwei" style="display: none;"></div>

						<div class="panel panel-default" id="newmessage" style="display: none; margin-top:18px;">
						  <div class="panel-heading">${sessionScope.student.getName()} <font style="float: right; margin-right: 5px;">刚刚</font></div>
						  <div class="panel-body" id="shownewmessage">
						    面板内容
						  </div>
						</div>


							<s:iterator value="#application.messages" var="m">

								<div class="panel panel-default" id="msg_${id}">
								  <div class="panel-heading">${m.student.name} <font style="float: right; margin-right: 5px;">发表于：${m.createtime}</font>
									  <s:set name='username' value='#session.student.username'/>
									  <s:if test="#m.student.username==#username">
									  	<a href="javascript:void(0)" style="float: right;margin-right: 10px;" onclick="delmsg('${id}')">删除</a>
									  </s:if>
								  
								  </div>
		
								  <div class="panel-body">
								    	<div>${m.content}</div>
		
										<!-- 下面是发表评论的面板 -->
										<div id="reppage" style="float: right; margin-top: 10px;">
											
											<button class="btn btn-info" type="button" data-toggle="collapse" data-target="#rep_msg_${id}" aria-expanded="false" aria-controls="collapseExample" style="float: right;">
											  评论
											</button>
		
						
											 
											<div class="collapse" id="rep_msg_${id}" style="float: right; ">
												  <div id="reply-page">
													<form action="" method="post">
														<textarea  class="form-control" style="min-height: 82px;" id="reply_text_${id}"></textarea>
														<button type="button" class="btn"  onclick="publishreply('${id}')">发表</button>
													</form>
												</div>
											</div>
										</div>

										
										<s:if test="#m.replies==null || #m.replies.size()<1">
											<div style="text-align: center; margin-top: 32px;">
												<span type="text" class="text-muted" style="text-align: center;">--评论区--</span>
											</div>
											<div style="float: left; margin-top: 8px;" class="text-muted">暂无评论</div>
											
										</s:if>
										
										
										<s:else>
												
												
											<div style="text-align: center; margin-top: 32px;">
												<span type="text" style="text-align: center;">--评论区--</span>
											</div>
											
											
											<s:iterator value="#m.replies" var="r">
											
												<div id="replys_${r.id}" style="float: left; margin-top: 8px;">
													<div class="input-group">
											            <span class="input-group-addon">${r.ustudent.name}</span>
											            <span type="text" class="form-control">${r.content}</span>
											        </div>
												</div>
											
											
											</s:iterator>


											<div id="replydingwei_${id}" style="display: none;"></div>

											<div id="newreply" style="float: left; margin-top: 8px; display: none;">
													<div class="input-group">
											            <span class="input-group-addon" id="newreply_name"></span>
											            <span type="text" class="form-control" id="newreply_content"></span>
											        </div>
											</div>
										
										</s:else>





								  </div>
		
								</div>
							</s:iterator>
						<div class="holder"></div>
				</div>
			

			
				<div class="holder"></div>




			
			

			
		</div>

			





		<!-- 右侧信息栏 -->
		<div id="right-info">
			
			<div id="showmonth" style="width: 100%;height: 245px;">
				<img id="monthimg" src="http://zxd-1253592841.file.myqcloud.com/img/bonus_1.jpg" style="height: 100%;width: 100%">
			</div>

		</div>
	</div>

</body>
</html>



