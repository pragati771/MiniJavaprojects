package com.app.pages;

import static com.app.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class SignupServlet
 */
//@WebServlet("/voter_register")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	
	

	@Override
	public void init() throws ServletException {
		try {
			ServletConfig config = getServletConfig();

			openConnection(config.getInitParameter("db_url"),
					config.getInitParameter("user_name"),
					config.getInitParameter("password"));
			userDao = new UserDaoImpl();

		}catch(Exception e) {
			throw new ServletException("err in init - " + getClass(), e);

		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session=request.getSession();
			String firstname=request.getParameter("fn");
			String lastname=request.getParameter("ln");
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			LocalDate dobirth=LocalDate.parse(request.getParameter("dob"));
			int age=Period.between(dobirth, LocalDate.now()).getYears();
			if(age>=21) {
			User user=new User(firstname,lastname,email,password,Date.valueOf(dobirth));
			String s=userDao.voterRegistration(user);
			pw.print("<h5>"+s+"</h5>");
			// discard the session
			session.invalidate();
			pw.print("<h4> proceed to <a href='login.html'>Login</a></h4>");

			}
			
			else {
				pw.print("<h4>registration failed!!</h4>");
				pw.print("<h4> proceed to <a href='voter_registration.html'>Registration page</a></h4>");

			}
		//	pw.print("<h5>"+s+"</h5>");
		//	response.sendRedirect("login");	


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException("err in servicing " + getClass(), e);

		}

	}

}
