<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="Entity.HotelRoom"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="Entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
Body {
    background-image: url(as22.jpg);
}

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

body {
    /* display: ; */
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    /* background: url(hotel10.jpg) no-repeat; */
    background-color: black;
    background-size: cover;
    background-position: center;
}

header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    padding: 20px 100px;
    background-color: transparent;
    display: flex;
    justify-content: space-between;
    align-items: center;
    z-index: 99;
    backdrop-filter: blur(10px);
}

.logo {
    font-size: 2em;
    user-select: none;
    color: #fff;
}

.logo img {
    height: 75px;
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

.navigation .btnLogin-popup {
    width: 130px;
    height: 50px;
    background: transparent;
    border: 2px solid #fff;
    outline: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 1.1em;
    color: #fff;
    font-weight: 500;
    margin-left: 40px;
    transition: 0.5s;
}

.navigation .btnLogin-popup:hover {
    background: black;
    color: #162938;
}


#booked {
   
    margin-top: 130px;
}

#hotel {
    display: flex;
    color: white;
    font-weight: bolder;
    font-size: 25px;

}

#p1 {
    margin-left: 50px;
    margin-right: 30px;
}

#p2 {
    margin-left: 30px;
    margin-right: 30px;
}

#p3 {
    margin-left: 30px;
    margin-right: 30px;
}

#p4 {
    margin-left: 30px;
    margin-right: 30px;
}

#p5 {
    margin-left: 30px;
    margin-right: 30px;
}

#p6 {
    margin-left: 30px;
    margin-right: 3px;
}

#hotel2 img {
    color: white;
    width: 50px;
    height: 50px;
    border-radius: 30px;
    margin-left: 40px;
}

#hotel2 {
    display: flex;
    color: white;
    font-weight: bolder;
    font-size: 25px;
    margin-top: 50px;
        backdrop-filter: blur(5px);
}

#btn {
    width: 30px;
    background-color: transparent;
    align-items: center;
    border-style: none;
    margin-left: 20px
    
}

#btn img {
    /* padding-right: 30px; */
    
}
#p7{
margin-left: 250px;
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
    <div id="booked">
        <div id="hotel">
            <p id="p1">Room Number</p>
            <p id="p2">Hotel Name</p>
            <p id="p3">Location</p>
            <p id="p4">Price</p>
            <p id="p5">Booking Status</p>
            <p id="p6">User name</p>
            <p id="p7">Delete</p>
        </div>
        
    
<%
HttpSession h1= request.getSession();
User u =(User)h1.getAttribute("suser");


EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();
String email=u.getEmail();
Query q=em.createQuery("Select b from HotelRoom b where b.custemail=?1");
q.setParameter(1,email);
List <HotelRoom> hr= q.getResultList();

for(int i=0;i<hr.size();i++){
	HotelRoom h2=hr.get(i);
	
	%>
	<div id="hotel2">
	<form action="cancelBooking" method="post">
            <label for="" id="p1"><%=h2.getRoomNo()%></label>
            <input type="hidden" name="roomno" value="<%=h2.getRoomNo()%>">
           <label for="" id="p2"><%=h2.getHotelName()%></label>
            <label for="" id="p3"> <%=h2.getLocation() %></label>
            <label for="" id="p4"><%=h2.getPrice() %></label>  
            <label for="" id="p5"><%=h2.getBookingStatus()%></label> 
          <label for="" id="p6"><%=h2.getCustemail()%></label>  
        <button type="submit" id="btn"><img src="Delete.png" alt=""></button>
        </form>
        </div>
	
	
	
	
	<!-- 
	<form action="cancelBooking" method="post">
	<input type="hidden" name="roomno" value="<%=h2.getRoomNo()%>">
	<label><%=h2.getCountroom() %></label>
	<label><%=h2.getHotelName() %></label>
	<label><%=h2.getLocation() %></label>
	<input type="submit" value="Cancel">
	</form>
	 -->
	
	<% 
}

%>
</div>
</body>
</html>