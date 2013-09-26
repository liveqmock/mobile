<%@page import="org.youi.common.util.PropertyUtils"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<table border="1" cellspacing="0" style="empty-cells:show;" align="center">
	<tr>
		<c:forEach items="${pagerRecords.pager.exportHeaders}" var="exportHeader">
			<td>${exportHeader}</td>
		</c:forEach>
	</tr>
	
	<c:forEach items="${pagerRecords.records}" var="record">
	<tr>
		<c:forEach items="${pagerRecords.pager.exportProperties}" var="exportProperty">
			<td>
				<% 
					Object value = PropertyUtils.getPropertyValue(pageContext.getAttribute("record"),pageContext.getAttribute("exportProperty").toString());
				%>
				<%=value==null?"":value%>
			</td>
		</c:forEach>
	</tr>
	</c:forEach>
</table>