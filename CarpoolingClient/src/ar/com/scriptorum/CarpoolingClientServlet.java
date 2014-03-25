package ar.com.scriptorum;

import java.io.IOException;

import javax.servlet.http.*;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.com.scriptorum.beans.Viaje;
import ar.com.scriptorum.dao.ViajeDao;

@SuppressWarnings("serial")
public class CarpoolingClientServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		ViajeDao dao = (ViajeDao) context.getBean("viajeDao");
		for(Viaje viaje:dao.findAll()) {
			resp.getWriter().println(viaje);
		}
		resp.getWriter().println("these were viajes");
	}
}
