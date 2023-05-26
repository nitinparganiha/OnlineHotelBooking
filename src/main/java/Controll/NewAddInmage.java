package Controll;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Entity.NewAddImage;
@MultipartConfig
@WebServlet("/newAddimage")
public class NewAddInmage extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		int idd=Integer.parseInt(id);
		
		
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
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Nitin");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		NewAddImage nwi=new NewAddImage();
		nwi.setId(idd);
		nwi.setImg1(imagefilename);
		nwi.setImg2(imagefilename1);
		nwi.setImg3(imagefilename2);
		et.begin();
		em.persist(nwi);
		et.commit();
	}
}
