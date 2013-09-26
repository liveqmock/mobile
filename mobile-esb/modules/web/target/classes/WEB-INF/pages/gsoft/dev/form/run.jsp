<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:html i18n="i18n.index" title="表单测试">
	<head>
		<%@ include file="/WEB-INF/pages/common/commonScriptAndCss.jsp"%>
	</head>
	
	<body>
		<youi:fieldLayout columns="1">
			<youi:fieldHidden property="formId" caption="formId"/>
			<youi:fieldLabel property="formCaption" caption="表单"/>
		</youi:fieldLayout>
		<div id="page_container">
		
		</div>
		<script type="text/javascript">
			var pageId = '';
 			$(function(){
				var formId = $('input[name="formId"]:first').val();
				var pageUrl = '/page/gsoft.dev.form.run/'+formId+'.html?page:pageId='+formId;
				//加载测试页面
				$.youi.pageUtils.loadPage($('#page_container'),pageUrl);
			});
		</script>
	</body>
</youi:html>