<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<%@ include file="header.jsp"%>

</head>
<body>
	<div class="header1">
		<a href="">About us</a> <a href="">Contact us</a>
     </div>		
<s:actionerror /> <s:actionmessage />
					
	<div class="loginBox">
			<div class="login" style="width: 311px;">
				<h1>Login</h1>
		
             <s:form method="post" action="login">
					<p style="width: 252px;">
						<s:textfield name="cb.userID" key="username" />
					</p>
					<p>
						<s:password name="cb.password" key="password" />
					</p>

					<p class="submit">
						<s:submit value="Login"></s:submit>
					</p>
				</s:form>


			</div>
			<div>
				<p>
					Forgot your password? <a href="#">Click here to reset it</a>.
				</p>
			</div>
			<div style="width: 296px;">
				<p align="left" style="width: 258px;">
					New User?<a href="registerProfile.jsp">Register Here</a>
				</p>
			</div>
		</div>
</body>
</html>

