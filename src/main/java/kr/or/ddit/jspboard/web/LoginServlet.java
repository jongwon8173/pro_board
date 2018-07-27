package kr.or.ddit.jspboard.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.jspboard.model.JspBoardVo;
import kr.or.ddit.jspboard.model.JspStudentVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;
import kr.or.ddit.jspboard.sevice.StudentService;
import kr.or.ddit.jspboard.sevice.StudentServiceInf;


//login.jsp  폼액션에서 Post방식으로 넘어옴  
//로그인 화면 : 로그인 성공후 메인 페이지 이동, 실패시 로그인 페이지로 이동

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");    // Post 방식의 메서드전달시 한글깨짐방지 , 파라미터 인코딩방식  
		
//		System.out.println(request.getMethod());  // service 클래스의 getMethod() 객체
		
		response.setContentType("text/html; charset=UTF-8");
		 
		// LoginServlet 파라미터(userId, password)를 확인 후 고정된 값을 비교 , 같을 경우에는 response객체의 writer 객체를 이용하여  화면에 "접속성공" 틀릴경우에는 "접속 실패" 메세지 출력
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		// ● 로그인 프로세서
		StudentServiceInf userService = new StudentService();  
		
		JspStudentVo jspStudentVo = userService.getStudent(userId);
		jspStudentVo = (jspStudentVo == null) ? jspStudentVo = new JspStudentVo() : jspStudentVo;

		// userService 에서 받아온 userVo의 정보를 사용자가 입력한 정보가 일치하는지 체크
		
//		PrintWriter pw = response.getWriter();
//		if( userId.equals(userVo.getUserId()) && password.equals(userVo.getPassword()) ){    <- Vo에 validateUser() 메서드를 따로 만들어서 처리하는 방법으로 처리 
//			pw.write("[로그인 성공]");
//		}else {
//			pw.write("[로그인 실패]");
//		}__________________________________________
			
		// 로그인 성공시 : forward -  /main.jsp  로 이동 : [main.jsp] 만 화면에 출력되게 만들기 
		// 로그인 실패시 : redirect - login.jsp  로 이동 : 로그인 실패하면 그대로 로그인 화면에 
		
		// 07.05 추가 ------------------------------------------
		// 로그인 성공시 uerVo 객체를 저장하여 (적당한 영역에)
		// main.jsp 에서 사용자 아이디를 화면에 출력
		// 단 새로운 탭에서 main.jsp를 직접 접속해도 사용자 아이디가 화면에 나와야한다. 

		
		
		if( jspStudentVo.validateUser(userId, password) ){  // true면 아래실행

			// 리퀘스트 객체에서 세션을 얻어온다 
			HttpSession session = request.getSession();
			session.setAttribute("jspStudentVo", jspStudentVo);
			
//			// application 
//			ServletContext servletContext = getServletContext();
//			servletContext.setAttribute("jspStudentVo", jspStudentVo);
	
//			RequestDispatcher rd =  request.getRequestDispatcher("/main.jsp");
//			rd.forward(request, response);
//			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
			// 왼쪽메뉴 게시판목록 생성
			JspBoardServiceInf jspBoardService = new JspBoardService();
			List<JspBoardVo> jspBoardList = jspBoardService.selectLeftMenuJspBoardList();
			request.getSession().setAttribute("menuBoardList", jspBoardList);
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
//			response.sendRedirect("/main.jsp");
			
		}else {
//			System.out.println("redirect - 로그인 실패 ");  
			
			request.setAttribute("errMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
//			response.sendRedirect("/login/login.jsp");

		}
			
		
		
		
		
		
		
	}

}
