<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： 数据库查看-->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:table>
		<youi:cell>
			<youi:fieldLayout id="fieldLayout_dbview" columns="1">
				<youi:fieldHidden property="datasourceId" caption="ID"/>
				<youi:fieldSelect property="dbType" convert="dbType" caption="数据库类型"/>
			</youi:fieldLayout>
		</youi:cell>
		<youi:cell>
			<youi:buttons id="buttons_dbview">
				<youi:button name="sqlCreate" caption="生成建表脚本"/>
			</youi:buttons>
		</youi:cell>
	</youi:table>
	
	<div style="height:398px;overflow:auto;">
		<youi:tree id="tree_dbview" tree="${dbTree}" idAttr="id" textAttr="text"/>
	</div>
	
	<youi:form caption="建表语句" id="form_viewCreateSql" dialog="true" submit="NOT" reset="NOT">
		<div style="height:420px;overflow:auto;">
			<textarea id="createSql" style="width:770px;height:410px;"></textarea>
		</div>
	</youi:form>
	
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="func_button_sqlCreate">
		var treeElement = $elem('tree_dbview',pageId),
			layoutElement = $elem('fieldLayout_dbview',pageId),
			formElement = $elem('form_viewCreateSql',pageId);
		//
		var submitParams = layoutElement.fieldLayout('getFieldParamters')||[];
		treeElement.find('li.treeNode.db-table.checked').each(function(){
			submitParams.push('tableName='+this.getAttribute('id'));
		});
		
		if(submitParams.length < 3){
			return;
		}
		//提交
		$.youi.ajaxUtil.ajax({
			url:'/reportcfg/dataSource/getTableCreateSql.json',
			data:submitParams.join('&'),
			success:function(result){
				//
				formElement.find('#createSql').val(result.record.html);
				formElement.form('open').show();
			}
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>