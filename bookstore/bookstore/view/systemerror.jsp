<!DOCTYPE html>
<html lang="ja">

  <head>
  	<%@ page contentType="text/html; charset=utf-8" %>
  	<%@ page import="jp.ac.asojuku.bookstore.param.RequestConst" %>
  	<%@ page import="jp.ac.asojuku.bookstore.param.SessionConst" %>
  	<%@ page import="jp.ac.asojuku.bookstore.dto.MemberDTO"%>
  	<%@ page import="jp.ac.asojuku.bookstore.error.ErrorsAction" %>
  	<%@ page import="jp.ac.asojuku.bookstore.error.ErrorAction" %>
  	<%@ page import="jp.ac.asojuku.bookstore.dto.SystemError" %>
  	<%@ page import="java.io.*,java.util.*,java.text.*" %>
  	<%@ page session="true"%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>新規会員登録</title>
	<!-- bookstore css -->
	<link href="view/css/bookstore.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="view/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
  </head>
  <body>
 
    
 <%SystemError system = (SystemError)session.getAttribute("Syserr");
 SystemError systemerr = (SystemError)session.getAttribute("Systemerr");
 %>

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
		<%if(system != null){%>
		<ul class="list-group">
	  		<li class="list-group-item list-group-item-danger">
	  		
						<%= system.getMailError()%>
			
	  		</li>
	  		
		</ul>
		<% }%>
		<%if(systemerr != null){%>
		<ul class="list-group">
	  		<li class="list-group-item list-group-item-danger">
	  		
						<%=systemerr.getSystemError() %>
			
	  		</li>
	  		
		</ul>
		<% }%>
		

  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="view/js/bootstrap.min.js"></script>
  </body>
</html>
