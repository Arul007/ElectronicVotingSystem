<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Successful</title>
<%@ include file="header.jsp"%>
<%@ include file="Voter_Header.jsp"%>
</head>
<body>
<s:actionmessage/>
<s:actionerror/>
<div id="leftcolumn">
		<%@ include file="voterMenu.jsp"%>
</div>
<div id="rightcolumn" class="rightcolumn1">
	<center>
		<h2>Upcoming Election Details</h2>
		<br>
		<s:form>
			<table border="3px">
				<tr>
					<th>Election ID</th>
					<th>Election Name</th>
					<th>Election Date</th>
					<th>District</th>
					<th>Constituency</th>
					<th>Counting Date</th>
				</tr>
				<s:iterator value="listOfElection">
					<tr>
						<td><s:property value="electionID" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="electionDate" /></td>
						<td><s:property value="district" /></td>
						<td><s:property value="constituency" /></td>
						<td><s:property value="countingDate" /></td>
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