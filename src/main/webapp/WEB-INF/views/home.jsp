<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Red Liquid</title>
<script>
  $(function() {
    $( "#date" ).datepicker();
	  var h = window.innerHeight;
	  document.getElementById("searchContent").style.height = (h-200)+"px";
  });
  </script>
</head>
<body onload="getBloodGroup(); getState();">
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
		<div align="center" class="menu" style='float:left;'  onclick="showDate()">
			<span class="icon">&#xe953;</span>
		</div>
	</div>
	
	<form:form method="post" commandName="request">
	<div class="search" align="center">
					<label style="min-width:100px;" for="bloodgroup">Search blood requests</label><form:input  style="width:100px;color:#e63386;border: 1px dotted #e63386;line-height:28px;" path="date"
					placeholder="YYYY-DD-MM"/><form:select class="search" style="width:100px;" path="bloodgroup" title="Blood group" onchange="getState()">
						</form:select><form:select  style="width:200px;"  path="statename" title="State" onchange="getDistrict()">
						</form:select><form:select style="width:200px;" path="districtname" title="District" onchange="getTaluk()">
						</form:select><form:select style="width:200px;" title="City" path="talukname">
						</form:select>
						
						<input type="submit" class="searchButton icon"
						value="<spring:message text="&#xe986;"/>" />
				
	</div></form:form><br>
	
		<div class="searchContent" id="searchContent">
		<c:if test="${!empty listrequests}">
			<table width="100%" cellspacing="0">
				<c:forEach items="${listrequests}" var="request">
					<tr>
						<td>
							<div class="userListPink">
								<div class="username">
									<span class="icon">&#xe973;</span>&nbsp;${request.patientname}
								</div>
								
								<div class="bloodgroup">${request.noofunits} units</div>
								<div class="location">
									<span class="icon">&#xe947;</span>&nbsp;${request.districtname},${request.statename}
								</div>
								<div class="phone">
									<span class="icon">&#xe942;</span>&nbsp;${request.phone}
								</div>
								<div class="bloodgroup">${request.bloodgroup}</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>