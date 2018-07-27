package kr.or.ddit.jspboard.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jspboard.model.JspFileVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;

import org.apache.commons.io.FileUtils;

/* 
 * jspPostsList.jsp ,게시글 클릭시 상세조회 화면 이동 (jspPostsList.jsp 게시글 목록 클릭시 () (posts_no , board_no , std_id 가지고옴) /JspPostsDetailServlet 에서 세팅 jspPostsDetail.jsp이동 ) / 
 * jspPostsInsert.jsp -> JspPostsInsertServlet.java /  게시글 신규 등록 : 신규 등록 후 해당글의 상세 조회 페이지로 이동한다
 * 게시글 수정 : 수정후 해당 글의 상세 조회 페이지로 이동 / 
 * 
 * -> StudentDetailServlet 조회해서 -> jspPostsDetail.jsp 이동
 */
@WebServlet("/jspFile")
public class jspFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public jspFileServlet() {
		super();
	}

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
		String flag = request.getParameter("flag");
		String file_no = request.getParameter("file_no");
		String file_path = request.getParameter("file_path");
		String file_upnm = request.getParameter("file_upnm");
		String board_no = request.getParameter("board_no");
		String posts_no = request.getParameter("posts_no");
		
		JspFileVo jspFileVo = new JspFileVo();
		jspFileVo.setFile_no(Integer.valueOf(file_no));
		jspFileVo.setPosts_no(Integer.valueOf(posts_no));
		
		if("delete".equals(flag)) {	// 게시글 첨부파일 삭제
			JspBoardServiceInf jspBoardService = new JspBoardService();
			jspBoardService.deleteJspFile(jspFileVo);
			
			// 파일 삭제
			FileUtils.deleteDirectory(new File(file_path, file_upnm));
			
			// 게시물 수정화면으로 이동
			String param = "?board_no=" + board_no + "&posts_no=" + posts_no;
			request.getRequestDispatcher("jspPostsUpdate"+param).forward(request, response);
		}
		else {	// 파일다운로드
			
		}
		
	}

}
