package kr.or.ddit.jspboard.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jspboard.model.JspCommentVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;
import kr.or.ddit.util.SessionUtil;


@WebServlet("/jspComment")  // jspPostsList.jsp 에서 새글등록 버튼 클릭시 값을가지고 넘어옴 
public class JspCommentServlet extends HttpServlet {
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
		String board_no = request.getParameter("board_no");
		String posts_no = request.getParameter("posts_no");
//		String flag = request.getParameter("flag");
		
		JspCommentVo jspCommentVo = new JspCommentVo();
		jspCommentVo.setCom_con(request.getParameter("com_con"));
		jspCommentVo.setCom_no(request.getParameter("com_no") == null ? -1 : Integer.valueOf(request.getParameter("com_no")));
		jspCommentVo.setCom_wri(SessionUtil.getSessionStdId(request));
		jspCommentVo.setPosts_no(Integer.valueOf(posts_no));
		
		// 댓글 등록
		JspBoardServiceInf jspBoardService = new JspBoardService();
		jspBoardService.insertJspComment(jspCommentVo);
		
//		if("INSERT".equals(flag)) {
//			jspBoardService.insertJspComment(jspCommentVo);
//		}
//		else if("UPDATE".equals(flag)) {
//			jspBoardService.updateJspComment(jspCommentVo);
//			
//		}
//		else if("UPDATE".equals(flag)) {
//			jspBoardService.deleteJspComment(jspCommentVo);
//		}

		// 게시물 상세조회화면으로 이동
		String param = "?board_no=" + board_no + "&posts_no=" + posts_no;
		
		request.getRequestDispatcher("jspPostsDetail"+param).forward(request, response);
	}

}
