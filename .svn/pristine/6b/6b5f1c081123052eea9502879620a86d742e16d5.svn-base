package kr.or.ddit.jspboard.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.jspboard.model.JspStudentVo;
import kr.or.ddit.jspboard.sevice.StudentService;
import kr.or.ddit.jspboard.sevice.StudentServiceInf;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
	
	//	@Before --> @Test --> @After
	// 테스트 메소드안에 중복되는 내용 : StudentService 구현체에 대한 생성 로직 
	// --> @Before 어노테이션이 붙은 setup메소드 위임
	// 모든 테스트 메소드 에서 StudentService 객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고 
	// 클래스 변수를 setup메소드에서 최기화하는 로직이 필요 
	// 테스트 메소드에서 StudentService를 생성하는 로직은 삭제 
	
	private StudentServiceInf studentService;
	
	@Before
	public void setup(){
		studentService = new StudentService();
	}
	
	
	/**
	 * 
	 * Method : getStudentByIdTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : 학생 정보 조회 테스트
	 */
	@Test
	public void getStudentByIdTest() {
		/***Given***/
//		StudentServiceInf studentService = new StudentService();
		String id = "nnn";
		
		/***When***/
		JspStudentVo studentvo = studentService.getStudent(id);

		/***Then***/
		assertEquals(id, studentvo.getStd_id());
		assertEquals("노미소", studentvo.getName());
		
	}
	
	
	/**
	 * 
	 * Method : selectAllStudentsTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : 전체 학생 정보 조회 테스트
	 */
	@Test
	public void selectAllStudentsTest() {
		
		/***Given***/
//		StudentServiceInf studentService = new StudentService();

		/***When***/
		List<JspStudentVo> sudentList = studentService.selectAllStudents();
		for (JspStudentVo studentVo : sudentList) {
			System.out.println(studentVo);
		}

		/***Then***/
		assertEquals(25, sudentList.size());
	}
	
	
	
	/**
	 * 
	 * Method : getStudentByVoTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : 학생 정보 조회 테스트
	 */
	@Test
	public void getStudentByVoTest() {
		/***Given***/
//		StudentServiceInf studentService = new StudentService();
		JspStudentVo paramVo = new JspStudentVo();
		int id = 15;
		paramVo.setStd_id("");
//		paramVo.setName(name);

		/***When***/
		JspStudentVo studentVo = studentService.getStudent(paramVo);

		/***Then***/
		assertEquals(id, studentVo.getStd_id());
		assertEquals("조종원", studentVo.getName());

	}
	
	
	
	
	/**
	 * 
	 * Method : getStudentPageListTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 :  학생 페이지 리스트 조회(2페이지 - 10건)  테스트
	 */
	@Test
	public void getStudentPageListTest(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 2);
		map.put("pageSize", 10);

		/***When***/
//		List<JspStudentVo> pageList = studentService.getStudentPageList(map);
		Map<String, Object> resultMap = studentService.getStudentPageList(map);  // 서비스 getStudentPageList 메서드에서 다오의 메서드를 각각 호출하여 하나의 맵으로 만들어서 반환 
		                                                                              		// Map<String, Object> resultMap = new HashMap<String, Object>();
		//학생 페이지 리스트                                                          		
		List<JspStudentVo> pageList =  (List<JspStudentVo>) resultMap.get("pageList");      		// 학생 페이지 리스트 조회
		// 학생 전체 건수                                                             		// List<JspStudentVo> pageList = studentDao.getStudentPageList(map);
		int totCnt = (int) resultMap.get("totalCnt");                                 		// resultMap.put("pageList", pageList);
                                                                                      		
		/***Then***/                                                                  		// 학생 전체 건수 조회
		assertEquals(10, pageList.size());     // 페이지 리스트 건수에 대한 검증       		// int totalCnt = studentDao.getStudentTotalCnt();
		assertEquals(25, totCnt);              // 학생 전체건수에 대한 검증            		
	}                                                                                 		// resultMap.put("totalCnt", totalCnt);
																							// return resultMap;
	
	
	
	/**
	 * 
	 * Method : getStudentPageListTest3
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : 학생 페이지 리스트 조회(3페이지 - 5건) 테스트
	 */
	@Test
	public void getStudentPageListTest2(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 3);
		map.put("pageSize", 10);

		/***When***/
		
		Map<String, Object> resultMap = studentService.getStudentPageList(map);
//		List<JspStudentVo> pageList = studentService.getStudentPageList(map);
		List<JspStudentVo> pageList = (List<JspStudentVo>) resultMap.get("pageList");
		int totCnt = (int) resultMap.get("totalCnt");

		/***Then***/
		assertEquals(5, pageList.size());
		assertEquals(25, totCnt);
	}
	
	/**
	 * 
	 * Method : calculatePageNavi
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : 전체 건수를 인자로 페이지 네비게이션 사이즈를 구하는 테스트 
	 */
	@Test
	public void calculatePageNavi() {
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;
		
		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지 
		
		if(mod > 0)
			cnt++;
		
		/***When***/
		System.out.println(Math.ceil((double)totCnt / pageSize));
		double pageNavi = Math.ceil((double)totCnt / pageSize);
		
		/***Then***/
//		assertEquals(3, pageNavi);
	
	}
	
	
	/**
	 * 
	 * Method : studentUpdateTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : 학생 정보 업데이트 테스트 
	 */
	@Test
	public void studentUpdateTest(){
		/***Given***/
		JspStudentVo studentVo = new JspStudentVo(); 
		
		studentVo.setStd_id("");
		studentVo.setName("강병관 ");
		studentVo.setAddr1("대전광역시 중구 중앙로 76");
		studentVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		studentVo.setZipcd("34940");
		studentVo.setPic("sally.png");
		studentVo.setPicpath("D:\\W\\A_TeachingMaterial\\7.JspSrpgin\\fileUpload");
		studentVo.setPicname("b4a18122-e170-462a-a971-6fdb60d38f57");

		/***When***/
		int updateCnt = studentService.studentUpdate(studentVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
		
	}
	
	
	
	
	

}
