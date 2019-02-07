package org.example.servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.servlet.model.User;
import org.example.servlet.repository.ServletLogInRepsiotry;

/**
 * Servlet implementation class LogInServlet
 */
//@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ServletLogInRepsiotry databaseRepository=null;
	Connection con=null;
	
	
   
    public LogInServlet() {
        super();
        
    }
    
    
    
    

	@Override
	public void init() throws ServletException {
		
		String dburl= getServletContext().getInitParameter("dburl");

		String dbname=this.getInitParameter("databasename");
;
		String dbpwd= getServletConfig().getInitParameter("databasepwd");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			con = DriverManager.getConnection(dburl, dbname,dbpwd);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		
	 
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("uname");
		String password= request.getParameter("pwd");
		
		databaseRepository = new ServletLogInRepsiotry();
		User usr = databaseRepository.getUserfromDataBase(con, userName, password);
		
		
		request.setAttribute("user", usr);
		
		RequestDispatcher requestDispatcher = null;
		
		if(usr!=null)
		{
			requestDispatcher = request.getRequestDispatcher("success.jsp");
			requestDispatcher.forward(request, response);
			
		}
		else{
			requestDispatcher = request.getRequestDispatcher("error.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}
}
