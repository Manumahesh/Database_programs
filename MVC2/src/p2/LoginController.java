package p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet 
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
		String temp1=null;
		String temp2=null;
		
		try
		{
			temp1=x.getParameter("usn");
			temp2=x.getParameter("name");
			Model m=new Model();
			m.setUsn(temp1);
			m.setName(temp2);
			boolean b=m.login();
			if(b==true)
				y.sendRedirect("/MVC2/LoginSuccess.jsp");
			else
				y.sendRedirect("/MVC2/LoginFailure.html");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
