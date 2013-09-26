<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<youi:subpage id="sbupage_auth" caption="菜单授权" height="460" width="780"
		subpageId="sbupage_auth" src="page/security.fuc.role/auth.html"/>
	
	<youi:subpage id="sbupage_page_auth" caption="页面授权" height="460"
		subpageId="sbupage_page_auth" src="page/security.fuc.role/pageAuth.html?roleId={roleId}"/>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-角色列表-->
	<youi:grid id="grid_role" idKeys="roleId" caption="角色列表" panel="false"
				src="/fuc/role/getPagerRoles.json" dataFormId="form_role"
				editSrc="/fuc/role/getRole.json"
				removeSrc="/fuc/role/removeRole.json">
		<youi:fieldLayout>
			<youi:fieldText operator="LIKE" property="roleId"  caption="角色名"/>
			<youi:fieldText operator="LIKE" property="roleCaption"  caption="角色描述"/>
		</youi:fieldLayout>

		<youi:gridCol width="200" property="roleId"  caption="角色名"/>
		<youi:gridCol width="400" property="roleCaption"  caption="角色描述"/>
		<youi:gridCol property="roleType" convert="roleType" caption="角色分类"/>
		
		<youi:button authCode="addRole" name="auth" caption="菜单授权" active="1" order="201"/>
		<youi:button name="pageAuth" caption="页面授权" order="202" active="1"/>
	</youi:grid>
	
	<!-- form-角色编辑 -->
	<youi:form dialog="true" caption="角色" idKeys="roleId"
		id="form_role" action="/fuc/role/saveRole.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText notNull="true" property="roleId"  caption="角色名"/>
			<youi:fieldText property="roleType"  caption="角色类型"/>
			<youi:fieldText notNull="true" width="602" column="2" property="roleCaption"  caption="角色描述"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="func_grid_auth">
		var subpageElement = $elem('sbupage_auth',pageId),
			gridElement = $elem('grid_role',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		subpageElement.subpage('open',selectedRecord);
	</youi:func>
	
	
	<youi:func name="func_grid_pageAuth">
		var subpageElement = $elem('sbupage_page_auth',pageId),
			gridElement = $elem('grid_role',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		subpageElement.subpage('open',selectedRecord,null,selectedRecord);
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>