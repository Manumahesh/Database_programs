package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jsql 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		String url="jdbc:oracle:thin:@//192.168.0.3:1521/XE";
				String un="system";
				String pwd="system";
				ResultSet res=null;
		String a=null;
		String b=null;
		int c=0;
		int d=0;
		int f=0;
		float g=0.0f;
		try
		{
			Class.forName("oracle.jdbc.driver.oracleDriver");
			System.out.println("driver loaded successfully");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("unable to load the dreiver");
		}

		try
		{
			con=DriverManager.getConnection(url,un,pwd);
			System.out.println("connection established successfully");
		}
		catch(Exception e)
		{
			System.out.println("unable to establish connection");
		}
		try
		{
			stmt=con.createStatement();
			res=stmt.executeQuery("Query executed successfuly");
		}
		catch(Exception e) 
		{
			System.out.println("unable to execute query");
		}
		try
		{		
			while(res.next()==true)
			{
				a=res.getString("USN");
				b=res.getString("NAME");
				c=res.getInt("MARKS1");
				d=res.getInt("MARKS2");
				f=res.getInt("MARKS3");
				g=res.getFloat("AVG");
				System.out.println(a+""+b+""+c+""+d+""+f+""+g);
			}
		}
		catch(Exception e)
		{
			System.out.println("unable to print result set");
		}
	}

}
