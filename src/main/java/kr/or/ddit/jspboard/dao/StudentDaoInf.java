package kr.or.ddit.jspboard.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.jspboard.model.JspStudentVo;



public interface StudentDaoInf {
	
	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 학생정보 조회  / 특정학생 정보조회 , 학생 id를 받아 학생정보를 조회한다.
	 */
	JspStudentVo getStudent(String std_id);
	
	
	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	List<JspStudentVo> selectAllStudents();
	
	

	
	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param JspJspStudentVo
	 * @return
	 * Method 설명 : 학생정보 조회  / 특정학생 정보조회 , 학생 JspStudentVo를 받아 학생정보를 조회한다.
	 */
	JspStudentVo getStudent(JspStudentVo jspStudentVo);
	
	/**
	 * 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 페이지 리스트 조회 
	 */
	List<JspStudentVo> getStudentPageList(Map<String, Integer> map);
	
	
	/**
	 * 
	 * Method : getStudentTotalCnt
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 학생 전체 건수 조회
	 */
	int getStudentTotalCnt();
	
	
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
	int studentUpdate(JspStudentVo jspStudentVo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
