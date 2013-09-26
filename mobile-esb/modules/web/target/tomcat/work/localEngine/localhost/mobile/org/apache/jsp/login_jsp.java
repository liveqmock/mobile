package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/pages/include.jsp");
    _jspx_dependants.add("/WEB-INF/youi.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fyoui_005fstyle_0026_005fhref_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fauthenticated;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fyoui_005fstyle_0026_005fhref_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fshiro_005fauthenticated = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fyoui_005fstyle_0026_005fhref_005fnobody.release();
    _005fjspx_005ftagPool_005fshiro_005fauthenticated.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/lib/jquery-1.9.1.min.js\" type=\"text/javascript\" ></script>\r\n");
      if (_jspx_meth_youi_005fstyle_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<title>邮储监控系统登陆</title>\r\n");
      out.write("\r\n");

	String username = request.getParameter("username");
	request.setAttribute("username",username);

      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("    \tfunction changeRandcode(){\r\n");
      out.write("\t\t\tdocument.getElementById('img_randCode').src='Kaptcha.jpg?timeStamp='+new Date().getTime();\r\n");
      out.write("\t\t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t$(function(){\r\n");
      out.write("    \t\t//已经登录或者在嵌套的pageContent容器中，重定位到主页面\r\n");
      out.write("    \t\tif($('#hasLogin').val()=='true'||$('.youi-page-content').length){\r\n");
      out.write("    \t\t\twindow.location.href = '");
      out.print(request.getContextPath());
      out.write("/index.jsp';\r\n");
      out.write("    \t\t\treturn;\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\tvar usernameElem = $('input[name=username]');\r\n");
      out.write("    \t\tvar passwordElem = $('input[name=password]');\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\tvar defaultUser = usernameElem.val();\r\n");
      out.write("    \t\tif(defaultUser=='user'||defaultUser=='cash'){\r\n");
      out.write("    \t\t\tpasswordElem.val('123456');\r\n");
      out.write("    \t\t\t$('input:submit').click();\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\t/**\r\n");
      out.write("    \t\t$('form.login-form').bind('submit',function(){\r\n");
      out.write("    \t\t\t$.ajax({\r\n");
      out.write("    \t\t\t\turl:'login.jsp?json=true&username=1&password=2',\r\n");
      out.write("    \t\t\t\ttype:'POST',\r\n");
      out.write("    \t\t\t\tsuccess:function(result){\r\n");
      out.write("    \t\t\t\t\talert(result);\r\n");
      out.write("    \t\t\t\t}\r\n");
      out.write("    \t\t\t});\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t\treturn false;\r\n");
      out.write("    \t\t});*/\r\n");
      out.write("    \t});\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      if (_jspx_meth_shiro_005fauthenticated_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"document.f.username.focus();\" class=\"login-bg-h\">\r\n");
      out.write("\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" class=\"login-bg\" align=\"center\">\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\" style=\"height: 50px;\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"30%\"></td>\r\n");
      out.write("\t\t\t\t<td width=\"60%\" class=\"\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"login-form-bg login-main\">\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"login-form\" name=\"f\" action=\"\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table class=\"login-table\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"left\"  valign=\"middle\" height=\"38px\"><input class=\"login-input\" type='text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname='username' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("' /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"left\"  valign=\"middle\" height=\"32px\"><input class=\"login-password\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype='password' name='password' value='123456'></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"login-buttons\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<table width=\"240px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td width=\"90px\"><input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"login-form-bg login-button login-submit\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tname=\"submit\" type=\"submit\" value=\" \"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"login-form-bg login-button login-reset\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tname=\"reset\" type=\"reset\" value=\" \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div style=\"padding-left:25px;height:30px;color:red;font-weight:bold;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t<td width=\"20%\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_youi_005fstyle_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  youi:style
    com.gsoft.framework.taglib.StyleTag _jspx_th_youi_005fstyle_005f0 = (com.gsoft.framework.taglib.StyleTag) _005fjspx_005ftagPool_005fyoui_005fstyle_0026_005fhref_005fnobody.get(com.gsoft.framework.taglib.StyleTag.class);
    _jspx_th_youi_005fstyle_005f0.setPageContext(_jspx_page_context);
    _jspx_th_youi_005fstyle_005f0.setParent(null);
    // /login.jsp(8,0) name = href type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_youi_005fstyle_005f0.setHref("/styles/login/login.css");
    int[] _jspx_push_body_count_youi_005fstyle_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_youi_005fstyle_005f0 = _jspx_th_youi_005fstyle_005f0.doStartTag();
      if (_jspx_th_youi_005fstyle_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_youi_005fstyle_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_youi_005fstyle_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_youi_005fstyle_005f0.doFinally();
      _005fjspx_005ftagPool_005fyoui_005fstyle_0026_005fhref_005fnobody.reuse(_jspx_th_youi_005fstyle_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_shiro_005fauthenticated_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:authenticated
    org.apache.shiro.web.tags.AuthenticatedTag _jspx_th_shiro_005fauthenticated_005f0 = (org.apache.shiro.web.tags.AuthenticatedTag) _005fjspx_005ftagPool_005fshiro_005fauthenticated.get(org.apache.shiro.web.tags.AuthenticatedTag.class);
    _jspx_th_shiro_005fauthenticated_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fauthenticated_005f0.setParent(null);
    int _jspx_eval_shiro_005fauthenticated_005f0 = _jspx_th_shiro_005fauthenticated_005f0.doStartTag();
    if (_jspx_eval_shiro_005fauthenticated_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t<!-- authenticated -->\r\n");
        out.write("\t<input id=\"hasLogin\" value=\"true\"/>\r\n");
        int evalDoAfterBody = _jspx_th_shiro_005fauthenticated_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fauthenticated_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fauthenticated.reuse(_jspx_th_shiro_005fauthenticated_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fauthenticated.reuse(_jspx_th_shiro_005fauthenticated_005f0);
    return false;
  }
}
