package myPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcConnnection.JDBCCON;


public class StudentClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String roll;
       String passfail3;
       String passfail4;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		int sem = Integer.parseInt(request.getParameter("sem"));
		String rollNmber = request.getParameter("stdRoll");
		
		roll = rollNmber;
		
		System.out.println(sem + " " + rollNmber);
		
		Connection con = JDBCCON.getConnection();
		System.out.println(con);
		
		final String SELECT_QUERY_SEM_3 = "select * from sem_3 where rollNo = ?";
		final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo = ?";
		final String SELECT_QUERY_STUDENT_DETAILS = "select * from student_details where rollNo = ?";
		
		if(sem == 3) {
			try {
				PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_3);
				ps.setString(1, rollNmber);
				
				PreparedStatement ps1 =  con.prepareStatement(SELECT_QUERY_STUDENT_DETAILS);
				ps1.setString(1, rollNmber);
				
				ResultSet rs1 = ps1.executeQuery();
				
				ResultSet rs = ps.executeQuery();
				
				
				
				pw.println("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "  <title>Bootstrap Example</title>\r\n"
						+ "  <meta charset=\"utf-8\">\r\n"
						+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
						+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
						+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "\r\n"
						+ "<div class=\"container\">\r\n"
						+ "  <h2>Semester 3</h2>\r\n"
						+ "  <p>Student 3rd Semester Result Activity</p>            \r\n");
				while(rs1.next()) {
					pw.println(""
							+ "<p>Roll Number: "+rs1.getString(5)+"</p>\r\n"
							+ "<p>Student Name: " +rs1.getString(2)+"/"+rs1.getString(6)+"</p>\r\n"
									+ "<p>Mother Name: "+rs1.getString(7)+"</p>\r\n"
											+ "<p>Branch: " +rs1.getString(4)+"</p>\r\n"
													+ "<p>Course: " +rs1.getString(3)+"</p>\r\n"
															+ "<br>");
				}
						pw.println("  <table class=\"table table-bordered\">\r\n"
						+ "    <thead>\r\n"
						+ "      <tr>\r\n"
						+ "        <th>Subject</th>\r\n"
						+ "        <th>Total Max Marks</th>\r\n"
						+ "        <th>Obt. Marks</th>\r\n"
						+ "<th>Grades</th>\r\n"
						+ "<th>Pass/Fail</th>\r\n"
						+ ""
						+ "      </tr>\r\n"
						+ "    </thead>\r\n"
						+ "    <tbody>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>CCWT</td>\r\n"
						+ "        <td>100</td>\r\n");
				while(rs.next()) {
					pw.println("<td>"+rs.getInt(3)+"</td>\r\n");
					pw.println("<td>"+gradesSemInt3(rollNmber)+"</td>\r\n");
					pw.println("<td>"+pfSem3Int3()+"</td>\r\n");
						    pw.println("</tr>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>C</td>\r\n"
						+ "        <td>100</td>\r\n");
						   
						   
								pw.println("<td>"+rs.getInt(4)+"</td>\r\n");
								pw.println("<td>"+gradesSemInt4(rollNmber)+"</td>\r\n");
								pw.println("<td>"+pfSem3Int4()+"</td>\r\n");
						      pw.println("</tr>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>DLD</td>\r\n"
						+ "        <td>100</td>\r\n");
						     
									pw.println("<td>"+rs.getInt(5)+"</td>\r\n");
									pw.println("<td>"+gradesSemInt5(rollNmber)+"</td>\r\n");
									pw.println("<td>"+pfSem3Int5()+"</td>\r\n");
						      pw.println("</tr>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>BE</td>\r\n"
						+ "        <td>100</td>\r\n");
						      
									pw.println("<td>"+rs.getInt(6)+"</td>\r\n");
									pw.println("<td>"+gradesSemInt6(rollNmber)+"</td>\r\n");
									pw.println("<td>"+pfSem3Int6()+"</td>\r\n");
						    pw.println("</tr>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>M3</td>\r\n"
						+ "        <td>100</td>\r\n");
						    pw.println("<td>"+rs.getInt(7)+"</td>\r\n");
						    pw.println("<td>"+gradesSemInt7(rollNmber)+"</td>\r\n");
						    pw.println("<td>"+pfSem3Int7()+"</td>\r\n");
						    pw.println("</tr>\r\n"
									+ "      <tr>\r\n"
									+ "        <td>Total</td>\r\n"
									+ "        <td>500</td>\r\n");
							pw.println("<td>"+(rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7))+"</td>\r\n");
							 pw.println("</tr>\r\n"
										+ "      <tr>\r\n"
										+ "        <td>Percantage</td>\r\n"
										);
									pw.println("<td>"+((rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7))/5.0)+"%"+"</td>\r\n");
									pw.println("<td>"+percantagePassFail3()+"</td>\r\n");
						    
								
			}
						   pw.println("</tr>\r\n"
						+ "    </tbody>\r\n"
						+ "  </table>\r\n"
						+ "</div>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(sem == 4) {
			try {
				PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_4);
				ps.setString(1, rollNmber);
				PreparedStatement ps1 =  con.prepareStatement(SELECT_QUERY_STUDENT_DETAILS);
				ps1.setString(1, rollNmber);
				
				ResultSet rs1 = ps1.executeQuery();
				
				ResultSet rs = ps.executeQuery();
				String div1 = "rsiData";
				
				pw.println("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "  <title>Bootstrap Example</title>\r\n"
						+ "  <meta charset=\"utf-8\">\r\n"
						+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
						+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
						+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "\r\n"
						+ "<div class=\"container\">\r\n"
						+ "  <h2>Semester 4th</h2>\r\n"
						+ "  <p>Student 4th Semester Result Activity</p>\r\n");
						while(rs1.next()) {
							pw.println(""
									+ "<p>Roll Number: "+rs1.getString(5)+"</p>\r\n"
									+ "<p>Student Name: " +rs1.getString(2)+"/"+rs1.getString(6)+"</p>\r\n"
											+ "<p>Mother Name: "+rs1.getString(7)+"</p>\r\n"
													+ "<p>Branch: " +rs1.getString(4)+"</p>\r\n"
															+ "<p>Course: " +rs1.getString(3)+"</p>\r\n"
																	+ "<br>");
						}
						pw.println( "  <table class=\"table table-bordered\">\r\n"
						+ "    <thead>\r\n"
						+ "      <tr>\r\n"
						+ "        <th>Subject</th>\r\n"
						+ "        <th>Total Max Marks</th>\r\n"
						+ "        <th>Obt. Marks</th>\r\n"
						+ "        <th>Grades</th>\r\n"
						+ "        <th>Pass/Fail</th>\r\n"
						+ "      </tr>\r\n"
						+ "    </thead>\r\n"
						+ "    <tbody>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>CPP</td>\r\n"
						+ "        <td>100</td>\r\n");
				while(rs.next()) {
					pw.println("<td>"+rs.getInt(3)+"</td>\r\n");
					pw.println("<td>"+gradesInt3(rollNmber)+"</td>\r\n");
							pw.println("<td>"+pfSem4Int3()+"</td>\r\n");
							
						    pw.println("</tr>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>ADA</td>\r\n"
						+ "        <td>100</td>\r\n");
						   
						    
								pw.println("<td>"+rs.getInt(4)+"</td>\r\n");
								pw.println("<td>"+gradesInt4(rollNmber)+"</td>\r\n");
								pw.println("<td>"+pfSem4Int4()+"</td>\r\n");
							
						      pw.println("</tr>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>OS</td>\r\n"
						+ "        <td>100</td>\r\n");
						     
									pw.println("<td>"+rs.getInt(5)+"</td>\r\n");
									pw.println("<td>"+gradesInt5(rollNmber)+"</td>\r\n");
									pw.println("<td>"+pfSem4Int5()+"</td>\r\n");
								
						      pw.println("</tr>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>CSA</td>\r\n"
						+ "        <td>100</td>\r\n");
						      
									pw.println("<td>"+rs.getInt(6)+"</td>\r\n");
									pw.println("<td>"+gradesInt6(rollNmber)+"</td>\r\n");
									pw.println("<td>"+pfSem4Int6()+"</td>\r\n");
								
						    pw.println("</tr>\r\n"
						+ "      <tr>\r\n"
						+ "        <td>M-IV</td>\r\n"
						+ "        <td>100</td>\r\n");
						    
						    
						 
								pw.println("<td>"+rs.getInt(7)+"</td>\r\n");
								pw.println("<td>"+gradesInt7(rollNmber)+"</td>\r\n");
								pw.println("<td>"+pfSem4Int7()+"</td>\r\n");
								
								pw.println("</tr>\r\n"
										+ "      <tr>\r\n"
										+ "        <td>Total</td>\r\n"
										+ "        <td>500</td>\r\n");
								
								pw.println("<td>"+(rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7))+"</td>\r\n");
								
								pw.println("</tr>\r\n"
										+ "      <tr>\r\n"
										+ "        <td>Percantage</td>\r\n"
										);
								
								pw.println("<td>"+((rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7))/5)+"%"+"</td>\r\n");
								pw.println("<td>"+percantagePassFail()+"</td>\r\n");
								
			}
						   pw.println("</tr>\r\n"
						+ "    </tbody>\r\n"
						+ "  </table>\r\n"
						+ "</div>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			pw.println("Invalid Sem");
		}
		
		
	}
	
	public String gradesInt3(String rollno) {
		
		
		
		Connection con = JDBCCON.getConnection();
		System.out.println(con);
		
		final String SELECT_QUERY_SEM_3 = "select * from sem_3";
		final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_4);
			ps.setString(1,rollno );
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(3) <= 100 && rs.getInt(3) >= 80) {
					return "A+";
				} else if(rs.getInt(3) <= 79 && rs.getInt(3) >= 60) {
					return "A";
				} else if(rs.getInt(3) <= 59 && rs.getInt(3) >= 50) {
					return "B";
				} else if(rs.getInt(3) <= 49 && rs.getInt(3) >= 33) {
					return "C";
				} else {
					return "D";
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
		
		
		
	}
