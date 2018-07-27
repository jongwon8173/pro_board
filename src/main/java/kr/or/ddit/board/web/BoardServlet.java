package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoarderServiceInf;

/**
 * Servlet implementation class BoardServlet
 */
// 다중처리
@WebServlet(urlPatterns={"/boardList", "/boardInsert"})
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 조회 
		BoarderServiceInf boardService = new BoardService();
		List<BoardVo> boardList = boardService.getBoardList();
		
		// 게시글을 request영역에 저장 
		request.setAttribute("boardList", boardList);
		
		// 게시글 화면을 담당할 jsp로 역할을 위임 (/board/boardList.jsp)
		// forward 방식으로 jsp  
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
//		
//		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp");
		rd.forward(request, response);
	}

}

