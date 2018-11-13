

import java.io.IOException;
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
			y.sendRedirect("/Serv/Hello.html");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
