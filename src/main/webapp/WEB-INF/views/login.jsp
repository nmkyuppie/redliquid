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
	<header>jingleee...<span class="loginuser"><span class="icon">&#xe975;</span> ${cookie.redliquid_username.value} </span></header>
	<div align="right" class="menuBar">
		<div align="center" class="menu">
			<a href="register"><span class="icon">&#xe905;</span>&nbsp;Sign Up</a>
		</div>
		<div align="center" class="menu" title="Post your blood request">
			<a href="request"><span class="icon">&#xe90b;</span>&nbsp;Request</a>
		</div>
		<div align="center" class="menu">
			<a href="search"><span class="icon">&#xe986;</span>&nbsp;Search</a>
		</div>
	</div>
	<div class="pageContent">
		<form:form method="post" commandName="login"
			onsubmit="return validateLogin();">

			<table align="center">
				<tr>
					<td><form:label path="username">Username</form:label><form:input path="username" placeholder="Username" /></td>
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