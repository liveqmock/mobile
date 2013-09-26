<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-预警信息列表-->
	<youi:grid id="grid_alertMsg" idKeys="alertMsgId" dataFormId="form_alertMsg"  caption="预警信息列表" 
				src="/art/alertMsg/getAlertMsgsByItem.json" 
				editSrc="/art/alertMsg/getAlertMsg.json" submit="NOT" reset="NOT" usePager="false" 
				remove="NOT" add="NOT" edit="详细信息" scrollHeight="360">
		<youi:fieldLayout>
			<youi:fieldHidden property="alertItemId"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="alertMsgInfo" width="240" caption="预警信息"/>
		<youi:gridCol property="alertLevel"  caption="预警级别"/>
		<youi:gridCol property="alertDate"  caption="预警日期"/>
		<youi:gridCol property="alertTime"  caption="预警时间"/>
		<youi:gridCol property="alertStatus"  caption="处理状态"/>
		<youi:gridCol property="operatorTime"  caption="最后操作时间"/>
		
		<youi:button name="closeMsg" caption="处理预警" order="301" />
		
	</youi:grid>
	
	<!-- form-预警信息编辑 -->
	<youi:form dialog="true" caption="预警信息" id="form_alertMsg" idKeys="alertMsgId">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
		<youi:fieldHidden property="alertMsgId"  caption="主键"/>
			<youi:fieldLabel property="alertMsgInfo" width="800" caption="预警信息" column="2"/>
			<youi:fieldLabel property="alertDate"  caption="预警日期"/>
			<youi:fieldLabel property="alertTime"  caption="预警时间"/>
			<youi:fieldLabel property="alertStatus"  caption="处理状态"/>
			<youi:fieldLabel property="operatorTime"  caption="最后操作时间"/>
			<youi:fieldLabel property="alertLevel"  caption="预警级别"  column="2"/>
			<youi:fieldLabel property="alertMsgDetails"  caption="详细信息"  column="2"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>