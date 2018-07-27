package kr.or.ddit.jspboard.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.FileUtil;
import kr.or.ddit.jspboard.model.JspFileVo;
import kr.or.ddit.jspboard.model.JspPostsVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;
import kr.or.ddit.util.SessionUtil;

/* 
 * jspPostsList.jsp ,게시글 클릭시 상세조회 화면 이동 (jspPostsList.jsp 게시글 목록 클릭시 () (posts_no , board_no , std_id 가지고옴) /JspPostsDetailServlet 에서 세팅 jspPostsDetail.jsp이동 ) / 
 * jspPostsInsert.jsp -> JspPostsInsertServlet.java /  게시글 신규 등록 : 신규 등록 후 해당글의 상세 조회 페이지로 이동한다
 * 게시글 수정 : 수정후 해당 글의 상세 조회 페이지로 이동 / 
 * 
 * -> StudentDetailServlet 조회해서 -> jspPostsDetail.jsp 이동
 */
@WebServlet("/jspPostsUpdate")
@MultipartConfig(maxFileSize = 1024 * 1000 * 5, maxRequestSize = 1024 * 1000 * 16)
public class JspPostsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JspPostsUpdateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시판, 게시글번호 파라미터 확인 
		int board_no = Integer.valueOf(request.getParameter("board_no"));
		int posts_no = Integer.valueOf(request.getParameter("posts_no"));	

		Map<String, Integer> postsParamMap =  new HashMap<String, Integer>();
		postsParamMap.put("board_no", board_no);
		postsParamMap.put("posts_no", posts_no);

		JspBoardServiceInf jspBoardService = new JspBoardService();
		JspPostsVo jspPostsVo = jspBoardService.selectJspPostsOne(postsParamMap);

		request.setAttribute("jspPostsVo", jspPostsVo);

		// view로 위임 
		request.getRequestDispatcher("/jspboard/jspPostsUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 파라미터 가져와서 vo에 set ==========================================================================
		String board_no = request.getParameter("board_no");
		String posts_no = request.getParameter("posts_no");
		JspPostsVo jspPostsVo = 
				new JspPostsVo(
						  Integer.valueOf(board_no)
						, Integer.valueOf(posts_no)
						, request.getParameter("posts_tit")
						, request.getParameter("posts_con")
						, SessionUtil.getSessionStdId(request)
						);

		// 첨부파일 정보 생성 및 파일저장 ========================================================================== 
		JspFileVo jspFileVo = null;
		for (Part part : request.getParts()) { 
			if (part.getName().equals("file_upnm") && part.getSize() > 0) { 
				jspFileVo = new JspFileVo();

				String contentDisposition =  part.getHeader("Content-Disposition");
				String fileName = FileUtil.getFileName(contentDisposition);
				
				String fileExt = fileName.substring(fileName.lastIndexOf("."), fileName.length());

				jspFileVo.setFile_path(FileUtil.fileUploadPath);
				jspFileVo.setFile_renm(fileName);
				jspFileVo.setFile_upnm(UUID.randomUUID().toString()+fileExt);
				jspFileVo.setFile_size(String.valueOf(part.getSize()));

				// 디렉토리 없을 경우 생성
				if(!new File(FileUtil.fileUploadPath).exists()) {
					new File(FileUtil.fileUploadPath).mkdirs();
				}

				System.out.println("filePath :::::::::: " + jspFileVo.getFile_path());
				System.out.println("fileRenm :::::::::: " + jspFileVo.getFile_renm());
				System.out.println("fileUpnm :::::::::: " + jspFileVo.getFile_upnm());
				System.out.println("fileSize :::::::::: " + jspFileVo.getFile_size());

				jspPostsVo.getFileList().add(jspFileVo);

				part.write(jspFileVo.getFile_path() + File.separator + jspFileVo.getFile_upnm() + fileExt);
				part.delete();
			}
		}
		
		// 게시글 수정
		JspBoardServiceInf jspBoardService = new JspBoardService();
		jspBoardService.updateJspPosts(jspPostsVo);   // 게시판 update 작업
		
		// 게시물 상세조회화면으로 이동
//		request.setAttribute("jspPostsVo", jspPostsVo);
		String param = "?board_no=" + board_no + "&posts_no=" + posts_no;
		
		request.getRequestDispatcher("jspPostsDetail"+param).forward(request, response);
	}

}
