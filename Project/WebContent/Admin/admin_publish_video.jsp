<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布视频</title>
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

	function verify(){
		var nm = $("#name").val();
		var name = $.trim(nm);
		var fe = $("#file").val();
		var file = $.trim(fe);
		if (name==null||name==""){
			alert("视频标题未填写！");
			return;
		}
		
		if (file==null||file==""){
			alert("未选择视频文件！");
			return;
		}
		$("#fm").submit();
		
	}
	
	function logout(){
		
		var del = confirm("你确定要注销吗？")
		if (del==true){
			location.href="AdminServlet?method=Admin_logout";
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
      <li><a href="AdminServlet?method=scan_news&num=1">教学公告</a></li>
      <li><a href="AdminServlet?method=scan_video&num=1">教学视频</a></li>
      <li><a href="AdminServlet?method=scan_document&num=1">试题下载</a></li>
      <li><a href="AdminServlet?method=scan_message&num=1">师生交流</a></li>
    </ul>
    
    <!-- end .sidebar1 --></div>
  <div class="content">
    <table width="764" border="0">
      <tr>
        <td width="758" height="42"><div class="userinfo">
          <table width="758" border="0">
            <tr>
              <td height="37">欢迎你：${sessionScope.admin.ad_username }</td>
              <td>工号：${sessionScope.admin.ad_number }</td>
              <td>上一次在线时间：${sessionScope.admin.ad_onlinetime}</td>
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
      <td><a href="admin_publish_news.jsp">发布公告</a></td>
      <td><a href="admin_publish_video.jsp">发布视频</a></td>	
      <td><a href="admin_publish_document.jsp">发布文档</a></td>
      <td><a href="#">回复答疑</a></td>
   </tr>
   <tr>
   <td colspan="4">
   <div style="margin:80px auto;">
   <p>上传视频</p>
       <form action="AdminServlet?method=publish_video" enctype="multipart/form-data" method="post" id="fm">
       <div style="margin-left:250px">
	视频名称:
	  <input type="text" name="video_name" id="name"><br/>
	选择文件:
	<input type="file" name="video_attachment" id="file"><br/>
	视频描述:
	<input type="text" name="video_pro"><br/>
	<input type="submit" value="提交" onclick="verify();">
    </div>
</form>
   </div> 
   
   </td>
   </tr>
  </table>
  </div>
  
  
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