<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<!-- grid-接口参数列表-->
	<youi:grid id="grid_outerServiceParam" idKeys="paramId" caption="接口参数列表" 
				src="getPagerOuterServiceParams.json" 
				removeSrc="removeOuterServiceParam.json">
		<youi:fieldLayout>
			<youi:fieldText property="paramCaption"  caption="参数描述"></youi:fieldText>
			<youi:fieldText property="paramType"  caption="参数类型"></youi:fieldText>
			<youi:fieldText property="paramXpath"  caption="参数路径"></youi:fieldText>
			<youi:fieldText property="outerSysId"  caption="外部系统ID"></youi:fieldText>
			<youi:fieldText property="paramName"  caption="参数名"></youi:fieldText>

			<youi:fieldText property="dataLength"  caption="长度"></youi:fieldText>
			<youi:fieldText property="dataType"  caption="数据类型"></youi:fieldText>
		</youi:fieldLayout>
		
		<youi:button caption="增加" name="addOuterServiceParam" active="0" icon="addRecord"></youi:button>
		<youi:button caption="编辑" name="editOuterServiceParam" active="1"  icon="editRecord"></youi:button>
		<youi:button caption="删除" name="removeOuterServiceParam" active="2" icon="removeRecord"></youi:button>
		
		<youi:gridCol property="paramCaption"  caption="参数描述"/>
		<youi:gridCol property="paramType"  caption="参数类型"/>
		<youi:gridCol property="paramXpath"  caption="参数路径"/>
		<youi:gridCol property="outerSysId"  caption="外部系统ID"/>
		<youi:gridCol property="paramName"  caption="参数名"/>

		<youi:gridCol property="dataLength"  caption="长度"/>
		<youi:gridCol property="dataType"  caption="数据类型"/>
	</youi:grid>
	
	<!-- form-接口参数编辑 -->
	<youi:form dialog="true" caption="编辑接口参数" id="form_outerServiceParam" action="saveOuterServiceParam.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="paramCaption"  caption="参数描述"/>
			<youi:fieldText property="paramType"  caption="参数类型"/>
			<youi:fieldText property="paramXpath"  caption="参数路径"/>
			<youi:fieldText property="outerSysId"  caption="外部系统ID"/>
			<youi:fieldText property="paramName"  caption="参数名"/>
			<youi:fieldText property="paramId"  caption="参数ID"/>
			<youi:fieldText property="dataLength"  caption="长度"/>
			<youi:fieldText property="dataType"  caption="数据类型"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
</youi:page>