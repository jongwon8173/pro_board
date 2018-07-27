package kr.or.ddit.jspboard.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * JspStudentVo.java
 *
 * @author pc24
 * @since 2018. 7. 19.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 19. pc24 최초 생성
 * 
 * - 회원(학생) VO 
 * </pre>
 */
public class JspStudentVo implements HttpSessionBindingListener{
	
	private Logger logger = LoggerFactory.getLogger(JspStudentVo.class);	
	
	private  String std_id ; 	// 학생아이디	널 여부   "N"
	private  String pass ; 		// 비밀번호	    널 여부   "N"
	private  String name ; 		// 학생이름	    널 여부   "N"
	private int call_cnt ; 		// 호출횟수	    널 여부   "Y"
	private  String addr1 ; 	// 주소	    	널 여부   "Y"
	private  String addr2 ; 	// 상세주소	    널 여부   "Y"
	private  String zipcd ; 	// 우편번호	    널 여부   "Y"
	private  String pic ; 		// 프로필사진	널 여부   "Y"
	private  String picpath ; 	// 파일경로	    널 여부   "Y"
	private  String picname ; 	// 파일이름	    널 여부   "Y"
	private  String reg_dt ; 	// 등록일	    널 여부   "N"
	
	public JspStudentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JspStudentVo(String std_id, String pass, String name,
			int call_cnt, String addr1, String addr2, String zipcd, String pic,
			String picpath, String picname, String reg_dt) {
		super();
		this.std_id = std_id;
		this.pass = pass;
		this.name = name;
		this.call_cnt = call_cnt;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcd = zipcd;
		this.pic = pic;
		this.picpath = picpath;
		this.picname = picname;
		this.reg_dt = reg_dt;
	}


	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCall_cnt() {
		return call_cnt;
	}

	public void setCall_cnt(int call_cnt) {
		this.call_cnt = call_cnt;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	
	@Override
	public String toString() {
		return "JspStudentVo [ std_id=" + std_id + ", pass="
				+ pass + ", name=" + name + ", call_cnt=" + call_cnt
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcd=" + zipcd
				+ ", pic=" + pic + ", picpath=" + picpath + ", picname="
				+ picname + ", reg_dt=" + reg_dt + "]";
	}
	

	
public boolean validateUser(String userId, String password){
		System.out.println("userId >>>> "+ userId);
		System.out.println("password >>>> "+ password);
		if (userId.equals(this.getStd_id())  && password.equals(this.getPass()))
			return true;
		else 
			return false;
	}


// ========================================================  2018.07.16
@Override
public void valueBound(HttpSessionBindingEvent event) {
	// session 객체에서 session.setAttribute("userVo", uservo)가 호출 되었을때
	logger.debug("httpSessionBinding valuesBound : " +event.getName());
	
}


@Override
public void valueUnbound(HttpSessionBindingEvent event) {
	// session 객체에서 session.removeAttribute("userVo", uservo)가 호출 되었을때
	logger.debug("httpSessionUnBinding valuesBound : " + event.getName());
	
}
	
	

	

}
