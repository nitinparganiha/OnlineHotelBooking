<%@page import="com.entity.NewAddImage"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.*"%>
<%@page import="com.entity.Image"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.img{
height: 100px;
width: 100px;
}
</style>
</head>
<body>
<% 

EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();

NewAddImage nimage= new NewAddImage();

out.print(nimage.getImg1());

String img2="Screenshot(13).png";

Class.forName("com.mysql.cj.jdbc.Driver");
Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","1234");
Statement st= co.createStatement();
ResultSet rs=st.executeQuery("select * from hotelbooking.newaddimage");
while(rs.next()){
	String imgname=rs.getString(2);
	String imgname1=rs.getString(3);
	String imgname2=rs.getString(4);
	
	%>
    <%=nimage.getId() %>
	<img alt="" class="img" src="<%=nimage.getImg1()%>">
	<img alt="" class="img" src="<%=imgname%>">
	<img alt="" class="img" src="<%=imgname1%>">
	<img alt="" class="img" src="<%=imgname2%>">
<%
}
%>
</body>
</html>