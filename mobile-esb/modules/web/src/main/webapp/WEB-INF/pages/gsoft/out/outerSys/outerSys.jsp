<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<!-- grid-外部系统列表-->
	<youi:grid id="grid_outerSys" idKeys="outerSysId" caption="外部系统列表" 
				src="/out/outerSys/getPagerOuterSyss.json" 
				removeSrc="/out/outerSys/removeOuterSys.json">
		<youi:fieldLayout>
			<youi:fieldText property="outerSysCaption"  caption="外部系统描述"></youi:fieldText>
			<youi:fieldText property="outerSysCode"  caption="外部系统代码"></youi:fieldText>
		</youi:fieldLayout>
		
		<youi:gridCol property="outerSysCaption"  caption="外部系统描述"/>
		<youi:gridCol property="outerSysCode"  caption="外部系统代码"/>

	</youi:grid>
	
	<!-- form-外部系统编辑 -->
	<youi:form dialog="true" caption="编辑外部系统" id="form_outerSys" action="/out/outerSys/saveOuterSys.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="outerSysCaption"  caption="外部系统描述"/>
			<youi:fieldText property="outerSysCode"  caption="外部系统代码"/>
			<youi:fieldText property="outerSysId"  caption="外部系统ID"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
</youi:page>