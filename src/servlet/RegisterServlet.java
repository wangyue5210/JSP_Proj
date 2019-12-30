package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class RegisterServlet extends HttpServlet {
	
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		response.setContentType("text/html;charset=utf-8");
		
		
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into tbl_user(username,password) values(?,?)";
		
		
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.DBClose(conn, ps, null);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		response.sendRedirect("/ServletProject/RegisterSuccess.html");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
