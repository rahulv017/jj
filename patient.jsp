<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.medical.model.Patient"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
            <% Patient pat = (Patient) session.getAttribute("currentSessionPatient");%>
			
            Welcome <%= pat.getName() + " " + pat.getAge() %>
         </center>
<a href="LogoutServlet">Logout</a>
</body>
</html>