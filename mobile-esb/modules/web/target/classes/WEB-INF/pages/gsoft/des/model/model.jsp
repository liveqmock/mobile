<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- grid-实体列表-->
	<youi:grid id="grid_entity" idKeys="entityId" caption="实体列表" dataFormId="form_entity"
				src="/des/entity/getPagerEntitys.json" panel="false"
				editSrc="/des/entity/getEntity.json" add="NOT" edit="NOT"
				removeSrc="/des/entity/removeEntity.json"
				showNum="true">
		<youi:fieldLayout>
			<youi:fieldText property="module.moduleCaption"  caption="模块"></youi:fieldText>
			<youi:fieldText property="entityName"  caption="实体名"></youi:fieldText>
			<youi:fieldText property="entityCaption"  caption="实体描述"></youi:fieldText>
			<youi:fieldText operator="LIKE" property="entityTable"  caption="表名称"></youi:fieldText>
		</youi:fieldLayout>
		
		<youi:button name="importFromPdm" caption="从PDM导入"/>
		<!-- 查看实体之间的关系图  -->
		<youi:button name="viewDiagram" caption="模型关系图"/>
		
		<youi:gridCol property="module.moduleCaption" width="150"  caption="模块"/>
		<youi:gridCol sortProperty="entiyCode" property="entityCode" width="100" caption="实体编码"/>
		<youi:gridCol property="entityName" width="150" caption="实体名"/>
		<youi:gridCol property="entityCaption" width="240"  caption="实体描述"/>
		<youi:gridCol property="entityTable"  caption="表名称"/>

	</youi:grid>
	
	<!-- form-实体编辑 -->
	<youi:form dialog="true" caption="实体" id="form_entity" action="/des/entity/saveEntity.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="entityId"  caption="实体ID"/>
			<youi:fieldLabel property="module.moduleCaption"  caption="模块"/>
			<youi:fieldText property="entityName"  caption="实体名"/>
			<youi:fieldText property="entityCode"  caption="实体编码"/>
			<youi:fieldText property="entityCaption"  caption="实体描述"/>
			<youi:fieldText property="entityTable"  caption="表名称"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	
	<!-- form-选择导入的PDM文件 -->
	<youi:form dialog="true" id="form_pdm_import" caption="上传PDM并导入" action="/des/entity/importFromPdm.json">
		<youi:fieldLayout columns="2">
			<youi:fieldSelect notNull="true" property="projectId" caption="项目" code="projectId" show="projectCaption" 
				src="/mgn/project/getProjects.json"/>
			<youi:fieldText property="tablePrefix" caption="表名前缀"/>
			<youi:fieldFile column="2" property="pdmFile" size="50" caption="PDM文件" width="500"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- 从PDM导入的函数 -->
	<youi:func name="func_grid_importFromPdm">
		var pdmFormElem = $.youi.pageUtils.element('form_pdm_import',pageId);
		pdmFormElem.form('open');
	</youi:func>
	
	<youi:func name="form_pdm_import_afterSubmit">
		//关闭弹出窗口
		$(this).form('close');
		//刷新实体数据
		$.youi.pageUtils.element('grid_entity',pageId).grid('pReload');
	</youi:func>
	
</youi:page>