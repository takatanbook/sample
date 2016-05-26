<!DOCTYPE html>
<html lang="ja">

  <head>
  	<%@ page contentType="text/html; charset=utf-8" %>
  	<%@ page import="jp.ac.asojuku.bookstore.param.RequestConst" %>
  	<%@ page import="jp.ac.asojuku.bookstore.param.SessionConst" %>
  	<%@ page import="jp.ac.asojuku.bookstore.dto.MemberDTO"%>
  	<%@ page import="jp.ac.asojuku.bookstore.error.ErrorsAction" %>
  	<%@ page import="jp.ac.asojuku.bookstore.error.ErrorAction" %>
  	<%@ page import="java.net.URLEncoder"%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>新規会員登録</title>
	<link href="view/css/bookstore.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="view/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    #error {
    color red;

    }
    nav{
      background: red;
    }
    .in{
    color:#ffcc99;
    }
    
    </style>
  </head>
  <body>
<% 
ErrorsAction  errors = (ErrorsAction)request.getAttribute(RequestConst.REQUEST_ERRORS);
String MemberToken1 = (String)session.getAttribute(SessionConst.SESSION_MEMBER_TOKEN1);
%>
<%MemberDTO memberINFO = (MemberDTO)request.getAttribute(RequestConst.REQUEST_MEMBER_INFO); %>
	<!-- 1.ナビゲーションバーの設定 -->
	<div class="dropdown">
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
						<li><a href="<%=request.getContextPath() %>/login">ログイン</a></li>
					</ul>
	
				</div>
				
				
			</div>
		</nav>
	</div>


	<!--  <div class="well">-->

		
		
    	<fieldset>
    	<ul class="list-group">
	  		<li class="list-group-item list-group-item-danger">
			<p class="">会員登録画面です。お手数ですが、全ての入力項目に必要項目に入力してください。最後に送信ボタンをおしてください。</p></li>
		</ul>
		
