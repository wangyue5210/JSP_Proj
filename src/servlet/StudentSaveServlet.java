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
public class StudentSaveServlet extends HttpServlet {
	
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String ageString=request.getParameter("age");
		int age=Integer.parseInt(ageString);
		System.out.println(name);
		
		
		
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into tbl_student(id,name,age) values(?,?,?) ";
		
		
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, util.UUIDUtil.getUUID());
			ps.setString(2, name);
			ps.setInt(3, age);
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
		
		
		response.sendRedirect(request.getContextPath()+"/student/list.do");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
