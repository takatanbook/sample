<!DOCTYPE html>
<html lang="ja">

  <head>
  	<%@ page contentType="text/html; charset=utf-8" %>
  	<%@ page import="jp.ac.asojuku.bookstore.param.RequestConst" %>
  	<%@ page import="jp.ac.asojuku.bookstore.param.SessionConst" %>
  	<%@ page import="jp.ac.asojuku.bookstore.dto.MemberDTO"%>
  	<%@ page import="jp.ac.asojuku.bookstore.error.ErrorsAction" %>
  	<%@page import="java.net.URLEncoder"%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>会員登録確認</title>
    <link href="view/css/bookstore.css" rel="stylesheet">
	
    <!-- Bootstrap -->
    <link href="view/css/bootstrap.min.css" rel="stylesheet">
    <!-- Optional theme -->
    <link href="view/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
 <%MemberDTO memberInfo =(MemberDTO)request.getAttribute(
		 RequestConst.REQUEST_MEMBER_INFO);
 String CSRFT = (String)session.getAttribute(SessionConst.SESSION_MEMBER_TOKEN2);
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
		<div class="container">

		  <div class="row" id="pwd-container">

		    <div class="col-md-4"></div>

		    <div class="col-md-4">

		      <section class="login-form">
		        <form  action="<%=request.getContextPath() %>/cmfirmmember" method="POST" class="well">
		        

		          <h1>会員情報確認</h1>
		          <!--<img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />!-->
		          <div class="form-group">

            		<label for="name" class="col col-xs-12 col-sm-4 col-md-3 control-label">お名前</label>

         	  		<div class="col col-xs-5 col-sm-3 col-md-3">

              			<!--   <input type="text" name="name1" id="name1" class="form-control" placeholder="姓"> -->
              			<%= memberInfo.getName_sei() %>

          			</div>

          			<div class="col col-xs-5 col-sm-3 col-md-3">

              			<!--  <input type="text" name="name2" id="name2" class="form-control" placeholder="名">-->
						<%= memberInfo.getName_mei() %>
          			</div>

          			<div class="col-xs-offset-2 col-sm-offset-2 col-md-offset-3"></div>

        		</div>
        		<br><br>
        		
        		<div class="form-group">

         	  		<label for="name" class="col col-xs-12 col-sm-4 col-md-3 control-label">ふりがな</label>

          			<div class="col col-xs-5 col-sm-3 col-md-3">

              			<!--  <input type="text" name="name3" id="name1" class="form-control" placeholder="せい"> -->
						<%= memberInfo.getName_hurigana_sei() %>
          			</div>

          			<div class="col col-xs-5 col-sm-3 col-md-3">

            			<!--  <input type="text" name="name4" id="name2" class="form-control" placeholder="めい">-->
						<%= memberInfo.getName_hurigana_mei() %>
          			</div>

          			<div class="col-xs-offset-2 col-sm-offset-2 col-md-offset-3"></div>

        		</div>
        		<br><br>
        		<div class="form-group">

            		<label for="email" class="col col-xs-12 col-sm-4 col-md-3 control-label">ニックネーム</label>

            		<div class="col col-xs-12 col-sm-6 col-md-7">

              			<!--  <input type="text" name="nickname"  class="form-control" placeholder="ニックネーム">-->
						<%= memberInfo.getNickname() %>
          			</div>

         	 		<div class="col-xs-offset-0 col-sm-offset-2 col-md-offset-2"></div>


          		</div>
          		<br><br>
          		<div class="form-group">


         	  		<label for="zipcode" class="col col-xs-12 col-sm-4 col-md-3 control-label">郵便番号</label>

          			<div class="col col-xs-7 col-sm-4 col-md-4">

              			<div class="input-group">

                			

                			<!--  <input type="text" name="yuubinno" id="zipcode" class="form-control" placeholder="000-0000">-->
							<%= memberInfo.getYuubinNo() %>
            			</div>

            		</div>
					<br>
            		<div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-5"></div>

        		</div>
        		<br><br>
        		<div class="form-group">

          			<label for="pref" class="col col-xs-12 col-sm-4 col-md-3 control-label">都道府県</label>

          			<div class="col col-xs-7 col-sm-4 col-md-3">
						<%= memberInfo.getPrefecture() %>

                	</div>

                	<div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-6"></div>

              	</div>
              	<br><br>
              	<div class="form-group">

          			<label for="pref" class="col col-xs-12 col-sm-4 col-md-3 control-label">市区町村名</label>

          			<div class="col col-xs-7 col-sm-4 col-md-3">
						<%= memberInfo.getAddres1() %>

                	</div>
                	

                	<div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-6"></div>

              	</div>
              	<br><br>
              	<div class="form-group">

          			
                	<label for="pref" class="col col-xs-12 col-sm-4 col-md-3 control-label">番地・ビル名</label>
                	<div class="col col-xs-7 col-sm-4 col-md-3">
						<%= memberInfo.getAddres2() %>

                	</div>

                	<div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-6"></div>

              	</div>
              	<br><br>
              	<div class="form-group">

          			
                	<label for="pref" class="col col-xs-12 col-sm-4 col-md-3 control-label">電話番号</label>
                	<div class="col col-xs-7 col-sm-4 col-md-3">
						<%= memberInfo.getTel1()  %>

                	</div>
                	<div class="col col-xs-7 col-sm-4 col-md-3">
						<%=   memberInfo.getTel2()  %>

                	</div>
                	<div class="col col-xs-7 col-sm-4 col-md-3">
						<%=   memberInfo.getTel3() %>

                	</div>

                	<div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-6"></div>

              	</div>
              	<br><br>
              	<div class="form-group">

          			
                	<label for="pref" class="col col-xs-12 col-sm-4 col-md-3 control-label">メールアドレス</label>
                	<div class="col col-xs-7 col-sm-4 col-md-3">
						<%= memberInfo.getMail1() %>

                	</div>
                	<input type="hidden" name="Member_CSRFToken" value=<%=URLEncoder.encode(CSRFT,"UTF-8")%> />

                	<div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-6"></div>

              	</div>
              	

              

		          <!--  <div class="pwstrength_viewport_progress"></div>-->


		          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">登録を確定</button>
		      

		        </form>
		        <form class="well"action="<%=request.getContextPath() %>/MemberNew" method="POST" >
		        <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">訂正</button></form>
		       </section>
		      </div>
		    <div class="col-md-4"></div>
		   </div>
		 </div>
		
  </body>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="view/img/js/bootstrap.min.js"></script>
  <script src="view/img/js/bookstore.js"></script>
</html>