<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<youi:subpage id="subpage_flow_design" caption="流程设计" subpageId="flowDesign"
		 type="window" src="/page/workflow.flow/design.html">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-流程列表-->
	<youi:grid id="grid_flow" idKeys="flowId" dataFormId="form_flow"  caption="流程列表" 
				src="/workflow/flow/getPagerFlows.json" 
				editSrc="/workflow/flow/getFlow.json" panel="false"
				removeSrc="/workflow/flow/removeFlow.json">
		<youi:fieldLayout>
			<youi:fieldText property="flowCaption"  caption="流程描述"></youi:fieldText>
			<youi:fieldText property="status"  caption="流程状态"></youi:fieldText>
		</youi:fieldLayout>
		
		<youi:gridCol width="200" property="flowCaption"  caption="流程描述"/>
		<youi:gridCol width="180" property="flowName"  caption="流程定义"/>
		<youi:gridCol property="status"  caption="部署状态"/>
		<youi:gridCol width="160" property="deployTime"  caption="部署时间"/>
		<youi:gridCol property="deployId"  caption="部署 "/>
		<youi:gridCol property="version"  caption="版本号"/>
		
		<youi:button name="upload" caption="上传" active="1" order="201"/>
		<youi:button name="design" caption="设计" active="1" order="201"/>
		<youi:button name="deploy" caption="部署"  order="202" active="1" submitAction="/workflow/flow/deploy.json" submitConfirmMsg="确认部署流程?"/>
		<youi:button name="deployForm" caption="表单部署" order="203" active="1" submitAction="/workflow/flow/deployForm.json" submitConfirmMsg="确认部署表单?"/>
	</youi:grid>
	
	<!-- form-流程编辑 -->
	<youi:form dialog="true" caption="流程" id="form_flow" idKeys="flowName" action="/workflow/flow/saveFlow.json">
		<youi:fieldLayout prefix="record" columns="1">
			<youi:fieldHidden property="flowId"  caption="流程ID"/>
			<youi:fieldHidden property="deployTime"  caption="部署时间"/>
			<youi:fieldHidden property="status"  caption="流程状态"/>
			
			<youi:fieldText width="602" notNull="true" property="flowName"  caption="流程名"/>
			<youi:fieldText width="602" notNull="true" property="flowCaption"  caption="流程描述"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	
	<youi:form dialog="true" id="form_upload" caption="流程上传" action="/workflow/flow/uploadFlow.json">
		<youi:fieldLayout prefix="upload" columns="1">
			<youi:fieldHidden property="flowId"  caption="流程ID"/>
			<youi:fieldLabel property="flowCaption"  caption="流程描述"/>
			<youi:fieldFile property="contentFile" caption="流程文件"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<!-- 流程文件上传 -->
	<youi:func name="func_grid_upload">
		var gridElement = $elem('grid_flow',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		
		$elem('form_upload',pageId).form('reset').form('fillRecord',selectedRecord).form('open');
	</youi:func>
	
	<youi:func name="func_grid_design">
		var subpageElement = $elem('subpage_flow_design',pageId),
			gridElement = $elem('grid_flow',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		subpageElement.subpage('open',selectedRecord);
	</youi:func>
	
	<youi:func name="form_upload_afterSubmit" params="result">
		$elem('form_upload',pageId).form('close');
		$elem('grid_flow',pageId).grid('refresh');
	</youi:func>
	
	<!--**********************************页面函数********************************-->
</youi:page>