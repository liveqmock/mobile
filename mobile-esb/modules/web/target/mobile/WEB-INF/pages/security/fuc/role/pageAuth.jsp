<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:form id="form_role_auth" panel="false" idKeys="roleId" 
		findAction="/fuc/role/getRoleAuth.json"  confirmMessage="确认授权？"
		action="/fuc/role/saveRolePageAuth.json">
		<youi:fieldLayout>
			<youi:fieldHidden property="roleType"/>
			<youi:fieldLabel property="roleId"  caption="角色名"/>
			<youi:fieldLabel property="roleCaption"  caption="角色描述"/>
		</youi:fieldLayout>
		
		<fieldset>
			<legend>选择页面元素</legend>
			
			
			<youi:table columns="3">
				<youi:cell>
					<div style="height:341px;overflow:auto;">
						<youi:tree width="400" id="tree_menu_pageElements" tree="${menuTree}"/>
					</div>
				</youi:cell>
					
				<youi:cell width="90" valign="middle">
					<youi:buttons id="buttons_rolePageElements" vertical="true">
						<youi:button name="addAll" caption="全部添加"/>
						<youi:button name="addSelected" caption="添加选择"/>
						<youi:button name="removeSelected" caption="移除选择"/>
						<youi:button name="removeAll" caption="移除全部"/>
					</youi:buttons>
				</youi:cell>
				
				<youi:cell width="420">
					<youi:fieldLayout styleClass="hideLabel" labelWidths="1" columns="1">
						<youi:fieldGrid property="rolePageElements" width="400">
							<youi:grid id="grid_rolePageElements" panel="false" idKeys="pk.menuId,pk.pageElementId" scrollHeight="310" showCheckbox="true">
								<youi:gridCol width="0" property="pk.roleId" caption="角色"/>
								<youi:gridCol width="100" property="pk.menuId" caption="菜单"/>
								<youi:gridCol width="100" property="pk.pageElementId" caption="页面元素"/>
							</youi:grid>
						</youi:fieldGrid>
					</youi:fieldLayout>
				</youi:cell>
			</youi:table>
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
	
	<!-- 添加全部 -->
	<youi:func name="func_button_addAll">
		var treeElement = $elem('tree_menu_pageElements',pageId),
			gridElement = $elem('grid_rolePageElements',pageId),
			formElement =  $elem('form_role_auth',pageId),
			roleId = formElement.find('.youi-field[property=roleId]').fieldValue();
		
		var idKeysCompareMap = {};
		gridElement.find('.grid-content .grid-scroll .row').each(function(){
			idKeysCompareMap[this.getAttribute('id').replace(/,/g,'_')]=true;
		});
		
		treeElement.find('li.treeNode.pageElement').each(function(){
			var id = this.getAttribute('id');
			if(idKeysCompareMap[id]!=true){
				gridElement.grid('addRow',{
					pk:{
						roleId:roleId,
						menuId:id.split('_')[0],
						pageElementId:id.split('_')[1]
					}
				});
			}
		});
		idKeysCompareMap = null;
		gridElement = null;
		treeElement = null;
	</youi:func>
	<!-- 添加选择 -->
	<youi:func name="func_button_addSelected">
		var treeElement = $elem('tree_menu_pageElements',pageId),
			gridElement = $elem('grid_rolePageElements',pageId),
			formElement =  $elem('form_role_auth',pageId),
			roleId = formElement.find('.youi-field[property=roleId]').fieldValue();
		
		var idKeysCompareMap = {};
		gridElement.find('.grid-content .grid-scroll .row').each(function(){
			idKeysCompareMap[this.getAttribute('id').replace(/,/g,'_')]=true;
		});
		
		treeElement.find('li.treeNode.pageElement.checked').each(function(){
			var id = this.getAttribute('id');
			if(idKeysCompareMap[id]!=true){
				gridElement.grid('addRow',{
					pk:{
						roleId:roleId,
						menuId:id.split('_')[0],
						pageElementId:id.split('_')[1]
					}
				});
			}
		});
		idKeysCompareMap = null;
		gridElement = null;
		treeElement = null;	
	</youi:func>
	<!-- 移除选择 -->
	<youi:func name="func_button_removeSelected">
		var gridElement = $elem('grid_rolePageElements',pageId);
		
		gridElement.find('.grid-content tr.row.selected').remove();
	</youi:func>
	
	<!-- 移除全部 -->
	<youi:func name="func_button_removeAll">
		var gridElement = $elem('grid_rolePageElements',pageId);
		gridElement.grid('parseRecords',[],0);
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>