package com.gsoft.framework.decorators;

import org.dom4j.Document;

public class YouiDecoratorLayout extends com.gsoft.framework.taglib.layout.BorderLayout{

	public YouiDecoratorLayout(String decorator, Document document) {
		super(decorator, document);
	}

	@Override
	protected String buildContentPrefix() {
		StringBuffer htmls = new StringBuffer();
		htmls.append("<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">")
		.append("  <tbody>")
		.append("    <tr><td class=\"youi-body-tl\" width=\"15\" valign=\"top\"><div></div></td>")
		.append("    <td class=\"youi-body-tc\" valign=\"top\">")
		.append("	</td>")
		.append("    <td class=\"youi-body-tr\" width=\"15\" valign=\"top\"><div></div></td>")
		.append("  </tr>")
		.append("  <tr>")
		.append("    <td class=\"youi-body-ml\" valign=\"middle\">&nbsp;</td>")
		.append("    <td class=\"youi-body-mc\" bgcolor=\"#F7F8F9\" valign=\"top\">")
		
		.append("		<div class=\"youi-page-content adapt-width\">")
		.append("		<div class=\"tabs-header page-tabs-header\"><ul class=\"tabs-items\"/></div>");
		return htmls.toString();
	}

	@Override
	protected String buildContentPostfix() {
		
		StringBuffer htmls = new StringBuffer();
		htmls.append("    </div></td>")
		.append("    <td class=\"youi-body-mr\">&nbsp;</td>")
		.append("  </tr>")
		.append("  <tr>")
		.append("    <td class=\"youi-body-bl\"  valign=\"bottom\"><div></div></td>")
		.append("    <td class=\"youi-body-bc\"><div></div></td>")
		.append("    <td class=\"youi-body-br\" valign=\"bottom\"><div></div></td>")
		.append("  </tr>")
		.append("</tbody></table>");
		
		return htmls.toString();
	}

	
}
