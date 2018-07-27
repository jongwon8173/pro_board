package kr.or.ddit.jspboard.model;

/**
 * 
 * JspCommentVo.java
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
 *- 게시글에 댓글,답글 VO 
 * </pre>
 */
public class JspCommentVo {
	
	private int com_no ; 		// 댓글번호(ID)(PK)    	널 여부   "N"
	private int com_pno ; 		// 상위댓글번호(ID)(FK)	    널 여부   "N"
	private int posts_no ; 		// 게시글번호(ID)(FK)	    널 여부   "N"
	private  String com_con ; 	// 댓글내용	    		널 여부   "Y"
	private  String com_dt ; 	// 작성일시	    		널 여부   "N"
	private  String com_wri ; 	// 작성자(학생번호ID)	널 여부   "N"
	private  String com_yn ; 	// 삭제여부	    		널 여부   "Y"
	
	
	public JspCommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public JspCommentVo(int com_no, int com_pno, int posts_no, String com_con,
			String com_dt, String com_wri, String com_yn) {
		super();
		this.com_no = com_no;
		this.com_pno = com_pno;
		this.posts_no = posts_no;
		this.com_con = com_con;
		this.com_dt = com_dt;
		this.com_wri = com_wri;
		this.com_yn = com_yn;
	}


	public int getCom_no() {
		return com_no;
	}


	public void setCom_no(int com_no) {
		this.com_no = com_no;
	}


	public int getCom_pno() {
		return com_pno;
	}


	public void setCom_pno(int com_pno) {
		this.com_pno = com_pno;
	}


	public int getPosts_no() {
		return posts_no;
	}


	public void setPosts_no(int posts_no) {
		this.posts_no = posts_no;
	}


	public String getCom_con() {
		return com_con;
	}


	public void setCom_con(String com_con) {
		this.com_con = com_con;
	}


	public String getCom_dt() {
		return com_dt;
	}


	public void setCom_dt(String com_dt) {
		this.com_dt = com_dt;
	}


	public String getCom_wri() {
		return com_wri;
	}


	public void setCom_wri(String com_wri) {
		this.com_wri = com_wri;
	}


	public String getCom_yn() {
		return com_yn;
	}


	public void setCom_yn(String com_yn) {
		this.com_yn = com_yn;
	}


	
	@Override
	public String toString() {
		return "JspCommentVo [com_no=" + com_no + ", com_pno=" + com_pno
				+ ", posts_no=" + posts_no + ", com_con=" + com_con
				+ ", com_dt=" + com_dt + ", com_wri=" + com_wri + ", com_yn="
				+ com_yn + "]";
	}
	
	
	

}
