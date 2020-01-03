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

import domain.City;
import domain.Province;

import util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class CityListServlet extends HttpServlet {
	
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到城市操作");
		response.setContentType("text/html;charset=utf-8");
		String pidString=request.getParameter("pid");
		int pid=Integer.parseInt(pidString);
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select id,name from tbl_city where pid=?";
		List<City> clist=new ArrayList<City>();
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pid);
			
			rs=ps.executeQuery();
			while (rs.next()) {
				City c=new City();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				
				clist.add(c);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				DBUtil.DBClose(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//{"plist":[{"id":?,"name":"?"},{},{}]}
		
		StringBuffer buf=new StringBuffer();
		buf.append("{\"clist\":[");
		for (int i = 0; i < clist.size(); i++) {
			City c=clist.get(i);
			buf.append("{\"id\":");
			buf.append(c.getId());
			buf.append(",\"name\":\"");
			buf.append(c.getName());
			buf.append("\"}");
			if(i < clist.size()-1) {
				buf.append(",");
			}
		}
		buf.append("]}");
		
		PrintWriter out=response.getWriter();
		System.out.println(buf.toString());
		out.print(buf.toString());
		out.close();
	
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
