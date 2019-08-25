package criminalnode1;

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
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
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
	     String name=request.getParameter("mail");
	     //System.out.println(mail);
	     String password=request.getParameter("password");
	       try
	       {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","root");	
	    			PreparedStatement pss=con.prepareStatement("select head from criminaldet where name=?");
	    	    	pss.setString(1, name);
	    	    	ResultSet res=pss.executeQuery();
	    	    	if(res.next())
	    	    	{
	    	    		String head=res.getString(1);
	    	    		request.setAttribute(name, "mail");
	    	    		request.setAttribute(head,"head");
	    	    		RequestDispatcher rd=request.getRequestDispatcher("criminalnode1.jsp");
	    	    		rd.forward(request, response);
	    	    		}
	    	    		 
	    	    	}
	   
	       catch(Exception e)
	       {
	    	   System.out.println(e);
	       }
	}

}
