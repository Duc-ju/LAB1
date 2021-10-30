const submit_button = document.getElementById("signup");
const errorMessage = document.getElementById("error-message");
submit_button.onclick = (e)=>{
	let pass = document.getElementById("pass");
	let rePass = document.getElementById("re_pass");
	let name = document.getElementById("name");
	let agree = document.getElementById("agree-term");
	if(name.value.length < 3){
		errorMessage.innerHTML="Your name must have at least 3 characters";
		e.preventDefault()
		return
	}
	if(pass.value!=rePass.value){
		errorMessage.innerHTML="Password and re-pass are different"
		e.preventDefault()
		return
	}
	if(pass.value.length < 8){
		errorMessage.innerHTML="Your password must be at least 8 characters";
		e.preventDefault()
		return
	}
	if(agree.checked == false){
		errorMessage.innerHTML="Read all statements in Terms of service and agree by checking to the box";
		e.preventDefault()
		return
	}
}