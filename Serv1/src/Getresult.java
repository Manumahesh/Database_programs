

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import oracle.jdbc.OracleDriver;

public class Getresult extends HttpServlet 
{
	Connection con=null;
	//Statement stmt=null;
	PreparedStatement pstmt=null;
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String un="system";
	String pwd="system";
	ResultSet res=null;
	String a=null;
	String b=null;
	int c=0;
	int d=0;
	int f=0;
	float g=0.0f;
	PrintWriter pw=null;
	
	public void init()
	{
		try 
		{
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
		System.out.println("Process");
		try 
		{
			String temp=x.getParameter("USN");
			System.out.println("Process");
			pstmt=con.prepareStatement("Select * from FEB_BATCH where USN=?");
			pstmt.setString(1,temp);
			res=pstmt.executeQuery();
			System.out.println("Query executed");
			while(res.next()==true)
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
		catch (Exception e) 
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
