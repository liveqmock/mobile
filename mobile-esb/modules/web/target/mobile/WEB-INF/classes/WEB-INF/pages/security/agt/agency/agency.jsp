<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.agt">
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:table>
		<youi:cell width="200">
			<div style="height:360px;overflow:auto;">
				<youi:tree id="tree_agency" dataFormId="form_agency"
					hideRoot="false" rootText="机构"
					iteratorSrc="/agt/agency/getChildren.json" iteratorParam="agencyId"
					idAttr="agencyId" textAttr="agencyCaption" pidAttr="parentAgencyId"/>
			</div>
		</youi:cell>
		<youi:cell>
			<!-- form-机构编辑 -->
			<youi:form caption="i18n.agency" id="form_agency"  submit="i18n.youi.tag.save"
				idKeys="agencyId"
				findAction="/agt/agency/getAgency.json"
				action="/agt/agency/saveAgency.json"
				removeAction="/agt/agency/removeAgency.json">
				
				<youi:fieldLayout styleClass="hide tree-binder" id="fieldLayout_add">
					<youi:fieldRadioGroup property="addType" defaultValue="1" caption="新增位置" convert="treeNodeAddType"/>
				</youi:fieldLayout>
				
				<youi:fieldLayout prefix="record" columns="1">
					<youi:fieldHidden property="agencyId"  caption="机构ID"/>
					<youi:fieldHidden property="parentAgencyId"  caption="父级机构"/>
					<youi:fieldLabel width="502" property="parentTextTrace"  caption="i18n.agency.parent"/>
					<youi:fieldText notNull="true" width="502" property="agencyCode"  caption="i18n.agency.code"/>
					<youi:fieldText notNull="true" width="502" property="agencyCaption"  caption="i18n.agency.caption"/>
					<youi:fieldText width="502" property="agencyPath"  caption="i18n.agency.path"/>
					<youi:fieldText width="502" property="leaf" defaultValue="1" caption="i18n.agency.leaf"/>
				</youi:fieldLayout>
				
				<youi:button name="add" caption="新 增"/>
			</youi:form>
		</youi:cell>
	</youi:table>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>