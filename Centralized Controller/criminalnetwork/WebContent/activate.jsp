<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
<br><br><br>
<div align="center">

<% 
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
	PreparedStatement pss=con.prepareStatement("SELECT * FROM officer WHERE activation=?");
	pss.setString(1, "deactivate");
	ResultSet res=pss.executeQuery();
	%>
	<h2>OFFICER</h2>
	<table border="5" bordercolor="green">
		<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>MAIL</th>
		<th>NETWORK</th>
		<th>ACTIVATION</th>
		</tr>
	<% 
	while(res.next())
	{
		String id=res.getString(1);
		String name=res.getString(2);
		String mail=res.getString(3);
		String network=res.getString(4);
	
	%>	
	
		<tr><td>
		<%out.write(id); %>
		</td><td>
		<%out.write(name); %>
		</td><td>
		<%out.write(mail); %>
		</td><td>
		<%out.write(network); %>
		</td><td>
		<input type="hidden" id="no" value="<%=id %>">
		<button onclick="loadDoc()">activate</button>
		<script type="text/javascript">
		var aa=document.getElementById("no").value;
		  
		  function loadDoc() {
			 				
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			    
			    }
			  };
			  xhttp.open("GET", "activate?id="+aa, true);
			  xhttp.send();
			}
		
		</script>
		</td></tr>
		
	
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