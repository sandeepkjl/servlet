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
import javax.servlet.http.HttpSession;

import org.example.servlet.model.User;
import org.example.servlet.model.UserSalary;
import org.example.servlet.repository.ServletLogInRepsiotry;

/**
 * Servlet implementation class LogInServlet
 */
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
		
		String userId = request.getParameter("uname");
		String password= request.getParameter("pwd");
		
		//maintaining seesion
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", userId);
		session.setAttribute("password", password);
		
		
		//fetching userRecord from database
		databaseRepository = new ServletLogInRepsiotry();
		User usr = databaseRepository.getUserfromDataBase(con, userId, password);
		
		RequestDispatcher requestDispatcher = null;
		
		ServletContext context = request.getServletContext();
		
		//if user exist
		if(usr!=null)
		{
			context.setAttribute("user", usr);
			request.setAttribute("user", usr);
			
			//fetching salary Record
			UserSalary usrSal=databaseRepository.getUserSalaryDetails(con,userId);
			context.setAttribute("usrSalary", usrSal);
			request.setAttribute("usrSalary", usrSal);
			
			requestDispatcher = request.getRequestDispatcher("success.jsp");
			requestDispatcher.forward(request, response);
			
		}
		else{
			requestDispatcher = request.getRequestDispatcher("error.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}
}
