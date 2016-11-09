<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Party Details</title>
<%@ include file="header.jsp"%>
<%@ include file="Admin_Header.jsp"%>
</head>
<body>
<s:actionmessage/>
<s:actionerror/>
<div id="leftcolumn">
		<%@ include file="adminMenu.jsp"%>
</div>
<div id="rightcolumn" class="rightcolumn1">
<h2 align="center">Add Party</h2>
<s:form action="addParty">
<s:actionmessage/>
<table align="center">
<tr><s:textfield name="partyBean.name" key="party.name"/></tr>
<tr><s:textfield name="partyBean.leader" key="party.leader"/></tr>
<tr><s:textfield name="partyBean.symbol" key="party.symbol"/></tr>
<tr><s:submit key="submit" /></tr>
</table>
</s:form>
</div>
</body>
<div>
	<%@ include file="footer.jsp"%>
</div> 
</html>