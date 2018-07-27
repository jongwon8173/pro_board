package kr.or.ddit.jspboard.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.jspboard.dao.JspBoardDao;
import kr.or.ddit.jspboard.dao.JspBoardDaoInf;
import kr.or.ddit.jspboard.model.JspBoardVo;
import kr.or.ddit.jspboard.model.JspPostsVo;
import kr.or.ddit.jspboard.sevice.JspBoardService;
import kr.or.ddit.jspboard.sevice.JspBoardServiceInf;

import org.junit.Before;
import org.junit.Test;

public class BoardServiceTest {

	private JspBoardServiceInf jspBoardService;

	@Before
	// 테스트 메소드가 실행되기전에 실행되어 초기화 작업
	public void setup() {
		jspBoardService = new JspBoardService();
	}

	// ============================
	// 게시판 Service
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
		JspBoardVo jspBoardVo = jspBoardService.selectJspBoard(map);

		/***Then***/
		assertEquals("bbb", jspBoardVo.getStd_id());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ============================
	// 게시글 Service
	// ============================
	/**
	 * 
	 * Method : selectJspPostsListTest
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : map객체로 전체 게시글 리스트를 조회하는 테스트
	 * (JspPostsServlet.java)
	 */
	@Test
	public void selectJspPostsListTest(){
		/***Given***/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_no", 1);
		map.put("std_id", "bbb" );
		map.put("page", 1);
		map.put("pageSize", 10); 

		/***When***/
		List<JspPostsVo> jspPostsList = jspBoardService.selectJspPostsList(map); 

		/***Then***/
		assertEquals("bbb", jspPostsList.size());
	}
	
	
	
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
		JspPostsVo jspPostsVo = jspBoardService.selectJspPostsOne(map);
		
		/***Then***/
		assertEquals("test1", jspPostsVo.getPosts_tit());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
