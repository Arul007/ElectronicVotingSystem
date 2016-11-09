<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.wipro.evs.action.AdminAction" %>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Candidate Details...</title>
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


<h2 align="center">Modify Candidate Details...</h2>
<s:if test="#session.userid=='null'">
<%
response.sendRedirect("login.jsp");
 %>
</s:if>
<s:else>
<s:form action="modifyCandidate">
<table align="center">
<tr><s:textfield value="%{candidateBean.candidateID}" name="candidateBean.candidateID" key="candidate.id" readonly="true"/></tr>
<tr><s:textfield value="%{candidateBean.name}"  name="candidateBean.name" key="candidate.name"/></tr>
<tr><s:textfield value="%{candidateBean.electionID}" name="candidateBean.electionID" key="candidate.electionid" readonly="true"/></tr>
<tr><s:textfield value="%{candidateBean.partyID}" name="candidateBean.partyID" key="candidate.partyid" readonly="true"/></tr>
<tr><s:textfield value="%{candidateBean.district}" name="candidateBean.district" key="candidate.district"/></tr>
<tr><s:textfield value="%{candidateBean.constituency}" name="candidateBean.constituency" key="candidate.constituency"/></tr>
<tr><s:textfield value="%{candidateBean.dateOfBirth}" name="candidateBean.dateOfBirth" key="candidate.dob"/></tr>
<tr><s:textfield value="%{candidateBean.mobileNo}" name="candidateBean.mobileNo" key="candidate.mobileno"/></tr>
<tr><s:textfield value="%{candidateBean.address}" name="candidateBean.address" key="candidate.address"/></tr>
<tr><s:textfield value="%{candidateBean.emailID}" name="candidateBean.emailID" key="candidate.emailid"/></tr>
<tr><s:submit value="Modify"/></tr>
</table>
</s:form>
</s:else>
</div>
</body>
<div>
	<%@ include file="footer.jsp"%>
</div>
 
</html>