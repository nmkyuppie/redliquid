<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/general.css">
<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="resources/js/validation.js"></script>
<title>404 :: Page not found.</title>
</head>
<body>
<header>jingleee...</header>
	<div align="right" class="menuBar">
		<div align="center" class="menu">
			<a href="login"><span class="icon">&#xea13;</span>&nbsp;Sign In</a>
		</div>
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
	<table width="100%" cellspacing="0">
	<tr><td align="center" width="60%"><span class="errormsg"><span class="icon">&#xe9e5;</span>&nbsp;Page not found</span></td><td><img alt="404" src="resources/404.jpg"></td>
	</tr>
	</table>
	</div>
</body>
</html>