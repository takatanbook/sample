<!DOCTYPE html>
<html lang="ja">
<head>
	<%@ page contentType="text/html; charset=utf-8" %>
	
</head>
<body>
	<form action ="<%=request.getContextPath() %>/seachtestinfo" method="POST">
	キーワード<input type="text" name="keyword" > <br />
	<input type="submit" value="検索" />
	</form>
</body>
</html>