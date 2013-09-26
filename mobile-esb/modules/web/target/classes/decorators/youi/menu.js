/**
 * 
 */
(function($) {
	var _log = $.youi.log;
	
	//$.youi.sysmenuUtils.openPage('pageId',paramRecord);
	$.youi.sysmenuUtils = {
		openPage:function(pageId,paramRecord){
			var sysmenu = $('.youi-sysmenu:first');
			sysmenu.sysmenu('openPage',pageId,paramRecord);
		}
	};
	
	$.widget("youi.sysmenu",{
		
		options:{
			
		},
		
		_create:function(){
			this.element.addClass('youi-menu youi-sysmenu');
			
			//默认打开
			//99010103
			
			var activePanel = null;
			if(this.options.selected){
				var selectedMenuItem = this.element.find('#'+this.options.selected);
				if(selectedMenuItem.length){
					//selectedMenuItem.addClass('selected');
					this._showTrace(selectedMenuItem.attr('id'));
					activePanel = selectedMenuItem.parents('.menu-bar-content:first').prev();
				}
			}
			if(activePanel==null)activePanel = this.element.find('.menu-bar-title:first');
			this.active(activePanel);
			
			this._initAction();
			
			this.resize();
		},
		
		_showTrace:function(pageId){
			var navigatorText = '';
			
			if(pageId=='000000'){//约定的首页
				navigatorText = '首页';
			}else{
				var selectedMenuItem = this.element.find('#'+pageId);
				
				var parent = selectedMenuItem;
				var traces = [];
				while(parent.length){
					traces.push(parent.find('>span').text());
					parent = parent.parents('.menu-item:first');
				}
				traces.push(selectedMenuItem.parents('.menu-bar-content:first').prev().text());
				navigatorText = traces.reverse().join(' > ');
			}
			$('.tabs-header.page-tabs-header .tabs-item.active').attr('title','当前位置:'+navigatorText);
			//$('.tabs-panel.adapt-height.active .youi-page .sys-page-navigator').html('当前位置:'+navigatorText);
		},
		
		active:function(barElement){
			if(barElement.hasClass('active'))return;
			this.element.find('.active').removeClass('active');
			var contentElement = barElement.next();
			barElement.addClass('active');
			contentElement.addClass('active');
			
			this.resize();
		},
		
		resize:function(){
			//设置高度
			var containerHeight = this.element.parent().height();
			var activeBar = this.element.find('.menu-bar-title.active');
			var activeContent = this.element.find('.menu-bar-content.active');
			
			var barCount = this.element.find('.menu-bar-title').length;
			
			var contentHeight = containerHeight-activeBar.outerHeight()*barCount;
			activeContent.css('height',contentHeight);
		},

		/**
		 * jquery 1.6升级到1.9 ：delegate中取绑定元素从 liveFired 变更为 delegateTarget 
		 */
		_initAction:function(){
			//delegate: function( selector, types, data, fn )
			//on: function( types, selector, data, fn
//			this.element.on('click','li.menu-item',function(event){
//				$.data(event.delegateTarget,_widgetFullName).sysmenu('exec',$(this));
//				return false;
//			});
			var _widgetFullName = this.widgetFullName;
			this.element.delegate('.treeNode.tree-span','click',function(event){
				//菜单项单击动作
				$.data(event.delegateTarget,_widgetFullName).exec($(this).parent());
				return false;//阻止冒泡
			}).delegate('.menu-bar-title','click',function(event){			
				//菜单头单击动作
				$.data(event.delegateTarget,_widgetFullName).active($(this));
			}).delegate('.tree-span','mouseenter',function(event){	
				//鼠标进入菜单节点
				var ulContent = $(this).parents('ul.menu-content-ul:first');
				var backgroundPosition = this.offsetTop-ulContent[0].offsetTop;
				ulContent.addClass('hover').css('backgroundPosition','0px '+backgroundPosition+'px');
			}).delegate('.tree-span','mouseleave',function(event){
				//鼠标离开菜单节点
				$(this).parents('ul.menu-content-ul:first').removeClass('hover');
			});
			
			$('body',document).bind('body.resize',{ui:this.element},function(event){
				event.data.ui.sysmenu('resize');
			});
		},
		
		_toggleChildren:function(menuElement){
			if(menuElement.hasClass('expandable')){
				menuElement.toggleClass('expanded');
				menuElement.find('>ul,>span').toggleClass('expanded').removeAttr('style');
			}
		},
		/**
		 * 执行菜单动作
		 */
		exec:function(menuElement,paramRecord){
			
			this._toggleChildren(menuElement);
			
			var pageId = menuElement.attr('id'),
				pageUrl = menuElement.find('>span>a').attr('href'),
				pageTitle = menuElement.find('>span:first').text();
			
			if(!pageUrl||'javascript:void(0)'==$.trim(pageUrl))return;
			
			this.element.find('.selected').not(menuElement).removeClass('selected');
			menuElement.addClass('selected');
			menuElement.find('>span').addClass('selected');
			//selected
			
			pageUrl = $.youi.parameterUtils.connectParameter(pageUrl,'timeStamp_',new Date().getTime());
			pageUrl = $.youi.parameterUtils.connectParameter(pageUrl,'page:pageId',pageId);
			
			if(paramRecord&&typeof(paramRecord) =='object'){
				for(var iParam in paramRecord){
					pageUrl = $.youi.parameterUtils.connectParameter(pageUrl,iParam,paramRecord[iParam]);
				}
			}
			try{
				this._loadPage(pageId, pageUrl, pageTitle);
			}catch(err){
				//
			}
		},
		/**
		 * 打开菜单
		 */
		openPage:function(pageId,paramRecord){
			var menuElement = this.element.find('li.menu-item#'+pageId);
			if(menuElement.length){
				if(paramRecord){
					//关闭已经打开的标签页
					$('body',document).borderLayout('closePage',pageId);
				}
				this.exec(menuElement,paramRecord);
			}
		},
		/**
		 * 加载页面
		 */
		_loadPage:function(pageId,pageUrl,pageTitle){
			var self =this;
			//加载页面
			$('body',document).borderLayout('loadPage',pageId,pageUrl,pageTitle,function(){
				//在page上方添加title
				self._showTrace(pageId);
			});
			
		}
	});
	
})(jQuery);