package criminalnetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class criminal
 */
@WebServlet("/criminal")
@MultipartConfig(maxFileSize = 16177215)
public class criminal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public criminal() {
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
		 String head=request.getParameter("head");
	     String name=request.getParameter("name");
	     String activity=request.getParameter("activity");
	     String country=request.getParameter("country");
	     String state=request.getParameter("state");
	     String city=request.getParameter("city");
	     String date=request.getParameter("date");
	     String time=request.getParameter("time");
	     String sex=request.getParameter("sex");
	     String member=request.getParameter("member");
	     String informer1=request.getParameter("inform");
	     Part filepart=request.getPart("photo");
	     InputStream inputStream =null; 
          String informer="public";
			if (filepart != null) 
	        					{    	  
							           System.out.println("name:"+filepart.getName());
							           //System.out.println("Filename:"+filepart.getSubmittedFileName());
							           System.out.println("size:"+filepart.getSize());
							           System.out.println(filepart.getContentType());
							           System.out.println("name:"+name);
							           inputStream = filepart.getInputStream();
							       }
			long size=filepart.getSize();
	     try
	     {
	    	 Class.forName("com.mysql.jdbc.Driver");
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
		    	PreparedStatement pss=con.prepareStatement("insert into criminaldet(name,activity,country,state,city,date,time,sex,member,photo,size,date1,time1,head) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		    	pss.setString(1, name);
		    	pss.setString(2, activity);
		    	pss.setString(3, country);
		    	pss.setString(4, state);
		    	pss.setString(5, city);
		    	pss.setString(6, date);
		    	pss.setString(7, time);
		    	pss.setString(8, sex);
		    	pss.setString(9, member);
		    	if (inputStream != null)
		         {
		  		 pss.setBinaryStream(10, inputStream,1000000);
		   			} 
		    	pss.setLong(11,size);
		        pss.setDate(12, new java.sql.Date(dp.getTime()));
				pss.setTime(13,new java.sql.Time(dp.getTime()));
				pss.setString(14, head);
				
				int i=pss.executeUpdate();
				if(i>0)
				{
					RequestDispatcher rd=request.getRequestDispatcher("adminpage.jsp");
					rd.forward(request, response);
				}
		    	
	     }
	     catch(Exception e)
	     {
	    	e.printStackTrace();
	     }
		
	}

}
