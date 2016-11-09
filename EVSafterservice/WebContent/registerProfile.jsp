<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register user...</title>
<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="header.jsp"%>
<%@ include file="homelog.jsp"%>
</head>
<body>
<h2 align="center">Registration Form</h2>
<s:form action="registerAction">
<s:actionmessage/>
<table align="center">
<tr><s:textfield name="profileBean.firstName" key="a"/></tr>
<tr><s:textfield name="profileBean.lastName" key="b"/></tr>
<tr><s:textfield name="profileBean.dateOfBirth" key="c"/></tr>
<tr><s:select list="{'Male','Female'}" name="profileBean.gender" key="d"/></tr>
<tr><s:textfield name="profileBean.street" key="e"/></tr>
<tr><s:select list="{'C1','C2','C3'}" name="profileBean.location" key="f"/></tr>
<tr><s:textfield name="profileBean.city" key="g"/></tr>
<tr><s:textfield name="profileBean.state" key="h"/></tr>
<tr><s:textfield name="profileBean.pincode" key="i"/></tr>
<tr><s:textfield name="profileBean.mobileNo" key="j"/></tr>
<tr><s:textfield name="profileBean.emailID" key="k"/></tr>
<tr><s:password name="profileBean.password"  key="l"/></tr>
<tr><s:submit  key="n" /></tr>
</table>
</s:form>

</body>
<%@ include file="footer.jsp"%>
</html>