(function($) {
	var _log = $.youi.log;
	
	/**
	 * 工作流设计器
	 * @author  zhyi_12
	 * @version 1.0.0
	 * @date 2011-04-03
	 */
	$.widget("youi.workflowDesigner", $.extend({},$.youi.dragSupport,$.youi.command,{
		/**
		 * 构造函数
		 */
		_create:function(){
			this.options.id = this.element.attr('id');
			this.element.addClass('youi-workflowDesigner');
			this._registerCommands();//初始化命令并注册设计器相关的命令
			//初始化workflow
			
			this._initWorkflow();//初始化工作流图形组件
			this._initToolbar();
			this._initPropertyTable();//
		},
		/**
		 * 初始化工作流图形组件
		 */
		_initWorkflow:function(){
			//
			var elementTreeId = this.options.elementTreeId;
			var elementTree = $('.youi-tree#'+elementTreeId);
			
			var workflowElem = this._getWorkflowElem();
			//树节点选中动作
			window[elementTreeId+'_change'] = function(event){
				if(this){
					workflowElem.workflow('selected',this.getAttribute('id'),event);
				}
			};
			///
			var self = this;
			workflowElem.workflow('option','afterLoad',function(treeHtml){
				elementTree.find('>ul>li>ul').empty().html(treeHtml);
			}).workflow('option','select',function(event,ui){
				if(event&&ui){
					//使对应的树节点变成选中样式
					elementTree.find('.selected').removeClass('selected');
					var treeNodeElement = elementTree.find('#'+ui.element.attr('id'));
					treeNodeElement.addClass('selected');
					treeNodeElement.find('a:first').addClass('selected');
					
					//打开属性编辑器
					self._activePropertyTable(ui.element,ui.model);
				}
			}).workflow('option','editorChangeListener',function(event,ui){
				//监听元素的变化;
				if(ui.addNode){//元素增加
					self.executeCommand('addNode',{'model':ui.addNode});
				}else if(ui.addTransition){//元素增加
//					self._addFlowTreeNode(ui.addTransition);
					self.executeCommand('addTransition',{'model':ui.addTransition});
				}else if(ui.remove&&ui.remove.id){//元素删除
					self._removeFlowTreeNode(ui.remove);
				}
			}).workflow('option','propertyChangeListener',function(event,ui){
				//监听属性发生变化
			});
		},
		
		_addFlowTreeNode:function(model){
			var elementTree = $('.youi-tree#'+this.options.elementTreeId);
			if(!model)return;
			var id = model.id,
				text = model.text,
				data = {'group':model.type};
			
			var parentNodeId = model.type=='transition'?'flow_list':'node_list';
			
			elementTree.tree('addNode',elementTree.find('li#'+parentNodeId),id,text,null,data);
		},
		
		_removeFlowTreeNode:function(model){
			var treeElement = $('.youi-tree#'+this.options.elementTreeId);
			treeElement.tree('removeNode',model.id);
			if(model.transitionIds&&$.isArray(model.transitionIds)){
				$(model.transitionIds).each(function(){
					treeElement.tree('removeNode',this);
				});
			}
		},
		
		_getWorkflowElem:function(){
			var workflowElem = this.element.find('.youi-workflow:first');
			if(!workflowElem.length){
				//抛出异常
			}
			return workflowElem;
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
			var propertyTableElem = this._getWidgetElement('propertyTable');
			
			propertyTableElem.propertyTable({
				height:480,
				propertyChanges:{
					//属性值变化监听
				},
				defaultChange:setPropertyValue,
				propertyGroupDescs:{
					"base":{
						"name":"base",
						"caption":"基本属性",
						"propertyDescs":[
						      {"name":"id","caption":"ID","type":"fieldLabel","defaultValue":null,"groups":["widget"]},
						      {"name":"caption","caption":"描述","type":"fieldText","defaultValue":"","groups":["widget"]},
							  {"name":"formKey","caption":"表单","type":"fieldText","defaultValue":null,"groups":["userTask","startEvent"]}
						]
					},
					//initiator
					"startEvent":{
						"name":"startEvent",
						"caption":"起始节点",
						"propertyDescs":[
						      {"name":"initiator","caption":"发起者变量","type":"fieldLabel","defaultValue":"","groups":["startEvent"]}
						 ]
					},
					"userTask":{
						"name":"userTask",
						"caption":"用户节点",
						"propertyDescs":[
						      {"name":"assignee","caption":"指派用户","type":"fieldText","defaultValue":"","groups":["userTask"]},
						      {"name":"candidateGroups","caption":"候选角色","type":"form",'formId':'form_candidateGroups',"defaultValue":"","groups":["userTask"]},
						      {"name":"candidateUsers","caption":"候选用户","type":"fieldText","defaultValue":"","groups":["userTask"]}
						 ]
					},
					"line":{
						"name":"transition",
						"caption":"线条属性",
						"propertyDescs":[
						      {"name":"expression","caption":"表达式","type":"fieldText","defaultValue":"","groups":["transition"]}
						 ]
					}
					
					//activiti:assignee
				}
			});
		},
		/**
		 * 初始化工具栏
		 */
		_initToolbar:function(){
			var toolbarElem = $('#'+this.options.id+'_toolbar',this.element);
			var self = this;
			toolbarElem.toolbar({
				commandWidgetId:'designer',
				commandWidget:'workflowDesigner',
				actions:{
					save:function(){
						self.save(function(xml){
							var saveForm = self.element.parents('.youi-form:first');
							saveForm.form('fieldValue','flowContent',xml);
							saveForm.form('submit');
						});
					}
				}
			}).toolbar('loadItems',[
				{name:'save',tooltip:'保存'},
				{name:'split'},
				{name:'undo',tooltip:'撤销'},
				{name:'redo',tooltip:'重做'},
				{name:'split'},
				{name:'halign',tooltip:'水平对齐'},
				{name:'valign',tooltip:'垂直对齐'},
				{name:'split'},
				{name:'remove',tooltip:'删除'}]
			);
		},
		
		_activePropertyTable:function(element,model){
			var groups = ['widget'];
			if(element.hasClass('transition')){
				groups.push('transition');
			}else if(element.hasClass('userTask')){
				groups.push('userTask');
			}else if(element.hasClass('startEvent')){
				groups.push('startEvent');
			}
			//bind,values,groups
			this._getWidgetElement('propertyTable')
				.propertyTable('active',element,model,groups);
		},
		
		/**
		 * 获取内部组件
		 */
		_getWidgetElement:function(widgetName){
			return this.element.find('#'+this.options.id+'_'+widgetName);
		},
		/**
		 * 注册命令
		 */
		_registerCommands:function(){
			if(!this._initCommands){return;}
			
			this._initCommands();//初始化命令
			var self = this;
			
			this.registerCommand('addNode',{
				exec:function(){
					//执行增加操作
					var model;
					if(this.model){
						model = this.model;
					}else if(this.addOptions){
						getWorkflowInstance(this.editorId)._addNode(this.addOptions.id,
								this.addOptions.text,
								this.addOptions.type,
								this.addOptions.pos);
						model = this.addOptions;
					}
					self._addFlowTreeNode(model);
					return true;
				},
				undo:function(){//撤销增加操作
					if(this.model){
						this.addOptions = $.extend({},this.model);
					}
					//删除html元素
					getWorkflowInstance(this.editorId)._removeNode(this.addOptions.id);
					self._removeFlowTreeNode(this.addOptions);
					this.model = null;//移除model
				},
				getTitle:function(){
					return "增加节点";
				}
			});
			//增加线条
			this.registerCommand('addTransition',{
				exec:function(){
					var model;
					if(this.model){
						model = this.model;
					}else if(this.addOptions){
						model = this.addOptions;
						getWorkflowInstance(this.editorId)._addTransition(model.fromId,model.toId);
					}
					self._addFlowTreeNode(model);
					return true;
				},
				
				undo:function(){
					//删除树节点
					if(this.model){
						this.addOptions = $.extend({},this.model);
					}
					//撤销
					getWorkflowInstance(this.editorId)._removeTransition(this.addOptions.id);
					self._removeFlowTreeNode(this.addOptions);
					this.model = null;//移除model
				},
				
				getTitle:function(){
					return "删除节点";
				}
			});
			
			//根据选择删除节点 removeSelected
			
		},
		
		openUserTaskForm:function(nodeId){
			this._getWorkflowElem().workflow('btn_formDesign',nodeId);
		},
		
		/**
		 * 垂直对齐
		 */
		valign:function(){
			this._getWorkflowElem().workflow('valign');
		},
		
		/**
		 * 水平对齐
		 */
		halign:function(){
			this._getWorkflowElem().workflow('halign');
		},
		
		/**
		 * 水平对齐
		 */
		remove:function(){
			this._getWorkflowElem().workflow('remove');
		},
		
		/**
		 * 设置属性值
		 */
		setPropertyValue:function(element,property,value){
			this._getWorkflowElem().workflow('setPropertyValue',element,property,value||'');
			if(property=='caption'&&value){
				//设置树文本
				var treeNode = $('.youi-tree#'+this.options.elementTreeId).find('li#'+element.attr('id'));
				treeNode.find('>span>a').text(value);
			}
		},
		/**
		 * 保存
		 */
		save:function(doSave){
			//
			var xml = this._getWorkflowElem().workflow('buildXml');
			if($.isFunction(doSave)){
				doSave.apply(this.element[0],[xml]);
			}
		}
	}));
	
	$.extend($.youi.workflowDesigner,{
		version: "1.0.0"
	});
	
	/*
	 * 回调函数
	 */
	function setPropertyValue(cell,property,value,show){
		var designer = cell.parents('.youi-workflowDesigner:first');
		designer.workflowDesigner('setPropertyValue',cell,property,value,show);
	}
	
	function getWorkflowInstance(designerId){
		var workflowElement = $('#'+designerId+' .youi-workflow:first');
		var instance =  $.data(workflowElement[0],'youi-workflow');//$.youi.getWidget(workflowElement,'workflow');
		return instance;
	}
	
})(jQuery);