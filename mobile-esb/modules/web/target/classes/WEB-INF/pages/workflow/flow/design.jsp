<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:html title="工作流设计器">
	<head>
		<%@ include file="/WEB-INF/pages/common/commonScriptAndCss.jsp"%>
		<script src="<%=request.getContextPath()%>/scripts/lib/jquery.ui.selectable.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/scripts/youi/youi.workflowDesigner.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/scripts/youi/youi.workflow.js" type="text/javascript"></script>
		
		<youi:script src="/scripts/youi/youi.propertyTable.js"/>
		<youi:script src="/scripts/youi/youi.xeditor.js"/>
		
		<youi:style href="/styles/youi.workflow.css"/>
		<youi:style href="/styles/youi.propertyTable.css"/>
		
		<style>
			body{
				padding:0px;margin:0px;
			}
			#youi_log{
				height:300px;
				overflow-y:auto;
				overflow-x:hidden;
			}
			
			.xml-line{
				color:#3F7F7F;
			}
			.attr-key{
				color:#7F007F;
			}
			
			.attr-value{
				color:blue;
			}
			
			.youi-tabs .tabs-panel{
				position:relative;
			}
		</style>
	</head>
	
	<body>
		<%
			//TODO 移植到后台
			request.setAttribute("flowId",request.getParameter("flowId"));
		%>
		<youi:form id="form_flow" reset="NOT" submit="NOT" caption="工作流设计器"
			action="/workflow/flow/saveFlowXml.json">
			<youi:fieldLayout columns="2">
				<youi:fieldLabel width="200" property="flowName" caption="流程名"/>
				<youi:fieldLabel width="400" property="flowCaption" caption="流程描述"/>
				<youi:fieldHidden property="flowContent"></youi:fieldHidden>
			</youi:fieldLayout>
			<div id="designer">
				<youi:table columns="3">
					<youi:cell width="200">
						<div style="width:200px;overflow-x:hidden;">
							<youi:tree id="tree_element" width="1000">
								<ul>
									<li id="tree_element_root" class="treeNode root">
										<span class=""><a class="">流程元素</a></span>
										<ul></ul>
									</li>
								</ul>
							</youi:tree>
						</div>
					</youi:cell>
					<youi:cell>
						<div id="designer_toolbar"></div>
						<youi:tabs id="tabs_flow_editor" itemHeight="450">
							<youi:tabItem caption="设计" id="designer">
								<youi:workflow processKey="${flowId}" loadSrc="/workflow/flow/getFlowHtml.json"/>
							</youi:tabItem>
							<youi:tabItem caption="activiti xml" id="activitiXml">
								<div id="xeditor_flow"></div>
							</youi:tabItem>
							
							<youi:tabItem caption="关联表单" id="showForms">
								<youi:grid id="grid_flow_form" caption="" panel="false" idKeys="findPath" usePager="false"
									src="/workflow/flow/getFlowForms.json" load="false"
									reset="NOT" submit="NOT" add="NOT" remove="NOT" edit="NOT">
									<youi:fieldLayout>
										<youi:fieldHidden property="flowId"></youi:fieldHidden>
									</youi:fieldLayout>
									<youi:gridCol width="400" property="findPath" caption="表单路径"/>
									<youi:gridCol width="140" property="formCode" caption="表单名"/>
									<youi:gridCol width="260" property="formCaption" caption="表单描述"/>
									<youi:gridCol width="80" type="link" 
										property="openFormEditor" caption=" " defaultValue="编辑"/>
								</youi:grid>
							</youi:tabItem>
						</youi:tabs>
					</youi:cell>
					<youi:cell width="200">
						<div id="designer_propertyTable"></div>
					</youi:cell>
				</youi:table>
			</div>
		</youi:form>
		
		<youi:form id="form_candidateGroups" dialog="true" reset="NOT" submit="确认" caption="候选角色">
			<youi:fieldLayout columns="1" labelWidths="1">
				<youi:fieldTree property="code" 
					caption="" rootText="候选角色" popup="false" simple="false" check="true" src="/fuc/role/getRoles.json" show="roleCaption"  code="roleId"/>
			</youi:fieldLayout>
		</youi:form>
		
		<script type="text/javascript">
			$(function(){
				$.youi.log.logLevel = 4;
				$('#designer').workflowDesigner({
					formId:'form_flow',
					elementTreeId:'tree_element'
				});
			});
			
			$('#xeditor_flow').xeditor({
				readonly:true
			});
		</script>
		<youi:func name="grid_flow_form_link_openFormEditor" params="rowId">
			//flow:2c9dc6043c413a7b013c413c36b10001/startEvent:startevent1
			if(rowId){
				var nodeId = rowId.split(':')[2];
				$('#designer').workflowDesigner('openUserTaskForm',nodeId);
			}
		</youi:func>
		
		<youi:func name="tabs_flow_editor_beforeSelect" params="tabId">
			if($('#'+tabId).is('.active')){
				return false;
			}
			
			var activeToolsbar = false;
			if('activitiXml'==tabId){
				$('#designer').workflowDesigner('save',function(xml){
					var params = 'flowContent='+xml+'&flowName='+$('#field_flowName').fieldValue();
					$('#xeditor_flow').xeditor('loadXml','/workflow/flow/getFlowActivitiXml.json',params);
				});
			}else if('showForms'==tabId){
				$('#grid_flow_form').grid('refresh');
			}else{
				activeToolsbar = true;
			}
			if(activeToolsbar){
				$('#designer_toolbar').find('.toolbar-item').removeClass('disabled');
			}else{
				$('#designer_toolbar').find('.toolbar-item').addClass('disabled');
			}
			return true;
		</youi:func>
	</body>
</youi:html>