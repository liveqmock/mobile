(function($) {
	var _log = $.youi.log;
	/**
	 * 表单设计器
	 * @author  zhyi_12
	 * @version 1.0.0
	 * @date 2011-04-03
	 */
	$.widget("youi.formDesigner", $.ui.mouse, $.extend({},$.youi.dragSupport,$.youi.command,{
		options:{
			distance: 1,
			height:450
		},
		
		WIDGET_UUID:0,//
		
		/**
		 * 构造函数
		 */
		_init:function(){
			this.options.id = this.element.attr('id');
			
			this.element.addClass('youi-formDesigner');
			this._registerCommands();//初始化命令并注册设计器相关的命令
			
			this._initToolbar(); 
			
			//计算高度(this.options.height)
			this.height = this.options.height - 29;
			
			this._initAccordion({
				height:this.height
			});//辅助面板
			this._initWidgetTree();//初始化页面元素结构树
			this._initSnippet();//小部件
			
			this._initPageEditor();//页面编辑器
			
			this._initConverts();
			this._initPropertyTable();
			
			//this._initModelTree();
			
			//this._initHotkeys();
			
			this._loadDefaultFormPage();//加载配置页
		},
		
		_loadDefaultFormPage:function(){
			var saveForm = $('#'+this.options.id+'_save');
			var formRecord = saveForm.form('getFormRecord');
			this.loadFormPage(formRecord.formId);
		},
		
		loadFormPage:function(formId){
			var formDesignerId = this.options.id;
			if(formId){
				$.youi.ajaxUtil.ajax({
					url:'/des/form/loadFormModel.json?formId='+formId,
					success:function(result){
						/**
						 * record:{
						 * 		treeHtml:'',//模型树html
						 * 		pageHtml:'',//页面html
						 * 		widgetModels:{}//模型数组
						 * }
						 */
						if(result.record){
							var record = result.record;
							$('#'+formDesignerId+'_tree_widgets>ul').html(record.treeHtml);
							$('#'+formDesignerId+'_pageEditor').pageEditor('loadFromModel',record);
						}
					}
				});
			}
		},
		/**
		 * 初始化模型树
		 */
		_initModelTree:function(){
			this._getWidgetElement('tree_model').tree({
				id:this.options.id+'_tree_model',
				hideRoot:false, 
				initHtml:false,
				dragable:true,
				idAttr:'id',
				textAttr:'text',
				dropStyle:'layoutDrop',
				stop:function(event,ui){
					//
					var treeNode = ui.dragNode;
					if(treeNode.hasClass('model')){//模型
						//获取所有的属性
						var fields = [];
						treeNode.find('li.normalattribute').each(function(){
							fields.push({
								property:this.getAttribute('id'),
								caption:$('>span>a',this).text()
							});
						});
						
						var pageEditorElem;
						if(ui.dropNode.is('.youi-pageEditor')){
							pageEditorElem = ui.dropNode;
						}else{
							pageEditorElem = ui.dropNode.parents('.youi-pageEditor:first');
						}
						pageEditorElem.pageEditor('addPageElem',
								ui.dropNode,'model','model',
								{modelCaption:treeNode.find('>span>a').text(),id:treeNode.attr('id'),'cols':fields});
					}
				}
			});
		},
		
		_initToolbar:function(){
			this._getWidgetElement('toolbar').toolbar({
				commandWidget:'formDesigner',
				commandWidgetId:this.options.id
			}).toolbar('loadItems',[
				{name:'save',caption:'保存'},
				{name:'showCode',caption:'查看代码'},
				{name:'run',caption:'运行'},
				{name:'split'},
				{name:'remove',tooltip:'删除页面元素',disabled:true},
				{name:'funcs',tooltip:'JS函数'},
				{name:'split'},
				{name:'merge',tooltip:'合并单元格',disabled:true}
			]);
		},
		
		_activeToolbar:function(actives){
			this._getWidgetElement('toolbar').toolbar('active',actives);
		},
		
		_disableToolbar:function(disables){
			this._getWidgetElement('toolbar').toolbar('disable',disables);
		},
		
		_initWidgetTree:function(){
			var self = this;
			var htmls = ['<ul><li id="tree_'+this.options.id+'_pageEditor" class="treeNode root"><span class="tree-span root"><a class="tree-a root" href="#">页面元素</a></span></li></ul>'];
			this._getWidgetElement('tree_widgets').html(htmls.join('')).tree({
				select:function(){
					var id = this.getAttribute('id');
					self._selectPageEditorElem(id);
				}
			});
		},
		
		_initHotkeys:function(){
			var self = this;
			$(document).bind('keydown','del', function(){
				//删除选择的元素
			 	self.removePageElem();
			});
		},
		
		_initConverts:function(){
			$.extend(
				$.youi.serverConfig.convertArray,{
					'field_notNull':{'1':'是'},
					'component_orderBy':{'asc':'正序','desc':'逆序'}
				}
			);
			
		},
		/**
		 * 辅助工具
		 */
		_initAccordion:function(){
			var accordionElem = this._getWidgetElement('accordion');
			accordionElem.accordion({
				height:this.height-1
			});
		},
		/**
		 * 获取内部组件
		 */
		_getWidgetElement:function(widgetName){
			return this.element.find('#'+this.options.id+'_'+widgetName);
		},
		
		/**
		 * 初始化form部件
		 */
		_initSnippet:function(){
			this._initPageElementSnippet('layout');//布局元素
			this._initPageElementSnippet('component');//组件
			this._initFieldSnippet();//表单元素
		},
		/**
		 * 小部件初始化
		 */
		_initPageElementSnippet:function(widgetType){
			var dropMarker = this._getWidgetElement('pageEditor').find('.drop-marker');
			this._getWidgetElement('snippet_'+widgetType).snippet({
				container:this._getWidgetElement('pageEditor'),
				dropStyle:function(currentDrag){
					if(currentDrag.attr('id')=='button'){
						return 'buttonDrop';
					}
					return 'layoutDrop'
				},
				drag:function(event,ui){
					if(ui.dropNode){
						$.youi.pageEditor.showDropMarker(ui.dropNode,dropMarker,event.pageY);
					}
				},
				stop:function(event,ui){
					if(!ui.dropNode)return;
					$(this).parents('.youi-formDesigner:first').formDesigner('addPageElem',
							ui.dropNode,widgetType,ui.dragNode.attr('id'));
				}
			});
		},
		/**
		 *  表单元素组件
		 */
		_initFieldSnippet:function(){
			this._getWidgetElement('snippet_field').snippet({
				container:$('body',document),
				dropStyle:'fieldDrop',
				stop:function(event,ui){
					if(!ui.dropNode)return;
					var formDesigner = $(this).parents('.youi-formDesigner:first');
					//TODO 命令模式调用
					formDesigner.formDesigner('addFieldElem',
						ui.dropNode,ui.dragNode.attr('id'),ui.dragNode.text());
				}
			});
		},
		
		/**
		 * 设置属性值
		 */
		setPropertyValue:function(cell,property,value){
			this._getWidgetElement('pageEditor').pageEditor('setPropertyValue',cell,property,value);
		},
		/**
		 * 页面编辑器
		 */
		_initPageEditor:function(){
			var self = this;
			var pageEditorElement = this._getWidgetElement('pageEditor');
			pageEditorElement.pageEditor({
				width:this.element.width()-240-200,
				height:this.height-10,
				select:function(event,ui){
					//打开属性编辑器
					self._activePropertyTable(ui.widgetElement,ui.widgetModel,
							['widget',ui.widgetModel.widgetType,ui.widgetModel.widgetName]);
					self._selectTreeNode(ui.widgetModel);
					
					self._activeToolbar(['remove']);
				},
				propertyChangeListener:function(event,ui){//监听属性发生变化
					self._setWidgetTreeNodeText(ui.widgetModel);
				},
				tableSelectListener:function(event,ui){//监听table组件的区域选择
					var tableElement = ui.startCell;
					if(ui.startCell!=null){
						self._activeToolbar(['merge']);
					}else{
						self._disableToolbar(['merge']);
					}
				},
				editorChangeListener:function(event,ui){//监听元素的变化
					//增加元素、删除元素、移动元素
					//ui.remove model
					//ui.add    model
					//ui.move,ui.moveTo
					if(ui.add&&ui.parentWidgetId){//元素增加
						//_log.info(ui.add.widgetId+' appendTo '+ui.parentWidgetId);
						self._addWidgetTreeNode(ui.add,ui.parentWidgetId);
					}else if(ui.remove){//元素删除
						//_log.info(ui.add.widgetId+' appendTo '+ui.parentWidgetId);
						self._removeWidgetTreeNode(ui.remove);
					}else if(ui.move){//元素移动
						_log.info('移动节点到：'+ui.parentWidgetId);
						self._moveWidgetTreeNode(ui.move,ui.parentWidgetId);
					}else if(ui.change){//修改field元素类型
						//
						self._changeWidgetFieldType(ui.change,ui.exsitFieldType);
					}
						
				}
			}).addClass('layoutDrop');
		},
		/**
		 * 模型结构树引起编辑器元素的变化
		 */
		_selectPageEditorElem:function(treeNodeId){
			var pageEditorElem = this._getWidgetElement('pageEditor');
			var widgetElement = pageEditorElem.find('#'+treeNodeId.substring('tree_'.length));
			pageEditorElem.pageEditor('selectWidgetItem',widgetElement);
		},
		/**begin 由编辑器引起的模型树结构的变化的相关方法**/
		_addWidgetTreeNode:function(widgetModel,parentWidgetId){
			var treeElement = this._getWidgetElement('tree_widgets');
			var parentNode = treeElement.find('.treeNode#'+this._getTreeNodeIdFromWidgetId(parentWidgetId));
			treeElement.tree('addNode',parentNode,this._getTreeNodeIdFromWidgetId(widgetModel.widgetId),
				this._getTreeTextFromWidgetModel(widgetModel)
				,null,{group:widgetModel.widgetName}
			);
		},
		
		_removeWidgetTreeNode:function(widgetModel){
			this._getWidgetElement('tree_widgets')
				.tree('removeNode',this._getTreeNodeIdFromWidgetId(widgetModel.widgetId));
			//this._selectTreeNode(widgetModel);
			this._disableToolbar(['remove']);
		},
		
		_moveWidgetTreeNode:function(widgetModel,parentWidgetId){
			//moveTreeNode:function(treeNode,moveToTreeNode
			var treeElement = this._getWidgetElement('tree_widgets');
			var treeNode = treeElement.find('#'+this._getTreeNodeIdFromWidgetId(widgetModel.widgetId));
			var moveToTreeNode = treeElement.find('#'+this._getTreeNodeIdFromWidgetId(parentWidgetId));
			treeElement.tree('moveTreeNode',treeNode,moveToTreeNode);
		},
		/**
		 * 改变field元素的类型
		 */
		_changeWidgetFieldType:function(widgetModel,exsitFieldType){
			var treeElement = this._getWidgetElement('tree_widgets');
			var treeNode = treeElement.find('#'+this._getTreeNodeIdFromWidgetId(widgetModel.widgetId));
			
			treeNode.find('.'+exsitFieldType).andSelf()
				.removeClass(exsitFieldType)
				.addClass(widgetModel.fieldType);
		},
		
		_setWidgetTreeNodeText:function(widgetModel){
			var treeNode = this._getWidgetElement('tree_widgets').find('#'+this._getTreeNodeIdFromWidgetId(widgetModel.widgetId));
			treeNode.find('>span>a').text(this._getTreeTextFromWidgetModel(widgetModel));
		},
		
		_getTreeTextFromWidgetModel:function(widgetModel){
			return widgetModel.caption||widgetModel.property||widgetModel.name||widgetModel.widgetId;
		},
		
		_getTreeNodeIdFromWidgetId:function(widgetId){
			var treeIdPrefix = 'tree_';
			return treeIdPrefix+widgetId;
		},
		
		_selectTreeNode:function(widgetModel){
			var treeElement = this._getWidgetElement('tree_widgets');
			var treeNode =  treeElement.find('#'+this._getTreeNodeIdFromWidgetId(widgetModel.widgetId));
			treeElement.tree('selectedNode',null,treeNode);//:function(event,treeNodeElement)
		},
		/**end 由编辑器引起的模型树结构的变化的相关方法**/
		/**
		 * 添加页面元素
		 */
		addPageElem:function(dropElem,widgetType,elemType){
			var widgetOptions = this._getWidgetElement('propertyTable')
				.propertyTable('getPropertyDescs',['widget',widgetType,elemType]);
			this._getWidgetElement('pageEditor').pageEditor('addPageElem',
				dropElem,widgetType,elemType,widgetOptions);
		},
		/**
		 * 添加表单元素
		 */
		addFieldElem:function(dropElem,fieldType,fieldCaption){
			this._getWidgetElement('pageEditor').pageEditor('addFieldElem',
				dropElem,fieldType,fieldCaption);
		},
		/**
		 * 删除编辑器的元素
		 */
		removePageElem:function(){
			if(this._getWidgetElement('pageEditor').pageEditor('removePageElem')==true){
				this.disablePropertyTable();
			}
		},
		
		/**
		 * 激活属性编辑
		 */
		_activePropertyTable:function(widgetElement,widgetModel,groups){
			this._getWidgetElement('propertyTable').propertyTable('active',
				widgetElement,widgetModel,
				groups);
		},
		
		disablePropertyTable:function(){
			this._getWidgetElement('propertyTable').propertyTable('disable');
		},
		
		mergeTableCell:function(){
			this._getWidgetElement('pageEditor').pageEditor('mergeTableCell');
		},
		/**
		 * 保存
		 */
		save:function(){
			var xml = this._getWidgetElement('pageEditor').pageEditor('buildXml');
			var saveForm = $('#'+this.options.id+'_save');
			saveForm.form('fieldValue','content',xml);
			saveForm.form('open');
		},
		
		run:function(){
			var xml = this._getWidgetElement('pageEditor').pageEditor('buildXml');
			var saveForm = $('#'+this.options.id+'_save');
			var record = saveForm.form('getFormRecord');
			record.content = xml;
			$.youi.pageUtils.goPage('/page/gsoft.dev.form/run.html',record);
		},
		
		showCode:function(){
			var saveForm = $('#'+this.options.id+'_save');
			var record = saveForm.form('getFormRecord');
			
			$.youi.pageUtils.goPage('/page/gsoft.dev.form/showCode.html',record);
		},
		
		funcs:function(){
			var pageEditorId = this.options.id+'_pageEditor';
			var dialogFormId = this.options.id+'_funcs';
			var afterSubmitFuncName = dialogFormId+'_afterSubmit';
			
			if(!window[afterSubmitFuncName]){
				window[afterSubmitFuncName] = function(){
					var funcBodys = {};
					$('#'+dialogFormId+'>.container_funcs>.func').each(function(){
						var funcName = this.getAttribute('id');
						var funcBody = $('.func_body',this).val();
						if($.trim(funcBody)||$(this).is('.active')){
							//_log.info('函数内容：'+funcBody);
							funcBodys[funcName] = funcBody;
						}
					});
					
					$('#'+pageEditorId).pageEditor('saveFuncBody',funcBodys);
					
					$('#'+dialogFormId).form('close');
				}
			}
			
			var funcs = this._getWidgetElement('pageEditor').pageEditor('funcs');
			var funcHtmls = [];
			
			var funcBody;
			for(var funcName in funcs){
				funcBody = funcs[funcName].content||'';
				funcHtmls.push('<div class="func '+(funcBody?'active':'')+'" id="'+funcName+'">');
				funcHtmls.push('<div class="func_comment">//'+funcs[funcName]['comment']+'</div>');
				funcHtmls.push('<div class="func_begin"><span class="js_key_func">function</span> <span class="func_name">'+funcName+'</span>('+(funcs[funcName].param||'')+'){</div>');
				funcHtmls.push('<textarea class="func_body">'+funcBody+'</textarea>');
				funcHtmls.push('<div class="func_end">}</div>');
				funcHtmls.push('</div>');
				funcBody = '';
			}
			
			$('#'+dialogFormId).form('open').find('>.container_funcs')
				.html(funcHtmls.join('')).find('.func.active').each(function(){
					$(this).parent().prepend(this);
				});
		},
		
		/**
		 * 注册命令
		 */
		_registerCommands:function(){
			if(!this._initCommands){return;}
			
			this._initCommands();//初始化命令
			//保存
			this.registerCommand('save',{
				exec:function(){
					$('#'+this.editorId).formDesigner('save');
					return false;
				},
				undo:function(){},
				getTitle:function(){return "保存";}
			});
			//增加field
			this.registerCommand('addField',{
				exec:function(){
					$('#'+this.editorId).formDesigner('addField',
						this.cell,
						this.field);
					return false;
				},
				undo:function(){},
				getTitle:function(){return "重做";}
			});
			
			this.registerCommand('merge',{
				exec:function(){
					$('#'+this.editorId).formDesigner('mergeTableCell');
					return false;
				},
				undo:function(){},
				getTitle:function(){return "合并单元格";}
			});
			
			this.registerCommand('run',{
				exec:function(){
					$('#'+this.editorId).formDesigner('run');
					return false;
				},
				undo:function(){},
				getTitle:function(){return "运行";}
			});
			
			//保存
			this.registerCommand('showCode',{
				exec:function(){
					$('#'+this.editorId).formDesigner('showCode');
					return false;
				},
				undo:function(){},
				getTitle:function(){return "保存";}
			});
			
			this.registerCommand('remove',{
				exec:function(){
					$('#'+this.editorId).formDesigner('removePageElem');
					return false;
				},
				undo:function(){},
				getTitle:function(){return "删除元素";}
			});
			this.registerCommand('funcs',{
				exec:function(){
					$('#'+this.editorId).formDesigner('funcs');
					return false;
				},
				undo:function(){},
				getTitle:function(){return "JS函数";}
			});
			
		},
		/**
		 * 初始化属性编辑表格
		 */
		_initPropertyTable:function(){
			var propertyTableElem = this.element.find('#'+this.options.id+'_propertyTable');
			propertyTableElem.propertyTable({
				height:this.height,
				propertyChanges:{
					//属性值变化监听
				},
				defaultChange:setPropertyValue,
				propertyGroupDescs:this.options.propertyGroupDescs
			});
		}
	}));
	
	$.extend($.youi.formDesigner,{
		version: "1.0.0"
	});
	
	/*
	 * 回调函数
	 */
	function setPropertyValue(cell,property,value,show){
		var formDesigner = cell.parents('.youi-formDesigner:first');
		formDesigner.formDesigner('setPropertyValue',cell,property,value,show);
	}
})(jQuery);