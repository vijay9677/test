/**
 *@author krunal and Sunil 
 */
			//  form validation
			//validation for first name
	
	 $("#fname").on("blur",function(){
		 alert("sdfsd");
		var val= $(this).val();
		var reg = new RegExp(/^[a-zA-Z]+$/);
		if(reg.test(val)){
			$("#fname-msg").html("Valid");

			$('#fname-msg').css("color","green");
		}
		else{
			$('#fname-msg').html("invalid");
			$('#fname-msg').css("color","red");
			
		}
		
	 });
	 
	 $("#lname").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-zA-Z]+$/);
		if(reg.test(val)){
			$("#lname-msg").html("Valid");

			$('#lname-msg').css("color","green");
		}
		else{
			$('#lname-msg').html("invalid");
			$('#lname-msg').css("color","red");
			
		}
		
	 });
	 
	 
	 
		 $("#email").on("blur",function(){
				var val= $(this).val();
				var emailreg = new RegExp(/^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/);
				if(emailreg.test(val)){
					$("#email-msg").html("Valid");
					$('#email-msg').css("color","green");
				}
				else{
					$('#email-msg').html("Please enter valid email");
					$('#email-msg').css("color","red");
					
				}
				
			 });
		 $("#pwd").on("blur",function(){
				var val= $(this).val();
				if(val==''){
					$("#password-msg").html("Please fill it");
					$('#password-msg').css("color","red");
				}
			 });
		 $("#repwd").on("blur",function(){
				var val= $(this).val();
				var pwd=$('#pwd').val();
				if(val==''){
					$("#repassword-msg").html("Please fill it");
					$('#repassword-msg').css("color","red");
				} 
				if(!pwd.match(val)){
					$("#repassword-msg").html("Please enter Same Password");
					$('#repassword-msg').css("color","red");
				}
			 });
		 $("#mobileno").on("blur",function(){
				var val= $(this).val();
				var mobilereg = new RegExp(/^[789]\d{9}$/);
				if(val==''){
					$("#mobile-msg").html("Please fill it");
					$('#mobile-msg').css("color","red");
				}
				if(!mobilereg.match(val)){
					$("#mobile-msg").html("Please Enter Valid Mobile no	");
					$('#mobile-msg').css("color","red");
				}
			 });
		
			
