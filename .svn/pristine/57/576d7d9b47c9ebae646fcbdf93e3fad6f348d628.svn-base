package kr.or.ddit.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class DefCompFilter
 */
@WebFilter("/defCompServlet	")	// 사용 하는 servlet 과 어노테이션이 같아야 사용 가능
public class DefCompFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(DefCompFilter.class);
	
    public DefCompFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 전처리
		HttpServletRequest req = (HttpServletRequest) request;	// filter 
		
		logger.debug(req.getRequestURI() + " : DefCompFilter doFilter");  // DefCompFilter 에 들어 왔을떄 확실 할수 있는 구분
		
		// lock이 걸려 있는 map 객체간 임의 등록이 불가능하다.
//		Map<String, String[]> requestMap =  req.getParameterMap();	// wrapper
//		requestMap.put("defComp", new String[] {"valueByFilter"});	// wrapper
		// ∴ wrapper 를 이용함

		DefCompWrapper defCompWrapper =  new DefCompWrapper(req);
//		defCompWrapper.getParameter("name");
		
		// filter /servlet 요청 저리
		chain.doFilter(defCompWrapper, response);
		
		// 후처리
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
