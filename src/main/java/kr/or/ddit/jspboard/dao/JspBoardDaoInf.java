package kr.or.ddit.jspboard.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.jspboard.model.JspBoardVo;
import kr.or.ddit.jspboard.model.JspCommentVo;
import kr.or.ddit.jspboard.model.JspFileVo;
import kr.or.ddit.jspboard.model.JspPostsVo;

public interface JspBoardDaoInf {
	
	/**
	 * 
	 * Method : selectJspBoardList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return List<JspBoardVo>
	 * Method 설명 : 전체 게시판 목록를 조회한다.
	 */
	List<JspBoardVo> selectJspBoardList(String std_id);
	
	/**
	 * 
	 * Method : selectLeftMenuJspBoardList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return List<JspBoardVo>
	 * Method 설명 : 왼쪽 메뉴 전체 게시판 목록를 조회한다.
	 */
	List<JspBoardVo> selectLeftMenuJspBoardList();
	
	/**
	 * 
	 * Method : selectJspBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return JspBoardVo
	 * Method 설명 : 게시판 정보를 조회한다.
	 */
	JspBoardVo selectJspBoard(Map<String, String> paramMap);
	
	/**
	 * 
	 * Method : insertJspBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시판 정보 등록
	 */
	void insertJspBoard(JspBoardVo jspBoardVo);
	
	/**
	 * 
	 * Method : updateJspBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시판 정보 수정
	 */
	void updateJspBoard(JspBoardVo jspBoardVo);
	
	/**
	 * 
	 * Method : selectJspPosts
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param std_id
	 * @return  JspPostsVo
	 * Method 설명 : 게시판번호를 받아 게시글 하나를 조회
	 */
	JspPostsVo selectJspPosts(int board_no);
	
	//============================================================================
	
	/**
	 * 
	 * Method : selectJspPosts
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param std_id
	 * @return  JspPostsVo
	 * Method 설명 : 게시글 정보를 받아 게시글 하나의 정보를 조회
	 */
	JspPostsVo selectJspPostsOne(Map<String, Integer> postsParamMap);
	
	
	/**
	 * 
	 * Method : selectJspPostsList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return List<JspPostsVo>
	 * Method 설명 : 전체 게시글 목록를 조회한다.
	 */
	List<JspPostsVo> selectJspPostsList(Map paramMap);
	
	/**
	 * 
	 * Method : selectJspPostsTotCnt
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return int
	 * Method 설명 : 전체 게시글 목록를 조회한다.
	 */
	int selectJspPostsTotCnt(Map paramMap);
	
	/**
	 * 
	 * Method : getJspPostsNoByPk
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return int
	 * Method 설명 : 게시글 번호 생성
	 */
	int getJspPostsNoByPk(JspPostsVo jspPostsVo);
	
	/**
	 * 
	 * Method : insertJspPosts
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시글 정보 등록
	 */
	void insertJspPosts(JspPostsVo jspPostsVo);
	
	/**
	 * 
	 * Method : updateJspPosts
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시글 정보 수정
	 */
	void updateJspPosts(JspPostsVo jspPostsVo);
	
	/**
	 * 
	 * Method : deleteJspPosts
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시글 삭제
	 */
	void deleteJspPosts(JspPostsVo jspPostsVo);

	/**
	 * 
	 * Method : selectJspCommentList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시글의 댓글 목록 조회
	 */
	List<JspCommentVo> selectJspCommentList(int posts_no);
	
	/**
	 * 
	 * Method : insertJspComment
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 댓글 저장
	 */
	void insertJspComment(JspCommentVo jspCommentVo);
	
	/**
	 * 
	 * Method : updateJspComment
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 댓글 수정
	 */
	void updateJspComment(JspCommentVo jspCommentVo);
	
	/**
	 * 
	 * Method : deleteJspComment
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 댓글 수정
	 */
	void deleteJspComment(JspCommentVo jspCommentVo);
	
	/**
	 * 
	 * Method : insertJspFile
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 첨부파일 정보 저장
	 */
	void insertJspFile(JspFileVo jspFileVo);
	
	/**
	 * 
	 * Method : selectFileList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 첨부파일 목록 조회
	 */
	List<JspFileVo> selectFileList(int posts_no);
	
	/**
	 * 
	 * Method : deleteJspFile
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 첨부파일 정보 삭제
	 */
	void deleteJspFile(JspFileVo jspFileVo);
	
}
