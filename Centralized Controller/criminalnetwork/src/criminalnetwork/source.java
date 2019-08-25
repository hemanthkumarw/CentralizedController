package criminalnetwork;



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class source
 */
public class source extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public source() {
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
		String mail=request.getParameter("mail");
		String dest=request.getParameter("destination");
		String title=request.getParameter("title");
		String mess=request.getParameter("mess");
		String node=request.getParameter("node");
		
		//String type=filepart.getContentType();
		
		
		
		
	
		
	try
	{
		byte[] fil=null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
		
		
		String sql="insert into sourceinfo(destination,title,content,name,node)values (?,?,?,?,?)";
		PreparedStatement stm=con.prepareStatement(sql);
		
		 stm.setString(1,dest);
		 stm.setString(2, title);
		 stm.setString(3, mess);
		 stm.setString(4, mail);
		 stm.setString(5, node);
		 
		 stm.executeUpdate();
		
		 
		 if(node.equals("node1"))
		    { 	
		    String url="http://localhost:8080/criminalnode1/no1?dest="+dest+"&title="+title+"&con="+mess+"&name="+mail+"&node="+node;
		    String rr=URLConnectionReader(url); 

		    }
		    else if(node.equals("node2"))
		    {
		    	String rr=URLConnectionReader("http://localhost:8080/criminalnode2/no2?dest="+dest+"&title="+title+"&con="+mess+"&name="+mail+"&node="+node); 
		    }
		    else if(node.equals("node3"))
		    {
		    	String rr=URLConnectionReader("http://localhost:8080/criminalnode3/no3?dest="+dest+"&title="+title+"&con="+mess+"&name="+mail+"&node="+node); 
		    } 
		    else if(node.equals("node4"))
		    {
		    	String rr=URLConnectionReader("http://localhost:8080/criminalnode4/no4?dest="+dest+"&title="+title+"&con="+mess+"&name="+mail+"&node="+node); 
		    }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
	private String URLConnectionReader(String url) {
		try
		{
			 URL yahoo = new URL(url);
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
			System.out.println(e);
			return null;
		}
		return null;
	}

	
}