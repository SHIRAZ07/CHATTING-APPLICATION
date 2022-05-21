package cms;

import java.sql.*;

//import javax.servlet.http.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class student_login extends HttpServlet
{
	String url="jdbc:mysql://localhost:3306/student";
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		login(username,password);
		
	}
	public void login (String username,String password) throws SQLException
	{
		String query="select * from student_login where uname='"+username+"'and pass='"+password+"'";
		Class.forName("com,mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		if(rs.next())
		{
			System.out.print("YES YOU ARE LOGGED IN");
		}
		else
		{
			System.out.print("NO YOU HAVEN'T LOGGED IN");
		}
		
	}
	
}
