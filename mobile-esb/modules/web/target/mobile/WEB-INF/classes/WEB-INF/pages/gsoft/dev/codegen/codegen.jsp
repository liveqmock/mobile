<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 界面描述：代码生成 -->
	<!--**********************************子页面**********************************-->
	<youi:subpage height="420" caption="查看代码" subpageId="050201" src="/page/gsoft.dev.codegen/code.html" id="subpage_code"/>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:table width="100%">
		<youi:cell width="200px">
			<div style="width:200px;height:440px;overflow-x:hidden;overflow-y:auto;">
				<youi:tree width="500" id="tree_model" tree="${modelTree}"/>
			</div>
		</youi:cell>
		<youi:cell>
			<youi:form submit="保存实体" action="/des/entity/saveEntity.json" panel="false"
				idKeys="entityName"
				findAction="/des/entity/getEntityByName.json" id="form_model" caption="实体模型">
				<youi:tabs id="tabs_model" itemHeight="360">
					<youi:tabItem caption="基本信息" id="model_base">
						<youi:fieldLayout id="fieldLayout_base" columns="1">
							<youi:fieldLabel width="502" property="entityId"  caption="模型主键"/>
							<youi:fieldText notNull="true" readonly="true" width="502" property="module.moduleId"  caption="模块主键"/>
							<youi:fieldText width="502" notNull="true" property="entityName" caption="模型名"/>
							<youi:fieldText property="entityCode"  caption="模型编码"/>
							<youi:fieldLabel width="502"  property="module.moduleCaption" caption="所属模块"/>
							<youi:fieldText width="502" property="entityTable"  caption="表名"/>
							<youi:fieldText width="502" property="entityCaption" caption="模型描述"/>
						</youi:fieldLayout>
					</youi:tabItem>
					<youi:tabItem caption="普通属性" id="model_attr">
						<youi:fieldLayout styleClass="hideLabel"  columns="1" labelWidths="0">
							<youi:fieldGrid width="0" property="entityAttrs" caption="">
								<youi:grid panel="false" showCheckbox="true" idKeys="attrName"  editable="true">
									<youi:gridCol width="150" property="attrName" caption="属性名" editor="fieldText"/>
									<youi:gridCol property="idAttr" caption="主键标识" editor="fieldText"/>
									<youi:gridCol width="260" property="attrCaption" caption="属性描述"  editor="fieldText"/>
									<youi:gridCol property="dataType" caption="数据类型" editor="fieldText"/>
									<youi:gridCol width="150" property="attrColumn" caption="属性列" editor="fieldText"/>
									<youi:gridCol width="40" property="attrLength" caption="长度"  
											editor="fieldText" editorOptions="{dataType:'integer'}"/>
								</youi:grid>
							</youi:fieldGrid>
						</youi:fieldLayout>
					</youi:tabItem>
					<youi:tabItem caption="外键属性" id="model_fore_attr">
						<youi:fieldLayout styleClass="hideLabel" columns="1" labelWidths="0">
							<youi:fieldGrid width="0" property="foreignAttrs" caption="">
								<youi:grid panel="false" showCheckbox="true" idKeys="attrName" editable="true">
									<youi:gridCol width="150" property="attrName" caption="属性名"  editor="fieldText"/>
									<youi:gridCol width="260" property="attrCaption" caption="属性描述"  editor="fieldText"/>
									<youi:gridCol width="150" property="attrColumn" caption="属性列"  editor="fieldText"/>
								</youi:grid>
							</youi:fieldGrid>
						</youi:fieldLayout>
					</youi:tabItem>
					<youi:tabItem caption="集合属性" id="model_set_attr">
						
					</youi:tabItem>
				</youi:tabs>
				
				<youi:button name="viewModelCode" caption="查看代码"/>
				<youi:button name="genModelCode" caption="生成代码" submitAction="/dev/code/genModelCode.json" submitConfirmMsg="确认生成代码？"/>
				<youi:button name="viewSql" caption="查看SQL" submitAction="/des/entity/getCreateTableSql.json"/>
				<youi:button name="addModel" caption="新实体"/>
			</youi:form>
		</youi:cell>
	</youi:table>
	<!-- 弹出框：模块代码生成 -->
	<youi:form id="form_module_opt" action="/dev/code/genModuleCode.json"
		caption="模块代码生成" dialog="true" submit="生成代码" reset="NOT">
		<youi:fieldLayout>
			<youi:fieldLabel property="entityName" caption="模块名"/>
			<youi:fieldLabel property="entityCaption" caption="模块描述"/>
			<youi:fieldLabel width="502" property="packagePrefix" caption="包前缀" column="2"/>
			<youi:fieldLabel width="502" property="project.sourcePath" caption="源代码路径" column="2"/>
			<youi:fieldText width="502" property="mainJavaPath" caption="JAVA代码" column="2"/>
			<youi:fieldText width="502" property="testJavaPath" caption="单元测试代码" column="2"/>
			<youi:fieldText width="502" property="jspPath" caption="JSP代码" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!-- javascript function -->
	<youi:func name="tree_model_change" params="treeDoc,selectedId">
		var treeNode = $(this);
		var treeNodeText = $('>span',this).text();
		if(treeNode.hasClass('model')){//模型节点
			var formElement = $elem('form_model',pageId),
				modelId = selectedId;
			//
			var queryRecord = {
				'entityName':this.getAttribute('code'),
				'entityCaption':treeNodeText
			};
			//填充查询条件并
			formElement.form('fillRecord',queryRecord);
			//
			formElement.form('loadRecord');
		}
	</youi:func>
	
	<!-- 代码生成提交后操作 -->
	<youi:func name="form_module_opt_afterSubmit">
		var formElement = $elem('form_module_opt',pageId);
		formElement.form('close');
	</youi:func>
	
	<!-- 按钮动作 - 查看模型代码 -->
	<youi:func name="func_form_viewModelCode">
		var subpageElement = $elem('subpage_code',pageId),
			filedLayoutElement =  $elem('fieldLayout_base',pageId);
		var record = filedLayoutElement.fieldLayout('getRecord');
		subpageElement.subpage('open',record,record.entityCaption);
	</youi:func>
	
	<!-- 按钮动作 - 新的模型 -->
	<youi:func name="func_form_addModel">
		var formElement = $elem('form_model',pageId);
		var treeElement = $elem('tree_model',pageId);
		var selectedNode = treeElement.tree('getSelected');
		
		var moduleElement = null;
		if(selectedNode&&selectedNode.length){
			if(selectedNode.is('.module')){
				moduleElement = selectedNode;
			}else{
				moduleElement = selectedNode.parents('li.module:first');
			}
		}

		if(moduleElement&&moduleElement.length){
			formElement.form('fieldReset').form('fillRecord',{
				module:{moduleId:moduleElement.attr('id'),moduleCaption:moduleElement.find('>span>a').text()}
			});
		}
		
	</youi:func>
	<!--**********************************页面函数********************************-->
	<youi:func name="form_model_afterSubmit" params="results">
		if(results.record.html){
			$.youi.messageUtils.showMessage(results.record.html);
		}
	</youi:func>
</youi:page>
