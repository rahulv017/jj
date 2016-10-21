<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signup</title>
 
</head>
<body>
<form action="PatSignupServlet" method="post">
ID:<input type="text" name="id"><br>  
Name:<input type="text" name="name"><br> 
Gender:<input type="text" name="gender"><br>  
Email_id:<input type="text" name="email_id"><br>  
Address:<input type="text" name="address"><br>    
Age:<input type="text" name="age"><br>  
Phone_no:<input type="text" name="phone_no"><br>  
Password:<input type="password" name="password"><br> 
Confirm Password:<input type="password" name="confirm_password"><br>
<%
String signup_msg=(String)request.getAttribute("error");  
if(signup_msg!=null)
out.println("<font color=red size=4px>"+signup_msg+"</font>");
%><br>
<input type="submit" value="signup">  
</form> 
</body>
</html>