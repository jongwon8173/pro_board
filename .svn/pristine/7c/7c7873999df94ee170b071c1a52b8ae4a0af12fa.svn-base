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
public class HttpServletRequestFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(HttpServletRequestFilter.class);

	public HttpServletRequestFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 전처리
		HttpServletRequest req = (HttpServletRequest) request;	// filter 
		
		logger.debug(req.getRequestURI() + " : Session doFilter");  // DefCompFilter 에 들어 왔을떄 확실 할수 있는 구분
		
		HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(req);
		
		// filter /servlet 요청 저리
		chain.doFilter(httpServletRequestWrapper, response);
		
		// 후처리
		
	}
	
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
