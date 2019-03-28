<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--mobile apps-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="My Resume Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
		SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--mobile apps-->
	<!--Custom Theme files-->
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link rel="stylesheet" href="css/swipebox.css">
	<!--//Custom Theme files-->
	<!--js-->
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- //js -->
	<!--web-fonts-->
	<link href='//fonts.googleapis.com/css?family=Overlock:400,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
	<!--//web-fonts-->
	<!--start-smooth-scrolling-->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>	
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
			
			function check(){
	    		var oldpassword = $("#oldpassword").val();
	    		var password = $("#password").val();
	    		var repassword = $("#repassword").val();
	    		var repassword2 = $("#repassword2").val();
	    		
	    		if(oldpassword != password){
	    			alert("旧密码错误！");
	    			return false;
	    		}
	    		
	    		if(repassword != repassword2){
	    			alert("两次输入密码不一致。");
	    			return false;
	    		}
	    		
	    		return true;
    		}
	</script>
	
  </head>
  
  <body>
    <%@ include file="/jsp/header.jsp" %>
    
    <!--banner-->
	<div id="home" class="banner">
		<div class="banner-info">
			<div class="container">
				<div class="col-md-8 header-right">
					<h1>${loginUser.name}</h1>
					<ul class="address">
						<li>
							<ul class="address-text">
								<li><b>出生日期</b></li>
								<li>${loginUser.birthday }</li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>联系电话 </b></li>
								<li>${loginUser.telephone }</li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>个人邮箱 </b></li>
								<li><a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=OwoLDg0MAwgIDgJ7SkoVWFRW" target="_blank"> ${loginUser.email }</a></li>
							</ul>
						</li>
						
						<li>
							<ul class="address-text">
								<li><b>性别 </b></li>
								<li>${loginUser.sex }</li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//banner-->
	
	<!--top-nav-->
	<div class="top-nav wow">
		<div class="container">
			<div class="navbar-header logo">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					导航
				</button>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<div class="menu">
					<ul class="nav navbar">
						<li><a href="javascript:void(0);"  data-toggle="modal" data-target="#editUser" class="scroll">修改个人信息</a></li>
						<li><a href="javascript:void(0);"  data-toggle="modal" data-target="#editPassword" class="scroll">更换密码</a></li>		
					</ul>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>	
	<!--//top-nav-->
	
	<!-- 修改个人信息 -->
	<form role="form" method="post" action="UserServlet?method=editUser">
	<div class="modal fade" id="editUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						修改个人信息
					</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" value="${loginUser.uid }" name="uid" id="uid" />
					<div class="form-group">
						<label for="name">姓名</label>
						<input type="text" value="${loginUser.name }" class="form-control" name="name" id="name" />
					</div>
						
					<div class="form-group">
						<label for="name">电话</label>
						<input type="text" value="${loginUser.telephone}" class="form-control" id="telephone" name="telephone" />
					</div>
					
					<div class="form-group">
						<label for="name">邮箱</label>
						<input type="text" value="${loginUser.email}" class="form-control" id="email" name="email" />
					</div>
					
					<label for="name">性别</label>
					<c:if test="${loginUser.sex == '男' }">
					<div class="radio">
					    <label><input type="radio" name="sex" id="sex" value="男" checked>男</label>
					</div>
					<div class="radio">
					    <label><input type="radio" name="sex" id="sex" value="女">女</label>
					</div>
					</c:if>
					
					<c:if test="${loginUser.sex == '女' }">
					<div class="radio">
					    <label><input type="radio" name="sex" id="sex" value="男" >男</label>
					</div>
					<div class="radio">
					    <label><input type="radio" name="sex" id="sex" value="女" checked>女</label>
					</div>
					</c:if>
					
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="submit" class="btn btn-primary">
						确定
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
    </form>
    
    <!-- 更换密码 -->
	<form role="form" method="post" action="UserServlet?method=editPassword"  >
	<div class="modal fade" id="editPassword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						更换密码
					</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" value="${loginUser.uid }" name="uid" id="uid" />
					<input type="hidden" value="${loginUser.password }" name="oldpassword" id="oldpassword" />
					<div class="form-group">
						<label for="name">旧密码</label>
						<input type="password"  class="form-control" id="password" name="password" />
					</div>
					
					<div class="form-group">
						<label for="name">新密码</label>
						<input type="password" class="form-control" id="repassword" name="repassword" />
					</div>
					
					<div class="form-group">
						<label for="name">新密码</label>
						<input type="password" class="form-control" id="repassword2" name="repassword2" />
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="submit" class="btn btn-primary" onclick="return check();" >
						确定
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
    </form>
    
  
    <%@ include file="/jsp/footer.jsp" %>
  </body>
</html>
