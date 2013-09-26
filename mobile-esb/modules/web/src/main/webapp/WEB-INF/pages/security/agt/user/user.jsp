<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<youi:style href="/styles/page/user.css"/>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-用户列表-->
	<youi:grid id="grid_user" idKeys="userId" caption="用户列表" panel="false"
				src="/agt/user/getPagerUsers.json" dataFormId="form_user"
				editSrc="/agt/user/getUser.json"
				removeSrc="/agt/user/removeUser.json">
		<youi:fieldLayout>
			<youi:fieldText property="loginName"  caption="登录名"></youi:fieldText>
			<youi:fieldText property="userCaption"  caption="用户名称"></youi:fieldText>
		</youi:fieldLayout>

		<youi:gridCol width="200" property="loginName"  caption="登录名"/>
		<youi:gridCol width="400"  property="userCaption"  caption="用户名称"/>
		<youi:gridCol property="userActive" convert="boolean" caption="是否生效"/>
	</youi:grid>
	
	<!-- form-用户编辑 -->
	<youi:form dialog="true" caption="用户" id="form_user" action="/agt/user/saveUser.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="userId"  caption="用户ID"/>
			<youi:fieldText notNull="true" property="loginName"  caption="登录名"/>
			<youi:fieldText notNull="true" property="userCaption"  caption="用户名称"/>
			<youi:fieldHidden property="userActive"  caption="是否生效"/>
		</youi:fieldLayout>
		<fieldset>
			<legend>选择用户角色</legend>
			<youi:fieldLayout labelWidths="1" columns="1">
				<youi:fieldTree property="roles" popup="false" valueMode="object"
					show="roleCaption" code="roleId" caption=""
					tree="${roleTree}" check="true" simple="false"/>
			</youi:fieldLayout>
		</fieldset>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>