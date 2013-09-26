<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
<script src="<%=request.getContextPath()%>/scripts/lib/jquery-1.9.1.min.js" type="text/javascript" ></script>
<youi:style href="/styles/login/login.css"/>
<title>邮储监控系统登陆</title>

<%
	String username = request.getParameter("username");
	request.setAttribute("username",username);
%>
	<script>
    	function changeRandcode(){
			document.getElementById('img_randCode').src='Kaptcha.jpg?timeStamp='+new Date().getTime();
		}
    	
    	$(function(){
    		//已经登录或者在嵌套的pageContent容器中，重定位到主页面
    		if($('#hasLogin').val()=='true'||$('.youi-page-content').length){
    			window.location.href = '<%=request.getContextPath()%>/index.jsp';
    			return;
    		}
    		
    		var usernameElem = $('input[name=username]');
    		var passwordElem = $('input[name=password]');
    		
    		var defaultUser = usernameElem.val();
    		if(defaultUser=='user'||defaultUser=='cash'){
    			passwordElem.val('123456');
    			$('input:submit').click();
    		}
    		/**
    		$('form.login-form').bind('submit',function(){
    			$.ajax({
    				url:'login.jsp?json=true&username=1&password=2',
    				type:'POST',
    				success:function(result){
    					alert(result);
    				}
    			});
    			
    			return false;
    		});*/
    	});
    </script>
</head>
<shiro:authenticated>
	<!-- authenticated -->
	<input id="hasLogin" value="true"/>
</shiro:authenticated>

<body onload="document.f.username.focus();" class="login-bg-h">
	<table width="100%" cellpadding="0" cellspacing="0" class="login-bg" align="center">
		<tbody>
			<tr>
				<td colspan="3" style="height: 50px;"></td>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="60%" class="">
						<div class="login-form-bg login-main">
							<form class="login-form" name="f" action="" method="POST">
								<table class="login-table" width="100%" cellspacing="0" cellpadding="0">
									<tr>
										<td align="left"  valign="middle" height="38px"><input class="login-input" type='text'
											name='username' value='${username}' /></td>
									</tr>
									<tr>
										<td align="left"  valign="middle" height="32px"><input class="login-password"
											type='password' name='password' value='123456'></td>
									</tr>
								</table>
								
								<div class="login-buttons">
									<table width="240px">
										<tr>
											<td width="90px"><input
												class="login-form-bg login-button login-submit"
												name="submit" type="submit" value=" "> 
											</td>
											<td>
												<input
												class="login-form-bg login-button login-reset"
												name="reset" type="reset" value=" ">
											</td>
										</tr>
									</table>
								</div>		
								<div style="padding-left:25px;height:30px;color:red;font-weight:bold;">${error}</div>
							</form>
						</div></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td colspan="3"></td>
			</tr>
		</tbody>
	</table>
</body>
</html>