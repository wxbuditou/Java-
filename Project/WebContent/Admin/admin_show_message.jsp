<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交流评论</title>
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

function btn_comment(){
	var cm = $("#publish_comment").val();
	var comment = $.trim(cm);
	var meid = $("#messageid").val();
	var message_id = $.trim(meid);
	var content = $("#content").val();
	
	if (comment==null||comment==""){
		alert("评论不能为空！");
		return;
	}
	location.href="AdminServlet?method=publish_comment&message_id="+message_id +"&comment_content="+content;
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
   </table>
   </div>
   </td>
   </tr>
   
  <tr>
    <td colspan="4">
    <div style="border:1px dashed #000; height:650px;">
   <table width="750">
   <tr>
   <td colspan="4">
   <input type="hidden" id="messageid" value="${message.message_id }">
    <span style="text-align:center;display:block;width=750">${message.message_topic }</span>
    </td>
    </tr>
    <tr>
    
    <td>
    <span style="width:750px;height:500px;">${message.message_content}</span>
    </td>
 	</tr>
    </table>
    </div>
    </td>
    </tr>
    
    <tr>
    <td width="750">
    <div><span>发表自己的看法:</span></div>
    <textarea name="ps_comment" id="content" cols="30px" rows="10px" style=" overflow:
    auto; background-color:; width:750px; font-size:18px;"></textarea><br>
    <input id="publish_comment" name="publish_comment" type="button" value="发表" onClick="btn_comment();">
    </td>
    </tr>
    
    <tr>
    <td>
    <!-- 遍历评论 -->
    <table width="750">
    <tr>
    <td width="770"><span><b>评论</b></span></td>
    </tr>
    <c:if test="${comments.size()!=0}">
    <c:forEach items="${comments}" var="comment" varStatus="idStatus"> 
    <tr>
    <td>
    <div> <span>
    <c:if test="${comment.comment_character==2 }">[学生] ${comment.comment_username }</c:if>
   	<c:if test="${comment.comment_character==0 }">[教师] ${comment.comment_username }</c:if>
   	<c:if test="${comment.comment_character==1 }">[管理员] ${comment.comment_username }</c:if>
   	
    第${idStatus.count }楼 	${comment.comment_time}</span></div>
    <div> <span><textarea  cols="30px" rows="8px" style=" overflow:
    auto; background-color: ; width:750px;" disabled="disabled">${comment.comment_content}</textarea></span></div>
    </td>
    </tr>
    </c:forEach>
    </c:if>
    <c:if test="${comments.size()==0 }">
    <tr>
    <td><span>当前没有人评论！</span></td></tr>
    </c:if>
    </table>
    
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