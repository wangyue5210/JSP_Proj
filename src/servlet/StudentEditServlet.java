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
public class StudentEditServlet extends HttpServlet {
	
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到修改学生信息列表操作");
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		
		
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select name,age from tbl_student where id=?;";
		Student student=new Student();
		
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				student.setId(id);
				student.setName(rs.getString(1));
				student.setAge(rs.getInt(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.DBClose(conn, ps, rs);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		//把查询到的学生信息存到request域，然后转发到edit.jsp
		request.setAttribute("student", student);
		request.getRequestDispatcher("/jsp/student/edit.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
