<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-功能界面列表-->
	<youi:grid id="grid_func" idKeys="funcId" dataFormId="form_func"  caption="功能界面列表" 
				src="/dem/func/getPagerFuncs.json" 
				editSrc="/dem/func/getFunc.json"
				removeSrc="/dem/func/removeFunc.json">
		<youi:fieldLayout>
			<youi:fieldText property="funcCode"  caption="功能编号"/>
			<youi:fieldText property="subsysId"  caption="子系统ID"/>
			<youi:fieldText property="funcCaption"  caption="功能描述"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="funcCode"  caption="功能编号"/>
		<youi:gridCol property="subsysId"  caption="子系统ID"/>
		<youi:gridCol property="funcCaption"  caption="功能描述"/>
	</youi:grid>
	
	<!-- form-功能界面编辑 -->
	<youi:form dialog="true" caption="功能界面" id="form_func" action="/dem/func/saveFunc.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="funcId"  caption="功能ID"/>
			<youi:fieldText property="funcCode"  caption="功能编号"/>
			<youi:fieldText property="subsysId"  caption="子系统ID"/>
			<youi:fieldText property="funcCaption"  caption="功能描述"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>