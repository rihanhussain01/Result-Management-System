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


public class AdminRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String adminId = request.getParameter("adminId");
		String name = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String select = request.getParameter("selector");
		String answer = request.getParameter("answer");
		
		System.out.println(name + " " +mobile + " " + email + " " + pass + " " + select + " " + answer);
		
		Connection con = JDBCCON.getConnection();
		
		final String INSERT_QUERY = "insert into rms_admin_reg (adminId , username , mobile , email , pass , securityquestion , securityAnswer) values(? , ? , ? , ? , ? , ? , ?)";
		
		
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1,adminId );
			ps.setString(2, name);
			ps.setString(3, mobile);
			ps.setString(4, email);
			ps.setString(5, pass);
			ps.setString(6, select);
			ps.setString(7, answer);
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				response.sendRedirect("registerSuccess.html");
			} else {
				response.sendRedirect("adminRegisterError.html");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
