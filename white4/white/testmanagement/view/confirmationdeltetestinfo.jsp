<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<%@ page contentType="text/html; charset=utf-8" %>
	
	<%@ page import="jp.asojuku.testmanagement.dto.TestInfoDto" %>
	<%@ page import="jp.asojuku.testmanagement.dto.TestSeachResultDto" %>
	<%@ page import="java.util.List" %>
<title></title>
</head>

<body>
<%
TestSeachResultDto testseachresultdto = (TestSeachResultDto)request.getAttribute("testseachresult");
int conunt = testseachresultdto.getSearchNum();
List<TestInfoDto> list =testseachresultdto.getTestlist();
%>
<% if(conunt == 0){ %>
	
<% }else{%>
	<%for(TestInfoDto data: list){ %>
		<%= data.getTestName() %>
		<%= data.getSponsor() %>
		<%= data.getExaminationDate() %>
		<form method="POST" action="<%=request.getContextPath() %>/deletetestinfo">
			<button type="submit" name='action' value="<%= data.getTestId()%>" >削除</button>
		</form>
	<%} %>
<% } %>

</body>
</html>