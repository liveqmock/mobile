<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-预警规则列表-->
	<youi:grid id="grid_alertRule" idKeys="alertRuleId" dataFormId="form_alertRule"  caption="预警规则列表" 
				src="/art/alertRule/getPagerAlertRules.json" 
				editSrc="/art/alertRule/getAlertRule.json"
				removeSrc="/art/alertRule/removeAlertRule.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="expression"  caption="规则表达式"/>
			<youi:fieldText property="voice"  caption="声音报警"/>

			<youi:fieldText property="type"  caption="规则类型"/>
			<youi:fieldText property="severity"  caption="预警级别"/>
			<youi:fieldText property="flash"  caption="闪光报警"/>
			<youi:fieldText property="caption"  caption="规则描述"/>
		</youi:fieldLayout>
		<youi:gridCol property="caption" width="300" caption="规则描述"/>
		<youi:gridCol property="expression"  caption="规则表达式"/>
		<youi:gridCol property="voice"  caption="声音报警"/>

		<youi:gridCol property="type"  caption="规则类型"/>
		<youi:gridCol property="severity"  caption="预警级别"/>
		<youi:gridCol property="flash"  caption="闪光报警"/>
	</youi:grid>
	
	<!-- form-预警规则编辑 -->
	<youi:form dialog="true" caption="预警规则" id="form_alertRule" idKeys="alertRuleId">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="expression"  caption="规则表达式"/>
			<youi:fieldText property="voice"  caption="声音报警"/>
			<youi:fieldText property="alertRuleId"  caption="ALERT_RULE_ID"/>
			<youi:fieldText property="type"  caption="规则类型"/>
			<youi:fieldText property="severity"  caption="预警级别"/>
			<youi:fieldText property="flash"  caption="闪光报警"/>
			<youi:fieldText property="caption"  caption="规则描述"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>