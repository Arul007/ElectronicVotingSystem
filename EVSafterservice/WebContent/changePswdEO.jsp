<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electoral Home Page</title>
<%@ include file="header.jsp"%>
<%@ include file="EO_Header.jsp"%>
</head>
<body>
<s:actionmessage/>
<s:actionerror/>
<div id="leftcolumn">
		<%@ include file="EOMenu.jsp"%>
</div>
<div id="rightcolumn" class="rightcolumn1">
<h2 align="center">Change Your Password Here</h2>
<br>
	<center>
	
		<s:form action="changePswdEO">
		
			<s:textfield name="cb.password" key="x" />
			<s:textfield name="newpass" key="y" />
			<s:textfield name="connewpass" key="z" />
		
			<s:submit value="ChangePassword"/>
		</s:form>
	</center>
</div>


</body>
<div>
<%@ include file="footer.jsp"%>
</div>
</html>