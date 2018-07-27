package kr.or.ddit.jspboard.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.FileUtil;
import kr.or.ddit.jspboard.model.JspStudentVo;
import kr.or.ddit.jspboard.sevice.StudentService;
import kr.or.ddit.jspboard.sevice.StudentServiceInf;

/**
 * Servlet implementation class StudentUpdateViewServlet
 */
@WebServlet("/studentUpdate")  /* 1. StudentUpdateServlet 으로 요청 전송 (/studentUpdate) - 학생id 파라미터 확인*/
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	// 학생정보 수정화면 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 학생 id 파라미터
		// 학생 정보조회 
		// request 객체에 학생정보를 설정 
		// /student/studentUpdate.jsp 로 위임 
		
		// 학생 id 파라미터
//		int id = Integer.parseInt(request.getParameter("id"));
		String std_id = request.getParameter("std_id");
		
		// 학생 정보조회 
		StudentServiceInf studentService = new StudentService();
		JspStudentVo studentVo = studentService.getStudent(std_id);
		
		// request 객체에 학생정보를 설정 
		request.setAttribute("studentVo", studentVo);
		
		// /student/studentUpdate.jsp 로 위임
		request.getRequestDispatcher("/student/studentUpdate.jsp").forward(request, response);	
	}
	
	
	// 학생 정보 수정 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// if( 프로필 이미지를 안올린경우 ) : 기존이미지 사용 
		// db에 있는 값을 조회해서 사용 
		// else if(프로필이미지를 올린경우 ) : 신규 업로드한 이미지를 사용 
		// service.studentUpdate() 호출 
		// redirect : /student/studentDetail.jsp
		
		// 파라미터를 받아 확인
//		int id = Integer.parseInt(request.getParameter("id"));
		String std_id = request.getParameter("std_id");
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		
		// 첨부이미지도 받아오기
		Part picPart = request.getPart("pic");
		
		// 학생정보 조회 (service 메서드에서 조회 )
		StudentServiceInf studentService = new StudentService();
//		JspStudentVo studentVo = studentService.getStudent(String.valueOf(id));
		JspStudentVo studentVo = studentService.getStudent(std_id);
		
		// 파라미터로 받은 값을 vo에 저장 
		studentVo.setName(name);
		studentVo.setAddr1(addr1);
		studentVo.setAddr2(addr2);
		studentVo.setZipcd(zipcd);
		
		
		// 신규이미지로 업데이트 하는 경우 
		if (picPart.getSize() > 0) {
			// 업로드당시 파일명 
			// UUID를 통해 임의의 파일명을 하나 작성(picname)
			// 업로드할 경로 (FileUtil.uploadPath )
			String contentDisposition =  picPart.getHeader("Content-Disposition");
			String pic = FileUtil.getFileName(contentDisposition);
			String picPath = FileUtil.fileUploadPath;
			String picname = UUID.randomUUID().toString();
			
			studentVo.setPic(pic);
			studentVo.setPicpath(picPath);
			studentVo.setPicname(picname);
			
			picPart.write(picPath + File.separator + picname);
			picPart.delete();
		}
		
		// 학생정보 업데이트 
		studentService.studentUpdate(studentVo);
		
		// 학생정보 상세조회 화면으로 이동 
		response.sendRedirect("/studentDetail?std_id" + std_id);
		// redirect : /student/studentDetail.jsp
		
	
/*		JspStudentVo studentVo = new JspStudentVo(); 	
  		studentVo.setId(2);
		studentVo.setName("강병관 ");
		studentVo.setAddr1("대전광역시 중구 중앙로 76");
		studentVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		studentVo.setZipcd("34940");
		studentVo.setPic("sally.png");
		studentVo.setPicpath("D:\\W\\A_TeachingMaterial\\7.JspSrpgin\\fileUpload");
		studentVo.setPicname("b4a18122-e170-462a-a971-6fdb60d38f57");*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}
