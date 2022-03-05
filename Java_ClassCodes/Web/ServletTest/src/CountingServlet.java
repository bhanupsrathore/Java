package basic.web.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/count")
public class CountingServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("user");
		if(name.length() == 0){
			response.sendRedirect("welcome.gws");
			return;
		}
		HttpSession session = request.getSession(true);
		Integer n = (Integer)session.getAttribute(name);
		if(n == null) n = 1;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>BasicWebApp</title></head>");
		out.println("<body>");
		out.printf("<h1>Hello %s</h1>%n", name);
		out.printf("<b>Number of greetings: %d</b>%n", n);
		out.println("</body>");
		out.println("</html>");
		out.close();
		session.setAttribute(name, n + 1);
		if(n > 5)
			session.invalidate();
	}
}

