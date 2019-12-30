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
public class LoginServlet extends HttpServlet {
	
    
@Override
	public void init() throws ServletException {
		int count=0;
		this.getServletContext().setAttribute("count", count);
		//在servlet初始化的时候，将值存进上下文对象
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
//		System.out.println(name+pass);
		response.setContentType("text/html;charset=utf-8");
		
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select count(*) from tbl_user where username=? and password=?";
		boolean flag=true;
		
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if (rs.next()) {
				int count=rs.getInt(1);
				
				if (count!=1) {
					flag=false;
				}
				
				
				
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
		
		if (flag) {
		int count = (int) this.getServletContext().getAttribute("count");
		count++;
		this.getServletContext().setAttribute("count", count);
			response.sendRedirect("/ServletProject/student/list.do");
			
		}else {
			
			
			//设置响应头信息
			/*
			 * response.setHeader("refresh","3,url=/ServletProject/login.html" );
			 * PrintWriter out=response.getWriter(); out.print("<html>");
			 * out.print("<body>"); out.print("登录失败,三秒钟之后跳转到登录页"); out.print("</body>");
			 * out.print("</html>"); out.close();
			 */
			
			response.sendRedirect("/ServletProject/LoginFail.html");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
