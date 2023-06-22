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
import com.entities.Message;
import com.entities.User;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserDAO dao=new UserDAO(DBConnect.getConnection());
		User user =dao.loginUser(email,password);
		HttpSession session=request.getSession();
		if(user!=null) {
			
			session.setAttribute("user-obj",user);
			response.sendRedirect("home.jsp");
		}else {
			Message message=new Message("Email or Password is Incorrect","alert-warning");
			session.setAttribute("msg",message);
			response.sendRedirect("login.jsp");
		}
		
	}

}
