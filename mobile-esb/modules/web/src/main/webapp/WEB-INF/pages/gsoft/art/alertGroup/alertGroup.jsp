<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-监控分类列表-->
	<youi:grid id="grid_alertGroup" idKeys="alertGroupId" dataFormId="form_alertGroup"  caption="监控分类列表" 
				src="/art/alertGroup/getPagerAlertGroups.json" 
				editSrc="/art/alertGroup/getAlertGroup.json"
				removeSrc="/art/alertGroup/removeAlertGroup.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="alertGroupCaption"  caption="分类描述"/>

			<youi:fieldText property="alertGroupCode"  caption="分类编码"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="alertGroupCode"  caption="分类编码"/>
		<youi:gridCol property="alertGroupCaption"  caption="分类描述"/>
	</youi:grid>
	
	<youi:grid id="grid_alertItem" idKeys="alertItemId" dataFormId="form_alertItem"  caption="监控项列表" 
				src="/art/alertItem/getPagerAlertItems.json"  parentId="grid_alertGroup" parentAttr="alertGroup"
				editSrc="/art/alertItem/getAlertItem.json" submit="NOT" reset="NOT"
				removeSrc="/art/alertItem/removeAlertItem.json">
		<youi:gridCol property="alertItemCode"  caption="监控项编码"/>
		<youi:gridCol property="alertItemCaption" width="240" caption="监控项描述"/>
		<youi:gridCol property="alertGroup.alertGroupCaption" width="160" caption="分类描述"/>
		<youi:gridCol property="subsysId" convert="alertSys" caption="业务系统"/>
	</youi:grid>
	
	<!-- form-监控分类编辑 -->
	<youi:form dialog="true" caption="监控分类" id="form_alertGroup" idKeys="alertGroupId"
		action="/art/alertGroup/saveAlertGroup.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="alertGroupCaption"  caption="分类描述"/>
			<youi:fieldText property="alertGroupId"  caption="主键"/>
			<youi:fieldText property="alertGroupCode"  caption="分类编码"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	
	
	<!-- form-监控项编辑 -->
	<youi:form dialog="true" caption="监控项" id="form_alertItem" idKeys="alertItemId"
		action="/art/alertItem/saveAlertItem.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldHidden property="alertItemId"  caption="主键"/>
			<youi:fieldHidden property="alertGroup.alertGroupId"  caption="监控分类"/>
			
			<youi:fieldLabel property="alertGroup.alertGroupCaption"  caption="监控分类"/>
			<youi:fieldText property="alertItemCaption"  caption="监控项描述"/>
			<youi:fieldText property="alertItemCode"  caption="监控项编码"/>
			<youi:fieldSelect property="subsysId" convert="alertSys" caption="subsysId"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>