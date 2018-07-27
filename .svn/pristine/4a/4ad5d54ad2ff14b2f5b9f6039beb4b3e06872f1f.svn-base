package kr.or.ddit.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.jspboard.model.JspStudentVo;

public class SessionUtil {

	public static JspStudentVo getUserSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session == null) {
			return null;
		}
		return (JspStudentVo) session.getAttribute("jspStudentVo");
	}
	
	public static String getSessionStdId(HttpServletRequest request) {
		return getUserSession(request).getStd_id();
	}
	
	public static boolean checkUser(HttpServletRequest request) {
		JspStudentVo sessionVo = getUserSession(request);
		return sessionVo != null 
				&& sessionVo.getStd_id() != null 
				&& sessionVo.getStd_id().equals("");
	}
	
}
