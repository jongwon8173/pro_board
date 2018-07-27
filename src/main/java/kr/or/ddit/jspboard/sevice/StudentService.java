package kr.or.ddit.jspboard.sevice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.jspboard.dao.StudentDao;
import kr.or.ddit.jspboard.dao.StudentDaoInf;
import kr.or.ddit.jspboard.model.JspStudentVo;



public class StudentService implements StudentServiceInf {
	
	StudentDaoInf studentDao = new StudentDao();
	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 학생 id를 입력받아 한명의 학생정보 조회 
	 */
	@Override
	public JspStudentVo getStudent(String std_id) {
		StudentDaoInf studentDao = new StudentDao();
		return studentDao.getStudent(std_id);
	}
	
	
	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생정보  조회 
	 */
	@Override
	public List<JspStudentVo> selectAllStudents() {
		StudentDaoInf studentDao = new StudentDao();
		return studentDao.selectAllStudents();
	}

	

	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param JspStudentVo
	 * @return
	 * Method 설명 : 학생정보 조회 
	 */
	@Override
	public JspStudentVo getStudent(JspStudentVo jspStudentVo) {
		StudentDaoInf studentDao = new StudentDao();
		return studentDao.getStudent(jspStudentVo);
	}


	/**
	 * 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 정보 페이지 리스트 조회랑& 학생 전체건수 조회 07.11
	 */
	@Override
	public Map<String, Object> getStudentPageList( Map<String, Integer> map ) {
		StudentDaoInf studentDao = new StudentDao();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 학생 페이지 리스트 조회
		List<JspStudentVo> pageList = studentDao.getStudentPageList(map);
		resultMap.put("pageList", pageList);
		
		// 학생 전체 건수 조회
		int totCnt = studentDao.getStudentTotalCnt();
		resultMap.put("totalCnt", totCnt);
		
		
		// 페이지 네비게이션 html 생성 
		int page = map.get("page");     // serVlet에서 put한거 가져온거 
		int pageSize = map.get("pageSize");
		
		/*
		// 해당부분을 메서드로 따로 뺌 makePageNavi()
		*/
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt ));
		
		return resultMap;
	}
	
	/**
	 * 
	 * Method : makePageNavi
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @param totCnt
	 * @return
	 * Method 설명 : 페이지 네비게이션 문자열 생성
	 */
	private String makePageNavi(int page, int pageSize, int totCnt){

		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지 
		
		if( mod > 0 )
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page-1; 
		int nextPage = page == cnt ? page : page + 1;
		
		pageNaviStr.append("<li> <a href=\"/studentList?page=" + prevPage + "&pageSize=" + pageSize+ "\" aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span> </a> </li>");  //<<부트 스트랩에서 페이지네이션부분 복사해오기 
	    
		for (int i = 1; i <= cnt; i++) {
			String activeClass = "";

			if( i == page )
				activeClass = "class=\"active\"";  //if문 end
			//http://localhost:8180 /studentList?page=3&pageSize=10 ↘링크 적용해주기
			pageNaviStr.append("<li " + activeClass + "><a href=\"/studentList?page=" + i + "&pageSize=" + pageSize+ "\">" + i + "</a></li>");
		}
		
		pageNaviStr.append("<li> <a href=\"/studentList?page=" + nextPage + "&pageSize=" + pageSize+ "\" aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span> </a> </li>"); // >>
		
		
		return pageNaviStr.toString();
	}

	
	/**
	 * 
	 * Method : studentUpdate
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param JspStudentVo
	 * @return
	 * Method 설명 : 학생 정보 업데이트 
	 */
	@Override
	public int studentUpdate(JspStudentVo jspStudentVo) {
		StudentDaoInf studentDao = new StudentDao();
	
		return studentDao.studentUpdate(jspStudentVo);
	}

	
	
	
	
	
	
}
