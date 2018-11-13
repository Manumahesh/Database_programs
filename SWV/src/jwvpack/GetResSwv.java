package jwvpack;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.OracleDriver;

public class GetResSwv extends HttpServlet
{
	Connection con=null;
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String un="System";
	String pwd="System";
	PreparedStatement pstmt=null;
	ResultSet res=null;
	String a=null;
	String b=null;
	int c=0;
	int d=0;
	int f=0;
	float g=0.0f;
	PrintWriter pw;
	
	public void init()
	{
		try {
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection(url,un,pwd);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
		try
		{
			String temp=x.getParameter("USN");
			if(temp.length()!=10)
			{
				pw=y.getWriter();
				pw.println("USN incorrect...!");
			}
			else
			{
				pstmt=con.prepareStatement("Select * from FEB_BATCH where USN=?");
				pstmt.setString(1,temp);
				res=pstmt.executeQuery();
				while(res.next())
				{
					a=res.getString(1);
					b=res.getString(2);
					c=res.getInt(3);
					d=res.getInt(4);
					f=res.getInt(5);
					g=res.getFloat(6);
					
					pw=y.getWriter();
					pw.println(a);
					pw.println(b);
					pw.println(c);
					pw.println(d);
					pw.println(f);
					pw.println(g);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void destory()
	{
		try 
		{
			con.close();
			pstmt.close();
			res.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
