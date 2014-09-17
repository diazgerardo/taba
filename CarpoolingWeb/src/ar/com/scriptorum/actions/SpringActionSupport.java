package ar.com.scriptorum.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SpringActionSupport extends ActionSupport {

    private static final long serialVersionUID = 1L;
    protected WebApplicationContext context;

    public SpringActionSupport() {
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
    }

    protected Boolean getSortDirection() {
        Boolean direction = Boolean.FALSE;
        Object obj = getHttpSession().getAttribute("sortDirection");
        if (obj != null) {
            direction = (Boolean) obj;
        }
        getHttpSession().setAttribute("sortDirection", !direction);
        return direction;
    }

    protected HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    protected HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    }

}
