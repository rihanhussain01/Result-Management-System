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


public class ShowResultsSem3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		Connection con = JDBCCON.getConnection();
		
		final String SELECT_QUERY = "select * from sem_3";
		
		try {
			PreparedStatement ps =  con.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			pw.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" \r\n"
					+ "    integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\r\n"
					+ "    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\" integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\" crossorigin=\"anonymous\">\r\n"
					+ "    </script>\r\n"
					+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js\" \r\n"
					+ "    integrity=\"sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT\" crossorigin=\"anonymous\">\r\n"
					+ "    </script>\r\n"
					+ "    <link rel=\"stylesheet\" href=\"first.css\">\r\n"
					+ "    <title>My First</title>\r\n"
					+ "</head>\r\n"
					+ "<style>\r\n"
					+ "    .myBranded {\r\n"
					+ "        color: white;\r\n"
					+ "        size: 30px;\r\n"
					+"			font-family : cursive;\r\n"		
					+ "    }\r\n"
					+ "    \r\n"
					+ "    .submit-btn {\r\n"
					+ "    background-color:  #Ffb600;\r\n"
					+ "    color: white;\r\n"
					+ "    font-size: 17px;\r\n"
					+ "    \r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    .dropdown {\r\n"
					+ "    text-decoration: none;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    \r\n"
					+ "body {\r\n"
					
					+ "background-size: contain;\r\n"
					+ "background-attachment: fixed;\r\n"
					+ "background-position: inherit;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".form-group input {\r\n"
					+ "border-radius: 30px;\r\n"
					+ "padding : 5px;\r\n"
					+ "padding-left: 17px;\r\n"
					+ "\r\n"
					+ "} \r\n"
					+ "\r\n"
					+ ".dropdown-item:hover {\r\n"
					+ "background-color: gray;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".nav-item:hover {\r\n"
					+ "background-color: #3385ff;\r\n"
					+ "border-radius: 5px;\r\n"
					+ "margin-left: 30px;\r\n"
					+ "}\r\n"
					+ ".nav-item {\r\n"
					
					+ "border-radius: 5px;\r\n"
					+ "margin-left: 20px;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ " .form-horizontal  input{\r\n"
					+ "display: inline-block;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".form-group {\r\n"
					+ "display: flex;\r\n"
					+ "}\r\n"
					+ ".email_label {\r\n"
					+ "justify-content: right;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "/*  .fm1 {\r\n"
					+ "background-color: gray;\r\n"
					+ "padding-left: 20px;\r\n"
					+ "padding-right: 20px;\r\n"
					+ "padding-top: 10px;\r\n"
					+ "padding-bottom: 10px;\r\n"
					+ "border-radius: 40px\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".fm2 {\r\n"
					+ "background-color: #Edeeec;\r\n"
					+ "padding-left: 20px;\r\n"
					+ "padding-right: 20px;\r\n"
					+ "padding-top: 10px;\r\n"
					+ "padding-bottom: 10px;\r\n"
					+ "border-radius: 40px\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".fm3 {\r\n"
					+ "background-color: gray;\r\n"
					+ "padding-left: 20px;\r\n"
					+ "padding-right: 20px;\r\n"
					+ "padding-top: 10px;\r\n"
					+ "padding-bottom: 10px;\r\n"
					+ "border-radius: 40px\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".fm4 {\r\n"
					+ "background-color: #Edeeec;\r\n"
					+ "padding-left: 20px;\r\n"
					+ "padding-right: 20px;\r\n"
					+ "padding-top: 10px;\r\n"
					+ "padding-bottom: 10px;\r\n"
					+ "border-radius: 40px\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".fm5 {\r\n"
					+ "background-color: gray;\r\n"
					+ "padding-left: 20px;\r\n"
					+ "padding-right: 20px;\r\n"
					+ "padding-top: 10px;\r\n"
					+ "padding-bottom: 10px;\r\n"
					+ "border-radius: 40px\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".fm6 {\r\n"
					+ "background-color: #Edeeec;\r\n"
					+ "padding-left: 20px;\r\n"
					+ "padding-right: 20px;\r\n"
					+ "padding-top: 10px;\r\n"
					+ "padding-bottom: 10px;\r\n"
					+ "border-radius: 40px\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".fm7 {\r\n"
					+ "background-color: gray;\r\n"
					+ "padding-left: 20px;\r\n"
					+ "padding-right: 20px;\r\n"
					+ "padding-top: 10px;\r\n"
					+ "padding-bottom: 10px;\r\n"
					+ "border-radius: 40px\r\n"
					+ "}  */\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</style>\r\n"
					+ "<body>\r\n"
					+ "    <nav class=\"navbar navbar-expand-lg navbar-light bg-primary\">\r\n"
					+ "        <div class=\"container\">\r\n"
					+ "         <a class=\"navbar-brand myBranded text-white\" href=\"#\">MY NAVBAR</a>\r\n"
					+ "          <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" \r\n"
					+ "          aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation close\">\r\n"
					+ "            <span class=\"navbar-toggler-icon\"></span>\r\n"
					+ "          </button>\r\n"
					+ "          <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
					+ "            <ul class=\"navbar-nav me-auto mb-2 mb-lg-0 m-auto\">\r\n"
					+ "              <li class=\"nav-item\">\r\n"
					+ "                <a class=\"nav-link text-white\" aria-current=\"page\" href=\"resultInsert.html\">Add New Students</a>\r\n"
					+ "              </li>\r\n"
					+ "              \r\n"
					+ "              <li class=\"nav-item dropdown\">\r\n"
					+ "                <a class=\"nav-link dropdown-toggle text-white\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
					+ "                  Insert Results\r\n"
					+ "                </a>\r\n"
					+ "                <ul class=\"dropdown-menu  bg-dark\" aria-labelledby=\"navbarDropdown\">\r\n"
					
					+ "                  <li><a class=\"dropdown-item text-white\" href=\"#\">Sem 1</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item text-white\" href=\"#\">Sem 2</a></li>\r\n"
					+ "					<li><hr class=\"dropdown-divider bg-white\"></li>\r\n"	
					+ "                  <li><a class=\"dropdown-item text-white \" href=\"semester3.html\">Sem 3</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item text-white \" href=\"semester4.html\">Sem 4</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item text-white \" href=\"semester5.html\">Sem 5</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item  text-white\" href=\"semester6.html\">Sem 6</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item  text-white\" href=\"semester7.html\">Sem 7</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item text-white\" href=\"semester8.html\">Sem 8</a></li>\r\n"
					+ "                  \r\n"
					
					+ "                </ul>\r\n"
					+ "\r\n"
					+ "              </li>\r\n"
					+ "<li class=\"nav-item dropdown\">\r\n"
					+ "                <a class=\"nav-link dropdown-toggle text-white\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
					+ "                  Show Insert Results\r\n"
					+ "                </a>\r\n"
					+ "                <ul class=\"dropdown-menu  bg-dark\" aria-labelledby=\"navbarDropdown\">\r\n"
				
					+ "                  <li><a class=\"dropdown-item text-white\" href=\"#\">Sem 1</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item text-white\" href=\"#\">Sem 2</a></li>\r\n"
					+ "                  <li><hr class=\"dropdown-divider bg-white\"></li>\r\n"
					+ "                  <li><a class=\"dropdown-item text-white \" href=\"ShowResultsSem3\">Sem 3</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item text-white \" href=\"ShowResultsSem4\">Sem 4</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item text-white \" href=\"#\">Sem 5</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item  text-white\" href=\"#\">Sem 6</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item  text-white\" href=\"#\">Sem 7</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item text-white\" href=\"#\">Sem 8</a></li>\r\n"
					+ "                  \r\n"
					
					+ "                </ul>\r\n"
					+ "\r\n"
					+ "              </li>"
					+ "\r\n"
					+ "              \r\n"
					+ "				\r\n"
					+ "              \r\n"
					+ "               <li class=\"nav-item\">\r\n"
					+ "                <a class=\"nav-link text-white\" href=\"AllStudentDetails\">All Students Details</a>\r\n"
					+ "              </li>\r\n"
					+ "              \r\n"
					+ "               <li class=\"nav-item\">\r\n"
					+ "                <a class=\"nav-link text-white\" href=\"index.html\">Logout</a>\r\n"
					+ "              </li>\r\n"
					+ "              \r\n"
					+ "              \r\n"
					+ "\r\n"
					+ "              \r\n"
					+ "            </ul>\r\n"
					+ "            \r\n"
					+ "          </div>\r\n"
					+ "        </div>\r\n"
					+ "      </nav>"
					+" <table class=\"table table-bordered\">\r\n"
							+ "    <thead>\r\n"
							+ "      <tr>\r\n"
							+ "        <th>S. No.</th>\r\n"
							+ "        <th>Roll Number</th>\r\n"
							+ "        <th>CCWT</th>\r\n"
							+ "<th>C</th>\r\n"
							+ "<th>DLD</th>\r\n"
							+ "<th>BE</th>\r\n"
							+ "<th>M-III</th>\r\n"
							+ "<th>Action</th>\r\n"
							
							+ "      </tr>\r\n"
							+ "    </thead>\r\n"
							+ "    <tbody>\r\n"
							+ "      <tr>\r\n"
							);
					while(rs.next()) {
						pw.println("<td>"+rs.getInt(1)+"</td>\r\n"
							+ "<td name=\"rollnumber\">"+rs.getString(2)+"</td>\r\n"
									+"<td>"+rs.getString(3)+"</td>\r\n"
									+ "<td>"+rs.getString(4)+"</td>\r\n"
									+ "<td>"+rs.getString(5)+"</td>\r\n"
									+ "<td>"+rs.getString(6)+"</td>\r\n"
									+"<td>"+rs.getString(7)+"</td>\r\n"
									+"<td>"+"<a href=\"#\">Edit</a><span>  </span><span>  </span><a href=\"#\">Delete</a>"+"</td>\r\n"
									
									+"</tr>\r\n");
					}
							   pw.println(
							 "    </tbody>\r\n"
							+ "  </table>\r\n"
							+ "</div>\r\n"
							+ "\r\n"
					+ "</body"
					+ "</html>"
					);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
