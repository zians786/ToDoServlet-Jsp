<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="com.bridgeit.dao.dbConnection" %>

<%
	try{
		Connection connection=dbConnection.getConnection();
		PreparedStatement statement=connection.prepareStatement("insert into registration values(?,?,?,?)");

		statement.setString(1, request.getParameter("userName"));
		statement.setString(2, request.getParameter("email"));
		statement.setString(3, request.getParameter("password"));
		statement.setString(4, request.getParameter("number"));
		
		int i=statement.executeUpdate();
		if(i>0){
			out.println("Registration Successfull");
			
		}else{
			out.println("Registration Unsuccessfull");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}catch(Exception e){
		
	}
%>


</body>
</html>