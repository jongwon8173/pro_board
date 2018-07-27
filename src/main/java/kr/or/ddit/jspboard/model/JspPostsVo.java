package kr.or.ddit.jspboard.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * JspPostsVo.java
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
 *- 게시판 하위에 게시글VO
 * </pre>
 */
public class JspPostsVo {
	
	private int rnum;				// 번호
	private int lvl;				// level
	private int posts_no ; 			// 게시글번호(ID)(PK)	    널 여부   "N"
	private int posts_pno ; 		// 상위게시글번호(ID)(FK)	널 여부   "N"
	private int board_no ; 			// 게시판유형번호(ID)(FK)	널 여부   "N"
	private  String posts_tit ; 	// 게시글제목	    		널 여부   "N"
	private  String posts_con ; 	// 게시글내용	    		널 여부   "Y"
	private  String posts_wri ; 	// 작성자(학생번호ID)	    널 여부   "N"
	private  String posts_indt ; 	// 작성일자	    			널 여부   "N"
	private  String posts_yn ; 		// 삭제여부	    			널 여부   "Y"
	private  String posts_updt ; 	// 수정일	    			널 여부   "Y"
	private int posts_count ; 		// 조회수	    			널 여부   "Y"
	private int posts_grpno ; 		// 게시글그룹번호	    	널 여부   "Y"
	
	private List<JspCommentVo> commentList = new ArrayList<JspCommentVo>() ; 	// 게시글 댓글 리스트
	private List<JspFileVo> fileList = new ArrayList<JspFileVo>();	// 게시풀 첨부파일 리스트
	
	public JspPostsVo() {
	}
	
	public JspPostsVo(int board_no, int posts_no, String posts_tit, String posts_con, String posts_wri) {
		super();
		this.board_no = board_no;
		this.posts_no = posts_no;
		this.posts_tit = posts_tit;
		this.posts_con = posts_con;
		this.posts_wri = posts_wri;
	}
	
	public JspPostsVo(int posts_no, int posts_pno, int board_no,
			String posts_tit, String posts_con, String posts_wri,
			String posts_indt, String posts_yn, String posts_updt,
			int posts_count, int posts_grpno) {
		super();
		this.posts_no = posts_no;
		this.posts_pno = posts_pno;
		this.board_no = board_no;
		this.posts_tit = posts_tit;
		this.posts_con = posts_con;
		this.posts_wri = posts_wri;
		this.posts_indt = posts_indt;
		this.posts_yn = posts_yn;
		this.posts_updt = posts_updt;
		this.posts_count = posts_count;
		this.posts_grpno = posts_grpno;
	}
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getLvl() {
		return lvl;
	}


	public void setLvl(int lvl) {
		this.lvl = lvl;
	}


	public int getPosts_no() {
		return posts_no;
	}
	public void setPosts_no(int posts_no) {
		this.posts_no = posts_no;
	}
	public int getPosts_pno() {
		return posts_pno;
	}
	public void setPosts_pno(int posts_pno) {
		this.posts_pno = posts_pno;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getPosts_tit() {
		return posts_tit;
	}
	public void setPosts_tit(String posts_tit) {
		this.posts_tit = posts_tit;
	}
	public String getPosts_con() {
		return posts_con;
	}
	public void setPosts_con(String posts_con) {
		this.posts_con = posts_con;
	}
	public String getPosts_wri() {
		return posts_wri;
	}
	public void setPosts_wri(String posts_wri) {
		this.posts_wri = posts_wri;
	}
	public String getPosts_indt() {
		return posts_indt;
	}
	public void setPosts_indt(String posts_indt) {
		this.posts_indt = posts_indt;
	}
	public String getPosts_yn() {
		return posts_yn;
	}
	public void setPosts_yn(String posts_yn) {
		this.posts_yn = posts_yn;
	}
	public String getPosts_updt() {
		return posts_updt;
	}
	public void setPosts_updt(String posts_updt) {
		this.posts_updt = posts_updt;
	}
	public int getPosts_count() {
		return posts_count;
	}
	public void setPosts_count(int posts_count) {
		this.posts_count = posts_count;
	}
	public int getPosts_grpno() {
		return posts_grpno;
	}
	public void setPosts_grpno(int posts_grpno) {
		this.posts_grpno = posts_grpno;
	}

	public List<JspCommentVo> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<JspCommentVo> commentList) {
		this.commentList = commentList;
	}

	public List<JspFileVo> getFileList() {
		return fileList;
	}

	public void setFileList(List<JspFileVo> fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "JspPostsVo [posts_no=" + posts_no + ", posts_pno=" + posts_pno
				+ ", board_no=" + board_no + ", posts_tit=" + posts_tit
				+ ", posts_con=" + posts_con + ", posts_wri=" + posts_wri
				+ ", posts_indt=" + posts_indt + ", posts_yn=" + posts_yn
				+ ", posts_updt=" + posts_updt + ", posts_count=" + posts_count
				+ ", posts_grpno=" + posts_grpno + "]";
	}

	
}
