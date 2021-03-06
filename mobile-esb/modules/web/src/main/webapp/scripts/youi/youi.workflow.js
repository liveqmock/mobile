 /*
 * TODO
 *  <p>初始化的辅助html的生成</p>
 *  <p>初始化节点和transition的html生成</p>
 *	<p>事件监听</p>
 *  <p>transition上的point的移动过程显示</p>
 *  <p>transition的click状态显示</p>
 *  <p>增加node的resizable</p>
 */
(function($) {
	/**
	 * 工作流图形组件
	 * @author zhouyi
	 * @version 1.0.0
	 * @requires
	 * 
	 * 工作流节点
	 * 1：startEvent
	 * 2：userTask
	 * 3:
	 */

	//panel-button的隐藏规则
	var hideRules = {
		'startEvent':['newEndEvent'],
		'exclusiveGateway':['formDesign'],
		'endEvent':['newEndEvent','formDesign','newGateway','newUserTask','newConnection']
	};
	
	$.widget("youi.workflow", $.ui.mouse,$.extend({},{
		options:{
			width:800,
			height:420,
			distance: 1,
			delay:0,
			appendTo:'parent'
		},
		
		GUID:0,
		/**
		 * widget 组件初始化方法
		 */
		_create:function(){
			var width = this.element.parent().width()||this.options.width;
			this.options.height = this.element.parent().height()||this.options.height;
			
			this.element.addClass('youi-workflow').css({
				width:width,
				height:this.options.height
			});
			
			this.element.disableSelection().selectable({//初始化多选
				cancel:'.point,.node,.center-point,.transitionName,.select-dragging,.panel-button',
				filter:'.point,.node',
				//appendTo:this.element,
				//tolerance:'fit',
				delay:100,
				start:function(event,ui){
					$('.select-dragging',this).hide();
				},
				stop:function(event,ui){
					$('.select-dragging',this).css({
						left:$('.ui-selectable-helper').offset().left+this.scrollLeft-$(this).offset().left,
						top:$('.ui-selectable-helper').offset().top+this.scrollTop-$(this).offset().top,
						width:$('.ui-selectable-helper').width(),
						height:$('.ui-selectable-helper').innerHeight()
					}).show();
				}
			});
			
			this.GUID = this.element.find('.node').length;
			this._initCanvaContext();//绘画面板支持
			
			if(this.options.processKey){
				this.loadByProcessKey(this.options.processKey);//
			}else{
				this._refreshTransitions();
			}
			
			this._mouseInit();//初始鼠标支持
			this._initAction();
			
		},
		/**
		 * 
		 */
		resize:function(){
			var parent = this.element.parent();
			var width = parent.width();
			this.element.find('>.bg,canvas').andSelf().width(width);
			
			this._refreshTransitions();
		},
		
		/**
		 * 根据流程主键加载流程
		 */
		loadByProcessKey:function(processkey){
			var self = this;
			if(processkey&&this.options.loadSrc){
				//从后台读取流程信息
				$.youi.ajaxUtil.ajax({
					url:this.options.loadSrc,
					data:'flowId='+processkey,
					success:function(results){
						self._doLoad(results.record,processkey);
					}
				});
			}
		},
		
		_doLoad:function(record,flowId){
			this.element.prepend(record.html);
			this._refreshTransitions();
			this._elementChange();
			
			this.element.find('.process-info:first').attr('id',flowId);
			
			var treeHtml = this._elementTreeHtml();
			if($.isFunction(this.options.afterLoad)){
				this.options.afterLoad.apply(this.element[0],[treeHtml]);
			}
		},
		/**
		 * 监听节点变化
		 */
		_elementChange:function(){
			//;
		},
		/**
		 * 刷新界面
		 */
		refresh:function(){
			this._refreshTransitions();
		},
		/**
		 * 
		 */
		_initAction:function(){
			var self = this;
			var _widgetName = this.widgetName;
			this.element.bind('click',function(event){
				var clickElement = $(event.srcElement||event.target);
				
				if(clickElement.attr('id')=='canvas_helper'){
					$('.select-dragging',this).hide();//
					$('.ui-selected',this).removeClass('ui-selected');
					
					//
					//clickElement.offset();
					var x = event.pageX + clickElement[0].scrollLeft-clickElement.offset().left;
					var y = event.pageY + clickElement[0].scrollTop-clickElement.offset().top;
					//寻找线条
					$('>.transition',this).each(function(){
						//var linePos;
						var inline = false;
						var waypoints = self._getWaypoints(this);
						
						for(var i=0;i<waypoints.length-1;i++){
							inline = false;//初始化为false
							var startPos =waypoints[i];
							var endPos = waypoints[i+1];
							
							inline = self._inPosLine(startPos,endPos,{left:x,top:y});
							//找到满足条件的线条则退出
							if(inline==true){
								break;
							}
						}
						
						if(inline){//如果找到线条，设置线条选择并退出循环
							self._selected($(this),event);
							return false;
						}
					});
				}else if(clickElement.is('.point')){
					clickElement = clickElement.parent();//处理point的选中
				}
				
				self._selected(clickElement,event);
			}).bind('mousedown',function(event){
				if(event.button==2||(!$.support.boxModel&&event.button===0)){//第二种情况为maxthon
					var downElement = $(event.srcElement||event.target);
					var type,nodeType,id;
					if(downElement.is('.node')){
						type = 'node';
						id = downElement.attr('id');
						nodeType = downElement[0].className.split(' ')[1];
					}else if(downElement.is('.point')){
						type = 'transition';
						id = downElement.parent().attr('id');
					}else{
						type = 'workflow';
					}
					self._popMenuSupport(event,{id:id,type:type,nodeType:nodeType});
				}else{
					if(self.options.popMenu)$(self.options.popMenu).menu('close');
				}
			}).bind('dblclick',function(){
				
			});
			//
			this.element.delegate('.node','mouseenter',function(event){
				$(this).addClass('node-over');
				$.youi.getWidget(event.delegateTarget,_widgetName)._showNodePanel($(this));
				//$.data(event.liveFired,'workflow')._showNodePanel($(this));
			}).delegate('.node','mouseout',function(event){
				$(this).removeClass('node-over');
			}).delegate('canvas','mouseenter',function(event){
				$('.node-over-panel',event.liveFired).hide();
			});
			//
			this.element.delegate('.panel-button','click',function(event){
				var nodeOverPanel = $(this).parents('.node-over-panel:first');
				var refNodeId = nodeOverPanel.attr('refNode');
				if(refNodeId){
					$.youi.getWidget(event.delegateTarget,_widgetName)['btn_'+this.getAttribute('id')](refNodeId);
					//$.data(event.liveFired,'workflow')['btn_'+this.getAttribute('id')](refNodeId);
				}
				
				nodeOverPanel.hide();
			});
			
			
			$('body',document).bind('body.resize',{ui:this.element},function(event){
				try{
					event.data.ui.workflow('resize');
				}catch(err){
					
				}
			});
		},
		/***********************************元素浮动按钮**********************************/
		
		btn_newConnection:function(){
		},
		/**
		 * 浮动按钮：删除节点
		 */
		btn_delete:function(refNodeId){
			if(window.confirm('确认删除?')){
				this.removeNode(refNodeId);
			}
		},
		
		/**
		 * 浮动按钮：增加UserTask节点
		 */
		btn_newUserTask:function(refNodeId){
			this._btn_newNode(refNodeId,'userTask');
		},
		
		/**
		 * 浮动按钮：增加UserTask节点
		 */
		btn_newGateway:function(refNodeId){
			this._btn_newNode(refNodeId,'exclusiveGateway');
		},
		
		/**
		 * 浮动按钮：增加UserTask节点
		 */
		btn_newEndEvent:function(refNodeId){
			this._btn_newNode(refNodeId,'endEvent');
		},
		
		/**
		 * 浮动按钮：表单设计
		 */
		btn_formDesign:function(refNodeId){
			var flowId = this.element.find('.process-info:first').attr('id');
			var record = this.getProcessProperties();
			var node = this.getNode(refNodeId);
			record.flowId = flowId;
			record.taskId = refNodeId;
			var formKey = getDataProperty(node,'formKey');
			if(formKey){
				record.formKey = formKey;
				record.formType =  getDataProperty(node,'nodeName');
				
				$.youi.pageUtils.goPage('/page/workflow.flow/formDesigner.html',record);
			}
		},
		
		
		/**
		 * 私有函数，根据当前节点增加新节点
		 */
		_btn_newNode:function(refNodeId,nodeType){
			var refNode = this.element.find('.node#'+refNodeId);
			//
			var newNodeId = this._genNodeId(nodeType);
			this.addNode(newNodeId,'',nodeType, {
				left:refNode[0].offsetLeft+100+refNode.width()/2,
				top:refNode[0].offsetTop,
				width:refNode.width(),
				height:refNode.height()
			});
			
			this.addTransition(refNodeId, newNodeId);
		},
		
		_genNodeId:function(nodeType){
			nodeType = nodeType||'userTask';
			var nodeId = nodeType+'_node'+(++this.GUID);
			
			if(this.element.find('#'+nodeId).length){
				this.GUID+=9;//增加9位
				return this._genNodeId(nodeType);
			}
			
			return nodeId;
		},
		/***********************************元素浮动按钮**********************************/
		/**
		 * 
		 */
		_showNodePanel:function(nodeElement){
			
			var left = nodeElement[0].offsetLeft+nodeElement.width();
			var top  = nodeElement[0].offsetTop - 25;
			var height = nodeElement.height();
			
			var nodeOverPanel = this.element.find('.node-over-panel');
			
			nodeOverPanel.find('>.panel-center').height(nodeElement.height()+5);
			//center
			//20
//			var centerCount = Math.floor((height+10)/20);
//			var centerCurrentVCount = nodeOverPanel.find('>.panel-center .panel-button').not('hide').length;
//			
//			if(centerCount<centerCurrentVCount){
//				//多余的往bottom里面移动
//				
//			}if(centerCount>centerCurrentVCount){
//				//从bottom里面补充到center
//			}
			
			nodeOverPanel.find('.panel-button').each(function(){
				var btnElement = $(this).removeClass('hide');
				var btnId = btnElement.attr('id');
				for(var nodeType in hideRules){
					if(nodeElement.hasClass(nodeType)){
						if($.inArray(btnId,hideRules[nodeType])!=-1){
							btnElement.addClass('hide');
							break;
						}
					}
				}
				btnElement = null;
			});
			
			nodeOverPanel.show();
			
			nodeOverPanel.attr('refNode',nodeElement.attr('id')).css({
				left:left-(nodeOverPanel.width()-25),
				top:top
			});
		},
		
		_selected:function(clickElement,event){
			if(clickElement[0]!=$('.click',this.element)[0]){
				var type;
				if(clickElement.hasClass('node')){
					type = 'node';
					if(event&&event.shiftKey===true){
						//画线
						var fromId = $('.click',this.element).attr('id'),
							toId   = clickElement.attr('id'),
							id = this._addTransition(fromId,toId,true,event);
						if($.isFunction(this.options.addTransitionCommand)){
							this.options.addTransitionCommand.apply(this.element[0],[event,{
								fromId:fromId,
								toId:toId,
								id:id
							}]);
						}
					}
					$('.click',this.element).removeClass('click');
					clickElement.addClass('click');
					//清理辅助画图面板
					this._clearCanvasHelper();
				}else if(clickElement.hasClass('transition')){
					type = 'transition';
					$('.click',this.element).removeClass('click');
					clickElement.addClass('click');
					//画click状态的transition
					this._refreshClickTransition();
				}
				//
				if(type){
					//this._propertiesSupport(event,{type:type,selectorPath:['#'+clickElement.attr('id')]});
					if(event){
						this._trigger('select', event, {
							element:clickElement,
							model:parseModel(clickElement)
						});
					}
//					if(event&&$.isFunction(this.options.select)){
//						this.options.select.apply(clickElement[0],[event]);
//					}
				}
			}
		},
		
		selected:function(id,event){
			var element = this.element.find('#'+id);
			this._selected(element,event);
		},
		
		_propertiesSupport:function(event,data){
			if(data&&data.type){
				var selectorPath = ['.youi-workflow#'+this.element.attr('id')].concat(data.selectorPath),
					pElement = this.element.find(data.selectorPath.join(' ')),
					propertyValue = this._getPropertyValue(pElement,data);
				//闭包函数,供属性编辑器中的属性值修改后调用
				function propertyChange(selectorPath){
					return function(property,value){
						//var propertyElement = $(selectorPath.join(' '));
						//调用属性修改的函数
						$(selectorPath[0]).workflow('setProperty',selectorPath.slice(1),property,value,event);
					};
				}
				var editorChange = propertyChange(selectorPath);
				if(this.options.propertyTable){//调用属性编辑器的熟悉填充函数
					$(this.options.propertyTable).propertyTable('fillProperties',propertyValue,editorChange);
				}
			}
		},
		
		_getPropertyValue:function(pElement,data){
			var propertyValue =  {
				id:pElement.attr('id'),
				name:pElement.attr('name')||pElement.attr('id'),
				left:pElement.css('left'),
				top:pElement.css('top')
			};
			
			switch(data.type){
				case 'node':
					var nodeType = pElement[0].className.split(' ')[1];
					$.extend(propertyValue,{
						nodeType:nodeType,
						text:pElement.text()
					});
					break;
				case 'transition':
					$.extend(propertyValue,{
						text:pElement.attr('title')
					});
					break;
				default :
			}
			return propertyValue;
		},
		//属性变化
		setProperty:function(selectorPath,property,value,event){
			var propertyElement  = this.element.find(selectorPath.join(' ')),
				oldValue;
				
			switch(property){
				case 'name':
					oldValue = propertyElement.attr('name')||propertyElement.attr('id');
					propertyElement.attr('name',value);
					break;
				case 'text':
					if(propertyElement.hasClass('transition')){
						oldValue = propertyElement.attr('title');
						propertyElement.attr('title',value);
					}else{
						oldValue = propertyElement.text();
						propertyElement.text(value);
					}
					break;
				case 'left':
					oldValue = propertyElement.css('left');
					propertyElement.css('left',value);
					this._refreshTransitions();
					break;
				case 'top':
					oldValue = propertyElement.css('top');
					propertyElement.css('top',value);
					this._refreshTransitions();
					break;
				default:
					
			}
			if(event&&$.isFunction(this.options.propertyChangeCommand)){
				this.options.propertyChangeCommand.apply(this.element[0],[event,{
					selectorPath:selectorPath,
					oldValue:oldValue,
					property:property,
					value:value
				}]);
			}else{
				//设置
				if(this.options.propertyTable){//调用属性编辑器的熟悉填充函数
					$(this.options.propertyTable).propertyTable('setProperty',property,value);
				}
			}
		},
		
		_popMenuSupport:function(event,data){
			if(this.options.popMenu){
				$(this.options.popMenu).menu('show',event.pageX,event.pageY+5,data);
			}
		},
		
		/**
		 * 初始化canva上下文
		 * this.canvaContext 主上下文
		 */
		_initCanvaContext:function(){
			var main = document.createElement('canvas');
			var trace = document.createElement('canvas');
			var helper = document.createElement('canvas');
			
			main.setAttribute('id','canvas_main');
			trace.setAttribute('id','canvas_trace');
			helper.setAttribute('id','canvas_helper');
			
			this.element.append(main).append(trace).append(helper);
			
			if(!$.support.boxModel){
				G_vmlCanvasManager.initElement(main);
				G_vmlCanvasManager.initElement(trace);
				G_vmlCanvasManager.initElement(helper);
			}
			
			this.canvasContext = main.getContext('2d');
			this.canvasContextTrace = trace.getContext('2d');
			this.canvasContextHelper = helper.getContext('2d');
			main = null;
			helper = null;
			trace = null;
		},
		/**
		 * 设置canvas的区域
		 */
		_calCanvasRect:function(){
			var domEl = this.element[0];
			var canvasRect = {
				width:domEl.scrollWidth,
				height:domEl.scrollHeight
			};
			if($.support.boxModel){
				//显示指定canvas的高和宽的属性，防止canvas缩放
				this.element.find('canvas').attr('width',canvasRect.width).attr('height',canvasRect.height);
			}
			this.element.find('canvas,.bg').css(canvasRect);
			return canvasRect;
		},
		/**
		 * 生成节点和线条的树结构
		 */
		_elementTreeHtml:function(){
			var htmls = [];
			htmls.push('<li id="node_list" class="treeNode expandable">');
			htmls.push('<div class="tree-trigger"></div>');
			htmls.push('<span class="tree-span expandable" title="流程节点">');
			htmls.push('<a class="tree-a" href="#">流程节点</a></span>');
			htmls.push('<ul>');
			this.element.find('>.node').each(function(){
				var properties = getDataProperties($(this));
				htmls.push($.youi.tree.treeNodeHtml(properties.id,properties.name||properties.id,null,{group:'node '+properties.nodeName}));
			});
			htmls.push('</ul>');
			htmls.push('</li>');
			
			htmls.push('<li id="flow_list" class="treeNode expandable last lastExandable">');
			htmls.push('<div class="tree-trigger"></div>');
			htmls.push('<span class="tree-span expandable" title="流程连线">');
			htmls.push('<a class="tree-a" href="#">流程连线</a></span>');
			htmls.push('<ul>');
			this.element.find('>.transition').each(function(){
				var properties = getDataProperties($(this));
				var id = this.getAttribute('id');
				htmls.push($.youi.tree.treeNodeHtml(id,properties.name||id,null,{group:'transition'}));
			});
			htmls.push('</ul>');
			htmls.push('</li>');
			return htmls.join('');
		},
		/**
		 * 刷新流线条
		 */
		_refreshTransitions:function(){
			var self = this,
				canvasRect = this._calCanvasRect();
			this.canvasContext.clearRect(0,0,canvasRect.width,canvasRect.height);
			var transitionsArgs = [];
			this.element.find('.transition').each(function(){
				transitionsArgs.push(self._getTransitionArgs(this));
			});
			
			drawCanvaTransitions(this.canvasContext,transitionsArgs);
			this._refreshClickTransition();
		},
		/**
		 * 刷新点选的线条
		 */
		_refreshClickTransition:function(){
			var transElement = this.element.find('.transition.click');
			if(transElement.length===0){return;}
			this._clearCanvasHelper();
			drawCanvaTransitions(this.canvasContextHelper,[this._getTransitionArgs(transElement)],'red');
			
			//显示拐点的中间节点
			var waypoints = this._getWaypoints(transElement);
			//
			transElement.find('>.center-point').remove();
			var centerPointHtmls = [];
			for(var i=0;i<waypoints.length-1;i++){
				//
				var centerLeft = (waypoints[i].left+waypoints[i+1].left)/2-2;
				var centerTop = (waypoints[i].top+waypoints[i+1].top)/2-2;
				
				centerPointHtmls.push('<div class="center-point" style="left:'+centerLeft+'px;top:'+centerTop+'px;"></div>');
			}
			transElement.append(centerPointHtmls.join(''));
		},
		/**
		 * 获取线条变量
		 */
		_getTransitionArgs:function(transElement){
			if(!transElement)return null;
			transElement = $(transElement);
			
			var	id	  = transElement.attr('id'),
				fromId= transElement.data('properties').sourceRef,
				toId  = transElement.data('properties').targetRef,
				from  = $('#'+fromId,this.element),
				to 	  = $('#'+toId,this.element),
				g     = [];//拐点
			$('.point',transElement).each(function(){
				g.push({
					left:this.offsetLeft+2,
					top :this.offsetTop+2
				});
			});
			
			return {
				id:id,
				text:id,
				fromId:fromId,
				toId:toId,
				startPos:getRectCenterPos(calculatePos(from),from.width(),from.outerHeight()),
				endPos:getRectCenterPos(calculatePos(to),to.width(),to.outerHeight()),
				endRect:{width:to.width(),height:to.outerHeight()},
				g:g
			}
		},
		
		/**
		 * 获取拐点集合
		 */
		_getWaypoints:function(transElement){
			var tranArgs = this._getTransitionArgs(transElement);
			var waypoints = [];
			waypoints.push(tranArgs.startPos);
			waypoints = waypoints.concat(tranArgs.g);
			waypoints.push(tranArgs.endPos);
			
			return waypoints;
		},
		/**
		 * 显示拐点拖动的规矩
		 */
		_traceTransition:function(pointDom,pointPos){
			//TODO
		},
		/**
		 * 
		 */
		_clearCanvasHelper:function(){
			this.canvasContextHelper.clearRect(0,0,$('.bg',this.element).width(),$('.bg',this.element).innerHeight());
		},
		
		_clearCanvasTrace:function(){
			this.canvasContextTrace.clearRect(0,0,$('.bg',this.element).width(),$('.bg',this.element).innerHeight());
		},
		
		/*******************开始节点拖动处理***********************************/
		_mouseStart: function(event) {
			var dragElement = $(event.target);
			$('.select-dragging',this).hide();//
			
			if(dragElement.length){
				if(event.ctrlKey){
					$.youi.log.info(event.ctrlKey);
				}else if(event.shiftKey){
					
				}else{
					this.currentDrag = dragElement;
					this.helper = this._createHelper(event,dragElement);
					this.originalPageX = event.pageX;
					this.originalPageY = event.pageY;
					if(dragElement.is('.ui-selected')){
						this.offsetDragX = event.pageX-this.helper.offset().left;
						this.offsetDragY = event.pageY-this.helper.offset().top;
					}else if(dragElement.is('.newConnection')){
						var refNode = this.element.find('.node#'+dragElement.parents('.node-over-panel:first').attr('refNode'));
						if(refNode.length){
							var startPos = {
								left:refNode[0].offsetLeft,
								top:refNode[0].offsetTop
							};
							this.startNode = refNode.attr('id');
							this.startPos = getRectCenterPos(startPos,refNode.width(),refNode.height());
						}
						this.offsetDragX = event.pageX-dragElement.offset().left;
						this.offsetDragY = event.pageY-dragElement.offset().top;
					}else{
						this.offsetDragX = event.pageX-dragElement.offset().left;
						this.offsetDragY = event.pageY-dragElement.offset().top;
					}
					
					this.originalPosition = this._generatePosition(event);
				}
			}
			return true;
		},
		
		_mouseDrag: function(event) {
			if(this.helper){
				this.position = this._generatePosition(event);
				this.helper.css(this.position);
				if(this.currentDrag.hasClass('point')){
					this._traceTransition(this.currentDrag[0],this.position);
				}else if(this.currentDrag.hasClass('newConnection')&&this.startPos){
					this._clearCanvasTrace();
					drawCanvaTransitions(this.canvasContextTrace,[{
						startPos:this.startPos,
						endPos:this.position,
						endRect:{width:2,height:2}
					}]);
				}
			}
			return false;
		},
		
		_mouseStop: function(event) {
			if(this.helper){
				this.helper.empty().hide();//
				var selectorPath = [];
				if(this.helper.is('.select-dragging')){
					selectorPath.push('.ui-selected');
				}else if(this.currentDrag.hasClass('node')){
					selectorPath.push('#'+this.currentDrag.attr('id'));
				}else if(this.currentDrag.hasClass('point')){
					var ponitId = this.currentDrag.attr('id');
					if(!ponitId){
						ponitId = this.currentDrag.parent().attr('id')+'_g'+this.currentDrag.prevAll().length;
						this.currentDrag.attr('id',ponitId);
					}
					//判断当前point在上一个节点和下一个节点的连线上
					if(this._inBetweenLine(this.currentDrag,this.position)){
						//删除当前节点
						this.currentDrag.remove();
					}
					selectorPath.push('#'+ponitId);
				}else if(this.currentDrag.hasClass('center-point')){
					//移动拐点的中间节点
					this._centerPoint2Point(this.currentDrag,this.position);
				}else if(this.currentDrag.is('.newConnection')){
					this._clearCanvasTrace();
					//
					if($(event.target).is('.node')){
						this.addTransition(this.startNode, $(event.target).attr('id'));
					}
					
					this.startNode = null;
					this.startPos = null;
				}
				
				this._move(selectorPath,this.position,this.originalPosition,event);
				if($.isFunction(this.options.moveCommand)){
					this.options.moveCommand.apply(this.element[0],[event,{
						selectorPath:selectorPath,
						position:this.position,
						originalPosition:this.originalPosition
					}]);
				}
				selectorPath = null;
				this.helper = null;
				this.position = null;
				this.currentDrag = null;
				
				this.offsetDragX = null;
				this.offsetDragY = null;
				this.originalPageX = null;
				this.originalPageY = null;
				this.originalPosition = null;
			}
			return false;
		},
		/**
		 * 判断当前拐点是否在上一个拐点和下一个拐点的连线上
		 */
		_inBetweenLine:function(pointElem,pos){
			var transElement = pointElem.parent();
			//
			var waypoints = this._getWaypoints(transElement);
			var index = pointElem.prevAll().length;
			
			var prevPos = waypoints[index];
			var nextPos = waypoints[index+2];
			
			return this._inPosLine(prevPos,nextPos,pos);
		},
		/**
		 * 
		 */
		_inPosLine:function(startPos,endPos,pos){
			var inline = false;
			var x = pos.left,y=pos.top;
			//在当前区域范围内
			if(x>=Math.min(startPos.left,endPos.left)-2&&x<=Math.max(startPos.left,endPos.left+2)
				&&y>=Math.min(startPos.top,endPos.top)-2&&y<=Math.max(startPos.top,endPos.top)+2){
				
				if(Math.abs(startPos.left-x)<2&&Math.abs(endPos.left-x)<2){
					//垂直线条
					inline = true;
				}else if(Math.abs(startPos.top-y)<2&&Math.abs(endPos.top-y)<2){
					//水平线条
					inline = true;
				}else{
					//其他线条，根据正切偏移来判断
					var tag = Math.abs(endPos.top-startPos.top)/Math.abs(endPos.left-startPos.left);
					var clickTag = Math.abs(endPos.top-y)/Math.abs(endPos.left-x);
					if(Math.abs(tag-clickTag)<0.1){//正切偏移量小于0.1
						inline = true;
					}
				}
			}
			return inline;
		},
		
		_mouseCapture: function(event) { 
			return true; 
		},
		/**
		 *
		 */
		_move:function(selectorPath,position,originalPosition,event){
			if(selectorPath.length<1)return;
			if(selectorPath=='.ui-selected'||selectorPath[1]=='.ui-selected'){
				var moveX = position.left-originalPosition.left,
					moveY = position.top-originalPosition.top;
				this.element.find(selectorPath[0]).each(function(){
					$(this).css({
						left: this.offsetLeft+moveX,
						top	: this.offsetTop+moveY
					});
				});
			}else{
				this.element.find(selectorPath.join(' ')).css(position);
			}
			this._refreshTransitions();
		},
		
		move:function(selectorPath,position,originalPosition){
			this._move(selectorPath,position,originalPosition);
		},
		/**
		 * 拐点的中间节点变化为新的拐点
		 */
		_centerPoint2Point:function(centerPointElem,pos){
			//
			var index = centerPointElem.prevAll('.center-point').length;
			var transElme = centerPointElem.parent();
			//
			
			var html = '<div class="point" style="left:'+(pos.left-2)+'px;top:'+(pos.top-2)+'px;"></div>';
			if(index==0){
				transElme.prepend(html);
			}else{
				var relativePointElem = transElme.find('.point:eq('+(index-1)+')');
				relativePointElem.after($(html));
			}
			
			this._refreshTransitions();
			//transElme.removeClass('click');
		},
		
		_generatePosition:function(event){
			return this._dealwithOutPos({
				left:event.pageX-this.offsetDragX,
				top:event.pageY-this.offsetDragY
			});
		},
		
		_dealwithOutPos:function(pos){
			return {
				left:pos.left-this.element.offset().left+this.element.scrollLeft(),
				top :pos.top-this.element.offset().top+this.element.scrollTop()
			};
		},
		
		_createHelper:function(event,dragElement){
			var helper;
			if(dragElement.is('.node')){
				if(dragElement.is('.ui-selected')){
					helper = this.element.find('>.select-dragging');
					helper.show();
				}else{
					helper = this.element.find('>.node-dragging').css({width:dragElement.width(),height:dragElement.outerHeight()}).show();
				}
			}else if(dragElement.is('.point')||dragElement.is('.center-point')){
				helper = this.element.find('>.point-dragging').show();
			}else if(dragElement.is('.newConnection')){
				helper = this.element.find('>.point-dragging').show();
			}
			return helper;
		},
		/*******************结束节点拖动处理***********************************/
		/**
		 *
		 */
		addNode:function(id,text,type,pos){
			var result = this._addNode(id, text, type, pos);
			this._trigger('editorChangeListener',null,{addNode:result});
			return result;
		},
		
		_addNode:function(id,text,type,pos){
			type = (type)?type:'userTask';
			//只能有一个start
			if((type=='startEvent')&&this.element.find('.node.'+type).length>0){
				return false;
			}
			if(!id){
				id = this._genNodeId(type);
			}
			if(!text){
				text =id;
			}
			pos = $.extend({
				left:20,
				top:100
			},pos);
			//nodeName
			var html = '<div data-properties=\'{"nodeName":"'+type+'"}\' id="'+id+'" class="node '+type+'" style="left:'+pos.left+'px;top:'+pos.top+'px;">'+text+'</div>';
			this.element.append(html);
			return {id:id,text:text,type:type,pos:pos};
		},
		
		addNodeTransitions:function(nodeTransitionArgs){
			//画线元素
			var length = nodeTransitionArgs.length,
				nodeTransitionArg,
				id,
				htmls = [];
			for(var i=0;i<length;i++){
				nodeTransitionArg = nodeTransitionArgs[i];
				id = nodeTransitionArg.id;
				htmls.push('<div id="'+id+'" data-properties=\'');
				htmls.push('from="'+nodeTransitionArg.fromId+'" to="'+nodeTransitionArg.toId+'" ');
				htmls.push('{"sourceRef":"'+nodeTransitionArg.fromId+'",');
				htmls.push('"targetRef":"'+nodeTransitionArg.toId+'"}\'');
				htmls.push('" class="transition">');
				$(nodeTransitionArg.g).each(function(i){
					htmls.push('<div id="'+id+'-p'+i+'" class="point" style="left:'+(this.left-2)+'px;top:'+(this.top-2)+'px;"></div>');
				});
				htmls.push('</div>');
				id = null;
				nodeTransitionArg = null;
			}
			this.element.append(htmls.join(''));
			//画线条
			drawCanvaTransitions(this.canvasContext,nodeTransitionArgs);
			this._refreshClickTransition();
		},
		
		getNode:function(id){
			return this.element.find('.node#'+id);
		},
		
		removeNode:function(id,type){
			var result  = this._removeNode(id, type);
			this._trigger('editorChangeListener',null,{remove:result});
			return result;
		},
		
		_removeNode:function(id,type){
			if(id){
				var removeHelper = $('<div></div>');
				removeHelper.append(this.element.find('#'+id));
				//删除相关线条
				var transitionElements = this.element.find('.transition[from='+id+'],.transition[to='+id+']');
				var transitionIds = [];
				transitionElements.each(function(){
					transitionIds.push(this.getAttribute('id'));
				});
				
				removeHelper.append(transitionElements);
				//刷新线条
				this._refreshTransitions();
				
				var removedHtml = removeHelper.html();
				removeHelper.remove();
				return {id:id,transitionIds:transitionIds,type:type};
			}
		},
		
		getNodeTransitionArgs:function(nodeId){
			var self = this,
				nodeTransitionArgs = [];
			this.element.find('.transition[from='+nodeId+'],.transition[to='+nodeId+']').each(function(){
				nodeTransitionArgs.push(self._getTransitionArgs($(this)));
			});
			return nodeTransitionArgs;
		},
		
		_addTransition:function(fromId,toId,addPoint,event){
			var id 		= fromId+'-'+toId,
			    from 	= $('#'+fromId,this.element),
				to 	 	= $('#'+toId,this.element),
				htmls 	= [];
			if(from.length==1&&to.length==1&&this.element.find('.transition[from='+fromId+'][to='+toId+']').length==0){
				var fromPos = getRectCenterPos(calculatePos(from),from.width(),from.outerHeight()),
					toPos   = getRectCenterPos(calculatePos(to),to.width(),to.outerHeight()),
					centerLeft = Math.min(toPos.left,fromPos.left)+Math.abs(toPos.left-fromPos.left)/2-2,
					centerTop  = Math.min(toPos.top,fromPos.top)+Math.abs(toPos.top-fromPos.top)/2-2;
				htmls.push('<div id="'+id+'" from="'+fromId+'" to="'+toId+'" data-properties=\'{"sourceRef":"'+fromId+'","targetRef":"'+toId+'"}\' class="transition">');
				if(addPoint==true){
					var pointTop,pointLeft;
					if(Math.abs(fromPos.top-toPos.top)>20&&Math.abs(fromPos.left-toPos.left)>20){
						pointTop = toPos.top-2;
						pointLeft = fromPos.left-2;
					}else{
						pointTop = centerTop;
						pointLeft = centerLeft;
					}
					htmls.push('<div id="'+id+'-p0" class="point" style="left:'+pointLeft+'px;top:'+pointTop+'px;"></div>');
				}
				htmls.push('</div>');
				this.element.append(htmls.join(''));
				this._refreshTransitions();
				return id;
			}else{
				return false;
			}
		},
		
		addTransition:function(fromId,toId){
			var id =  this._addTransition(fromId,toId,false);
			this._trigger('editorChangeListener',null,{addTransition:{id:id,text:id,fromId:fromId,toId:toId,type:'transition'}});
			return id;
		},
		
		removeTransition:function(fromId,toId){
			var transitionElement = this.element.find('.transition[from='+fromId+'][to='+toId+']');
			this._removeTransition(transitionElement.attr('id'));
			this._trigger('editorChangeListener',null,{remove:{id:id,type:'transition'}});
		},
		
		removeTransitionById:function(id){
			this._removeTransition(id);
			this._trigger('editorChangeListener',null,{remove:{id:id,type:'transition'}});
		},
		
		_removeTransition:function(id){
			this.element.find('#'+id).remove();
			this._refreshTransitions();
		},
		
		/**
		 * 激活时调用的方法
		 */
		active:function(event){
			if(!$.support.boxModel){
				this._refreshTransitions();
			}
			var clickElement = this.element.find('.click');
			if(clickElement.length>0){
				var type = clickElement.hasClass('node')?clickElement[0].className.split(' ')[1]:'transition';
				this._propertiesSupport(event,{type:type,selectorPath:['#'+clickElement.attr('id')]});
			}
		},
		/**
		 * 
		 */
		getProcessProperties:function(){
			var precessInfoElem = this.element.find('>.process-info');
			return getDataProperties(precessInfoElem);
		},
		/**
		 * 
		 */
		setPropertyValue:function(element,property,value){
			//alert(property+'='+value);
			if('expression'==property){
				element.attr('expression',value);
			}else if('caption'==property){
				if(element.hasClass('userTask')){
					element.text(value);
				}
				element.attr('title',value);
			}else{
				//设置到dataProperties里面的属性
				setDataProperty(element,property,value);
			}
		},
		
		/*
		 * 删除选择元素
		 */
		remove:function(){
			if(window.confirm('确认删除?')){
				//先删除节点和连线
				this.element.find('.ui-selected.node,.click.node').each(function(){
					var id = this.getAttribute('id');
					$('.transition[from='+id+'],.transition[to='+id+']',this.parentNode).remove();
					$(this).remove();
				});
				//再删除独立选择的连接线
				this.element.find('.transition.click').remove();
				//刷新线条
				this._refreshTransitions();
				return {};
			}
		},
		
		/**
		 * 
		 */
		buildXml:function(){
			var xmls = [];
			xmls.push('<flow>');
			var self = this;
			var skipProps = ['id','nodeId','nodeCaption'];
			this.element.find('.node').each(function(){
				var classes = this.className.split(' ');
				var type  = classes[1]||'userTask';
				var nodeId = this.getAttribute('id');
				
				xmls.push('<node id="'+nodeId+'" ');
				xmls.push(' type="'+type+'" ');
				xmls.push(' caption="'+($(this).text()||'')+'" ');
				var datas = getDataProperties($(this));
				for(var property in datas){
					if($.inArray(property,skipProps)!=-1){
						continue;
					}
					var propertySplit = property.split(":");
					if(propertySplit.length>1){
						xmls.push(propertySplit[1]+'="'+datas[property]+'" ');
					}else{
						xmls.push(property+'="'+datas[property]+'" ');
					}
				}
				
				xmls.push(' left="'+this.offsetLeft+'" ');
				xmls.push(' top="'+this.offsetTop+'" ');
				xmls.push(' width="'+(this.offsetWidth-2)+'" ');
				xmls.push(' height="'+(this.offsetHeight-2)+'" ');
				//保存位置信息 left,top
				xmls.push('>');
				xmls.push('</node>');
			});
			
			this.element.find('.transition').each(function(){
				var thisElement = $(this);
				
				var id = this.getAttribute('id');
				xmls.push('<transition id="'+id+'" ');
				xmls.push(' from="'+this.getAttribute('from')+'" ');
				xmls.push(' to="'+this.getAttribute('to')+'" ');
				xmls.push(' name="'+(thisElement.text()||thisElement.attr('title'))+'" ');
				xmls.push(' expression="'+(thisElement.attr('expression')||getDataProperty(thisElement,'expression')||'')+'" ');
				xmls.push('>');
				//保存拐点
				$('.point',this).each(function(){
					xmls.push('<point ');
					xmls.push(' left="'+this.offsetLeft+'" ');
					xmls.push(' top="'+this.offsetTop+'" ');
					xmls.push('/>');
				});
				
				xmls.push('</transition>');
			});
			xmls.push('</flow>');
			return xmls.join('');
		},
		
		/**
		 * 垂直对齐
		 */
		valign:function(){
			var uiSelecteds = this.element.find('.node.ui-selected,.point.ui-selected');
			
			if(uiSelecteds.length>0){
				var baseValign = uiSelecteds[0].offsetLeft+uiSelecteds[0].offsetWidth/2;
			
				uiSelecteds.each(function(){
					$(this).css('left',baseValign-this.offsetWidth/2);
				});
				//刷新线条
				this._refreshTransitions();
			}
		},
		
		/**
		 * 水平对齐
		 */
		halign:function(){
			var uiSelecteds = this.element.find('.node.ui-selected,.point.ui-selected');
			
			if(uiSelecteds.length>0){
				
				var baseHalign = uiSelecteds[0].offsetTop+uiSelecteds[0].offsetHeight/2;
			
				uiSelecteds.each(function(){
					$(this).css('top',baseHalign-this.offsetHeight/2);
				});
				//刷新线条
				this._refreshTransitions();
			}
		},
		
		/**
		 * 注销
		 */
		destory:function(){
			//TODO
			this.canvasContext = null;
			this.canvasContextHelper = null;
			this.canvasContextTrace = null;
			$.widget.prototype.destory.apply(this);
		}
	}));
	
	$.extend($.youi.workflow,{
		commandsCallBack:[
			{name:'propertyChangeCommand',command:'setProperty'},
			{name:'moveCommand',command:'move'},
			{name:'addTransitionCommand',command:'addTransition'}
		],
		getter:['addNode','addTransition','getNodeTransitionArgs','getCommandCallbacks','getCommands','getUndoCommands']
	});
	//计算定位
	function calculatePos(element){
		if(!element.length)return;
		var offsetParent = element.offsetParent(),
			pos = element.offset();
		//alert(offsetParent.attr('id'));
		return {
			left:pos.left-offsetParent.offset().left+offsetParent.scrollLeft(),
			top :pos.top-offsetParent.offset().top+offsetParent.scrollTop()
		};
	}
	//获得区域的中心位置
	function getRectCenterPos(pos,width,height){
		return {
			left:pos.left+width/2,
			top :pos.top+height/2
		};
	}
	//画流程线集合
	function drawCanvaTransitions(context,transitionsArgs,color){
		//$.youi.time.start();
		context.beginPath();
		if(color)context.strokeStyle = color;
		$(transitionsArgs).each(function(){
			_drawCanvaTransition(context,this.startPos,this.endPos,this.endRect,this.g);
		});
		context.stroke();
		//$.youi.time.end('画线');
	}
	/**
	 * 画直线 
	 */
	//TODO 带拐角
	function _drawStraightLine(context,startPos,endPos,hasBeginRect,hasEndRect){
		
		//起始拐角
		//context.arc(startPos.left+5,startPos.top+5,5,0,Math.PI*2,true);
		
		context.moveTo(startPos.left,startPos.top);
		//(定义一个中心点，半径，起始角度，结束角度，和绘图方向：顺时针或逆时针);
		context.lineTo(endPos.left,endPos.top);
		//结束拐角
		//context.arc(startPos.left+5,startPos.top+5,5,0,Math.PI*2,true);
	}
	//画流程线
	function _drawCanvaTransition(context,startPos,endPos,endRect,g){
		if(g&&g.length>0){//有拐点
			for(var i=0;i<g.length;i++){
				_drawStraightLine(context,startPos,g[i]);
				startPos = g[i];
			}
		}
		
		_drawStraightLine(context,startPos,endPos);
		
		var r = 5/Math.sin(30*Math.PI/180);
		//计算正切角度
		var tag = (endPos.top-startPos.top)/(endPos.left-startPos.left);
		tag = isNaN(tag)?0:tag;
		
		var o = Math.atan(tag)/(Math.PI/180)-30;//计算角度
		var rectTag = endRect.height/endRect.width;
		//计算箭头位置
		var xFlag = startPos.top<endPos.top?-1:1,
			yFlag = startPos.left<endPos.left?-1:1,
			arrowTop,
			arrowLeft;
		//按角度判断箭头位置
		if(Math.abs(tag)>rectTag&&xFlag==-1){//top边
			arrowTop  = endPos.top-endRect.height/2;
			arrowLeft = endPos.left+xFlag*endRect.height/2/tag;
		}else if(Math.abs(tag)>rectTag&&xFlag==1){//bottom边
			arrowTop  = endPos.top+endRect.height/2;
			arrowLeft = endPos.left+xFlag*endRect.height/2/tag;
		}else if(Math.abs(tag)<rectTag&&yFlag==-1){//left边
			arrowTop  = endPos.top+yFlag*endRect.width/2*tag;
			arrowLeft = endPos.left-endRect.width/2;
		}else if(Math.abs(tag)<rectTag&&yFlag==1){//right边
			arrowTop  = endPos.top+endRect.width/2*tag;
			arrowLeft = endPos.left+endRect.width/2;
		}
		
		if(arrowLeft&&arrowTop){
			//计算低位偏移
			var lowDeltX = r*Math.cos(o*Math.PI/180);
			var lowDeltY = r*Math.sin(o*Math.PI/180);
			//计算高位偏移
			var o = 90-o-60;//计算角度
			var highDeltX = r*Math.sin(o*Math.PI/180);
			var highDeltY = r*Math.cos(o*Math.PI/180);
			var flag = 1;
			if(startPos.left>endPos.left){
				flag = -1;
			}
			//画箭头
			context.moveTo(arrowLeft,arrowTop);
			context.lineTo(arrowLeft-lowDeltX*flag,arrowTop-lowDeltY*flag);
			context.moveTo(arrowLeft,arrowTop);
			context.lineTo(arrowLeft-highDeltX*flag,arrowTop-highDeltY*flag);
		}
	}
	
	
	/**
	 * 获取element元素上的数据属性对象
	 */
	function getDataProperties(element){
		var properties = element.data('properties');
		return properties!=null?properties:{};
	}
	/**
	 * 获取element元素上的数据属性值
	 */
	function getDataProperty(element,propName){
		return getDataProperties(element)[propName];
	}
	/**
	 * 设置element元素上的数据属性值
	 */
	function setDataProperty(element,propName,propValue){
		var properties = $.extend({},element.data('properties'));
		if(propName){
			properties[propName] = propValue;
			element.data('properties',properties);
		}
	}
	/**
	 * 解析element元素为模型对象
	 */
	function parseModel(element){
		var model = {
			id:element.attr('id'),
			caption:element.text()
		};
		var properties = getDataProperties(element);
		
		var expression = element.attr('expression');
		if(expression){
			model.expression = expression; 
		}
		
		//model = $.extend(model,properties);
		for(var prop in properties){
			var propSplit = prop.split('activiti:');
			if(propSplit.length==2){
				model[propSplit[1]] = properties[prop];
			}else{
				model[propSplit[0]] = properties[prop];
			}
		}
		return model;
	}
})(jQuery);