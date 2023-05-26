package Controll;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.Query;

import Entity.HotelRoom;
@MultipartConfig
@WebServlet("/notbooking")
public class NotbookingStatus extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String roomno = req.getParameter("roomno");
	String price = req.getParameter("price");
    String bstatus = req.getParameter("status");

	String datef = req.getParameter("fromdate");
	String datet = req.getParameter("todate");

	String countroom = req.getParameter("countroom");
	String location = req.getParameter("location");
	String flour = req.getParameter("flour");
	String hotelname = req.getParameter("hotelname");
	String custemail = req.getParameter("custemail");
	
	int rumno = Integer.parseInt(roomno);
	double rprice = Double.parseDouble(price);
	int countrum = Integer.parseInt(countroom);
	int flor = Integer.parseInt(flour);
	Date  f=Date.valueOf(datef);
	Date t= Date.valueOf(datet);

	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Nitin");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Query q=em.createQuery("select a from HotelRoom a where a.RoomNo=?1");
	q.setParameter(1, rumno);
	List<HotelRoom>horom=q.getResultList();
	HotelRoom hotrm= horom.get(0);
	
	HotelRoom hm = new HotelRoom();
	hm.setRoomNo(rumno);
	hm.setPrice(rprice);
	hm.setBookingStatus(bstatus);
	hm.setFrom(f);
	hm.setTo(t);
	hm.setCountroom(countrum);
	hm.setLocation(location);
	hm.setFlour(flor);
	hm.setHotelName(hotelname);
	hm.setCustemail(custemail);
	hm.setImg1(hotrm.getImg1());
	hm.setImg2(hotrm.getImg2());
	hm.setImg3(hotrm.getImg3());
	
	et.begin();
	em.merge(hm);
	et.commit();
	
	RequestDispatcher rd= req.getRequestDispatcher("ManageBooking.jsp");
	rd.forward(req, resp);
}
}
