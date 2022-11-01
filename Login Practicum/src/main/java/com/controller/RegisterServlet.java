package com.controller;
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.*;
import com.dao.*;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	public RegisterServlet() {
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        RegisterBean registerBean = new RegisterBean();
        
        registerBean.setFullName(fullName);
        registerBean.setUserName(userName);
        registerBean.setEmail(email);
        registerBean.setPassword(password);
        
        RegisterDao registerDao = new RegisterDao();
        
        String userRegistered = registerDao.registerUser(registerBean);
        
        if (userRegistered.equals("SUCCESS")) {
        	request.getRequestDispatcher("/Home.jsp").forward(request, response);
        }
        else {
        	request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }
        
	}
}