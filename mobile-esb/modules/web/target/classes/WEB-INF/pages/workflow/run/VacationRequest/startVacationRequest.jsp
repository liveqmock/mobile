<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page><youi:form id="form_flow" caption="name" action="/workflow/flow/start.json">
<youi:fieldLayout><youi:fieldHidden property="processDefinitionId"/><youi:fieldHidden property="taskId"/></youi:fieldLayout>
<youi:fieldLayout columns="1" showBorder="false" id="fieldLayout2"><youi:fieldText property="numberOfDays" column="1" notVisible="false" caption="请假天数"></youi:fieldText><youi:fieldCalendar property="startDate" column="1" notVisible="false" caption="起始日期"></youi:fieldCalendar><youi:fieldText property="vacationMotivation" column="1" notVisible="false" caption="请假原因"></youi:fieldText></youi:fieldLayout></youi:form></youi:page>