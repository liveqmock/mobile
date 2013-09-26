<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-监控项列表-->
	<youi:grid id="grid_alertItem" idKeys="alertItemId" dataFormId="form_alertItem"  caption="监控项列表" 
				src="/art/alertItem/getPagerAlertItems.json" 
				editSrc="/art/alertItem/getAlertItem.json"
				removeSrc="/art/alertItem/removeAlertItem.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="alertItemCaption"  caption="监控项描述"/>
			<youi:fieldText property="alertItemCode"  caption="监控项编码"/>

		</youi:fieldLayout>
		
		<youi:gridCol property="alertItemCaption"  caption="监控项描述"/>
		<youi:gridCol property="alertItemCode"  caption="监控项编码"/>

	</youi:grid>
	
	<!-- form-监控项编辑 -->
	<youi:form dialog="true" caption="监控项" id="form_alertItem" idKeys="alertItemId">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="alertItemCaption"  caption="监控项描述"/>
			<youi:fieldText property="alertItemCode"  caption="监控项编码"/>
			<youi:fieldText property="alertItemId"  caption="主键"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>