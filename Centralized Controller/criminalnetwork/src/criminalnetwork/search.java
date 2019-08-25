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
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
	     String email=request.getParameter("email");
	     String name1=request.getParameter("name");
	     System.out.println(name1);
	     String password=request.getParameter("activity");
	     System.out.println(password);
	     System.out.println("dfghgjgjhjgggggggggggggggggggggggggggggggggggg");
	     int c=1;
	     try
	     {
	    	  //System.out.println("vsddfbfbbdfvdfgdf");
	    	 Class.forName("com.mysql.jdbc.Driver");
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
		    	
         	PreparedStatement pe=con.prepareStatement("select count from criminaldet where name=? and activity=?");
	    	pe.setString(1, name1);
		    pe.setString(2, password);
		    ResultSet re=pe.executeQuery();
	    	while(re.next())
	    	{
	    		int coun=re.getInt(1);
	    		
	    		int e=c+coun;
	    		
	    	PreparedStatement pp=con.prepareStatement("insert into criminal(name,activity,count,email)values(?,?,?,?)");
	    	pp.setString(1, name1);	
	    	pp.setString(2, password);
	    	pp.setInt(3, e);
	    	pp.setString(4, email);
	    	int i=pp.executeUpdate();
	    	if(i>0)
	    	{
	    		
	    	}
	    	
	    	PreparedStatement ps=con.prepareStatement("update criminaldet set count=? where name=? and activity=?");
	    	ps.setInt(1, e);
	    	ps.setString(2, name1);
	    	ps.setString(3, password);
	    	int ie=ps.executeUpdate();
	    	if(ie>0)
	    	{
	    		
	    	}
	    	}
		    	PreparedStatement pss=con.prepareStatement("select * from criminaldet where name=?");
		    	pss.setString(1, name1);
		    	//pss.setString(2, password);
		    	ResultSet res=pss.executeQuery();
		    	if(res.next())
		    	{
		    		//System.out.println("vsddfbfbbdfvdfgdf");
		    		String name=res.getString(2);
		    		System.out.println(name);
		    		String acti=res.getString(3);
		    		String coun=res.getString(4);
		    		String state=res.getString(5);
		    		String cit=res.getString(6);
		    		String date=res.getString(7);
		    		String time=res.getString(8);
		    		String sex=res.getString(9);
		    		String mem=res.getString(10);
		    		byte[] pic=res.getBytes(11);
		    		String ii=getEncode_Image(pic);
		    		
		    		  
		    		 out.write("<html><body bgcolor='#556B2F'><br><br><br><br><div align='center'><h2>CRIMINAL DETAILS</h2><TABLE border='5'><tr><th rowspan='7'><img alt='picture' src='data:image/jpg;base64,"+ii+"' style='width: 200px;height: 150px'/></th></tr>");    	  
				      out.write("<tr><th>name</th><td>"+name+"</td></tr><tr><th>activity</th><td>"+acti+"</td></tr><tr><th>state</th><td>"+state+"</td></tr></tr><tr><th>country</th><td>"+coun+"</td></tr><tr><th>city</th><td>"+cit+"</td></tr><tr><th>date</th><td>"+date+"</td></tr><tr><th>time</th><td>"+time+"</td></tr><tr><th>sex</th><td>"+sex+"</td></tr><tr><th>member</th><td>"+mem+"</td></tr><br>"); 
		 
				      out.write("</table></div> </body> </html>");	
			    	 // request.setAttribute("name",name);
			    	  
			    	out.write("<html>");
			   
	    
     
		    	}  
		    	else
		    	{RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
	    		rd.forward(request, response);
		    	
		    	}
	     }
	     
		catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	}
	private String getEncode_Image(byte[] pic) {
		String image_encode=org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(pic);
		System.out.print("Image encoded is::::"+image_encode);

		return image_encode;

	}

}
