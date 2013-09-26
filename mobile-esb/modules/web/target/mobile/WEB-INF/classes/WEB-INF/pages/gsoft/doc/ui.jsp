<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:style href="/styles/page/uidoc.css"></youi:style>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:form id="form_doc_ui" caption="UI文档" reset="NOT" submit="NOT">
		<div id="content" style="height:400px;"></div>
		
	</youi:form>
	
	<youi:form dialog="true" width="1000" height="540" id="form_doc_widget" caption="组件文档" reset="NOT" submit="NOT">
		<div class="doc-ui-container">
			<youi:tabs id="tabs_doc_ui" itemHeight="510">
				<youi:tabItem caption="标签文档" id="doc_ui_taglib">
					<div id="doc_ui_taglib_container"> </div>
				</youi:tabItem>
				<youi:tabItem caption="UI文档" id="doc_ui_widget">
					<div id="doc_ui_widget_container"> </div>
				</youi:tabItem>
			</youi:tabs>
		</div>
	</youi:form>
	
	<!--**********************************页面内容********************************-->

	<!--**********************************页面函数********************************-->
	<youi:func name="init">
		var formElem = $elem('form_doc_ui',pageId);
		
		var model = {
			widgets:[
				{name:'form',caption:'表单'},
				{name:'fieldLayout',caption:'表单布局'},
				{name:'grid',caption:'列表'},
				{name:'tree',caption:'树'}
				//{name:'panel',caption:'panel'},
				//{name:'tabs',caption:'标签'},
				//{name:'dialog',caption:'对话框'},
				//{name:'page',caption:'页面'},
				//{name:'subpage',caption:'子页面'}
			],
			fieldWidgets:[
				{name:'fieldText',caption:'文本输入'},
				{name:'fieldSelect',caption:'下拉选择'},
				{name:'fieldArea',caption:'文本域'},
				{name:'fieldPassword',caption:'密码输入'},
				{name:'fieldTree',caption:'下拉树'},
				{name:'fieldCalendar',caption:'日期选择'},
				{name:'fieldCheckboxGroup',caption:'复选框组'},
				{name:'fieldRadioGroup',caption:'单选框组'},
				{name:'fieldLabel',caption:'文本显示'},
				{name:'fieldAutocomplete',caption:'autocomplete'},
				{name:'fieldHidden',caption:'隐藏域'},
				{name:'fieldSwfupload',caption:'多文件上传'}
			],
			commons:[]
		};
		
		var htmls = [];
		
		htmls.push(buildGroupHtml(model.widgets,'Widget组件'));
		htmls.push(buildGroupHtml(model.fieldWidgets,'表单域组件'));
		htmls.push(buildGroupHtml(model.commons,'工具类组件'));

		var contentElem =formElem.find('#content'); 
		contentElem.delegate('.ui-item','click',function(event){
			var id = this.getAttribute('id');
			$.youi.ajaxUtil.ajax({
				url:'doc/ui/taglib/'+id+'.json',
				success:function(result){
					$elem('form_doc_widget',pageId).form('open',id).find('#doc_ui_taglib_container').html(result.html);
				}
			});

			$.youi.ajaxUtil.ajax({
				url:'doc/ui/widget/'+id+'.json',
				success:function(result){
					$elem('form_doc_widget',pageId).form('open',id).find('#doc_ui_widget_container').html(result.html);
				}
			});

		}).html(htmls.join(''));
		
		function buildGroupHtml(groupModels,title,columns){
			columns = columns||4;
			var tdWidth = 100/columns+"%";
			var htmls = [];
			if($.isArray(groupModels)){
				htmls.push('<fieldset><legend>'+title+'</legend>');
				htmls.push('<table class="bg-border" width="100%" cellspacing="1" cellpadding="3">');
				htmls.push('<tr>');
				
				$(groupModels).each(function(index){
					//换行
					if(index>0&&index%columns==0){
						htmls.push('</tr><tr>');
					}	
					htmls.push('<td width="'+tdWidth+'" class="ui-item" id="'+this.name+'" >'+this.caption+'</td>');
				});
				htmls.push('</tr></table></fieldset>');
			}
			return htmls.join('');
		}
		
		formElem.find('#content').html(htmls.join(''));
	</youi:func>
	
	
	<!--**********************************页面函数********************************-->
</youi:page>