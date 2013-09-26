(function($) {
	var _log = $.youi.log;
	/**
	 * 组织机构设计器
	 * @author  zhyi_12
	 * @version 1.0.0
	 * @date 2011-04-03
	 */
	$.widget("youi.organizeDesigner", $.extend({},$.youi.dragSupport,$.youi.command,{
		/**
		 * 构造函数
		 */
		_create:function(){
			this.options.id = this.element.attr('id');
			this._registerCommands();//初始化命令并注册设计器相关的命令
			//初始化organize
			this._initOrganize();//初始化图形组件
			this._initToolbar();//初始化工具栏
		},
		/**
		 * 初始化组件
		 */
		_initOrganize:function(){
			var organizeElem = this._getOrganizeElem();
			organizeElem.organize({
				width:this.options.width,
				select:this.options.select
			});
		},
		
		_getOrganizeElem:function(){
			var organizeElem = this.element.find('>.youi-organize:first');
			if(!organizeElem.length){
				organizeElem = $('<div id="#'+this.options.id+'_organize"></div>').prependTo(this.element);
			}
			return organizeElem;
		},
		/**
		 * 初始化palette
		 */
		_initPalette:function(){
			var paletteElem = $('#'+this.options.id+'_palette',this.element);
		},
		
		/**
		 * 初始化propertyTable
		 */
		_initPropertyTable:function(){
			var paletteElem = $('#'+this.options.id+'_palette',this.element);
		},
		/**
		 * 初始化工具栏
		 */
		_initToolbar:function(){
			var toolbarElem = $('#'+this.options.id+'_toolbar',this.element);
			
			toolbarElem.toolbar({
				commandWidget:this.widgetName,
				commandWidgetId:this.options.id
			}).toolbar('loadItems',[
			   {name:'save',caption:'保存'} ,
			   {name:'halign',caption:'水平对齐'},
			   {name:'valign',caption:'垂直对齐'}
			]);
		},
		
		/**
		 * 注册命令
		 */
		_registerCommands:function(){
			if(!this._initCommands){return;}
			
			this._initCommands();//初始化命令
			var self = this;
			this.registerCommand('save',{
				exec:function(){
					//插入行,并记录插入的位置
					alert('保存');
					return false;
				},
				undo:function(){return false;},
				getTitle:function(){return "保存";}
			});
			
			this.registerCommand('halign',{
				exec:function(){
					self._getOrganizeElem().organize('halign');
					return false;
				},
				undo:function(){return false;},
				getTitle:function(){return "水平对齐";}
			});
			
			this.registerCommand('valign',{
				exec:function(){
					self._getOrganizeElem().organize('valign');
					return false;
				},
				undo:function(){return false;},
				getTitle:function(){return "垂直对齐";}
			});
		},
		/**
		 * 保存
		 */
		save:function(doSave){
			//
			var xml = this._getOrganizeElem().organize('buildXml');
			if($.isFunction(doSave)){
				doSave.apply(this.element[0],[xml]);
			}
		}
	}));
	
	$.extend($.youi.organizeDesigner,{
		version: "1.0.0"
	});
})(jQuery);