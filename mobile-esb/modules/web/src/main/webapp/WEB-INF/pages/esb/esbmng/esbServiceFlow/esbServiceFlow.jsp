<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-服务流列表-->
	<youi:grid id="grid_esbServiceFlow" idKeys="esbServiceId" dataFormId="form_esbServiceFlow"  caption="服务流列表" 
				src="/esbmng/esbServiceFlow/getPagerEsbServiceFlows.json" 
				editSrc="/esbmng/esbServiceFlow/getEsbServiceFlow.json"
				removeSrc="/esbmng/esbServiceFlow/removeEsbServiceFlow.json" panel="false">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="esbServiceCaption"  caption="服务流描述"/>

		</youi:fieldLayout>
		
		<youi:gridCol property="esbServiceCaption"  caption="服务流描述"/>

	</youi:grid>
	
	<!-- form-服务流编辑 -->
	<youi:form dialog="true" caption="服务流" id="form_esbServiceFlow" idKeys="esbServiceId"
		action="/esbmng/esbServiceFlow/saveEsbServiceFlow.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="esbServiceCaption"  caption="服务流描述"/>
			<youi:fieldText property="esbServiceId"  caption="服务流主键"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>