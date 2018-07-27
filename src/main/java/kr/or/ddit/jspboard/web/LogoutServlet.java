package kr.or.ddit.jspboard.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그아웃 상황
		// 1. logout 요청시 session 무효화 작업
		// 2. login.jsp redirect 
		
		// 기존의 session 획득
		HttpSession session =  request.getSession();
		
		// 기존의 session 을 초기화
		session.invalidate();

		// 로그 아웃시 맨처음 화면인 login.jsp 로 redirect 
		response.sendRedirect("/login/login.jsp") ;
		
		// Test 확인 할 것
		// 1. loginSession.jsp 확인
		// 2. 데이터가 없을 경우 : login.jsp 에서 로그인
		// 		2-1. loginSession.jsp 확인(값증가)
		// 		2-2. main.jsp 로그아웃
		//		2-3. loginSession.jsp 확인(값감소)
		
		// 3.데이터가 있을 경우 : login.jsp
		//		3-1.main.jsp에서 로그아웃
		//		3-2.loginSession.jsp확인(값감소)
		
	}
}
