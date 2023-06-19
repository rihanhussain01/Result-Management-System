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


public class ResultInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String name = request.getParameter("name");
		String course = request.getParameter("courseName");
		String branch = request.getParameter("branchName");
		String rollNo = request.getParameter("rollNo");
		String father = request.getParameter("fatherName");
		String mother = request.getParameter("motherName");
		String gender = request.getParameter("gender");
		String passingYear = request.getParameter("passingYear");
		
		
		Connection con = JDBCCON.getConnection();
		
//		System.out.println(JDBCCON.getConnection());
//		response.getWriter().println(JDBCCON.getConnection());
		final String INSER_QUERY = "insert into student_details"
				+ "(stdName , courseName , branchName , rollNo , fatherName , motherName , gender , passingYear) "
				+ "values(? , ? , ? , ? , ? , ? , ? , ?)";
		
		try {
			PreparedStatement ps =  con.prepareStatement(INSER_QUERY);
			ps.setString(1, name);
			ps.setString(2, course);
			ps.setString(3, branch);
			ps.setString(4, rollNo);
			ps.setString(5, father);
			ps.setString(6, mother);
			ps.setString(7, gender);
			ps.setString(8, passingYear);
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				response.getWriter().println("Update Successfully Done");
			} else  {
				response.getWriter().println("Update Failed");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
