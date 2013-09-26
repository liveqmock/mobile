<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-交易列表-->
	<youi:grid id="grid_tran" idKeys="tranId" dataFormId="form_tran"  caption="交易列表" 
				src="/dem/tran/getPagerTrans.json" 
				editSrc="/dem/tran/getTran.json"
				removeSrc="/dem/tran/removeTran.json">
		<youi:fieldLayout>
			<youi:fieldText property="tranCode"  caption="交易码"></youi:fieldText>
			<youi:fieldText property="tranName"  caption="交易名"></youi:fieldText>
			<youi:fieldText property="tranCaption"  caption="交易描述"></youi:fieldText>
		</youi:fieldLayout>
		
		<youi:gridCol width="120" property="tranCode"  caption="交易码"/>
		<youi:gridCol width="150" property="tranName"  caption="交易名"/>
		<youi:gridCol width="150" property="tuxServerName"  caption="TUXEDO服务名"/>
		<youi:gridCol width="240" property="tranCaption"  caption="交易描述"/>
		
	</youi:grid>
	
	<!-- grid-参数列表-->
	<youi:grid id="grid_tranParam" idKeys="tranParamId" dataFormId="form_tranParam"  caption="参数列表" 
				src="/dem/tranParam/getPagerTranParams.json" 
				editSrc="/dem/tranParam/getTranParam.json"
				removeSrc="/dem/tranParam/removeTranParam.json" 
				parentId="grid_tran" parentAttr="tran" load="false" reset="NOT" submit="NOT">
				
		<youi:gridCol width="100" property="paramName"  caption="参数名"/>	
		<youi:gridCol property="dataType"  caption="数据类型"/>	
		<youi:gridCol property="paramType"  caption="上下行"/>
		<youi:gridCol property="dataLength"  caption="长度"/>
		<youi:gridCol width="200" property="fmlName"  caption="FML域名"/>
		<youi:gridCol width="300" property="paramCaption"  caption="参数描述"/>
	</youi:grid>
	
	<!-- form-交易编辑 -->
	<youi:form dialog="true" caption="交易" id="form_tran" action="/dem/tran/saveTran.json">
		<youi:fieldLayout prefix="record" columns="1">
			<youi:fieldHidden property="tranId"  caption="交易ID"/>
			<youi:fieldText width="502" property="tranCode"  caption="交易码"/>
			<youi:fieldText width="502" property="tranName"  caption="交易名"/>
			<youi:fieldText width="502" property="tranCaption"  caption="交易描述"/>
			<youi:fieldText width="502" property="tuxServerName"  caption="服务名"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	
	<!-- form-参数编辑 -->
	<youi:form dialog="true" caption="参数" id="form_tranParam" action="/dem/tranParam/saveTranParam.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="tranParamId"  caption="参数ID"/>
			<youi:fieldHidden property="tran.tranId"  caption="交易ID"/>
			<youi:fieldLabel property="tran.tranCode"  caption="交易码"/>
			
			<youi:fieldText property="paramType"  caption="参数类型"/>
			<youi:fieldText property="dataLength"  caption="长度"/>
			<youi:fieldText property="fmlName"  caption="FML域名"/>
			
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