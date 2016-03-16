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
// 	  document.getElementById("searchIframe").style.height = (h-200)+"px";
  });
  </script>
<title>Red liquid</title>
</head>
<body onload="getBloodGroup();">
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
	<div id="searchBox" class="search" align="center">
	<table cellspacing=0 cellpadding=0 border=0>
		<tr>
			<td>
			<label style="min-width:100px;" for="bloodgroup">Search blood requests</label>
			</td>
			<td>
			<select style="width:100px;" id="bloodgroup" title="Blood group" onchange="getState() "></select>
			</td>
			<td>
			<select  style="width:200px;"  id="statename" title="State" onchange="getDistrict()"></select>
			</td>
			<td>
			<select style="width:200px;" id="districtname" title="District" onchange="getTaluk()"></select>
			</td>
			<td>
			<select style="width:200px;" title="City" id="talukname"></select>
			</td>
			<td>
			<input type="submit" class="searchButton icon" onclick="setIframeSrc(1);" value="<spring:message text="&#xe986;"/>" />
			</td>
		</tr>
	</table>
	
	<iframe frameborder="0" src="requestsByCriteria?pageNo=1" id="searchIframe" width="100%" height="450px"></iframe>
	
	</div>
</body>
</html>