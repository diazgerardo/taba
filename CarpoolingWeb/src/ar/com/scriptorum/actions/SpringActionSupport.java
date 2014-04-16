package ar.com.scriptorum.actions;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

public class SpringActionSupport extends ActionSupport {

	private static final long serialVersionUID = 1L;
	protected WebApplicationContext context;
	public SpringActionSupport() {
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(
	                                    ServletActionContext.getServletContext()
	              );
	}
}
