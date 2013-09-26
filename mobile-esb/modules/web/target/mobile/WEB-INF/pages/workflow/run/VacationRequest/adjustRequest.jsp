<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
<youi:fieldLayout><youi:fieldHidden property="processDefinitionId"/><youi:fieldHidden property="taskId"/></youi:fieldLayout>
<youi:fieldLayout columns="1" showBorder="false" id="fieldLayout18"><youi:fieldSelect mixed="false" convert="booleanConvert" property="resendRequest" column="1" notVisible="false" caption="重新审批"></youi:fieldSelect></youi:fieldLayout></youi:page>