<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%@ include file="/jsp/header.jsp" %>
  <div style="width:1200px;margin:0 auto;" >
    <div style="margin-left:400px;font-size:30px;" >${notice.ntitle }<br /><br /></div>
    <div style="font-size:20px;" >${notice.ncontent }<br /><br /></div>
     <div style="float:right;font-size:20px;" >${notice.ndate }<br /><br /></div>
   </div>
  <%@ include file="/jsp/footer.jsp" %>
  </body>
</html>
