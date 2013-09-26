(function($) {
	var _log = $.youi.log;
	//加载页面脚本
	$.youi.pageUtils.loadPageScript = function(pageId,after,pageDoc){
		if(pageId){
			var scriptId = 'script_'+pageId;
			
			$('script#'+scriptId).remove();
			
			var scriptDoc = document.createElement('script');
			scriptDoc.setAttribute('id','script_'+pageId);
			scriptDoc.setAttribute('type','text/javascript');
			scriptDoc.setAttribute('src',$.youi.serverConfig.contextPath+'scripts/page/'+pageId+'.html');
			var bodyDoc = $('body',document)[0];
			bodyDoc.parentNode.appendChild(scriptDoc);
			
			$(scriptDoc).bind('load',function(){
				if(!this.hasLoaded){
					this.hasLoaded = true;
					if($.isFunction(after)){
						after(pageDoc);
					}
				}
			});
		}
	};
	//执行页面函数
	$.youi.pageUtils.doPageFunc = function(funcName,pageId,pageDoc){
		var fullFuncName = 'P_'+pageId+'_'+funcName;
		if($.isFunction(window[fullFuncName])){
			window[fullFuncName].apply(pageDoc);
		}
	};
	
	
	$.widget('youi.subpage',{
		/**
		 * 默认参数
		 */
		options:{
			type:'dialog',
			width:1000,
			height:300
		},
		/**
		 * 组件初始化入口
		 */
		_create:function(){
			this.element.addClass('youi-subpage').height(this.options.height);
			this._initAction();
			
			if(this.options.formAction){
				this.element.addClass('youi-form').form({
					id:this.options.id,
					initHtml:false
				});
			}
		},
		/**
		 * 
		 */
		_initAction:function(){
			var buttonsPanel = this.element.find('>.subpage-buttons');
			if(this.options.buttonActions){
				var buttonActions = $.extend({},this.options.buttonActions);
				
				var subpageElement = this.element;
				if(buttonActions['close']){
					buttonActions['close'] = function(){
						subpageElement.subpage('close');
					};
				}
				
				if(buttonActions['submit']){
					buttonActions['submit'] = function(){
						subpageElement.subpage('submit');
					};
				}
				//
				$.youi.buttonUtils.addButtonActionListener(buttonsPanel,buttonActions);
			}
			
		},
		/**
		 * 打开子页面
		 */
		open:function(record,subtitle,params){
			this.openParams = params;
			//打开载体
			switch(this.options.type){
				case 'dialog':
					this._openDialog(record,subtitle,params);
					break;
				case 'window':
					this._openWindow(record,params);
					break;
				default:
					;
			}
		},
		/**
		 * 
		 */
		submit:function(){
			//
			var action = this.options.formAction;
			if(action){
				if(this.openParams){
					for(var name in this.openParams){
						action = action.replace(new RegExp("\\{" + name + "\\}", "g"), this.openParams[name]);
					}
				}
				this.element.attr('action',action);
				this.element.form('submit');
			}
		},
		/**
		 * 加载子页面内容
		 */
		_loadSubPage:function(record,paramObject){
			var subpageId = this.options.subpageId;
			if(paramObject||!this.element.hasClass('loaded')){
				var content = this.element.find('>.subpage-content');
				content.empty();
				var url = this._getSubpageUrl();
				for(var name in paramObject){
					url = url.replace(new RegExp("\\{" + name + "\\}", "g"), paramObject[name]);
				}
				
				$.youi.pageUtils.loadPage(content,url,function(){
					$(this.parentNode).addClass('loaded');
					//执行子页面函数
					window.setTimeout(function(){
						_execSubpageInit(subpageId,record);
					},100);
					
				});
			}else{
				_execSubpageInit(subpageId,record);
			}
		},
		/**
		 * 弹出窗口类型打开
		 */
		_openDialog:function(record,subtitle,params){
			//加载页面内容
			this._loadSubPage(record,params);
			
			this.element.dialog({
				autoOpen: false,
				width:(this.options.width||600)+28,
				title:this.options.caption,
				modal: true, 
				minHeight:500,
				overlay: { opacity: 0.2, background: "#A8A8A8" },
				close:function(){
					//TODO 集成close事件
					return true;
				}
			}).show().dialog('open',subtitle);
		},
		/**
		 * 打开新窗口
		 */
		_openWindow:function(record){
			$.youi.pageUtils.goPage(this._getSubpageUrl(),record);
		},
		/**
		 * 
		 */
		_getSubpageUrl:function(){
			var subpageId = this.options.subpageId;
			var url = $.youi.parameterUtils.connectParameter(this.options.src
					,"page:pageId",subpageId);
			return url;
		},
		
		close:function(){
			switch(this.options.type){
				case 'dialog':
					this.element.dialog('close');
					break;
				default:
					;
			}
			this.openParams = null;
		},
		
		/**
		 * 组件销毁
		 */
		destroy:function(){
			$.Widget.prototype.destroy.apply(this, arguments);
		}
	});
	
	function _execSubpageInit(subpageId,record){
		var subInitFunc = window['P_'+subpageId+'_subpage_init'];
		if($.isFunction(subInitFunc)){
			subInitFunc(record);//执行
		}
	}
})(jQuery);
