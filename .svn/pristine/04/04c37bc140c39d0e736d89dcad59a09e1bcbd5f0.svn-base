package kr.or.ddit.jspboard.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jspboard.model.JspBoardVo;
import kr.or.ddit.jspboard.model.JspStudentVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;
import kr.or.ddit.util.SessionUtil;

/**
 * Servlet implementation class StudentServlet
 */

@WebServlet("/jspBoard") // 게시판 생성클릭시 이동
public class JspBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JspStudentVo studentVo = SessionUtil.getUserSession(request);
		
		JspBoardServiceInf jspBoardService = new JspBoardService();
		
		// 게시판 목록조회
		List<JspBoardVo> jspBoardList = jspBoardService.selectJspBoardList(studentVo.getStd_id());
		request.setAttribute("jspBoardList", jspBoardList);
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/jspboard/jspBoard.jsp");
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
