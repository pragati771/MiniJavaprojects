package com.app.pages;

import static com.app.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class AdminServlet
 */
//@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidateDaoImpl candidateDao;
   
	@Override
	public void init() throws ServletException {
		try {
			ServletConfig config = getServletConfig();
			
			//User user = (User) hs.getAttribute("user_info");
			openConnection(config.getInitParameter("db_url"),
					config.getInitParameter("user_name"),
					config.getInitParameter("password"));
			candidateDao=new CandidateDaoImpl();

		}catch(Exception e) {
			throw new ServletException("err in init - " + getClass(), e);

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			HttpSession session=request.getSession();
			CandidateDaoImpl dao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
			pw.print("<h3> Welcome!! back admin</h3>");
			
			pw.print("<h4><a href='GetTop'>Get Top 2 Candidates</a></h4>");
			pw.print("<h4><a href='GetTotalV'>Get party wise votes</a></h4>");
			
			pw.print("<h3><a href='logout'>Logout</h3>");
			
		}
		
	}

	

}
