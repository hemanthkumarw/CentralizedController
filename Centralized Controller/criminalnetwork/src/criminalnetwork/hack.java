package criminalnetwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
 * Servlet implementation class hack
 */
@WebServlet("/hack")
public class hack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hack() {
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
	     System.out.println(name);
	     String password=request.getParameter("password");
	       try
	       {
	    	   long lo=System.currentTimeMillis();
				Date dp=new Date(lo);
	    	   String head=null;
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");	
	    	PreparedStatement ps=con.prepareStatement("insert into hacklogin(name,password,dat,tim)values(?,?,?,?)");
	    	ps.setString(1, name);
	    	ps.setString(2, password);
	    	ps.setDate(3, new java.sql.Date(dp.getTime()));
			 ps.setTime(4,new java.sql.Time(dp.getTime()));	
	    	   int i=ps.executeUpdate();
	    	   if(i>0)
	    	   {
	    		   
	    	   }
	    	  
		    	
	    			PreparedStatement pss=con.prepareStatement("select head from criminaldet where name=?");
	    	    	pss.setString(1, name);
	    	    	ResultSet res=pss.executeQuery();
	    	    	if(res.next())
	    	    	{
	    	    		 head=res.getString(1);
	    	    		System.out.println(head);
	    	    		
	    	    		}
	    	    	request.setAttribute("name", name);
    	    		request.setAttribute("head",head);
    	    		RequestDispatcher rd=request.getRequestDispatcher("hackpage.jsp");
    	    		rd.forward(request, response);
	    	    		 
	    	    	}
	   
	       catch(Exception e)
	       {
	    	   System.out.println(e);
	       }
	}

}
