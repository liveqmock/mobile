<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-监控业务系统列表-->
	<youi:grid id="grid_alertSys" idKeys="alertSysId" dataFormId="form_alertSys"  caption="监控业务系统列表" 
				src="/art/alertSys/getPagerAlertSyss.json" 
				editSrc="/art/alertSys/getAlertSys.json"
				removeSrc="/art/alertSys/removeAlertSys.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="alertSysName"  caption="应用系统名称"/>
			<youi:fieldText property="alertSysCode"  caption="应用系统编码"/>

		</youi:fieldLayout>
		
		<youi:gridCol property="alertSysName"  caption="应用系统名称"/>
		<youi:gridCol property="alertSysCode"  caption="应用系统编码"/>

	</youi:grid>
	
	<!-- form-监控业务系统编辑 -->
	<youi:form dialog="true" caption="监控业务系统" id="form_alertSys" idKeys="alertSysId"
		action="/art/alertSys/saveAlertSys.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="alertSysName"  caption="应用系统名称"/>
			<youi:fieldText property="alertSysCode"  caption="应用系统编码"/>
			<youi:fieldText property="alertSysId"  caption="业务系统主键"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>