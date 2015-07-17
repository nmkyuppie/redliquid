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
<script>
  $(function() {
	  var h = window.innerHeight;
// 	  document.getElementById("searchContent").style.height = (h-200)+"px";
  });
  </script>
<title>Home</title>
</head>
<body onload="getBloodGroup();">
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
			<a onclick="searchBoxVisibility()"><span class="icon">&#xe986;</span>&nbsp;Search</a>
		</div>
	</div>
	<form:form method="post" commandName="user" style="margin:0 auto;width:750px;">
	<div id="searchBox" class="search" align="center">
					<label style="min-width:100px;" for="bloodgroup">Search donar</label><form:select style="width:100px;" path="bloodgroup" title="Blood group" onchange="getState()">
						</form:select><form:select  style="width:200px;"  path="statename" title="State" onchange="getDistrict()">
						</form:select><form:select style="width:200px;" path="districtname" title="District" onchange="getTaluk()">
						</form:select><form:select style="width:200px;" title="City" path="talukname">
						</form:select>
						
						<input type="submit" class="searchButton icon"
						value="<spring:message text="&#xe986;"/>" />
				
	</div></form:form><br>
	
	<div class="searchContent" id="searchContent">
		<c:if test="${!empty listusers}">
			<table width="100%" cellspacing="0">
				<c:forEach items="${listusers}" var="user">
					<tr>
						<td>
							<div class="userListPink">
								<div class="username">
									<span class="icon">&#xe971;</span>&nbsp;${user.username}
								</div>
								<div class="location">
									<span class="icon">&#xe947;</span>&nbsp;${user.districtname},${user.statename}
								</div>
								<div class="phone">
									<span class="icon">&#xe942;</span>&nbsp;${user.phone}
								</div>
								<div class="bloodgroup">${user.bloodgroup}</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	
	<div id="pager" align="right" class="pagerBar">
		<div align="center" class="pageNo">
			<a href="login">Next</a>
		</div>
		<div align="center" class="pageNo">
			<a href="login">Previous</a>
		</div>
	</div>
</body>
</html>