/**
 * Registration page validation
 */

var validateReg=function(){
	var user = document.getElementById('username').value;
	var email = document.getElementById('email').value;
	var age = document.getElementById('age').value;
	var password = document.getElementById('password').value;
	var cpassword = document.getElementById('cpassword').value;
	var phone = document.getElementById('phone').value;
	var bloodgroup = document.getElementById('bloodgroup').value;
	var statename = document.getElementById('statename').value;
	var districtname = document.getElementById('districtname').value;
	var talukname = document.getElementById('talukname').value;
	
	var reg = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var isItOk=false;
	
    if (user == null || user == "") {
    	document.getElementById('error').textContent = "Please enter your name";
    }
    else if(email == null || email == ""){
    	document.getElementById('error').textContent = "Please enter your email id";
    }
    else if(!reg.test(email)){
    	document.getElementById('error').textContent = "Please enter valid email id";
    }
    else if(age == null || age == ""){
    	document.getElementById('error').textContent = "Please enter your age";
    }
    else if(password == null || password == ""){
    	document.getElementById('error').textContent = "Please enter your password";
    }
    else if(password.length<8){
    	document.getElementById('error').textContent = "Password should have atleast 8 digits";
    }
    else if(cpassword == null || cpassword == ""){
    	document.getElementById('error').textContent = "Please enter confirm password";
    }
    else if(password!=cpassword){
    	document.getElementById('error').textContent = "Password should be same";
    }
    else if(phone == null || phone == ""){
    	document.getElementById('error').textContent = "Please enter your phone number";
    }
    else if(isNaN(phone)){
    	document.getElementById('error').textContent = "Please enter valid phone number";
    }
    else if(bloodgroup == null || bloodgroup == ""){
    	document.getElementById('error').textContent = "Please select your blood group";
    }
    else if(statename == null || statename == ""){
    	document.getElementById('error').textContent = "Please select the state";
    }
    else if(districtname == null || districtname == ""){
    	document.getElementById('error').textContent = "Please select the district";
    }
    else if(talukname == null || talukname == ""){
    	document.getElementById('error').textContent = "Please select the city";
    }
    else{
    	document.getElementById('error').textContent = "";
    	isItOk=true;
    }
    return isItOk;
}

/**
 * Request page validation
 */

var validateReq=function(){
	var user = document.getElementById('patientname').value;
	var patientage = document.getElementById('patientage').value;
	var date = document.getElementById('date').value;
	var email = document.getElementById('email').value;
	var bloodgroup = document.getElementById('bloodgroup').value;
	var noofunits = document.getElementById('noofunits').value;
	var phone = document.getElementById('phone').value;
	var statename = document.getElementById('statename').value;
	var districtname = document.getElementById('districtname').value;
	var talukname = document.getElementById('talukname').value;

	var reg = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var dateReg = /^([0-9]{4}|[0-9]{2})[./-]([0]?[1-9]|[1][0-2])[./-]([0]?[1-9]|[1|2][0-9]|[3][0|1])$/ ; 
	var isItOk=false;
	
    if (user == null || user == "") {
    	document.getElementById('error').textContent = "Please enter patient's name";
    }
    else if(patientage == null || patientage == ""){
    	document.getElementById('error').textContent = "Please enter patient's age";
    }
    else if(isNaN(patientage)){
    	document.getElementById('error').textContent = "Please enter age in numbers";
    }
    else if(!dateReg.test(date)){
    	document.getElementById('error').textContent = "Please enter valid date";
    }
    else if(bloodgroup == null || bloodgroup == ""){
    	document.getElementById('error').textContent = "Please select your blood group";
    }
    else if(noofunits == null || noofunits == ""){
    	document.getElementById('error').textContent = "Please enter required no. of units";
    }
    else if(isNaN(noofunits)){
    	document.getElementById('error').textContent = "Please enter units in numbers";
    }
    else if(phone == null || phone == ""){
    	document.getElementById('error').textContent = "Please enter your phone number";
    }
    else if(isNaN(phone)){
    	document.getElementById('error').textContent = "Please enter valid phone number";
    }
    else if(email == null || email == ""){
    	document.getElementById('error').textContent = "Please enter your email id";
    }
    else if(!reg.test(email)){
    	document.getElementById('error').textContent = "Please enter valid email id";
    }
    else if(statename == null || statename == ""){
    	document.getElementById('error').textContent = "Please select the state";
    }
    else if(districtname == null || districtname == ""){
    	document.getElementById('error').textContent = "Please select the district";
    }
    else if(talukname == null || talukname == ""){
    	document.getElementById('error').textContent = "Please select the city";
    }
    else{
    	document.getElementById('error').textContent = "";
    	isItOk=true;
    }
    return isItOk;
}


