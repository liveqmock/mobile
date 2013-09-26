<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
<youi:fieldLayout><youi:fieldHidden property="processDefinitionId"/><youi:fieldHidden property="taskId"/></youi:fieldLayout>
<youi:func name="initPage">
  //页面初始化
</youi:func>
<youi:fieldLayout columns="2" showBorder="false" id="fieldLayout0"><youi:fieldText property="numberOfDays" column="1" notNull="false" notVisible="false" caption="请假天数"></youi:fieldText><youi:fieldText property="vacationMotivation" column="1" notNull="false" notVisible="false" caption="请假原因"></youi:fieldText><youi:fieldText property="startDate" column="1" notNull="false" notVisible="false" caption="起始日期"></youi:fieldText><youi:fieldSelect mixed="false" convert="booleanConvert" property="vacationApproved" column="1" notNull="false" notVisible="false" caption="是否同意"></youi:fieldSelect></youi:fieldLayout></youi:page>