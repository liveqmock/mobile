<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	<!--**********************************页面内容********************************-->
	<youi:table>
		<youi:cell width="300">
			<div style="height:430px;overflow:hidden;">
				<youi:tree id="tree_menu"
					 dataFormId="form_menu" idAttr="menuId" pidAttr="parentMenuId" textAttr="menuCaption"
				 tree="${menuTree}"></youi:tree>
			</div>
		</youi:cell>
		<youi:cell>
			<!-- form-系统菜单编辑 -->
			<youi:form caption="编辑系统菜单" id="form_menu" panel="false"
				action="/fuc/menu/saveMenu.json"
				findAction="/fuc/menu/getMenu.json" idKeys="menuId"
				removeAction="/fuc/menu/removeMenu.json">
				<youi:tabs id="tabs_menu">
					<youi:tabItem caption="基本信息" id="base">
						<div style="height:26px;">
							<youi:fieldLayout styleClass="hide tree-binder" id="fieldLayout_add" columns="1">
								<youi:fieldRadioGroup property="addType" defaultValue="1" caption="新增位置" convert="treeNodeAddType"/>
							</youi:fieldLayout>
						</div>
						<youi:fieldLayout prefix="record" columns="1">
							<youi:fieldText notNull="true"  width="502" property="menuId"  caption="菜单编号"/>
							<youi:fieldHidden styleClass="field-parent" property="parentMenuId"  caption="父菜单"/>
							
							<youi:fieldLabel width="502" property="parentTextTrace"  caption="父级菜单"/>
							<youi:fieldText notNull="true" width="502" property="menuCaption"  caption="菜单名称"/>
							<youi:fieldText width="502" property="menuStyle"  caption="菜单样式"/>
							<youi:fieldRadioGroup property="subpage" convert="boolean" defaultValue="0" caption="是否子页面"/>
							<youi:fieldText width="502" property="menuSrc"  caption="菜单地址"/>
							<youi:fieldText width="502" property="menuNum"  caption="菜单序号"/>
							
						</youi:fieldLayout>
					</youi:tabItem>
					<youi:tabItem caption="页面元素可见权限配置" id="pageElements">
						<youi:fieldLayout prefix="record" columns="1" labelWidths="1">
							<youi:fieldGrid property="pageElements" width="795">
								<youi:grid editable="true" panel="false" idKeys="pk.menuId,pk.pageElementId">
									<youi:gridCol editor="fieldText" property="pk.pageElementId" width="200" caption="授权标识"/>
									<youi:gridCol editor="fieldText" property="pageElementCaption" caption="组件描述"/>
								</youi:grid>
							</youi:fieldGrid>
						</youi:fieldLayout>
					</youi:tabItem>
				</youi:tabs>
				
				<youi:button name="add" caption="新增"/>
			</youi:form>
		</youi:cell>
	</youi:table>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>