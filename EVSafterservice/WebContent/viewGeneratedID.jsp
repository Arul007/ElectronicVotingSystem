<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generated Id</title>
<%@ include file="header.jsp"%>
<%@ include file="Voter_Header.jsp"%>
</head>
<body>
<div id="leftcolumn">
		<%@ include file="voterMenu.jsp"%>
</div>
<div id="rightcolumn" class="rightcolumn1">
<s:actionmessage/>
<s:actionerror/>
	<center>
		<h2>Select Constituency..</h2>
		<br>
		<s:form action="viewGeneratedID">
			<table align="center" border="3px">
			<tr><s:select list="{'C1','C2','C3'}" name="constituency" key="election.con"/></tr>
            
			</table><br><br>
			<s:submit key="submit" align="center"/>
			
		</s:form>
		
	</center>
 </div>	
</body>
<div>
	<%@ include file="footer.jsp"%>
</div>
</html>