<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--|----------------------------------子页面 BEG---------------------------------|-->
	
	<!--|==================================子页面 END=================================|-->
	<youi:form id="form_user" caption="查询用户" action="esb/load/userManager/getPagerUsers.json">
		<youi:fieldLayout>
			<youi:fieldText property="userId" notNull="true" caption="用户ID"></youi:fieldText>
		</youi:fieldLayout>
	</youi:form>
	
	<!--|----------------------------------页面内容  BEG-------------------------------|-->
	
	<!--|==================================页面内容  END===============================|-->
	
	<div id="container"></div>
	<!--|----------------------------------页面函数  BEG-------------------------------|-->
	<youi:func name="form_user_afterSubmit" params="result">
		$('#container').html(JSON.stringify(result));
	</youi:func>
	<!--|==================================页面函数  END===============================|-->
</youi:page>