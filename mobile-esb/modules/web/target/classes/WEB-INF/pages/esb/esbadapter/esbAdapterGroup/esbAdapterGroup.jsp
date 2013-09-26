<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-适配器分类列表-->
	<youi:grid id="grid_esbAdapterGroup" idKeys="esbAdapterGroupId" dataFormId="form_esbAdapterGroup"  caption="适配器分类列表" 
				src="/esbadapter/esbAdapterGroup/getPagerEsbAdapterGroups.json" 
				editSrc="/esbadapter/esbAdapterGroup/getEsbAdapterGroup.json"
				removeSrc="/esbadapter/esbAdapterGroup/removeEsbAdapterGroup.json" panel="false">
		<youi:fieldLayout labelWidths="120,120">

			<youi:fieldText property="esbAdapterGroupCaption"  caption="适配器分类描述"/>
		</youi:fieldLayout>
		

		<youi:gridCol property="esbAdapterGroupCaption"  caption="适配器分类描述"/>
	</youi:grid>
	
	<!-- form-适配器分类编辑 -->
	<youi:form dialog="true" caption="适配器分类" id="form_esbAdapterGroup" idKeys="esbAdapterGroupId"
		action="/esbadapter/esbAdapterGroup/saveEsbAdapterGroup.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="esbAdapterGroupId"  caption="适配器分类主键"/>
			<youi:fieldText property="esbAdapterGroupCaption"  caption="适配器分类描述"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>