package kr.or.ddit.jspboard.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jspboard.model.JspPostsVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;

/* 
 * jspPostsList.jsp ,게시글 클릭시 상세조회 화면 이동 (jspPostsList.jsp 게시글 목록 클릭시 () (posts_no , board_no , std_id 가지고옴) /JspPostsDetailServlet 에서 세팅 jspPostsDetail.jsp이동 ) / 
 * jspPostsInsert.jsp -> JspPostsInsertServlet.java /  게시글 신규 등록 : 신규 등록 후 해당글의 상세 조회 페이지로 이동한다
 * 게시글 수정 : 수정후 해당 글의 상세 조회 페이지로 이동 / 
 * 
 * -> StudentDetailServlet 조회해서 -> jspPostsDetail.jsp 이동
 */
@WebServlet("/jspPostsDelete")
public class JspPostsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JspPostsDeleteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 파라미터 가져와서 vo에 set ==========================================================================
		String board_no = request.getParameter("board_no");
		String posts_no = request.getParameter("posts_no");
		
		JspPostsVo jspPostsVo = new JspPostsVo();
		jspPostsVo.setBoard_no(Integer.valueOf(board_no));
		jspPostsVo.setPosts_no(Integer.valueOf(posts_no));
		
		// 게시글 삭제
		JspBoardServiceInf jspBoardService = new JspBoardService();
		jspBoardService.deleteJspPosts(jspPostsVo);
		
		// 게시물 목록조회화면으로 이동
		String param = "?board_no=" + board_no;
		
		request.getRequestDispatcher("jspPosts"+param).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
