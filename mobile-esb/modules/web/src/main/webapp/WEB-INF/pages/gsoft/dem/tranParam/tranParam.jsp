<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-参数列表-->
	<youi:grid id="grid_tranParam" idKeys="tranParamId" dataFormId="form_tranParam"  caption="参数列表" 
				src="/dem/tranParam/getPagerTranParams.json" 
				editSrc="/dem/tranParam/getTranParam.json"
				removeSrc="/dem/tranParam/removeTranParam.json">
		<youi:fieldLayout>
			<youi:fieldText property="paramType"  caption="参数类型"></youi:fieldText>
			<youi:fieldText property="dataLength"  caption="长度"></youi:fieldText>
			<youi:fieldText property="fmlName"  caption="FML域名"></youi:fieldText>

			<youi:fieldText property="dataType"  caption="数据类型"></youi:fieldText>
			<youi:fieldText property="paramCaption"  caption="参数描述"></youi:fieldText>
			<youi:fieldText property="paramName"  caption="参数名"></youi:fieldText>
		</youi:fieldLayout>
		
		<youi:gridCol property="paramType"  caption="参数类型"/>
		<youi:gridCol property="dataLength"  caption="长度"/>
		<youi:gridCol property="fmlName"  caption="FML域名"/>

		<youi:gridCol property="dataType"  caption="数据类型"/>
		<youi:gridCol property="paramCaption"  caption="参数描述"/>
		<youi:gridCol property="paramName"  caption="参数名"/>
	</youi:grid>
	
	<!-- form-参数编辑 -->
	<youi:form dialog="true" caption="参数" id="form_tranParam" action="/dem/tranParam/saveTranParam.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="paramType"  caption="参数类型"/>
			<youi:fieldText property="dataLength"  caption="长度"/>
			<youi:fieldText property="fmlName"  caption="FML域名"/>
			<youi:fieldText property="tranParamId"  caption="参数ID"/>
			<youi:fieldText property="dataType"  caption="数据类型"/>
			<youi:fieldText property="paramCaption"  caption="参数描述"/>
			<youi:fieldText property="paramName"  caption="参数名"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>