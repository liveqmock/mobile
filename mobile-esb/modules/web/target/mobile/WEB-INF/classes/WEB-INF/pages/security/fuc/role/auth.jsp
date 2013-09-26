<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:form id="form_role_auth" panel="false" idKeys="roleId" 
		findAction="/fuc/role/getRoleAuth.json"  confirmMessage="确认授权？"
		action="/fuc/role/saveRoleAuth.json">
		<youi:fieldLayout>
			<youi:fieldHidden property="roleType"/>
			<youi:fieldLabel property="roleId"  caption="角色名"/>
			<youi:fieldLabel property="roleCaption"  caption="角色描述"/>
		</youi:fieldLayout>
		
		<fieldset>
			<legend>选择功能菜单</legend>
			<youi:fieldLayout styleClass="hideLabel" labelWidths="1" columns="1">
				<youi:fieldTree property="menus" popup="false" height="360" width="730" valueMode="object"
					show="menuCaption" code="menuId" caption=""
					tree="${menuTree}" check="true" simple="false"/>
			</youi:fieldLayout>
		</fieldset>
		
		<youi:button name="closeDialog" caption="关闭" order="400"/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="subpage_init" params="record">
		var formElement = $elem('form_role_auth',pageId);
		formElement.form('fillRecord',record);//填充数据
		//从后台查询数据填充到form中
		formElement.form('loadRecord',function(results){
			
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>