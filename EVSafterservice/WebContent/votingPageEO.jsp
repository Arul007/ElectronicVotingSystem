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
	<h2 align="center">Enter Election Name</h2>
	<s:form action="voting2">
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
		<table align="center" border="3px">
			<tr>
				<th>Candidate ID</th>
				<th>Candidate Name</th>
				<th>Party Name</th>
				<th>Election ID</th>
				<th>Symbol</th>
				<th>Cast Your Vote</th>
				
			</tr>
			<s:iterator value="listOfCandidate1">
				<tr>
					<td><s:property value="candidateID" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="partyName" /></td>
					<td><s:property value="electionID" /></td>
					<td><img src="<s:property value="symbol" />"height="50" width="50"/></td>
					<td><a
						href= "vote2.action?
						candidateID=<s:property value="candidateID"/>&electionID=<s:property value="electionID"/>"
						>Cast Vote</a></td>
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