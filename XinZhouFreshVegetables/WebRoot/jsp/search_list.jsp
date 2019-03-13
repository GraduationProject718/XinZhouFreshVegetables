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
    
    <title>信息搜索</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- 引入自定义css文件 style.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

	<style>
		body {
			margin-top: 20px;
			margin: 0 auto;
			width: 100%;
		}
			width: 100%;
			height: 300px;
		}
	</style>

  </head>
  
  <body>
  <%@ include file="/jsp/header.jsp" %>
    <div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
				</ol>
			</div>
			
			<c:if test="${empty page.list}">
				<div class="col-md-2">
					<h1>暂无数据</h1>
				</div>
			</c:if>
			
			<c:if test="${not empty page.list}">
				<c:forEach items="${page.list}" var="p">
					<c:if test="${p.pflag == 0 }">
					<div class="col-md-2">
						<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}">
							<img src="${pageContext.request.contextPath}/${p.pimage}" width="170" height="170" style="display: inline-block;">
						</a>
						<p><a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}" style='color:green'>${p.pname}</a></p>
						<p><font color="#FF0000">商城价：&yen;${p.shop_price}</font></p>
					</div>
					</c:if>
				</c:forEach>
				<jsp:include page="/jsp/pageFile.jsp"></jsp:include>
			</c:if>
		</div>
  <%@ include file="/jsp/footer.jsp" %>
  </body>
</html>
