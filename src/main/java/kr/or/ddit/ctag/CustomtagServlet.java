package kr.or.ddit.ctag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jspboard.model.JspStudentVo;
import kr.or.ddit.jspboard.sevice.StudentService;
import kr.or.ddit.jspboard.sevice.StudentServiceInf;

/**
 * Servlet implementation class CustomtagServlet
 */
@WebServlet("/customtag")
public class CustomtagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 학생 1페이지 리스트 조회 
		// request 객체 속성 설정
		// ctag.jsp로 전달 (forward)
		
		
		// 학생 1페이지 리스트 조회 
		Map<String, Integer> paramMap =  new HashMap<String, Integer>();
		paramMap.put("page", 1);
		paramMap.put("pageSize", 10);    
		
		// request 객체 속성 설정
		
		StudentServiceInf studentService = new StudentService();
		Map<String, Object>  resultMap = studentService.getStudentPageList(paramMap);
		request.setAttribute("studentList", (List<JspStudentVo>) resultMap.get("pageList"));
		
		// ctag.jsp로 전달 (forward)
		request.getRequestDispatcher("/jsp/ctag/ctag.jsp").forward(request, response);
	}



}
