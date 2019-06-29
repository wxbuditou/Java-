<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频播放</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

<link rel="stylesheet" href="../css/layout.css" type="text/css">
<style type="text/css">
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	margin: 0;
	padding: 0;
	color: #000;
	background-image:url(../Image/login_bgx.gif);
}
</style>

<script type="text/javascript">

	function logout(){
		
		var del = confirm("你确定要注销吗？")
		if (del==true){
			location.href="TeacherServlet?method=teacher_logout";
		}
	}

</script>

</head>
<body>

<div class="container">
  <div class="header"> 
    <!-- end .header --></div>
  <div class="sidebar1">
    <ul class="nav">
      <li><a href="TeacherServlet?method=scan_news&num=1">教学公告</a></li>
      <li><a href="TeacherServlet?method=scan_video&num=1">教学视频</a></li>
      <li><a href="TeacherServlet?method=scan_document&num=1">试题下载</a></li>
      <li><a href="TeacherServlet?method=scan_message&num=1">师生交流</a></li>
    </ul>
    
    <!-- end .sidebar1 --></div>
  <div class="content">
    <table width="764" border="0">
      <tr>
        <td width="758" height="42"><div class="userinfo">
          <table width="758" border="0">
            <tr>
              <td height="37">欢迎你：${sessionScope.teacher.teacher_username }</td>
              <td>工号：${sessionScope.teacher.teacher_number }</td>
              <td>上一次在线时间：${sessionScope.teacher.teacher_onlinetime}</td>
              <td><button id="logout" onclick="logout();">注销</button></td>
            </tr>
          </table>
        </div>
        </td>
      </tr>
      
     <tr>
     <td>
    <div class="news_num">
    <table width="750" border="0">
    <tr bgcolor="#E6E6FA">
      <td><a href="teacher_publish_news.jsp">发布公告</a></td>
      <td><a href="teacher_publish_video.jsp">发布视频</a></td>	
      <td><a href="teacher_publish_document.jsp">发布文档</a></td>
      <td><a href="#">回复答疑</a></td>
   </tr>
   </table>
   </div>
   </td>
   
   <tr>
    <td >
   <video  controls="controls" width="750" height="500">
 	 <source src="/Project/${video.video_savepath }/${video.video_attachment}" type="video/mp4">
	</video>
    </td>
     </tr>
    </table>
  </div>
  
   <div class="footer" style="text-align:center ; display:blocked;">
    <p >copyright@wx工作室，版权所有，侵权必究。</p>
  <!-- end .footer --></div>
  <!-- end .container --></div>

  
</body>
</html>