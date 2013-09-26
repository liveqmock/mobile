package org.apache.jsp.decorators.youi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/pages/include.jsp");
    _jspx_dependants.add("/WEB-INF/youi.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/decorators/youi/main.css\" type=\"text/css\" rel=\"stylesheet\"></link>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/decorators/youi/menu.css\" type=\"text/css\" rel=\"stylesheet\"></link>\r\n");
      out.write("<script type=\"text/javascript\" >\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/decorators/youi/menu.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/decorators/youi/layout.js\"></script>\r\n");
      out.write("<div class=\"header-bg\" style=\"min-width:800\">\r\n");
      out.write("\t<table height=\"60px;\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"header-bg-logo\" width=\"500px\"></td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<div style=\"float:left;margin-left:120px;color:white;font-weight:bold;\">\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t    <script>\r\n");
      out.write("\t\t\t\t\t    var date = new Date();\r\n");
      out.write("\t\t\t\t\t    var year = date.getFullYear();\r\n");
      out.write("\t\t\t\t\t    var month = date.getMonth()+1;\r\n");
      out.write("\t\t\t\t\t    var day = date.getDate();\r\n");
      out.write("\t\t\t\t\t    var hours = date.getHours();\r\n");
      out.write("\t\t\t\t\t    var hello = \"您好\";\r\n");
      out.write("\t\t\t\t\t    if (hours >=5 && hours < 12) {\r\n");
      out.write("\t\t\t\t\t    hello = \"早上好\";\r\n");
      out.write("\t\t\t\t\t    } else if (hours >= 8 && hours < 12){\r\n");
      out.write("\t\t\t\t\t    hello = \"上午好\";\r\n");
      out.write("\t\t\t\t\t    } else if (hours >= 12 && hours < 14){\r\n");
      out.write("\t\t\t\t\t    hello = \"中午好\";\r\n");
      out.write("\t\t\t\t\t    } else if (hours >= 14 && hours < 17){\r\n");
      out.write("\t\t\t\t\t    hello = \"下午好\";\r\n");
      out.write("\t\t\t\t\t    } else if (hours >= 17 && hours < 23){\r\n");
      out.write("\t\t\t\t\t    hello = \"晚上好\";\r\n");
      out.write("\t\t\t\t\t    } else if (hours > 23 || hours < 5){\r\n");
      out.write("\t\t\t\t\t    hello = \"夜里好\";\r\n");
      out.write("\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t    document.write(hello+\"，");
      if (_jspx_meth_shiro_005fprincipal_005f0(_jspx_page_context))
        return;
      out.write("！今天是\"+year+\"年\"+month+\"月\"+day+\"日\");\r\n");
      out.write("\t\t\t\t    </script>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"200\">\r\n");
      out.write("\t\t\t\t<div style=\"float:right;margin-right:20px\"><a href=\"logout.jsp\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/decorators/youi/images/esc.jpg\" width=\"55\" height=\"61\" border=\"0\"></a></div>\r\n");
      out.write("\t\t\t\t<div style=\"float:right;margin-right:10px\"><a href=\"###\" id=\"modify_password\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/decorators/youi/images/xgmm.jpg\" width=\"53\" height=\"61\" border=\"0\"></a></div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_shiro_005fprincipal_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_005fprincipal_005f0 = (org.apache.shiro.web.tags.PrincipalTag) _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_005fprincipal_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fprincipal_005f0.setParent(null);
    int _jspx_eval_shiro_005fprincipal_005f0 = _jspx_th_shiro_005fprincipal_005f0.doStartTag();
    if (_jspx_th_shiro_005fprincipal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
    return false;
  }
}
