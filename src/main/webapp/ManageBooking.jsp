<%@page import="com.entity.HotelRoom"%>
<%@page import="java.util.List"%>
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
Body {
    background-image: url(ManageBooking.jpg);
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
#mid1{
    padding-top: 150px;
}
#fd3{
    color: #fff;
    font-size: 24px;
}
#fd2{
    color: #fff;
    font-size: 24px;
    padding-top: 10px;
}
#fd5{
    color: #fff;
    font-size: 24px;
    padding-top: 20px;
}
.l2{
    padding-left: 30px;
}
.l7{
    padding-left: 30px;
}

.l3{
    padding-left: 45px;
} 
.l8{
    padding-left: 30px;
}
.l4{
    padding-left: 30px;
}
.l9{
    padding-left: 30px;
}
.l5{
    padding-left: 0px;
}
.i1{
border-radius: 5px;
height: 25px;
text-align: center;
}


.l10{
    padding-left: 100px;
}
.i10{
    padding-left: 80px;
}
#i11{
    margin-left: 160px;
    width: 170px;
    height: 30px;
    font-size: 20px;
    border-radius: 20px;
    font-weight: bolder;
    background-color: orange;
}

#i11:hover{
    background-color: green;
}
</style>
</head>
<body>
<header>
        <h2 class="logo"><img src="one8-logo.png" alt=""></h2>
        <nav class="navigation">
            <a href="AdminHome.html" id="home">Home</a>
            <a href="About.html">About</a>
            <a href="Service.html">Service</a>
            <a href="Contact.html">Contact</a>
            <!-- 
            <button class="btnLogin-popup" id="btnLogin-popup">Login</button>
             -->
        </nav>
    </header>
    <div id="mid1">
<%
EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();
String b="Booked";
Query q= em.createQuery("select a from HotelRoom a where a.BookingStatus=?1");
q.setParameter(1,b);
List<HotelRoom> hotelroom =q.getResultList();

for(int i=0;i<hotelroom.size();i++){
	HotelRoom hm= hotelroom.get(i);
	%>
	<form action="notbooking" method="post" enctype='multipart/form-data'>
	                  <div id="fd3">
                            <label for="" class="l1">Room No</label>
                            <input type="text" name="roomno" value="<%=hm.getRoomNo()%>" class="i1">
                            <label for="" class="l2">Price</label>
                            <input type="text" name="price" value="<%=hm.getPrice()%>" class="i1">
                            <label for="" class="l4">Date From</label>
                            <input type="datetime" name="fromdate" value="<%=hm.getFrom()%>" class="i1">
                            <label for="" class="l3">Date to</label>
                            <input type="datetime" name="todate" value="<%=hm.getTo()%>" class="i1">
                            
                        </div>
                        <div id="fd2">
                            <label for="" class="l6">Location</label>
                            <input type="text" name="location" value="<%=hm.getLocation()%>" class="i1">
                            <label for="" class="l7">Flour</label>
                            <input type="number" name="flour" value="<%=hm.getFlour()%>" class="i1">
                            <label for="" class="l8">Count Room</label>
                            <input type="number" name="countroom" value="<%=hm.getCountroom()%>" class="i1">
                            <label for="" class="l9">Customer Email</label>
                            <input type="email" name="custemail" value="customer@gmail.com" class="i1">
                            
                        </div>
                        
                    <div id="fd5">
                    <label for="" class="l5">Hotel Name</label>
                            <input type="text" name="hotelname" value="<%=hm.getHotelName()%>" class="i1">
                        <label for="" class="l10">UnBook</label>
                        <input type="checkbox" value="NotBook" name="status"  class="i10">
                        <input type="submit" value="Update" id="i11">
                    </div>
	
	
	
	
	
	
<!-- 	
RoomNo:  <input type="text" name="roomno" value="<%=hm.getRoomNo()%>">
Price :  <input type="text" name="price" value="<%=hm.getPrice()%>">
 
Un-Book :<input type="checkbox" value="NotBook" name="status" >

Date From: <input type="datetime" name="fromdate" value="<%=hm.getFrom()%>">
Date TO: <input type="datetime" name="todate" value="<%=hm.getTo()%>">
Count room: <input type="number" name="countroom" value="<%=hm.getCountroom()%>">
Location <input type="text" name="location" value="<%=hm.getLocation()%>">
Flour: <input type="number" name="flour" value="<%=hm.getFlour()%>">
Hotel Name: <input type="text" name="hotelname" value="<%=hm.getHotelName()%>">
Customer Email: <input type="email" name="custemail" value="customer@gmail.com">
<input type="submit" value="Update">
 -->
	</form>
	<br><br>
	<%
}

%>

</div>

</body>
</html>