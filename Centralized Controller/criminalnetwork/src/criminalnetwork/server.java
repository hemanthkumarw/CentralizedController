package criminalnetwork;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class server
 */
@WebServlet("/server")

public class server extends HttpServlet {
	 public static final String PUBLIC_KEY_FILE = "C:/keys/public.key";
	  public static final String PRIVATE_KEY_FILE = "C:/keys/private.key";
	String line;
	static int count=0;
	static String lo;
	static String st=null;
	static String lg="to";
	static String up="from";
	 static String o=null;
	 static String p=null;
	static  int port5=8678;
	 static int port1=7890;
	private static final long serialVersionUID = 1L;
	 ServerSocket echoServer = null;
	    //String line;
	    DataInputStream is;
	    Socket clientSocket = null;
	    Socket serv=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public server() {
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
		
		 try {
		      echoServer = new ServerSocket(6787);
		    } catch (IOException e) {
		      System.out.println(e);
		    }

		    /*
		     * Create a socket object from the ServerSocket to listen to and accept
		     * connections. Open input and output streams.
		     */
		    System.out.println("The server started. To stop it press <CTRL><C>.");
		   
		    	while(true)
		    	{
		    		try
		    		{
		    			System.out.println("main server wainting");
		    		serv=echoServer.accept();
		    		PrintStream os=new PrintStream(serv.getOutputStream());
		    		InputStream min_streams=serv.getInputStream();
		    		ObjectInputStream obej=new ObjectInputStream(serv.getInputStream());
		    		ObjectOutputStream objp=new ObjectOutputStream(serv.getOutputStream());
		    		   ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
		    		      ObjectInputStream inputStream2 = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
		    		  // final  PublicKey pkey=(PublicKey)inputStream.readObject();
		    		   //final PrivateKey privateKey = (PrivateKey) inputStream2.readObject();
		    		String keyss;
		    		Enumeration names;
		    		Hashtable<String, String> hashtable = null;
					try {
						hashtable = (Hashtable<String, String>) obej.readObject();
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
		    		names = hashtable.keys();
		    		   while(names.hasMoreElements()) {
		    		      keyss = (String) names.nextElement();
		    		      switch(keyss)
		    		      {
		    		      case "server1":
		    		      {
		    		    	  o=hashtable.get(keyss);
		    		    	System.out.println(o);
		    		    	  break;
		    		      }
		    		      case "user":
		    		      {
		    		    	 String oi=hashtable.get(keyss);
		    		    	 try
							    {
							    	Class.forName("com.mysql.jdbc.Driver");
								    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
								    String str="select sourceinfo from ";
								    Statement psmt=conn.createStatement();
								   ResultSet r=psmt.executeQuery(str);
								   while(r.next())
								   {
									   String lio=r.getString(1);
									   if(lio.equals(oi))
									   {
										   //objp.writeObject(privateKey);
									   }
									  
									   }
								   
								   
								    
								  
							    }catch(Exception e1)
							    {
							    	e1.printStackTrace();
							    }
		    		    	  break;
		    		    	 }
		    		      case "server9":
		    		      {
		    		    	 
		    		    	  p=hashtable.get(keyss);
		    		    	  break;
		    		      }
		    		      case "init":
		    		      {
		    		    	  String r=hashtable.get(keyss);
		    		    	  try
		    		    	  {
		    		    	  	Class.forName("com.mysql.jdbc.Driver");
		    		    		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","sabi");
		    		    		    String str="insert into secur(user)values(?)";
		    		    		 PreparedStatement psmt=conn.prepareStatement(str);
		    		    		psmt.setString(1, r);
		    		    		psmt.executeUpdate();
		    		    	  }catch(Exception e)
		    		    	  {
		    		    	  	e.printStackTrace();
		    		    	  }
		    		    	  break;
		    		      }
		    		      case "design":
		    		      {
		    		    	  String hl=hashtable.get(keyss);
		    		    	  try
		    		    	  {
		    		    	  	Class.forName("com.mysql.jdbc.Driver");
		    		    		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","sabi");
		    		    		    String str="insert into secur1(user1)values(?)";
		    		    		 PreparedStatement psmt=conn.prepareStatement(str);
		    		    		psmt.setString(1, hl);
		    		    		psmt.executeUpdate();
		    		    	  }catch(Exception e)
		    		    	  {
		    		    	  	e.printStackTrace();
		    		    	  }
		    		    	  if(o.equals("free"))
		    		    	  {
		    		    		
		    		    		os.println(port5);
		    		    		 //objp.writeObject(pkey);
		    		    	  }
		    		    	  else if(p.equals("free"))
		    		    	  {
		    		    		 
		    		    		  os.println(port1);
		    		    		  //objp.writeObject(pkey);
		    		    	  }
		    		    	  else 
		    		    	  {
		    		    		  System.out.println("all server is busy");
		    		    	  }
		    		      }
		    		      break;
		    		      }
		        os.close();    
		    	serv.close();
		    	min_streams.close();
		    	obej.close();
		        
		    	}
		    	
		    	}
//		    	 
//		      is = new DataInputStream(clientSocket.getInputStream());
//		      os = new PrintStream(clientSocket.getOutputStream());
		//   
//		      while (true) {
//		     up= is.readLine();
//		       
		//   System.out.println(lo);
//		        if(up.equals("from"))
//		        {
//		        	System.out.println("rteryuityero");
//		        }
//		        else if(up.equals("to"))
//		        {
//		        	System.out.println("uiuiuiuiuirtyt");
//		        	
//		        }
//		        else
//		        {
//		        	   lo=up;
//		        System.out.println(lo);
//		        }
////		        os.println("From server: " + line);
//		      }

		    		catch (IOException e) {
		    		      System.out.println(e);
		    		    }
		    	} 
		
	}

}
