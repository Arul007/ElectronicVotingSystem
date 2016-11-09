<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Homepage</title>
<%@ include file="header.jsp"%>
<%@ include file="Admin_Header.jsp"%>
</head>
<body>
<br>
<s:actionmessage/>
<s:actionerror/>
<div id="leftcolumn">
		<%@ include file="adminMenu.jsp"%>
</div>
<div id="rightcolumn" class="rightcolumn1">
<h2 align="center">Enter ElectionId.. </h2>
<s:form action="approveResult">
<table align="center">
	<s:textfield name="electionId" key="election.electionID" />
	<s:submit key="submit" />
	</table>
</s:form>
<br><br>
<table align="center" border="3px">
<tr>
<th>ElectionId</th>
<th>CandidateId</th>
<th>VoteCount</th>
</tr>
<s:iterator value="result">
				<tr>
					<td><s:property value="electionID" /></td>
					<td><s:property value="candidateID" /></td>
					<td><s:property value="voteCount" /></td>
				</tr>
</s:iterator>
</table>
</div>
	

</body>
<div>
	<%@ include file="footer.jsp"%>
</div>
 
</html>
