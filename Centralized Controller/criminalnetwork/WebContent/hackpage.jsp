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
background-image:url("usr.jpg");
background-repeat:no-repeat;
background-size:1500px;
background-position:top ;
background-color: 	#6A5ACD;

}
td
{
font-family: Gotham 3r;
    font-weight: 400;
    font-style: normal;
    font-size: 24px;
    line-height: 28px;
    margin-left:20px;
}
input[type=text],input[type=password]
{
    width:200px;
    padding: 10px 15px;
    margin: 5px 5px;
    display: inline-block;
     border: 2px solid green;
     border-radius: 9px;
    box-sizing: border-box;
    background-color: #3CBC8D;
        color: black;
    }
    table
{
margin: auto;
    border: 3px solid #73AD21;
}
</style>
</head>
<body>
<br><br><br>
<%
String name=(String)request.getAttribute("name");
System.out.println(name);
String head=(String)request.getAttribute("head");
System.out.println(head);
%>
<div align="center">
<form action="hacker" method="post">
<table>
<tr>
<td>DESTINATION</td>
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
</td>
</tr>
<tr>
<td>NODE</td>
<td>
<select  name="node">
<option value="node1">node1</option>
<option value="node2">node2</option>
<option value="node3">node3</option>
<option value="node4">node4</option>
</select>
</td></tr>
</table>
<center><input type="submit" value="forward"></center>
</form>
</div>
</body>
</html>