<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************页面内容********************************-->
	<!-- grid-商户信息表列表-->
	<youi:grid id="grid_merInfo" idKeys="merchantNo"
		dataFormId="form_merInfo" caption="商户信息表列表"
		src="esb/sys/merInfManager/getPagerMerInfs.json" add="NOT" edit="NOT"
		remove="NOT">
		<youi:fieldLayout labelWidths="120,120">
				<youi:fieldTree width="380" property="belongInst" caption="机构代码" popup="true" simple="false"
			 src="/esb/sys/instManager/getInstNoByParentNo.json" iteratorParentAttr="instNo" code="instNo" show="instCaption"/>
		</youi:fieldLayout>
		<youi:button name="pauseRecov" active="1" caption="停止/恢复" />
		<youi:gridCol property="merchantNo" caption="商户编号" width="170"/>
		<youi:gridCol property="merName" caption="商户全称" width="170"/>
		<youi:gridCol property="merAddress" caption="商户地址" width="170"/>
		<youi:gridCol property="contacts" caption="联系人" width="170"/>
		<youi:gridCol property="contactNum" caption="联系电话" width="170"/>
		<youi:gridCol property="merState" caption="商户状态" convert="FooState" />
	</youi:grid>

	<!--**********************************页面内容********************************-->

	<!--**********************************页面函数********************************-->
	<youi:func name="func_grid_pauseRecov">
    var gridMerInfo = $elem('grid_merInfo',pageId);
        record = gridMerInfo.grid('getSelectedRecord');
      if('02' == record.merState){
           alert('该商户已解约，不能进行此操作！');
           return;
       }
        $.youi.ajaxUtil.ajax({
				url:'/esb/sys/merInfManager/updateMerInfState.json',
				data:'merchantNo='+record.merchantNo,
				success:function(result){
					   if('00' == record.merState){
      	                  alert('该商户已停止交易！');
                      }else if('01' == record.merState) {
      	                  alert('该商户可以正常交易！');
                      }
                      gridMerInfo.grid('refresh');
				  }
		});
     
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>