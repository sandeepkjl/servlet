<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    
<%@ page import="org.example.servlet.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>

<h1> UserInfo</h1>
<table border="2px">
<tr>
<th>UserId</th>  <th>Password</th>  <th> UserName</th> <th>Address</th> 
</tr>


 
<% User user =  
            (User)request.getAttribute("user"); %> 
        
          <tr>
                <td> ${ user.getUserId() }</td> 
                <td>${  user.getPassword() }</td> 
                
               
                <td>${  user.getUsername() }</td>
                 <td>${  user.getUserAddress() }</td>
                
                </tr> 
 
</table>

</br>
</br>



<a href="${pageContext.request.contextPath}/salary.jsp" > Click Here User's Details Salary </a>

</body>
</html>