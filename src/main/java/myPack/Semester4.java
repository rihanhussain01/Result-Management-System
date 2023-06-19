package myPack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcConnnection.JDBCCON;


public class Semester4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String rollNo=request.getParameter("rollNo");
		int cpp = Integer.parseInt(request.getParameter("cpp"));
		int ada = Integer.parseInt(request.getParameter("ada"));
		int os = Integer.parseInt(request.getParameter("os"));
		int m4 = Integer.parseInt(request.getParameter("m4"));
		int csa = Integer.parseInt(request.getParameter("csa"));
		
		
		System.out.println(rollNo + " " + cpp + " " + ada + " " + os + " " + m4 + " " + csa);
		
		Connection con = JDBCCON.getConnection();
		System.out.println(con);
		
		
		final String QUERY = "insert into sem_4(rollNo , cpp , ada , os , csa , m4) values(? , ? , ? , ? , ?  , ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(QUERY);
			ps.setString(1, rollNo);
			ps.setInt(2, cpp);
			ps.setInt(3, ada);
			ps.setInt(4, os);
			ps.setInt(5, csa);
			ps.setInt(6, m4);
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				response.getWriter().println("Data Inserted");
			}else {
				response.getWriter().println("Data Not Inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
