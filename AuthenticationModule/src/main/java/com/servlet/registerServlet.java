package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.entities.User;
import com.entities.Message;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("uname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDAO dao=new UserDAO(DBConnect.getConnection());
		boolean f=dao.registerUser(user);
		
		if(f) {
			Message msg=new Message("Congrats! Registration successful...","alert-success");
			HttpSession session=request.getSession();
			session.setAttribute("msg",msg);
			response.sendRedirect("register.jsp");
		}else {
			Message msg=new Message("Opps! Something went wrong...","alert-danger");
			HttpSession session=request.getSession();
			session.setAttribute("msg",msg);
			response.sendRedirect("register.jsp");
		}
	}

}
