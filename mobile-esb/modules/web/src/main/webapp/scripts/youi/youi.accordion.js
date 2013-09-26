(function($) {
	var _log = $.youi.log;
	/**
	 *  accordion 组件
	 * @author  zhouyi
	 * @version 1.0.0
	 * @date 2011-03-18
	 */
	$.widget("youi.accordion", $.extend({
		_init:function(){
			this.element.addClass('youi-accordion');
			
			this.childCount = this.element.find('>div').length;
			this._initAction();
			this.active(0);
		},
		
		active:function(index){
			var activeHeader = this.element.find('.youi-accordion-header:eq('+index+')');
			if(activeHeader.hasClass('youi-state-active'))return;
			
			var headersHeight = this.childCount*30+3;
			var activeHeight  = 'auto';
			if(this.options.height){
				activeHeight =(this.options.height-headersHeight)+'px';
			}
			
			this.element.find('.youi-accordion-content-active').removeClass('youi-accordion-content-active');
			this.element.find('.youi-accordion-header.youi-state-active').removeClass('youi-state-active');
			
			activeHeader.addClass('youi-state-active');
			this.element.find('.youi-accordion-content:eq('+index+')')
				.addClass('youi-accordion-content-active')
				.css('height',activeHeight);
		},
		
		_initAction:function(){
			this.element.delegate('.youi-accordion-header','click',function(event){
				var activeIndex = $(this).parent().prevAll().length;
				$(event.delegateTarget).accordion('active',activeIndex);
				return false;
			});
		},
		
		/**
		 * 
		 */
		_defaultHtmls:function(){
			var htmls = [];
			
			this.element.append(htmls.join(''));
			//
		}
	}));
	
	$.extend($.youi.accordion,{
		version: "1.0.0",
		defaults:{
			
		}
	});
})(jQuery);