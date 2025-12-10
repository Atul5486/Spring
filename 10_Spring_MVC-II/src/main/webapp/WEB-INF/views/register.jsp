<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function submitHandler(e){
		e.preventDefault();
		let username=document.getElementById("username");
		let email=document.getElementById("email");
		let password=document.getElementById("password");
		let genderObj=document.querySelector("input[name='gender']:checked");
		let gender=genderObj ? genderObj.value:"" ;
		let hobbiesObj=document.querySelector("input[name='hobbies']:checked");
		let hobbies=hobbiesObj ? [...hobbiesObj].map((hobby)=>hobby.value).join(","):"";
		let subject=document.querySelector("subject").value;
		
		let obj={username,email,password,gender,hobbies,subject};
		
		fetch("<%=request.getContextPath()%>/registerData",
		method:'POST',
		headers:{
			'content-type':'appication/json';
		}
		body:JSON.Strinfigy(obj);
		).then((res)=>{
			res.json();
		}).then((data)=>{
			console.log("Data ----->\n",data);
			
			let fields=["username","email","password","hobbies","subject"];
			
			fields.forEach((field)=>{
				document.getElementById("err_"+field).innerHTML="";
			})
			
			if(data.field){
				doucment.getElementById("err_"+data.field).innerHTML=data.message;
			}
			if(data.status===201){
				window.location.href="<%= request.getContextPath()%>/login";
			}
		}).catch((err)=>{
			console.log("Error Occured\n"+err.message);
		})
	}

</script> 
</head>
<body>
	<blockquote>
		<h2>Example of Spring MVC</h2>
		<jsp:include page="header.jsp"></jsp:include>
		<h2>Registration Form</h2>
		<form:form modelAttribute="user">
			<form:input type="text" placeholder="Enter Username" id="username" path="username"/>
			<span class="error_message" id="err_username"></span> <br>

			<form:input type="email" placeholder="Enter Email" id="email" path="email"/>
			<span class="error_message" id="err_email"></span> <br>
			
			<form:password placeholder="Enter Password" id="password" path="password"/>
			<span class="error_message" id="err_password"></span> <br>
			
			<form:radiobutton id="male" value="male" path="gender"/>Male
			<form:radiobutton id="female" value="female" path="gender"/>Female
			<span class="error_message" id="err_gender"></span> <br>
			
			<form:checkbox id="cricket" value="Cricket" path="hobbies"/>Cricket
			<form:checkbox id="football" value="Football" path="hobbies"/>Football
			<span class="error_message" id="err_hobbies"></span> <br>
			
			<form:select id="subject" path="subject">
				<form:option value="">Select Subject</form:option>
				<form:option value="C Language">C Language</form:option>
				<form:option value="Java">Java</form:option>
				<form:option value="Python">Python</form:option>
				<form:option value="React js">React js</form:option>
			</form:select>
			<span class="error_message" id="err_subject"></span> <br>
			
			<button type="button" onclick="submitHandler(event)">Register</button>
			<button type="reset">Reset</button>

		</form:form>
	</blockquote>
</body>
</html>