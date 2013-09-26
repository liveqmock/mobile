<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<table>
	<tr>
		<c:forEach items="${pagerRecords.pager.exportHeaders}" var="exportHeader">
			<td>${exportHeader}</td>
		</c:forEach>
	</tr>
	
	<c:forEach items="${pagerRecords.records}" var="record">
	<tr>
		<c:forEach items="${pagerRecords.pager.exportProperties}" var="exportProperty">
			<td>
				${record[exportProperty]}
			</td>
		</c:forEach>
	</tr>
	</c:forEach>
</table>
