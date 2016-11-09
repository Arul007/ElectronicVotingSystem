<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Party Details...</title>
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


	<center>
		<h2>All Party Details</h2>
		<br>
		<s:form>
			<table border="3px">
				<tr>
					<th>Party ID</th>
					<th>Party Name</th>
					<th>Leader</th>
					<th>Symbol</th>
				</tr>
				<s:iterator value="allParty">
					<tr>
						<td><s:property value="partyID" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="leader" /></td>
						<td><img src="<s:property value="symbol"/>" height="50" width="50"/></td>
						<td><a
							href="viewAllParty1.action?partyID=<s:property value="partyID"/>">Edit</a></td>
						<td><a
							href="deleteParty.action?partyID=<s:property value="partyID"/>">Delete</a></td>
					</tr>
				</s:iterator>
			</table>
		</s:form>
	</center>
</div>	
</body>
<div>
	<%@ include file="footer.jsp"%>
</div> 
</html>