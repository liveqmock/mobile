<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->

	<!--**********************************子页面**********************************-->

	<!--**********************************页面内容********************************-->
	<!-- 黑名单管理 -->
	<youi:grid id="grid_BlInf" idKeys="bankcardNum"
		dataFormId="form_detail" caption="黑名单信息管理"
		src="/esb/sys/blInfManager/getPagerBlInfs.json" panel="false"
		add="NOT" remove="NOT" edit="NOT">
		<youi:fieldLayout>
			<youi:fieldText operator="LIKE" property="bankcardNum" caption="银行卡号" />
		</youi:fieldLayout>
		
		<youi:button name="addBlackList" caption="添加/撤销黑名单" />
		
		<youi:gridCol width="160" property="bankcardNum" caption="卡号" />
		<youi:gridCol width="100" property="cardholder" caption="客户姓名" />
		<youi:gridCol width="80" property="balcklistState"
			convert="balcklistState" caption="黑名单状态" />
		<youi:gridCol  width="120" property="addQuitReason" convert="addQuitReason" caption="添加/撤出原因" />
		<youi:gridCol property="documentType" convert="documentType"
			caption="证件类型" />
		<youi:gridCol width="140" property="documentNum" caption="证件号码" />
		<youi:gridCol property="cardType" convert="cardType" caption="卡类型" />
		<youi:gridCol property="cardState" convert="cardState" caption="卡状态" />
		<youi:gridCol property="effectDate" caption="生效日期" type="date" format="yyyyMMdd" textFormat="yyyy-MM-dd" >	
		</youi:gridCol>
		<youi:gridCol property="" caption=""></youi:gridCol>
	</youi:grid>
	
	<youi:form dialog="true" id="form_detail" submit="提交" reset="NOT" 
		action="/esb/load/blInfManager/changeBlackListState.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120" columns="2" >
			<youi:fieldLabel property="bankcardNum" caption="卡号" column="2" />
			<youi:fieldLabel property="cardholder" caption="客户姓名" />
			<youi:fieldSelect property="balcklistState" convert="balcklistState" caption="黑名单状态" readonly="true" />
			<youi:fieldSelect property="documentType" convert="documentType" caption="证件类型" readonly="true"  />
			<youi:fieldLabel property="documentNum" caption="证件号码" />
			<youi:fieldSelect property="cardType" convert="cardType" caption="卡类型" readonly="true"  />
			<youi:fieldSelect property="cardState"   convert="cardState" caption="卡状态"  readonly="true" />
			<youi:fieldSelect src="/base/codeitem/getCodeitems.json?codemap.codemapId=ff80808140ccdc9f0140ccf988df0002&operator:itemValue=START"
			    parents="balcklistState"  parentsAlias="itemValue" code="itemValue"
				show="itemCaption"  property="addQuitType" caption="添加/撤出类型" notNull="true" />

			<youi:fieldSelect
				src="/base/codeitem/getCodeitems.json?codemap.codemapId=4028ab1940c9e3ab0140ca0539210001&operator:itemValue=START"
				parents="addQuitType" parentsAlias="itemValue" code="itemValue"
				show="itemCaption" property="addQuitReason" caption="添加/撤出原因" notNull="true" />
			<youi:fieldLabel property="effectDate" caption="生效日期"  />
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面内容********************************-->

	<!--**********************************页面函数********************************-->
	<youi:func name="func_grid_addBlackList">
      
	   var gridElem = $elem('grid_BlInf',pageId),
			signForm = $elem('form_detail',pageId),
			record = gridElem.grid('getSelectedRecord');
        record.addQuitReason="";
		signForm.form('fillRecord',record);
		signForm.form('open','添加/撤销黑名单');
    </youi:func>
    <youi:func name="form_detail_afterSubmit">
         var gridElem = $elem('grid_BlInf',pageId);
         gridElem.grid('refresh');
    </youi:func>

	<!--**********************************页面函数********************************-->
</youi:page>