<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品列表</title>
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
				<c:forEach items="${page.list}" var="p" varStatus="status">
					<c:if test="${p.pflag == 0}">
					<div class="col-md-4">
						<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}&num=1">
							<img src="${pageContext.request.contextPath}/${p.pimage}" width="200" height="200" style="display: inline-block;">
						</a>
						<p><a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}" style='color:green;font-size:18px;'>${p.pname}</a></p>
						<p style="font-size:15px;"><font color="#FF0000">商城价：&yen;${p.shop_price}</font></p>
					</div>
					</c:if>
				</c:forEach>
			</c:if>
		</div>
		<div style="margin:20px;">
			<jsp:include page="/jsp/pageFile.jsp"></jsp:include>
		</div>
		<%@ include file="/jsp/footer.jsp" %>
	</body>

</html>