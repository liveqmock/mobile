<%@ include file="/WEB-INF/pages/include.jsp"%>

<%@ page language="java" pageEncoding="UTF-8"%>
<script>
	$(function(){
		$('#system_v_menu').sysmenu({
			
		});
	});
</script>

<!-- 纵向系统菜单 -->
<table width="100%" cellspacing="0" cellpadding="0"
	border="0" bgcolor="#EEF2FB">
	<tbody>
		<tr>
			<td height="5px;" class="menu-container-top"></td>
		</tr>
		<tr>
			<td width="182" valign="top">
				<youi:sysVertMenu id="system_v_menu"></youi:sysVertMenu>
			</td>
		</tr>
	</tbody>
</table>
