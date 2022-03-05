package basic.web.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebFilter("/*")
public class PausingFilter implements Filter {

	private long last;

	public void init(FilterConfig config) {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
		long now = System.currentTimeMillis();
		if(now - last > 5000){
			last = now;
			next.doFilter(request, response);
		}
		else{
			PrintWriter out = response.getWriter();
			out.println("Server busy, please try after some time...");
			out.close();
		}
	}

	public void destroy() {}
}

