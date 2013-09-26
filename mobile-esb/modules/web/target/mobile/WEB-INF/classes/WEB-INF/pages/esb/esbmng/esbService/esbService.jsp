<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-服务列表-->
	<youi:grid id="grid_esbService" idKeys="esbServiceId" dataFormId="form_esbService"  caption="服务列表" 
				src="/esbmng/esbService/getPagerEsbServices.json" 
				editSrc="/esbmng/esbService/getEsbService.json"
				removeSrc="/esbmng/esbService/removeEsbService.json" panel="false">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="createTime"  caption="创建时间"/>
			<youi:fieldText property="esbServiceInterface"  caption="接口名称"/>
			<youi:fieldText property="esbServiceCaption"  caption="服务描述"/>

			<youi:fieldText property="esbServiceVersion"  caption="版本号"/>
			<youi:fieldText property="esbServiceCode"  caption="服务编码"/>
			<youi:fieldText property="updateTime"  caption="修改时间"/>
			<youi:fieldText property="esbServiceName"  caption="服务名"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="createTime"  caption="创建时间"/>
		<youi:gridCol property="esbServiceInterface"  caption="接口名称"/>
		<youi:gridCol property="esbServiceCaption"  caption="服务描述"/>

		<youi:gridCol property="esbServiceVersion"  caption="版本号"/>
		<youi:gridCol property="esbServiceCode"  caption="服务编码"/>
		<youi:gridCol property="updateTime"  caption="修改时间"/>
		<youi:gridCol property="esbServiceName"  caption="服务名"/>
	</youi:grid>
	
	<!-- form-服务编辑 -->
	<youi:form dialog="true" caption="服务" id="form_esbService" idKeys="esbServiceId"
		action="/esbmng/esbService/saveEsbService.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="createTime"  caption="创建时间"/>
			<youi:fieldText property="esbServiceInterface"  caption="接口名称"/>
			<youi:fieldText property="esbServiceCaption"  caption="服务描述"/>
			<youi:fieldText property="esbServiceId"  caption="服务主键"/>
			<youi:fieldText property="esbServiceVersion"  caption="版本号"/>
			<youi:fieldText property="esbServiceCode"  caption="服务编码"/>
			<youi:fieldText property="updateTime"  caption="修改时间"/>
			<youi:fieldText property="esbServiceName"  caption="服务名"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>