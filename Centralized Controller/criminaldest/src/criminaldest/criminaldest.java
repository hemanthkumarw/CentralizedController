package criminaldest;

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
 * Servlet implementation class dest
 */
public class criminaldest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public criminaldest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		System.out.println("node1 get method called");
		String uri=request.getRequestURI();
		System.out.println("get::uri::"+uri);
		
		if(uri.equals("/criminaldest/criminal"))
		{
			String dest=request.getParameter("dest");
			System.out.println(dest);
			String title=request.getParameter("title");
			String cont=request.getParameter("con");
			String head=request.getParameter("head");
			String name=request.getParameter("name");
			String node=request.getParameter("node");
			try
			{
				long lo=System.currentTimeMillis();
				Date dp=new Date(lo);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
				
				
				String sql="insert into criminaldest(destination,title,content,head,name,date,time,node)values(?,?,?,?,?,?,?,?)";
				PreparedStatement stm=con.prepareStatement(sql);
				 stm.setString(1, dest);
				 stm.setString(2, title);
				 stm.setString(3, cont);
				 stm.setString(4, head);
				 stm.setString(5, name);
				 stm.setDate(6, new java.sql.Date(dp.getTime()));
				 stm.setTime(7,new java.sql.Time(dp.getTime()));	
				 stm.setString(8, node);
				 stm.executeUpdate();
				 
				 
				 
				 
				//out.write("<html><head></head><body></body></html>");
				 //response.getWriter().write("YOU ARE FILE RECEIVED"); 
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(uri.equals("/criminaldest/dest"))
		{
			
			System.out.println("cvbcvbbbgfgfg");
			long lo=System.currentTimeMillis();
			Date dp=new Date(lo);
			String dest=request.getParameter("dest");
			System.out.println(dest);
			String title=request.getParameter("title");
			System.out.println(title);
			String content=request.getParameter("con");
			
			System.out.println(content);
			String name=request.getParameter("name");
			System.out.println(name);
			String node=request.getParameter("node");
			System.out.println(node);
			try
			
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
			String sql="insert into destinationinfo(dest,tit,content,name,node,dat,tim)values (?,?,?,?,?,?,?)";
			PreparedStatement stm=con.prepareStatement(sql);
			 stm.setString(1, dest);
			 stm.setString(2, title);
			 stm.setString(3, content);
			 
			 stm.setString(4, name);
			 stm.setString(5, node);
			 stm.setDate(6, new java.sql.Date(dp.getTime()));
			 stm.setTime(7,new java.sql.Time(dp.getTime()));	
			 stm.executeUpdate();
			 
			// RequestDispatcher rd=request.getRequestDispatcher("suc.jsp");
	    		//rd.forward(request, response);
			 
			//out.write("<html><head></head><body><h2>YOU ARE FILE RECEIVED</h2></body></html>");
			 //response.getWriter().write("YOUR FILE RECEIVED"); 	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
