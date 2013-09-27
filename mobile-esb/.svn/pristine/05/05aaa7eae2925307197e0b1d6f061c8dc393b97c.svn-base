<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-服务输入列表-->
	<youi:grid id="grid_esbServiceInput" idKeys="esbServiceInputId" dataFormId="form_esbServiceInput"  caption="服务输入列表" 
				src="/esbmng/esbServiceInput/getPagerEsbServiceInputs.json" 
				editSrc="/esbmng/esbServiceInput/getEsbServiceInput.json"
				removeSrc="/esbmng/esbServiceInput/removeEsbServiceInput.json" panel="false">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="nameExpression"  caption="属性表达式"/>
			<youi:fieldText property="esbServiceInputCaption"  caption="服务输入描述"/>
			<youi:fieldText property="inputExpression"  caption="值表达式"/>

		</youi:fieldLayout>
		
		<youi:gridCol property="nameExpression"  caption="属性表达式"/>
		<youi:gridCol property="esbServiceInputCaption"  caption="服务输入描述"/>
		<youi:gridCol property="inputExpression"  caption="值表达式"/>

	</youi:grid>
	
	<!-- form-服务输入编辑 -->
	<youi:form dialog="true" caption="服务输入" id="form_esbServiceInput" idKeys="esbServiceInputId"
		action="/esbmng/esbServiceInput/saveEsbServiceInput.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="nameExpression"  caption="属性表达式"/>
			<youi:fieldText property="esbServiceInputCaption"  caption="服务输入描述"/>
			<youi:fieldText property="inputExpression"  caption="值表达式"/>
			<youi:fieldText property="esbServiceInputId"  caption="服务输入主键"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>