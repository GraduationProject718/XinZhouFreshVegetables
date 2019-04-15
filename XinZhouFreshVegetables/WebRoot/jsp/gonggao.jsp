<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>站内公告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  <%@ include file="/jsp/header.jsp" %>
	<div style="width:1200px; margin:0 auto;font-size:20px;" >
	<c:forEach items="${page.list}" var="n" varStatus="status">
	<a href="NoticeServlet?method=view&nid=${n.nid}">${ n.ntitle }</a>
	<div style="float:right;" >${ n.ndate }</div>
	<br /><br />
	</c:forEach>
	<%@include file="/jsp/pageFile.jsp" %>
	</div>	
	<%@ include file="/jsp/footer.jsp" %>
  </body>
</html>
