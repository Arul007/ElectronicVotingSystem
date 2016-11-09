<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.wipro.evs.action.AdminAction" %>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Election Details...</title>
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
<h2 align="center">Modify Election Details...</h2>
<s:if test="#session.userid=='null'">
<%
response.sendRedirect("login.jsp");
 %>
</s:if>
<s:else>
<s:form action="modifyElection">
<table align="center">
<tr><s:textfield value="%{electionBean.electionID}" name="electionBean.electionID" key="election.electionID" readonly="true"/></tr>
<tr><s:textfield value="%{electionBean.name}"  name="electionBean.name" key="election.name"/></tr>
<tr><s:textfield value="%{electionBean.electionDate}" name="electionBean.electionDate" key="election.date"/></tr>
<tr><s:textfield value="%{electionBean.district}" name="electionBean.district" key="election.district"/></tr>
<tr><s:textfield value="%{electionBean.constituency}" name="electionBean.constituency" key="election.con"/></tr>
<tr><s:textfield value="%{electionBean.countingDate}" name="electionBean.countingDate" key="election.counting"/></tr>
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