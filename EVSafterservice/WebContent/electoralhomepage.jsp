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
<br><br>
<div id="leftcolumn">
		<%@ include file="EOMenu.jsp"%>
</div>
<div id="rightcolumn" class="rightcolumn1">
<h3 align="center">Electoral Home Page</h3>
<s:actionmessage/>
<s:actionerror/>
</div>


</body>
<div>
<%@ include file="footer.jsp"%>
</div>
</html>