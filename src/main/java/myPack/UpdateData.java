package myPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcConnnection.JDBCCON;

public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		Connection con = JDBCCON.getConnection();
		String rollnumber = request.getParameter("rollnumber");
		final String SELECT_QUERY = "select * from sem_3";
		
		try {
			PreparedStatement ps =  con.prepareStatement(SELECT_QUERY);
		
		
		
		
	}catch (Exception e) {
		// TODO: handle exception
	}

}
}