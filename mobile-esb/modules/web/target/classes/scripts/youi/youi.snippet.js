(function($) {
	var _log = $.youi.log;
	/**
	 *  accordion 组件
	 * @author  zhouyi
	 * @version 1.0.0
	 * @date 2011-03-18
	 */
	$.widget("youi.snippet",$.ui.mouse, $.extend({},$.youi.dragSupport,{
		
		options:{
			distance: 1
		},
		
		_init:function(){
			this.element.addClass('youi-snippet');
			this._mouseInit();//初始化拖动
		},
		
		_initAction:function(){
			
		},
		
		/**
		 * 鼠标拖动开始
		 */
		_mouseStart: function(event) {
			//span-item 元素可以拖动
			var target = event.target;
			if(target.className=='snippet-item-span'){
				//拖动开始
				this.currentDrag = $(target).parent();
				this.helper = this._createHelper(event,this.currentDrag);
			}
		},
		/**
		 * 鼠标拖动过程
		 */
		_mouseDrag: function(event) {
			if(this.currentDrag){
				var dropElem;
				var target = event.target;
				var eventClasses = target.className?target.className.split(' '):[];//$.youi.eventUtil.getEventClass(event);
				
				if(this.helper){
					this.position = this._generatePosition(event);
					this.helper.css(this.position);
				}
				
				if(this.currentDrag){//查询结果的移动动作
					var dropStyle;
					if($.isFunction(this.options.dropStyle)){
						dropStyle = this.options.dropStyle(this.currentDrag);
					}else{
						dropStyle = this.options.dropStyle;
					}
					
					if($.inArray(dropStyle,eventClasses)!=-1){//拖到到单元格
						this._doDrag($(target));
						//
						this._trigger('drag', event, {
							helper:this.helper,
							container:this.options.container,
							dragNode:this.currentDrag,
							dropNode:this.currentDrop
						});
						
					}else{
						this._releaseDrop();
					}
				}
			}
		},
		
		/**
		 * 鼠标拖动结束
		 */
		_mouseStop: function(event) {
			if(this.currentDrag&&this.currentDrop){
				//执行拖到停止操作
				this._trigger('stop', event, {
					dragNode:this.currentDrag,
					dropNode:this.currentDrop
				});
				
				this._dropOut();
				this.helper.remove();
			}
			this.helper&&this.helper.remove();
			this.currentDrag = null;
			this.currentDrop = null;
			this.helper = null;
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
	
	$.extend($.youi.snippet,{
		version: "1.0.0",
		defaults:{
			delay: 0,//
			distance: 1
		}
	});
})(jQuery);