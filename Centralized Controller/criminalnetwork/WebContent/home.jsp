<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
<link rel="stylesheet" type="text/css" href="home.css">
<style type="text/css">
body
{
background-image:url("bl.jpg");
background-repeat:no-repeat;
background-size:1350px;
height:500px;
background-position:top ;
}
div {
    background-color:blue;
    color: white;
    padding: 25px;
    text-align: center;
}

div.govind
{
    margin: 5px;
    border: 1px solid #ccc;
    height: 400px;
    width: 1300px;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}
li {
    float: right;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}
h2
{
font-color:blue;
}
</style>
</head>
<body>
<div>
<h3 align="center">THE CENTRALIZED CONTROLLER TO OPTIMIZE PACKET SWITCHING WITH LESS TRAFFIC INTENSITY AND SECURITY
</h3>
<ul>
<li><a href="home.jsp" style="text-decoration:none">HOME</a><br><br></li>
<li><a href="informer.jsp" style="text-decoration:none">INFORMER</a><br><br></li>
<li><a href="officers.jsp" style="text-decoration:none">OFFICER</a><br><br></li>
<li><a href="public.jsp" style="text-decoration:none">PUBLIC</a><br><br></li>
<li><a href="network.jsp" style="text-decoration:none">NETWORK</a><br><br></li>
</ul>
</div>


<div class="govind">


<marquee  direction="down" scrollamount="6"><img src="cnss.png" id="myButton"  height="300" width="1000" ></marquee></div>

 <script type="text/javascript">
            var images = ['n1.jpg', 'n2.jpg', 'n3.jpg'],
                i = 1;

            // preload
            for (var j=images.length; j--;) {
                var img = new Image();
                img.src = images[j];
            }

            // event handler
            document.getElementById('myButton').addEventListener('click', function() {
                this.src = images[i >= images.length - 1 ? i = 0 : ++i];
            }, false);
        </script>
</div>

</body>
</html>