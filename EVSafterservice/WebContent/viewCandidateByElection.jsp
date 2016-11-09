<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Viewing Candidate...</title>
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



	<h2 align="center">Enter Election Name</h2>
	<s:form action="viewCandidateByElection">
		<s:actionmessage />
		<table align="center">
			<tr>
				<s:textfield name="electionID" key="candidate.election" />
			</tr>

			<tr>
				<s:submit key="submit" />
			</tr>
		</table>
		<br>
		<br>
		<table align="left" class="tableclass" border="3px">
			<tr>
				<th>Candidate ID</th>
				<th>Name</th>
				<th>Election ID</th>
				<th>Party ID</th>
				<th>District</th>
				<th>Con</th>
				<th>DOB</th>
				<th>Mobile No</th>
				<th>Address</th>
				<th>Email Id</th>
			</tr>
			<s:iterator value="viewCandidate">
				<tr>
					<td><s:property value="candidateID" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="electionID" /></td>
					<td><s:property value="partyID" /></td>
					<td><s:property value="district" /></td>
					<td><s:property value="constituency" /></td>
					<td><s:property value="dateOfBirth" /></td>
					<td><s:property value="mobileNo" /></td>
					<td><s:property value="address" /></td>
					<td><s:property value="emailID" /></td>
					<td><a
						href="viewAllCandidate1.action?CandidateID=<s:property value="CandidateID"/>">Edit</a></td>
					<td><a
						href="deleteCandidate.action?CandidateID=<s:property value="CandidateID"/>">Delete</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
</div>
</body>
<div>
	<%@ include file="footer.jsp"%>
</div>
</html>