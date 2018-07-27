package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class RequesrCounterFilter
 */
//@WebFilter("/RequesrCounterFilter")
public class RequesrCounterFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(RequesrCounterFilter.class);
	
	private Map<String, Integer> requestCountMap = new HashMap<String, Integer>();
	
	public void destroy() {
		
	}
	

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//	application 사용
		ServletContext sc = request.getServletContext();
		sc.setAttribute("requestCounter", requestCountMap);
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		// 전처리 
		logger.debug(req.getRequestURI());
		
		// map객체에 uri를 키로하고, 값: 해당 uri요청된 횟수 지정
		Integer count = requestCountMap.get(req.getRequestURI());
//		count++;
//		requestCountMap.put(req.getRequestURI(), count); 과 같은 표현식 
		count = count == null ? 0 : count;
		requestCountMap.put(req.getRequestURI(), ++count);
		
		
		// 다른 필터, 혹은 더이상의 필터가 없을 경우 요청에 대한 servlet으로 전달. 
		chain.doFilter(request, response);
		
		// 후처리 
	}

	
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
