<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body
{
background-image:url("red.jpg");
background-repeat:no-repeat;
background-size:1350px;
background-position:top ;
background-color:#8A2BE2;
}
</style>
</head>
<body>
<%
String name=(String)request.getAttribute("mail");
String head=(String)request.getAttribute("head");
String s1="node1";
%>
<div align="center">
<form action="criminalnode2" method="post">
<table>
<tr>
<td>NAME</td>
<td><input type="text" name="destination"></td>
</tr>
<tr>
<td>TITLE</td>
<td><input type="text" name="title"></td>
</tr>
<tr>
<td>MESSAGE</td>
<td><textarea  name="content" ></textarea>
<input type="hidden" name="name" value=<%=name %>>
<input type="hidden" name="head" value=<%=head %>>
<input type="hidden" name="node" value=<%=s1 %>>
</td>
</tr>
</table>
</form>
</div>
</body>
</html>