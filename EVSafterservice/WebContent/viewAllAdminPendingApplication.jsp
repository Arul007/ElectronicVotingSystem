<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Successful</title>
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
		<h2>All Pending Application Details</h2>
		<br>
		<s:form>
			<table border="3px">
				<tr>
					<th>User ID</th>
					<th>Constituency</th>
					<th>PassedStatus</th>
					<th>ApprovedStatus</th>

				</tr>
				<s:iterator value="pendingApplication">
					<tr>
						<td><s:property value="userID" /></td>
						<td><s:property value="constituency" /></td>
						<td><s:property value="passedStatus" /></td>
						<td><s:property value="approvedStatus" /></td>

						<td><a
							href="forwardRequest.action?userID=<s:property value="userID"/>">Forward</a></td>
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