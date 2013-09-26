<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<youi:subpage id="subpage_esb_flow_design" caption="流程设计" subpageId="esbFlowDesign"
		 type="window" src="/page/esb.flow/design.html">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-服务流列表-->
	<youi:grid id="grid_esbServiceFlow" dataFormId="form_esbServiceFlow"  caption="服务流列表" 
				src="/esbmng/esbServiceFlow/getPagerEsbServiceFlows.json" 
				editSrc="/esbmng/esbServiceFlow/getEsbServiceFlow.json" idKeys="flowId"
				removeSrc="/esbmng/esbServiceFlow/removeEsbServiceFlow.json" panel="false">
		<youi:fieldLayout labelWidths="120,120" columns="1">
			<youi:fieldText property="flowCaption"  caption="服务流描述"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="flowCaption" width="200" caption="服务流描述"/>
		<youi:gridCol property="flowStatus" width="100" caption="流程状态"/>
		<youi:gridCol property="updateTime" width="180" caption="流程更新时间" type="date" 
			format="yyyyMMddHHmmss" textFormat="yyyy-MM-dd HH:mm:ss"/>
		<youi:gridCol property="createTime" width="180" caption="流程启动时间" type="date" 
			format="yyyyMMddHHmmss" textFormat="yyyy-MM-dd HH:mm:ss"/>
		<youi:gridCol property="flowDeployPath" width="300" caption="部署路径"/>
		
		<youi:button name="design" order="201" caption="设计"></youi:button>
		<youi:button name="run" order="202" caption="启动" submitAction="/esbmng/esbServiceFlow/runFlow.json"/>
		<youi:button name="stop" order="202" caption="停止" submitAction="/esbmng/esbServiceFlow/stopFlow.json"/>
		<youi:button name="startFlow" order="203"  caption="执行流程"  submitAction="/esbmng/esbServiceFlow/startInstance.json"></youi:button>
	</youi:grid>
	
	<!-- form-服务流编辑 -->
	<youi:form dialog="true" caption="服务流" id="form_esbServiceFlow" idKeys="esbServiceId"
		action="/esbmng/esbServiceFlow/saveEsbServiceFlow.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120" columns="1">
			<youi:fieldHidden property="flowId"  caption="服务流主键"/>
			<youi:fieldText property="flowCaption"  caption="服务流描述"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="func_grid_design">
		var subpageElement = $elem('subpage_esb_flow_design',pageId),
			gridElement = $elem('grid_esbServiceFlow',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		subpageElement.subpage('open',selectedRecord);
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>