package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefCompWrapper extends HttpServletRequestWrapper{

	private Map<String, String[]> map ;
	
	public DefCompWrapper(HttpServletRequest request) {
		super(request);
//		request.getParameter(name);
//		request.getParameterValues(name);
//		request.getParameterMap();		
//		request.getParameterNames();
		
		// 기존 request 객체의 파라미터 map을 복사
		map = new HashMap<String, String[]>(request.getParameterMap());
		
		// defComp 파라미터를 확인하고 없으면 등록
		String[] defComps = map.get("defComp");
		System.out.println("test");
		System.out.println(defComps);
		// defComp 파라미터가 null 혹은 whiteSpace인 경우 --> 기본값으로 설정
		if (defComps == null || defComps[0].equals("")){
			map.put("defComp", new String[] {"defCompValue"});
		}
	}

//	@Override
	/**
	 * Method : getParameter
	 * 최초작성일 : 2018. 7. 16.
	 * 작성자 : PC07
	 * 변경이력 :
	 * @param name
	 * @return
	 * Method 설명 :
	 */
	@Override
	public String getParameter(String name) {
		// 기존에 재정의한 getParameterValues(name) 이용
		String[] values = getParameterValues(name);
		if (values != null) {
			return values[0];
		} else {
			return null; 
		}
	}

	/**
	 * Method : getParameterMap
	 * 최초작성일 : 2018. 7. 16.
	 * 작성자 : PC07
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	@Override
	public Map<String, String[]> getParameterMap() {
//		return super.getParameterMap();
		return map;	// 클래스안에서 만든 map 을 그대로 return
	}

	/**
	 * Method : getParameterNames
	 * 최초작성일 : 2018. 7. 16.
	 * 작성자 : PC07
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(map.keySet());	// key 는 paramet 이름을 의미
	}

	/**
	 * Method : getParameterValues
	 * 최초작성일 : 2018. 7. 16.
	 * 작성자 : PC07
	 * 변경이력 :
	 * @param name
	 * @return
	 * Method 설명 :
	 */
	@Override
	public String[] getParameterValues(String name) {
		return 	map.get(name);	// // 클래스안에서 만든 map안의 name 을 return
	}

}




















