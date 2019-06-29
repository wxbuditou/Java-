<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String randcode = (String)session.getAttribute("check_code");
//String obj =(String)request.getSession().getAttribute("msg");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>登陆</title>
<style type="text/css">

body {
	background-color: #FAFAD2;
	background-image: url(Image/login_bgx.gif);
}


.loginwindow{
	background-image: url(Image/login_m_bg.png);
	background-repeat:no-repeat;
}

.user{
	background-image: url(Image/user.png);
}

.password{
	background-image: url(Image/password.png);
}

</style>
</head>

<script type="text/javascript" src="<%=path %>/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
/*
	$(function(){
		$("#username").blur(function(){
			var un = $("#username").val();
			var username = $.trim(un);
			var add = $("#ad").val();
			var ad = $.trim(add);
			alert(ad);
			if (username!=null&&username!=""){
				$.post("UserServlet",{"method":"valideUserExist","username":username,"ad":ad},function(data){
					
					if (data=="no"){
						var rs = $("#result");
						rs.html("用户名不存在！");
					}
				});//发送数据到服务器进行异步校验
				
			}else{
				alert("请输入学号");
			}
		})
		
	});*/
	//验证码不同步，session中永远慢一步，后台校验验证码
	function judge(){
		var un = $("#username").val();
		var username=$.trim(un);
		var add = $("#ad").val();
		var ad = $.trim(add);
		var pd = $("#password").val();
		var password = $.trim(pd);
		var cd = $("#code").val();
		var code=$.trim(cd);
		var rc = $("#hiddencode").val();
		if (username==null||username==""){
			alert("请输入用户名");
			return;
		}
		if (password==null||password==""){
			alert("请输入密码！");
			return;
		}
		if (code==null||code==""){
			alert("请输入验证码！");
			return;
		}
		$("#fm").submit();
	}
	
</script>
<body background="">

<div id="container" style="width:400px;height:300px;margin:auto;margin-top:15%; background:200080;">
<div class="loginwindow" style=" width:403px;height:302px; margin-top:30px;">
<div class="window" style=" padding-top:20px; padding-left:5px; padding-right:5px;">
<div class="denglu"><p align="center" style="font-size:16px; margin-top:5px;"><strong>登陆</strong></p></div>

<div style="margin-top:5px; margin-bottom:5px; padding-left:5px;"><span id="result" style="color:red;">
<c:if test="${not empty sessionScope.msg}">
	${sessionScope.msg}
	<%request.getSession().removeAttribute("msg"); %>
</c:if>
</span></div>
<div class="fmcontainer" style=" margin-left:12px; margin-top:10px;">
<form action="UserServlet" method="post" id="fm">
		用户名：
    <input type="text" name="username" id="username" style=" width:245px; height:37px;" class="user"> 
	<select name="position" style="height:37px; width:60px;">
	  <option value="student" selected="selected">学生</option>
	  <option value="teacher" >教师</option>
	  <option value="adminstrator">管理员</option> 
    </select>
<br>
			密&nbsp;&nbsp;&nbsp;码：	
    <input type="password" name="password" id="password" style="  width:245px; height:37px;" class="password">
	<br>
	验证码：<input type="text" name="code" id="code" style="  width:245px; height:37px;">
	<img src="servlet/CheckCodeServlet"><br>
    <div style="text-align:center;">
	<input type="reset" value="重置" style=" text">
	<input type="button" value="提交" onclick="judge();">
    </div>
</form>
</div>
</div>
</div>
</div>
</body>
</html>