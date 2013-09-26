<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 表单页面 -->
	<!--**********************************子页面**********************************-->
	<!-- 表单设计器子页面，弹出窗口类型 -->
	<youi:subpage type="window" id="subpage_form_designer" subpageId="050101"
		 src="/page/gsoft.dev.form/design.html" caption="表单设计器"/>
	<!--**********************************子页面**********************************-->

	<!--**********************************页面内容********************************-->
	<!-- grid-表单列表-->
	<youi:grid id="grid_form" idKeys="formId" caption="表单列表" 
				src="/des/form/getPagerForms.json" dataFormId="form_form"
				editSrc="/des/form/getForm.json" edit="NOT"
				removeSrc="/des/form/removeForm.json" load="false">
		<youi:fieldLayout>
			<youi:fieldText property="formCaption"  caption="表单描述"></youi:fieldText>
			<youi:fieldText property="formCode"  caption="表单编码"></youi:fieldText>
		</youi:fieldLayout>
		
		<youi:button name="formDesign" caption="表单设计" active="1" order="201"/>
		<youi:gridCol width="300" property="formCaption"  caption="表单描述"/>
		<youi:gridCol width="100" property="formCode"  caption="表单编码"/>
		<youi:gridCol property="findPath"  caption="路径"/>
	</youi:grid>
	
	<!-- form-表单编辑 -->
	<youi:form dialog="true" caption="表单" id="form_form" action="/des/form/saveForm.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="formId"  caption="表单ID"/>
			<youi:fieldText property="formCaption"  caption="表单描述"/>
			<youi:fieldText property="formCode"  caption="表单编码"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="func_grid_formDesign">
		var gridElement = $elem('grid_form',pageId),
			subpageElement = $elem('subpage_form_designer',pageId),
			record = gridElement.grid('getSelectedRecord');
		if(record){
			subpageElement.subpage('open',record);
		}
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>