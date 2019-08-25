package criminalnetwork;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class admin
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	     PrintWriter out=response.getWriter();
	     String mail=request.getParameter("name");
	     String password=request.getParameter("password");
	     if(mail.equals("admin")&&password.equals("admin"))
	     {
	       try
	       {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
	    	PreparedStatement pss=con.prepareStatement("insert into admin(name,password)values(?,?)");
	    	pss.setString(1, mail);
	    	pss.setString(2, password);
	    	int i=pss.executeUpdate();
	    	if(i>0)
	    	{
	    		RequestDispatcher rd=request.getRequestDispatcher("adminpage.jsp");
	    		rd.forward(request, response);
	    	}
	    	else
	    	{
	    		//out.println("<marquee>sorry your username and password is Incorrect</marquee>");
	    	}
	    	
	    	
	       }
	       catch(Exception e)
	       {
	    	   e.printStackTrace();
	       }
	     }

	}

}
