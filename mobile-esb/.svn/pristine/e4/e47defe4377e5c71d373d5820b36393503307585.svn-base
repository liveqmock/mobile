/*!
 * SDC UI JavaScript Library v1.0.0
 * http://jquery.com/
 *
 * Copyright 2011, The isoftstone company
 * Dual licensed under the MIT or GPL Version 2 licenses.
 */
(function( $, undefined ) {
	/**
	 * %widgetName%组件
	 * @author  
	 * @version 1.0.0
	 * @date 2011-07-20
	 * Depends: 
	 * 	jquery.js,
	 *  jquery.ui.core.js
	 *  youi.core.js
	 */
	$.widget("youi.borderLayout", {
		/**
		 * 默认参数
		 */
		options: {
			initHtml:true
		},
		/**
		 * 初始化
		 */
		_create: function() {
			this._defaultHtmls();
			this._initAction();
			
			this._getTabsElement().tabs({
				
			});
			this._autoResize();
		},
		/**
		 * 
		 */
		loadPage:function(pageId,pageUrl,pageTitle,after){
			this._getTabsElement().tabs('loadPage',pageId,pageUrl,pageTitle,after);
		},
		
		_getTabsElement:function(){
			return $('.youi-page-content:first');
		},
		
		
		/**
		 * 窗体自适应
		 */
		_autoResize:function(){
			var width = $(window).width(),
				height = $(window).height(),
				panelCenter = $('.panel-center:first'),
				northElement = this.element.find('>.panel-north'),
				southElement = this.element.find('>.panel-south'),
				westElement = this.element.find('.panel-west:first'),
				westWidth = westElement.width(),
				northHeight = northElement.outerHeight(),
				southHeight = southElement.outerHeight();
			
			contentHeight = height - northHeight - southHeight-10;//Math.max(450,contentHeight);
			panelCenter.css({
				'width':width-westWidth,
				'height':contentHeight
			});
			westElement.height(contentHeight+5);
			$('.adapt-width').width(width-westWidth-2);
			$('.youi-page-content').height(contentHeight-10);
			
			$('#system_v_menu').height(contentHeight-3);
		},
		/**
		 * 组织js生成的html
		 */
		_defaultHtmls:function(){
			//if(this.options.initHtml!==false){
				//
			//}
		},
		/**
		 * 组件事件
		 */
		_initAction:function(){
			var self = this;
			$(window).bind('resize',function(event){
				var currentResize = $(window).width()+':'+$(window).height();
				if(currentResize===window.lastResize){
					return;
				}
				window.lastResize = currentResize;
				self._autoResize();
				$('.layout-resize-handle').trigger('layout.resize');
			});
		},
		
		/**
		 * 关闭页面
		 */
		closePage:function(pageId){
			this._getTabsElement().tabs('closeTab','tab_'+pageId);
		},
		/**
		 * 注销
		 */
		destroy: function() {
			$.Widget.prototype.destroy.apply(this,arguments);
		}
	});
})(jQuery);