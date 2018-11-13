<%@ page import="oracle.jdbc.OracleDriver"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.http.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!Connection con=null;
PreparedStatement pstmt=null;
String url="jdbc:oracle:thin:@//localhost:1521/XE";
String un="System";
String pwd="System";
ResultSet res=null;
String a=null;
String b=null;
int c=0;
int d=0;
int f=0;
float g=0.0f; %>

<%!public void jspInit()
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
} %>

<%!public void jspDestory()
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
%>

<%try 
{
	String temp=request.getParameter("USN");
	pstmt=con.prepareStatement("Select * from FEB_BATCH where USN=?");
	pstmt.setString(1,temp);
	res=pstmt.executeQuery();
	while(res.next()==true)
	{
		a=res.getString(1);
		b=res.getString(2);
		c=res.getInt(3);
		d=res.getInt(4);
		f=res.getInt(5);
		g=res.getFloat(6);
		
		PrintWriter pw=response.getWriter();
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
}%>
</body>
</html>