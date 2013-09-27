<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-${modelDescription}列表-->
	<youi:grid id="grid_${modelName}" idKeys="${id}" dataFormId="form_${modelName}"  caption="${modelDescription}列表" 
				src="/${moduleName}/${modelName}/getPager${modelClassName}s.json" 
				editSrc="/${moduleName}/${modelName}/get${modelClassName}.json"
				removeSrc="/${moduleName}/${modelName}/remove${modelClassName}.json">
		<youi:fieldLayout labelWidths="120,120">
			<#list attributes as attribute>
			<#if attribute.id!="true">
			<youi:fieldText property="${attribute.name}"  caption="${attribute.description}"/></#if>
			</#list>
		</youi:fieldLayout>
		
		<#list attributes as attribute>
		<#if attribute.id!="true">
		<youi:gridCol property="${attribute.name}"  caption="${attribute.description}"/></#if>
		</#list>
	</youi:grid>
	
	<!-- form-${modelDescription}编辑 -->
	<youi:form dialog="true" caption="${modelDescription}" id="form_${modelName}" idKeys="${id}"
		action="/${moduleName}/${modelName}/save${modelClassName}.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<#list attributes as attribute>
			<youi:fieldText property="${attribute.name}"  caption="${attribute.description}"/>
			</#list>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>