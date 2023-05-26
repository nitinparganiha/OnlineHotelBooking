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

import Entity.Admin;
@WebServlet("/asignIn")
public class AdminSignIN extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String email =req.getParameter("email");
	 String name=req.getParameter("name");
	 String age=req.getParameter("age");
	 String mobile=req.getParameter("mobile");
	 String pass=req.getParameter("pass");
	 
	 int ag=Integer.parseInt(age);
	 Long mob=Long.parseLong(mobile);
	 
	 Admin a=new Admin();
	 a.setEmail(email);
	 a.setName(name);
	 a.setAge(ag);
	 a.setMobile(mob);
	 a.setPass(pass);
	 
	 EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
	 EntityManager em=emf.createEntityManager();
	 EntityTransaction et=em.getTransaction();
	 
	 et.begin();
	 em.persist(a);
	 et.commit();
	 
	 RequestDispatcher rd=req.getRequestDispatcher("Login.html");
	 rd.forward(req, resp);
}
}
