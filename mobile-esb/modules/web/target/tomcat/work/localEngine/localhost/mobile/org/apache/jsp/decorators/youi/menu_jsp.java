package org.apache.jsp.decorators.youi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/pages/include.jsp");
    _jspx_dependants.add("/WEB-INF/youi.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fyoui_005fsysVertMenu_0026_005fid_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fyoui_005fsysVertMenu_0026_005fid_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fyoui_005fsysVertMenu_0026_005fid_005fnobody.release();
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
      out.write("<script>\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$('#system_v_menu').sysmenu({\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- 纵向系统菜单 -->\r\n");
      out.write("<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\r\n");
      out.write("\tborder=\"0\" bgcolor=\"#EEF2FB\">\r\n");
      out.write("\t<tbody>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"5px;\" class=\"menu-container-top\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"182\" valign=\"top\">\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_youi_005fsysVertMenu_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\r\n");
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

  private boolean _jspx_meth_youi_005fsysVertMenu_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  youi:sysVertMenu
    com.gsoft.framework.taglib.menu.SysVertMenuTag _jspx_th_youi_005fsysVertMenu_005f0 = (com.gsoft.framework.taglib.menu.SysVertMenuTag) _005fjspx_005ftagPool_005fyoui_005fsysVertMenu_0026_005fid_005fnobody.get(com.gsoft.framework.taglib.menu.SysVertMenuTag.class);
    _jspx_th_youi_005fsysVertMenu_005f0.setPageContext(_jspx_page_context);
    _jspx_th_youi_005fsysVertMenu_005f0.setParent(null);
    // /decorators/youi/menu.jsp(21,4) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_youi_005fsysVertMenu_005f0.setId("system_v_menu");
    int[] _jspx_push_body_count_youi_005fsysVertMenu_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_youi_005fsysVertMenu_005f0 = _jspx_th_youi_005fsysVertMenu_005f0.doStartTag();
      if (_jspx_th_youi_005fsysVertMenu_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_youi_005fsysVertMenu_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_youi_005fsysVertMenu_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_youi_005fsysVertMenu_005f0.doFinally();
      _005fjspx_005ftagPool_005fyoui_005fsysVertMenu_0026_005fid_005fnobody.reuse(_jspx_th_youi_005fsysVertMenu_005f0);
    }
    return false;
  }
}
