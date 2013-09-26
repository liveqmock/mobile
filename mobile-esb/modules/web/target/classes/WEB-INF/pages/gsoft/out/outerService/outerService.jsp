<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************子页面**********************************-->
	<youi:subpage id="subpage_form_design" caption="表单设计" subpageId="formDesign"
		 type="window" src="/page/gsoft.out.outerService/formDesigner.html">
	</youi:subpage>
	
	<youi:subpage id="subpage_form_req" caption="模拟请求" subpageId="form_req"
		 src="/page/gsoft.out.outerService/req.html" height="450"
		 formAction="/out/outerService/getSoapReq.json?outerServiceId={outerServiceId}">
		 <youi:button name="close" caption="关闭" order="900"/>
	</youi:subpage>
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:table columns="1">
		<youi:cell>
			<!-- grid-接口列表-->
			<youi:grid id="grid_outerService" idKeys="outerServiceId" caption="接口列表" 
						dataFormId="form_outerService"
						src="/out/outerService/getPagerOuterServices.json" 
						editSrc="/out/outerService/getOuterService.json"
						removeSrc="/out/outerService/removeOuterService.json">
				<youi:fieldLayout>
					<youi:fieldText property="outerServiceName"  caption="接口名"/>
					<youi:fieldText property="outerServiceType"  caption="接口类型"/>
				</youi:fieldLayout>
				
				<youi:gridCol width="200" property="outerServiceName"  caption="接口名"/>
				<youi:gridCol width="200" property="outerServiceCaption"  caption="接口描述"/>
				<youi:gridCol width="200" property="outerServiceType"  caption="接口类型"/>
				
				<youi:gridCol property="formId"  caption="接口表单"/>
				
				<youi:button name="genFromWsdl" caption="从wsdl生成"/>
				
				<youi:button name="soapReq" order="201" active="1" caption="SOAP请求"/>
				
				<youi:button name="serviceForm" order="201" active="1" caption="接口表单"/>
				<youi:button name="remvoeForm" order="202" active="1" caption="删除表单" 
					submitAction="/out/outerService/removeOuterServiceForm.json"/>
			</youi:grid>
		</youi:cell>
		<youi:cell>
			<!-- grid-接口参数列表-->
			<youi:grid  dataFormId="form_outerServiceParam"
						id="grid_outerServiceParam" idKeys="paramId" caption="接口参数列表" 
						src="/out/outerServiceParam/getPagerOuterServiceParams.json" 
						editSrc="/out/outerServiceParam/getOuterServiceParam.json"
						removeSrc="/out/outerServiceParam/removeOuterServiceParam.json" 
						parentId="grid_outerService" parentAttr="outerService" showNum="true"
						load="false" submit="NOT" reset="NOT" usePager="false"
						exportXls="true">
				<youi:gridCol width="120" property="paramName"  caption="参数名"/>
				<youi:gridCol width="200" property="paramCaption"  caption="参数描述"/>
				
				<youi:gridCol property="paramXpath" width="420" caption="参数路径"/>
				<youi:gridCol property="paramType"  caption="参数类型"/>
				<youi:gridCol property="dataLength"  caption="长度"/>
				<youi:gridCol property="dataType"  caption="数据类型"/>
			</youi:grid>
		</youi:cell>
	</youi:table>
	
	<!-- form-接口编辑 -->
	<youi:form dialog="true" caption="接口" id="form_outerService" 
		action="/out/outerService/saveOuterService.json">
		<youi:fieldLayout prefix="record" columns="1">
			<youi:fieldHidden property="outerServiceId"  caption="接口ID"/>
			<youi:fieldText property="outerServiceName" width="502"  caption="接口名"/>
			<youi:fieldText property="outerServiceCaption" width="502"  caption="接口描述"/>
			<youi:fieldText property="outerServiceType" width="502"  caption="接口类型"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	
	<!--  -->
	
	<!-- form-接口参数编辑 -->
	<youi:form dialog="true" caption="接口参数" 
		id="form_outerServiceParam" action="/out/outerServiceParam/saveOuterServiceParam.json">
		<youi:fieldLayout prefix="record" columns="1">
			<youi:fieldHidden property="outerService.outerServiceId"  caption="接口ID"/>
			<youi:fieldHidden property="paramId"  caption="参数ID"/>
			<youi:fieldText property="paramName" width="502"  caption="参数名"/>
			<youi:fieldText property="paramCaption" width="502" caption="参数描述"/>
			<youi:fieldText property="paramXpath" width="502"  caption="参数路径"/>
			<youi:fieldText property="paramType" width="502"  caption="参数类型"/>
			<youi:fieldText property="dataLength" width="502"  caption="长度"/>
			<youi:fieldText property="dataType" width="502"  caption="数据类型"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--  -->
	<youi:form caption="wsdl" id="form_wsdl2service" dialog="true" action="/out/outerService/genFromWsdl.json">
		<youi:fieldLayout columns="1">
			<youi:fieldText caption="wsdlUrl" property="wsdlUrl" width="502"/>
			<youi:fieldRadioGroup property="cover" caption="是否覆盖" convert="booleanStr"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<!-- grid按钮：打开从wsdl生成接口窗口 -->
	<youi:func name="func_grid_genFromWsdl">
		var formElement = $elem('form_wsdl2service',pageId);
		formElement.form('open');
	</youi:func>
	<!-- grid按钮：打开表单设计子页面 -->
	<youi:func name="func_grid_serviceForm">
		var subpageElement = $elem('subpage_form_design',pageId),
			gridElement = $elem('grid_outerService',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		//AMInnToAccQry 2c9dc60438838f720138839005810496
		subpageElement.subpage('open',{
			serviceId:selectedRecord.outerServiceId,
			formKey:selectedRecord.outerServiceName
		});
	</youi:func>
	
	<youi:func name="func_grid_soapReq">
		var subpageElement = $elem('subpage_form_req',pageId),
			gridElement = $elem('grid_outerService',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
	
		subpageElement.subpage('open',selectedRecord,'',selectedRecord);
	</youi:func>
	
	<!-- 接口生成后的操作 -->
	<youi:func name="form_wsdl2service_afterSubmit">
		var gridElement = $elem('grid_outerService',pageId);
		gridElement.grid('pReload');//刷新grid
	</youi:func>
	
	<youi:func name="func_subpage_gen">
		var subpageElement = $elem('subpage_form_req',pageId);
		//
		var fieldLayoutElement = subpageElement.find('.youi-fieldLayout:first');
		//
		var dataFieldXpaths = fieldLayoutElement.data('fieldPaths');
		//alert(dataFieldXpaths.adjDate);
		
		fieldLayoutElement.find('.youi-field').each(function(){
			var property = this.getAttribute('property');
			var value = $(this).fieldValue();
			if(value){
				//alert(property+value+dataFieldXpaths[property]);
			}
		});
		
		//subpageElement
	</youi:func>
	
	<youi:func name="subpage_form_req_afterSubmit" params="result">
		$('#req_fieldLayout_param_soapXml>pre').text(result.record.html);
	</youi:func>
	
	<!--**********************************页面函数********************************-->
</youi:page>