var validateLogin=function(){
	var user = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	var isItOk=false;
    if (user == null || user == "") {
    	document.getElementById('error').textContent = "Please enter your name";
    }
    else if(password == null || password == ""){
    	document.getElementById('error').textContent = "Please enter your password";
    }
    else{
    	document.getElementById('error').textContent = "";
    	isItOk=true;
    }
    return isItOk;
}

var getBloodGroup=function(){
	$('#bloodgroup').empty();
	$('#bloodgroup').append('<option value="" disabled selected>Blood group</option>');
	$('#bloodgroup').append('<option value="A-" >A-</option>');
	$('#bloodgroup').append('<option value="A+" >A+</option>');
	$('#bloodgroup').append('<option value="B-" >B-</option>');
	$('#bloodgroup').append('<option value="B+" >B+</option>');
	$('#bloodgroup').append('<option value="O-" >O-</option>');
	$('#bloodgroup').append('<option value="O+" >O+</option>');
	$('#bloodgroup').append('<option value="AB-" >AB-</option>');
	$('#bloodgroup').append('<option value="AB+" >AB+</option>');
        	
}

var getState=function(){
	$.ajax({
        type: "POST",
        url: "state",
        data: {
        },
        success: function(data) {
        	$('#statename').empty();
        	var len=data.length;
        	var res=data.substring(1, len-1);
        	var state=res.split(",");
            $('#statename').append('<option value="" disabled selected>State</option>');
        	for (var i in state) {
                $('#statename').append('<option value="'+ state[i] + '">'+ state[i] + '</option>');
            }
        }
    });
}

var getDistrict=function(){
	var state = $('#statename').val();
	$.ajax({
        type: "POST",
        url: "district",
        data: "state=" + state,
        success: function(data) {
        	$('#districtname').empty();
        	var len=data.length;
        	var res=data.substring(1, len-1);
        	var district=res.split(",");
            $('#districtname').append('<option value="" disabled selected>District</option>');
        	for (var i in district) {
                $('#districtname').append('<option value="'+ district[i] + '">'+ district[i] + '</option>');
            }
        }
    });
}

var getTaluk=function(){
	var district = $('#districtname').val();
	$.ajax({
        type: "POST",
        url: "taluk",
        data: "district=" + district,
        success: function(data) {
        	$('#talukname').empty();
        	var len=data.length;
        	var res=data.substring(1, len-1);
        	var city=res.split(",");
            $('#talukname').append('<option value="" disabled selected>City</option>');
        	for (var i in city) {
        		if(city[i]!="")
                $('#talukname').append('<option value="'+ city[i] + '">'+ city[i] + '</option>');
            }
        }
    });
}

var toggleCheckBox=function(){
	var selected = $('#availability').val();
	if(selected!="true"){
		$("#checkYes").css("background-color","#787878");
		$("#checkYes").css("color","#FFF");
		$("#checkNo").css("background-color","#fff");
		$("#checkNo").css("color","#787878");
		$("#checkText").html(", I'm available to donate.");
		document.getElementById('availability').value="true";
	}
	else{
		$("#checkYes").css("background-color","#fff");
		$("#checkYes").css("color","#787878");
		$("#checkNo").css("background-color","#787878");
		$("#checkNo").css("color","#FFF");
		$("#checkText").html(", I'm not available to donate.");
		document.getElementById('availability').value="false";
	}
}

var searchBoxVisibility=function(){
	document.getElementById('searchBox').className = 'searchVisible';
	document.getElementById('searchContent').style.marginTop="0px";
}