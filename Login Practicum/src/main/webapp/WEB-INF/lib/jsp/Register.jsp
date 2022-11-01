<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="author" content="Tyler Mckenzie">
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./stuff.css">
<title>Insert title here</title>
<script>
function validate() {
	var fullname = document.form.fullname.value;
	var username = document.form.username.value;
	var email = document.form.email.value;
	var password = document.form.password.value;
	var repassword = document.form.repassword.value;
	
    if (fullname==null || fullname=="")
    { 
    alert("Full Name can't be blank"); 
    return false; 
    }
    else if (email==null || email=="")
    { 
    alert("Email can't be blank"); 
    return false; 
    }
    else if (username==null || username=="")
    { 
    alert("Username can't be blank"); 
    return false; 
    }
    else if(password.length<6)
    { 
    alert("Password must be at least 6 characters long."); 
    return false; 
    } 
    else if (password!=repassword)
    { 
    alert("Re-entered Password should match with the Password"); 
    return false; 
    }
}
</script>
</head>
<body>
<h1 align="center">Registration</h1>
<h3 class="space">Please fill in the information below</h3>
<form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
<table class="space">
<tr>
<th> Full Name: </th>
 	<td>
 		<input type="text" id="fullname" placeholder="" size="20" maxlength="20"> 
 	</td>
</tr>
<tr>
<th> User Name: </th>
 	<td>
 		<input type="text" id="username" placeholder="" size="20" maxlength="20"> 
 	</td>
</tr>
<tr>
<th> Email: </th>
	 <td>
 		<input type="email" id="email" placeholder="" size="20" maxlength="20"> 
 	</td>
</tr>
<tr>
<th> Password: </th>
 	<td>
 		<input type="password" id="password" placeholder="" size="20" maxlength="20"> 
 	</td>
</tr>
<tr>
<th> Re-enter Password: </th>
 	<td>
 		<input type="password" id="repassword" placeholder="" size="20" maxlength="20"> 
 	</td>
</tr>
<tr>
  <td><%=(request.getAttribute("errMessage") == null) ? ""
     : request.getAttribute("errMessage")%></td>
</tr>
</table>
</form>
<div class="space">
	<input type="submit" id="button" value="Register"></input>
	<input type="reset" id="button" value="Clear"></input>
</div>
</body>
</html>