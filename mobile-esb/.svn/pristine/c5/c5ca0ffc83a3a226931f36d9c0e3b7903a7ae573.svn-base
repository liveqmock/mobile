//$.youi.widgetFactory

/**
 * 组件工厂
 */
(function (jQuery){
    this.version = '1.0.0';
    this.widgetObjects = {};
    /**
     * 注册组件
     */
    this.register = function(widgetObject) {
     	var otherParentWidgets = Array.prototype.slice.call(arguments, 1);
		var otherWidgetObject = {};
		 
		if(otherParentWidgets){
			for(var i=0;i<otherParentWidgets.length;i++){
				$.extend(otherWidgetObject,otherParentWidgets[i]);
			}
		}
		
		this.widgetObjects[widgetObject.widgetName] = 
			$.extend({},$.youi.pageEditor.widgetObject,otherWidgetObject,widgetObject);
        return this;
	};
	/**
	 * 注册YOUI 基本组件
	 */
	this.registerComponent = function(widgetObject){
		widgetObject.widgetType = $.youi.pageEditor.widgetType.COMPONENT;
		return this.register.apply(this,Array.prototype.slice.call(arguments));
	};
	/**
	 * 注册布局组件
	 */		
	this.registerLayout =function(widgetObject){
		widgetObject.widgetType = $.youi.pageEditor.widgetType.LAYOUT;
		return this.register.apply(this,Array.prototype.slice.call(arguments));
	};
	/**
	 * 注册YOUI FILED组件
	 */		
	this.registerField  = function(widgetObject){
		widgetObject.widgetType = $.youi.pageEditor.widgetType.FIELD;
		return this.register.apply(this,Array.prototype.slice.call(arguments));
	};
	/**
	 * 注册HTML元素组件
	 */		
	this.registerHtml  = function(widgetObject){
		widgetObject.widgetType = $.youi.pageEditor.widgetType.HTML;
		return this.register.apply(this,Array.prototype.slice.call(arguments));
	};
	/**
	 * 生成html
	 */
	this.buildHtml = function(widgetModel){
		var widgetObject = this.widgetObjects[widgetModel.widgetName];
		widgetModel = this.parseWidgetModel(widgetModel);
		var htmls = [];
		if(widgetObject){
			htmls.push('<div class="youi-'+widgetModel.widgetName+'">');
			htmls.push(widgetObject.buildHtml(widgetModel)||'');
			htmls.push('</div>');
		}
		return htmls.join('');
	};
	
	this.parseWidgetModel = function(widgetModel){
		var parsedWidgetModel = {};
		var parsedAttr;
		for(var attr in widgetModel){
			parsedAttr = attr;
			var attrSplits = attr.split('_');
			if(attrSplits.length){
				parsedAttr = attrSplits[attrSplits.length-1];
			}
			parsedWidgetModel[parsedAttr] = widgetModel[attr];
		}
		return parsedWidgetModel;
	};
	/**
	 * 设置属性值
	 */
	this.setPropertyValue = function(widgetName,widgetElement,property,value){
		var widgetObject = this.widgetObjects[widgetName];
		if(widgetObject){
			var methodName = 'set'+property.substring(0,1).toUpperCase()+property.substring(1);
			$.youi.log.debug('设置属性【'+property+'】='+value);
			if($.isFunction(widgetObject[methodName])){
				widgetObject[methodName].apply(widgetObject,[widgetElement,value]);
			}
		}
	};
	
	this.getFuncs = function(widgetModel){
		var widgetObject = this.widgetObjects[widgetModel.widgetName];
		if(widgetObject&&widgetObject.funcs){
			return widgetObject.funcs(widgetModel);
		}
	}; 
	
    jQuery.youi.widgetFactory = this;
    return jQuery;
})(jQuery);
/*********************************************************************************/
(function($) {
	var _log = $.youi.log;
	/**
	 *  页面编辑 组件
	 * @author  zhouyi
	 * @version 1.0.0
	 * @date 2011-03-18
	 */
	$.widget("youi.pageEditor", $.ui.mouse, $.extend({},$.youi.dragSupport,{
		WIDGET_UUID:0,
		
		options:{
			delay: 0,//
			distance: 1,
			startUUID:0
		},
		
		widgetModels:{},//存储所有的widget模型
		
		pageFuncs : {},//页面函数
		/**
		 *组件初始化
		 */
		_init:function(){
			this.options.id = this.element.attr('id');
			this.options.container = this.options.container||this.element;
			
			this.widgetModels = {};
			this.pageFuncs = {
				initPage:{
					comment:'页面初始化函数',
					content:'//页面初始化'
				}	
			};//页面函数
			
			this.element.addClass('youi-pageEditor childDrop').css({
				height:this.options.height,
				width:this.options.width
			});
			this._initAction();//初始化动作
			this._mouseInit();//初始化拖动
		},
		
		loadFromModel:function(model){
			var htmls = ['<div class="drop-marker"></div>'];
			htmls.push(model.pageHtml);
			this.element.html(htmls.join(''));
			
			if(isNaN(model.widgetUuid)){
				model.widgetUuid = 0;
			}
			
			this.WIDGET_UUID = parseInt(model.widgetUuid||0)+1;
			this.widgetModels = model.widgetModels||{};
			this.pageFuncs = model.pageFuncs||{};
		},
		/**
		 *动作初始化
		 */
		_initAction:function(){
			var selectWidgetStyles = ['widget-item','widget-field','widget-button','grid-col-header','table-td'];
			this.element.bind('click',function(event){
				//widget-item
				var eventClass = $.youi.classUtils.getEventClass(event);
				
				if($.inArray(eventClass,selectWidgetStyles)!=-1){
					$(this).pageEditor('selectWidgetItem',$(event.target),event);
				}else if(eventClass=='grid-col-add-handle'){//增加列
					$(this).pageEditor('addGridCol',$(event.target),event);
				}
			});
		},
		
		/**
		 * 选中widgetItem
		 */
		selectWidgetItem:function(selectWidget,event){
			var oldSelected = this.element.find('.selected');
			if(oldSelected.length||oldSelected[0]!=selectWidget[0]){
				oldSelected.removeClass('selected');
				selectWidget.addClass('selected');
				
				var widgetModel;
				
				this._clearSelectedTableArea();
				
				if(selectWidget.hasClass('table-td')){
					widgetModel = {
						widgetId:'td_'+selectWidget.parent().prevAll().length+'_'+selectWidget.prevAll().length,
						widgetName:'td',
						rowspan:selectWidget.attr('rowspan'),
						colspan:selectWidget.attr('colspan')
					};
					this._completeSelectedTableArea(selectWidget,selectWidget,true);
				}else{
					widgetModel = this.widgetModels[selectWidget.attr('id')];
				}
				
				this._trigger('select', event, {
					widgetElement:selectWidget,
					widgetModel:widgetModel
				});
			}
		},
		/**
		 * 设置组件属性值
		 */
		setPropertyValue:function(widgetElement,property,value,event){
			var widgetId = widgetElement.attr('id');
			var widgetModel = this.widgetModels[widgetId];
			var widgetName = widgetModel.widgetName;
			
			widgetModel[property]= value;
			
			$.youi.widgetFactory.setPropertyValue(widgetName,
				widgetElement,
				property,
				value);
			//监听属性变化
			this._trigger('propertyChangeListener', event, {
				widgetModel:widgetModel
			});
		},
		/**
		 * 打开页面元素的对话框
		 */
		_openPageElemDialog:function(id,elemType,widgetOptions){
			var formId = 'form_'+id;
			var formElem = $('#'+formId);
			var editorId = this.options.id;
			$(widgetOptions).each(function(){
				if(this.property=='widgetId'){
					this.defaultValue = id;
				}else if(this.property=='widgetName'){
					this.defaultValue = elemType;
				}else if(this.property=='component_submit'&&elemType=='grid'){
					this.defaultValue = '查 询';
				}
			});
			
			var formOptions = {};
			if(formElem.length===0){
				formElem = $('<form class="youi-form" id="'+formId+'" ></form>').appendTo($('body',document));
				var fieldLayoutElem = $('<div id="fieldLayout_'+id+'"></div>').appendTo(formElem);
				
				formElem.append('<div class="form-buttons" align="center">'+
					$.youi.buttonUtils.createButtons([{name:'submit',caption:'确定'},{name:'reset',caption:'取消'}])+'</div>');
				
				formElem.form($.extend({
					dialog:true, 
					id:formId,
					caption:'编辑',
					hideCloseIcon:true,
					buttonActions:{
						'submit':function(){
							//提交
							var formElem = $(this).parents('form:first');
							var formRecord = formElem.form('getFormRecord');
							if($('#'+editorId).pageEditor('createWidget',formRecord)!=false){
								formElem.dialog('close');
							}
						},
						'reset':function(){//取消动作
							 $(this).parents('form:first').form('close');
							$('#'+id).remove();
						}
					}
				},formOptions)).bind('keydown',function(event){
					if($(event.target).hasClass('textInput')&&event.keyCode==13){
						$('.youi-button a.submit',this).click();
					}
				});
				
				fieldLayoutElem.fieldLayout({
					fields:widgetOptions
				});
				
			}
			
			formElem.form('open');
		},
		
		/**
		 * 鼠标拖动开始
		 */
		_mouseStart: function(event) {
			//span-item 元素可以拖动
			var target = event.target;
			var eventClass = $.youi.classUtils.getEventClass(event);
			var startClasses  = ['widget-item','widget-field','widget-button'];
			
			this.currentDrag = $(target);
			this.dragClass=eventClass;
			if($.inArray(eventClass,startClasses)!=-1){//拖动-组件拖动
				this.dropMarker = this.element.find('.drop-marker');
				this.helper = this._createHelper(event,this.currentDrag).width(this.currentDrag.width());
			}else if(eventClass=='table-td'){//拖动-table单元格选择
				this._clearSelectedTableArea();
			}else if(eventClass=='grid-col-header'){//拖动-grid组件列拖动
				this.helper = this._createHelper(event,$('<div class="grid-col-helper">'+this.currentDrag.text()+'</div>')).width(this.currentDrag.width());
			}else{
				this.currentDrag = null;
				this.dragClass = null;
			}
		},
		/**
		 * 鼠标拖动过程
		 */
		_mouseDrag: function(event) {
			if(this.currentDrag){
				var dropElem;
				var target = event.target;
				var eventClass = $.youi.classUtils.getEventClass(event);
				var eventClasses = target.className?target.className.split(' '):[];
				
				if(this.helper){
					this.position = this._generatePosition(event);
					this.helper.css(this.position);
				}
				
				if(this.currentDrag){//查询结果的移动动作
					if(this.dragClass=='table-td'&&eventClass=='table-td'){
						if(target!=this.currentDrag[0]
							&&(!this.currentDrop||this.currentDrop[0]!=target)){
							this.currentDrop = $(target);
							this._selectTableArea(this.currentDrag,this.currentDrop);
						}
					}else if(this.dragClass=='grid-col-header'&&eventClass=='grid-col-header'){
						this._doDrag($(target));
					}else if(this._canDragDrop(eventClasses)){//
						this._doDrag($(target));
						$.youi.pageEditor.showDropMarker($(target),this.dropMarker,event.pageY);
					}else{
						this._releaseDrop();
					}
				}
			}
		},
		
		_selectTableArea:function(startCell,endCell){
			var tableElement = startCell.parents('table:first');
			tableElement.find('.td-selected').removeClass('td-selected');
			if(endCell.parents('table:first')[0]!=tableElement[0]){
				return;
			}
			var startColIndex = startCell.prevAll().length,
				startRowIndex = startCell.parent().prevAll().length,
				endColIndex = endCell.prevAll().length,
				endRowIndex = endCell.parent().prevAll().length;
			
			var table = tableElement[0];
			
			var area = _getTableCoverArea(table,{
				rowFrom : Math.min(startRowIndex,endRowIndex),
				rowTo : Math.max(startRowIndex,endRowIndex),
				colFrom : Math.min(startColIndex,endColIndex),
				colTo : Math.max(startColIndex,endColIndex)
			});
			//var fromCell = 
			
			//_log.debug(rowFrom+' - '+rowTo +' - '+colFrom+' - '+colTo);
			for(var row=area.rowFrom;row<=area.rowTo;row++){
				for(var col=area.colFrom;col<=area.colTo;col++){
					$(table.rows[row].cells[col]).addClass('td-selected');
				}
			}
		},
		
		_completeSelectedTableArea:function(startCell,endCell,refreshArea){
			if(refreshArea){this._selectTableArea(startCell,endCell);}
			this._trigger('tableSelectListener', null, {
				startCell:startCell,
				endCell:endCell
			});
		},
		
		_clearSelectedTableArea:function(){
			this.element.find('.td-selected').removeClass('td-selected');
			//监听单元格选择
			this._trigger('tableSelectListener', null, {
				startCell:null,
				endCell:null
			});
		},
		/**
		 * 判断是否允许接收拖动的元素
		 */
		_canDragDrop:function(eventClasses){
			return (this.dragClass=='widget-item'&&$.inArray('layoutDrop',eventClasses)!=-1)//
				 ||(this.dragClass=='widget-field'&&$.inArray('fieldDrop',eventClasses)!=-1)//
				 ||(this.currentDrag.hasClass('component-fieldLayout')&&$.inArray('fieldLayoutDrop',eventClasses)!=-1)
				 ||(this.currentDrag.hasClass('widget-button')&&$.inArray('buttonDrop',eventClasses)!=-1);//按钮容器
			
		},
		/**
		 * 鼠标拖动结束
		 */
		_mouseStop: function(event) {
			if(this.currentDrag&&this.currentDrop){
				if(this.dragClass=='widget-item'){
					//移动元素
					this._moveWidgetElem(this.currentDrag,this.currentDrop);
				}else if(this.dragClass=='widget-field'){
					this._moveFieldElem(this.currentDrag.parent(),this.currentDrop);
				}else if(this.dragClass=='widget-button'){
					this._moveButtonElem(this.currentDrag.parent(),this.currentDrop);
				}else if(this.dragClass=='table-td'){
					//完成单元格选择
					this._completeSelectedTableArea(this.currentDrag,this.currentDrop);
				}else if(this.dragClass=='grid-col-header'){
					//完成grid列交换
					this._moveGridCol(this.currentDrag,this.currentDrop);
				}
				this._dropOut();
			}
			this.dropMarker&&this.dropMarker.removeClass('child').removeClass('before').removeClass('after');
			this.dropMarker = null;
			this.helper&&this.helper.remove();
			this.currentDrag = null;
			this.currentDrop = null;
			this.helper = null;
			this.dragClass = null;
		},
		
		/**
		 * 添加html
		 */
		_defaultHtmls:function(){
			var htmls = [];
			
			this.element.append(htmls.join(''));
			//
		},
		/**
		 * 增加field元素到pageEditor
		 */
		addFieldElem:function(dropElem,fieldType,fieldCaption){
			var uuid = this.genUUID();
			var widgetId = fieldType+uuid;
			var caption = fieldCaption+uuid;
			var property = widgetId;
			
			//如果已经存在field，使用已经存在的field的相关属性
			var exsitFieldElem = dropElem.find('.widget-field');
			var exsitFieldId,exsitFieldType;//
			if(exsitFieldElem.length){
				exsitFieldId = exsitFieldElem.attr('id');
				
				if(this.widgetModels[exsitFieldId]){
					exsitFieldType = this.widgetModels[exsitFieldId].fieldType;
					caption = this.widgetModels[exsitFieldId].caption;
					property = this.widgetModels[exsitFieldId].property;
				}
				widgetId = exsitFieldId;
				delete this.widgetModels[exsitFieldId];//删除之前的模型信息
			}
			
			this.widgetModels[widgetId] = {
				widgetId:widgetId,
				widgetType:'field',
				widgetName:fieldType,
				property:property,
				fieldType:fieldType,
				caption:caption};
			
			//如果是最后一行
			var row = dropElem.parent();
			if(row.next().length==0){
				var newRow = row.clone();
				newRow.find('td').removeClass('droping').empty();
				row.after(newRow);
			}
			
			dropElem.html('<div id="'+widgetId+'" class="widget-field '+fieldType+'">'+property+'</div>');
			dropElem.prev().html(caption);
			
			
			if(!exsitFieldElem.length){
				this._trigger('editorChangeListener', null, {
					add:this.widgetModels[widgetId],
					parentWidgetId:this._getParentWidgetId(widgetId)
				});
			}else{//
				this._trigger('editorChangeListener', null, {
					change:this.widgetModels[widgetId],
					exsitFieldType:exsitFieldType
				});
			}
		},
		
		addGridCol:function(gridColHandle){
			var selectedCol = gridColHandle.parent().find('.selected');
			var firstCol = gridColHandle.next();
			var firstColId = firstCol.attr('id');
			var colIdSplits = firstColId.split('_col');
			var colIndex = gridColHandle.nextAll().length;
			var gridColId = colIdSplits[0]+'_col'+colIndex;
			
			while(this.widgetModels[gridColId]){
				gridColId = colIdSplits[0]+'_col'+(++colIndex);
			}
			
			var gridColCaption = '列'+colIndex;
			var colModel = {
				widgetId:gridColId,
				widgetType:'component',
				widgetName:'gridCol',
				property:gridColId,
				caption:gridColCaption};
			
			var colTd = $('<td id="'+gridColId+'" class="grid-col-header grid-col" valign="top">'+gridColCaption+'</td>');
			
			if(selectedCol.length){
				selectedCol.before(colTd);
			}else{
				gridColHandle.parent().append(colTd);
			}
			
			this.widgetModels[gridColId] = colModel;
			
			this._trigger('editorChangeListener', null, {
				add:colModel,
				parentWidgetId:this._getParentWidgetId(firstColId)
			});
		},
		
		/**
		 * 添加页面元素
		 */
		addPageElem:function(dropElem,widgetType,widgetName,widgetOptions){
			var editorChangeListeners = [];
		
			var elem = null;
			var id = widgetOptions.id||(widgetName+this.genUUID());
			var classes = ['widget-item','widget-'+widgetType,widgetType+'-'+widgetName];
			var showDialog = true;
			this.widgetModels[id] = $.extend({
				widgetId:id,
				widgetType:widgetType,
				widgetName:widgetName,
				editorChangeListeners:editorChangeListeners},
			widgetOptions);
			//处理元素样式
			switch(widgetName){
				case 'div':
					classes.push('childDrop layoutDrop');
					break;
				case 'button':
					classes[0] = 'widget-button';
					classes.push('youi-corner-all');
					break;
				default://组件
			}
			
			elem = $('<div title="'+id+'" class="'+classes.join(' ')+'" id="'+id+'"></div>');
			var specailCreate = false;//使用非通用模式创建元素
			switch(widgetName){
				case 'div':
					showDialog = false;
					break;
				case 'button':
					this._addButtonWidgetElem(elem,dropElem);
					this.widgetModels[id].name = this.widgetModels[id].name||id;
					editorChangeListeners.push({
						add:this.widgetModels[id],
						parentWidgetId:this._getParentWidgetId(id)
					});
					specailCreate = true;
					break;
				case 'grid':
					//创建表格列对象
					var defaultCols = 4;
					var gridColId;
					for(var i=0;i<defaultCols;i++){
						gridColId = id+'_col'+i;
						this.widgetModels[gridColId] = {
							widgetId:gridColId,
							widgetType:'component',
							widgetName:'gridCol',
							property:gridColId,
							caption:'列'+i};
						editorChangeListeners.push({
							add:this.widgetModels[gridColId],
							parentWidgetId:id
						});
						gridColId = '';
					}
					editorChangeListeners.push(this._addInnerFieldLayout('fieldLayout_'+id,id,'查询条件','query'));
					break;
				case 'form':
					editorChangeListeners.push(this._addInnerFieldLayout('fieldLayout_'+id,id,'表单布局','record'));
					break;
				case 'model'://从模型生成
					specailCreate = true;
					showDialog = false;
					
					var gridId = 'grid_'+id;
					var formId = 'form_'+id;
					var gridModel = {
							widgetId:gridId,
							widgetType:'component',
							widgetName:'grid',
							id:gridId,
							caption:widgetOptions.modelCaption+'列表',
							cols:widgetOptions.cols,
							submit:'查 询',
							reset:'重 置',
							prefix:'query',
							buttons:[
							    {id:'add'+id,'caption':'增加',func:"$('#"+formId+"').form('open');"},
							    {id:'edit'+id,'caption':'修改',func:"$('#"+formId+"').form('open');"},
							    {id:'remove'+id,'caption':'删除',func:";"}
							],
							fields:[widgetOptions.cols[0]]
						};
					var formModel = {
						widgetId:formId,
						widgetType:'component',
						widgetName:'form',
						id:formId,
						caption:'编辑'+widgetOptions.modelCaption,
						submit:'提 交',
						reset:'重 置',
						prefix:'record',
						dialog:true,
						fields:widgetOptions.cols
					};
					//grid模型
					this.widgetModels[gridId] = gridModel;
					
					//form模型
					this.widgetModels[formId] = formModel;
					
					//添加页面元素
					this._addModelElem(gridModel,formModel,dropElem);
					
					/***************加入子元素模型并加入editor变化监听***************/
					//列模型
					if($.isArray(widgetOptions.cols)){
						var col;
						for(var i=0;i<widgetOptions.cols.length;i++){
							col = widgetOptions.cols[i];
							gridColId = gridId+'_'+col.property;
							this.widgetModels[gridColId] = {
								widgetId:gridColId,
								widgetType:'component',
								widgetName:'gridCol',
								property:col.property,
								caption:col.caption};
							editorChangeListeners.push({
								add:this.widgetModels[gridColId],
								parentWidgetId:gridId
							});	
							
							//查询条件
							
							
							//表单项
							this.widgetModels[formModel.prefix+'_'+col.property] = {
									widgetId:formModel.prefix+'_'+col.property,
									widgetType:'field',
									widgetName:'fieldText',
									property:col.property,
									fieldType:'fieldText',
									caption:col.caption};
							editorChangeListeners.push({
								add:this.widgetModels[formModel.prefix+'_'+col.property],
								parentWidgetId:'fieldLayout_'+formId
							});
							
							gridColId = '';
							col = null;
						}
					}
					
					//按钮
					if($.isArray(gridModel.buttons)){
						for(var i=0;i<gridModel.buttons.length;i++){
							var button = gridModel.buttons[i];

							this.widgetModels[button.id] = {
									widgetId:button.id,
									widgetType:'component',
									widgetName:'button',
									name:button.id,
									caption:button.caption};
							editorChangeListeners.push({
								add:this.widgetModels[button.id],
								parentWidgetId:gridId
							});
							//按钮函数
							this.pageFuncs['func_grid_'+button.id] = {
								content:button.func,
								comment:'button'
							};
							button = null;
						}
					}

					editorChangeListeners.push(this._addInnerFieldLayout('fieldLayout_form_'+id,'form_'+id,'表单布局','record'));
					editorChangeListeners.push(this._addInnerFieldLayout('fieldLayout_grid_'+id,'grid_'+id,'查询条件','query'));
					
					//form表单
					editorChangeListeners.push({
						add:this.widgetModels[formId],
						parentWidgetId:this._getParentWidgetId(formId)
					});
					
					//表格
					editorChangeListeners.push({
						add:this.widgetModels[gridId],
						parentWidgetId:this._getParentWidgetId(gridId)
					});
					
					break;
				default://组件
			}
			
			if(specailCreate!=true){
				this._addOrMoveWidgetElem(elem,dropElem);
				editorChangeListeners.push({
					add:this.widgetModels[id],
					parentWidgetId:this._getParentWidgetId(id)
				});
			}
			
			if(showDialog){
				this._openPageElemDialog(id,widgetName,widgetOptions);
			}else{
				this._triggerChangeListener(id);
			}
		},
		/**
		 * 
		 */
		_addInnerFieldLayout:function(innerFieldLayoutId,innerFieldLayoutPid,innerFieldLayoutCaption,prefix){
			this.widgetModels[innerFieldLayoutId] 
				={  widgetId:innerFieldLayoutId,
					widgetType:'component',
					widgetName:'fieldLayout',
					caption:innerFieldLayoutCaption,
					prefix:prefix
				};
			return {
				add:this.widgetModels[innerFieldLayoutId],
				parentWidgetId:innerFieldLayoutPid
			};
		},
		
		_triggerChangeListener:function(widgetId){
			var widgetModel = this.widgetModels[widgetId];
			if(!widgetModel)return;
			var editorChangeListeners = widgetModel.editorChangeListeners;
			if($.isArray(editorChangeListeners)){
				for(var i=editorChangeListeners.length-1;i>=0;i--){
					this._trigger('editorChangeListener', null, editorChangeListeners[i]);
				}
				delete widgetModel['editorChangeListeners'];
			}
		},
		
		_getParentWidgetId:function(widgetId){
			var dropStyles = ['youi-pageEditor','widget-item'];
			var parentWidgetId;
			
			if(widgetId==this.element.attr('id')){
				return widgetId;
			}
			
			this.element.find('#'+widgetId).parents().each(function(){
				var elemStyle = this.className;
				if(elemStyle){
					var elemStyles = elemStyle.split(' ');
					for(var i=0;i<dropStyles.length;i++){
						if($.inArray(dropStyles[i],elemStyles)!=-1){
							parentWidgetId = this.getAttribute('id');
							if(parentWidgetId){
								return false;
							}
						}
					}
				}
			});
			return parentWidgetId;
		},
		/**
		 * 移除页面元素
		 */
		removePageElem:function(){
			var selectedWidget = this.element.find('.selected');
			var widgetId = selectedWidget.attr('id');
			if(selectedWidget.length==1&&window.confirm('确定删除元素['+widgetId+']')){
				//删除子节点模型
				var self = this;
				selectedWidget.find('.widget-item,.widget-field,.widget-button,.grid-col-header').each(function(){
					delete self.widgetModels[this.getAttribute('id')];
					_log.info('删除子元素模型：'+this.getAttribute('id'));
				});
				
				//清理外部关联元素
				if(selectedWidget.is('.widget-field')){
					var prevLabel = selectedWidget.parent().prev();
					if(prevLabel.is('.fieldLabel')){
						prevLabel.empty();
					}
				}
				//删除dom元素
				selectedWidget.remove();
				
				this._trigger('editorChangeListener', null, {
					remove:this.widgetModels[widgetId]
				});
				//删除模型
				delete this.widgetModels[widgetId];
				return true;
			}
			return false;
		},
		/**
		 * 创建组件
		 */
		createWidget:function(widgetRecord){
			var htmls = $.youi.widgetFactory.buildHtml(widgetRecord);
			this.element.find('#'+widgetRecord.widgetId).append(htmls);
			
			$.extend(this.widgetModels[widgetRecord.widgetId],widgetRecord);
			
			this._triggerChangeListener(widgetRecord.widgetId);
		},
		/**
		 * 函数列表
		 */
		funcs:function(){
			//this.widgetModels[widgetId]
			var self = this;
			var funcs = {
				'initPage':$.extend({
					comment:'页面初始化函数',
					content:'//页面初始化'
				},this.pageFuncs['initPage'])
			};
			
			//按钮回调函数
			this.element.find('.widget-button').each(function(){
				var widgetId = this.getAttribute('id');
				var buttonModel = self.widgetModels[widgetId];
				
				if(buttonModel&&buttonModel.name){
					var buttonContainer = $(this).parents('.widget-item:first');
					var funcPrefix = 'func_button_';
					var commentPrefix = '按钮';
					if(buttonContainer.hasClass('component-grid')){
						funcPrefix = 'func_grid_';
						commentPrefix = 'grid按钮';
					}
					var funcName = funcPrefix+buttonModel.name;
					funcs[funcName] = $.extend({
						comment:'按钮动作函数 - '+commentPrefix+'【'+buttonModel.caption+'】'
					},self.pageFuncs[funcName]);
				}
			});
			//组件的回调函数
			var widgetModel;
			for(var widgetId in this.widgetModels){
				widgetModel = this.widgetModels[widgetId];
				var modelFuncs = $.youi.widgetFactory.getFuncs(widgetModel);
				for(var funcName in modelFuncs){
					funcs[funcName] = $.extend({},modelFuncs[funcName],self.pageFuncs[funcName]);
				}
			}
			
			this.pageFuncs = funcs;
			return funcs;
		},
		/**
		 * 保存函数内容
		 */
		saveFuncBody:function(funcBodys){
			for(var funcName in funcBodys){
				if(this.pageFuncs[funcName]){
					this.pageFuncs[funcName].content = funcBodys[funcName];
				}
			}
		},
		
		_addOrMoveWidgetElem:function(moveItem,relativeItem){
			var dropMarker = this.element.find('.drop-marker');
			var addType = '';
			//判断接收节点是否为拖动节点的上级的节点
			if(relativeItem.parents().length==relativeItem.parents().not(moveItem).length){
				if(dropMarker.hasClass('child')||relativeItem.hasClass('childDrop')){
					relativeItem.append(moveItem);
					addType = 'child';
				}else if(dropMarker.hasClass('before')){
					relativeItem.before(moveItem);
					addType = 'before';
				}else if(dropMarker.hasClass('after')){
					relativeItem.after(moveItem);
					addType = 'after';
				}
			}
			dropMarker.removeClass('before').removeClass('child').removeClass('after');
			return addType;
		},
		/**
		 * 增加按钮
		 */
		_addButtonWidgetElem:function(elem,dropElem){
			var hasButton = dropElem.find('.youi-button').length;
			if(hasButton){//插入到当前单元格后
				dropElem = dropElem.clone().empty().insertAfter(dropElem);
			}
			dropElem.append(elem);
			this.element.find('.drop-marker').removeClass('before').removeClass('child').removeClass('after');
		},
		/**
		 * 当拖到对象为模型时添加dom元素
		 */
		_addModelElem:function(gridModel,formModel,dropElem){
			//创建查询列表
			var gridElem = $('<div class="widget-item widget-component component-grid" id="'+gridModel.id+'"></div>');
			this._addOrMoveWidgetElem(gridElem,dropElem);
			this.createWidget(gridModel);
			//创建form
			var formElem = $('<div class="widget-item widget-component component-form" id="'+formModel.id+'"></div>');
			this._addOrMoveWidgetElem(formElem,dropElem);
			this.createWidget(formModel);
		},
		
		_moveWidgetElem:function(elem,dropElem){
			var widgetId = elem.attr('id');
			var fromWidgetId = this._getParentWidgetId(widgetId);
			this._addOrMoveWidgetElem(elem,dropElem);
			var toWidgetId = this._getParentWidgetId(widgetId);
			
			if(fromWidgetId!=toWidgetId){
				this._trigger('editorChangeListener', null, {
					move:this.widgetModels[widgetId],
					parentWidgetId:toWidgetId
				});
			}
		},
		/**
		 * 移动按钮
		 */
		_moveButtonElem:function(dragCell,dropCell){
			this._moveFieldElem(dragCell,dropCell);
		},
		/**
		 * 移动grid 组件列
		 */
		_moveGridCol:function(dragCell,dropCell){
			if(dragCell.parent()[0]==dropCell.parent()[0]){
				dropCell.before(dragCell);
			}
		},
		
		_moveFieldElem:function(dragCell,dropCell){
			//单元格交换
			var dragNextHelper = $('<td class="drag-helper-next"/>');
			var dropNextHelper = $('<td class="drop-helper-next"/>');
			
			var dragCellPrev = dragCell.prev();
			var dropCellPrev = dropCell.prev();
			
			dragNextHelper.insertAfter(dragCell);
			dropNextHelper.insertAfter(dropCell);
	
			_exchangeRowAndColspan(dragCell,dropCell);
			dragCell.insertAfter(dropNextHelper);
			dropCell.insertAfter(dragNextHelper);
			//if(dragCell)
			
			if(dragCellPrev.is('.fieldLabel')&&dropCellPrev.length){
				_exchangeRowAndColspan(dropCellPrev,dragCellPrev);
				dropCellPrev.insertAfter(dragNextHelper);
				dragCellPrev.insertAfter(dropNextHelper);
			}
			
			//删除辅助元素
			dragNextHelper.remove();
			dropNextHelper.remove();
			dragNextHelper = null;
			dropNextHelper = null;
		},
		/**
		 * 合并表格的单元格
		 */
		mergeTableCell:function(){
			var startCell = this.element.find('td.td-selected:first'),
				lastCell = this.element.find('td.td-selected:last');
			var rowspan = lastCell.parent().prevAll().length - startCell.parent().prevAll().length+1,
				colspan = lastCell.prevAll().length - startCell.prevAll().length+1;
			
			
			var containMergeCell = false;//区域内是否已经有合并的单元格
			this.element.find('td.td-selected').each(function(index){
				//查找是否存在已经合并的单元格
				if($(this).attr('rowspan')>1||$(this).attr('colspan')>1){
					containMergeCell = true;
					return false;
				}
			});
			
			if(!containMergeCell)startCell.attr('rowspan',rowspan).attr('colspan',colspan);
			this.element.find('td.td-selected').each(function(index){
				var cell = $(this);
				if(containMergeCell){//执行拆分
					if(cell.attr('rowspan')>1||cell.attr('colspan')>1){
						cell.attr('rowspan',1).attr('colspan',1);
					}
					cell.show();
				}else{//执行合并
					if(index>0)cell.hide();
				}
			});
		},
		/**
		 * 输出xml描述
		 */
		buildXml:function(){
			var xmls = ['<?xml version="1.0" encoding="UTF-8"?>'];
			xmls.push('<page widgetUuid="'+this.WIDGET_UUID+'">');
			
			var self = this;
			this.element.find('>.widget-item').each(function(){
				xmls.push(self._buildWidgetXml($(this)));
			});
			//函数
			xmls.push('<funcs>');
			//xmls.push();
			var funcBody;
			for(var funcName in this.pageFuncs){
				funcBody = this.pageFuncs[funcName].content;
				if($.trim(funcBody)){
					xmls.push('<func comment="'+(this.pageFuncs[funcName]['comment']||'')+'" name="'+funcName+'"><![CDATA[ ');
					xmls.push(funcBody);
					xmls.push(']]></func>');
				}
			}
			xmls.push('</funcs>');
			
			xmls.push('</page>');
			return xmls.join('');
		},
		
		_buildWidgetXml:function(widgetElement){
			var xmls = [];
			var widgetId = widgetElement.attr('id');
			var widgetModel = this.widgetModels[widgetId];
			var modelAttr;
			if(widgetModel){
				var tagName = widgetModel.widgetName;
				
				xmls.push('<'+tagName);
				
				for(var attr in widgetModel){
					if(typeof(widgetModel[attr])=='string'){
						//
						
						xmls.push(' ');
						modelAttr = attr;
						if(attr.indexOf(widgetModel.widgetType+'_')==0){
							modelAttr = attr.replace(widgetModel.widgetType+'_','');
							if(widgetModel[modelAttr]){//如果没有默认值
								continue;
							}
						}
						
						xmls.push(modelAttr);
						
						xmls.push('="');
						xmls.push(widgetModel[attr]);
						xmls.push('"');
						
						modelAttr = null;
					}
				}
				xmls.push('>');
				
				if(widgetElement.hasClass('layout-table')){//表格布局组件
					var table = widgetElement.find('table:first')[0];
					var rows = table.rows.length;
					var cols = table.rows[0].cells.length;
					_log.debug('rows:'+rows);
					for(var row=0;row<rows;row++){
						xmls.push('<tr>');
						for(var col=0;col<cols;col++){
							xmls.push('<td>');
							xmls.push(this._buildChildrenXml($(table.rows[row].cells[col])));
							xmls.push('</td>');
						}
						xmls.push('</tr>');
					}
					
				}else{
					xmls.push(this._buildChildrenXml(widgetElement));
				}
				xmls.push('</'+tagName+'>');
			}
			return xmls.join('');
		},
		
		_buildChildrenXml:function(parentElement){
			var xmls = [];
			//子元素处理 处理
			var childElements;
			//layout-div
			///html/body/div/table/tbody/tr/td[2]/div/div[2]/div/table/tbody/tr/td
			if(parentElement.hasClass('table-td')){//表格单元格
				childElements = parentElement.find('>.widget-item');
			}else if(parentElement.hasClass('component-fieldLayout')){//fieldLayout布局
				childElements = parentElement.find('.widget-field');
			}else if(parentElement.hasClass('layout-div')){//div布局
				childElements = parentElement.find('>.widget-item');
			}else if(parentElement.hasClass('component-buttons')){//按钮容器
				childElements = parentElement.find('.widget-button');
			}else{//其他组件的内嵌
				childElements = parentElement.find('.grid-col-header,.widget-item,.component-button');
			}
			
			var self = this;
			if(childElements){
				childElements.each(function(){
					xmls.push(self._buildWidgetXml($(this)));
				});
			}
			return xmls.join('');
		},
		
		genUUID:function(){
			return this.options.startUUID+this.WIDGET_UUID++;
		}
	}));
	
	$.extend($.youi.pageEditor,{
		version: "1.0.0",
		
		getter:['addPageElem','removePageElem','buildXml','funcs'],
		
		widgetObject:{
			widgetId:'',
			widgetName:'widget',
			buildHtml:function(widgetModel){return '';}//获得HTML
		},
		/**
		 *
		 */
		captionWidget:{
			setCaption:function(widgetElement,value){
				var captionElement = widgetElement.is('.widget-caption')
					?widgetElement:widgetElement.find('.widget-caption:first')
				captionElement.text(value);
			}
		},
		
		fieldWidget:{
			setProperty:function(widgetElement,value){
				widgetElement.text(value);
			},
			
			setCaption:function(widgetElement,value){
				widgetElement.attr('title',value);
				widgetElement.parent().prev().text(value);
			},
			
			setNotNull:function(widgetElement,value){
				value==1?widgetElement.addClass('notNull'):widgetElement.removeClass('notNull');
			},
			/**
			 * 设置占位
			 */
			setColumn:function(widgetElement,value){
				value = value||1;
				var cell = widgetElement.parent();
				var colspan = cell.attr('colspan')||1;
				var cols = cell.parent().find('td').length;//计算总列数
				var index = cell.prevAll().length;//当前元素的定位
				var end = Math.min(cols,value*2);
				
				cell.attr('colspan',end-index);
				if(colspan>value){//减少占位
					var nextCell = cell;
					for(var i=index;i<end+(colspan-value)*2;i++){
						nextCell = nextCell.next().show();
					}
				}else if(colspan<value){//增加占位
					var nextCell = cell;
					for(var i=index;i<end;i++){
						nextCell = nextCell.next().hide();
					}
				}
			}
		},
		
		widgetType:{
			LAYOUT:'layout',
			COMPONENT:'component',
			FIELD:'field',
			HTML:'html'
		},
		
		showDropMarker:function(dropNode,dropMarker,pageY){
			parentOffset = dropMarker.parent().offset();
			if(!parentOffset)return ;
			var positionStyle,
				markerTop = {},
				dropLeft = dropNode.offset().left-parentOffset.left,
				dropTop = dropNode.offset().top-parentOffset.top;
				dropBottom = dropTop+dropNode.outerHeight() ;
				
			dropMarker.removeClass('before').removeClass('after').removeClass('child');
			if(dropNode.hasClass('childDrop')){
				positionStyle = 'child';
				markerTop = (dropTop+dropBottom)/2;
			}else if(pageY>dropTop&&pageY<dropTop+8){
				positionStyle = 'before';
				markerTop = dropTop;
			}else if(pageY>dropBottom-8&&pageY<dropBottom){
				positionStyle = 'after';
				markerTop = dropBottom;
			}else{
				positionStyle = 'child';
				markerTop = (dropTop+dropBottom)/2;
			}
			
			dropMarker.addClass(positionStyle).css({
				top:markerTop-7,
				left:dropLeft
			});
		}
	});
	
	/**
	 * 树数据结构
	 */
	var _treeData = {
		children:[],
		id:'',
		text:'',
		group:'',
		addChild:function(child){
			var child = $.extend({},_treeData,child);
			child.children=[];
			this.children.push(child);
			return this;
		},
		
		toHtml:function(last){
			var htmls = [];
			var childCount = this.children.length;
			
			var styles = [];
			
			if(last)styles.push('last');
			
			if(childCount>0){
				styles.push('expanded');
				if(last){
					styles.push('expanded');
				}
			}
			
			styles.push(this.group);
			
			htmls.push('<li class="treeNode '+styles.join(' ')+'"');
			htmls.push(' id="'+this.id+'" ');
			htmls.push('><span class="tree-span '+styles.join(' ')+'" >');
			htmls.push('<a class="tree-a '+styles.join(' ')+'" href="#" >');
			htmls.push(this.text);
			htmls.push('</a></span>')
			if(childCount>0){
				htmls.push('<ul>');
				for(var i=0;i<childCount;i++){
					htmls.push(this.children[i].toHtml(childCount==i+1));
				}
				htmls.push('</ul>');
			}
			htmls.push('</li>');
			return htmls.join('');
		}
	};
	
	//注册widgetObject
	$.youi.widgetFactory.registerLayout({
		widgetName:'table',
		buildHtml:function(options){
			var rows = options.rows||2,
				cols = options.cols||3;
			var cellWidth = Math.floor(10000/cols)/100;
			var htmls = ['<table width="100%" cellpading="0" cellspacing="0">'];
			for(var row=0;row<rows;row++){
				htmls.push('<tr>');
				for(var col=0;col<cols;col++){
					htmls.push('<td class="table-td layoutDrop childDrop"></td>');
				}
				htmls.push('</tr>');
			}
			htmls.push('</table>');
			return htmls.join('');
		}
	}).registerLayout({
		widgetName:'div',
		caption:'div布局'
	}).registerComponent({
		widgetName:'grid',
		caption:'grid组件',
		setSubmit:function(widgetElement,submit){
			//
			widgetElement.find('#button_submit').text(submit);
		},
		setReset:function(widgetElement,reset){
			//
			widgetElement.find('#button_reset').text(reset);
		},
		funcs:function(options){
			var key = options.widgetId;
			if(options.id||options.name){
				key = options.id||(options.widgetName+'_'+options.name);
			}
			var funcs = {};
			funcs[key+'_beforeSubmit'] = {
				comment:'回调函数 - grid组件查询前'
			};
			funcs[key+'_change'] = {
				comment:'回调函数 - grid组件行选择变化'
			};
			return funcs;
		},
		buildHtml:function(options){
			var htmls = [];
			
			if(options.panel!=false){
				htmls.push(_buildPanelPrefix(options.caption));
			}
			//添加fieldLayout
			htmls.push(_buildInnerFieldLayout(options));
			//添加查询和重置按钮
			htmls.push('<div align="center" class="grid-formButtons">');
			if(options.submit!='NOT')htmls.push('<div class="form-button youi-corner-all" id="button_submit">'+options.submit+'</div>');
			if(options.reset!='NOT')htmls.push('<div class="form-button youi-corner-all" id="button_reset">'+options.reset+'</div>');
			htmls.push('</div>');
			
			//添加按钮容器
			htmls.push('<div class="youi-buttons component-buttons" align="right">');
			htmls.push(_buildButtonLayout(options.buttons));
			htmls.push('</div>');
			//htmls.push('<div title="此处可以放置按钮" class="buttonDrop"></div>');
			//添加表格列
			
			htmls.push('<table class="grid-table bg-border" width="100%" cellpading="0" cellspacing="1">');
			htmls.push('<tr>');
			htmls.push('<td width="1%" title="增加列" class="grid-col-add-handle" valign="top" >+</td>');
			if(!options.cols){
				for(var col=0;col<4;col++){
					htmls.push('<td valign="top" id="'+(options.widgetId+'_col'+col)+'" class="grid-col-header grid-col widget-caption">列'+col+'</td>');
				}
			}else{
				for(var col=0;col<options.cols.length;col++){
					htmls.push('<td valign="top" id="'+options.widgetId+'_'+options.cols[col].property+'" class="grid-col-header grid-col widget-caption">'+options.cols[col].caption+'</td>');
				}
			}
			htmls.push('</tr>');
			htmls.push('</table>');
			
			htmls.push('<div class="grid-footer"></div>');
			
			if(options.panel!=false){
				htmls.push(_buildPanelPostfix());
			}
			return htmls.join('');
		}
	},$.youi.pageEditor.captionWidget).registerComponent({
		widgetName:'gridCol',
		setWidth:function(widgetElement,width){
			widgetElement.attr('width',width);
		}
	},$.youi.pageEditor.captionWidget).registerComponent({
		widgetName:'form',
		setSubmit:function(widgetElement,submit){
			widgetElement.find('#button_submit').text(submit);
		},
		setReset:function(widgetElement,reset){
			widgetElement.find('#button_reset').text(reset);
		},
		funcs:function(options){
			var key = options.widgetId;
			if(options.id||options.name){
				key = options.id||(options.widgetName+'_'+options.name);
			}
			var funcs = {};
			funcs[key+'_beforeSubmit'] = {
				comment:'回调函数 - form组件提交前',
				content:'return true;'
			};
			funcs[key+'_afterSubmit'] = {
				comment:'回调函数 - form提交后',
				param:'results'
			};
			return funcs;
		},
		buildHtml:function(options){
			var htmls = [];
				
			if(options.panel!=false){
				htmls.push(_buildPanelPrefix(options.caption));
			}
			
			htmls.push(_buildInnerFieldLayout(options));
			htmls.push('<div class="form-buttons" align="center">');
			htmls.push('<table><tr>');
			if(options.submit!='NOT')htmls.push('<td><div class="form-button youi-corner-all" id="button_submit">'+options.submit+'</div></td>');
			if(options.reset!='NOT')htmls.push('<td><div class="form-button youi-corner-all" id="button_reset">'+options.reset+'</div></td>');
			htmls.push('<td>');
			htmls.push(_buildButtonLayout());
			htmls.push('</td>');
			htmls.push('</tr></table>');
			
			htmls.push('</div>');
			
			if(options.panel!=false){
				htmls.push(_buildPanelPostfix());
			}
			return htmls.join('');
		}
	},$.youi.pageEditor.captionWidget).registerComponent({
		widgetName:'fieldLayout',
		buildHtml:function(options){
			var htmls = [];
			options = $.extend({columns:2},options);
			htmls.push(_buildFormLayout(options.columns));
			return htmls.join('');
		},
		setColumns:function(widgetElement,value){
			var table = widgetElement.find('table:first')[0];
			var oldColumns = table.rows[0].cells.length/2;
			var cols = value*2;
			var cellWidth = Math.floor(10000/cols)/100;
			if(value!=oldColumns){
				//重新组织
				var tempTr = $('<tr></tr>');
				var rowHtmls = ['<tr>'];
				var lastIndex = 0;
				$(table).find('td').each(function(index){
					var mod = index%cols;
					if(mod==0&&index>0){
						rowHtmls.push('</tr>');
						rowHtmls.push('<tr>');
					}
					lastIndex = mod;
					rowHtmls.push(tempTr.empty().append($(this)).html());
				});
				
				for(var i=0;i<(cols-lastIndex-1)/2;i++){
					//补充空余列
					rowHtmls.push('<td class="fieldLabel"></td>');
					rowHtmls.push('<td class="fieldDrop childDrop" title="此处可以放置表单组件"></td>');
				}
				
				rowHtmls.push('</tr>');
				$(table).html(rowHtmls.join(''));
			}else{
				return;
			}
			//重新设置宽度
			$(table).find('td').attr('width',cellWidth+'%');
			$(table).find('tr').each(function(index){
				if(index>1&&$('.widget-field',this).length==0){
					$(this).remove();
				}
			});
		}
	}).registerComponent({
		widgetName:'panel',
		buildHtml:function(options){
			var htmls = [];
			htmls.push(_buildPanelPrefix(options.caption));
			htmls.push('<div class="layoutDrop childDrop"></div>');
			htmls.push(_buildPanelPostfix());
			return htmls.join('');
		}
	},$.youi.pageEditor.captionWidget).registerComponent({
		widgetName:'tree',
		buildHtml:function(options){
			var treeData = $.extend({},_treeData,{
				id:'tree_root',
				text:options.caption||'根节点',
				group:'root'
			}).addChild({id:'node_1',text:'节点一'})
			  .addChild({id:'node_2',text:'节点二'});
			
			return '<div class="youi-tree"><ul>'+treeData.toHtml(true)+'</ul></div>';
		}
	}).registerComponent({
		widgetName:'buttons',
		buildHtml:function(options){
			return _buildButtonLayout();
		}
	}).registerComponent({
		widgetName:'button',
		buildHtml:function(options){
			return '<span class="widget-caption">'+(options.caption||'')+'</span>';
		}
	},$.youi.pageEditor.captionWidget).registerField({
		widgetName:'fieldText',
		caption:'文本框',
	},$.youi.pageEditor.fieldWidget).registerField({
		widgetName:'fieldArea',
		caption:'文本域',
	},$.youi.pageEditor.fieldWidget).registerField({
		widgetName:'fieldSelect',
		caption:'下拉框',
	},$.youi.pageEditor.fieldWidget).registerField({
		widgetName:'fieldCalendar',
		caption:'日历',
	},$.youi.pageEditor.fieldWidget).registerField({
		widgetName:'fieldPassword',
		caption:'密码框',
	},$.youi.pageEditor.fieldWidget).registerField({
		widgetName:'fieldCheckboxGroup',
		caption:'复选框',
	},$.youi.pageEditor.fieldWidget).registerField({
		widgetName:'fieldRadioGroup',
		caption:'单选框',
	},$.youi.pageEditor.fieldWidget).registerField({
		widgetName:'fieldTree',
		caption:'表单树',
	},$.youi.pageEditor.fieldWidget);
	
	
	function _buildButtonLayout(buttons){
		var htmls = [];
		htmls.push('<table><tr>');
		if($.isArray(buttons)){
			for(var i=0;i<buttons.length;i++){
				htmls.push('<td width="60px" title="此处可以放置按钮" class="buttonDrop childDrop">');
				htmls.push('<div id="'+buttons[i].id+'" class="widget-button widget-component component-button youi-corner-all" >');
				htmls.push('<span class="widget-caption">'+(buttons[i].caption||'')+'</span>');
				htmls.push('</div>');
				htmls.push('</td>');
			}
		}
		htmls.push('<td width="60px" title="此处可以放置按钮" class="buttonDrop childDrop"></td>');
		
		htmls.push('<tr></table>');
		return htmls.join('');
	}
	
	function _buildFormLayout(columns,fields,prefix){
		var rows = ($.isArray(fields)?fields.length/2:1)+1,
			cols = columns*2,
			prefix = prefix||'field';
		
		var cellWidth = Math.floor(10000/cols)/100;
		var htmls = ['<table width="100%" cellpading="0" cellspacing="0">'];
		var field;
		for(var row=0;row<rows;row++){
			htmls.push('<tr>');
			for(var col=0;col<cols;col++){
				//var fieldIndex = 
				//<div id="fieldText0" class="widget-field fieldText selected">fieldText0</div>
				//<td class="fieldLabel" width="25%">文本框0</td>
				if(fields){
					field = fields[Math.floor(row*columns+col/2)];
				}
				if(col%2==1){//填充区
					htmls.push('<td width="'+cellWidth+'%" title="此处可以放置表单组件" class="fieldDrop childDrop">')
					if(field)htmls.push('<div id="'+(prefix+'_'+field.property)+'" class="widget-field fieldText">'+field.property+'</div>');
					htmls.push('</td>')
				}else{
					htmls.push('<td width="'+cellWidth+'%" class="fieldLabel">');
					if(field)htmls.push(field.caption);
					htmls.push('</td>')
				}
				field = null;
			}
			htmls.push('</tr>');
		}
		htmls.push('</table>');
		return htmls.join('');
	}
	
	function _exchangeRowAndColspan(cell1,cell2){
		var rowspan = cell1.attr('rowspan');
		var colspan = cell1.attr('colspan');
		
		cell1.attr('rowspan',cell2.attr('rowspan'));
		cell1.attr('colspan',cell2.attr('colspan'));
		
		cell2.attr('rowspan',rowspan);
		cell2.attr('colspan',colspan);
	}
	/**
	 * panel 包装元素-之前
	 */
	function _buildPanelPrefix(title){
		var htmls = [];
		htmls.push("<div class=\"youi-panel\">");
		htmls.push(	"<div class=\"panel-header\">");
		htmls.push(	"	<div class=\"widget-caption\">"+(title||"")+"</div>");
		htmls.push(	"</div>");
		htmls.push(	"<div class=\"panel-content\">");
		return htmls.join('');
	}
	/**
	 * panel 包装元素-之后
	 */
	function _buildPanelPostfix(){
		return '</div></div>';
	}
	
	function _buildInnerFieldLayout(options){
		var htmls = [];
		//添加fieldLayout
		var fieldLayoutId = 'fieldLayout_'+options.widgetId;
		htmls.push('<div title="此处可以放置fieldLayout组件" class="youi-fieldLayout fieldLayoutDrop childDrop">'),
		htmls.push('<div title="'+fieldLayoutId+'" id="'+fieldLayoutId+'" class="widget-item widget-component component-fieldLayout">');
		htmls.push(_buildFormLayout(2,options.fields,options.prefix));
		htmls.push('</div></div>');
		return htmls.join('');
	}
	
	 /**
	 * 根据 行列定位计算覆盖的区域（合并单元格区域扩展）
	 */
	function _getTableCoverArea(table,area){
		var td;
		var coverArea = $.extend({},area);
		//_log.info('查找区域：rowFrom '+area.rowFrom+',rowTo'+area.rowTo+',colFrom '+area.colFrom+'colTo '+area.colTo);
		//遍历起始行和结束行
		for(var col=area.colFrom;col<=area.colTo;col++){
			//起始行如果有隐藏的单元格则往上查找
			td = table.rows[area.rowFrom].cells[col];
			if(td.style.display=='none'){
				var prevTd = td;
				var prevIndex = area.rowFrom;
				while(prevTd.style.display=='none'&&prevIndex>0){
					prevTd = table.rows[--prevIndex].cells[col];
				}
				var rowspan = $(prevTd).attr('rowspan');
				//_log.info('找到合并的单元格:'+prevTd.style.display+' - '+rowspan+' '+$(prevTd).text());
				//找到rowspan大于1的单元格，并且td在该合并区域内
				if(rowspan>1&&prevIndex+rowspan>area.rowFrom){
					coverArea.rowFrom = Math.min(coverArea.rowFrom,prevIndex);
				}
			}
			//结束行如果有隐藏的单元格则往下查找
			td = table.rows[area.rowTo].cells[col];
			var rowspan = $(td).attr('rowspan');
			if(rowspan&&rowspan>1){
				coverArea.rowTo = area.rowTo+rowspan-1;
			}else if(td.style.display=='none'){
				var prevTd = td;
				var prevIndex = area.rowTo;
				while(prevTd.style.display=='none'&&prevIndex>0){
					prevTd = table.rows[--prevIndex].cells[col];
				}
				var rowspan = $(prevTd).attr('rowspan');
				//_log.info('find 下 merge cell [row '+prevIndex+']:'+rowspan+'-'+$(prevTd).text());
				//找到rowspan大于1的单元格，并且td在该合并区域内
				if(rowspan>1&prevIndex+rowspan>area.rowTo){
					coverArea.rowTo = Math.max(coverArea.rowTo,prevIndex+rowspan-1);
				}
			}
			td = null;
		}
		//遍历起始列和结束列
		for(var row=area.rowFrom;row<=area.rowTo;row++){
			td = table.rows[row].cells[area.colFrom];
			if(td.style.display=='none'){
				var prevTd = td;
				var prevIndex = area.colFrom;
				while(prevTd.style.display=='none'&&prevIndex>0){
					prevTd = table.rows[row].cells[--prevIndex];
				}
				var colspan = $(prevTd).attr('colspan');
				if(colspan>1&&prevIndex+colspan>area.colFrom){
					coverArea.colFrom = Math.min(coverArea.colFrom,prevIndex);
				}
			}
			
			td = table.rows[row].cells[area.colTo];
			var colspan = $(td).attr('colspan');
			if(colspan&&colspan>1){
				coverArea.colTo = area.colTo+colspan-1;
			}else if(td.style.display=='none'){
				var prevTd = td;
				var prevIndex = area.colTo;
				while(prevTd.style.display=='none'&&prevIndex>0){
					prevTd = table.rows[row].cells[--prevIndex];
				}
				var colspan = $(prevTd).attr('colspan');
				if(colspan>1&&prevIndex+colspan>area.colTo){
					coverArea.colTo = Math.max(coverArea.colTo,$(prevTd).prevAll().length+colspan-1);
				}
			}
			td = null;
		}
		
		if(area.rowFrom==coverArea.rowFrom&&
			area.rowTo==coverArea.rowTo&&
			area.colFrom==coverArea.colFrom&&
			area.colTo==coverArea.colTo){
			return area;
		}else{
			return _getTableCoverArea(table,coverArea);
		}
	}
})(jQuery);