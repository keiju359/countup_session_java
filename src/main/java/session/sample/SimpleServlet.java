package session.sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SimpleServlet extends HttpServlet
{
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	try{
    		 HttpSession session = req.getSession();    		 
    		 Integer count = (Integer) session.getAttribute("count");
    		 if (count == null) {
    			 count = 1;
    		 } else {
    			 count += 1;
    		 }
    		 session.setAttribute("count", count);
    		 resp.getWriter().write("<html> <body><h1>count:" + count + "</h1></body></html>");
		} catch (Exception e) {
    		System.out.println("例外:" + e.getMessage());
		}
    }
}
