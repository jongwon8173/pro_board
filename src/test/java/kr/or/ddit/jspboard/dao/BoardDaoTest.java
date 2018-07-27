package kr.or.ddit.jspboard.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.jspboard.model.JspBoardVo;
import kr.or.ddit.jspboard.model.JspPostsVo;

import org.junit.Before;
import org.junit.Test;

public class BoardDaoTest {

	private JspBoardDaoInf boardDao;

	@Before
	// 테스트 메소드가 실행되기전에 실행되어 초기화 작업
	public void setup() {
		boardDao = new JspBoardDao();
	}

	// ============================
	// 게시판 Dao
	// ============================

	/**
	 * 
	 * Method : selectJspBoardTest
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : Map 정보로 하나의 게시판정보 조회하는 테스트 
	 * (JspPostsServlet.java)
	 */
	@Test
	public void selectJspBoardTest(){
		/***Given***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("board_no", "1");
		map.put("std_id", "bbb" );

		/***When***/
		JspBoardVo jspBoardVo = boardDao.selectJspBoard(map);

		/***Then***/
		assertEquals("bbb", jspBoardVo.getStd_id());
	}
	
	
	@Test
	public void selectJspPostsListTest(){
		/***Given***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("board_no", "1");
		map.put("std_id", "bbb" );

		/***When***/
		JspBoardVo jspBoardVo = boardDao.selectJspBoard(map);

		/***Then***/
		assertEquals("bbb", jspBoardVo.getStd_id());
	}
	
	

	// ============================
	// 게시글 Dao
	// ============================
	/**
	 * 
	 * Method : selectJspPostsOneTest
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : 게시글 2개의 정보를 받아 게시글 하나의 정보를 조회하는 테스트
	 */
	@Test
	public void selectJspPostsOneTest() {
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("board_no", 1);
		map.put("posts_no", 0);

		/***When***/
		JspPostsVo jspPostsVo = boardDao.selectJspPostsOne(map);
		
		/***Then***/
		assertEquals("test1", jspPostsVo.getPosts_tit());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
