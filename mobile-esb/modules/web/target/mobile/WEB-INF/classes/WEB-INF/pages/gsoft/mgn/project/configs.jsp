<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 界面描述：项目配置 -->
	
	<!--**********************************页面内容********************************-->
	<youi:form id="form_project_config" panel="false" action="/mgn/project/saveProjectConfig.json"
		findAction="/mgn/project/getProjectConfig.json" idKeys="projectId">
		
		<youi:tabs id="tabs_project_config">
			<youi:tabItem id="config_base" caption="基本配置">
				<youi:fieldLayout columns="1" labelWidths="120">
					<youi:fieldText width="502" property="projectId" caption="项目ID"/>
					<youi:fieldText width="502" property="demDoc" caption="需求文档"/>
					<youi:fieldText width="502" property="desDoc" caption="设计文档"/>
					<youi:fieldText width="502" property="modDoc" caption="模型文档"/>
				</youi:fieldLayout>
			</youi:tabItem>
			
			<youi:tabItem id="config_devp" caption="开发配置">
				<youi:fieldLayout columns="1" labelWidths="120">
					<youi:fieldText notNull="true" width="502" property="name" caption="项目名"/>
					<youi:fieldText width="502" property="svnPath" caption="SVN地址"/>
					<youi:fieldText notNull="true" width="502" property="basePackage" caption="项目包"/>
					<youi:fieldLabel width="502" property="sourcePath" caption="项目路径"/>
					<youi:fieldText notNull="true" width="502" property="javaPath" defaultValue="src/main/java" caption="代码路径"/>
					<youi:fieldText notNull="true" width="502" property="testPath" defaultValue="test/main/java" caption="单元测试路径"/>
					<youi:fieldText notNull="true" width="502" property="jspPath" defaultValue="src/main/webapp/WEB-INF/pages" caption="页面路径"/>
				</youi:fieldLayout>
			</youi:tabItem>
		</youi:tabs>
		
		<youi:button name="closeDialog" caption="关闭" order="400"/>
		<youi:button name="closeDialog1" caption="关闭1" order="400"/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<!-- 由父页面调用时触发 -->
	<youi:func name="subpage_init" params="record">
		//加载数据
		var formElement = $elem('form_project_config',pageId);
		formElement.form('fillRecord',record);//填充数据
		//根据projectId查询数据填充到form中
		
		formElement.form('loadRecord');
	</youi:func>
	<!--**********************************页面函数********************************-->
	
	<youi:func name="func_form_closeDialog1">
		var formElement = $elem('form_project_config',pageId);
		formElement.parents('.youi-dialog:first').dialog('close');
	</youi:func>
</youi:page>
