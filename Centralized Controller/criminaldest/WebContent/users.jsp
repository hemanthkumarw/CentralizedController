<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Arrays"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user</title>

<style type="text/css">
body
{
background-image:url("usr.jpg");
background-repeat:no-repeat;
background-size:1500px;
background-position:top ;
background-color:#6A5ACD;

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
    width:250px;
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
<%

String mail=request.getParameter("mail");
try

{
	String name=null;
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");	
	PreparedStatement pep=con.prepareStatement("select name from destination where email=?");
	pep.setString(1, mail);
	ResultSet res=pep.executeQuery();
	while(res.next())
	{
		name=res.getString(1);
		System.out.println(name);
	}
	
PreparedStatement pss=con.prepareStatement("select * from destinationinfo where dest=?");
pss.setString(1, name);
ResultSet rr=pss.executeQuery();
%>

<br><br><br><br>
<div align="center">
<table border="2" bordercolor="red">
<tr>
<th>NAME</th>
<th>TITLE</th>
<th>CONTENT</th>
</tr>
<% 
while(rr.next())
	
	
{
	
	String title=rr.getString(3);
	String content=rr.getString(4);
	String name1=rr.getString(5);
%>
<tr>
<td><%out.write(title); %></td>
<td><%out.write(content); %></td>
<td><%out.write(name1); %></td>
</tr>
<% 	
}
%>
</table>
</div>
<% 
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</body>
</html>