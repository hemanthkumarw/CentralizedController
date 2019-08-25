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
background-image:url("pnk.png");
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
{s
margin: auto;
    border: 3px solid #73AD21;
}
</style>
</head>
<body>
<form action="sourcelogin" method="post" enctype="multipart/form-data">
<div align="center">
<h3>REGISTER HERE</h3>
<table>
<tr>
<td>NAME</td>
<td><input type="text" name="name" required></td>
</tr>
<tr>
<td>EMAIL ID</td>
<td><input type="text" name="email" required></td>
</tr>
<tr>
<td>CITY</td>
<td><input type="text" name="city" required></td>
</tr>
<tr>
<td>POSTAL CODE</td>
<td><input type="text" name="postcode" required></td>
</tr>
<tr>
<td>MOBILE NUMBER</td>
<td><input type="text" name="mobile" required></td>
</tr>
<tr>
<td>DATE OF BIRTH</td>
<td><input type="text" name="dob" required></td>
</tr>
<tr>
<td>SEX</td>
<td><input type="radio" name="sex" value="male">male
<input type="radio" name="sex" value="female">Female
</td>
</tr>
<tr>
<td>PASSWORD</td>
<td><input type="password" name="password" required>
</td>
</tr>
</table>
<center><input type="submit" value="REGISTER"></center>



</div>
</form> 
</body>
</html>