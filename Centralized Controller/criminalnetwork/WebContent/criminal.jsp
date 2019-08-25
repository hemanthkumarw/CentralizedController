
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRIMINAL DETAIL</title>
<style type="text/css">
body
{
background-image:url("san.jpg");
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
<form action="criminal" method="post"  enctype="multipart/form-data">
<div align="center">
<h3>UPDATE YOUR DETAILS</h3>
<table>
<tr>
<td>HEAD</td>
<td><input type="text" name="head"></td>
</tr>
<tr>
<td>CRIMINAL NAME</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>ACTIVITY</td>
<td><input type="text" name="activity"></td>
</tr>
<tr>
<td>COUNTRY</td>
<td><input type="text" name="country"></td>
</tr>
<tr>
<td>STATE</td>
<td><input type="text" name="state"></td>
</tr>
<tr>
<td>CITY</td>
<td><input type="text" name="city"></td>
</tr>
<tr>
<td>DATE</td>
<td><input type="text" name="date"></td>
</tr>
<tr>
<td>TIME</td>
<td><input type="text" name="time"></td>
</tr>
<tr>
<td>SEX</td>
<td><input type="text" name="sex">
</td>
</tr>
<tr>
<td>MEMBERS</td>
<td><input type="text" name="member">
</tr>
<tr>
<td>PHOTO</td>
<td><input type="file" name="photo">
</tr>
</table>
<center><input type="submit" value="upload"></center>
</div>
</form> 
</body>
</html>