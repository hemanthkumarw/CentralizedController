<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NODE2</title>
<style type="text/css">
body
{
background-image:url(".jpg");
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
<form action="index" method="post">
<div align="center">
<h3>LOGIN HERE</h3>
<table>
<tr>
<td>MAIL ID</td>
<td><input type="text" name="mail"></td>
</tr>
<tr>
<td>PASSWORD</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="LOGIN"></td>
</tr>
</table>
</div>
</form>
</body>
</html>