<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.wipro.evs.action.AdminAction"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Party Details...</title>
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


	<h2 align="center">Modify Party Details...</h2>
	<s:if test="#session.userid=='null'">
		<%
			response.sendRedirect("login.jsp");
		%>
	</s:if>
	<s:else>
		<s:form action="modifyParty">
			<table align="center">
				<tr>
					<s:textfield value="%{partyBean1.partyID}" name="partyBean1.partyID"
						key="party.partyID" readonly="true"/>
				</tr>
				<tr>
					<s:textfield value="%{partyBean1.name}" name="partyBean1.name"
						key="party.name" />
				</tr>
				<tr>
					<s:textfield value="%{partyBean1.leader}" name="partyBean1.leader"
						key="party.leader" />
				</tr>
				<tr>
					<s:textfield value="%{partyBean1.symbol}" name="partyBean1.symbol"
						key="party.symbol" />
				</tr>
				<tr>
					<s:submit value="Modify" />
				</tr>
			</table>
		</s:form>
	</s:else>
</div>
</body>
<div>
	<%@ include file="footer.jsp"%>
</div>
</html>