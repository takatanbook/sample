/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.69
 * Generated at: 2016-07-19 02:51:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=Shift_JIS\">\r\n");
      out.write("<title>検定管理システム</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/view/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/view/js/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("    $('a,a img,button').css({\r\n");
      out.write("        opacity: 1.0,\r\n");
      out.write("        filter: \"alpha(opacity=100)\"\r\n");
      out.write("        }).hover(function(){\r\n");
      out.write("            $(this).fadeTo(200,0.6);\r\n");
      out.write("        },function(){\r\n");
      out.write("            $(this).fadeTo(200,1.0);\r\n");
      out.write("    })\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<header><h1><a href=\"main_admin.html\">検定管理システム</a></h1></header>\r\n");
 String err = (String)request.getAttribute("errMsg");
      out.write('\r');
      out.write('\n');
 String Studenterr = (String)request.getAttribute("StudentMsg");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"info\">\r\n");
      out.write("\t<h2>検定キーワードで検索</h3>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/seachtestinfo\" method=\"POST\">\r\n");
      out.write("\t");
if(err != null) {
      out.print( err );
 }
      out.write("<br />\r\n");
      out.write("\t<input type=\"text\" name=\"keyword\"><br>\r\n");
      out.write("\t<button class=\"button1\" type=\"submit\">検索</button>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<h2>受験学生氏名で検索</h2>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action =\"");
      out.print(request.getContextPath() );
      out.write("/seachStudenttesthistory\" method=\"POST\">\r\n");
      out.write("\t");
if(Studenterr != null) {
      out.print( Studenterr );
 }
      out.write("<br />\r\n");
      out.write("\t<input type=\"text\" name=\"keyword\"><br>\r\n");
      out.write("\t<button class=\"button1\" type=\"submit\">検索</button>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"side\">\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/logout\"><button class=\"menu\" type=\"submit\">ログアウト</button></form>\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/admintop\"><button class=\"menu\" type=\"submit\">メニュートップ</button></form>\r\n");
      out.write("\t\r\n");
      out.write("\t<p><hr></p>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/admintestview\" method=\"POST\"><button class=\"menu\" type=\"submit\">検定情報トップ</button></form>\r\n");
      out.write("\t<form action=\"test_add.html\" method=\"POST\"><button class=\"menu\" type=\"submit\">検定の追加</button></form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<footer>&copy; 2016 WhiteCo.</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
