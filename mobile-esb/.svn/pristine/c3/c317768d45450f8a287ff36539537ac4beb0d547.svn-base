<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************页面内容********************************-->
	<!-- grid-商户信息表列表-->
	<youi:grid id="grid_merInfo" idKeys="merchantNo"
		dataFormId="form_merInfo" caption="商户信息表列表"
		src="esb/sys/merInfManager/getSignedPagerMerInfs.json" add="NOT"
		editSrc="/esb/sys/merInfManager/getMerInf.json" edit="修改"
	  remove="NOT"  >
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldText property="merchantNo" caption="商户编号" />
			<youi:fieldText property="merName" caption="商户全称" />
			<youi:fieldSelect property="merKind" caption="商户种类" convert="merKind"/>
			<youi:fieldSelect property="merType" caption="商户类型" convert="merType"/>
		</youi:fieldLayout>
		<youi:button name="signout" active="1" submitAction="/esb/sys/merInfManager/signoutMer.json" caption="解约" submitConfirmMsg="确定解约该商户？"/>
		<youi:button name="sign"  caption="签约" />
		<youi:button name="detail" active="2" caption="查看详细" />

		<youi:gridCol property="merchantNo" caption="商户编号" width="130"/>
		<youi:gridCol property="merName" caption="商户全称" width="130"/>
		<youi:gridCol property="merCardnum" caption="商户帐号" width="130"/>
		<youi:gridCol property="merOpenbank" caption="商户开户行" width="130" convert="merOpenbank"/>
		<youi:gridCol property="belongInst" caption="所属机构" convert="instNo" width="130"/>
		<youi:gridCol property="dailyPayLimit" caption="每日交易限额" width="130"/>
		<youi:gridCol property="singlePayLimit" caption="单笔交易限额" width="130"/>
<%-- 		<youi:gridCol property="dailyProcBala" caption="每日收单余额" /> --%>
<%-- 		<youi:gridCol property="singleProcLim" caption="单笔收单限额" /> --%>
	</youi:grid>
	<!-- form-商户签约信息修改 -->
	<youi:form dialog="true" caption="商户签约信息" id="form_merInfo"
		idKeys="merchantNo" action="/esb/sys/merInfManager/signMer.json">
		<youi:fieldLayout prefix="recordDetail" labelWidths="120,120">
			<youi:fieldText property="merchantNo" caption="商户编号" readonly="true" />
			<youi:fieldText property="merName" caption="商户全称" />
			<youi:fieldSelect property="merOpenbank" caption="商户开户行" convert="merOpenbank"/>
			<youi:fieldHidden property="merState" caption="商户状态" />
            <youi:fieldSelect property="belongInst" convert="instNo" caption="机构代码" readonly="true"/>
			<youi:fieldText property="merAddress" caption="商户地址" />
			<youi:fieldText property="merKind" caption="商户种类" readonly="true" />
			<youi:fieldText property="merType" caption="商户类型" readonly="true" />
			<youi:fieldSelect property="settleAccountCycle" caption="结算周期" convert="balCycle" />
			<youi:fieldText property="dailyProcLimit" caption="每日收单限额" /> 
			<youi:fieldText property="singleProcLim" caption="单笔收单限额" />
			<youi:fieldText property="dailyPayLimit" caption="每日交易限额" />
			<youi:fieldText property="singlePayLimit" caption="单笔交易限额" />
			<youi:fieldText property="dailyProcBala" caption="每日收单余额" readonly="true" />
			<youi:fieldSelect property="serviceChargeType" caption="手续费类型"  convert="clrType"/>
			<youi:fieldText property="monthAmount" caption="每月金额" />
			<youi:fieldText property="serviceChargeRate" caption="手续费率" />
			<youi:fieldText property="contactNum" caption="联系电话" maxLength="11"/>
			<youi:fieldCalendar property="signDate" caption="签约日期" format="yyyyMMdd" textFormat="yyyy/MM/dd" readonly="true"/>
