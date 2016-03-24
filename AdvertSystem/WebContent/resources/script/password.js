function onLoad(){
 $("#password").keyup(passwordMatch)
 $("#confirmpass").keyup(passwordMatch);
 $("#userdetails").submit(confirmPass);
}

function confirmPass(){
	if(password!=confirmPass){
		alert('Password do not match!')
		return false;
	}
	
	return true;
}

function passwordMatch(){

var password=$("#password").val();
var confirmpass=$("#confirmpass").val();

if(password.length<3||confirmpass.length<3){
	return;
}
if(password==confirmpass){
	
	$("#matchpass").text("Password match.");
	$("#matchpass").addClass("valid");
	$("#matchpass").removeClass("error");
}
else{
	
	$("#matchpass").text("Password do not match.")
	$("#matchpass").addClass("error");
	$("#matchpass").removeClass("valid");
	}
}

$(document).ready(onLoad);