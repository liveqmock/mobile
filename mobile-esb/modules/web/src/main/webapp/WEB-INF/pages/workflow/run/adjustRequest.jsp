<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
<youi:fieldLayout><youi:fieldHidden property="processDefinitionId"/><youi:fieldHidden property="taskId"/></youi:fieldLayout>
<youi:func name="initPage">
  //页面初始化
</youi:func>
<youi:fieldLayout columns="2" showBorder="false" id="fieldLayout0"><youi:fieldSelect mixed="false" convert="booleanStr" property="resendRequest" column="1" notNull="false" notVisible="false" caption="退回请求"></youi:fieldSelect></youi:fieldLayout></youi:page>