package basic.web.app;

import java.io.IOException;
import java.util.Random;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class LottoTag extends SimpleTagSupport {

	private int size = 8;
	private String id;
	private static Random rdm = new Random();

	public void setSize(int value) { size = value; }

	public void setId(String name) { id = name; }

	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = getJspContext();
		JspFragment body = getJspBody();
		for(int i = 0; i < size; ++i){
			int val = rdm.nextInt(10);
			context.setAttribute(id, val);
			body.invoke(null);
		}
	}
}

