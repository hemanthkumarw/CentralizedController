
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
<title>Insert title here</title>
<style type="text/css">
body
{
background-image:url("san.jpg");
background-repeat:no-repeat;
background-size:1350px;
background-position:top ;
background-color:#8A2BE2;
}
 .go {
   
    color: white;
    padding: 25px;
    text-align: center;
   border-style: solid;
   width:200px;
   margin-left:550px;
   background-color: blue;
}

a
 {
    background-color: #4CAF10;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    width:100px;
    cursor: pointer;
    }
    h3
    {
    
    background-color: #4CAF10;
    height:50px;
    margin-top:20px;
    }
</style>
</head>
<body>
<%
try
{
	 Class.forName("com.mysql.jdbc.Driver");
 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
 	PreparedStatement pss=con.prepareStatement("select * from officer");
 	ResultSet res=pss.executeQuery();
 	%>
 	<br><br><br><br>
 	<div align="center">
 	<Table border="2" bordercolor="green">
 	<tr>
 	<th>NAME</th>
 	<th>EMAIL</th>
 	<th>ADDRESS</th>
 	<th>MOBILE</th>
 	<th>DOB</th>
 	
 	</tr>
 	<% 
 	while(res.next())
 	{
 		String name=res.getString(2);
 		String email=res.getString(3);
 		String address=res.getString(4);
 		String num=res.getString(6);
 		String dob=res.getString(7);
 		
 		
 		byte[] na=name.getBytes();
 		byte[] em=email.getBytes();
 		byte[] add=address.getBytes();
 		byte[] numm=num.getBytes();
 		byte[] dd=dob.getBytes();
 		

		KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        SecretKey myDesKey = keygenerator.generateKey();
        
	    Cipher desCipher;
        desCipher = Cipher.getInstance("AES");
        desCipher.init(Cipher.ENCRYPT_MODE,myDesKey);
        
        byte[] na1= desCipher.doFinal(na);
        
        String na2=new String(na1);
         
        byte[] email1=desCipher.doFinal(em);
        String email2=new String(email1);
        
        byte[] add1=desCipher.doFinal(add);
        String add2=new String(add1);
        
        byte[]  numm1=desCipher.doFinal(numm);
        String numm2=new String(numm1);
        
        byte[]  ddd=desCipher.doFinal(dd);
        String ddd1=new String(ddd);
 		
        %>
        <tr>
        <td><%out.write(name); %></td>
        <td><%out.write(email); %></td>
        <td><%out.write(address); %></td>
        <td><%out.write(num); %></td>
        <td><%out.write(dob); %></td>
        </tr>
       <% 
 	}
 	%>
 	</Table>
 	</div>
 	<% 
}
catch(Exception e)
{
	
}
%>
</body>
</html>