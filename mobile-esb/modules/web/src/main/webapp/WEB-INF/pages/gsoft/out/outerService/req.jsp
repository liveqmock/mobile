<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	
	
	
	<youi:grid load="false" panel="false" src="/trans/acc/accQry.json?serviceName=InnOpCnlErrQry"
		reset="NOT" add="NOT" edit="NOT" remove="NOT">
		<div id="req_fieldLayout_param_container" style="height:200px;overflow:auto;">
	
		</div>
		<youi:gridCol property="resXml" caption="xml"/>
	</youi:grid>
	<div id="req_fieldLayout_param_soapXml" style="width:600px;height:200px;overflow:auto;border:1pt solid silver;">
		<pre></pre>
	</div>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="subpage_init" params="record">
		//alert('sub'+record.outerServiceId);
		var outerServiceId = record.outerServiceId;
		$.youi.ajaxUtil.ajax({
			url:'/out/outerServiceParam/getOuterServiceParams.json?outerService.outerServiceId='+outerServiceId,
			success:function(result){
				var records  = result.records;
				
				var fields = [];
				var dataFieldPaths = {};
				$(records).each(function(){
					if('req'==this.paramType){
						fields.push({
							property:this.paramName,
							caption:this.paramCaption
						});
						dataFieldPaths[this.paramName] = this.paramXpath;
					}
				});
				
				var fieldLayoutElement = $('<div data-fieldPaths="{}"></div>');
				$('#req_fieldLayout_param_container').empty().append(fieldLayoutElement);
				
				fieldLayoutElement.data('fieldPaths',dataFieldPaths).fieldLayout({
					fields:fields
				});
			}
		});
		//fieldLayout
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>