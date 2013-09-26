<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:style href="styles/youi.treegrid.css"/>
<youi:page>
	<!-- 界面描述：系统菜单设计 {simple:false,popup:true,src:'/des/sysMenu/getMenuPathsByParent.json',iteratorParentAttr:'menuPath',code:'menuPath',show:'menuCaption'}-->
	<youi:fieldLayout columns="1" labelWidths="120">
		<youi:fieldTree width="660" property="exmenu" caption="可选菜单地址" popup="true" simple="false"
			 src="/des/sysMenu/getMenuPathsByParent.json" iteratorParentAttr="menuPath" code="menuPath" show="menuCaption"/>
	</youi:fieldLayout>
	<youi:grid
		usePager="false" scrollHeight="360"  panel="false"
		reset="NOT" submit="NOT"
		add="NOT" edit="NOT" remove="NOT" dataFormId="form_dev_menu" 
		src="/des/sysMenu/getSysMenus.json"
		editSrc="/des/sysMenu/getSysMenu.json"
		id="tree_grid_dev_menu" idKeys="menuId" caption="菜单列表">
		
		<youi:button name="addRow" caption="插入行"/>
		<youi:button name="saveRow" caption="保存行" active="1"/>
		<youi:button name="removeRow" caption="删除行" active="1"/>
		
		<youi:button name="autoCreateMenuCode" caption="自动编号"  order="303"/>
		<youi:button name="refreshMenu" caption="刷新菜单"  order="303"/>
		<youi:button name="showXml" caption="显示XML"  order="305"/>
		<youi:button name="saveMenus" caption="全部保存"  order="315"/>
		
		<youi:gridCol width="280" type="tree" fixed="false" property="menuCaption" caption="菜单"/>
		<youi:gridCol width="100" property="menuCode" editor="fieldText" caption="菜单编号"/>
		<youi:gridCol width="300" editor="fieldText" property="menuHref" caption="菜单地址"
			editorOptions=""/>
	</youi:grid>
	
	<youi:form dialog="true" id="form_menu_xml" caption="菜单xml" submit="NOT" reset="NOT">
		<youi:fieldLayout labelWidths="1" columns="1">
			<youi:fieldArea property="html" readonly="true" caption="" width="810" rows="15"/>
		</youi:fieldLayout>
	</youi:form>
	
	
	<!-- 业务初始化 -->
	<youi:func name="init">
		var gridElement = $elem('tree_grid_dev_menu',pageId);
		gridElement.find('.grid-content .grid-scroll').delegate('.tree-node-text','click',function(event){
			//alert(this.innerHTML);
			var text = $(this).text();
			
			var editInput = $('input',this);
			if(editInput.length==0){
				$(this).empty().parent().removeAttr('value');
				editInput = $('<input class="grid-tree-input" type="type" value="'+text+'" />').appendTo(this);
			}
			return false;
		});
	</youi:func>
	
	<!-- 插入行 -->
	<youi:func name="func_grid_addRow">
		var gridElement = $elem('tree_grid_dev_menu',pageId);
		
		var selectedElement = gridElement.find('.row.selected');
		
		var level = 1;
		//取当前选择行的层级
		if(selectedElement.length){
			var maxLevel = 10;
			for(var i=1;i <= maxLevel;i++){
				if(selectedElement.hasClass('tree-level-'+i)){
					level = (i+1);
					break;
				}
			}
		}
		
		var menuId = new Date().getTime();
		gridElement.grid('addRow',{
			menuId:menuId,
			menuCaption:'新菜单'+menuId,
			level:level
		},true);
		
		if(selectedElement.length){
			//移动增加的行到选择行下方
			selectedElement.after(selectedElement.parent().find('.row:last'));
			
			selectedElement.removeClass('expanded').addClass('expandable');
			gridElement.grid('toggleTreeNode',null,selectedElement);
		}
	</youi:func>
	
	
	<!-- 刷新菜单 -->
	<youi:func name="func_grid_refreshMenu">
		var gridElement = $elem('tree_grid_dev_menu',pageId);
		gridElement.grid('pReload');
	</youi:func>
	
	<!-- 删除行 -->
	<youi:func name="func_grid_removeRow">
		var gridElement = $elem('tree_grid_dev_menu',pageId);
		var selectedElement = gridElement.find('.row.selected');
		
		if(selectedElement.hasClass('row-new')){
			selectedElement.remove();
		}else{
			if(window.confirm('确认删除菜单？')){
				$.youi.ajaxUtil.ajax({
					url:'/des/sysMenu/removeSysMenu.json',
					data:$.youi.parameterUtils.propertyParameter('menuId',selectedElement.attr('id')),
					success:function(results){
						//
						selectedElement.remove();
						selectedElement = null;
					}
				});
			}
		}
	</youi:func>
	
	<!-- 保存菜单 -->
	<youi:func name="func_grid_saveMenus">
		var gridElement = $elem('tree_grid_dev_menu',pageId);
		var records = gridElement.grid('getRecords');
		var menuXml = _buildMenuXmlFromRecords(records);
		$.youi.ajaxUtil.ajax({
			url:'/des/sysMenu/saveXmlToDb.json',
			data:$.youi.parameterUtils.propertyParameter('menuXml',menuXml),
			success:function(results){
				//删除新记录样式
				$('.row.row-new',gridElement).removeClass('row-new');
			}
		});
	</youi:func>
	
	<youi:func name="func_grid_showXml">
		var gridElement = $elem('tree_grid_dev_menu',pageId),
			formElement = $elem('form_menu_xml',pageId);
		var records = gridElement.grid('getRecords');
		var menuXml = _buildMenuXmlFromRecords(records);
		$.youi.ajaxUtil.ajax({
			url:'/des/sysMenu/showFormatXml.json',
			data:$.youi.parameterUtils.propertyParameter('menuXml',menuXml),
			success:function(results){
				//
				formElement.form('open').form('fillRecord',results.record);
			}
		});
	</youi:func>
	
	<youi:func name="func_grid_autoCreateMenuCode">
		var gridElement = $elem('tree_grid_dev_menu',pageId);
		//levelCod  tree-level-1
		var levelMap = {nextLevel:0};
		
		gridElement.find('tr.row').each(function(){
			var levelClass = findLevelClass(this);
			if(levelMap[levelClass]==null){
				levelMap[levelClass] = {level:++levelMap.nextLevel,index:1};
			}else{
				//重置比当前levelClass大的编号为0
				for(var iLevel in levelMap){
					if(iLevel>levelClass){
						levelMap[iLevel].index = 0;
					}
				}
				levelMap[levelClass].index++;
			}
			
			var codes = [];
			for(var i=1;i<=levelMap[levelClass].level;i++){
				var index = levelMap['tree-level-'+i].index;
				if(index<10){
					codes.push('0'+index);
				}else{
					codes.push(index);
				}
			}
			var menuCode = (codes.join('')+'000000').substring(0,6);
			$('td:eq(1)',this).html(menuCode).attr('value',menuCode);
			
		});

		function findLevelClass(trDoc){
			if(!trDoc)return '';
			var className = trDoc.className;
			var classArray = className.split(' ');
			var treeLevelClassPrefix = 'tree-level-';
			for(var i=0;i<classArray.length;i++){
				if(classArray[i].indexOf(treeLevelClassPrefix)==0){
					return classArray[i];
				}
			}
			return '';
		}
		
	</youi:func>
	
	<script>
		function _buildMenuXmlFromRecords(records){
			var xmls = [];
			xmls.push('<');
			xmls.push('menus');
			xmls.push('>');
			
			$(records).each(function(){
				xmls.push("<"+"menu ");
				xmls.push(_buildAttr('id',this.menuId));
				xmls.push(_buildAttr('menuCode',this.menuCode));
				xmls.push(_buildAttr('text',this.menuCaption));
				xmls.push(_buildAttr('href',this.menuHref));
				xmls.push(_buildAttr('level',this.level));
				xmls.push('/>');
			});
			
			xmls.push('<');
			xmls.push('/menus');
			xmls.push('>');
			
			return xmls.join('');
		}
		
		function _buildAttr(key,value){
			return key+'="'+(value||'')+'" ';
		}
	</script>
</youi:page>
