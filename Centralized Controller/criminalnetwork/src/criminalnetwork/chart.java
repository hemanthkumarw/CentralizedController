package criminalnetwork;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 * Servlet implementation class chart
 */
@WebServlet("/chart")
public class chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		 Connection connection = null;
		    try {
		      Class.forName("com.mysql.jdbc.Driver").newInstance();
		      try {
		        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/criminal","root","sabi");
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    } 
		    catch (InstantiationException e) {
		      e.printStackTrace();
		    } 
		    catch (IllegalAccessException e) {
		      e.printStackTrace();
		    } 
		    catch (ClassNotFoundException e) {
		      e.printStackTrace();
		    }
          
		    JDBCCategoryDataset dataset = new JDBCCategoryDataset(connection);
		    try {
		     dataset.executeQuery("Select head,count From criminaldet order by count desc");
		    
		      
		      
		      JFreeChart chart = ChartFactory.createBarChart("BAR CHART", null, null, dataset,PlotOrientation.VERTICAL, true, true, false);
		      chart.setBorderVisible(true);

		      
		      
		      
		      while (chart != null) 
		      {
		    	  int width = 400;
	                int height = 400;
		        response.setContentType("image/png");
		        OutputStream out = response.getOutputStream();
		        ChartUtilities.writeChartAsPNG(out, chart, width, height);
		      }
		    	
		    } 
		    catch (SQLException e) {
		      e.printStackTrace();
		    }
          
		    try {
		      if(connection != null)
		      {
		    	  connection.close();
		    	  } 
		    }
		    catch (SQLException e) 
		    {e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
