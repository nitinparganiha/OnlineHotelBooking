<%@page import="com.entity.HotelRoom"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            /* background: url(hotel10.jpg) no-repeat; */
            background-color: black;
            background-size: cover;
            background-position: center;
            margin-top: 45px;
        }

        header {
            position: fixed;
            
            backdrop-filter: blur(10px);
            top: 0;
            left: 0;
            width: 100%;
            padding: 30px 300px;
            /* background-color: rgb(240, 109, 83); */
            display: flex;
            justify-content: space-between;
            align-items: center;
            z-index: 99;
        }

        .logo {
            font-size: 2em;
            user-select: none;
            color: #fff;
        }

        .navigation a {
            position: relative;
            font-size: 1.1em;
            color: #fff;
            text-decoration: none;
            font-weight: 500;
            margin-left: 40px;
        }

        .navigation a::after {
            content: '';
            position: absolute;
            left: 0;
            bottom: -6px;
            width: 100%;
            height: 3px;
            background: #fff;
            border-radius: 5px;
            transform: scaleX(0);
            transition: 0.5s;
        }

        .navigation a:hover:after {
            transform-origin: left;
            transform: scaleX(1);
        }
        
        #img{
        display:flex;
         width: 100%
         }
         #img img{
         width: 500px;
         }
         .d1{
         color: white;
         font-size: 24px;
         margin-left: 100px
         }
         .d2{
         color: white;
         font-size: 24px;
         margin-left: 10px;
         }
         .p1{
         color: white;
         font-size: 24px;
         margin-left: 165px
         }
        .c1{
         color: white;
         font-size: 24px;
         margin-left: 178px
         }
         

</style>
</head>
<body>

<header>
        <h2 class="logo"><img src="one8-logo.png" alt=""></h2>
        <nav class="navigation">
            <a href="Userhome.html" id="home">Home</a>
            <a href="About.html">About</a>
            <a href="Service.html">Service</a>
            <a href="Contact.html">Contact</a>
            <!-- 
            <button class="btnLogin-popup" id="btnLogin-popup">Login</button>
             -->
        </nav>
    </header>
    
<%
HttpSession h=request.getSession();
 User u=(User) (h.getAttribute("suser"));
 
 String email=u.getEmail();

EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
EntityManager  em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();

Query q=em.createQuery("select a from HotelRoom a where a.custemail=?1");
q.setParameter(1,email);

List<HotelRoom>hm=q.getResultList();

for(int i=0;i<hm.size();i++){
	HotelRoom hm1=hm.get(i);
	%>
	<form action="">
	<div id="img">
	<img alt="" src="<%=hm1.getImg1()%>">
	<img alt="" src="<%=hm1.getImg2()%>">
	<img alt="" src="<%=hm1.getImg3()%>">
	</div>
	
	<div>
	<label for="" class="d1">Room Number</label>
	<label for="" class="d2"><%=hm1.getRoomNo()%></label>
	<label for="" class="p1">Price</label>
	<label for="" class="d2"><%=hm1.getPrice() %></label>
	<label for="" class="c1">Count Room</label>
    <label for="" class="d2"><%=hm1.getCountroom() %></label>
    <label for="" class="d1">Flour</label>
	<label for="" class="d2"> <%=hm1.getFlour() %></label>
	</div>
	
	<div>
	<label for="" class="d1">Date From</label>
    <label for="" class="d2"><%=hm1.getFrom() %></label>
    <label for="" class="d1">Date To</label>
    <label for="" class="d2"><%=hm1.getTo() %></label>
    <label for="" class="d1">Location</label>
	<label for="" class="d2"> <%=hm1.getLocation() %></label>
	<label for="" class="d1">Hotel Name</label>
	<label for="" class="d2"> <%=hm1.getHotelName() %></label>
	</div>
	<br><br>
	<hr>
	</form>
<%	
}
%>
</body>
</html>