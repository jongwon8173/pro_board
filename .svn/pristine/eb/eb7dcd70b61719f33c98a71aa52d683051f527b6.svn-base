package kr.or.ddit.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadServlet
 */

// bytes
// 1kb = 1024
// 1MB = 1kb * 1000
// 5MB = 1MB * 5 == 1KB * 1000 * 5 = 1024 * 1000 * 5
//fileSizeThreshold : 파일크기가 클때 / maxFileSize : 파일 1개당 크기 / maxRequestSize : 파일 요청 크기
@WebServlet("/fileUpload") 
@MultipartConfig(maxFileSize=1024*1000*5, maxRequestSize=1024*1000*16)  
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// parameter : userId, uploadFile
		// 일반 텍스트 파라미터는 request.getParamter를 통해서 얻을수 있다.
		// 파일의 경우 request.getPart를 통해서 얻을 수 있다.
		logger.debug("contentType == > " + request.getContentType());
		logger.debug("userId == > " + request.getParameter("userId"));
//		logger.debug("upLoadFile == > " + request.getParameter("upLoadFile")); // <<== 
		
		// getPart
		Part uploadFilePart = request.getPart("upLoadFile");	// part 를 반환
//		logger.debug("uploadFilePart.getName() == > " + uploadFilePart.getName() );
//		logger.debug("uploadFilePart.getInputStream() == > " + uploadFilePart.getInputStream());
//		logger.debug("uploadFilePart == > " + uploadFilePart);
		
		// file 이름에 대한 정보를 획득 : getHeaer("Content-Disposition");
		// form-data; name="upLoadFile"; filename="하트_라이언.gif"
		String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
		logger.debug("contentDisposition == > " + contentDisposition);
		
		
		//	FileUtil.java 안의 메서드 getFileName() 사용
		String fileName = FileUtil.getFileName(contentDisposition);
		logger.debug("fileName 추출 ==> " + fileName);
		
		
//		2017-07-17
		// 파일업로드는 우리 프로젝트 경로에 업로드되는것이 아니고 ,이클립스 플러그인이 자동으로 deploy 디플로이 경로에 업로드 된다. 간혹 jsp를 수정햇는데 반영이 안되는 경우가 있을거다
		// deploy="D:\W\A_TeachingMaterial\7.JspSrpgin\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
		// 파일 저장경로 설정 
		// 실무: 병도 storage 
		// 개발환경 : 임의 영역 (서버 변경시, 쟈기동시 업로드 파일 삭제됨 )
		// fileUpload 디렉토리에 임의로 작성
		// D:\W\A_TeachingMaterial\7.JspSrpgin\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp\fileUpload
		
		// url --> realpath : application 객체에서 제공해주는 메소드 
		// dpoPost 메소드 안에서 application(servletContext) 객체를 구한다. 
		
		// 1. request.getServletcontext()
		// 2. getServletcontext()  (서블릿에서 제공해주는 메소드 )
		
		
		// 임의의 배포경로 / url로 접근이 가능하다..
//		ServletContext servletcontext = getServletContext();
//		String path = servletcontext.getRealPath("/fileUpload");
		
		// 고정된 영역으로 배포  / d드라이브경로에 잇는것은 url로 접근 불가 하지
		String path = FileUtil.fileUploadPath;   // "D:\\W\\A_TeachingMaterial\\7.JspSrpgin\\fileUpload";
		
		// fileSize 정상적인 경우에만 업로드를 수행한다. 
		if(uploadFilePart.getSize() > 0) {
//			uploadFilePart.write( path + File.separator + fileName );  // File.separator는 os 환경에 맞춰 자동으로 
			// 사용자가 업로드한 실제 파일명은 디비상 저장학고, 물리적 파일명은 임의로 적용 
			uploadFilePart.write( path + File.separator + UUID.randomUUID().toString() );  
			uploadFilePart.delete();
		}
		// path 파일경로 :D:\W\A_TeachingMaterial\7.JspSrpgin\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp\fileUpload
		// fileName 파일이름 :  filename="하트_라이언.gif"
		
		
		// getParts
		/*
		fileUpload.jsp의 form 에서 
		enctype="application/x-www-form-urlencoded" 일때
		15:18:59.970 [http-bio-8180-exec-14] DEBUG kr.or.ddit.file.FileUploadServlet - contentType == > application/x-www-form-urlencoded
		15:18:59.970 [http-bio-8180-exec-14] DEBUG kr.or.ddit.file.FileUploadServlet - userId == > brown
		15:18:59.970 [http-bio-8180-exec-14] DEBUG kr.or.ddit.file.FileUploadServlet - upLoadFile == > pooh.gif
		
		fileUpload.jsp의 form 에서 
		enctype="multipart/form-data
		15:51:38.782 [http-bio-8180-exec-2] DEBUG kr.or.ddit.file.FileUploadServlet - contentType == > multipart/form-data; boundary=----WebKitFormBoundarylN6eBW8cbhyabKPY
		15:51:38.783 [http-bio-8180-exec-2] DEBUG kr.or.ddit.file.FileUploadServlet - userId == > null
		15:51:38.784 [http-bio-8180-exec-2] DEBUG kr.or.ddit.file.FileUploadServlet - upLoadFile == > null
		
		어노테이션 추가 후
		@MultipartConfig(maxFileSize=1024*1000*5, maxRequestSize=1024*1000*16)
		15:57:13.513 [http-bio-8180-exec-14] DEBUG kr.or.ddit.file.FileUploadServlet - contentType == > multipart/form-data; boundary=----WebKitFormBoundaryECak0A6Z5E8Wy4Lf
		15:57:13.535 [http-bio-8180-exec-14] DEBUG kr.or.ddit.file.FileUploadServlet - userId == > brown
		15:57:13.535 [http-bio-8180-exec-14] DEBUG kr.or.ddit.file.FileUploadServlet - upLoadFile == > null
		
		uploadFilePart 로 변경
		16:01:00.495 [http-bio-8180-exec-23] DEBUG kr.or.ddit.file.FileUploadServlet - contentType == > multipart/form-data; boundary=----WebKitFormBoundary3CZd3MYvSoCLEK7H
		16:01:00.522 [http-bio-8180-exec-23] DEBUG kr.or.ddit.file.FileUploadServlet - userId == > brown
		16:01:00.522 [http-bio-8180-exec-23] DEBUG kr.or.ddit.file.FileUploadServlet - uploadFilePart == > org.apache.catalina.core.ApplicationPart@76a2a376
		
		getHeader("Content-Disposition")
		16:05:29.750 [http-bio-8180-exec-28] DEBUG kr.or.ddit.file.FileUploadServlet - contentType == > multipart/form-data; boundary=----WebKitFormBoundaryUWbNhqK1Wl7nloDK
		16:05:29.767 [http-bio-8180-exec-28] DEBUG kr.or.ddit.file.FileUploadServlet - userId == > brown
		16:05:29.767 [http-bio-8180-exec-28] DEBUG kr.or.ddit.file.FileUploadServlet - contentDisposition == > form-data; name="upLoadFile"; filename="하트_라이언.gif"
		 */
	}
}
