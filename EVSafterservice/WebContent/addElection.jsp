<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Election</title>
<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="header.jsp"%>
<%@ include file="Admin_Header.jsp"%>
</head>
<body>
<br><br>
	<div id="leftcolumn">
		<%@ include file="adminMenu.jsp"%>
</div>
<div id="rightcolumn" class="rightcolumn1">
			<h2 align="center">Add Election</h2>

	<s:form action="addElection">
		<s:actionmessage />
		<table align="center">
			<tr>
				<s:textfield name="electionBean.name" key="election.name" />
			</tr>
			<tr>
				<s:textfield name="electionBean.electionDate" key="election.date" />
			</tr>
			<tr>
				<s:textfield name="electionBean.district" key="election.district" />
			</tr>

			<tr>
				<s:select list="{'C1','C2','C3'}" name="electionBean.constituency"
					key="election.con" />
			</tr>

			<tr>
				<s:textfield name="electionBean.countingDate"
					key="election.counting" />
			</tr>
			<tr>
				<s:submit key="submit" />
			</tr>
		</table>
	</s:form>
	</div>
</body>
<div>
	<%@ include file="footer.jsp"%>
</div>
</html>