package myPack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcConnnection.JDBCCON;


public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String cnfPass = request.getParameter("cnfpassword");
		
		Connection con = JDBCCON.getConnection();
		final String UPDATE_QUERY = "update rms_admin_reg set pass=? where email=?";
		if(pass.equalsIgnoreCase(cnfPass)) {
			try {
				
				PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
				ps.setString(2, email);
				ps.setString(1, pass);
				
				int i = ps.executeUpdate();
				
				if(i > 0 ) {
				response.sendRedirect("forgotSuccess.html");
				} else {
					response.sendRedirect("forgotWrong.html");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("forgotWrong.html");
		}
		
		
		
	}

}
