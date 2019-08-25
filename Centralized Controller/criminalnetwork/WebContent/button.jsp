
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
<%@ page import="javax.servlet.ServletOutputStream" %>
<%@page import="javax.crypto.Cipher"%>
<%@page import="javax.crypto.KeyGenerator"%>
<%@page import="javax.crypto.SecretKey"%>
<%@page import="javax.crypto.spec.SecretKeySpec"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<%
String mail=request.getParameter("mail");

try
{
	String name=null;
	Class.forName("com.mysql.jdbc.Driver");
 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
 	PreparedStatement pss=con.prepareStatement("select destination from sourceinfo where name=?");
 	pss.setString(1,mail);
 	ResultSet res=pss.executeQuery();
 	while(res.next())
 	{
 		 name=res.getString(1);
 		 System.out.println(name);
 	}
 	PreparedStatement p=con.prepareStatement("select * from criminalinfo where destination=?");
 	p.setString(1,name);
 	ResultSet ee=p.executeQuery();
 	%>
 	<div align="center">
 	<table>
 	<tr>
 	<th>NAME</th>
 	<th>NODE</th>
 	</tr>
 	<% 
 	while(ee.next())
 	{
 	String name1=ee.getString(6);
 	String node=ee.getString(7);
 	%>
 	<tr>
 	<td><%out.write(name1); %></td>
 	<td><%out.write(node); %></td>
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