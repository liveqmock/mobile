<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-数据元列表-->
	<youi:grid id="grid_esbDataElement" idKeys="esbDataElementId" dataFormId="form_esbDataElement"  caption="数据元列表" 
				src="/esbmng/esbDataElement/getPagerEsbDataElements.json" 
				editSrc="/esbmng/esbDataElement/getEsbDataElement.json"
				removeSrc="/esbmng/esbDataElement/removeEsbDataElement.json" panel="false">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="dataLength"  caption="字段长度"/>
			<youi:fieldText property="columnName"  caption="数据库列名"/>
			<youi:fieldText property="esbDataElementName"  caption="数据元名"/>
			<youi:fieldText property="esbDataElementCaption"  caption="数据元描述"/>

			<youi:fieldText property="dataType"  caption="数据类型"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="dataLength"  caption="字段长度"/>
		<youi:gridCol property="columnName"  caption="数据库列名"/>
		<youi:gridCol property="esbDataElementName"  caption="数据元名"/>
		<youi:gridCol property="esbDataElementCaption"  caption="数据元描述"/>

		<youi:gridCol property="dataType"  caption="数据类型"/>
	</youi:grid>
	
	<!-- form-数据元编辑 -->
	<youi:form dialog="true" caption="数据元" id="form_esbDataElement" idKeys="esbDataElementId"
		action="/esbmng/esbDataElement/saveEsbDataElement.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="dataLength"  caption="字段长度"/>
			<youi:fieldText property="columnName"  caption="数据库列名"/>
			<youi:fieldText property="esbDataElementName"  caption="数据元名"/>
			<youi:fieldText property="esbDataElementCaption"  caption="数据元描述"/>
			<youi:fieldText property="esbDataElementId"  caption="数据元主键"/>
			<youi:fieldText property="dataType"  caption="数据类型"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>