<%-- 			<youi:fieldText property="logoutDate" caption="注销日期" /> --%>
			<youi:fieldText property="merCardnum" caption="商户帐号" />
			<youi:fieldText property="contacts" caption="联系人" />
		</youi:fieldLayout>
		<br />
	</youi:form>
	<!-- 商户签约信息弹出窗口 -->
	<youi:form dialog="true" caption="商户签约" id="form_signs"  action="/esb/sys/merInfManager/signMer.json"  >
		<youi:fieldLayout prefix="recordSign" labelWidths="120,120">
			<youi:fieldText property="merchantNo" caption="商户编号" notNull="true"/>
			<youi:fieldText property="merName" caption="商户全称" notNull="true"/>
			<youi:fieldText property="merKind" caption="商户种类" notNull="true"/>
			<youi:fieldText property="merType" caption="商户类型" notNull="true"/>
			<youi:fieldSelect property="belongInst" convert="instNo" caption="机构代码" notNull="true"/>
			<youi:fieldText property="merAddress" caption="商户地址" notNull="true"/>
			<youi:fieldText property="contacts" caption="联系人" notNull="true"/>
			<youi:fieldText property="contactNum" caption="联系电话" maxLength="11" notNull="true"/>
			<youi:fieldSelect property="merOpenbank" caption="商户开户行" notNull="true" convert="merOpenbank"/>
			<youi:fieldText property="merCardnum" caption="商户帐号" notNull="true"/>
			<youi:fieldSelect property="serviceChargeType" caption="手续费类型" notNull="true" convert="clrType"/>
			<youi:fieldText property="monthAmount" caption="每月金额" />
			<youi:fieldText property="serviceChargeRate" caption="手续费率" />
 			<youi:fieldText property="dailyProcLimit" caption="每日收单限额" notNull="true"/> 
			<youi:fieldText property="singleProcLim" caption="单笔收单限额" notNull="true"/>
			<youi:fieldText property="dailyPayLimit" caption="每日交易限额" notNull="true"/>
			<youi:fieldText property="singlePayLimit" caption="单笔交易限额" notNull="true"/>
			<youi:fieldSelect property="settleAccountCycle" caption="结算周期" convert="balCycle" notNull="true"/>
			<youi:fieldCalendar property="signDate" caption="签约日期" format="yyyyMMdd" textFormat="yyyy/MM/dd" notNull="true"/>
<%-- 		<youi:fieldCalendar property="logoutDate" caption="注销日期" format="yyyyMMdd" textFormat="yyyyMMdd" /> --%>
			<youi:fieldHidden property="merState" caption="商户状态" defaultValue="00" />
			<!-- 商户状态：00正常 01 暂停  02 解约 -->
		</youi:fieldLayout>
		<br />
	</youi:form>
	<!--**********************************页面内容********************************-->
	<!--**********************************页面函数********************************-->
	<youi:func name="init">
       <!--给利率 增加%显示-->
	    var signForm = $('#P_030200_recordSign_serviceChargeRate .field-invalid'),
	        modifyForm = $('#P_030200_recordDetail_serviceChargeRate .field-invalid');
            signForm.text('%');
            modifyForm.text('%');
	</youi:func>
	
	<youi:func name="func_grid_sign">
   <!-- 弹出签约form -->
		var gridMerInfo = $elem('grid_merInfo',pageId),
            signForm = $elem('form_signs',pageId);
            signForm.form('clear');
		    signForm.form('open');
	</youi:func>
	
	<youi:func name="recordSign_serviceChargeType_change" >
<!--动态改变 手续费率的必输性-->
	    var  serviceChargeType=$elem('recordSign_serviceChargeType',pageId).fieldValue(),    
            serviceChargeRateLable = $('#P_030200_recordSign_serviceChargeRate'),
            monthAmountLable = $('#P_030200_recordSign_monthAmount');
          if(serviceChargeType == '00'){
             monthAmountLable.parent().prev().addClass('notNull');
             serviceChargeRateLable.parent().prev().removeClass('notNull');
             monthAmountLable.removeClass('readonly disabled');
             serviceChargeRateLable.addClass('readonly disabled');
          }else if(serviceChargeType == '01'){
             monthAmountLable.parent().prev().removeClass('notNull');
             serviceChargeRateLable.parent().prev().addClass('notNull');
             serviceChargeRateLable.removeClass('readonly disabled');
             monthAmountLable.addClass('readonly disabled');
          }else{
             serviceChargeRateLable.parent().prev().removeClass('notNull');
             monthAmountLable.parent().prev().removeClass('notNull');
             monthAmountLable.addClass('readonly disabled');
             serviceChargeRateLable.addClass('readonly disabled');
          }
	</youi:func>
	
	<youi:func name="func_grid_detail">
      <!-- 查看签约明细 -->
		var gridMerInfo = $elem('grid_merInfo',pageId),
            datailForm = $elem('form_merInfo',pageId);
            record = gridMerInfo.grid('getSelectedRecord');
            merchantNo = record.merchantNo;
            datailForm.form('clear');
      <!--根据主键再此做查询-->
           $.youi.ajaxUtil.ajax({
				url:'/esb/sys/merInfManager/getMerInf.json',
				data:'merchantNo='+merchantNo,
				success:function(result){
					  datailForm.form('fillRecord',result.record).form('open');
				  }
		   });	
	</youi:func>
	
	<youi:func name="form_signs_afterSubmit">
    <!-- 签约提交后，关闭form 刷新grid -->
	    var formSigns=$elem('form_signs',pageId),
             gridMerInfo=$elem('grid_merInfo',pageId);
             formSigns.form('close');
             gridMerInfo.grid('refresh');
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>