public String gradesInt4(String rollno) {
		
		Connection con = JDBCCON.getConnection();
		System.out.println(con);
		
		final String SELECT_QUERY_SEM_3 = "select * from sem_3";
		final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_4);
			ps.setString(1, rollno);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(4) <= 100 && rs.getInt(4) >= 80) {
					return "A+";
				} else if(rs.getInt(4) <= 79 && rs.getInt(4) >= 60) {
					return "A";
				} else if(rs.getInt(4) <= 59 && rs.getInt(4) >= 50) {
					return "B";
				} else if(rs.getInt(4) <= 49 && rs.getInt(4) >= 33) {
					return "C";
				} else {
					return "D";
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
		
		
		
	}

public String gradesInt5(String rollno) {
	
	Connection con = JDBCCON.getConnection();
	System.out.println(con);
	
	final String SELECT_QUERY_SEM_3 = "select * from sem_3";
	final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo = ?";
	
	try {
		PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_4);
		ps.setString(1, rollno);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			if(rs.getInt(5) <= 100 && rs.getInt(5) >= 80) {
				return "A+";
			} else if(rs.getInt(5) <= 79 && rs.getInt(5) >= 60) {
				return "A";
			} else if(rs.getInt(5) <= 59 && rs.getInt(5) >= 50) {
				return "B";
			} else if(rs.getInt(5) <= 49 && rs.getInt(5) >= 33) {
				return "C";
			} else {
				return "D";
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
	
	
	
	
}

public String gradesInt6(String rollno) {
	
	Connection con = JDBCCON.getConnection();
	System.out.println(con);
	
	final String SELECT_QUERY_SEM_3 = "select * from sem_3";
	final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo = ?";
	
	try {
		PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_4);
		ps.setString(1, rollno);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			if(rs.getInt(6) <= 100 && rs.getInt(6) >= 80) {
				return "A+";
			} else if(rs.getInt(6) <= 79 && rs.getInt(6) >= 60) {
				return "A";
			} else if(rs.getInt(6) <= 59 && rs.getInt(6) >= 50) {
				return "B";
			} else if(rs.getInt(6) <= 49 && rs.getInt(6) >= 33) {
				return "C";
			} else {
				return "D";
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
	
	
	
	
}

public String gradesInt7(String rollno) {
	
	Connection con = JDBCCON.getConnection();
	System.out.println(con);
	
	final String SELECT_QUERY_SEM_3 = "select * from sem_3";
	final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo = ?";
	
	try {
		PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_4);
		ps.setString(1, rollno);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			if(rs.getInt(7) <= 100 && rs.getInt(7) >= 80) {
				return "A+";
			} else if(rs.getInt(7) <= 79 && rs.getInt(7) >= 60) {
				return "A";
			} else if(rs.getInt(7) <= 59 && rs.getInt(7) >= 50) {
				return "B";
			} else if(rs.getInt(7) <= 49 && rs.getInt(7) >= 33) {
				return "C";
			} else {
				return "D";
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
	
}


public String gradesSemInt3(String rollno) {
	
	
	
	Connection con = JDBCCON.getConnection();
	System.out.println(con);
	
	final String SELECT_QUERY_SEM_3 = "select * from sem_3 where rollNo = ?";
	final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo=?";
	
	try {
		PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_3);
		ps.setString(1,rollno );
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			if(rs.getInt(3) <= 100 && rs.getInt(3) >= 80) {
				return "A+";
			} else if(rs.getInt(3) <= 79 && rs.getInt(3) >= 60) {
				return "A";
			} else if(rs.getInt(3) <= 59 && rs.getInt(3) >= 50) {
				return "B";
			} else if(rs.getInt(3) <= 49 && rs.getInt(3) >= 33) {
				return "C";
			} else {
				return "D";
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
	
	
	
	
}
public String gradesSemInt4(String rollno) {
	
	Connection con = JDBCCON.getConnection();
	System.out.println(con);
	
	final String SELECT_QUERY_SEM_3 = "select * from sem_3 where rollNo = ?";
	final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo = ?";
	
	try {
		PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_3);
		ps.setString(1, rollno);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			if(rs.getInt(4) <= 100 && rs.getInt(4) >= 80) {
				return "A+";
			} else if(rs.getInt(4) <= 79 && rs.getInt(4) >= 60) {
				return "A";
			} else if(rs.getInt(4) <= 59 && rs.getInt(4) >= 50) {
				return "B";
			} else if(rs.getInt(4) <= 49 && rs.getInt(4) >= 33) {
				return "C";
			} else {
				return "D";
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
	
	
	
	
}

public String gradesSemInt5(String rollno) {

Connection con = JDBCCON.getConnection();
System.out.println(con);

final String SELECT_QUERY_SEM_3 = "select * from sem_3 where rollNo = ?";
final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo = ?";

try {
	PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_3);
	ps.setString(1, rollno);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		if(rs.getInt(5) <= 100 && rs.getInt(5) >= 80) {
			return "A+";
		} else if(rs.getInt(5) <= 79 && rs.getInt(5) >= 60) {
			return "A";
		} else if(rs.getInt(5) <= 59 && rs.getInt(5) >= 50) {
			return "B";
		} else if(rs.getInt(5) <= 49 && rs.getInt(5) >= 33) {
			return "C";
		} else {
			return "D";
		}
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return "";




}

public String gradesSemInt6(String rollno) {

Connection con = JDBCCON.getConnection();
System.out.println(con);

final String SELECT_QUERY_SEM_3 = "select * from sem_3 where rollNo = ?";
final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo = ?";

try {
	PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_3);
	ps.setString(1, rollno);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		if(rs.getInt(6) <= 100 && rs.getInt(6) >= 80) {
			return "A+";
		} else if(rs.getInt(6) <= 79 && rs.getInt(6) >= 60) {
			return "A";
		} else if(rs.getInt(6) <= 59 && rs.getInt(6) >= 50) {
			return "B";
		} else if(rs.getInt(6) <= 49 && rs.getInt(6) >= 33) {
			return "C";
		} else {
			return "D";
		}
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return "";




}

public String gradesSemInt7(String rollno) {

Connection con = JDBCCON.getConnection();
System.out.println(con);

final String SELECT_QUERY_SEM_3 = "select * from sem_3 where rollNo = ?";
final String SELECT_QUERY_SEM_4 = "select * from sem_4 where rollNo = ?";

try {
	PreparedStatement ps = con.prepareStatement(SELECT_QUERY_SEM_3);
	ps.setString(1, rollno);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		if(rs.getInt(7) <= 100 && rs.getInt(7) >= 80) {
			return "A+";
		} else if(rs.getInt(7) <= 79 && rs.getInt(7) >= 60) {
			return "A";
		} else if(rs.getInt(7) <= 59 && rs.getInt(7) >= 50) {
			return "B";
		} else if(rs.getInt(7) <= 49 && rs.getInt(7) >= 33) {
			return "C";
		} else {
			return "D";
		}
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return "";

}



public String pfSem4Int3() {
	
//	String rollNmber = request.getParameter("stdRoll");
	
//	if(gradesInt3(roll).equalsIgnoreCase("A+") || gradesInt3(roll).equalsIgnoreCase("A") || gradesInt3(roll).equalsIgnoreCase("B") || gradesInt3(roll).equalsIgnoreCase("C")) {
//		
//		return "Pass";
//		
//	} else
//	if(gradesInt4(roll).equalsIgnoreCase("A+") || gradesInt4(roll).equalsIgnoreCase("A") || gradesInt4(roll).equalsIgnoreCase("B") || gradesInt4(roll).equalsIgnoreCase("C")){
//   return "Pass";		
//	} else if(gradesInt5(roll).equalsIgnoreCase("A+") || gradesInt5(roll).equalsIgnoreCase("A") || gradesInt5(roll).equalsIgnoreCase("B") || gradesInt5(roll).equalsIgnoreCase("C")) {
//	return "Pass";	
//	} else if(gradesInt6(roll).equalsIgnoreCase("A+") || gradesInt6(roll).equalsIgnoreCase("A") || gradesInt6(roll).equalsIgnoreCase("B") || gradesInt6(roll).equalsIgnoreCase("C")) {
//	return "Pass";	
//	} else if(gradesInt7(roll).equalsIgnoreCase("A+") || gradesInt7(roll).equalsIgnoreCase("A") || gradesInt7(roll).equalsIgnoreCase("B") || gradesInt7(roll).equalsIgnoreCase("C")) {
//return "Pass";		
//	} else {
//		return "Fail";
//	}
	
//	String grades = gradesInt3(roll);
//	System.out.println(grades);
//	
//	if(grades.equalsIgnoreCase("B") ||  ) {
//		return "Pass";
//	}
//	
//	return "Hathi";
//		
	
	
	if(gradesInt3(roll).equalsIgnoreCase("A+") || gradesInt3(roll).equalsIgnoreCase("A") || gradesInt3(roll).equalsIgnoreCase("B") || gradesInt3(roll).equalsIgnoreCase("C")) {
		
		passfail4 = "Pass";
		return "Pass";
		
		
	} else {
		passfail4 = "Fail";
		return "Fail";
	}
}


public String pfSem4Int4() {
	

	
	if(gradesInt4(roll).equalsIgnoreCase("A+") || gradesInt4(roll).equalsIgnoreCase("A") || gradesInt4(roll).equalsIgnoreCase("B") || gradesInt4(roll).equalsIgnoreCase("C")) {
		passfail4 = "Pass";
		return "Pass";
		
	} else {
		passfail4 = "Fail";
		return "Fail";
	}
}


public String pfSem4Int5() {
	

	
	if(gradesInt5(roll).equalsIgnoreCase("A+") || gradesInt5(roll).equalsIgnoreCase("A") || gradesInt5(roll).equalsIgnoreCase("B") || gradesInt5(roll).equalsIgnoreCase("C")) {
		passfail4 = "Pass";
		return "Pass";
		
	} else {
		passfail4 = "Fail";
		return "Fail";
	}
}

public String pfSem4Int6() {
	

	
	if(gradesInt6(roll).equalsIgnoreCase("A+") || gradesInt6(roll).equalsIgnoreCase("A") || gradesInt6(roll).equalsIgnoreCase("B") || gradesInt6(roll).equalsIgnoreCase("C")) {
		passfail4 = "Pass";
		return "Pass";
		
	} else {
		passfail4 = "Fail";
		return "Fail";
	}
}

public String pfSem4Int7() {
	

	
	if(gradesInt7(roll).equalsIgnoreCase("A+") || gradesInt7(roll).equalsIgnoreCase("A") || gradesInt7(roll).equalsIgnoreCase("B") || gradesInt7(roll).equalsIgnoreCase("C")) {
		passfail4 = "Pass";
		return "Pass";
		
	} else {
		passfail4 = "Fail";
		return "Fail";
	}
}


public String percantagePassFail() {
	if(passfail4.equalsIgnoreCase("Pass")) {
		return "Pass";
	} else {
		return "Fail";
	}
}


public String pfSem3Int3() {
	
//	String rollNmber = request.getParameter("stdRoll");
	
//	if(gradesInt3(roll).equalsIgnoreCase("A+") || gradesInt3(roll).equalsIgnoreCase("A") || gradesInt3(roll).equalsIgnoreCase("B") || gradesInt3(roll).equalsIgnoreCase("C")) {
//		
//		return "Pass";
//		
//	} else
//	if(gradesInt4(roll).equalsIgnoreCase("A+") || gradesInt4(roll).equalsIgnoreCase("A") || gradesInt4(roll).equalsIgnoreCase("B") || gradesInt4(roll).equalsIgnoreCase("C")){
//   return "Pass";		
//	} else if(gradesInt5(roll).equalsIgnoreCase("A+") || gradesInt5(roll).equalsIgnoreCase("A") || gradesInt5(roll).equalsIgnoreCase("B") || gradesInt5(roll).equalsIgnoreCase("C")) {
//	return "Pass";	
//	} else if(gradesInt6(roll).equalsIgnoreCase("A+") || gradesInt6(roll).equalsIgnoreCase("A") || gradesInt6(roll).equalsIgnoreCase("B") || gradesInt6(roll).equalsIgnoreCase("C")) {
//	return "Pass";	
//	} else if(gradesInt7(roll).equalsIgnoreCase("A+") || gradesInt7(roll).equalsIgnoreCase("A") || gradesInt7(roll).equalsIgnoreCase("B") || gradesInt7(roll).equalsIgnoreCase("C")) {
//return "Pass";		
//	} else {
//		return "Fail";
//	}
	
//	String grades = gradesInt3(roll);
//	System.out.println(grades);
//	
//	if(grades.equalsIgnoreCase("B") ||  ) {
//		return "Pass";
//	}
//	
//	return "Hathi";
//		
	
	
	if(gradesSemInt3(roll).equalsIgnoreCase("A+") || gradesSemInt3(roll).equalsIgnoreCase("A") || gradesSemInt3(roll).equalsIgnoreCase("B") || gradesSemInt3(roll).equalsIgnoreCase("C")) {
		passfail3 = "Pass";
		return "Pass";
		
	} else {
		passfail3 = "Fail";
		return "Fail";
	}
}


public String pfSem3Int4() {
	

	
	if(gradesSemInt4(roll).equalsIgnoreCase("A+") || gradesSemInt4(roll).equalsIgnoreCase("A") || gradesSemInt4(roll).equalsIgnoreCase("B") || gradesSemInt4(roll).equalsIgnoreCase("C")) {
		passfail3 = "Pass";
		return "Pass";
		
	} else {
		passfail3 = "Fail";
		return "Fail";
	}
}


public String pfSem3Int5() {
	

	
	if(gradesSemInt5(roll).equalsIgnoreCase("A+") || gradesSemInt5(roll).equalsIgnoreCase("A") || gradesSemInt5(roll).equalsIgnoreCase("B") || gradesSemInt5(roll).equalsIgnoreCase("C")) {
		passfail3 = "Pass";
		return "Pass";
		
	} else {
		passfail3 = "Pass";
		return "Fail";
	}
}

public String pfSem3Int6() {
	

	
	if(gradesSemInt6(roll).equalsIgnoreCase("A+") || gradesSemInt6(roll).equalsIgnoreCase("A") || gradesSemInt6(roll).equalsIgnoreCase("B") || gradesSemInt6(roll).equalsIgnoreCase("C")) {
		passfail3 = "Pass";
		return "Pass";
		
	} else {
		passfail3 = "Fail";
		return "Fail";
	}
}

public String pfSem3Int7() {
	

	
	if(gradesSemInt7(roll).equalsIgnoreCase("A+") || gradesSemInt7(roll).equalsIgnoreCase("A") || gradesSemInt7(roll).equalsIgnoreCase("B") || gradesSemInt7(roll).equalsIgnoreCase("C")) {
		passfail3 = "Pass";
		return "Pass";
		
	} else {
		passfail3 = "Fail";
		return "Fail";
	}
}

public String percantagePassFail3() {
	if(passfail3.equalsIgnoreCase("Pass")) {
		return "Pass";
	} else {
		return "Fail";
	}
}



}
