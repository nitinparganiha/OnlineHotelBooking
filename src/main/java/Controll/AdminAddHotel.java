package Controll;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
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
import javax.servlet.http.Part;

import Entity.HotelRoom;
@MultipartConfig
@WebServlet("/adminaddroom")
public class AdminAddHotel extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Image
		
		Part file= req.getPart("image1");
		String imagefilename= file.getSubmittedFileName();
		System.out.println(imagefilename);
		String uploadpath="C:/Users/nitin/eclipse-workspace/Hotel/src/main/webapp/"+imagefilename;
		try {
			FileOutputStream fo=new  FileOutputStream(uploadpath);
		    InputStream is=file.getInputStream();
			
		    byte[] data=new byte[is.available()];
		    is.read(data);
		    fo.write(data);
		    fo.close();
		}catch (Exception e) {
	        e.printStackTrace();
		}
		
		Part file1= req.getPart("image2");
		String imagefilename1= file1.getSubmittedFileName();
		System.out.println(imagefilename1);
		String uploadpath1="C:/Users/nitin/eclipse-workspace/Hotel/src/main/webapp/"+imagefilename1;
		try {
			FileOutputStream fo1=new  FileOutputStream(uploadpath1);
		    InputStream is1=file1.getInputStream();
			
		    byte[] data1=new byte[is1.available()];
		    is1.read(data1);
		    fo1.write(data1);
		    fo1.close();
		}catch (Exception e) {
	        e.printStackTrace();
		}
		
		
		Part file2= req.getPart("image3");
		String imagefilename2= file2.getSubmittedFileName();
		System.out.println(imagefilename2);
		String uploadpath2="C:/Users/nitin/eclipse-workspace/Hotel/src/main/webapp/"+imagefilename2;
		try {
			FileOutputStream fo2=new  FileOutputStream(uploadpath2);
		    InputStream is2=file2.getInputStream();
			
		    byte[] data2=new byte[is2.available()];
		    is2.read(data2);
		    fo2.write(data2);
		    fo2.close();
		}catch (Exception e) {
	        e.printStackTrace();
		}
		System.out.println(imagefilename);
		System.out.println(imagefilename1);
		System.out.println(imagefilename2);

		String roomno = req.getParameter("roomno");
		String price = req.getParameter("price");


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
		
//		Image
		
		String nb="NotBook";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Nitin");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		HotelRoom hm = new HotelRoom();
		hm.setRoomNo(rumno);
		hm.setBookingStatus(nb);
		hm.setPrice(rprice);
		hm.setFrom(f);
		hm.setTo(t);
		hm.setCountroom(countrum);
		hm.setLocation(location);
		hm.setFlour(flor);
		hm.setHotelName(hotelname);
		hm.setCustemail(custemail);
		hm.setImg1(imagefilename);
		hm.setImg2(imagefilename1);
		hm.setImg3(imagefilename2);
		et.begin();
		em.merge(hm);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("AdminHome.html");
		rd.forward(req, resp);
	}
}
