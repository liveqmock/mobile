/**
 * field组件
 * Copyright (c) 2009 zhouyi
 * licenses
 * doc 
 */
(function($) {
	var _log = $.youi.log;
	/**
	 * fieldArea
	 * 
	 */
	$.widget("youi.fieldCkeditor",$.extend({},$.youi.field,{
		
		_initField:function(){
			//移动dialog到body上
			var dialogParent = this.element.parents('.youi-form.youi-dialog:first');
			var ckeditorId = this.options.id+"_editor";
			this.ckeditorId = ckeditorId;
			if(dialogParent.length){
				window.setTimeout(function(){
					dialogParent.form('open').dialog('closeOverlay').parents('.youi-dialog-container:first').hide();
					CKEDITOR.replace(ckeditorId);
				},100);
			}
		},
		
		_fieldHtmls:function(){
			var htmls = [];
			var inputWidth = this.options.width - 17;
			htmls.push("<textarea id=\""+this.options.id+"_editor\" style=\"width:"+(inputWidth)+"px;z-index:9999;\" type=\"text\" class=\"textInput value\"></textarea>");
			htmls.push("<div class=\"field-invalid\"></div>");
			return htmls.join('');
		},
		
		setValue:function(value){
			var oEditor = CKEDITOR.instances[this.ckeditorId];
			return oEditor.setData(value);
		},
		
		getValue:function(){
			var oEditor = CKEDITOR.instances[this.ckeditorId];
			return oEditor.getData();
		},
		
		reset:function(){
			this.element.removeClass('validate-success').removeClass('validate-error').removeAttr('title');
			var oEditor = CKEDITOR.instances[this.ckeditorId];
			oEditor&&oEditor.setData(this.options.defaultValue||'');
		},
		
		clear:function(){
			var oEditor = CKEDITOR.instances[this.ckeditorId];
			oEditor&&oEditor.setData('');
		},
		
		validate:function(){
			this.element.removeClass('validate-error').removeAttr('title');
			if(!this._validateNotNull()){
				return false;
			}
			return true;
		}
		
	}));
	
	$.extend($.youi.fieldCkeditor,{
		defaults:$.extend({},$.youi.fieldDefaults,{
			
		})
	});
})(jQuery);