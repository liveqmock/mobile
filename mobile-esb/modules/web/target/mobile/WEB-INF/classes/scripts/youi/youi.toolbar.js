/*
 * YOUI TREE
 *
 * Copyright (c) 2009 zhouyi
 * Dual licensed under the MIT (MIT-LICENSE.txt)
 * and GPL (GPL-LICENSE.txt) licenses.
 *
 */
(function($) {

$.widget("youi.toolbar", {
	_init:function(){
		this.element.addClass('youi-toolbar').disableSelection();
		this._initAction();
	},
	
	_initAction:function(){
		var commandWidget   = this.options.commandWidget,
			commandWidgetId = this.options.commandWidgetId;
		this.element.bind('click',function(event){
			if(!event.target.className)return;
			var eventClass = event.target.className.split(' ')[0];
			if(eventClass=='toolbar-item'&&!$(event.target).hasClass('disabled')){
				var method = event.target.getAttribute('method'),
					action = event.target.getAttribute('action'),
					paramName = event.target.getAttribute('param');
					value = event.target.getAttribute('value')||null;
				var options = {};
				options[paramName] = value;
				if(method&&$.isFunction(window['method_'+method])){
					window['method_'+method](commandWidgetId);
					//$('#reportEditor').reportEditor(this.method,options);
				}else{
					$('#'+commandWidgetId)[commandWidget]('executeCommand',action,options);
				}
			}else  if(eventClass=='toolbar-toggle'){
				var toggleItem = $(event.target);
					togglePanel = toggleItem.next(),
					position = {
						top:toggleItem.offset().top,
						left:toggleItem.offset().left
					};
				togglePanel.toggleClass('expanded').css(position);
			}
		});
	},
	/**
	 * 载入项目
	 */
	loadItems:function(items){
		this.element.html(toolbarsHtmls(items));
	},
	
	/**
	 * 生成项目的html
	 */
	_itemHtml:function(item){
		return toolbarsHtmls(item);
	},
		
	active:function(actives){
		if(!actives){return;}
		for(var i=0;i<actives.length;i++){
			this.element.find('.toolbar-item.disabled.'+actives[i]).removeClass('disabled');
		}
	},
	
	disable:function(disables){
		if(!disables){return;}
		for(var i=0;i<disables.length;i++){
			this.element.find('.toolbar-item.'+disables[i]).addClass('disabled');
		}
	},
	
	destroy:function(){
		
	}
});
function toolbarsHtmls(toolbars,parentName,param){
	var htmls = [];
	htmls.push('<table cellspacing="0" cellpadding="0"><tr>');
	$(toolbars).each(function(){
		htmls.push('<td>');
		if(this.name=='split'){
			htmls.push('<div class="toolbar-split"></div>');
		}else{
			if(this.children&&this.children.length>0){
				htmls.push('<div class="toolbar-toggle"></div><div class="toggle-panel">');
				htmls.push(toolbarsHtmls(this.children,this.name,this.param));
				htmls.push('</div>');
			}else{
				var sytleClasses = ['toolbar-item'];
				if(this.disabled){
					sytleClasses.push('disabled');
				}
				sytleClasses.push(parentName||this.name);
				htmls.push('<div ');
				if(param){
					htmls.push(' param="'+param+'" ');
				}
				if(this.value){
					htmls.push(' value="'+this.value+'" ');
					sytleClasses.push(this.value);
				}
				if(this.caption){
					sytleClasses.push(' caption');
				}
				if(this.method){
					htmls.push(' method="'+this.method+'" ');
				}
				if(this.noIcon){
					sytleClasses.push(' noIcon');
				}
				htmls.push(' action="'+(parentName||this.name)+'" ');
				htmls.push('title="'+(this.tooltip||this.caption)+'"  class="'+sytleClasses.join(' ')+'">');
				htmls.push(this.caption);
				htmls.push('</div>');
			}
		}
		htmls.push('</td>');
	});
	htmls.push('</tr></table>');
	return htmls.join('');
}
})(jQuery);