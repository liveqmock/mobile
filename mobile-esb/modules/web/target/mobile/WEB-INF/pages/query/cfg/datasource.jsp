<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<youi:subpage id="sbupage_viewdb" caption="DB查看" height="460"
		subpageId="sbupage_viewdb" src="page/query.cfg/dbview.html?datasourceId={datasourceId}&dbType={jdbcDbtype}"/>
	
	<youi:subpage id="sbupage_querydb" caption="DB查询" height="610"
		subpageId="sbupage_querydb" src="page/query.cfg/dbquery.html?datasourceId={datasourceId}&dbType={jdbcDbtype}"/>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-数据源列表-->
	<youi:grid id="grid_dataSource" idKeys="datasourceId" dataFormId="form_dataSource"  caption="数据源列表" 
				src="/reportcfg/dataSource/getPagerDataSources.json" 
				editSrc="/reportcfg/dataSource/getDataSource.json"
				removeSrc="/reportcfg/dataSource/removeDataSource.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="jdbcDbtype"  caption="数据库类型"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="jdbcDbtype"  caption="数据库类型"/>
		<youi:gridCol property="jdbcSchema"  caption="SCHEMA"/>
		<youi:gridCol property="jdbcUsername"  caption="用户名"/>

		<youi:gridCol property="jdbcDriver" width="240" caption="数据库驱动"/>
		<youi:gridCol property="jdbcUrl"  caption="数据库URL"/>
		
		<youi:button name="viewdb" order="201" caption="查看数据库" active="1"/>
		<youi:button name="querydb" order="202" caption="查询数据" active="1"/>
	</youi:grid>
	
	<!-- form-数据源编辑 -->
	<youi:form dialog="true" caption="数据源" id="form_dataSource" idKeys="datasourceId"
		action="/reportcfg/dataSource/saveDataSource.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120" columns="1">
			<youi:fieldText property="datasourceId"  caption="数据源名" width="622"/>
			<youi:fieldText property="jdbcDbtype"  caption="数据库类型" width="622"/>
			<youi:fieldText property="jdbcSchema" notNull="true" caption="SCHEMA" width="622"/>
			<youi:fieldText property="jdbcUsername"  caption="用户名" width="622"/>
			<youi:fieldPassword property="jdbcPassword"  caption="密码" width="622"/>
			<youi:fieldText property="jdbcDriver"  caption="数据库驱动" width="622"/>
			<youi:fieldText property="jdbcUrl"  caption="数据库URL" width="622"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="func_grid_viewdb">
		var subpageElement = $elem('sbupage_viewdb',pageId),
			gridElement = $elem('grid_dataSource',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		subpageElement.subpage('open',selectedRecord,null,selectedRecord);
	</youi:func>
	
	<youi:func name="func_grid_querydb">
		var subpageElement = $elem('sbupage_querydb',pageId),
			gridElement = $elem('grid_dataSource',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		subpageElement.subpage('open',selectedRecord,null,selectedRecord);
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>