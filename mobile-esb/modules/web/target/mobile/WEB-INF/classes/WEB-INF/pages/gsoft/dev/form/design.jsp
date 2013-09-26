<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:html title="表单设计器">
	<head>
		<%@ include file="/WEB-INF/pages/common/commonScriptAndCss.jsp"%>
		
		<youi:script src="/scripts/lib/jquery.mousewheel.js"/>
		
		<youi:script src="/scripts/youi/youi.toolbar.js"/>
		<youi:script src="/scripts/youi/youi.formDesigner.js"/>
		<youi:script src="/scripts/youi/youi.pageEditor.js"/>
		<youi:script src="/scripts/youi/youi.snippet.js"/>
		<youi:script src="/scripts/youi/youi.propertyTable.js"/>
	
		<youi:style href="/styles/youi.toolbar.css"/>
		<youi:style href="/styles/youi.accordion.css"/>
		<youi:style href="/styles/youi.propertyTable.css"/>
		<youi:style href="/styles/youi.snippet.css"/>
		<youi:style href="/styles/youi.pageEditor.css"/>
		<youi:style href="/styles/youi.formDesigner.css"/>
		
		<style>
			#youi_log{
				height:300px;
				overflow-y:auto;
				overflow-x:hidden;
			}
			
			body{	
				margin:0;
				padding:0;
			}
		</style>
	</head>
	
	<body>
		<youi:form id="panel_form_designer" caption="表单设计器" submit="NOT" reset="NOT">
			<youi:fieldLayout columns="1" labelWidths="120">
				<youi:fieldLabel width="500" property="formCaption" caption="当前编辑表单"/>
			</youi:fieldLayout>
			
			<div id="formDesigner" class="youi-formDesigner">
				<div id="formDesigner_toolbar"></div>
				<table cellspacing="0" width="100%">
					<tr>
						<td valign="top" class="layout-td panel-west">
							<div id="formDesigner_accordion" class="youi-accordion " style="width:200px;">
								<div>
									<h3 class="youi-accordion-header youi-widget-header"><span class="youi-icon youi-icon-triangle"></span><a class="accordion-a" href="#">页面结构</a></h3>
									<div class="youi-accordion-content youi-widget-content">
										<div id="formDesigner_tree_widgets"></div>
									</div>
								</div>
								<div>
									<h3 class="youi-accordion-header youi-widget-header"><span class="youi-icon youi-icon-triangle"></span><a class="accordion-a" href="#">布局组件</a></h3>
									<div class="youi-accordion-content youi-widget-content">
										<div id="formDesigner_snippet_layout">
											<div id="div" class="snippet-item"><span class="snippet-item-span">div</span></div>
											<div id="table" class="snippet-item"><span class="snippet-item-span">table</span></div>
										</div>
									</div>
								</div>
								<div>
									<h3 class="youi-accordion-header youi-widget-header"><span class="youi-icon youi-icon-triangle"></span><a class="accordion-a" href="#">页面组件</a></h3>
									<div class="youi-accordion-content youi-widget-content">
										<div id="formDesigner_snippet_component">
											<div id="grid" class="snippet-item"><span class="snippet-item-span">grid组件</span></div>
											<div id="form" class="snippet-item"><span class="snippet-item-span">form组件</span></div>
											<div id="panel" class="snippet-item"><span class="snippet-item-span">panel组件</span></div>
											<div id="tree" class="snippet-item"><span class="snippet-item-span">tree组件</span></div>
											<div id="tab" class="snippet-item"><span class="snippet-item-span">tab组件</span></div>
											<div id="accordion" class="snippet-item"><span class="snippet-item-span">accordion组件</span></div>
											<div id="fieldLayout" class="snippet-item"><span class="snippet-item-span">表单布局组件</span></div>
											<div id="buttons" class="snippet-item"><span class="snippet-item-span">按钮容器</span></div>
											<div id="button" class="snippet-item"><span class="snippet-item-span">按钮</span></div>
										</div>
									</div>
								</div>
								<div >
									<h3 class="youi-accordion-header youi-widget-header"><span class="youi-icon youi-icon-triangle"></span><a class="accordion-a" href="#">表单组件</a></h3>
									<div class="youi-accordion-content youi-widget-content">
										<div id="formDesigner_snippet_field">
											<div id="fieldText" class="snippet-item"><span class="snippet-item-span">文本框</span></div>
											<div id="fieldArea" class="snippet-item"><span class="snippet-item-span">文本域</span></div>
											<div id="fieldSelect" class="snippet-item"><span class="snippet-item-span">下拉框</span></div>
											<div id="fieldPassword" class="snippet-item"><span class="snippet-item-span">密码框</span></div>
											<div id="fieldCalendar" class="snippet-item"><span class="snippet-item-span">日历</span></div>
											<div id="fieldCheckboxGroup" class="snippet-item"><span class="snippet-item-span">复选框组</span></div>
											<div id="fieldRadioGroup" class="snippet-item"><span class="snippet-item-span">单选框组</span></div>
											<div id="fieldTree" class="snippet-item"><span class="snippet-item-span">表单树</span></div>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td valign="top" class="layout-td panel-center">
							<div id="formDesigner_pageEditor">
								<div class="drop-marker"></div>
							</div>
						</td>
						<td valign="top" class="layout-td panel-east" width="240px">
							<div id="formDesigner_propertyTable">
								
							</div>
						</td>
					</tr>
				</table>
				
			</div>
			<div id="designer_footer" align="center" style="font-weight:bold;background-color:#CFDBEC;">
				Copyright © 2010-2015  All Rigths  Reserved.
			</div>
		</youi:form>
		<!-- 表单保存 -->
		<youi:form dialog="true" action="/des/form/saveForm.json" reset="NOT" submit="保存" id="formDesigner_save" caption="保存表单">
			<youi:fieldLayout columns="1">
				<youi:fieldHidden property="formId" caption="formId"/>
				<youi:fieldText  property="formCaption" caption="表单描述" width="498"/>
				<youi:fieldArea caption="表单xml" readonly="true" width="500"  rows="15" property="content"/>
			</youi:fieldLayout>
		</youi:form>
		<!-- 表单函数编辑 -->
		<youi:form dialog="true" reset="NOT" submit="保存" id="formDesigner_funcs" caption="页面函数">
			<div class="container_funcs" style="height:400px;overflow-y:auto;">
				
			</div>
		</youi:form>
		
		<script type="text/javascript">
			$(function(){
				$.youi.logLevel = 4;
				
				var designerElement = $('#formDesigner');
				var height = $(window).height() - 9 -designerElement.offset().top - $('#designer_footer').outerHeight();
				designerElement.formDesigner({
					propertyGroupDescs:${propertyGroupDescs},
					height:height
				});
				designerElement = null;
			});
			
			function formDesigner_save_afterSubmit(result){
				$.youi.messageUtil.showMessage('保存成功！');
				$('#formDesigner_save').form('fillRecord',result.record).form('close');
			}
		</script>
	</body>
</youi:html>