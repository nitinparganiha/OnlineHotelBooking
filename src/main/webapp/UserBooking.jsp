<%@page import="Entity.NewAddImage"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="Entity.User"%>
<%@page import="Entity.HotelRoom"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.*"%>
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
<title>BOOK HOTEL</title>

    <style>
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

        #first {
            background-color: blue;
            border: 5px solid rgb(189, 16, 137);
            width: 1508px;
            height: 60px;
            /* position: absolute; */
            margin-bottom: 925px;
            /* position: relative; */
        }

        #body {
            border: 5px solid white;
            margin-top: 49px;

        }

        #second {
            border: 5px solid green;
            height: 490px;
            width: 1500px;
        }

        #second img {
            width: 493px;
            height: 350px;
            
        }

        #detail {
            border: 5px solid red;
            color: wheat;
        }
        .d1{
            margin-left: 150px;
            height: 30px;
            font-weight: bolder;
            font-size: 25px;
            color: white;
        }
        .d2{
            height: 30px;
            border-radius: 30px;
            border:2px solid green;

        }
        .d3{
            margin-left: 0px;
            height: 30px;
            font-weight: bolder;
            font-size: 25px;
        }
        .d4{
        color: white;
        font-size: 25px;
        margin-left: 30px;
        }
        .d5{
        margin-left: 290px;
        color: white;
        font-size: 25px;
        font-weight: bolder;
        }
        
        .d6{
        margin-left: 250px;
        width: 80px;
        height: 40px;
        border-radius:10px;
        font-size: 25px;
        border: 2px solid green;
        color:green;
        }
        .d6:hover{
        color:orange;
        }
        #hotelname{
        margin-left: 265px;
        }
        #flour{
        margin-left: 205px;
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
        </nav>
    </header>
<%
EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();
String book="NotBook";
Query q= em.createQuery("select a from HotelRoom a where a.BookingStatus='"+book+"'");
List<HotelRoom> hotelroom=q.getResultList();

for(int i=0;i<hotelroom.size();i++){
	HotelRoom hm=hotelroom.get(i);
%>
    <!-- <div id="first">
    </div> -->
    <div id="body">
        <div id="second">

            
                <form action="userbookhotel" method="post">
                                     <input type="hidden" name="roomno" value="<%=hm.getRoomNo()%>"> 
            <img src="<%=hm.getImg1()%>" alt="">
            <img src="<%=hm.getImg2()%>" alt="">
            <img src="<%=hm.getImg3()%>" alt="">
                    <div>
                    <label for="" class="d1">DATE FROM</label>
                    <input type="datetime" class="d2" name="fromdate" placeholder="0000-00-00">
                    <label for="" class="d1">DATE TO</label>
                    <input type="datetime" class="d2" name="todate" placeholder="0000-00-00">
                    <label for="" class="d1">COUNT OF ROOM</label>
                    <label for="" class="d4"><%=hm.getCountroom()%></label>
                </div>
                <div>
                    <label for="" class="d1">LOCATION</label>
                   <label for="" class="d4"> <%=hm.getLocation()%></label>
                    <label for="" class="d1" id="hotelname">HOTEL NAME</label>
                    <label for="" class="d4"> <%=hm.getHotelName()%></label>
                    <label for="" class="d1" id="flour">FLOUR</label>
                     <label for="" class="d4"><%=hm.getFlour()%></label>
                </div>
                <div>
                <label for="" class="d1">PRICE</label>
                <label for="" class="d4"><%=hm.getPrice()%></label>
                <label for="" class="d5">Check For Book</label>
                    <input type="checkbox" class="d2" name="status" value="Booked">
                    <input type="submit" class="d6" value="Book">
                    </div>
                    
                </form>

        </div>
        
        

  <%
}
%>
    </div>


</body>
</html>