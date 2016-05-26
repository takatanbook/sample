/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.64
 * Generated at: 2016-01-09 05:22:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jp.ac.asojuku.bookstore.param.RequestConst;
import jp.ac.asojuku.bookstore.param.SessionConst;
import jp.ac.asojuku.bookstore.dto.MemberDTO;
import jp.ac.asojuku.bookstore.error.ErrorsAction;
import java.net.URLEncoder;

public final class confirmmember_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ja\">\n");
      out.write("\n");
      out.write("  <head>\n");
      out.write("  \t\n");
      out.write("  \t\n");
      out.write("  \t\n");
      out.write("  \t\n");
      out.write("  \t\n");
      out.write("  \t\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("    <title>会員登録確認</title>\n");
      out.write("    <link href=\"view/css/bookstore.css\" rel=\"stylesheet\">\n");
      out.write("\t\n");
      out.write("    <!-- Bootstrap -->\n");
      out.write("    <link href=\"view/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Optional theme -->\n");
      out.write("    <link href=\"view/css/bootstrap-theme.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write(" ");
MemberDTO memberInfo =(MemberDTO)request.getAttribute(
		 RequestConst.REQUEST_MEMBER_INFO);
 String CSRFT = (String)session.getAttribute(SessionConst.SESSION_MEMBER_TOKEN2);
 
      out.write("\n");
      out.write("\t  <nav class=\"navbar navbar-inverse\">\n");
      out.write("\t\n");
      out.write("\t\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbarEexample7\">\n");
      out.write("\t\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("\t\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href=\"#\">ASO書店</a>\n");
      out.write("\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\n");
      out.write("\t\t\t\t<div class=\"collapse navbar-collapse\" id=\"navbarEexample7\">\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/top\">トップ画面</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">買い物かご</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</nav>\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\n");
      out.write("\t\t  <div class=\"row\" id=\"pwd-container\">\n");
      out.write("\n");
      out.write("\t\t    <div class=\"col-md-4\"></div>\n");
      out.write("\n");
      out.write("\t\t    <div class=\"col-md-4\">\n");
      out.write("\n");
      out.write("\t\t      <section class=\"login-form\">\n");
      out.write("\t\t        <form  action=\"");
      out.print(request.getContextPath() );
      out.write("/cmfirmmember\" method=\"POST\" class=\"well\">\n");
      out.write("\t\t        \n");
      out.write("\n");
      out.write("\t\t          <h1>会員情報確認</h1>\n");
      out.write("\t\t          <!--<img src=\"http://i.imgur.com/RcmcLv4.png\" class=\"img-responsive\" alt=\"\" />!-->\n");
      out.write("\t\t          <div class=\"form-group\">\n");
      out.write("\n");
      out.write("            \t\t<label for=\"name\" class=\"col col-xs-12 col-sm-4 col-md-3 control-label\">お名前</label>\n");
      out.write("\n");
      out.write("         \t  \t\t<div class=\"col col-xs-5 col-sm-3 col-md-3\">\n");
      out.write("\n");
      out.write("              \t\t\t<!--   <input type=\"text\" name=\"name1\" id=\"name1\" class=\"form-control\" placeholder=\"姓\"> -->\n");
      out.write("              \t\t\t");
      out.print( memberInfo.getName_sei() );
      out.write("\n");
      out.write("\n");
      out.write("          \t\t\t</div>\n");
      out.write("\n");
      out.write("          \t\t\t<div class=\"col col-xs-5 col-sm-3 col-md-3\">\n");
      out.write("\n");
      out.write("              \t\t\t<!--  <input type=\"text\" name=\"name2\" id=\"name2\" class=\"form-control\" placeholder=\"名\">-->\n");
      out.write("\t\t\t\t\t\t");
      out.print( memberInfo.getName_mei() );
      out.write("\n");
      out.write("          \t\t\t</div>\n");
      out.write("\n");
      out.write("          \t\t\t<div class=\"col-xs-offset-2 col-sm-offset-2 col-md-offset-3\"></div>\n");
      out.write("\n");
      out.write("        \t\t</div>\n");
      out.write("        \t\t<br><br>\n");
      out.write("        \t\t\n");
      out.write("        \t\t<div class=\"form-group\">\n");
      out.write("\n");
      out.write("         \t  \t\t<label for=\"name\" class=\"col col-xs-12 col-sm-4 col-md-3 control-label\">ふりがな</label>\n");
      out.write("\n");
      out.write("          \t\t\t<div class=\"col col-xs-5 col-sm-3 col-md-3\">\n");
      out.write("\n");
      out.write("              \t\t\t<!--  <input type=\"text\" name=\"name3\" id=\"name1\" class=\"form-control\" placeholder=\"せい\"> -->\n");
      out.write("\t\t\t\t\t\t");
      out.print( memberInfo.getName_hurigana_sei() );
      out.write("\n");
      out.write("          \t\t\t</div>\n");
      out.write("\n");
      out.write("          \t\t\t<div class=\"col col-xs-5 col-sm-3 col-md-3\">\n");
      out.write("\n");
      out.write("            \t\t\t<!--  <input type=\"text\" name=\"name4\" id=\"name2\" class=\"form-control\" placeholder=\"めい\">-->\n");
      out.write("\t\t\t\t\t\t");
      out.print( memberInfo.getName_hurigana_mei() );
      out.write("\n");
      out.write("          \t\t\t</div>\n");
      out.write("\n");
      out.write("          \t\t\t<div class=\"col-xs-offset-2 col-sm-offset-2 col-md-offset-3\"></div>\n");
      out.write("\n");
      out.write("        \t\t</div>\n");
      out.write("        \t\t<br><br>\n");
      out.write("        \t\t<div class=\"form-group\">\n");
      out.write("\n");
      out.write("            \t\t<label for=\"email\" class=\"col col-xs-12 col-sm-4 col-md-3 control-label\">ニックネーム</label>\n");
      out.write("\n");
      out.write("            \t\t<div class=\"col col-xs-12 col-sm-6 col-md-7\">\n");
      out.write("\n");
      out.write("              \t\t\t<!--  <input type=\"text\" name=\"nickname\"  class=\"form-control\" placeholder=\"ニックネーム\">-->\n");
      out.write("\t\t\t\t\t\t");
      out.print( memberInfo.getNickname() );
      out.write("\n");
      out.write("          \t\t\t</div>\n");
      out.write("\n");
      out.write("         \t \t\t<div class=\"col-xs-offset-0 col-sm-offset-2 col-md-offset-2\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("          \t\t</div>\n");
      out.write("          \t\t<br><br>\n");
      out.write("          \t\t<div class=\"form-group\">\n");
      out.write("\n");
      out.write("\n");
      out.write("         \t  \t\t<label for=\"zipcode\" class=\"col col-xs-12 col-sm-4 col-md-3 control-label\">郵便番号</label>\n");
      out.write("\n");
      out.write("          \t\t\t<div class=\"col col-xs-7 col-sm-4 col-md-4\">\n");
      out.write("\n");
      out.write("              \t\t\t<div class=\"input-group\">\n");
      out.write("\n");
      out.write("                \t\t\t\n");
      out.write("\n");
      out.write("                \t\t\t<!--  <input type=\"text\" name=\"yuubinno\" id=\"zipcode\" class=\"form-control\" placeholder=\"000-0000\">-->\n");
      out.write("\t\t\t\t\t\t\t");
      out.print( memberInfo.getYuubinNo() );
      out.write("\n");
      out.write("            \t\t\t</div>\n");
      out.write("\n");
      out.write("            \t\t</div>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("            \t\t<div class=\"col-xs-offset-5 col-sm-offset-4 col-md-offset-5\"></div>\n");
      out.write("\n");
      out.write("        \t\t</div>\n");
      out.write("        \t\t<br><br>\n");
      out.write("        \t\t<div class=\"form-group\">\n");
      out.write("\n");
      out.write("          \t\t\t<label for=\"pref\" class=\"col col-xs-12 col-sm-4 col-md-3 control-label\">都道府県</label>\n");
      out.write("\n");
      out.write("          \t\t\t<div class=\"col col-xs-7 col-sm-4 col-md-3\">\n");
      out.write("\t\t\t\t\t\t");
      out.print( memberInfo.getPrefecture() );
      out.write("\n");
      out.write("\n");
      out.write("                \t</div>\n");
      out.write("\n");
      out.write("                \t<div class=\"col-xs-offset-5 col-sm-offset-4 col-md-offset-6\"></div>\n");
      out.write("\n");
      out.write("              \t</div>\n");
      out.write("              \t<br><br>\n");
      out.write("              \t<div class=\"form-group\">\n");
      out.write("\n");
      out.write("          \t\t\t<label for=\"pref\" class=\"col col-xs-12 col-sm-4 col-md-3 control-label\">市区町村名</label>\n");
      out.write("\n");
      out.write("          \t\t\t<div class=\"col col-xs-7 col-sm-4 col-md-3\">\n");
      out.write("\t\t\t\t\t\t");
      out.print( memberInfo.getAddres1() );
      out.write("\n");
      out.write("\n");
      out.write("                \t</div>\n");
      out.write("                \t\n");
      out.write("\n");
      out.write("                \t<div class=\"col-xs-offset-5 col-sm-offset-4 col-md-offset-6\"></div>\n");
      out.write("\n");
      out.write("              \t</div>\n");
      out.write("              \t<br><br>\n");
      out.write("              \t<div class=\"form-group\">\n");
      out.write("\n");
      out.write("          \t\t\t\n");
      out.write("                \t<label for=\"pref\" class=\"col col-xs-12 col-sm-4 col-md-3 control-label\">番地・ビル名</label>\n");
      out.write("                \t<div class=\"col col-xs-7 col-sm-4 col-md-3\">\n");
      out.write("\t\t\t\t\t\t");
      out.print( memberInfo.getAddres2() );
      out.write("\n");
      out.write("\n");
      out.write("                \t</div>\n");
      out.write("\n");
      out.write("                \t<div class=\"col-xs-offset-5 col-sm-offset-4 col-md-offset-6\"></div>\n");
      out.write("\n");
      out.write("              \t</div>\n");
      out.write("              \t<br><br>\n");
      out.write("              \t<div class=\"form-group\">\n");
      out.write("\n");
      out.write("          \t\t\t\n");
      out.write("                \t<label for=\"pref\" class=\"col col-xs-12 col-sm-4 col-md-3 control-label\">電話番号</label>\n");
      out.write("                \t<div class=\"col col-xs-7 col-sm-4 col-md-3\">\n");
      out.write("\t\t\t\t\t\t");
      out.print( memberInfo.getTel1()  );
      out.write("\n");
      out.write("\n");
      out.write("                \t</div>\n");
      out.write("                \t<div class=\"col col-xs-7 col-sm-4 col-md-3\">\n");
      out.write("\t\t\t\t\t\t");
      out.print(   memberInfo.getTel2()  );
      out.write("\n");
      out.write("\n");
      out.write("                \t</div>\n");
      out.write("                \t<div class=\"col col-xs-7 col-sm-4 col-md-3\">\n");
      out.write("\t\t\t\t\t\t");
      out.print(   memberInfo.getTel3() );
      out.write("\n");
      out.write("\n");
      out.write("                \t</div>\n");
      out.write("\n");
      out.write("                \t<div class=\"col-xs-offset-5 col-sm-offset-4 col-md-offset-6\"></div>\n");
      out.write("\n");
      out.write("              \t</div>\n");
      out.write("              \t<br><br>\n");
      out.write("              \t<div class=\"form-group\">\n");
      out.write("\n");
      out.write("          \t\t\t\n");
      out.write("                \t<label for=\"pref\" class=\"col col-xs-12 col-sm-4 col-md-3 control-label\">メールアドレス</label>\n");
      out.write("                \t<div class=\"col col-xs-7 col-sm-4 col-md-3\">\n");
      out.write("\t\t\t\t\t\t");
      out.print( memberInfo.getMail1() );
      out.write("\n");
      out.write("\n");
      out.write("                \t</div>\n");
      out.write("                \t<input type=\"hidden\" name=\"Member_CSRFToken\" value=");
      out.print(URLEncoder.encode(CSRFT,"UTF-8"));
      out.write(" />\n");
      out.write("\n");
      out.write("                \t<div class=\"col-xs-offset-5 col-sm-offset-4 col-md-offset-6\"></div>\n");
      out.write("\n");
      out.write("              \t</div>\n");
      out.write("              \t\n");
      out.write("\n");
      out.write("              \n");
      out.write("\n");
      out.write("\t\t          <!--  <div class=\"pwstrength_viewport_progress\"></div>-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t          <button type=\"submit\" name=\"go\" class=\"btn btn-lg btn-primary btn-block\">登録を確定</button>\n");
      out.write("\t\t      \n");
      out.write("\n");
      out.write("\t\t        </form>\n");
      out.write("\t\t        <form class=\"well\"action=\"");
      out.print(request.getContextPath() );
      out.write("/MemberNew\" method=\"POST\" >\n");
      out.write("\t\t        <button type=\"submit\" name=\"go\" class=\"btn btn-lg btn-primary btn-block\">訂正</button></form>\n");
      out.write("\t\t       </section>\n");
      out.write("\t\t      </div>\n");
      out.write("\t\t    <div class=\"col-md-4\"></div>\n");
      out.write("\t\t   </div>\n");
      out.write("\t\t </div>\n");
      out.write("\t\t\n");
      out.write("  </body>\n");
      out.write("  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("  <!-- Include all compiled plugins (below), or include individual files as needed -->\n");
      out.write("  <script src=\"view/img/js/bootstrap.min.js\"></script>\n");
      out.write("  <script src=\"view/img/js/bookstore.js\"></script>\n");
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
