package Controll;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
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
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import Entity.Image;

@MultipartConfig(location = "D:\\images", maxFileSize = 1400 * 900, fileSizeThreshold = 1400
		* 900, maxRequestSize = 1400 * 900)
@WebServlet("/image")
public class Imageupload extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i = req.getParameter("id");
		System.out.println(i);
		int idd = Integer.parseInt(i);
		Part p = req.getPart("imgs");
		InputStream is = p.getInputStream();
		byte[] contents = new byte[is.available()];

		try {
			Blob b = new SerialBlob(contents);
			is.read(contents);
			System.out.println(p);
			System.out.println(is);
			System.out.println(is);
			System.out.println(is);
			System.out.println();

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Nitin");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();

			Image im = new Image();

			im.setId(idd);
			im.setImage(b);

			et.begin();
			em.persist(im);
			et.commit();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Image uploaded");
		RequestDispatcher rd= req.getRequestDispatcher("DisplayImage.jsp");
		rd.forward(req, resp);
		
	}
}
