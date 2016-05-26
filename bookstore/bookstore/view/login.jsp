<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=utf-8" errorPage="systemerror.jsp" %>
<%@ page import="jp.ac.asojuku.bookstore.param.SessionConst" %>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>ログイン</title>
<link rel="stylesheet" href="http://localhost:8080/bookstore/view/css/bookstore.css">
<script src="http://localhost:8080/bootstore/view/js/bookstore.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script type='text/javascript' src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <script type='text/javascript' src="//cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js"></script>
<![endif]-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<style type="text/css">
	div #error {
	color:red;
}
#in{
	background-color:snow;
}
#in h1{
	color:hotpink;
	 float:left;
}
</style>


</head>

<body>
	<nav class="navbar navbar-inverse">

		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarEexample7">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ASO書店</a>

			</div>

			<div class="collapse navbar-collapse" id="navbarEexample7">
				<ul class="nav navbar-nav">
					<li><a href="<%=request.getContextPath() %>/top">トップ画面</a></li>
					<li><a href="#">買い物かご</a></li>
				</ul>

			</div>
		</div>
	</nav>
    <!-- <form >
         <input type="text" name="username" >
         <input type="password" name="password">
         <button type="submit">Sign in</button>
     </form>!-->
     <!-- /form -->
     <div class="container">

		  <div class="row" id="pwd-container">

		    <div class="col-md-4"></div>

		    <div class="col-md-4">
<%

String LoginRequestMsg =  (String)request.getAttribute("LoginRequestMsg");
String CSRFT = (String)session.getAttribute(SessionConst.SESSION_LOGUIN_TOKEN1);
System.out.println("@"+CSRFT +"kkkkkkkkkkkkkkk");
//request.setAttribute("Csrft",CSRFT);
//System.out.println("???????" +request.getAttribute("Csrft"));
if( LoginRequestMsg != null ){
%>

<div id="error">
<%= LoginRequestMsg %>
</div>
<%
}
%>
		      <section class="login-form"  >
		        <form  action="<%=request.getContextPath() %>/auth" method="POST" role="login" id="in">
		        

		          <h1>LOGIN</h1>
		          <!--<img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />!-->
		          <input type="email" name="memb_id" placeholder="Email" required class="form-control input-lg"  />

		          <input type="password" name="password" class="form-control input-lg" id="password" placeholder="Password"  />
		          <input type="hidden" name="_CSRFToken" value=<%=URLEncoder.encode(CSRFT,"UTF-8")%> />


		          <div class="pwstrength_viewport_progress"></div>


		          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
		          <div>
		            <a href="<%=request.getContextPath() %>/MemberNew" onclick="document.form.submit(); return false;">新規会員登録</a> or <a href="#">パスワードをお忘れ</a>
		          </div>

		        </form>

		        <div class="form-links">
		          
		        </div>
		      </section>
		     </div>

		     <div class="col-md-4"></div>


		  </div>




	</div>


</body>

</html>