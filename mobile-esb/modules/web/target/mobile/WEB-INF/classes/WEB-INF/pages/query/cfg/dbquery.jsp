<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： 数据库查询-->
	<!--**********************************子页面**********************************-->
	
	<youi:form panel="false" id="form_dbquery" caption="数据查询" action="/reportcfg/dataSource/sqlQuery.json"
		submit="查询">
		<youi:fieldLayout id="fieldLayout_dbview" columns="1" labelWidths="80">
			<youi:fieldSelect notNull="true" property="datasourceId" width="910" show="datasourceId" code="datasourceId" src="/reportcfg/dataSource/getDataSources.json" caption="数据源"/>
			<youi:fieldArea property="sql" caption="SQL"  rows="6" width="910"></youi:fieldArea>
		</youi:fieldLayout>
	</youi:form>
	<div id="grid_dbquery_result_container" style="clear:both;"></div>
	<!--**********************************子页面**********************************-->
	
	
	<!--**********************************页面内容********************************-->
	
	<youi:func name="form_dbquery_afterSubmit" params="result">
		var gridContainer = $('#grid_dbquery_result_container');
		var formElement = $elem('form_dbquery',pageId);
		gridContainer.empty();
		var firstRecord;
		if(result&&$.isArray(result.records)){
			firstRecord = result.records[0];
			if(firstRecord){
				var cols = [];
				for(var iProperty in firstRecord){
					var value = firstRecord[iProperty];
					var col = {property:iProperty,caption:iProperty};
					if(value&&value.length){
						var width = value.length*10;
						if(width>80){
							col.width = width;
						}
					}
					cols.push(col);
					col = null;
				}
				var gridElement = $('<div id="grid_'+pageId+'_dbquery'+'"></div>').appendTo(gridContainer);
				
				gridElement.grid({
					showNum:true,pageSize:20,srcType:'json',
					src:$.youi.serverConfig.contextPath+'reportcfg/dataSource/sqlQuery.json',
					cols:cols
				});
				var formRecord = formElement.form('getFormRecord');
				var fieldLayout = $('<div class="youi-fieldLayout"></div>').appendTo(gridElement.find('.grid-query:first'));
				
				var queryFields = [];
				for(var iField in formRecord){
					queryFields.push({type:'fieldHidden',property:iField,defaultValue:formRecord[iField]});
				}
				fieldLayout.fieldLayout({fields:queryFields,initHtml:'1'});

				gridElement.grid('parseRecords',result.records,result.totalCount);
			}
		}
		if(!firstRecord){gridContainer.html("<div align=\"center\">未找到数据!</div>");}
	</youi:func>
	
	<!--**********************************页面函数********************************-->
</youi:page>