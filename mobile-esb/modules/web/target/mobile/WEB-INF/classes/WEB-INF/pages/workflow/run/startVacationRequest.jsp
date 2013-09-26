<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page><youi:form id="form_flow" caption="name" action="/workflow/flow/start.json">
<youi:fieldLayout><youi:fieldHidden property="processDefinitionId"/><youi:fieldHidden property="taskId"/></youi:fieldLayout>
<youi:func name="initPage">
 //页面初始化
</youi:func>
<youi:fieldLayout columns="1" showBorder="false" id="fieldLayout0"><youi:fieldText property="numberOfDays" column="1" notNull="false" notVisible="false" caption="天数"></youi:fieldText><youi:fieldText property="startDate" column="1" notNull="false" notVisible="false" caption="起始日期"></youi:fieldText><youi:fieldText property="vacationMotivation" column="1" notNull="false" notVisible="false" caption="原因"></youi:fieldText></youi:fieldLayout></youi:form></youi:page>