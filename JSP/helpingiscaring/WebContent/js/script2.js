


	// GETTING ALL INPUT TEXT FIELDS

	var email = document.forms["vForm"]["email"];
	var password = document.forms["vForm"]["password"];


	// GETTING ALL ERROR OBJECTS
	
	var email_error = document.getElementById("email_error");
	var password_error = document.getElementById("password_error");

	// SETTING ALL EVENT LISTENERS
	password.addEventListener("blur", nameVerify, true);
	email.addEventListener("blur", emailVerify, true);

	function Validate(){
	

		// VALIDATE EMAIL
		if(email.value == ""){
			email_error.textContent = "Email is required";
			email.style.border = "1px solid red";
			email.focus();
			return false;
		}

		// VALIDATE PASSWORD
		if (password.value != password_confirmation.value) {
			password_error.textContent = "The two passwords do not match";
			password.style.border = "1px solid red";
			password_confirmation.style.border = "1px solid red";
			password.focus();
			return false;
		}

		// PASSWORD REQUIRED
		if (password.value == "" || password_confirmation.value == "") {
			password_error.textContent = "Password required";
			password.style.border = "1px solid red";
			password_confirmation.style.border = "1px solid red";
			password.focus();
			return false;
		}
	}

	// ADD EVENT LISTENERS
	function nameVerify(){
		if (fname.value != "") {
			name_error.innerHTML = "";
			fname.style.border = "1px solid #110E0F";
			return true;
		}
	}

	function emailVerify(){
		if (email.value != "") {
			email_error.innerHTML = "";
			email.style.border = "1px solid #110E0F";
			return true;
		}
	}




