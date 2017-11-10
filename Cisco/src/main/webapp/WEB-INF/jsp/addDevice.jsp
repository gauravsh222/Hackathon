<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/kafka/add" method="post" commandName="device">
	Node Name  : <input type="text" name="node"/><br/>
	IP Address : <input type="text" name="ipAddress"/><br/>
	Terminal IP : <input type="text" name="terminalIP"/><br/>
	Port : <input type="text" name="port"/><br/>
<input type="submit" value="Submit">
</form>
</body>
</html>