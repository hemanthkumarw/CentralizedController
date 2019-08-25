package criminalnetwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cregister
 */
@WebServlet("/cregister")
public class cregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cregister() {
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
	     //PrintWriter out=response.getWriter();
		 long milli=System.currentTimeMillis();
		  Date dp=new Date(milli);  
	     String name=request.getParameter("name");
	     String email=request.getParameter("email");
	     String address=request.getParameter("city");
	     String postcode=request.getParameter("postcode");
	     String mobile=request.getParameter("mobile");
	     String dob=request.getParameter("dob");
	     String sex=request.getParameter("sex");
	     String password=request.getParameter("password");
	     String s="deactivate";
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
	    	PreparedStatement pss=con.prepareStatement("insert into officer(name,email,address,postcode,mobile,dob,sex,password,date,activation) values(?,?,?,?,?,?,?,?,?,?)");
	    	pss.setString(1, name);
	    	pss.setString(2, email);
	    	pss.setString(3, address);
	    	pss.setString(4, postcode);
	    	pss.setString(5, mobile);
	    	pss.setString(6, dob);
	    	pss.setString(7, sex);
	    	pss.setString(8, password);
	    	pss.setDate(9, new java.sql.Date(dp.getTime()));
	    	pss.setString(10, s);
	    	
	    	
	    	
	    	int i=pss.executeUpdate();
	    	if(i>0)
	    	{
	    		//out.println("sucessfully inserted")
	    		RequestDispatcher rd=request.getRequestDispatcher("officers.jsp");
	    		rd.forward(request, response);
	    	}
	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }    
	   

	}

}
