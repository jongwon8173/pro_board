package kr.or.ddit.jspboard.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jspboard.model.JspStudentVo;
import kr.or.ddit.jspboard.sevice.StudentService;
import kr.or.ddit.jspboard.sevice.StudentServiceInf;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// StudentService 객체를 생성, 학생전체 리스트를 조회 
		// 학생 전체 리스트 request객체에 속성으로 설정
		// studentList.jsp로 forward 
		
		// page, pageSize 파라미터 받아오기     // "/studentList?page=1&pageSize=10" 로 보낸 
		// 파라미터 값이 없을경우 기본값으로 page: 1 , pageSize: 10 주기
		String pageStr = request.getParameter("page");
		int page = pageStr == null? 1 : Integer.parseInt(pageStr);

		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);

//		int page = Integer.parseInt(request.getParameter("page"));
//		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		Map<String, Integer> paramMap =  new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);     // WHERE rn BETWEEN ( #{page} -1 ) * #{pageSize} +1 AND  #{page} * #{pageSize}
		
		
		// 학생 페이지 리스트 랑, 전체 건수 조회 / 같이 조회 가능하도록 서비스 소스 수정 
		StudentServiceInf studentService = new StudentService();
		
//		기존: List<JspStudentVo> studentList = service.selectAllStudents();
//		List<JspStudentVo> studentList = studentService.getStudentPageList(paramMap);
		Map<String, Object>  resultMap = studentService.getStudentPageList(paramMap);
		
		// 학생 페이지 리스트 
		List<JspStudentVo> studentList = (List<JspStudentVo>) resultMap.get("pageList");
		request.setAttribute("studentList", studentList);
		
		// 페이지 네비게이션 문자열 
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/student/studentList.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
