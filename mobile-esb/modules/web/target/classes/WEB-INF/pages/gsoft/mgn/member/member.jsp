<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- grid -->
	<youi:grid 
			idKeys="userId" dataFormId="form_user" editSrc="data/user.form.data"
			caption="i18n.user" 
			id="grid_user" 
			showCheckbox="true"
			src="data/user.grid.data">
		<youi:fieldLayout prefix="query">
			<youi:fieldText property="userName" caption="i18n.user.userName"/>
			<youi:fieldSelect property="active" convert="boolean" caption="active"/>
		</youi:fieldLayout>
		
		<youi:gridCol orderBy="desc" width="200" property="userId" caption="id"/>
		<youi:gridCol width="200" property="userName" caption="i18n.user.userName"/>
		<youi:gridCol width="500" convert="boolean"  property="userCaption" caption="i18n.user.userCaption"/>
	</youi:grid>
	<!-- form -->
	<youi:form dialog="true" id="form_user" caption="i18n.user">
		<youi:fieldLayout height="360" prefix="record">
			<youi:fieldText property="userName" caption="i18n.user.userName"/>
		</youi:fieldLayout>
	</youi:form>
</youi:page>
