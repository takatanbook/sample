<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>検定管理システム</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="jQuery/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function(){
    $('a,a img,button').css({
        opacity: 1.0,
        filter: "alpha(opacity=100)"
        }).hover(function(){
            $(this).fadeTo(200,0.6);
        },function(){
            $(this).fadeTo(200,1.0);
    })
});
</script>
</head>
<body>
<%@ page import="jp.asojuku.testmanagement.dto.ExamationInfoDto" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%

	HttpSession examationsearchsession = request.getSession(false);

	ExamationInfoDto examationinfo = (ExamationInfoDto)examationsearchsession.getAttribute("examationinfo");

	int i = Integer.parseInt(request.getParameter("forid"));


%>

<header><h1><a href="/testmanagement/examationlist">検定管理システム</a></h1></header>

<div class="main">

	<div class="info">
	<h2>受験検定追加</h2>
	<p>受験検定の合否を選択してください。</p>

	<table class="list">
		<tr>
			<td class="testadd">実施日</td><td><%=examationinfo.getSponsor().get(i) %></td>
		</tr>
		<tr>
			<td class="testadd">主催</td><td><%=examationinfo.getSponsor().get(i) %></td>
		</tr>
		<tr>
			<td class="testadd">検定名</td><td><%=examationinfo.getTestName().get(i) %></td>
		</tr>
	</table>

	<form action="<%=request.getContextPath() %>/view/examationaddchack.jsp">
		<select name="gouhi" class="drop">
		<optgroup label="合否">
		<option value="1">合格</option>
		<option value="0">不合格</option>
		</optgroup>
		</select>


	<table class="button">
		<tr>
			<td class="button">
				<button class="button1" onClick="history.back()">戻る</button>
			</td>
			<td class="button">

				<button class="button1" type="submit" name="i" value="<%= i%>">確認</button>

			</td>
		</tr>
	</table>
	</form>
	</div>

	<div class="side">
	<form action="<%=request.getContextPath() %>/logout"><button class="menu" type="submit">ログアウト</button></form>

	<p><hr></p>

	<form action="<%=request.getContextPath() %>/examationlist"><button class="menu" type="submit">受験検定一覧</button></form>
	<form action="<%=request.getContextPath() %>/view/examationadd1.jsp" method="POST"><button class="menu" type="submit">受験検定の追加</button></form>
	</div>

</div>

<footer>&copy; 2016 WhiteCo.</footer>

</body>
</html>