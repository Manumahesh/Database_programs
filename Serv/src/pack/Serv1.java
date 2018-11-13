package pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Serv1 extends HttpServlet 
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
		try 
		{
			PrintWriter pw=y.getWriter();
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<meta charset=\"ISO-8859-1\">");
			pw.println("<title>Insert title here</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<h1>hello</h1>");
			pw.println("</body>");
			pw.println("</html>");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
