package criminalnode2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class criminalnode2
 */
public class criminalnode2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public criminalnode2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter pw=response.getWriter();
		System.out.println("criminalnode2 post method called");
		String uri=request.getRequestURI();
		System.out.println("get::uri::"+uri);
		if(uri.equals("/criminalnode2/node2"))
		{
			String dest=request.getParameter("dest");
			String title=request.getParameter("title");
			String content=request.getParameter("con");
			if(content!=null)
			{
				content=content.trim();
				content=content.replace(" ", "+");
			}
			String head=request.getParameter("head");
			String name=request.getParameter("name");
			String node=request.getParameter("node");
			
		    	//int sign=3000;
				String rr=URLConnectionReader("http://localhost:8080/criminaldest/criminal?dest="+dest+"&title="+title+"&con="+content+"&head="+head+"&name="+name+"node="+node); 	
		    
		}
		else if(uri.equals("/criminalnode2/no2"))
		{
			String dest=request.getParameter("dest");
			String title=request.getParameter("title");
			if(title!=null)
			{
				title=title.trim();
				title=title.replace(" ", "+");
			}

			
			String content=request.getParameter("con");
			if(content!=null)
			{
				content=content.trim();
				content=content.replace(" ", "+");
			}
			
			String name=request.getParameter("name");
			String node=request.getParameter("node");
			
			String rr=URLConnectionReader("http://localhost:8080/criminaldest/dest?dest="+dest+"&title="+title+"&con="+content+"&name="+name+"&node="+node); 	
			//response.getWriter().write(rr);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
