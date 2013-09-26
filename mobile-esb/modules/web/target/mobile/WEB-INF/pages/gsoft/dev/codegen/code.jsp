<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述：查看代码 -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:form id="form_codes" panel="false" idKeys="entityName"
		findAction="/dev/code/viewModelCode.json" reset="NOT" submit="NOT">
		<youi:fieldLayout columns="1">
			<youi:fieldLabel property="entityName" caption="entityName"/>
		</youi:fieldLayout>
		<youi:tabs id="tabs_codes" 
			itemSrc="/page/gsoft.dev.codegen/show.html" itemHeight="360">
		</youi:tabs>
	</youi:form>
	
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="subpage_init" params="record">
		var formElement = $elem('form_codes',pageId),
			tabsElement = $elem('tabs_codes',pageId);
		formElement.form('fillRecord',record);
		
		tabsElement.tabs('option','maxOpenTab',100);
		tabsElement.tabs('option','showClose',false);
		
		//删除之前的内容
		tabsElement.tabs('removeAll');
		
		formElement.form('loadRecord',function(resultRecord){
			var codes = resultRecord.codes;
			$(codes).each(function(){
				tabsElement.tabs('addTab',this.codeId,this.codeFilename);
			});
			tabsElement.tabs('selectIndex',0);
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>