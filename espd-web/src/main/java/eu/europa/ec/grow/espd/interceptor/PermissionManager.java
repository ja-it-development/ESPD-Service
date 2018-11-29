package eu.europa.ec.grow.espd.interceptor;

import eu.europa.ec.grow.espd.service.ESOPDBConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j

public class PermissionManager implements HandlerInterceptor {

	private static final String ESOP_NOACCESS_PAGE = "/esop/return/err";

	@Autowired
	ESOPDBConnector esopdbConnector;

	// This method is called before the controller
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			HttpSession session = request.getSession();
			Object evid = session.getAttribute("ESOP_VISITORID");
			if (evid != null) {
				log.info("Access granted");
				return true;
			} else {
				response.sendRedirect(getFullBaseURL(request) + ESOP_NOACCESS_PAGE);
				log.warn("Access denied");
				return false;
			}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	private String getFullBaseURL (HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}

}