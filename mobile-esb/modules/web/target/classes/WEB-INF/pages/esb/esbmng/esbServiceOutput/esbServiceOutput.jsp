<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-服务输出列表-->
	<youi:grid id="grid_esbServiceOutput" idKeys="esbServiceOutputId" dataFormId="form_esbServiceOutput"  caption="服务输出列表" 
				src="/esbmng/esbServiceOutput/getPagerEsbServiceOutputs.json" 
				editSrc="/esbmng/esbServiceOutput/getEsbServiceOutput.json"
				removeSrc="/esbmng/esbServiceOutput/removeEsbServiceOutput.json" panel="false">
		<youi:fieldLayout labelWidths="120,120">

			<youi:fieldText property="paramName"  caption="参数名"/>
			<youi:fieldText property="outputCaption"  caption="输出描述"/>
		</youi:fieldLayout>
		

		<youi:gridCol property="paramName"  caption="参数名"/>
		<youi:gridCol property="outputCaption"  caption="输出描述"/>
	</youi:grid>
	
	<!-- form-服务输出编辑 -->
	<youi:form dialog="true" caption="服务输出" id="form_esbServiceOutput" idKeys="esbServiceOutputId"
		action="/esbmng/esbServiceOutput/saveEsbServiceOutput.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="esbServiceOutputId"  caption="服务输出主键"/>
			<youi:fieldText property="paramName"  caption="参数名"/>
			<youi:fieldText property="outputCaption"  caption="输出描述"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>