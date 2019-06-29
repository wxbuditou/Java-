<%@page import="cn.it.cast.utils.PageModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% PageModel pm = (PageModel)request.getAttribute("page"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
</head>
<body>

<div class="container">
  <table width="750" border="1" align="center">
  <c:forEach items="${pm.list}" var="news" varStatus="idStatus">
    <tr><!-- 点击标题对该新闻阅读，服务端返回content，阅读量加1 -->
      <td>${idStatus.count+1}</td>
      <td><a href="${pageContext.request.contextPath }/${pm.url}">标题:${news.news_topic}</a></td>	
      <td>发起人${news.teacher_number}</td>
      <td>点击量${news.news_clicknum}</td>
    </tr>
    </c:forEach>
  </table>
</div>
<div style="text-align:center;">
  <!-- 发送到分页servlet，将返回video类信息存储到list中，传递到前台 -->
  共${page.totalPageNum}页/第${page.currentPageNum }页 
  <a href="${pageContext.request.contextPath }/${page.url}&num=1">首页</a>
  <a href="${pageContext.request.contextPath }/${page.url}&num=${page.prevPageNum}">上一页</a>
  
  
  <c:forEach begin="${page.startPage }" end="${page.endPage }" var = "i">
<a href="${pageContext.request.contextPath }/${page.url}&num=${i}">${ i}</a>
</c:forEach>

<a href="${pageContext.request.contextPath }/${page.url}&num=${page.nextPageNum}">下一页</a>
<a href="${pageContext.request.contextPath }/${page.url}&num=${page.endPage}">末页</a>
</div>

</body>
</html>