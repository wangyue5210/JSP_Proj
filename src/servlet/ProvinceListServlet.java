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

import domain.Province;

import util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class ProvinceListServlet extends HttpServlet {
	
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到省份操作");
		response.setContentType("text/html;charset=utf-8");
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select id,name from tbl_province ";
		List<Province> plist=new ArrayList<Province>();
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Province p=new Province();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				
				plist.add(p);
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
		buf.append("{\"plist\":[");
		for (int i = 0; i < plist.size(); i++) {
			Province p=plist.get(i);
			buf.append("{\"id\":");
			buf.append(p.getId());
			buf.append(",\"name\":\"");
			buf.append(p.getName());
			buf.append("\"}");
			if(i < plist.size()-1) {
				buf.append(",");
			}
		}
		buf.append("]}");
		
		PrintWriter out=response.getWriter();
		//System.out.println(buf.toString());
		out.print(buf.toString());
		out.close();
	
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
