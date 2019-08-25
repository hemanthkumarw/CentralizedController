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
<title>ADMIN</title>
<style type="text/css">
body
{
background-image:url("bl.jpg");
background-repeat:no-repeat;
background-size:1350px;
background-position:top ;
background-color:#8A2BE2;
}
.gm{
    
    color: white;
    padding: 25px;
    text-align: center;
     border-style: solid;
     margin-left:400px;
     width:300px;
   background-color: blue;
}



a {
    background-color: #4CAF10;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 4px;
    width:150px;
    cursor: pointer;
    }
}
</style>
</head>
<body>
<br><br><br>
<div class="gm" align="center">
<a href="criminal.jsp" style="text-decoration:none;">CRIMINAL RECORD</a><br><br>
<a href="activate.jsp" style="text-decoration:none;">ACTIVATE</a><br><br>
<a href="officierdet.jsp" style="text-decoration:none;">OFFICIER DETAILS</a><br><br>
<a href="home.jsp" style="text-decoration:none;">LOGOUT</a>
</div>

</body>
</html>