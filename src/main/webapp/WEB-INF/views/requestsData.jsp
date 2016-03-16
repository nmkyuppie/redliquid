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
<title>Search Data</title>
</head>
<div class="searchContent" id="searchContent">
		<c:if test="${!empty listrequests}">
			<table width="100%" cellspacing="0">
				<c:forEach items="${listrequests}" var="request">
					<tr>
						<td>
							<div class="userListPink">
								 <div class="username" style="width:20%;">
									<span class="icon">&#xe971;</span>&nbsp;${request.patientname}
								</div>
								<div class="location" style="width:30%;">
									<span class="icon">&#xe947;</span>&nbsp;${request.talukname},${request.districtname},${request.statename}
								</div>
								<div class="phone" style="width:20%;">
									<span class="icon">&#xe942;</span>&nbsp;${request.phone}
								</div>
								<div class="date" style="width:15%;">
									<span class="icon">&#xe950;</span>&nbsp;${request.dateString}
								</div>
								<div class="bloodgroup">${request.bloodgroup}</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
</div>
<c:if test="${empty listrequests}">
	<div class="pageContent">
		<table width="100%" cellspacing="0">
			<tr>
				<td align="center" width="60%"><span class="errormsg"><span
						class="icon">&#xe9e5;</span>&nbsp;No records found</span></td>
			</tr>
		</table>
	</div>
</c:if>
</body>
</html>