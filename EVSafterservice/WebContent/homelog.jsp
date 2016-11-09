<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" type="text/css" rel="stylesheet">
<title>Homelog jsp</title>
</head>
<body>

	<div class="header1">
		<table>
			<tr >
				<td align="left" style="width: 900px; ">Welcome....!!<%=session.getAttribute("user") %></td>
				<td align="center"><a href="login.jsp">Home</a> </td>
			</tr>
		</table>
	</div>
</body>
</html>