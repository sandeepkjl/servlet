<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="org.example.servlet.model.UserSalary" %>
<%@ page import="org.example.servlet.model.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>User Salary Details:-</h2>

<div>

<% 
ServletContext context=request.getServletContext();
UserSalary usrSal = (UserSalary)context.getAttribute("usrSalary");
%>

</br>
UserId:-  <%=usrSal.getUserId() %></br>

Basic:-  <%= usrSal.getBasic() %></br>

HomeAndRentAllowances :- <%=usrSal.getHra() %></br>

Bonus:- <%=usrSal.getBonus() %> </br>

PF :- <%= usrSal.getPf() %></br>

Gratuity:- <%= usrSal.getGratuity() %></br>

VariablePay:- <%= usrSal.getVariablePay() %></br>

Medical:- <%= usrSal.getMedical()  %></br>

</br>
</br>

<b>TOTAl SUM </b>:- <%= usrSal.getBasic()+ usrSal.getHra()+ usrSal.getBonus()+ usrSal.getPf()
+usrSal.getGratuity()+usrSal.getVariablePay()+usrSal.getMedical() %>

</div>


</body>
</html>