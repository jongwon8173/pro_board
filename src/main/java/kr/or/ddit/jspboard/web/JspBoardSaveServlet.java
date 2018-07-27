package kr.or.ddit.jspboard.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jspboard.model.JspBoardVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;
import kr.or.ddit.util.SessionUtil;


@WebServlet("/jspBoardSave")  // jspBoard.jsp 에서 생성버튼 클릭시 값을가지고 넘어옴 
public class JspBoardSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 가져와서 vo에 set ==========================================================================
		JspBoardVo jspBoardVo = 
				new JspBoardVo(
							 Integer.valueOf(request.getParameter("board_no"))
							,request.getParameter("std_id")
							,request.getParameter("board_nm")
							,request.getParameter("board_yn")
						);
		
		JspBoardServiceInf jspBoardService = new JspBoardService();
		
		String flag = request.getParameter("flag");
		if(flag.equals("INSERT")) {	   // 게시판 insert 작업
			jspBoardService.insertJspBoard(jspBoardVo);
		}
		else {	   // 게시판 update 작업
			jspBoardService.updateJspBoard(jspBoardVo);
		}
		
		// 게시판 목록
		List<JspBoardVo> jspBoardList = jspBoardService.selectJspBoardList(SessionUtil.getSessionStdId(request));
		request.setAttribute("jspBoardList", jspBoardList);
		
		// 왼쪽메뉴 게시판 목록
		if(request.getSession().getAttribute("menuBoardList") != null) {
			request.getSession().removeAttribute("menuBoardList");
		}
		List<JspBoardVo> menuBoardList = jspBoardService.selectLeftMenuJspBoardList();
		request.getSession().setAttribute("menuBoardList", menuBoardList);
		
		// 게시판 생성화면으로 이동
		request.getRequestDispatcher("/jspboard/jspBoard.jsp").forward(request, response);
	}

}
