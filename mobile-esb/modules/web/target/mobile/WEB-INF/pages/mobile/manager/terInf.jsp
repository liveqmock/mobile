<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************页面内容********************************-->
	<!-- grid-终端信息表列表-->
	<youi:grid id="grid_terInf" idKeys="terminalNo" dataFormId="form_terInf"  caption="终端信息表列表" 
				src="esb/sys/terInfManager/getPagerTerInfs.json"  edit="NOT" remove="NOT" add = "NOT">
		<youi:fieldLayout labelWidths="120,120" prefix="terInf">
			<youi:fieldText property="phoneNum"  caption="手机号码"/>
<%-- 			<youi:fieldSelect property="belongInst" convert="instNo" caption="机构代码"/> --%>
			
			<youi:fieldTree width="200" property="belongInst" caption="机构代码" popup="true" simple="false"
			 src="/esb/sys/instManager/getInstNoByParentNo.json" iteratorParentAttr="instNo" code="instNo" show="instCaption"/>
			
			<youi:fieldSelect property="terminalBrand" convert="terminalBrand" caption="终端品牌"/>
			<youi:fieldSelect property="terminalModel" convert="terminalModel" caption="终端型号"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="belongInst"  caption="所属机构" convert="instNo"/>
		<youi:gridCol property="phoneNum"  caption="手机号码"/>
		<youi:gridCol property="terminalBrand"  caption="终端品牌" convert="terminalBrand"/>
		<youi:gridCol property="terminalModel"  caption="终端型号" convert="terminalModel"/>
		<youi:gridCol property="currPosition"  caption="当前位置"/>
		<youi:gridCol property="belongMerchant"  caption="所属商户"/>
		<youi:gridCol property="terminalState"  caption="终端状态" convert="terminalState"/>

		<youi:button name="pauseRecov" active="1" 
			 caption="暂停/恢复" />
		<youi:button name="cancel" active="2" submitAction="/esb/sys/terInfManager/cancelTerInf.json"
			submitConfirmMsg="确认注销？" caption="注销" />
	</youi:grid>
	
	<!-- form-终端信息表编辑 -->
	<youi:form dialog="true" caption="终端信息表" id="form_terInf" idKeys="terminalNo"
		action="/esb/sys/terInfManager/saveTerInf.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldSelect property="belongInst" convert="instNo" caption="所属机构"/>
<%-- 			<youi:fieldText property="merchantNo"  caption="商户编号"/> --%>
			<youi:fieldText property="phoneNum"  caption="手机号码"/>
		    <youi:fieldSelect property="terminalBrand" convert="terminalBrand" caption="终端品牌"/>
			<youi:fieldSelect property="terminalModel" convert="terminalModel" caption="终端型号"/>
			<youi:fieldText property="currPosition"  caption="当前位置"/>
			<youi:fieldText property="belongMerchant"  caption="所属商户"/>
			<youi:fieldSelect property="terminalState" convert="terminalState"  caption="终端状态"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="func_grid_pauseRecov"> 
      	var gridElem = $elem('grid_terInf',pageId),
           record = gridElem.grid('getSelectedRecord');
           if('02' == record.terminalState){
               alert('该商户已注销，不能做此操作！');
               return ;
            }
       	 $.youi.ajaxUtil.ajax({
				url:'/esb/sys/terInfManager/updateTerInfState.json',
				data:'terminalNo=' + record.terminalNo,
 				success:function(result){
 			       alert('修改成功！');
                   $elem('grid_terInf',pageId).grid('refresh');
			 }
		});	 
	</youi:func> 


	<!--**********************************页面函数********************************-->
</youi:page>