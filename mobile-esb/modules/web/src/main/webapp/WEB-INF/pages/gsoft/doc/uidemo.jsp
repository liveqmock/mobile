<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	
	<!--**********************************页面内容********************************-->
	<input type="text" id="autocomplete"></input>
	<!--**********************************页面内容********************************-->

	<!--**********************************页面函数********************************-->
	<youi:func name="init">
		$('#autocomplete').autocomplete({
			source:['aaaa','acced','bddfds']
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>