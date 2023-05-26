package Controll;

import java.io.IOException;

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

import Entity.User;
@WebServlet("/usingn")
public class UserSignIn extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String name=req.getParameter("name");
	String age=req.getParameter("age");
	String mobile=req.getParameter("mobile");
	String pass=req.getParameter("pass");
	int ag=Integer.parseInt(age);
	long mob=Long.parseLong(mobile);

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	User u=new User();
	u.setEmail(email);
	u.setName(name);
	u.setAge(ag);
	u.setMobile(mob);
	u.setPass(pass);
	
	et.begin();
	em.persist(u);;
	et.commit();
	
	RequestDispatcher rd=req.getRequestDispatcher("SigninLogin.html");
	rd.forward(req, resp);
}
}
