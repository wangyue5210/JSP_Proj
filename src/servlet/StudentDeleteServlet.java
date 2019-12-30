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
public class StudentDeleteServlet extends HttpServlet {
	
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		

		response.setContentType("text/html;charset=utf-8");
		
		
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="delete from tbl_student where id =?";
		
		
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.DBClose(conn, ps, null);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		response.sendRedirect("/ServletProject/student/list.do");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
