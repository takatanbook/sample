
<!DOCTYPE html>
<html lang="ja">
<head>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="jp.asojuku.testmanagement.dto.SeachTestHistoryStudentDTO" %>
<%@ page import="jp.asojuku.testmanagement.dto.SeachTestHistoryStudentResultDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="jp.asojuku.testmanagement.dto.SeachStudentHistoryTestResultDTO" %>
<%@ page import="jp.asojuku.testmanagement.dto.SeachStudentHistoryTestDTO" %>
<%@ page import="jp.asojuku.testmanagement.util.CipherHelper" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date" %>
<script type="text/javascript" src="view/js/jquery_post_link.js"></script>
<script type="text/javascript" src="view/js/jquery.js"></script>
<script type="text/javascript" >
	$("a.post").toPostLink();
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
<%
//seachstudenthistorytestresult
	SeachStudentHistoryTestResultDTO result = 
			(SeachStudentHistoryTestResultDTO)request.getAttribute("seachstudenthistorytestresult");
	SeachTestHistoryStudentResultDTO resultdto =
			(SeachTestHistoryStudentResultDTO)request.getAttribute("seachstudentlogtextresult");
	if(resultdto != null){
		
%>
<% 
		String keyword = resultdto.getKeyword();
		List<SeachTestHistoryStudentDTO> list = resultdto.getStudentinfolist();
		if(list == null){
			System.out.println("null");
		}
%>
		<h1><%= keyword %></h1>
		<% for(SeachTestHistoryStudentDTO data: list) {%>
			<% String encrypedResult = CipherHelper.encrypt(data.getStudent_id()); %>
			<a class="post" href="<%=request.getContextPath() %>/historyoftest?student_id=<%=URLEncoder.encode(encrypedResult,"UTF-8")%>"><%=data.getStudent_id() %></a>
			<h1><%=data.getStudent_name() %></h1>
			<h1><%=data.getGrade() %></h1>
			<h1><%=data.getDepartment() %></h1>
		<%} %>
	<%} else if(result  != null){ %>
		<% List<SeachStudentHistoryTestDTO> list = result.getstudenttestloginfolist();%>
		
		<% for (SeachStudentHistoryTestDTO data : list) { %>
			<%
			String date = "";
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); 
			date = sdf1.format(data.getTestDay());
			%>
			<h1><%= date %></h1>
			<h1><%= data.getStudentName() %></h1>
			<h1><%= data.getTestName() %></h1>
			<h1><%= data.getTestSponsor() %></h1>
			
			<% String nae = "";
			int i = data.getExamationResult();
			if(i == 1){
				nae ="合格";
			}else{nae = "不合格";}
			%>
			<h1><%=nae %></h1>
			<hr />
		<%} %>
	<% } %>

 
</body>
</html>