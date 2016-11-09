<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voter Home Page</title>
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
<h2 align="center">Election Result...</h2>
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

<b><a onclick="window.print()" href="electionResult.jsp">Print Election Result</a></b>
</div>
</body>
<div>
	<%@ include file="footer.jsp"%>
</div>
</html>