package com.app.pages;

import static com.app.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.entities.Candidate;

/**
 * Servlet implementation class GetTotalVotes
 */
//@WebServlet("/GetTotalV")
public class GetTotalVotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CandidateDaoImpl candidateDao;
	   
	@Override
	public void init() throws ServletException {
		try {
			ServletConfig config = getServletConfig();

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
			pw.print("<h1> Candidates and total votes are</h1>");
			Map<String, Integer> mymap=dao.getPartyWiseVotes();
			for (Entry<String, Integer> entry : mymap.entrySet())  
	            pw.print("<h2>Party:" + entry.getKey() + 
	                             ", TotalVotes = " + entry.getValue()+"</h2><br>"); 
			//pw.print("<h2>"+mymap+"</h2>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}


