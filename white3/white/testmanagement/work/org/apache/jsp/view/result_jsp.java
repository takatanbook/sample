/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.69
 * Generated at: 2016-06-27 04:25:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jp.asojuku.testmanagement.dto.SeachTestHistoryStudentDTO;
import jp.asojuku.testmanagement.dto.SeachTestHistoryStudentResultDTO;
import java.util.ArrayList;
import java.util.List;
import jp.asojuku.testmanagement.dto.SeachStudentHistoryTestResultDTO;
import jp.asojuku.testmanagement.dto.SeachStudentHistoryTestDTO;
import jp.asojuku.testmanagement.util.CipherHelper;
import java.text.SimpleDateFormat;
import java.net.URLEncoder;
import java.util.Date;

public final class result_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"view/js/jquery_post_link.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"view/js/jquery.js\"></script>\n");
      out.write("<script type=\"text/javascript\" >\n");
      out.write("\t$(\"a.post\").toPostLink();\n");
      out.write("</script>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n");
      out.write("<title></title>\n");
      out.write("</head>\n");
      out.write("<body>\n");

//seachstudenthistorytestresult
	SeachStudentHistoryTestResultDTO result = 
			(SeachStudentHistoryTestResultDTO)request.getAttribute("seachstudenthistorytestresult");
	SeachTestHistoryStudentResultDTO resultdto =
			(SeachTestHistoryStudentResultDTO)request.getAttribute("seachstudentlogtextresult");
	if(resultdto != null){
		

      out.write('\n');
 
		String keyword = resultdto.getKeyword();
		List<SeachTestHistoryStudentDTO> list = resultdto.getStudentinfolist();
		if(list == null){
			System.out.println("null");
		}

      out.write("\n");
      out.write("\t\t<h1>");
      out.print( keyword );
      out.write("</h1>\n");
      out.write("\t\t");
 for(SeachTestHistoryStudentDTO data: list) {
      out.write("\n");
      out.write("\t\t\t");
 String encrypedResult = CipherHelper.encrypt(data.getStudent_id()); 
      out.write("\n");
      out.write("\t\t\t<a class=\"post\" href=\"");
      out.print(request.getContextPath() );
      out.write("/historyoftest?student_id=");
      out.print(URLEncoder.encode(encrypedResult,"UTF-8"));
      out.write('"');
      out.write('>');
      out.print(data.getStudent_id() );
      out.write("</a>\n");
      out.write("\t\t\t<h1>");
      out.print(data.getStudent_name() );
      out.write("</h1>\n");
      out.write("\t\t\t<h1>");
      out.print(data.getGrade() );
      out.write("</h1>\n");
      out.write("\t\t\t<h1>");
      out.print(data.getDepartment() );
      out.write("</h1>\n");
      out.write("\t\t");
} 
      out.write('\n');
      out.write('	');
} else if(result  != null){ 
      out.write('\n');
      out.write('	');
      out.write('	');
 List<SeachStudentHistoryTestDTO> list = result.getstudenttestloginfolist();
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t");
 for (SeachStudentHistoryTestDTO data : list) { 
      out.write("\n");
      out.write("\t\t\t");

			String date = "";
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); 
			date = sdf1.format(data.getTestDay());
			
      out.write("\n");
      out.write("\t\t\t<h1>");
      out.print( date );
      out.write("</h1>\n");
      out.write("\t\t\t<h1>");
      out.print( data.getStudentName() );
      out.write("</h1>\n");
      out.write("\t\t\t<h1>");
      out.print( data.getTestName() );
      out.write("</h1>\n");
      out.write("\t\t\t<h1>");
      out.print( data.getTestSponsor() );
      out.write("</h1>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t");
 String nae = "";
			int i = data.getExamationResult();
			if(i == 1){
				nae ="合格";
			}else{nae = "不合格";}
			
      out.write("\n");
      out.write("\t\t\t<h1>");
      out.print(nae );
      out.write("</h1>\n");
      out.write("\t\t\t<hr />\n");
      out.write("\t\t");
} 
      out.write('\n');
      out.write('	');
 } 
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
