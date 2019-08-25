package criminalnetwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class client
 */
@WebServlet("/client")
public class client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public client() {
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
	     String mail=request.getParameter("mail");
	     //System.out.println(mail);
	     String password=request.getParameter("password");
	       try
	       {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
	    	
	    	PreparedStatement ps=con.prepareStatement("select activation from officer where email=?");
	    	ps.setString(1, mail);
	    	ResultSet re=ps.executeQuery();
	    	if(re.next())
	    	{
	    		String act=re.getString(1);
	    		if(act.equals("activate"))
	    		{
	    			PreparedStatement pss=con.prepareStatement("select email,password from officer where email=?");
	    	    	pss.setString(1, mail);
	    	    	ResultSet res=pss.executeQuery();
	    	    	if(res.next())
	    	    	{
	    	    		String email=res.getString(1);
	    	    		String pass=res.getString(2);
	    	    		if(mail.equals(email)&&password.equals(pass))
	    	    		{
	    	    		request.setAttribute(mail, "mail");
	    	    		RequestDispatcher rd=request.getRequestDispatcher("userpage.jsp");
	    	    		rd.forward(request, response);
	    	    		}
	    	    		 else
	    	 	    	{
	    	 	    		out.println("sorry your mail and password is Incorrect");
	    	 	    	}
	    	    	}
	    		}
	    		else
	    		{
	    			out.write("<html>");
	    			out.write("<head>");
	    			out.write("<title>NOTIFICATION</title>");
	    			out.write("</head>");
	    			out.write("<body>");
	    			out.write("<div align='center'>");
	    			out.write("<h2>YOU ARE NOT ACTIVATED</h2>");
	    			out.write("</body>");
	    			out.write("</html>");
	    		}
	    	}
	    	
	       }
	       catch(Exception e)
	       {
	    	   System.out.println(e);
	       }
	     
	    
	}

}
