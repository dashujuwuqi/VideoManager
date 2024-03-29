<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- saved from url=(0084)http://localhost:8080/Voids/user/VideoGo.do?id=218&subjectName=WEB%E5%89%8D%E7%AB%AF -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--<base href="http://localhost:8080/Voids/">-->
<base href=".">

<meta name="viewport"
	content="initial-scale=1, maximum-scale=1, user-scalable=no">

<!--<base href="http://localhost:8080/Voids/">-->
<base href=".">
<meta name="renderer" content="webkit">
<meta name="keywords"
	content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description"
	content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">

<link rel="stylesheet" href="/VideoSSM/static/z/base.css">
<link rel="stylesheet" href="/VideoSSM/static/z/css.css">
<link rel="icon" href="http://localhost:8080/Voids/static/z/favicon.png"
	type="image/png">
<!--  <link href="/VideoSSM/static/z/video-js.css" rel="stylesheet" type="text/css"> -->
<title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100" style="padding-top: 0px;">




	<header>
		<div class="container">
			<span>欢迎来到IT培训的黄埔军校——智游教育！</span>


			<c:if test="${empty user.accounts }">
				<div id="userBlock" style="float: right">
					<a id="loginLink"><img src="/VideoSSM/static/z/we.png"
						draggable="false">登录</a> <a id="regLink"><img
						src="/VideoSSM/static/z/we.png" draggable="false">注册</a>
				</div>
			</c:if>

			<c:if test="${not empty user.accounts  }">
				<div id="userAccount" style="float: right">
					<a href="/VideoSSM/loginOut.do">退出</a> <a
						href="/VideoSSM/foreground/PersonalCenter.jsp">
						${user.accounts}</a>
				</div>
			</c:if>

			<a onclick="JavaScript:addFavorite2()"><img
				src="/VideoSSM/static/z/sc.png" draggable="false">加入收藏</a> <a
				id="adminLoginLink"> <img src="/VideoSSM/static/z/we.png"
				draggable="false">后台管理
			</a> <a class="color_e4"><img src="/VideoSSM/static/z/phone.png"
				draggable="false"> 0371-88888598 4006-371-555</a>

		</div>
	</header>




	<div>
	
		<!--面包屑导航-->
		
		<div class="container mian-nav">公开课 / ${result.data.videoPlay.course.subject.subjectName }</div>
	
		
		<input id="videoId" value="${result.data.videoPlay.videoId }" type="hidden">
		
		<div id="content">
				<div class="intro">
					<div class="container">
						<div class="v-intro">
							<div class="left">
								<c:if test="${user != null }">
								<video id="videoPlayer" src="${result.data.videoPlay.videoUrl} "
									class="video-js vjs-default-skin" controls="controls"
									poster="${result.data.videoPlay.imageUrl }" data-setup="{}" height="280" width="627">
								</video>
								</c:if>
								<c:if test="${empty user}">
								<video id="videoPlayer" src=""
									class="video-js vjs-default-skin" controls="controls"
									poster="${result.data.videoPlay.imageUrl }" data-setup="{}" height="280" width="627">
								</video>
								</c:if>
							</div>

							<div class="right">
								<p class="right-title">${result.data.videoPlay.title}</p>
								<div class="avatar">
									<span style="background-image: url(${result.data.videoPlay.speaker.picUrl})"></span>
									<p>
										<b>${result.data.videoPlay.speaker.speakerJob }：${result.data.videoPlay.speaker.speakerName }</b><br>
										<i>${result.data.videoPlay.speaker.speakerDesc}</i>
									</p>
								</div>
								<p class="video-intro">
									<span>本节内容：</span>${result.data.videoPlay.detail}
								</p>
							</div>
						</div>

						<div class="kcjs">
							<p class="title">课程介绍</p>
							<p class="content">${result.data.videoPlay.course.courseDesc }</p>
						</div>

					</div>
				</div>
				</div>
			
			<!--目录-->
			<div class="catalog">
				<div class="container">
					<p class="title">目录</p>

                  <c:forEach items="${result.data.list}" var="j"> 
					<c:forEach items="${j.videos }" var="i">
					<div class="chapter">
						<p class="biaoti">
							<a
								href="/VideoSSM/videoPlay.do?videoId=${i.videoId}&subjectId=${j.subjectId}">${i.title}</a>
						</p>
						<p class="lecturer"><a href="/VideoSSM/videoPlay.do?videoId=${i.videoId}&subjectId=${j.subjectId}">${i.detail }</a></p>
						<p class="lecturer">${i.speaker.speakerJob}：${i.speaker.speakerName}</p>
						<div class="v-info">
							<span class="count"><img src="/VideoSSM/static/z/count.png"
								alt="">${i.playNum}</span> <span class="duration"><img
								src="/VideoSSM/static/z/player.png" alt="">${i.time}</span>
						</div>
					</div>
                  </c:forEach>
					
					</c:forEach>
					
					
					

				
			</div>
		</div>



	


	<!--页脚-->
	<footer>
		<ul>
			<li><img src="./视频播放_files/footer_logo.png" alt=""
				draggable="false"></li>
			<li class="mt25">
				<h3>各校区地址</h3>
				<ul>
					<li>总部地址<br>中国-郑州经济技术开发区河南省通信产业园六层
					</li>
					<li>郑州校区一<br>中国-郑州经济技术开发区第一大街与经北一路
					</li>
					<li>郑州校区二<br>中国-郑州经济技术开发区第四大街经开人才市场七楼
					</li>
					<li>郑州校区三<br>中国-郑州经济技术开发区第八大街河南省留学生创业园九层、十层
					</li>
					<li>西安分校<br>中国-西安莲湖区 联系人：梁老师 13201570801
					</li>
				</ul>
			</li>
			<li class="mt25">
				<h3>联系我们</h3>
				<ul id="foo_icon">
					<li>中国-郑州经济技术开发区经北三路河南通信产业园六层</li>
					<li>e-mail:zy@zhiyou100.com</li>
					<li>电话:4006-371-555 0371-88888598</li>
					<li class="erwei"><br>
						<div>
							<img class="weixin" src="./视频播放_files/a.png" alt=""
								draggable="false"> <img class="weibo"
								src="./视频播放_files/a_002.png" alt="" draggable="false">
						</div></li>
				</ul>
			</li>
		</ul>
		<div class="record">智游教育 © 豫ICP备17000832号-1 河南智游臻龙教育科技有限公司</div>
	</footer>

	<!--找回密码-->
	<div class="mask hidden" id="findPassword">
		<div class="mask_content">
			<div class="mask_content_header">
				<img src="/VideoSSM/static/z/logo.png" alt="" class="ma">
			</div>
			<div class="mask_content_body">
				<form id="findForm" action="/VideoSSM/findPassword.do">
					<h3>找回密码</h3>
					<input id="FindEmail" placeholder="请输入邮箱" name="email2" type="email">
					<span id="emailMsg2"></span>
					
					<input  type="text" placeholder="请输入邮箱内的验证码" id="codeNew"> 
					<input type="hidden" id="CodeNowNew">
					<div id="codeMsgNew"></div>
					<button type="button" id="codeBtn1" >发送验证码</button>
					
					<input id="NewloginPassword" placeholder="请输入新的密码" name="password2" type="password">
					
					<input id="findSubBtn" value="提交" type="submit">
				</form>
			</div>
			<div class="mask_content_footer">
				<span id="find_close">关 闭</span>
			</div>
		</div>
	</div>
	<!-- ************************************************************************************* -->

	<!-- ************************************************************************************* -->

	<!--用户登录-->
	<div class="mask hidden" id="login">
		<div class="mask_content">
			<div class="mask_content_header">
				<img src="/VideoSSM/static/z/logo.png" alt="" class="ma">
			</div>
			<div class="mask_content_body">
				<form id="loginForm" action="">
					<h3>快速登录</h3>
					<input id="loginEmail" placeholder="请输入邮箱" name="email"
						type="email"><span
						id="emailMsg1"></span> <input id="loginPassword"
						placeholder="请输入密码" name="password" type="password">
					<div id="forget">
						<a
							href="javascript:void(0)"  id="forgetPass">忘记密码？</a>
					</div>
					<input onclick="return commitLogin()" value="登　录" type="submit">
				</form>
			</div>
			<div class="mask_content_footer">
				<span id="login_close">关 闭</span>
			</div>
		</div>
	</div>
	<!-- ************************************************************************************* -->
	<!-- 管理员登录 -->
	<div class="mask hidden" id="adminLogin">
		<div class="mask_content">
			<div class="mask_content_header">
				<img src="/VideoSSM/static/z/logo.png" alt="" class="ma">
			</div>
			<div class="mask_content_body">
				<form id="AdminLoginForm" action="/VideoSSM/adminLogin.do"
					method="post">
					<h3>管理员登录</h3>
					<input id="loginAccounts" placeholder="请输入管理员账户" name="accounts"
						type="text"
						style="width: 100%; margin: 15px 0; padding: 0 10px 0 50px; border: 1px solid #bac0ce; background-image: url(/VideoSSM/static/z/user.png); background-repeat: no-repeat; background-position: 8px center;">

					<input id="loginAccountsPassword" placeholder="请输入密码"
						name="accountsPassword" type="password">
					<div id="msg">&nbsp;</div>
					<input id="adminSubBtn" value="登　录" type="submit">
				</form>
			</div>
			<div class="mask_content_footer">
				<span id="adminLogin_close">关 闭</span>
			</div>
		</div>
	</div>
	<c:if test="${msg!=null}">
		<script type="text/javascript">
			alert('${msg}');
		</script>
	</c:if>
	<!-- ************************************************************************************* -->
	<!-- 用户注册 -->
	<div class="mask hidden" id="reg">
		<div class="mask_content">
			<div class="mask_content_header">
				<img src="/VideoSSM/static/z/logo.png" alt="" class="ma">
			</div>
			<div class="mask_content_body">
				<form id="regForm"
					action="">
					<h3>新用户注册</h3>
					<input id="regEmail" placeholder="请输入邮箱" name="email" type="email">
					<span id="emailMsg"></span>
					<input id="regPsw" placeholder="请输入密码" name="password" type="password"> 
					<input id="regPswAgain" placeholder="请再次输入密码" name="psw_again" type="password">
					<span id="passMsg"></span>
					  <input  type="text" placeholder="请输入邮箱内的验证码"
								id="code"> <input type="hidden" id="CodeNow">
							<div id="codeMsg"></div>
					  <button type="button" id="codeBtn" >发送验证码</button>
					
					<div id="yzm" class="form-inline">
						<input name="yzm" style="width: 45%; display: inline-block;"
							type="text">
						<div id="v_container"
							style="width: 45%; height: 40px; float: right;">
							<canvas id="verifyCanvas" width="100" height="38"
								style="cursor: pointer;">您的浏览器版本不支持canvas</canvas>
							<canvas id="verifyCanvas" width="100" height="38"
								style="cursor: pointer;">您的浏览器版本不支持canvas</canvas>
						</div>
					</div>
					<input id="userReg" onclick="return commitRegForm();" value="注　册" type="submit">
				</form>
			</div>
			<div class="mask_content_footer">
				<span id="reg_close">关 闭</span>
			</div>
		</div>
	</div>



	<script src="/VideoSSM/static/z/jquery-1.js"></script>
	<script src="/VideoSSM/static/z/gVerify.js"></script>
	<script src="/VideoSSM/static/z/index.js"></script>

	<script type="text/javascript" src="/VideoSSM/js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#loginLink").click(function() {
				$("#login").toggle();
			});
		});
		$(document).ready(function() {
			$("#adminLoginLink").click(function() {
				$("#adminLogin").toggle();
			});
		});
		$(document).ready(function() {
			$("#regLink").click(function() {
				$("#reg").toggle();
			});
		});
		$(document).ready(function() {
			$("#reg_close").click(function() {
				$("#reg").toggle();
			});
		});
		$(document).ready(function() {
			$("#login_close").click(function() {
				$("#login").toggle();
			});
		});
		$(document).ready(function() {
			$("#adminLogin_close").click(function() {
				$("#adminLogin").toggle();
			});
		});

		$(document).ready(function() {
			$("#find_close").click(function() {
				$("#findPassword").toggle();
			});
		});
		
		$(document).ready(function() {
			$("#forgetPass").click(function() {
				$("#login").toggle();
				$("#findPassword").toggle();
			});
		});
	</script>




</body>
</html>