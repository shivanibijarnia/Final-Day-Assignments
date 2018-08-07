<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Forms-1</title>
<style type="text/css">
h1{
text-align: center;
}
</style>
</head>
<body>
<div class="container">

	<div><h1>Registration</h1></div>
	<form class="form-horizontal" action="./registration-successful.jsp" onsubmit="return validate()">
		<div class="form-group">
			<label class="control-label col-sm-2" for="firstname">Firstname:</label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="firstname" placeholder="Enter Firstname" name="firstname" value="">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="lastname">Lastname:</label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="lastname" placeholder="Enter Lastname" name="lastname" value="">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email" value="">
			</div>
		</div>
		<div class="form-group"> 
			<div class="col-sm-offset-2 col-sm-10">
			  <button type="submit" class="btn btn-default" id="submit">Register</button>
			</div>
		</div>
	</form>
	
</div>
<script type="text/javascript">
function validate(){
	var firstname = document.getElementById("firstname").value;
	var lastname = document.getElementById("lastname").value;
	var email = document.getElementById("email").value;
	var contact = document.getElementById("contact").value;
	var address = document.getElementById("address").value;
	var city = document.getElementById("city").value;
	var state = document.getElementById("state").value;
	if(!firstname){
		alert("Enter Firstname");
	}
	if(!lastname){
		alert("Enter Lastname");
	}
	if(!email){
		alert("Enter Email Id");
	}
	if(!contact){
		alert("Enter Contact Number");
	}
	if(!address){
		alert("Enter Address");
	}
	if(!city){
		alert("Enter City");
	}
	if(!state){
		alert("Choose State");
	}
	if(!firstname || !lastname || !email || !contact || !address || !city || !state){
		return false;
	}
	else{
		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
			var phoneno =  /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/; 							<!--  /^\d{10}$/;		  -->
			if(contact.match(phoneno)) {
				return true;
			}
			else {
				alert("Enter valid contact number");
				return false;
			}
		}
		else{
			alert("Enter valid email id");
			return false;
		}
	}
	
}
</script>
</body>
</html>