package Controll;

import java.io.IOException;
import java.util.List;

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
import javax.servlet.http.HttpSession;

import Entity.User;

import javax.persistence.Query;
@WebServlet("/userlogin")
public class UserLogin extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nitin");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Query q=em.createQuery("select a from User a where a.email=?1 and a.pass=?2");
	
	q.setParameter(1, email);
	q.setParameter(2, pass);
	
	List<User> user=q.getResultList();
	
	if(user.size()>0){
		User u=user.get(0);
		HttpSession h1=req.getSession();
		h1.setAttribute("suser", u);
		RequestDispatcher rd=req.getRequestDispatcher("Userhome.html");
		rd.forward(req, resp);
	}else {
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.include(req, resp);
	}
}
}
