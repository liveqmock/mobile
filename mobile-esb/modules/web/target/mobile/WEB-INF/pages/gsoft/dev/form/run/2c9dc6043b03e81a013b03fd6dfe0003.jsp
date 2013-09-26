<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
<youi:func name="initPage">
  //页面初始化
</youi:func>
<youi:func name="form_remove_beforeSubmit">
  return true;
</youi:func>
<youi:grid submit="查 询" reset="重置" add="增加" edit="编辑" remove="删除" id="grid_user" caption="用户列表"><youi:fieldLayout columns="0" showBorder="false" id="fieldLayout_grid3" caption="查询条件"><youi:fieldCalendar property="username" column="1" notVisible="false" caption="用户名"></youi:fieldCalendar></youi:fieldLayout><youi:gridCol property="grid3_col0" caption="用户名"></youi:gridCol><youi:gridCol property="grid3_col1" caption="用户描述"></youi:gridCol><youi:gridCol property="grid3_col2" caption="列2"></youi:gridCol><youi:gridCol property="grid3_col3" caption="列3"></youi:gridCol></youi:grid></youi:page>