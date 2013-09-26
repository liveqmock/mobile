<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:html title="流程设计器">
	<head>
		<%@ include file="/WEB-INF/pages/common/commonScriptAndCss.jsp"%>
		<youi:script src="/scripts/youi/youi.serviceflow.js"/>
		<youi:script src="/scripts/youi/youi.xeditor.js"/>
		<youi:style href="/styles/youi.serviceflow.css"></youi:style>
		<style>
			body{
				padding:0;margin:0;
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
		</style>
	</head>
	
	<!-- 页面描述：服务流设计 -->

<body>
	<youi:form id="form_flow" caption="服务流程编排" 
		submit="NOT" reset="NOT" action="/esbmng/esbServiceFlow/saveFlowXml.json">
		<youi:fieldLayout columns="1">
			<youi:fieldLabel property="flowCaption" width="600" caption="流程名称"/>
			<youi:fieldHidden property="flowId"/>
			<youi:fieldHidden property="flowContent"/>
		</youi:fieldLayout>
		<div id="esb_flow_toolbar"></div>
		
		<youi:tabs id="tabs_flow_editor" itemHeight="450">
			<youi:tabItem caption="设计" id="flow_editor">
				<div style="position:relative">
					<div id="esb_flow">
						<div class="bg"></div>
						<div class="point-dragging"></div>
						<div class="node-dragging"></div>
						<div class="select-dragging"></div>
					
						<div class="node-over-panel">
							<div class="panel-top">
								<div id="delete" class="panel-button delete"></div>
							</div>
							
							<div class="panel-center">
								<div id="newUserTask" class="panel-button newUserTask"></div>
								<div id="newGateway" class="panel-button newGateway"></div>
								<div class="panel-button newConnection" title="新建连接" id="newConnection"></div>
							</div>
						</div>
					</div>
				</div>
			</youi:tabItem>
			<youi:tabItem caption="XML" id="flow_editor_xml">
				<div id="xeditor_flow"></div>
			</youi:tabItem>
			<youi:tabItem caption="ESB-XML" id="flow_editor_esb_xml">
				<div id="xeditor_esb_flow"></div>
			</youi:tabItem>
		</youi:tabs>
		
	</youi:form>
	
	<!-- 服务节点编辑弹出窗口 -->
	<youi:form dialog="true" id="form_esb_flow_node_properties" caption=" " height="450" 
		reset="NOT" submit="确认" idKeys="nodeId">
	
		<youi:tabs id="tabs_esb_flow_node_properties" itemHeight="400">
			<youi:tabItem caption="基本信息" id="baseInfo">
				<div style="font-size:0px;height:2px;"></div>
				<youi:fieldLayout columns="1">
					<youi:fieldLabel property="nodeId" width="682" caption="节点ID"/>
					<youi:fieldText property="nodeCaption" width="682"  caption="节点描述"/>
					<youi:fieldSelect notNull="true" src="/esbmng/esbService/getEsbServices.json" show="esbServiceCaption" code="esbServiceId"
						 property="esbServiceId" width="682" caption="服务"/>
					<youi:fieldSelect notNull="true" src="/esbadapter/esbAdapter/getEsbAdapters.json" show="esbAdapterCaption" code="esbAdapterId"
						property="serviceAdapter" width="682" caption="服务适配器"/>
				</youi:fieldLayout>
				
				<fieldset style="border:1pt solid silver;">
					<legend>服务属性</legend>
					<div id="serivce_attrs" class="serivce-attrs" style="overflow:auto;height:245px;"></div>
				</fieldset>
			</youi:tabItem>
			
			<youi:tabItem caption="输入" id="nodeInput">
				<div style="height:400px;position:relative;">
					<youi:fieldLayout labelWidths="1" columns="1">
						<youi:fieldGrid parents="esbServiceId"  parentsAlias="esbService.esbServiceId"
							  property="nodeInputs" mode="reload" caption=""  width="798">
							  
							  <youi:grid id="grid_nodeInput" caption="输入参数" idKeys="nameExpression"
									panel="false" usePager="false" 
									add="NOT" edit="NOT" remove="NOT"
									reset="NOT" submit="NOT" save="NOT"
									src="/esbmng/esbServiceInput/getEsbServiceInputs.json" load="false">
									<youi:gridCol property="nameExpression" width="200" caption="参数名"/>
									<youi:gridCol editor="fieldText" property="inputExpression" width="500" caption="值表达式"/>
								</youi:grid>
						</youi:fieldGrid>
					</youi:fieldLayout>
				</div>
			</youi:tabItem>
			
			<youi:tabItem caption="输出" id="nodeOutput">
				 <youi:tree id="tree_node_output"  rootText="输出">
		 			<ul>
		 				<li class="treeNode expandable expanded" id="record">
		 					<div class="tree-trigger"></div>
		 					<span class="tree-span expandable expanded" title="record"><a href="#" class="tree-a">单记录</a></span>
		 					<ul>
			 					<li class="treeNode" id="userId">
			 						<span class="tree-span" title="用户主键"><a href="#" class="tree-a">userId</a></span>
			 					</li>
			 					<li class="treeNode last" id="userName">
			 						<span class="tree-span" title="用户名"><a href="#" class="tree-a">userName</a></span>
			 					</li>
		 					</ul>
		 				</li>
		 				<li class="treeNode expandable" id="records">
		 					<div class="tree-trigger"></div>
		 					<span class="tree-span expandable" title="records"><a href="#" class="tree-a">记录集</a></span>
		 				</li>
		 				<li class="treeNode expandable expanded last" id="message">
		 					<div class="tree-trigger"></div>
		 					<span class="tree-span expandable expanded" title="message"><a href="#" class="tree-a">响应信息</a></span>
		 				
		 					<ul>
			 					<li class="treeNode" id="code">
			 						<span class="tree-span" title="响应码"><a href="#" class="tree-a">返回码</a></span>
			 					</li>
			 					<li class="treeNode last" id="info">
			 						<span class="tree-span" title="响应信息"><a href="#" class="tree-a">返回信息</a></span>
			 					</li>
		 					</ul>
		 				</li>
		 			</ul>
				 </youi:tree>
			</youi:tabItem>
		</youi:tabs>
	</youi:form>
	
	<youi:form dialog="true" id="form_start_properties" caption="起始节点输入配置" reset="NOT" submit="确认" >
		<youi:fieldHidden prefix="start" property="nodeId" caption="节点ID"/>
		<div style="height:400px;position:relative;">
			<youi:fieldGrid prefix="start" property="nodeInputs" caption=""  width="798">
				<youi:grid id="grid_start_input" caption="" panel="false" submit="NOT" reset="NOT" save="NOT" editable="true"
					load="false" usePager="false">
					<youi:gridCol editor="fieldText" width="350" property="nameExpression" caption="参数名称"></youi:gridCol>
					<youi:gridCol editor="fieldText" width="350" property="inputExpression" caption="数据类型"></youi:gridCol>
				</youi:grid>
			</youi:fieldGrid>
		</div>
	</youi:form>
	
	<youi:form dialog="true" id="form_end_properties" caption="结束节点输出配置">
		<youi:fieldHidden prefix="end" property="nodeId" caption="节点ID"/>
		<div style="height:400px;position:relative;">
			<youi:fieldGrid prefix="end" property="nodeOutputs" gridId="grid_end_output" caption=""  width="798">
				<youi:grid id="grid_end_output" caption="" panel="false" submit="NOT" reset="NOT" save="NOT" editable="true"
					load="false" usePager="false" >
					<youi:gridCol editor="fieldText" width="140" property="nameExpression" caption="参数名称"></youi:gridCol>
					<youi:gridCol editor="fieldText" width="360" property="inputExpression" caption="表达式"></youi:gridCol>
				</youi:grid>
			</youi:fieldGrid>
		</div>
	</youi:form>
	
	<!-- 页面初始化函数 -->
	<script type="text/javascript">
		var pageId = null;
		$(function(){
			var flowId = $('#field_flowId').fieldValue();
			
			//加载数据
			if(flowId){
				$.youi.ajaxUtil.ajax({
					url:'/esbmng/esbServiceFlow/getFlowHtml.json?flowId='+flowId,
					success:function(result){
						$('#esb_flow').find('.node,.transition').remove();
						$('#esb_flow').prepend(result.record.html);
						
						$('#esb_flow').serviceflow({
							nodeFormConfigs:{
								userTask:{
									id:'form_esb_flow_node_properties'
								},
								start:{
									id:'form_start_properties'
								},
								end:{
									id:'form_end_properties'
								}
							}
						});
					}
				});
			}
			
			$('#xeditor_flow').xeditor({
				readonly:true
			});
			
			$('#xeditor_esb_flow').xeditor({
				readonly:true
			});
			
			$('#esb_flow_toolbar').toolbar({
				commandWidgetId:'esb_flow',
				commandWidget:'serviceflow',
				actions:{
					save:function(){
						$('#tabs_flow_editor').tabs('selectIndex');
						var flowContent = $('#esb_flow').serviceflow('buildXml');
						var saveForm = $('#form_flow');
						saveForm.form('fieldValue','flowContent',flowContent);
						saveForm.form('submit');
					}
				}
			}).toolbar('loadItems',[
				{name:'save',tooltip:'保存'},
				{name:'split'},
				{name:'halign',tooltip:'水平对齐'},
				{name:'valign',tooltip:'垂直对齐'},
				{name:'split'},
				{name:'remove',tooltip:'删除'}]);
		});
	</script>
	
	<youi:func name="field_esbServiceId_change" params="value,oldValue">
		var baseInfoItem = $elem('baseInfo',pageId);
	</youi:func>
	
	<youi:func name="field_serviceAdapter_change" params="value,oldValue">
		var serviceAttrsContainer = $('#serivce_attrs').empty();
		if(!value)return;
		var layoutElement = $('<div></div>').appendTo(serviceAttrsContainer);
		//element.data('properties')
		var formElement = $elem('form_esb_flow_node_properties',pageId);
		var properties =$.extend({},formElement.data('properties'));
		
		layoutElement.fieldLayout({
			columns:1,
			fields:[{'property':'beanName',caption:'服务名',width:600,defaultValue:'userManager'},
			{'property':'methodName',caption:'方法名',width:600}]
		}).fieldLayout('setFieldValues',properties);
		
	</youi:func>
	
	<youi:func name="tabs_flow_editor_beforeSelect" params="tabId">
		if($('#'+tabId).is('.active')){
			return false;
		}
		if('flow_editor_xml'==tabId){
			//获取转换后的xml
			var flowContent =  $('#esb_flow').serviceflow('buildXml');
			var params  = 'flowContent='+flowContent;
			$('#xeditor_flow').xeditor('loadXml','/esbmng/esbServiceFlow/formatFlowXml.json',params);
		}else if('flow_editor_esb_xml'==tabId){
			var flowContent =  $('#esb_flow').serviceflow('buildXml');
			var params  = 'flowContent='+flowContent;
			$('#xeditor_esb_flow').xeditor('loadXml','/esbmng/esbServiceFlow/showEsbFlowXml.json',params);
		}
		return true;
	</youi:func>
	
	<!-- 标签选择 -->
	<youi:func name="tabs_esb_flow_node_properties_select" params="tabId">
		var baseInfoItem = $elem('baseInfo',pageId),
			nodeInputItem = $elem('nodeInput',pageId),//输入参数面板
			nodeOutputItem = $elem('nodeOutput',pageId);
	
		var selectedServiceId = $elem('field_esbServiceId',pageId).fieldValue();//
		if(!selectedServiceId)return;//没有选择节点
		
		if(tabId==nodeInputItem.attr('id')){
			//处理输入参数面板
			var serviceId = nodeInputItem.attr('serviceId');
			
			if(!serviceId||selectedServiceId!=serviceId){
				nodeInputItem.attr('serviceId',selectedServiceId);
				$elem('field_nodeInputs',pageId).fieldValue('load');
			}
		}else if(tabId==nodeOutputItem.attr('id')){
			//处理输出参数面板
			var serviceId = nodeOutputItem.attr('serviceId');
			
			if(!serviceId||selectedServiceId!=serviceId){
				nodeOutputItem.attr('serviceId',selectedServiceId);
			}
		}
	</youi:func>
	
	<youi:func name="grid_nodeInput_afterParse" params="records">
		if(records.length==0)return;
		var nodeId =  $elem('field_nodeId',pageId).fieldValue();
		var maps = $('#esb_flow').serviceflow('getNodeInputs',nodeId);
		$('tr.row',this).each(function(){
			var propName = this.getAttribute('id');
			if(maps[propName]){
				$('td:last',this).attr('value',maps[propName]).text(maps[propName]);
			}
		});
	</youi:func>
	</body>
</youi:html>