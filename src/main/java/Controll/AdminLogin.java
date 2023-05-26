package Controll;

import java.io.IOException;
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

import Entity.Admin;
import Entity.User;
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
Query q=em.createQuery("select a from Admin a where a.email=?1 and a.pass=?2");
	
	q.setParameter(1, email);
	q.setParameter(2, pass);
	
	List<Admin> admin=q.getResultList();
	
	if(admin.size()>0){
		RequestDispatcher rd=req.getRequestDispatcher("AdminHome.html");
		rd.forward(req, resp);
	}else {
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.include(req, resp);
	}
}
}
