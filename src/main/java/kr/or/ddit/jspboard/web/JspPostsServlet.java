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

import kr.or.ddit.jspboard.model.JspBoardVo;
import kr.or.ddit.jspboard.model.JspPostsVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;
import kr.or.ddit.util.SessionUtil;

/*  <a href="/jspPosts?board_no=${vo.board_no}&std_id=${vo.std_id }&page=1&pageSize=10" > 
 * localhost:8180/jspposts?board_no=1>
 * 
   게시판 목록 게시판이름 클릭시 게시판 번호 board_no=1 , std_id , page=1 , pageSize=10 를 가지고 넘어온다.
 */
@WebServlet("/jspPosts")  
public class JspPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JspPostsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JspBoardServiceInf jspBoardService = new JspBoardService();
		
		int board_no = Integer.valueOf(request.getParameter("board_no"));
		String std_id = SessionUtil.getSessionStdId(request);
		
		// 게시판 정보 조회
		Map<String, String> jspBoardMap = new HashMap<String, String>();
		jspBoardMap.put("board_no", String.valueOf(board_no));
		jspBoardMap.put("std_id", std_id);
		
		JspBoardVo jspBoardVo = jspBoardService.selectJspBoard(jspBoardMap);
		request.setAttribute("jspBoardVo", jspBoardVo);
		
		//-------------------------------------------------------------
		// page, pageSize 파라미터 받아오기     // "/studentList?page=1&pageSize=10" 로 보낸 
		// 파라미터 값이 없을경우 기본값으로 page: 1 , pageSize: 10 주기
		String pageStr = request.getParameter("page");
		int page = pageStr == null? 1 : Integer.parseInt(pageStr);

		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);

		Map paramMap =  new HashMap();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);     // WHERE rn BETWEEN ( #{page} -1 ) * #{pageSize} +1 AND  #{page} * #{pageSize}
		
		paramMap.put("board_no", board_no);
		paramMap.put("std_id", std_id);
		
		
		// 게시판 번호(board_no)에 해당하는 게시글 목록조회  
//		List<JspPostsVo> jspPostsList = jspBoardService.selectJspPostsList(paramMap);
		
		Map<String, Object> resultMap = jspBoardService.getGroupBoardList(paramMap);
		List<JspPostsVo> jspPostsList = (List<JspPostsVo>) resultMap.get("jspPostsList");
		request.setAttribute("jspPostsList", jspPostsList);
		
		// 페이지 네비게이션 문자열 
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/jspboard/jspPostsList.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
