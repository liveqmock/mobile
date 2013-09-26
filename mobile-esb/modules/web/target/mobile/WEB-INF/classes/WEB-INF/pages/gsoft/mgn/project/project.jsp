<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>
	<!--**********************************子页面**********************************-->
	<!-- 项目配置子页面，弹出对话框类型 -->
	<youi:subpage id="subpage_project_configs" height="360" subpageId="010201"
		 src="/page/gsoft.mgn.project/configs.html" caption="项目配置"/>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:table>
		<youi:cell width="200px" rowspan="2">
			<youi:buttons id="buttons_project">
				<youi:button name="addProjectGroup" caption="增加"></youi:button>
				<youi:button name="editProjectGroup" caption="修改"></youi:button>
				<youi:button name="removeProjectGroup" caption="删除"></youi:button>
			</youi:buttons>
			<div style="clear:both;">
				<youi:tree id="tree_projectGroup" tree="${projectGroupTree}"/>
			</div>
		</youi:cell>
		<youi:cell>
			<youi:grid src="/mgn/project/getPagerProjects.json"
					   editSrc="/mgn/project/getProject.json"
					   removeSrc="/mgn/project/removeProject.json"
				 dataFormId="form_project" idKeys="projectId"
				 scrollHeight="120"
				 id="grid_project" caption="项目列表" load="false">
			 	<youi:fieldLayout id="fieldLaout_grid_project">
			 		<youi:fieldHidden property="projectGroup.projectGroupId"/>
			 		<youi:fieldAutocomplete src="/mgn/project/findProjectsByTerm.json" property="projectCode" caption="项目编码"/>
			 		<youi:fieldText operator="LIKE"  property="projectCaption" caption="项目描述"/>
			 	</youi:fieldLayout>
			 	
			 	<youi:button name="configs" caption="项目配置" order="201" active="1"/>
			 	<youi:button name="exportSource" caption="导出项目骨架" order="202" active="1" />
			 	
			 	<youi:gridCol width="120" property="projectGroup.projectGroupCaption" caption="项目文件夹"/>
				<youi:gridCol width="120" orderBy="asc" property="projectCode" caption="项目编码"/>
				<youi:gridCol width="80" property="projectStatus" caption="项目状态"/>
				<youi:gridCol width="200" property="projectCaption" caption="项目描述"/>
				
			</youi:grid>
		</youi:cell>
		<youi:cell>
			<youi:grid parentId="grid_project" parentAttr="project"
				src="/mgn/module/getPagerModules.json" dataFormId="form_module"
				removeSrc="/mgn/module/removeModule.json"
				editSrc="/mgn/module/getModule.json" idKeys="moduleId"
				id="grid_module" caption="模块列表" load="false"
				submit="NOT" reset="NOT"
				usePager="false">
				<youi:gridCol width="200" property="moduleName" caption="模块名"/>
				<youi:gridCol orderBy="asc" property="moduleCaption" caption="模块描述"/>
			</youi:grid>
		</youi:cell>
	</youi:table>
	
	<!-- form-项目编辑 -->
	<youi:form width="960" dialog="true" caption="项目" id="form_project" action="/mgn/project/saveProject.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120">
			<youi:fieldHidden property="projectId"  caption="项目ID"/>
			<youi:fieldHidden property="projectGroup.projectGroupId"/>
			<youi:fieldLabel width="802"  property="projectGroup.projectGroupCaption" caption="项目文件夹"/>
			<youi:fieldText notNull="true" width="802" property="projectCode"  caption="项目编码"/>
			<youi:fieldText notNull="true" width="802" property="projectCaption"  caption="项目描述"/>
			<youi:fieldCustom custom="fieldCkeditor" customOptions="{}" width="802" property="projectDetails"  caption="项目详细信息"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-模块编辑 -->
	<youi:form dialog="true" caption="模块" id="form_module" action="/mgn/module/saveModule.json">
		<youi:fieldLayout  prefix="module_record" columns="1" >
			<youi:fieldHidden property="moduleId"  caption="模块ID"/>
			<youi:fieldHidden property="project.projectId"  caption="项目ID"/>
			
			<youi:fieldLabel caption="项目" property="project.projectCaption"/>
			
			<youi:fieldText property="moduleName" width="502"  caption="模块名"/>
			<youi:fieldText property="moduleCaption" width="502"  caption="模块描述"/>
			
		</youi:fieldLayout>
	</youi:form>
	
	
	<!-- form-项目分类编辑 -->
	<youi:form dialog="true" caption="项目分类" id="form_projectGroup" idKeys="projectGroupId"
		action="/mgn/projectGroup/saveProjectGroup.json" findAction="/mgn/projectGroup/getProjectGroup.json">
		<youi:fieldLayout prefix="projectGroup_record" columns="1" labelWidths="110">
			<youi:fieldHidden property="projectGroupId"  caption="项目分类编号" />
			<youi:fieldText property="projectGroupCaption" caption="项目分类名称" width="602"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<!-- 页面初始化函数 -->
	<youi:func name="init">
		var gridElement = $elem('grid_project',pageId);
		//把查询块放到表格工具栏按钮行中
		gridElement.find('>.grid-formButtons').prepend(gridElement.find('>.youi-fieldLayout'));
	</youi:func>
	
	<!-- grid按钮:打开项目配置窗口 -->
	<youi:func name="func_grid_configs">
		var gridElement = $elem('grid_project',pageId),//
			subpageElement = $elem('subpage_project_configs',pageId),//
			selectedRecord = gridElement.grid('getSelectedRecord');
		//打开子页面
		subpageElement.subpage('open',selectedRecord,selectedRecord.projectCaption);
	</youi:func>
	
	<!-- 导出项目骨架 -->
	<!-- 按钮：删除项目分组 -->
	<youi:func name="func_grid_exportSource">
		var gridElement = $elem('grid_project',pageId),//
			selectedRecord = gridElement.grid('getSelectedRecord');
		
		window.location.href = $.youi.serverConfig.contextPath+'mgn/project/download.json?projectId='+selectedRecord.projectId;
	</youi:func>
	
	<!-- 树节点切换 -->
	<youi:func name="tree_projectGroup_change">
		//根据元素ID和页面编码获取页面组件
		var gridElement = $elem('grid_project',pageId),
			formElement = $elem('form_project',pageId);
		//设置查询条件
		var queryRecord = {projectGroup:{
			projectGroupCaption:$('>span',this).text(),
			projectGroupId: this.getAttribute('id')
		}};
		//重置表单查询条件，填入新的查询条件，刷新表格数据
		$elem('fieldLaout_grid_project',pageId).fieldLayout('fieldDefaultValue',
			'projectGroup.projectGroupId',this.getAttribute('id'));
		gridElement.grid('reset').grid('pReload');
		//填充表单默认值
		formElement
			.form('fieldDefaultValue','projectGroup.projectGroupId',queryRecord.projectGroup.projectGroupId)
			.form('fieldDefaultValue','projectGroup.projectGroupCaption',queryRecord.projectGroup.projectGroupCaption);
	</youi:func>
	
	<!-- 增加项目分组 -->
	<youi:func name="func_button_addProjectGroup">
		$elem('form_projectGroup',pageId).form('fieldReset').form('open');
	</youi:func>
	<!-- 按钮：编辑项目分组 -->
	<youi:func name="func_button_editProjectGroup">
		var selectNode = $elem('tree_projectGroup',pageId).tree('getSelected');
		if(!selectNode||selectNode.hasClass('root')){
			return;
		}
		var projectGroupId = selectNode.attr('id');
		var selectRecord = {projectGroupId:projectGroupId};
		//先使用主键填充，然后调用form的loadRecord方法通过findAction从后台读取数据
		$elem('form_projectGroup',pageId).form('fillRecord',selectRecord).form('loadRecord').form('open');
	</youi:func>
	
	<!-- 按钮：删除项目分组 -->
	<youi:func name="func_button_removeProjectGroup">
		if(!window.confirm('确认删除？')){
			return;
		}
		var selectNode = $elem('tree_projectGroup',pageId).tree('getSelected');
		if(!selectNode||selectNode.hasClass('root')){
			return;
		}
		var projectGroupId = selectNode.attr('id');
		$.youi.ajaxUtil.ajax({
			url:'/mgn/projectGroup/removeProjectGroup.json?projectGroupId='+projectGroupId,
			success:function(result){
				var treeElem = $elem('tree_projectGroup',pageId);
				treeElem.tree('removeNode',projectGroupId);
			}
		});
	</youi:func>
	
	<!-- 保存项目分组回调函数 -->
	<youi:func name="form_projectGroup_afterSubmit" params="result">
		
		var record = result.record;
		var treeElem = $elem('tree_projectGroup',pageId);

		var treeNode = treeElem.find('li.treeNode#'+record.projectGroupId);
		if(treeNode.length){
			treeNode.find('>span>a').text(record.projectGroupCaption);
		}else{
			treeElem.tree('addNode',treeElem.find('li:first'),record.projectGroupId,record.projectGroupCaption);
			//addNode:function(relativeNode,id,text,attributes,data,afterAdd,type)
		}
		$elem('form_projectGroup',pageId).form('close');
	</youi:func>
	
	
	<!--*********************************页面函数*********************************-->
</youi:page>