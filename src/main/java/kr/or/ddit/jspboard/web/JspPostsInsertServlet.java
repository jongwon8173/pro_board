package kr.or.ddit.jspboard.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.file.FileUtil;
import kr.or.ddit.jspboard.model.JspFileVo;
import kr.or.ddit.jspboard.model.JspPostsVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;
import kr.or.ddit.util.SessionUtil;


@WebServlet("/jspPostsInsert")  // jspPostsList.jsp 에서 새글등록 버튼 클릭시 값을가지고 넘어옴 
@MultipartConfig(maxFileSize = 1024 * 1000 * 5, maxRequestSize = 1024 * 1000 * 16)
public class JspPostsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	Logger logger = LoggerFactory.getLogger(JspPostsInsertServlet.class);
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 가져와서 vo에 set ==========================================================================
		String board_no = request.getParameter("board_no");
		String posts_no = (request.getParameter("posts_no") == null ) || (request.getParameter("posts_no").equals(""))  || (request.getParameter("posts_no").equals(" "))
									? "-1" : request.getParameter("posts_no");
		
		logger.debug("request.getParameter(\"posts_no\") == > " + request.getParameter("posts_no"));
		
		JspPostsVo jspPostsVo = new JspPostsVo();
		jspPostsVo.setBoard_no(Integer.valueOf(board_no));
//		jspPostsVo.setPosts_pno(Integer.valueOf(posts_no));		// 작성화면에 게시글ID가 있으면 답글작성이므로 상위게시글ID로 Set
		jspPostsVo.setPosts_pno(Integer.parseInt(posts_no));	// valueOf() 음수 형변환 안됨
		jspPostsVo.setPosts_con(request.getParameter("posts_con"));
		
		request.setAttribute("jspPostsVo", jspPostsVo);
		logger.debug("JspPostsInsertServlet=========================================");
		request.getRequestDispatcher("/jspboard/jspPostsInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// 파라미터 가져와서 vo에 set ==========================================================================
		String board_no = request.getParameter("board_no");
		String posts_pno = request.getParameter("posts_pno");	// 상위게시글ID - 답글일경우에 존재함
		
		JspPostsVo jspPostsVo = 
				new JspPostsVo(
						  Integer.valueOf(board_no)
						, -1
						, request.getParameter("posts_tit")
						, request.getParameter("posts_con")
						, SessionUtil.getSessionStdId(request)
						);
		jspPostsVo.setPosts_pno(posts_pno == null ? 0 : Integer.valueOf(posts_pno));
		
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
		
		// 게시글 등록
		JspBoardServiceInf jspBoardService = new JspBoardService();
		int posts_no = jspBoardService.insertJspPosts(jspPostsVo);   // 게시판 insert 작업
		
		// 게시물 상세조회화면으로 이동
//		request.setAttribute("jspPostsVo", jspPostsVo);
		String param = "?board_no=" + board_no + "&posts_no=" + posts_no;
		
		request.getRequestDispatcher("jspPostsDetail"+param).forward(request, response);
	}

}
