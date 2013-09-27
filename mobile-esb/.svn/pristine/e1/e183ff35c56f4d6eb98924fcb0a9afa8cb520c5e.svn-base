<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:table columns="1">
		<youi:cell>
			<!-- grid-代码集列表-->
			<youi:grid id="grid_codemap" idKeys="codemapId" dataFormId="form_codemap"  caption="代码集列表" 
						src="/base/codemap/getPagerCodemaps.json" 
						editSrc="/base/codemap/getCodemap.json" showCheckbox="true" panel="false"
						removeSrc="/base/codemap/removeCodemap.json">
				<youi:fieldLayout>
					<youi:fieldText property="code"  caption="代码集编码"/>
					<youi:fieldText property="caption"  caption="代码集描述"/>
				</youi:fieldLayout>
				
				<youi:gridCol property="code" width="120" caption="代码集编码"/>
				<youi:gridCol property="caption" width="220" caption="代码集描述"/>
				<youi:gridCol property="type" convert="codemapType" caption="代码集类型"/>
				<youi:gridCol property="expression"  caption="值表达式"/>
				
				<youi:button name="refreshCached" caption="同步缓存" active="1" submitAction="/base/codemap/refreshCached.json"/>
				<youi:button name="exportSql" caption="查看SQL" active="2" 
					submitAction="/base/codemap/exportCodemapToSql.json" 
					submitType="2"/>
			</youi:grid>
		</youi:cell>
			
		<youi:cell>
			<!-- grid-代码项列表-->
			<youi:grid id="grid_codeitem" idKeys="itemId" dataFormId="form_codeitem"  caption="代码项列表" 
						src="/base/codemap/getPagerCodeitemsByCodeMap.json" 
						editSrc="/base/codeitem/getCodeitem.json" submit="NOT" reset="NOT"
						removeSrc="/base/codeitem/removeCodeitem.json"
						parentId="grid_codemap" parentAttr="codemap">
				<youi:gridCol width="240" property="itemValue"  caption="代码值"/>
				<youi:gridCol property="itemCaption"  caption="代码描述"/>
		
			</youi:grid>
		</youi:cell>
	</youi:table>
	
	
	
	<!-- form-代码集编辑 -->
	<youi:form dialog="true" caption="代码集" id="form_codemap" action="/base/codemap/saveCodemap.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="codemapId"  caption="代码集ID"/>
			<youi:fieldSelect convert="codemapType" property="type"  caption="代码集类型"/>
			<youi:fieldText property="code"  caption="代码集编码"/>
			<youi:fieldText column="2" width="602" property="caption"  caption="代码集描述"/>
			<youi:fieldText column="2" width="602" property="expression"  caption="值表达式"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-代码项编辑 -->
	<youi:form dialog="true" caption="代码项" id="form_codeitem" action="/base/codeitem/saveCodeitem.json">
		<youi:fieldLayout prefix="record" columns="1">
			<youi:fieldHidden property="itemId"  caption="代码ID"/>
			<youi:fieldHidden property="codemap.codemapId"  caption="代码集ID"/>
			<youi:fieldLabel column="2" width="602"  property="codemap.caption"  caption="代码集"/>
			<youi:fieldText column="2" width="602" property="itemValue"  caption="代码值"/>
			<youi:fieldText column="2" width="602" property="itemCaption"  caption="代码描述"/>
		</youi:fieldLayout>
	</youi:form>
	
	
	<youi:form dialog="true" id="form_view_exportSql" caption="代码集sql" submit="NOT" reset="NOT">
		<youi:fieldLayout columns="1" labelWidths="1">
			<youi:fieldArea property="html" caption="" rows="20" width="800"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<youi:func name="func_grid_exportSql" params="result">
		var sqlFormElem = $elem('form_view_exportSql',pageId);
		sqlFormElem.form('fieldReset').form('fillRecord',result.record).form('open');
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>