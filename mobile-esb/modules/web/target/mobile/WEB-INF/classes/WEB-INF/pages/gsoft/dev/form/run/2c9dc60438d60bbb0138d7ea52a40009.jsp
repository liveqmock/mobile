<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
<youi:form submit="提  交 " reset="重 置" id="form_sInstAdjResRcv" caption="sInstAdjResRcv"><youi:fieldLayout columns="0" showBorder="false" id="fieldLayout_sInstAdjResRcv"><youi:fieldText property="adjDate" column="1" notVisible="false" caption="adjDate"></youi:fieldText><youi:fieldText property="adjResulte" column="1" notVisible="false" caption="adjResulte"></youi:fieldText><youi:fieldCalendar property="instIn" column="1" notVisible="false" caption="instIn"></youi:fieldCalendar><youi:fieldText property="instOut" column="1" notVisible="false" caption="instOut"></youi:fieldText><youi:fieldText property="tzType" column="1" notVisible="false" caption="tzType"></youi:fieldText></youi:fieldLayout></youi:form></youi:page>