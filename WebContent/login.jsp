<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<%@page import="com.bridgeit.service.*"%>
<%@page import="com.bridgeit.model.*"%>

<jsp:useBean id="object" class="com.bridgeit.model.User"/>
<jsp:useBean id="service" class="com.bridgeit.service.ServiceImp"/>
<jsp:setProperty property="*" name="object"/>
<% 
	
	boolean status=service.serviceLoginValidate(object);
if(status){
	out.println("Login Successful");
	session=request.getSession();
	session.setAttribute("userName",object.getUserName());
	%><jsp:forward page="dashboard.jsp"></jsp:forward><%
	
}

else{
	out.print("Login Unsuccessful");
	%>
	<jsp:include page="index.jsp"></jsp:include><%
}
%>	
</body>
</html>