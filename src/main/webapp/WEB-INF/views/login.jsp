<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/general.css">
<script type="text/javascript" src="resources/js/validation.js"></script>
<title>Login</title>
</head>
<body>
	<header>jingleee...<span class="loginuser">
		<span class="icon" onclick="showHeaderMenu();" style="cursor:pointer;padding: 10px;">&#xe9bf;</span></span>
	</header>
	<div id="headerMenu" class="headerMenu">
		<ul>
			<li onclick="location.assign('register')">Donar registration &nbsp;<span class="icon" style="cursor:pointer;">&#xe944;</span></li>
			<li onclick="location.assign('request')">Post your request &nbsp;<span class="icon" style="cursor:pointer;">&#xe950;</span></li>
			<li onclick="location.assign('login')">Edit profile &nbsp;<span class="icon" style="cursor:pointer;">&#xe907;</span></li>
		</ul>
	</div>
	<div align="right" class="menuBar">
		<div align="center" class="menu" title="Post your blood request">
			<a href="request"><span class="icon">&#xe953;</span>&nbsp;Blood requests</a>
		</div>
		<div align="center" class="menu">
			<a href="search"><span class="icon">&#xe986;</span>&nbsp;Search donars</a>
		</div>
	</div>
	<div class="pageContent">
		<form:form method="post" commandName="login"
			onsubmit="return validateLogin();">

			<table align="center">
				<tr>
					<td><form:label path="username">Email id</form:label><form:input path="username" placeholder="Email id" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label><form:input path="password" placeholder="Password" /></td>
				</tr>
				<tr align="center">
					<td align="center"><input type="submit"
						class="submitButton" value="<spring:message text="Sign In"/>" /></td>
				</tr>
				<tr align="right">
					<td><span class="forget">Forget Password?</span></td>
				</tr>
				<tr align="right">
					<td><div align="center" id="error" class="error">${sucessMsg}</div></td>
				</tr>
			</table>
		</form:form>
		
	</div>
</body>
</html>