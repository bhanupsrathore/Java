package basic.web.app;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ClockTag implements SimpleTag {

	private JspContext context;
	private JspFragment body;
	private JspTag parent;
	private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");

	public void setJspContext(JspContext value) { context = value; }

	public void setJspBody(JspFragment value) { body = value; }

	public void setParent(JspTag value) { parent = value; }
	public JspTag getParent() { return parent; }

	public void setFormat(String value) { formatter.applyPattern(value); }

	public void doTag() throws JspException, IOException {
		JspWriter page = context.getOut();
		Date now = new Date();
		page.print(formatter.format(now));
	}
}

