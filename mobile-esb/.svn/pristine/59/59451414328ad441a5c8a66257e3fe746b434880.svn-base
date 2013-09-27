<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>	
	<script src="<%=request.getContextPath()%>/scripts/lib/jquery.ui.selectable.js" type="text/javascript"></script>
	
	<script src="<%=request.getContextPath()%>/scripts/youi/youi.organize.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/scripts/youi/youi.organizeDesigner.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/scripts/youi/youi.toolbar.js" type="text/javascript"></script>
	
	<youi:style href="/styles/youi.organize.css"/>
	<youi:style href="/styles/youi.toolbar.css"/>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:table>
		<youi:cell width="550">
			<div id="organize_designer">
				<div id="organize_designer_toolbar"></div>
				<div id="organize_designer_organize" class="youi-organize">
					<div style="left: 13px; top: 182px;" id="start" class="node ui-selectee">s</div>
					
					<div class="point-dragging"></div>
					<div class="node-dragging"></div>
					<div class="select-dragging"></div>
					<div class="node-over-panel">
						<div class="panel-top">
							<div id="delete" class="panel-button delete"></div>
						</div>
						
						<div class="panel-center">
							<div id="newUserTask" class="panel-button newUserTask"></div>
						</div>
					</div>
				</div>
			</div>
		</youi:cell>
	</youi:table>
	
	<youi:form dialog="true" id="form_organize" caption="组织信息">
		<youi:fieldLayout columns="1">
			<youi:fieldHidden property="organizeId"/>
			<youi:fieldLabel property="parentOrganize" width="260" caption="上级组织"/>
			<youi:fieldText property="organizeCaption" width="260" caption="组织名称"/>
			<youi:fieldSelect property="organizeRole" width="260" caption="组织角色"/>
			
			<youi:fieldGrid property="organizeFields" caption="组织成员" width="260">
				<youi:grid width="100%" id="grid_member"  panel="false" submit="NOT" reset="NOT"
						add="NOT" edit="NOT" remove="NOT" usePager="false" scrollHeight="255">
					<youi:gridCol property="userCaption" width="120" caption="姓名"/>
					<youi:gridCol property="pos" caption="岗位"/>
					<youi:button name="addMember" caption="添加成员"/>
				</youi:grid>
			</youi:fieldGrid>
		</youi:fieldLayout>
	</youi:form>
			
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="init">
		$('#organize_designer').organizeDesigner({
			width:800,
			select:function(){
				//
				//alert(this);
			}
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>