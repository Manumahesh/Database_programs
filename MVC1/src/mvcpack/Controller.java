package mvcpack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet 
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
		String temp=null;
		try
		{
			temp=x.getParameter("USN");
			Model m=new Model();
			m.setUsn(temp);
			boolean b=m.getResult();
			if(b==true)
			{
				HttpSession hs=x.getSession(true);
				hs.setAttribute("NAME", m.getName());
				hs.setAttribute("MARKS1", m.getMarks1());
				hs.setAttribute("MARKS2", m.getMarks2());
				hs.setAttribute("MARKS3", m.getMarks3());
				y.sendRedirect("/MVC1/Disp.jsp");
			}
			else
			{
				y.sendRedirect("/MVC1/InvalidUSN.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}