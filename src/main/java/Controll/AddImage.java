package Controll;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig
@WebServlet("/addImage")
public class AddImage extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	System.out.println("yes ");
	Part file= req.getPart("imgs");
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
	
	Part file1= req.getPart("imgs1");
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
	
	
	Part file2= req.getPart("imgs2");
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
	
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","1234");
		PreparedStatement ps=con.prepareStatement("insert into hotelbooking.addimage(addimagename,addimagename2,addimagename3) values(?,?,?)");
		ps.setString(1, imagefilename);
		ps.setString(2,imagefilename1);
		ps.setNString(3, imagefilename2);
		ps.execute();
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
