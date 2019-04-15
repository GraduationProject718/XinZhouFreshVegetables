<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>忻州新鲜蔬菜订购网</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">
		<%@ include file="/jsp/header.jsp" %>
		<div style="width:1400px;margin:0 auto;">
			<!--
            	描述：轮播条
            -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${pageContext.request.contextPath}/img/gun1.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/gun2.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/gun3.jpg">
							<div class="carousel-caption">

							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			
			<!--

            	描述：排行榜
            -->
			<div class="container-fluid" style="width:70%;float:left;">
				<div class="col-md-12">
					<h2>排行榜&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				
				<c:forEach items="${top}" var="p">
					<c:if test="${p.pflag == 0 }">
					<div class="col-md-4" style="text-align:center;height:400px;padding:10px 0px;">
						<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}&num=1">
							<img src="${pageContext.request.contextPath}/${p.pimage}"style="width:80%;height:300px;display: inline-block;">
						</a>
						<p><a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}&num=1" style='color:#666;font-size:20px;'>${p.pname}</a></p>
						<p><font color="#E4393C" style="font-size:20px;">&yen;${p.shop_price}</font></p>
					</div>
					</c:if>
				</c:forEach>
				
			</div>		
			
			<!--

            	描述：站内公告
            -->
			<div class="container-fluid" style="width:30%;float:right;font-size:20px;">
				<div class="col-md-12">
					<h2>站内公告&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/NoticeServlet?method=findNoticeByIndex&num=1" style="font-size:20px;float:right;">更多</a></h2>
				</div>
				<div class="col-md-10">
				<table>
				<c:forEach items="${notice}" var="n">
					<tr style="height:40px;padding-top:20px;">
						<td>
							<div >
								<a href="NoticeServlet?method=view&nid=${n.nid}">${n.ntitle}</a>
							</div>
						</td>
					</tr>
				</c:forEach>
				</table>
				</div>
			</div>		
			
			<!--

            	描述：最新商品
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<c:forEach items="${news}" var="p">
					<c:if test="${p.pflag == 0 }">
					<div class="col-md-3" style="text-align:center;height:500px;padding:10px 0px;">
						<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}&num=1">
							<img src="${pageContext.request.contextPath}/${p.pimage}" style="width:80%;height:400px;display: inline-block;" />
						</a>
						<p><a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}&num=1" style='color:#666;font-size:20px;'>${p.pname}</a></p>
						<p><font color="#E4393C" style="font-size:20px;">&yen;${p.shop_price}</font></p>
					</div>
					</c:if>
				</c:forEach>
					
				</div>
			</div>
			<!--

            	描述：热门商品
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<c:forEach items="${hots}" var="p">
					<c:if test="${p.pflag == 0 }">
					<div class="col-md-3" style="text-align:center;height:500px;padding:10px 0px;">
						<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}&num=1">
							<img src="${pageContext.request.contextPath}/${p.pimage}" style="width:80%;height:400px;display: inline-block;" />
						</a>
						<p><a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}&num=1" style='color:#666;font-size:20px;'>${p.pname}</a></p>
						<p><font color="#E4393C" style="font-size:20px;">&yen;${p.shop_price}</font></p>
					</div>
					</c:if>
				</c:forEach>
				</div>
			</div>	
			
			</div>
			</div>
			<!--
            	描述：页脚部分
            -->
			<%@ include file="/jsp/footer.jsp" %>
	</body>
</html>