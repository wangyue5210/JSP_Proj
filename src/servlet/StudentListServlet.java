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
public class StudentListServlet extends HttpServlet {
	
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到学生信息列表操作");
		response.setContentType("text/html;charset=utf-8");
		
		Connection conn2=null;
		PreparedStatement ps2=null;
		ResultSet rs2=null;
		String sql2="select id,name,age from tbl_student ";
		List<Student> list=new ArrayList<Student>();
		try {
			conn2=DBUtil.getConnection();
			ps2=conn2.prepareStatement(sql2);
			rs2=ps2.executeQuery();
			while (rs2.next()) {
				Student s=new Student();
				s.setId(rs2.getString(1));
				s.setName(rs2.getString(2));
				s.setAge(rs2.getInt(3));
				list.add(s);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				DBUtil.DBClose(conn2, ps2, rs2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.setContentType("text/html;charset=utf-8");
		int count=(int) this.getServletContext().getAttribute("count");
		PrintWriter out=response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table border='1'>");
		
		out.print("<tr >");
		out.print("<td colspan='5'>");
		out.print("当前访问人数为:"+count+"人");
		out.print("</td>");
		out.print("</tr>");
		
		
		out.print("<tr>");
		
		out.print("<td>");
		out.print("编号");
		out.print("</td>");
		
		out.print("<td>");
		out.print("id");
		out.print("</td>");
		
		out.print("<td>");
		out.print("姓名");
		out.print("</td>");
		
		out.print("<td>");
		out.print("年龄");
		out.print("</td>");
		
		out.print("<td>");
		out.print("操作");
		out.print("</td>");
		
		out.print("</tr>");

		
		for (int i = 0; i <list.size(); i++) {
			Student student=list.get(i);
			out.print("<tr>");
			
			out.print("<td>");
			out.print(i+1);
			out.print("</td>");
			
			out.print("<td>");
			out.print(student.getId());
			out.print("</td>");
			
			out.print("<td>");
			out.print(student.getName());
			out.print("</td>");
			
			out.print("<td>");
			out.print(student.getAge());
			out.print("</td>");
			
			out.print("<td>");
			out.print("<a href='/ServletProject/student/delete.do?id="+student.getId()+"' >删除</a>");
			out.print("</td>");
			
			out.print("</tr>");
			
		}
		out.print("</table>");
		out.print("</body>");
		
		
		
		out.print("</html>");
		
		
	    
		out.close();
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