<% if( errors != null ){ %>
		<ul class="list-group">
		<li class="list-group-item list-group-item-danger">
	<% for(ErrorAction err : errors.getList()){%>
		
			<p><%= err.getMessage() %></p>
		
	<%} %>
	</li>
	</ul>
<%} %>
        
	
	
	
   <form class="form-horizontal" action="<%=request.getContextPath() %>/entrymember" method="POST">




       	<div class="form-group">

            <label for="name" class="col col-xs-12 col-sm-4 col-md-3 control-label in">お名前</label>

         	  <div class="col col-xs-5 col-sm-3 col-md-3">

              <input type="text" name="name1" id="name1" class="form-control" placeholder="姓"
              <% if(memberINFO !=null) { %> 
              	value=<%=memberINFO.getName_sei()%>
             <% } %> >
				<p class="help-block in">お名前を入力してください。（漢字または英字）</p>
          	</div>

          	<div class="col col-xs-5 col-sm-3 col-md-3">

              <input type="text" name="name2" id="name2" class="form-control" placeholder="名"
              <%if(memberINFO != null){ %>value=<%=memberINFO.getName_mei() %><%} %> >
			
          	</div>
			
          	<div class="col-xs-offset-2 col-sm-offset-2 col-md-offset-3"></div>

        	</div>
        	<div class="form-group">

         	  <label for="name" class="col col-xs-12 col-sm-4 col-md-3 control-label in">ふりがな</label>

          	<div class="col col-xs-5 col-sm-3 col-md-3">

              <input type="text" name="name3" id="name3" class="form-control" placeholder="せい"
              <%if(memberINFO != null){ %>value=<%=memberINFO.getName_hurigana_sei() %><%} %> >
			 <p class="help-block in">ふりがなを入力してください。（ひらがな）</p>
          	</div>

          	<div class="col col-xs-5 col-sm-3 col-md-3">

            	<input type="text" name="name4" id="name4" class="form-control" placeholder="めい"
            	<%if(memberINFO != null){ %>value=<%=memberINFO.getName_hurigana_mei() %><%} %> >

          	</div>

          	<div class="col-xs-offset-2 col-sm-offset-2 col-md-offset-3"></div>

        	</div>
        	<div class="form-group">

            <label for="email" class="col col-xs-12 col-sm-4 col-md-3 control-label in">ニックネーム</label>

            <div class="col col-xs-12 col-sm-6 col-md-7">

              <input type="text" name="nickname"  id="nickname" class="form-control" placeholder="ニックネーム"
              <%if(memberINFO != null){ %>value=<%=memberINFO.getNickname() %><%} %> >

          	</div>

         	 	<div class="col-xs-offset-0 col-sm-offset-2 col-md-offset-2"></div>


          </div>


          <div class="col-xs-offset-2 col-sm-offset-2 col-md-offset-3"></div>



        	 <div class="form-group">


         	  <label for="zipcode" class="col col-xs-12 col-sm-4 col-md-3 control-label in">郵便番号</label>

          	<div class="col col-xs-7 col-sm-4 col-md-4">

              <div class="input-group">

                <span class="input-group-addon">〒</span>

                <input type="text" name="yuubinno" id="zipcode" class="form-control" placeholder="000-0000"
                <%if(memberINFO != null){ %>value=<%=memberINFO.getYuubinNo() %><%} %> >
				
            	</div>
				<p class="help-block in">郵便番号入力してください。（半角）</p>
            </div>

            <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-5"></div>

        	</div>

        		<div class="form-group">

          		<label for="pref" class="col col-xs-12 col-sm-4 col-md-3 control-label in">住所</label>

          		<div class="col col-xs-7 col-sm-4 col-md-3">

            		<select name="pref" id="pref" class="form-control">
					   
  			           <option value="北海道">北海道</option>

  	    		       <option value="青森県">青森県</option>

  	        		   <option value="岩手県">岩手県</option>

  	            	 <option value="宮城県">宮城県</option>

  	          		 <option value="秋田県">秋田県</option>

  	           		 <option value="山形県">山形県</option>

  	               <option value="福島県">福島県</option>

  	               <option value="茨城県">茨城県</option>

  	               <option value="栃木県">栃木県</option>

  	               <option value="群馬県">群馬県</option>

  	               <option value="埼玉県">埼玉県</option>


  	               <option value="千葉県">千葉県</option>

  	               <option value="東京都">東京都</option>

  	               <option value="神奈川県">神奈川県</option>

  	               <option value="新潟県">新潟県</option>

  	               <option value="山梨県">山梨県</option>

  	               <option value="長野県">長野県</option>

  	               <option value="富山県">富山県</option>

  	               <option value="石川県">石川県</option>

  	               <option value="福井県">福井県</option>

  	               <option value="岐阜県">岐阜県</option>

  	               <option value="静岡県">静岡県</option>

  	               <option value="愛知県">愛知県</option>

  	               <option value="三重県">三重県</option>

  	               <option value="滋賀県">滋賀県</option>

  	               <option value="京都府">京都府</option>

  	               <option value="大阪府">大阪府</option>

  	               <option value="兵庫県">兵庫県</option>

  	               <option value="奈良県">奈良県</option>

  	               <option value="和歌山県">和歌山県</option>

  	               <option value="鳥取県">鳥取県</option>

  	               <option value="島根県">島根県</option>

  	               <option value="岡山県">岡山県</option>

  	               <option value="広島県">広島県</option>

  	               <option value="山口県">山口県</option>

  	               <option value="徳島県">徳島県</option>

  	               <option value="香川県">香川県</option>

  	               <option value="愛媛県">愛媛県</option>

  	               <option value="高知県">高知県</option>

  	               <option value="福岡県">福岡県</option>

  	               <option value="佐賀県">佐賀県</option>

  	               <option value="長崎県">長崎県</option>

  	               <option value="熊本県">熊本県</option>

  	               <option value="大分県">大分県</option>

  	               <option value="宮崎県">宮崎県</option>

  	               <option value="鹿児島県">鹿児島県</option>

  	               <option value="沖縄県">沖縄県</option>

  	             </select>
				<p class="help-block in">都道府県を選択してください。</p>
                </div>

                <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-6"></div>

              </div>

              <div class="form-group">

                <div class="col col-sm-8 col-sm-offset-4 col-md-9 col-md-offset-3">

                  <input type="text" name="addr1" id="addr1" class="form-control" placeholder="市区町村名"
                  <%if(memberINFO != null){ %>value=<%=memberINFO.getAddres1() %><%} %> >

                  <p class="help-block in">住所は2つに分けてご記入ください。</p>

                  <input type="text" name="addr2" id="addr2" class="form-control" placeholder="番地・ビル名"
                  <%if(memberINFO != null){ %>value=<%=memberINFO.getAddres2() %><%} %> >

                  <p class="help-block in">マンション名は必ず記入してください。</p>


                </div>

              </div>

              <div class="form-group">

                <label for="tel" class="col col-xs-12 col-sm-4 col-md-3 control-label in">電話番号</label>

                <div class="col-xs-12 colcol-xs-10 col-sm-6 col-md-7">

                  <div class="input-group">

                    <input type="tel" name="tel1" id="tel1" class="form-control" placeholder="080"
                    <%if(memberINFO!= null){ %>value=<%=memberINFO.getTel1() %><%} %> >

                    <span class="input-group-addon">-</span>

                    <input type="tel" name="tel2" id="tel2" class="form-control" placeholder="0000"
                    <%if(memberINFO != null){ %>value=<%=memberINFO.getTel2() %><%} %> >

                    <span class="input-group-addon">-</span>

                    <input type="tel" name="tel3" id="tel3" class="form-control" placeholder="0000"
                    <%if(memberINFO != null){ %>value=<%=memberINFO.getTel3() %><%} %> >

                  </div>
                  <p class="help-block in">携帯番号または自宅電話番号</p>

                </div>

                <div class="col-xs-offset-2 col-sm-offset-2 col-md-offset-2"></div>

              </div>

              <div class="form-group">

                <label for="email" class="col col-xs-12 col-sm-4 col-md-3 control-label in">メールアドレス</label>

                <div class="col col-xs-12 col-sm-6 col-md-7">

                  <input type="email" name="email" id="email" class="form-control" placeholder="メールアドレスを入力してください"
                  <%if(memberINFO != null){ %>value=<%=memberINFO.getMail1() %><%} %> >

                </div>

              <div class="col-xs-offset-0 col-sm-offset-2 col-md-offset-2"></div>


              </div>
              <div class="form-group">

                <label for="email2" class="col col-xs-12 col-sm-4 col-md-3 control-label in">メールアドレス再度確認</label>

                <div class="col col-xs-12 col-sm-6 col-md-7">

                  <input type="email" name="email2" id="email2" class="form-control" placeholder="メールアドレスを再度入力してください"
                  <%if(memberINFO != null){ %>value=<%=memberINFO.getMail2() %><%} %> >

                </div>

                <div class="col-xs-offset-0 col-sm-offset-2 col-md-offset-2"></div>


              </div>

              <div class="form-group">

                <label for="email" class="col col-xs-12 col-sm-4 col-md-3 control-label in">パスワード</label>

                <div class="col col-xs-12 col-sm-6 col-md-7">

                  <input type="password" name="password" id="pass1" class="form-control" placeholder="パスワード" ">
				<p class="help-block in">パスワードは、八文字以上。</p>
                </div>

                <div class="col-xs-offset-0 col-sm-offset-2 col-md-offset-2"></div>


              </div>
              <div class="form-group">

                <label for="email" class="col col-xs-12 col-sm-4 col-md-3 control-label in">パスワード再度入力</label>

                <div class="col col-xs-12 col-sm-6 col-md-7">

                  <input type="password" name="password2"  id="pass2"class="form-control" placeholder="パスワード再入力" >
				  <input type="hidden" name="Member_CSRFToken" value=<%=URLEncoder.encode(MemberToken1,"UTF-8")%> />
                </div>

                <div class="col-xs-offset-0 col-sm-offset-2 col-md-offset-2"></div>


              </div>
              <div class="form-group">

          		<label for="pref" class="col col-xs-12 col-sm-4 col-md-3 control-label in">性別</label>

          		<div class="col col-xs-7 col-sm-4 col-md-3">

  	          		<select name="sex" id="pref" class="form-control">
						
  				    	<option value="men">男性</option>
  				        <option value="woman">女性</option>


  		            </select>

                </div>

                <div class="col-xs-offset-5 col-sm-offset-4 col-md-offset-6"></div>

              </div>

              <div class="form-group">

                <div class="col col-xs-9 col-xs-offset-3 col-sm-8 col-sm-offset-4 col-md-9 col-md-offset-3">
				  <button type="submit" class="btn btn-default">送信</button>
                  <!--<button type="submit" class="btn btn-success btn-lg">登録</button>-->

                </div>

              </div>

            </form>

        </fieldset>

    

  <!--  </div>-->

  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="view/js/bootstrap.min.js"></script>
  </body>
</html>
