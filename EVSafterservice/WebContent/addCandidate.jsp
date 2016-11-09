<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Candidate Details...</title>
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



	<h2 align="center">Candidate Form</h2>
	<s:form action="addCandidate">
		<s:actionmessage />
		<table align="center">
			<tr>
				<s:textfield name="candidateBean.name" key="candidate.name" />
			</tr>
			<tr>
				<s:textfield name="candidateBean.electionID"
					key="candidate.electionid" />
			</tr>
			<tr>
				<s:textfield name="candidateBean.partyID" key="candidate.partyid" />
			</tr>
			<tr>
				<s:textfield name="candidateBean.district" key="candidate.district" />
			</tr>
			<tr>
			<s:select list="{'C1','C2','C3'}" name="candidateBean.constituency" key="candidate.constituency"/>
				
			</tr>
			<tr>
				<s:textfield name="candidateBean.dateOfBirth" key="candidate.dob" />
			</tr>
			<tr>
				<s:textfield name="candidateBean.mobileNo" key="candidate.mobileno" />
			</tr>
			<tr>
				<s:textfield name="candidateBean.address" key="candidate.address" />
			</tr>
			<tr>
				<s:textfield name="candidateBean.emailID" key="candidate.mail" />
			</tr>
			<tr>
				<s:submit key="n" />
			</tr>
		</table>
	</s:form>
	</div>
</body>
<div>
	<%@ include file="footer.jsp"%>
</div> 
</html>