<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@page import="org.youi.common.util.PropertyUtils"%>
<%
	java.util.Map<String,String[]>  pMap = request.getParameterMap();
	java.util.Set<String> parameterNames = pMap.keySet();
	String[] values = null;
	StringBuffer buf = new StringBuffer();
	for(String parameterName:parameterNames){
		values = pMap.get(parameterName);
		if(values!=null&&values.length>0){
			for(String value:values){
				if(value!=null&&!"".equals(value)){
					buf.append("<input type=\"hidden\" name=\"");
					buf.append(parameterName);
					buf.append("\" value=\"");
					buf.append(value);
					buf.append("\"/>");
				}
			}
		}
		values = null;
	}
	
	Object exportXls = request.getParameter("export:xls");
	if(exportXls!=null){
		request.setAttribute("exportXls",true);
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition","attachment;"+ "filename=\""+new String("表格数据".getBytes("gb2312"), "iso8859-1")+".xls\"");
	}
%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>打印数据</title>
		<meta content="text/html; charset=UTF-8" http-equiv="content-type">
		<script src="<%=request.getContextPath()%>/scripts/lib/jquery-1.4.js" type="text/javascript"></script>
		<script>
			function exportExcel(){
				var url = window.location.href+'&export:xls==true';
				//window.location.href = href;
				var htmls = '<%=buf.toString()%>';
				htmls+='<input type="hidden" name="export:xls" value="true"/>';
				$('#export_form').html(htmls).submit();
			}
		</script>
		<style>
			 @media print{
			 	.noprint{display:none;}
				 table{
				 	margin-top:50px;
				 }
				 
			 } 
			 
			 table td.cell{
			 	text-align:center;
			 	border:1pt solid black;
			 	padding:2px;
			 	font-size:11pt;
			 }
			 
			 table tr.header td.cell{
			 	background:silver;
			 }
			 
			 table tr.row1 td.cell{
			 	background-color:#F5F5FE;
			 }
		</style>
	</head>
	<body>
		<table cellspacing="0" cellspacing="0" style="empty-cells:show;border-collapse:collapse;" align="center">
			<c:if test="${exportXls==null}">
			<tr class="noprint">
				<c:forEach items="${pagerRecords.pager.exportHeaders}" var="exportHeader" varStatus="status">
					<c:if test="${status.last==true}">
					<td height="30" style="text-align:left;" colspan="${status.index+1}">
						【<a onclick="window.print();" href="#">打印</a>】
						【<a onclick="window.close();" href="#">关闭</a>】
						【<a onclick="exportExcel();" href="#">导出EXCEL</a>】
					</td>
					</c:if>
				</c:forEach>
			</tr>
			</c:if>
			<tr class="header">
				<c:forEach items="${pagerRecords.pager.exportHeaders}" var="exportHeader">
					<td class="cell"> ${exportHeader}</td>
				</c:forEach>
			</tr>
			
			<c:forEach items="${pagerRecords.records}" var="record" varStatus="varStatus">
			<tr class="row${varStatus.index%2}">
				<c:forEach items="${pagerRecords.pager.exportProperties}" var="exportProperty">
					<td class="cell">
						<% 
							Object value = null;
							try{
								value = PropertyUtils.getPropertyValue(
									pageContext.getAttribute("record"),
									pageContext.getAttribute("exportProperty").toString());
							}catch(Exception e){
								value = "";
							}
						%>
						<%=value==null?"":value%>
					</td>
				</c:forEach>
			</tr>
			</c:forEach>
		</table>
		<form id="export_form" style="display:none;" method="post" target="_blank">
		
		</form>
	</body>	
</html>
