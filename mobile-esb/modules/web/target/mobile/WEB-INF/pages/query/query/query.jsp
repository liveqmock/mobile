<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-通用查询列表-->
	<youi:grid id="grid_query" idKeys="queryId" dataFormId="form_query"  caption="通用查询列表" 
				src="/query/query/getPagerQuerys.json" 
				editSrc="/query/query/getQuery.json"
				removeSrc="/query/query/removeQuery.json">
		<youi:fieldLayout columns="1">
			<youi:fieldText width="662" property="queryCaption"  caption="查询描述"/>
		</youi:fieldLayout>
		<youi:gridCol property="queryCaption" width="200" caption="查询描述"/>
		<youi:gridCol property="querySql"  caption="查询SQL"/>
	</youi:grid>
	
	<!-- form-通用查询编辑 -->
	<youi:form dialog="true" caption="通用查询" id="form_query" idKeys="queryId"
		action="/query/query/saveQuery.json">
		
		<youi:tabs id="tabs_query">
			<youi:tabItem caption="基本信息" id="base">
				<youi:fieldLayout prefix="record"  columns="1">
					<youi:fieldText notNull="true" property="queryId"  caption="查询编码" width="662"/>
					<youi:fieldText property="queryCaption"  caption="查询描述" width="662"/>
					<youi:fieldSelect notNull="true" property="datasource.datasourceId" show="datasourceId" code="datasourceId" src="/reportcfg/dataSource/getDataSources.json" caption="数据源"/>
					<youi:fieldArea notNull="true" property="querySql"  caption="查询SQL" rows="9" width="662"/>
				</youi:fieldLayout>
			</youi:tabItem>
			<youi:tabItem caption="查询条件" id="conds">
				<youi:fieldLayout prefix="record"  columns="1"  labelWidths="1">
					<youi:fieldGrid property="queryConds"  width="790">
						<youi:grid editable="true" load="false" showCheckbox="true" panel="false" idKeys="pk.mapName">
							<youi:gridCol editor="fieldText" width="120" property="pk.mapName"  caption="映射名"/>
							<youi:gridCol editor="fieldText" width="200"  property="mapCaption"  caption="映射描述"/>
							<youi:gridCol editor="fieldText" width="120"  property="mapColumn"  caption="数据库列"/>
							<youi:gridCol editor="fieldText"  property="mapNum"  caption="序号列"/>
						</youi:grid>
					</youi:fieldGrid>
				</youi:fieldLayout>
			</youi:tabItem>
			<youi:tabItem caption="查询结果" id="maps">
				<youi:fieldLayout prefix="record"  columns="1" labelWidths="1">
					<youi:fieldGrid property="queryMaps" width="790">
						<youi:grid editable="true" load="false" showCheckbox="true" panel="false" idKeys="pk.mapName">
							<youi:gridCol editor="fieldText" width="120" property="pk.mapName"  caption="映射名"/>
							<youi:gridCol editor="fieldText" width="200"  property="mapCaption"  caption="映射描述"/>
							<youi:gridCol editor="fieldText" width="120"  property="mapColumn"  caption="数据库列"/>
						</youi:grid>
					</youi:fieldGrid>
				</youi:fieldLayout>
			</youi:tabItem>
		</youi:tabs>
		
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>