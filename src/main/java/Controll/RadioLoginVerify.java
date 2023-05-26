package Controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/rverify")
public class RadioLoginVerify extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String role=req.getParameter("rol");
	
	if(role.equals("admin")) {
		RequestDispatcher rd=req.getRequestDispatcher("adminlogin");
		rd.forward(req, resp);
	}else {
		RequestDispatcher rd=req.getRequestDispatcher("userlogin");
		rd.forward(req, resp);
	}
}
}
