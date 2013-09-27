<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<!-- 表单设计器子页面，弹出窗口类型 -->
	<youi:subpage type="window" id="subpage_form_designer" subpageId="050101"
		 src="/page/gsoft.dev.form/design.html" caption="表单设计器"/>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	
	<youi:table>
		<youi:cell width="240">
			<youi:tree id="tree_sysmenu" tree="${sysMenuTree}"/>
			
			<div style="display:none;">
				<youi:grid panel="false" styleClass="hide" id="grid_sysmenu" idKeys="menuId" caption="菜单" load="false" 
					submit="NOT" reset="NOT" add="NOT" edit="NOT" remove="NOT" usePager="false"
					scrollHeight="20">
					<youi:gridCol property="menuCaption" caption=" "/>
				</youi:grid>
			</div>
		</youi:cell>
		<youi:cell>
			<youi:tabs id="tabs_sysmenu_ref" itemHeight="420">
				<youi:tabItem caption="功能页面列表" id="tabitem_func">
					<!-- grid-功能界面列表-->
					<youi:grid  parentId="grid_sysmenu" parentAttr="sysMenu" panel="false"
								id="grid_func" idKeys="funcId" dataFormId="form_func"  caption="界面列表" 
								src="/dem/func/getPagerFuncs.json"   load="false"
								editSrc="/dem/func/getFunc.json" submit="NOT" reset="NOT"
								removeSrc="/dem/func/removeFunc.json" scrollHeight="290">
						<youi:gridCol width="120" property="funcCode"  caption="功能编号"/>
						<youi:gridCol width="300" property="funcCaption"  caption="功能描述"/>
						
						<youi:button name="formDesign" order="201" caption="页面设计" active="1"/>
					</youi:grid>
				</youi:tabItem>
				
				<youi:tabItem caption="功能交易列表" id="tabitem_tran">
					<!-- grid-交易列表-->
					<youi:grid parentId="grid_sysmenu" parentAttr="sysMenu" panel="false"
							id="grid_tran" idKeys="tranId" dataFormId="form_tran"  caption="交易列表" 
							src="/dem/tran/getPagerTrans.json" 
							editSrc="/dem/tran/getTran.json" submit="NOT" reset="NOT" load="false"
							removeSrc="/dem/tran/removeTran.json" scrollHeight="290">
						<youi:gridCol width="120" property="tranCode"  caption="交易码"/>
						<youi:gridCol width="150" property="tranName"  caption="交易名"/>
						<youi:gridCol width="240" property="tranCaption"  caption="交易描述"/>
					</youi:grid>
				</youi:tabItem>
			</youi:tabs>
		</youi:cell>
	</youi:table>
	
	
	<!-- form-功能界面编辑 -->
	<youi:form dialog="true" caption="功能界面" id="form_func" action="/dem/func/saveFunc.json">
		<youi:fieldLayout prefix="funcRecord"  columns="1">
			<youi:fieldHidden property="funcId"  caption="功能ID"/>
			<youi:fieldHidden property="sysMenu.menuId"  caption="功能菜单"/>
			<youi:fieldLabel width="502" property="sysMenu.menuCaption"  caption="功能菜单"/>
			<youi:fieldText width="502" property="funcCode"  caption="功能编号"/>
			<youi:fieldText width="502" property="funcCaption"  caption="功能描述"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	
	
	<!-- form-交易编辑 -->
	<youi:form dialog="true" caption="交易" id="form_tran" action="/dem/tran/saveTran.json">
		<youi:tabs id="tabs_tran">
			<youi:tabItem caption="交易基本信息" id="tabItem_bases">
				<youi:fieldLayout prefix="tranRecord" columns="1">
					<youi:fieldHidden property="tranId"  caption="交易ID"/>
					<youi:fieldHidden property="sysMenu.menuId"  caption="功能菜单"/>
					
					<youi:fieldLabel width="502" property="sysMenu.menuCaption"  caption="功能菜单"/>
					<youi:fieldText width="502" property="tranCode"  caption="交易码"/>
					<youi:fieldText width="502" property="tranName"  caption="交易名"/>
					<youi:fieldText width="502" property="tranCaption"  caption="交易描述"/>
					
				</youi:fieldLayout>
			</youi:tabItem>
			
			<youi:tabItem caption="交易输入输出" id="tabItem_tran_params">
				<youi:fieldLayout prefix="tranRecord" columns="1" labelWidths="1">
					<youi:fieldGrid property="params" width="785">
						<youi:grid showNum="true" editable="true" id="tran_params" panel="false" idKeys="tranParamId">
							<youi:gridCol editor="fieldText" width="120" property="paramName" caption="参数名"/>
							<youi:gridCol editor="fieldText" width="240" property="paramCaption" caption="参数描述"/>
							<youi:gridCol editor="fieldSelect" width="120" convert="tranParamType" property="paramType" caption="输入输出"/>
							
							<youi:gridCol editor="fieldText" property="length" caption="长度"/>
						</youi:grid>
					</youi:fieldGrid>
				</youi:fieldLayout>
			</youi:tabItem>
		</youi:tabs>
		
		<br/>
	</youi:form>
	
	<!--  -->
	<youi:form dialog="true" id="form_navgator_build" caption="表单创建向导" 
		action="/dem/func/saveFuncForm.json" submit="创建表单" reset="NOT">
		<youi:fieldLayout prefix="navgator" columns="1">
			<youi:fieldHidden property="funcId" caption=""/>
			<youi:fieldLabel width="600" property="funcCaption" caption="功能名称"/>
		</youi:fieldLayout>
		<fieldset>
			<legend>选择创建表单交易</legend>
			<youi:fieldLayout prefix="navgator" columns="1" labelWidths="1">
				<youi:fieldGrid property="trans" caption="" width="785">
					<youi:grid panel="false" showCheckbox="true"
							id="grid_tran_for_build" idKeys="tranId" submit="NOT" reset="NOT" load="false"
							scrollHeight="290">
						<youi:gridCol width="120" property="tranCode"  caption="交易码"/>
						<youi:gridCol width="150" property="tranName"  caption="交易名"/>
						<youi:gridCol width="240" property="tranCaption"  caption="交易描述"/>
					</youi:grid>
				</youi:fieldGrid>
			</youi:fieldLayout>
		</fieldset>
		<!-- 隐藏参数 -->
		<div style="display:none;" id="extras_param_tranId"></div>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="tree_sysmenu_change">
		var gridSysmenu = $elem('grid_sysmenu',pageId);
		
		gridSysmenu.grid('parseRecords',[{menuId:this.getAttribute('id'),menuCaption:$('>span',this).text()}]);
	</youi:func>
	<!-- 编辑功能表单 ：如果存在表单，直接定位到编辑页面，如果没有表单-->
	<youi:func name="func_grid_formDesign">
		var gridElement = $elem('grid_func',pageId),
			subpageElement = $elem('subpage_form_designer',pageId),
			record = gridElement.grid('getSelectedRecord');

		//先查询是否已经存在表单
		$.youi.ajaxUtil.ajax({
			url:'/dem/func/getFuncForm.json',
			data:'funcId='+record.funcId,
			success:function(result){
				if(result.record.formId){//表单已经存在
					//直接提交表单
					var buildForm = $elem('form_navgator_build',pageId); 
					buildForm.form('fillRecord',record);
					buildForm.form('submit');
				}else{
					//打开表单
					//grid_tran
					var gridTranElement = $elem('grid_tran',pageId);

					var tranRecords = gridTranElement.grid('getRecords');
					
					$elem('form_navgator_build',pageId).form('fillRecord',$.extend({},record,{
						trans:tranRecords
					})).form('open');
				}
			}
		});
	</youi:func>
	
	<youi:func name="form_navgator_build_beforeSubmit" params="result">
		var formElement = $elem('form_navgator_build',pageId),
			gridElement = $elem('grid_tran_for_build',pageId),
			tranRecords = gridElement.grid('getRecords');
		//
		var extraContainer = formElement.find('#extras_param_tranId');
		var htmls = [];
		$(tranRecords).each(function(){
			htmls.push('<input type="hidden" name="tranId" value="'+this.tranId+'" class="extra-field"/>');
		});
		extraContainer.html(htmls.join(''));
		return true;
	</youi:func>
	
	<youi:func name="form_navgator_build_afterSubmit" params="result">
		if(result.record&&result.record.formId){
			var subpageElement = $elem('subpage_form_designer',pageId);
			result.record.content = '';
			subpageElement.subpage('open',result.record);
			//$elem('form_navgator_build',pageId).form('close');
		}
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>