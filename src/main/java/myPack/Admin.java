package myPack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

import jdbcConnnection.JDBCCON;


public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(name + " " + password);
		
		Connection con = JDBCCON.getConnection();
		
		final String SELECT_QUERY = "select * from rms_admin_reg where email=? and pass=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY)
					;
			ps.setString(1, name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				response.sendRedirect("resultInsert.html");
			} else {
				response.sendRedirect("adminError.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
