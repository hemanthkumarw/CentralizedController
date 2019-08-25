package criminalnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
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
 * Servlet implementation class hacker
 */
@WebServlet("/hacker")
public class hacker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hacker() {
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
		PrintWriter out=response.getWriter();
		String dest=request.getParameter("destination");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		if(content!=null)
		{
			content=content.trim();
			content=content.replace(" ", "+");
		}
		System.out.println(content);
		String name=request.getParameter("name");
		System.out.println(name);
		String head=request.getParameter("head");
		String node=request.getParameter("node");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");	
	    PreparedStatement pss=con.prepareStatement("insert into criminalinfo(destination,title,content,head,name,node)values(?,?,?,?,?,?)");
	    pss.setString(1, dest);
	    pss.setString(2, title);
	    pss.setString(3, content);
	    pss.setString(4, head);
	    pss.setString(5, name);
	    pss.setString(6, node);
	  
	    
	    
	    
	    
	    int i=pss.executeUpdate();
	    if(i>0)
	    {
	    	
	    }
	    int c=1,a=0,b=0;
	    PreparedStatement ps=con.prepareStatement("select comm from criminaldet where head=?");
	    ps.setString(1, head);
	    ResultSet res=ps.executeQuery();
	    if(res.next())
	    {
	     	a=res.getInt(1);
	     	b=a+c;
	    }
	    PreparedStatement pp=con.prepareStatement("update criminaldet set comm=?,node=? where head=?");
	    pp.setInt(1, b);
	    pp.setString(2, node);
	    pp.setString(3, head);
	    int r=pp.executeUpdate();
	    		if(r>0)
	    		{
	    			
	    		}
	    		
	    String name1=null;		
	  PreparedStatement po=con.prepareStatement("select name from criminaldet");
	  ResultSet resultSet=po.executeQuery();
	  while(resultSet.next())
	  {
		name1=resultSet.getString(1); 
		System.out.println(name1);
	 
	    if(!name.equals(name1))
	    {
	    	 PreparedStatement qq=con.prepareStatement("update destinationinfo set tit=?,content=? where dest=?");
	 	    qq.setString(1, title);
	 	    qq.setString(2, content);
	 	    qq.setString(3, dest);
	 	    int w=qq.executeUpdate();
	 	    if(w>0)
	 	    {
	 	    	
	 	    }
		    		    
	    }
	    else
	    {
	    	 //out.write("<html><body><p>SORRY U ARE HAKER</p></body></html>");
	    	 RequestDispatcher rd=request.getRequestDispatcher("haa.jsp");
		     rd.forward(request, response);
		}
	       
		}
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		private String URLConnectionReader(String url)
		
		{
					try
					{
						URL yahoo=new URL(url);
						 URLConnection yc = yahoo.openConnection();
						 BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
						    
				         String inputLine;
				         while ((inputLine = in.readLine()) != null) 
					        {
					            System.out.println(inputLine);
					            return inputLine;
					            
					        }
				         in.close();
						 
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println(e);
					}
						return null;
	}

}
