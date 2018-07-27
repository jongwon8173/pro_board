package kr.or.ddit.jspboard.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.jspboard.model.JspBoardVo;
import kr.or.ddit.jspboard.model.JspCommentVo;
import kr.or.ddit.jspboard.model.JspFileVo;
import kr.or.ddit.jspboard.model.JspPostsVo;
import kr.or.ddit.jspboard.model.JspStudentVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class JspBoardDao implements JspBoardDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * 
	 * Method : selectJspBoardList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return List<JspBoardVo>
	 * Method 설명 : 전체 게시판 목록를 조회한다.
	 */
	public List<JspBoardVo> selectJspBoardList(String std_id) {
		SqlSession session = sqlSessionFactory.openSession(); 
		List<JspBoardVo> jspBoardList = session.selectList("jspboard.selectJspBoardList", std_id);
		session.close();
		return jspBoardList;
	}
	
	/**
	 * 
	 * Method : selectLeftMenuJspBoardList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return List<JspBoardVo>
	 * Method 설명 : 왼쪽 메뉴 전체 게시판 목록를 조회한다.
	 */
	public List<JspBoardVo> selectLeftMenuJspBoardList() {
		SqlSession session = sqlSessionFactory.openSession(); 
		List<JspBoardVo> jspBoardList = session.selectList("jspboard.selectLeftMenuJspBoardList");
		session.close();
		return jspBoardList;
	}
	
	/**
	 * 
	 * Method : selectJspBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return JspBoardVo
	 * Method 설명 : 게시판 정보를 조회한다.
	 */
	public JspBoardVo selectJspBoard(Map<String, String> paramMap) {
		SqlSession session = sqlSessionFactory.openSession(); 
		JspBoardVo jspBoard = session.selectOne("jspboard.selectJspBoard", paramMap);
		session.close();
		return jspBoard;
	}
	
	/**
	 * 
	 * Method : insertJspBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시판 정보 등록
	 */
	public void insertJspBoard(JspBoardVo jspBoardVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.insert("jspboard.insertJspBoard", jspBoardVo);
		session.commit();
		session.close();
	}
	
	/**
	 * 
	 * Method : updateJspBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시판 정보 수정
	 */
	public void updateJspBoard(JspBoardVo jspBoardVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.update("jspboard.updateJspBoard", jspBoardVo);
		session.commit();
		session.close();
	}
	
	//===게시글==================================================================================================
	
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
	public JspPostsVo selectJspPostsOne(Map<String, Integer> postsParamMap){
		SqlSession session = sqlSessionFactory.openSession(); 
		JspPostsVo jspOnePosts = session.selectOne("jspboard.selectJspPostsOne", postsParamMap);
		session.close();
		return jspOnePosts;
	}
	
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
	public JspPostsVo selectJspPosts(int board_no){
		SqlSession session = sqlSessionFactory.openSession(); 
		JspPostsVo jspPostsVo = session.selectOne("jspboard.selectJspPosts", board_no);
		session.close();
		return jspPostsVo;
	}
	
	/**
	 * 
	 * Method : selectJspPostsList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return List<JspPostsVo>
	 * Method 설명 : 전체 게시글 목록를 조회한다.
	 */
	public List<JspPostsVo> selectJspPostsList(Map paramMap) {
		SqlSession session = sqlSessionFactory.openSession(); 
		List<JspPostsVo> jspPostsList = session.selectList("jspboard.selectJspPostsList", paramMap);
		session.close();
		return jspPostsList;
	}
	
	/**
	 * 
	 * Method : selectJspPostsTotCnt
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return int
	 * Method 설명 : 전체 게시글 개수를 조회한다.
	 */
	public int selectJspPostsTotCnt(Map paramMap) {
		SqlSession session = sqlSessionFactory.openSession(); 
		int totCnt = session.selectOne("jspboard.selectJspPostsTotCnt", paramMap);
		session.close();
		return totCnt;
	}

	/**
	 * 
	 * Method : getJspPostsNoByPk
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return int
	 * Method 설명 : 게시글 번호 생성
	 */
	public int getJspPostsNoByPk(JspPostsVo jspBoardVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		int postsNo = session.selectOne("jspboard.getJspPostsNoByPk", jspBoardVo);
		session.close();
		return postsNo;
	}
	
	/**
	 * 
	 * Method : insertJspPosts
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시글 정보 등록
	 */
	public void insertJspPosts(JspPostsVo jspPostsVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.insert("jspboard.insertJspPosts", jspPostsVo);
		session.commit();
		session.close();
	}
	
	/**
	 * 
	 * Method : updateJspPosts
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시글 정보 수정
	 */
	public void updateJspPosts(JspPostsVo jspPostsVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.update("jspboard.updateJspPosts", jspPostsVo);
		session.commit();
		session.close();
	}
	
	/**
	 * 
	 * Method : deleteJspPosts
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시글 삭제
	 */
	public void deleteJspPosts(JspPostsVo jspPostsVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.update("jspboard.deleteJspPosts", jspPostsVo);
		session.commit();
		session.close();
	}
	
	/**
	 * 
	 * Method : selectJspCommentList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 게시글의 댓글 목록 조회
	 */
	public List<JspCommentVo> selectJspCommentList(int posts_no) {
		SqlSession session = sqlSessionFactory.openSession(); 
		List<JspCommentVo> jspCommentList = session.selectList("jspboard.selectJspCommentList", posts_no);
		session.close();
		return jspCommentList;
	}
	
	/**
	 * 
	 * Method : insertJspComment
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 댓글 저장
	 */
	public void insertJspComment(JspCommentVo jspCommentVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.update("jspboard.insertJspComment", jspCommentVo);
		session.commit();
		session.close();
	}
	
	/**
	 * 
	 * Method : updateJspComment
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 댓글 수정
	 */
	public void updateJspComment(JspCommentVo jspCommentVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.update("jspboard.updateJspComment", jspCommentVo);
		session.commit();
		session.close();
	}
	
	/**
	 * 
	 * Method : deleteJspComment
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 댓글 수정
	 */
	public void deleteJspComment(JspCommentVo jspCommentVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.update("jspboard.deleteJspComment", jspCommentVo);
		session.commit();
		session.close();
	}
	
	/**
	 * 
	 * Method : insertJspFile
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 첨부파일 정보 저장
	 */
	public void insertJspFile(JspFileVo jspFileVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.update("jspboard.insertJspFile", jspFileVo);
		session.commit();
		session.close();
	}
	
	/**
	 * 
	 * Method : selectFileList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 첨부파일 목록 조회
	 */
	public List<JspFileVo> selectFileList(int posts_no) {
		SqlSession session = sqlSessionFactory.openSession(); 
		List<JspFileVo> fileList = session.selectList("jspboard.selectFileList", posts_no);
		session.close();
		return fileList;
	}
	
	/**
	 * 
	 * Method : deleteJspFile
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 첨부파일 정보 삭제
	 */
	public void deleteJspFile(JspFileVo jspFileVo) {
		SqlSession session = sqlSessionFactory.openSession(); 
		session.delete("jspboard.deleteJspFile", jspFileVo);
		session.commit();
		session.close();
	}
	
}
