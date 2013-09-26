<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<link href="<%=request.getContextPath()%>/decorators/youi/main.css" type="text/css" rel="stylesheet"></link>
<link href="<%=request.getContextPath()%>/decorators/youi/menu.css" type="text/css" rel="stylesheet"></link>
<script type="text/javascript" >
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/decorators/youi/menu.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/decorators/youi/layout.js"></script>
<div class="header-bg" style="min-width:800">
	<table height="60px;" width="100%">
		<tr>
			<td class="header-bg-logo" width="500px"></td>
			<td>
				<div style="float:left;margin-left:120px;color:white;font-weight:bold;">
					<br>
					<br>
				    <script>
					    var date = new Date();
					    var year = date.getFullYear();
					    var month = date.getMonth()+1;
					    var day = date.getDate();
					    var hours = date.getHours();
					    var hello = "您好";
					    if (hours >=5 && hours < 12) {
					    hello = "早上好";
					    } else if (hours >= 8 && hours < 12){
					    hello = "上午好";
					    } else if (hours >= 12 && hours < 14){
					    hello = "中午好";
					    } else if (hours >= 14 && hours < 17){
					    hello = "下午好";
					    } else if (hours >= 17 && hours < 23){
					    hello = "晚上好";
					    } else if (hours > 23 || hours < 5){
					    hello = "夜里好";
					    }
					    document.write(hello+"，<shiro:principal/>！今天是"+year+"年"+month+"月"+day+"日");
				    </script>
				</div>
			</td>
			<td width="200">
				<div style="float:right;margin-right:20px"><a href="logout.jsp"><img src="<%=request.getContextPath()%>/decorators/youi/images/esc.jpg" width="55" height="61" border="0"></a></div>
				<div style="float:right;margin-right:10px"><a href="###" id="modify_password"><img src="<%=request.getContextPath()%>/decorators/youi/images/xgmm.jpg" width="53" height="61" border="0"></a></div>
			</td>
		</tr>
	</table>
	
</div>
