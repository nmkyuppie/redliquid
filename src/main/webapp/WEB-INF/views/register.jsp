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
<title>Register</title>
</head>
<body onload="getState()">
	<header>jingleee...</header>
	<div align="right" class="menuBar">
		<div align="center" class="menu" data-tooltip="Sign In" data-tooltip-position="bottom">
			<a href="login"><span class="icon">&#xea13;</span>&nbsp;Sign In</a>
		</div>
		<div align="center" class="menu" data-tooltip="Post your blood request" data-tooltip-position="bottom">
			<a href="request"><span class="icon">&#xe90b;</span>&nbsp;Request</a>
		</div>
		<div align="center" class="menu" data-tooltip="Search donars" data-tooltip-position="bottom">
			<a href="search"><span class="icon">&#xe986;</span>&nbsp;Search</a>
		</div>
	</div>
	<div class="pageContent">
		<form:form method="post" commandName="register"
			onsubmit="return validateReg();">
			<form:hidden path="id" />

			<table align="center">
				<tr>
					<td><label for="username" >User Name</label><form:input path="username" placeholder="Name" /></td>
				</tr>
				<tr>
					<td><label for="email">Email id</label><form:input path="email" placeholder="Email id" /></td>
				</tr>
				<tr>
					<td><label for="age">Age</label><form:input path="age"
							placeholder="Age" /></td>
				</tr>
				<tr>
					<td><label for="password">Password</label><form:password path="password" placeholder="Password" /></td>
				</tr>
				<tr>
					<td><label for="cpassword">Confirm Password</label><input
						type="password" id="cpassword" placeholder="Confirm Password" /></td>
				</tr>
				<tr>
					<td><label for="phone">Phone Number</label><form:input path="phone" placeholder="Phone number" /></td>
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
				<tr ><td align="center" style="padding-top: 3px;">
				<form:hidden path="availability" value="true" onclick="toggleCheckBox()" style="width:0px;z-index: -1;position:absolute;"></form:hidden>
				<label id="checkYes" for="availability" class="checkBoxSelected" onclick="toggleCheckBox()">Yes</label>
				<label id="checkNo" for="availability" class="checkBoxNotSelected" onclick="toggleCheckBox()">No</label>
				<label id="checkText" for="availability" class="avtext" onclick="toggleCheckBox()">, I'm available to donate.</label></td>
				
				</tr>
				<tr>
					<td align="center"><input type="submit" class="submitButton"
						value="<spring:message text="Sign Up"/>" /></td>
				</tr>
				<tr align="right">
					<td colspan="2"><div align="center" id="error" class="error"></div></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>