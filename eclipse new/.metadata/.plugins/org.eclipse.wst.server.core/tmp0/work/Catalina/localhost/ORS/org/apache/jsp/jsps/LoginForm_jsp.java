/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.75
 * Generated at: 2018-04-12 21:19:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function emptyvalidation(entered, alertbox)\r\n");
      out.write("{\r\n");
      out.write("\r\n");
      out.write("with (entered)\r\n");
      out.write("{\r\n");
      out.write("if (value==null || value==\"\")\r\n");
      out.write("{if (alertbox!=\"\") {alert(alertbox);} return false;}\r\n");
      out.write("else {return true;}\r\n");
      out.write("}\r\n");
      out.write("} \r\n");
      out.write("\r\n");
      out.write("function formvalidation(thisform)\r\n");
      out.write("{\r\n");
      out.write("with (thisform)\r\n");
      out.write("{\r\n");
      out.write("if (emptyvalidation(username,\"Please Enter An User Name\")==false) {username.focus(); return false;};\r\n");
      out.write("if (emptyvalidation(password,\"Please Enter A Password\")==false) {password.focus(); return false;};\r\n");
      out.write("}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body topmargin=\"0\" leftmargin=\"0\"  marginwidth=\"0\" marginheight=\"0\" background=");
      out.print(request.getContextPath()+"/images/web-background.png" );
      out.write(" >\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<table width=\"100%\" align=\"left\" border=\"0\" style=\"vertical-align: top;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"1\" width=\"900\" height=\"300\" valign=\"top\">\r\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menubeforelogin.jsp", out, false);
      out.write("<br/>&nbsp;&nbsp;&nbsp; \r\n");
      out.write("\t\t\t\t<font color=\"#1B577C\" size=\"4\"><b><i>Login Here...</i></b></font>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "statusmsg.jsp", out, false);
      out.write("      \r\n");
      out.write("          <form action=");
      out.print(request.getContextPath()+"/LoginAction" );
      out.write(" method=post onsubmit=\"return formvalidation(this)\">\r\n");
      out.write("        <table  border=\"0\" align=\"center\"  bgcolor=\"white\" width=\"80%\">\r\n");
      out.write("               <tr>\r\n");
      out.write("                 <td height=\"120\" align=\"right\"></td>\r\n");
      out.write("                 <td><table border=\"0\" align=\"center\">\r\n");
      out.write("                   <tr>\r\n");
      out.write("                     <td ><span class=\"Title\"><font color=\"#1B577C\"><b>UserID</b></font></span></td>\r\n");
      out.write("                      <td ><input type=\"#1B577C\" name=\"username\"/>                      </td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                   <tr>\r\n");
      out.write("                     <td><span class=\"Title\"><font color=\"#1B577C\"><b>Password</b></font></span></td>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <input type=\"password\" name=\"password\"/>                      </td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                     <td colspan=\"2\"><p><br/></p></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                   <tr>\r\n");
      out.write("                     <td colspan=\"2\" align=\"center\">\r\n");
      out.write("                         <input type=\"image\" src=");
      out.print(request.getContextPath()+"/images/LOGINBUTTON.jpg" );
      out.write(" height=\"30\" width=\"100\"/>\r\n");
      out.write("                     </td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                 </table></td>\r\n");
      out.write("                 <td>&nbsp;</td>\r\n");
      out.write("               </tr>\r\n");
      out.write("               <tr>\r\n");
      out.write("                 <td >&nbsp;</td>\r\n");
      out.write("                 <td>\r\n");
      out.write("                 <div align=\"center\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/jsps/Recoverpassword.jsp\"><strong><font color=\"#1B577C\">Forgot Password ! !......</font></strong></a></div></td>\r\n");
      out.write("                 <td>&nbsp;</td>\r\n");
      out.write("               </tr>\r\n");
      out.write("               \r\n");
      out.write("               \r\n");
      out.write("             </table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("          </form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\" valign=\"bottom\">\r\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
