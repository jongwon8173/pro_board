package kr.or.ddit.jspboard.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jspboard.model.JspStudentVo;
import kr.or.ddit.jspboard.sevice.StudentService;
import kr.or.ddit.jspboard.sevice.StudentServiceInf;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/studentDetail") 
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 학생 id 파라미터 확인 
//		int id = Integer.parseInt(request.getParameter("id"));
		String std_id = request.getParameter("std_id");
		
		// service 객체에서 학생정보를 조회 
		StudentServiceInf studentService = new StudentService();
		JspStudentVo studentVo = studentService.getStudent(std_id);
		
		// request 객체에 저장 
		request.setAttribute("studentVo", studentVo);
		
		// student/studentDetail.jsp로 위임 
		request.getRequestDispatcher("/student/studentDetail.jsp").forward(request, response);
	}


}
