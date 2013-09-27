<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>	
	<script src="<%=request.getContextPath()%>/scripts/lib/jquery.ui.selectable.js" type="text/javascript"></script>
	
	<script src="<%=request.getContextPath()%>/scripts/youi/youi.netgraphic.js" type="text/javascript"></script>
	
	<youi:style href="/styles/youi.netgraphic.css"/>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<div id="youi_netgraphic" class="youi-netgraphic">
		<div id="DCC_A" class="node" style="left: 322px; top: 142px;">前置A</div>
		<div id="FLR_A" class="node" style="left: 104px; top: 259px;">流水A</div>
		<div id="FLR_B" class="node" style="left: 198px; top: 297px;">流水B</div>
		<div id="FLR_C" class="node" style="left: 306px; top: 315px;">流水C</div>
		<div id="CLR_A" class="node" style="left: 76px; top: 133px;">手续费A</div>
		<div id="CLR_B" class="node" style="left: 124px; top: 59px;">手续费B</div>
		<div id="CLR_C" class="node" style="left: 233px; top: 22px;">手续费C</div>
		<div id="CLR_D" class="node" style="left: 354px; top: 15px;">手续费D</div>
		
		<div id="transition1" class="transition click" 
			data-properties='{"sourceRef":"DCC_A","targetRef":"FLR_A"}' to="FLR_A" from="DCC_A"></div>
		<div id="transition2" class="transition" 
			data-properties='{"sourceRef":"DCC_A","targetRef":"FLR_B"}' to="FLR_B" from="DCC_A"></div>
		<div id="transition3" class="transition" 
			data-properties='{"sourceRef":"DCC_A","targetRef":"FLR_C"}' to="FLR_C" from="DCC_A"></div>
		<div id="transition4" class="transition" 
			data-properties='{"sourceRef":"DCC_A","targetRef":"CLR_A"}' to="CLR_A" from="DCC_A"></div>
		<div id="transition5" class="transition" 
			data-properties='{"sourceRef":"DCC_A","targetRef":"CLR_B"}' to="CLR_B" from="DCC_A"></div>
		<div id="transition6" class="transition" 
			data-properties='{"sourceRef":"DCC_A","targetRef":"CLR_C"}' to="CLR_C" from="DCC_A"></div>
		<div id="transition7" class="transition" 
			data-properties='{"sourceRef":"DCC_A","targetRef":"CLR_D"}' to="CLR_D" from="DCC_A"></div>	
			
		<div class="point-dragging"></div>
		<div class="node-dragging"></div>
		<div class="select-dragging"></div>
		<div class="node-over-panel">
			
		</div>
	</div>
	
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="init">
		var pageElement = $('#youi_netgraphic').parents('.youi-page:first');
			var width=pageElement.width()-10;
		$('#youi_netgraphic').netgraphic({
			width:width,
			height:480
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>