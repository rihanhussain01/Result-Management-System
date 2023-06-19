package myPack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcConnnection.JDBCCON;


public class Semester3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String roll =  request.getParameter("rollNo");
		int ccwt = Integer.parseInt(request.getParameter("ccwt"));
		int c = Integer.parseInt(request.getParameter("c"));
		int dld = Integer.parseInt(request.getParameter("dld"));
		int be = Integer.parseInt(request.getParameter("be"));
		int m3 = Integer.parseInt(request.getParameter("m3"));
		
		System.out.println(roll + " " + ccwt + " " + c + " " + dld + " " + be + " " + m3);
		
		Connection con = JDBCCON.getConnection();
		
//		System.out.println(con);
		
		final String INSERT_DATA = "insert into sem_3(rollNo , ccwt , c , dld , be , m3) values(? , ? , ? , ? , ? , ?)";
		try {
			PreparedStatement ps =  con.prepareStatement(INSERT_DATA);
			ps.setString(1, roll);
			ps.setInt(2, ccwt);
			ps.setInt(3, c);
			ps.setInt(4, dld);
			ps.setInt(5, be);
			ps.setInt(6, m3);
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				response.getWriter().println("update Successfully");
			} else {
				response.getWriter().println("update Failed");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
