<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="jp.ac.asojuku.bookstore.param.SessionConst" %>
<%@ page import="jp.ac.asojuku.bookstore.dto.LoginInfoDTO" %>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    
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
	<title>トップ画面サンプル</title>
<style type="text/css">


.container{
	
}

.header{
	border-top:3px solid #000;
}
.logo{
	margin:0.5em auto;
	display:block;
}
.headerNavBtn{
	text-align:center;
	height:3em;
	line-height:3em;
	color:#5F5F5F;
	font-size:16px;
}
.headerNavBtn:hover{
	background:#EEE;
}

.section{
	background: #232829;
	background: -moz-linear-gradient(50% 0% -90deg, #000 0%, #232829 100%);
	background: -o-linear-gradient(-90deg, #000 0%, #232829 100%);
	background: -webkit-gradient(linear, 50% 0%, 50% 100%, color-stop(0, #000), color-stop(1, #232829));
	background: -webkit-linear-gradient(-90deg, #000 0%, #232829 100%);
	background: linear-gradient(180deg, #000 0%, #232829 100%);
	padding: 2em 0 3em;
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#ff000000,endColorstr=#ff232829,GradientType=0)";
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#ff000000,endColorstr=#ff232829,GradientType=0);
}


.mainVisual_wrapper{

}

.mainVisual_wrapper .container{
	padding:0;
}

.mainVisual_wrapper.section{
	padding:0;
}

.col_box{
	background:#FFF;
	border-radius:3px;
	padding:15px 0 15px;
	margin-bottom:1em;
}

.copyright{
	text-align:center;
	margin:0.5em auto;
	display:block;
}

.taka {
    background-color:snow;
    padding:10px; /* メニュー全体170px; */
    width:270px; /* リンク部分150px; */
    /*background-image: url("view/img/sa.jpg")*/
}
.taka li {
    list-style-type:none;  /* リスト記号なし */
    /* margin-bottom:5px; */
}
.taka a {
    border:solid 2px;
    border-color:white darkblue darkblue white;
    padding:5px;
    display:block;
    font-weight:bold;
    font-size:12px;
    color:#ffffff;
    text-decoration:none;
    background-color:#BAD3FF;
}
.taka a:hover {
    border-color:darkblue lightblue lightblue darkblue;
    padding:7px 3px 3px 7px;
    background-color:#ffcccc;
}
.taka h1{
   font-size: 17px;
   color:#ffcc99;
   text-align: center;
   border: medium solid #ff00ff;
   
}
.taka h2{
   font-size: 17px;
   color:hotpink;
   text-align: center;
   border: medium solid white;
}
.form1{
	width:500px;
	margin:0 auto;
	margin-left:auto;
	margin-right:auto;
	
}
.search { 
	padding:6px 15px 6px 30px;
	margin:3px; 
	 
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
<%
LoginInfoDTO loginInfo = (LoginInfoDTO)session.getAttribute(SessionConst.SESSION_LOGININFO);
%>
				<div class="collapse navbar-collapse" id="navbarEexample7">
					<ul class="nav navbar-nav">
						<li><a href="<%=request.getContextPath() %>/top">トップ画面</a></li>
						<li><a href="#">買い物かご</a></li>
						<% if(loginInfo == null ){ %>
						<li><a href="<%=request.getContextPath() %>/MemberNew">新規会員登録</a></li>
						<li><a href="<%=request.getContextPath() %>/login">ログイン</a></li>
						<% } else { %>
						<li><a class="navbar-brand" href="#">ようこそ! <%= loginInfo.getMemb_name() %>さん</a><li>
						<li><a href="<%=request.getContextPath() %>/logout">ログアウト</a></li>
						<% } %>
					</ul>
	
				</div>
				
				
			</div>
		</nav>
		
		

		<div class="container">

		  <div class="row" id="pwd-container">

		    <div class="col-md-4"></div>

		    <div class="col-md-4">

		      <section class="login-form">
		      	
		        
		       </section>
		      </div>
		    <div class="col-md-4"></div>
		   </div>
		 </div>
		 <nav class="taka">
		 	<h2>書籍検索</h2>
		 	<h1>あ行からわ行で検索します。</h1>
		 	<form class="form1" action="<%=request.getContextPath() %>/" method="post" >
   				<span><input type="text" name="booksearch" class="search rounded" placeholder="Search..." size="15" ></span>
    			<span><input type="submit" value="検索" style="background-color:#ffffff;border-color:#ff6868;border-width:2px"></span>
			</form>
		 	
		 	<h1>ジャンル</h1>
			<ul>
			  <li><a href="#">一般教養</a></li>
			  <li><a href="#">語学</a></li>
			  <li><a href="#">情報系・PC関連</a></li>
			  <li><a href="#">介護・看護</a></li>
			  <li><a href="#">医療関連</a></li>
			  <li><a href="#">工業・電気関係</a></li>
			  <li><a href="#">法学関係</a></li>
			  <li><a href="#">国家試験対策本</a></li>
			  <li><a href="#">事務系</a></li>
			</ul>
			
		</nav>
	
		

   
   

</body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="view/img/js/jquery-2.1.4.js"></script>
<script src="view/img/js/jquery-2.1.4.min.js"></script>

</html>
