<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Application</title>
</head>
<style>
fieldset{
border: green 2px solid;
}
input { border: 1px solid #f00; 
border-radius: 3px;}
.inputSub { border: 1px solid blue;
background: white;
cursor: pointer}

body {
	margin: 0;
	padding: 0;
	font-family: Helvetica, Arial, sans-serif;
	color: #666;
	background: #f2f2f2; 
	font-size: 1em;
	line-height: 1.5em;
}
 
h1 {
	font-size: 2.3em;
	line-height: 1.3em;
	margin: 15px 0;
	text-align: center;
	font-weight: 300;
}
 
p {
	margin: 0 0 1.5em 0;
}
 
#main-header {
	background: #333;
	color: white;
	height: 80px;
}	
	#main-header a {
		color: white;
	}
	
	#logo-header {
	float: left;
	padding: 15px 0 0 20px;
	text-decoration: none;
}
	#logo-header:hover {
		color: #0b76a6;
	}
	
	#logo-header .site-name {
		display: block;
		font-weight: 700;
		font-size: 1.2em;
	}
	
	#logo-header .site-desc {
		display: block;
		font-weight: 300;
		font-size: 0.8em;
		color: #999;
	}
	
 
/*
 * Navegación
 */
nav {
	float: right;
}
	nav ul {
		margin: 0;
		padding: 0;
		list-style: none;
		padding-right: 20px;
	}
	
		nav ul li {
			display: inline-block;
			line-height: 80px;
		}
			
			nav ul li a {
				display: block;
				padding: 0 10px;
				text-decoration: none;
			}
			
				nav ul li a:hover {
					background: #0b76a6;
				}
				
				#main-content {
	background: white;
	width: 90%;
	max-width: 800px;
	margin: 20px auto;
	box-shadow: 0 0 10px rgba(0,0,0,.1);
}
 
	#main-content header,
	#main-content .content {
		padding: 40px;
	}
	
	los pie de páginaCSS

#main-footer {
	background: #333;
	color: white;
	text-align: center;
	padding: 20px;
	margin-top: 40px;
}
	#main-footer p {
		margin: 0;
	}
	
	#main-footer a {
		color: white;
	}

#main-footer {
	background: #333;
	color: white;
	text-align: center;
	padding: 20px;
	margin-top: 40px;
}
	#main-footer p {
		margin: 0;
	}
	
	#main-footer a {
		color: white;
	}
</style>
<body>

<header id="main-header">
		
		<a id="logo-header" href="#">
			<span class="site-name">Sara Barrientos </span>
			<span class="site-desc">PROYECTO DAW 16-17</span>
		</a> <!-- / #logo-header -->
 
		<nav>
			<ul>
				<li><a href="#"></a></li>
				
			</ul>
		</nav><!-- / nav -->
 
	</header><!-- / #main-header -->
	<form action="loginPath" method="post">
	<center>
	<br>
		<fieldset style="width: 300px">
			<legend> </legend>
			<table>
			<tr>
				<td colspan="2"><c:out value="${errorMsg}"/> </td>
			</tr>
				<tr>
					<td>User ID</td>
					<td><input type="text" name="username" required="required" /></td>
				</tr>
				<tr>
<<<<<<< HEAD
					<td>Password</td> <p> Modificacion professor </p>
=======
					<td>Password</td> <td>sara</td>//modificado
>>>>>>> Ficheros
					<td><input type="password" name="password" required="required" /></td>
				</tr>
				<tr>
					<td><input class="inputSub" type="submit" value="Login" /></td>
				</tr>
			</table>
		</fieldset>
		</center>
		
	</form>
	
	<footer id="main-footer">
		<p>&copy; 2016-2017 <a href="#">Sara</a></p>
	</footer> <!-- / #main-footer -->
</body>
</html>
