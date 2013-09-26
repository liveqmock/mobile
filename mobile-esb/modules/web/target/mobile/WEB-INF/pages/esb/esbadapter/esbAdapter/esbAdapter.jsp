<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-服务适配器列表-->
	<youi:grid id="grid_esbAdapter" idKeys="esbAdapterId" dataFormId="form_esbAdapter"  caption="服务适配器列表" 
				src="/esbadapter/esbAdapter/getPagerEsbAdapters.json" 
				editSrc="/esbadapter/esbAdapter/getEsbAdapter.json"
				removeSrc="/esbadapter/esbAdapter/removeEsbAdapter.json" panel="false">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="esbAdapterCaption"  caption="服务适配器描述"/>

		</youi:fieldLayout>
		
		<youi:gridCol property="esbAdapterCaption" width="200" caption="服务适配器描述"/>
		<youi:gridCol property="esbAdapterUrl" width="300" caption="URL地址"/>
		<youi:gridCol property="esbAdapterPort"  caption="端口"/>
		
		<youi:gridCol property="esbAdapterGroup.esbAdapterGroupCaption"  caption="适配器类型"/>
	</youi:grid>
	
	<!-- form-服务适配器编辑 -->
	<youi:form dialog="true" caption="服务适配器" id="form_esbAdapter" idKeys="esbAdapterId"
		action="/esbadapter/esbAdapter/saveEsbAdapter.json">
		<youi:fieldLayout prefix="record" columns="1"  labelWidths="120,120">
			<youi:fieldHidden property="esbAdapterId" caption="服务适配器ID"/>
			<youi:fieldText property="esbAdapterCaption"  width="602" caption="服务适配器描述"/>
			<youi:fieldText property="esbAdapterUrl" width="602" caption="服务适配器URL"/>
			<youi:fieldText property="esbAdapterPort" width="602" caption="端口"/>
			<youi:fieldSelect property="esbAdapterGroup.esbAdapterGroupId" width="602"  caption="适配器类型"
				src="/esbadapter/esbAdapterGroup/getEsbAdapterGroups.json" show="esbAdapterGroupId" code="esbAdapterGroupCaption"/>
		
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>