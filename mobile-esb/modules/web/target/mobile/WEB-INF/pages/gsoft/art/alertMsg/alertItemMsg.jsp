<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-报警信息列表-->
	<youi:grid id="grid_alertMsg" idKeys="alertMsgId" dataFormId="form_alertMsg"  caption="报警信息列表" 
				src="/art/alertMsg/getAlertMsgsByItem.json" 
				editSrc="/art/alertMsg/getAlertMsg.json" submit="NOT" reset="NOT" usePager="false" 
				remove="NOT" add="NOT" edit="详细信息" scrollHeight="360">
		<youi:fieldLayout>
			<youi:fieldHidden property="alertItemId"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="alertMsgInfo" params="alertMsgId" type="link"  width="240" caption="报警信息"/>
		<youi:gridCol property="alertLevel"  highlight="return record.alertLevel==3;" convert="alertLevel" caption="报警级别"/>
		<youi:gridCol property="alertDate"  caption="报警日期"/>
		<youi:gridCol property="alertTime"  caption="报警时间"/>
		<youi:gridCol property="alertStatus" caption="处理状态"/>
		<youi:gridCol property="operatorTime"  caption="最后操作时间"/>
		
		<youi:button name="closeMsg" caption="处理报警" order="301" />
		
	</youi:grid>
	
	<!-- form-报警信息编辑 -->
	<youi:form dialog="true" caption="报警信息" id="form_alertMsg" idKeys="alertMsgId" submit="NOT" reset="NOT">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
		<youi:fieldHidden property="alertMsgId"  caption="主键"/>
			<youi:fieldLabel property="alertMsgInfo" width="800" caption="报警信息" column="2"/>
			<youi:fieldLabel property="alertDate"  caption="报警日期"/>
			<youi:fieldLabel property="alertTime"  caption="报警时间"/>
			<youi:fieldLabel property="alertStatus"  caption="处理状态"/>
			<youi:fieldLabel property="operatorTime"  caption="最后操作时间"/>
			<youi:fieldLabel property="alertLevel" convert="alertLevel"  caption="报警级别"  column="2"/>
			<youi:fieldLabel property="alertMsgDetails"  caption="详细信息"  column="2"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="grid_alertMsg_select">
		//alert(1);
	</youi:func>
	<youi:func name="grid_alertMsg_link_alertMsgInfo" params="rowId">
		if(rowId==3){//
			var pageId='link';
			var pageUrl='page/gsoft.art.alertMsg/netgrapic.html?page:pageId='+pageId;
			var pageTitle='前置A链路图';
			$('body',document).borderLayout('loadPage',pageId,pageUrl,pageTitle);
		}else{
			var pageId='link1';
			var pageUrl='page/gsoft.art.alertSys/alertSys.html?page:pageId='+pageId;
			var pageTitle='aaa';
			$('body',document).borderLayout('loadPage',pageId,pageUrl,pageTitle);
		}
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>