package Controll;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.HotelRoom;

import javax.persistence.*;
@WebServlet("/cancelBooking")
public class CnacelBooking extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String roomno=req.getParameter("roomno");
	  int romno=Integer.parseInt(roomno);
	  
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
	  EntityManager em=emf.createEntityManager();
	  EntityTransaction et=em.getTransaction();
	  
	  Query q=em.createQuery("select a from HotelRoom a where  a.RoomNo=?1");	
	  q.setParameter(1, romno);
	  List<HotelRoom> h1=q.getResultList();
	  HotelRoom h2=h1.get(0);
	  HotelRoom h3=new HotelRoom();
	  h3.setRoomNo(romno);
	  h3.setBookingStatus("NotBook");
	  h3.setHotelName(h2.getHotelName());
	  h3.setFrom(h2.getFrom());
	  h3.setTo(h2.getTo());
	  h3.setCountroom(h2.getCountroom());
	  h3.setCustemail("customer@gmail.com");
	  h3.setFlour(h2.getFlour());
	  h3.setLocation(h2.getLocation());
	  h3.setPrice(h2.getPrice());
	  h3.setImg1(h2.getImg1());
	  h3.setImg2(h2.getImg2());
	  h3.setImg3(h2.getImg3());
	  
	  et.begin();
	  em.merge(h3);
	  et.commit();
	  
	  RequestDispatcher  rd=req.getRequestDispatcher("CancelBooking.jsp");
	  rd.forward(req, resp);
	  
}
}
