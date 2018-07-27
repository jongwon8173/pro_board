package kr.or.ddit.jspboard.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.jspboard.dao.StudentDao;
import kr.or.ddit.jspboard.dao.StudentDaoInf;
import kr.or.ddit.jspboard.model.JspStudentVo;

import org.junit.Before;
import org.junit.Test;




public class StudentDaoTest {
	

	
//	@Before --> @Test --> @After
	// 테스트 메소드안에 중복되는 내용 : StudentDao 구현체에 대한 생성 로직 
	// --> @Before 어노테이션이 붙은 setup메소드 위임
	// 모든 테스트 메소드 에서 StudentDao 객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고 
	// 클래스 변수를 setup메소드에서 최기화하는 로직이 필요 
	// 테스트 메소드에서 StudentDao를 생성하는 로직은 삭제 
	
	private StudentDaoInf studentDao;
	
	
	@Before    // 테스트 메소드가 실행되기전에 실행되어 초기화 작업 
	public void setup(){
		studentDao = new StudentDao();
	}
	
	
	/**
	 * 
	 * Method : selectAllStudentsTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 :전체 학생정보를 조회한다.
	 */
	@Test
	public void selectAllStudentsTest() {
	
		/***Given***/
//		StudentDaoInf studentDao = new StudentDao();

		/***When***/
		List<JspStudentVo> studentList = studentDao.selectAllStudents();
		
		for (JspStudentVo vo : studentList)
			System.out.println(vo);
		
		/***Then***/
		assertEquals(25, studentList.size());
	}
	
	/**
	 * 
	 * Method : getStudentTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param id
	 * Method 설명 : 학생 id로 학생정보 조회 테스트 
	 */
	@Test
	public void getStudentTestById(){
		/***Given***/
		String id = "bbb";

		/***When***/
		JspStudentVo studentvo = studentDao.getStudent(id);
	
		/***Then***/
		assertEquals(id, studentvo.getStd_id());
		assertEquals("김마음", studentvo.getName());
	}
	
	
	
	/**
	 * 
	 * Method : getStudentTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param id
	 * Method 설명 : 학생정보 조회 테스트 
	 */
	@Test
	public void getStudentTestByVo(){
		/***Given***/
//		StudentDaoInf studentDao = new StudentDao();
		JspStudentVo paramVo = new JspStudentVo();
		String id = "ccc";
		paramVo.setStd_id(id);

		/***When***/
		JspStudentVo studentvo = studentDao.getStudent(paramVo);
	
		/***Then***/
		assertEquals(id, studentvo.getStd_id());
		assertEquals("김마음", studentvo.getName());
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
		List<JspStudentVo> pageList = studentDao.getStudentPageList(map);

		/***Then***/
		assertEquals(10, pageList.size());
	}
	
	
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
		List<JspStudentVo> pageList = studentDao.getStudentPageList(map);
		for (JspStudentVo studentVo : pageList) {
			System.out.println(studentVo);
		}

		/***Then***/
		assertEquals(5, pageList.size());
	}
	
	
	/**
	 * 
	 * Method : getStudentTotalCntTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : 학생 전체 건수 조회 테스트 
	 */
	@Test
	public void getStudentTotalCntTest() {
		/***Given***/
		

		/***When***/
		int studentCnt = studentDao.getStudentTotalCnt();
		System.out.println(studentCnt);
		/***Then***/
		assertEquals(25, studentCnt);
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
	public void studentUpdateTest() {
		/***Given***/
		// 인자값으로 vo를 넘겨줘야하므로 vo에 set한다 
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
		int updateCnt = studentDao.studentUpdate(studentVo);
		System.out.println("업데이트 성공건수" + updateCnt);
		/***Then***/
		assertEquals(1, updateCnt);

			/*	쿼리문 
			 * update student set pic='sally.png',
				picpath='D:\W\A_TeachingMaterial\7.JspSrpgin\fileUpload',
				picname='b4a18122-e170-462a-a971-6fdb60d38f57',
				addr1='대전광역시 중구 중앙로 76',
				addr2='영민빌딩 2층 대덕인재개발원',
				zipcd='34940',
				name='강병관'
				WHERE id = 2; */
	}
	

}
