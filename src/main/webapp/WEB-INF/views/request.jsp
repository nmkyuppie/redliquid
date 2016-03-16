<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/general.css">
<link rel="stylesheet" href="resources/js/jquery-ui.css">
<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/validation.js"></script>
<script>
  $(function() {
    $( "#date" ).datepicker();
  });
  </script>
<title>Home</title>
</head>
<body onload="getState()">

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
		<div align="center" class="menu">
			<a href="search"><span class="icon">&#xe986;</span>&nbsp;Search donars</a>
		</div>
	</div>
	<div class="pageContent">
		<form:form method="post" commandName="request"
			onsubmit="return validateReq();">
			<table align="center">
			
			<form:hidden path="code" />
				<tr>
					<td><label for="patientname">Patient Name</label><form:input path="patientname" placeholder="Patient name" /></td>
				</tr>
				<tr>
					<td><label for="patientage">Patient Age</label><form:input path="patientage"
							placeholder="Patient Age" /></td>
				</tr>
				<tr>
					<td><label for=""date"">Needed on</label><form:input path="date"
					placeholder="YYYY-DD-MM"/></td>
				</tr>
				<tr>
					<td><label for="bloodgroup">Blood group</label><form:select path="bloodgroup">
							<form:option value="O+"></form:option>
							<form:option value="O-"></form:option>
							<form:option value="A+"></form:option>
							<form:option value="A-"></form:option>
							<form:option value="B+"></form:option>
							<form:option value="B-"></form:option>
							<form:option value="AB+"></form:option>
							<form:option value="AB-"></form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><label for="noofunits">How many units?</label><form:input path="noofunits" value="1"
					placeholder="No. of units required"/></td>
				</tr>
				<tr>
					<td><label for="phone">Contact Number</label><form:input path="phone" placeholder="Phone number" /></td>
				</tr>
				<tr>
					<td><label for="email">Email id</label><form:input path="email" placeholder="Email id" /></td>
				</tr>
				<tr>
					<td><label for="statename">State</label><form:select path="statename" title="State" onchange="getDistrict()">
						</form:select></td>
				</tr>
				<tr>
					<td><label for="districtname">District</label><form:select path="districtname" title="District" onchange="getTaluk()">
						</form:select></td>
				</tr>
				<tr>
					<td><label for="talukname">City</label><form:select title="City" path="talukname">
						</form:select></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" class="submitButton"
						value="<spring:message text="Request"/>" /></td>
				</tr>
				<tr align="right">
					<td colspan="2"><div align="center" id="error" class="error"></div></td>
				</tr>
				</table>
		</form:form>
	</div>
</body>
</html>