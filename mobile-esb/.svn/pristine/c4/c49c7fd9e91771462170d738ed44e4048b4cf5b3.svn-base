<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-客户信息管理-->
	<youi:grid id="grid_ClientInf" idKeys="clientId" dataFormId="form_detail"  caption="客户信息管理" 
				src="/esb/sys/clientInfManager/getPagerClientInfs.json" panel="false"
				editSrc="/esb/sys/clientInfManager/getClientInf.json"
				add="NOT"  remove="NOT"   edit="详细信息">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="documentType"  convert="documentType"   caption="证件类型"/>
			<youi:fieldText property="documentNum"  caption="证件号码"/>
			<youi:fieldText property="mainAccount"  caption="主账号"/>
			<youi:fieldText property="contactNum"  caption="手机号码"/>	
		</youi:fieldLayout>
		
		<youi:button name="signs" caption="签约明细" active="1"/>
		<youi:button name="deleteClient" caption="删除客户" active="2" 
					submitAction="/esb/sys/clientInfManager/removeClientInf.json" 
					submitType="2" order="401" submitConfirmMsg="确认删除客户？"/>
	
		<youi:gridCol width="120" property="clientName"  caption="客户姓名"/>
		<youi:gridCol width="180" property="mainAccount"  caption="主账号"/>
		<youi:gridCol width="80" property="documentType"  convert="documentType"  caption="证件类型"/>
		<youi:gridCol width="160" property="documentNum"  caption="证件号码"/>
		<youi:gridCol width="120" property="contactNum"  caption="手机号码"/>
		<youi:gridCol property="clientState" convert="FooState"  caption="客户状态"/>
		<youi:gridCol width="180" property="clientAddress"  caption="当前地址"/>
	    <youi:gridCol  property="" caption="" />
	</youi:grid>	
	
	<youi:form dialog="true" caption="客户" id="form_detail" action="" submit="NOT" reset="NOT">
		<youi:fieldLayout prefix="record" columns="2">
			<youi:fieldHidden property="clientId"  caption="客户ID"/>
			
			<youi:fieldLabel  property="clientName"  caption="客户姓名"/>
			<youi:fieldLabel  property="contactNum"  caption="手机号码"/>
			
			<youi:fieldLabel convert="documentType" property="documentType"  caption="证件类型"/>
			<youi:fieldLabel  property="documentNum"  caption="证件号码"/>
			
			<youi:fieldLabel property="mainAccount" column="2" caption="主账号"/>
			<youi:fieldLabel column="2" width="602" property="clientAddress"  caption="当前地址"/>
			
			<youi:fieldLabel  property="clientState"  convert="FooState"  caption="客户状态"/>
			<youi:fieldLabel  property="terminalBrand"  caption="终端品牌"/>
			<youi:fieldLabel  property="terminalModel"  caption="终端型号"/>
			<youi:fieldLabel  property="terminalState"  caption="终端状态"/>
		</youi:fieldLayout>
		
		<fieldset>
			<legend>绑定的银行卡</legend>
			<div style="position:relative;height:300px;">
				<youi:fieldLayout labelWidths="1" columns="1">
					<youi:fieldGrid property="accInfs" caption="" width="0">
						<youi:grid id="grid_accInfs"  panel="false">
							<youi:gridCol width="200" property="bankcardNum" caption="银行卡号"/>
							<youi:gridCol property="balance" caption="余额"/>
							<youi:gridCol property="affordCardInst" caption="发卡机构"/>
							<youi:gridCol property="accountState" convert="cardState" caption="账户状态"/>
							<youi:gridCol property="currType" convert="currType" caption="币种"/>
							<youi:gridCol property="accountType" convert="cardType" caption="账户类型"/>
							<youi:gridCol property="rate" caption="利率"/>
						</youi:grid>
					</youi:fieldGrid>
				</youi:fieldLayout>
			</div>
		</fieldset>
	</youi:form>
	
	<!-- 客户签约信息弹出窗口 -->
	<youi:form dialog="true" id="form_signs" caption=""  submit="NOT" reset="NOT">
		<div style="position:relative;height:300px;">
			<youi:grid id="grid_signs" panel="false" submit="NOT" edit="NOT"
				load="false" src="/esb/sys/clientInfManager/getClientSignInfs.json"
				reset="NOT" remove="NOT" add="NOT" usePager="false">
				<youi:fieldLayout prefix="signs" id="fieldLayout_signs">
					<youi:fieldHidden property="clientId"/>
				</youi:fieldLayout>
				<youi:gridCol width="180" property="bankcardNum" caption="银行卡号"/>
				<youi:gridCol property="signDate" caption="签约日期" type="date" format="yyyyMMdd" textFormat="yyyy-MM-dd" />
				<youi:gridCol property="dailyPayLimit" caption="每日交易限额"/>
				<youi:gridCol property="singlePayLimit" caption="单笔交易限额"/>
				<youi:gridCol property="signBusiness"  convert="signBusiness" caption="签约业务"/>
				<youi:gridCol property="clientState" convert="FooState"  caption="客户状态"/>
				<youi:gridCol property="logoutDate" caption="注销日期" type="date" format="yyyyMMdd" textFormat="yyyy-MM-dd" />
			</youi:grid>
		</div>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<!--  -->
	<youi:func name="func_grid_signs">
		var gridElem = $elem('grid_ClientInf',pageId),
			signForm = $elem('form_signs',pageId),
			signGridElem = $elem('grid_signs',pageId),
			record = gridElem.grid('getSelectedRecord');
		
		signForm.form('fillRecord',record);
		signGridElem.grid('refresh');
		signForm.form('open',record.clientName+'签约信息查看');
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>