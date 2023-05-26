package Controll;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.HotelRoom;
import Entity.User;

@WebServlet("/userbookhotel")
public class UserBooking extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String roomno=req.getParameter("roomno");
		String book=req.getParameter("status");
		String datefrom=req.getParameter("fromdate");
		String dateto=req.getParameter("todate");

		
		int rmno=Integer.parseInt(roomno);
		Date f=Date.valueOf(datefrom);
		Date t=Date.valueOf(dateto);
		
		System.out.println(book);
		HttpSession h1=req.getSession();
		User u=(User) (h1.getAttribute("suser"));

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select a from HotelRoom a where a.RoomNo=?1");
		q.setParameter(1, rmno);
		List<HotelRoom>horom=q.getResultList();
		HotelRoom hotrm= horom.get(0);
		HotelRoom hm=new HotelRoom();
		hm.setRoomNo(rmno);
		hm.setPrice(hotrm.getPrice());
		hm.setBookingStatus(book);
		hm.setFrom(f);
		hm.setTo(t);
		hm.setCountroom(hotrm.getCountroom());
		hm.setLocation(hotrm.getLocation());
		hm.setFlour(hotrm.getFlour());
		hm.setHotelName(hotrm.getHotelName());
		hm.setCustemail(u.getEmail());
		hm.setImg1(hotrm.getImg1());
		hm.setImg2(hotrm.getImg2());
		hm.setImg3(hotrm.getImg3());
		
		
		
		System.out.println(hotrm.getImg1());
		System.out.println(hotrm.getImg2());
		System.out.println(hotrm.getImg3());
		
		
		et.begin();
		em.merge(hm);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Userhome.html");
		rd.forward(req, resp);
	}
}
