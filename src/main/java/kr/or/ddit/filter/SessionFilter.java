package kr.or.ddit.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.jspboard.model.JspBoardVo;
import kr.or.ddit.jspboard.model.JspStudentVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class HttpServletRequestFilter
 */
@WebFilter("/sessionFilter")
public class SessionFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(SessionFilter.class);

	public SessionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)req;

		StringBuffer url = request.getRequestURL();
		logger.debug("request Url : " + url);

		if(url.toString().endsWith(".js") 
				|| url.toString().endsWith(".css")
				|| url.toString().endsWith(".jpg")
				|| url.toString().endsWith(".gif")
				|| url.toString().endsWith(".ico")
				|| url.toString().endsWith(".png")
				|| url.toString().contains("/login.jsp")
				|| url.toString().contains("/loginServlet")
				|| url.toString().contains("/SE2/photo_uploade")
				) {
			logger.debug("SessionFilter ByPass");
			chain.doFilter(req, res);
		}
		else {
			HttpSession session = request.getSession();
			JspStudentVo sessionVo = (JspStudentVo)session.getAttribute("jspStudentVo");

			if(sessionVo == null || sessionVo.getStd_id() == null || sessionVo.getStd_id().equals("")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
				dispatcher.forward(req, res);
			} else {
//				if(session.getAttribute("menuBoardList") != null) {
//					request.removeAttribute("menuBoardList");
//				}
//				JspBoardServiceInf jspBoardService = new JspBoardService();
//				List<JspBoardVo> jspBoardList = jspBoardService.selectJspBoardList(sessionVo.getStd_id());
//				request.setAttribute("menuBoardList", jspBoardList);
				chain.doFilter(req, res);
			}
		}
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
