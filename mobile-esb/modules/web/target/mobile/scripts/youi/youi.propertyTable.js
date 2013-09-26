(function($) {
	var _log = $.youi.log;
	/**
	 * propertyTable
	 * @author  zhyi_12
	 * @version 1.0.0
	 * @date 2011-04-03
	 */
	$.widget("youi.propertyTable", {
		options:{
			height:500,
			nameWidth:'100px'
		},
		
		propertyDescs:{},
		/**
		 * 构造函数
		 */
		_init:function(){
			this.options.id = this.element.attr('id');
			this.element.addClass('youi-propertyTable');
			this.propertyDescs = {};
			this._initPropertyGroupDescs();
			this._defaultHtmls();
			
			this._initAction();//初始化动作
			
			this.element.find('.propertyTable-content:first').editor({});
		},
		
		_initPropertyGroupDescs:function(){
			this.propertyGroupDescs = this.options.propertyGroupDescs;
		},
		/**
		 * 
		 */
		getPropertyDescs:function(groups){
			var propertyDescs = [];
			$.each(this.propertyGroupDescs,function(index){
				if($.isArray(this.propertyDescs)&&this.propertyDescs.length>0){
					$(this.propertyDescs).each(function(){
						for(var i=0;i<groups.length;i++){//查找匹配的属性
							if($.inArray(groups[i],this.groups)!=-1){
								propertyDescs.push($.extend({property:this.name},this));
								break;
							}
						}
					});
				}
			});
			return propertyDescs;
		},
		//propertyGroupDescs初始化
		
		_defaultHtmls:function(){
			var self = this;
			var htmls = [];
			var nameWidth = this.options.nameWidth;
			//头
			htmls.push('<div><table class="propertyTable-header youi-table" align="center" cellpadding="2" cellspacing="1" width="100%">');
			htmls.push('	<tr>');
			htmls.push('		<td width="'+nameWidth+'" >名称</td>');
			htmls.push('		<td>值</td>');
			htmls.push('	</tr>');
			htmls.push('</table></div>');
			htmls.push('<div class="propertyTable-content" style="height:'+(this.options.height-25)+'px;">');
			$.each(this.propertyGroupDescs,function(index){
				if($.isArray(this.propertyDescs)&&this.propertyDescs.length>0){
					htmls.push('<table class="propertyGroup youi-table" width="100%" cellspacing="1" cellpadding="2">');
					htmls.push('<tr class="propertyTable-group"><td class="expandHandle" width="'+nameWidth+'"></td><td class="propertyGroup-name">'+this.caption+'</td></tr>');
					var groupName = this.name;
					$(this.propertyDescs).each(function(){
						htmls.push('<tr groupName="'+groupName+'" class="propertyTable-item '+this.type+'" id="');
						htmls.push(this.name);
						htmls.push('"><td class="propertyTable-name">');
						htmls.push(this.caption);
						htmls.push('</td><td class="propertyTable-value ');
						htmls.push(this.type);
						htmls.push('"></td></tr>');
						
						self.propertyDescs[this.name] = this;
					});
					htmls.push('</table>');
				}
			});
			htmls.push('</div>');
			this.element.append(htmls.join(''));
		},
		
		_initAction:function(){
			this.element.bind('click',function(event){
				var targetClass = $.youi.classUtils.getEventClass(event);
				switch(targetClass){
					case 'propertyTable-value'://值单元格单击动作
						$(this).propertyTable('openEditor',event.target.parentNode.getAttribute('id'));
						return false;
					default:
						$(this).propertyTable('closeEditor');
				}
			});
			
			this.element.find('.propertyTable-content').bind('scroll',function(){
				$.youi.editorFactory.closeEditor();
			});
		},
		
//		positionEditor:function(){
//			var editingCell = this.element.find('.editing:first');
//			if(editingCell.length){
//				var editorPanel = $('#'+editingCell.attr('editorId'));
//				var cellOffset = editingCell.offset();
//				editorPanel.show().css({
//					left:cellOffset.left,
//					top:cellOffset.top
//				});
//			}
//		},
		/**
		 * 打开编辑器
		 */
		openEditor:function(name){
			this._closeEditor();
			var valueCell = this.element.find('tr.propertyTable-item#'+name+' td.propertyTable-value');
			var propertyDesc = this.propertyDescs[name];
			//if(!type)return;
			
			var self = this;
			//组织单元格编辑参数
			var editorOptions = $.extend({
				closeEvent:function(value,text,oldValue){
					var change = propertyDesc.change||self.options.defaultChange;
					var groupName = valueCell.parent().attr('groupName');
					if($.isArray(value)){
						value = value.join();
					}
					
					if(oldValue!=value&&$.isFunction(change)){
						if(change.apply(valueCell[0],[self.bind,
							propertyDesc.name.replace(groupName+'_',''),
							value,
							text,oldValue])==false){
							return;
						}
					}
				},
				record:{},
				convert:propertyDesc.name,
				initHtml:true
			},propertyDesc,{
				name:propertyDesc.type,
				property:propertyDesc.name});
		
			this.element.find('.propertyTable-content:first').trigger('editor.open',[valueCell,editorOptions]);
//			
//			var editorId,editorOptions={};
//			switch(type){
//				case 'fieldLabel':
//					return;
//				case 'fieldText'://输入框
//					editorId = 'fieldTextEditor_'+this.options.id;
//					editorOptions ={
//						property:this.options.id,
//						prefix:'fieldTextEditor'
//					};
//					break;
//				case 'fieldCalendar'://日历
//					break;
//				default://textEditor_formDesigner_propertyTable
//					editorId = propertyDesc.type+'Editor_'+propertyDesc.name;
//					
//					editorOptions ={
//						property:propertyDesc.name,
//						prefix:propertyDesc.type+'Editor',
//						convert:propertyDesc.name
//					};
//			}
//			
//			var editorPanel = this._getEditorPanel(editorId,$.extend({fieldType:type},editorOptions));
//			
//			if(editorPanel&&editorPanel.length){
//				editorPanel.fieldReset();//重置值
//				var width = valueCell.width()-2;
//				editorPanel.fieldWidth(width);
//				editorPanel.fieldValue(valueCell.attr('value'));//设置field值
//				
//				valueCell.addClass('editing').attr('editorId',editorPanel.attr('id'));
//				
//				var cellOffset = valueCell.offset();
//				editorPanel.show().css({
//					left:cellOffset.left,
//					top:cellOffset.top
//				});
//				
//				editorPanel.fieldFocus();
//			}
		},
		
//		_getEditorPanel:function(editorId,options){
//			var editorPanel = $('#'+editorId);
//			if(!editorPanel.length){
//				var slef = this;
//				editorPanel = 
//					$('<div class="youi-editor youi-editor-'+options.fieldType+'" id="'+editorId+'"></div>')
//						.appendTo($('body',document))[options.fieldType](options).bind('keydown',function(event){
//							if($(event.target).hasClass('textInput')&&event.keyCode==13){
//								slef.closeEditor();
//							}
//						});
//			}
//			return editorPanel;
//		},
		
		_closeEditor:function(){
			$.youi.editorFactory.closeEditor();
//			var editingCell = this.element.find('.editing:first');
//			if(editingCell.length){
//				var editorPanel = $('#'+editingCell.attr('editorId'));
//				var value = editorPanel.fieldValue();
//				var oldValue = editingCell.attr('value');
//				var groupName = editingCell.parent().attr('groupName');
//				if(oldValue!=value){//执行change事件
//					var propertyDesc = this.propertyDescs[editingCell.parent().attr('id')];
//					
//					var change = propertyDesc.change||this.options.defaultChange;
//					if($.isFunction(change)){
//						if(change.apply(editingCell[0],[this.bind,
//							propertyDesc.name.replace(groupName+'_',''),
//							value,
//							editingCell.text(),
//							oldValue])==false){
//							return;
//						}
//					}
//				}
//				
//				editingCell.removeAttr('editorId')
//					.removeClass('editing')
//					.attr('value',value)
//					.text(editorPanel.fieldShow())
//					.attr('title',editingCell.text());
//				editorPanel.hide();
//			}
		},
		
		/**
		 * 关闭编辑器
		 */
		closeEditor:function(){
			this._closeEditor();
		},
		
		/**
		 * 激活
		 */
		active:function(bind,values,groups){
			this.disable();//清理之前的绑定
			this.bind = bind;
			this._activeItem(values,groups);
			this.element.addClass('active');
		},
		
		_activeItem:function(values,groups){
			var self = this;
			this.element.find('td.propertyTable-value').each(function(){
				var name = this.parentNode.getAttribute('id');
				var groupName = this.parentNode.getAttribute('groupName');
				if(!self.propertyDescs[name])return;
				var activeGroups = self.propertyDescs[name].groups;
				var active = false;
				
				for(var i=0;i<groups.length;i++){//查找匹配的属性
					if($.inArray(groups[i],activeGroups)!=-1){
						active = true;
						break;
					}
				}
				if(values&&active==true){
					$(this).parent().addClass('active');
					var value = values[name]||values[name.substring(groupName.length+1)];
					if(value){
						var caption = value;
						if($.youi.serverConfig.convertArray[name]){
							caption = $.youi.serverConfig.convertArray[name][value];
						}
						$(this).attr('value',value).text(caption).attr('title',caption);
					}else{
						$(this).attr('value','').attr('title','').text('');
					}
				}
			});
			
			//
			this.element.find('table.propertyGroup').each(function(){
				if($('.propertyTable-item.active',this).length){
					$(this).addClass('active');
				}
			});
		},
		/**
		 * 
		 */
		disable:function(){
			this._closeEditor();
			if(this.element.hasClass('active')){
				this.bind = null;
				this.element.removeClass('active').find('.active').removeClass('active');
			}
		}
		
	});
	
	$.extend($.youi.propertyTable,{
		version: "1.0.0",
		
		getter:['getPropertyDescs']
	});
})(jQuery);