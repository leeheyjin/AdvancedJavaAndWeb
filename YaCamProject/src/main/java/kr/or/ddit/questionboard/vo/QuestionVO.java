package kr.or.ddit.questionboard.vo;

public class QuestionVO {
	private int que_no    ;
	private String mem_id    ;
	private String que_typ   ;
	private String que_ttl   ;
	private String que_dtl   ;
	private String que_date  ;
	private String que_redate;
	private String que_file;
	
	public String getQue_file() {
		return que_file;
	}
	public void setQue_file(String que_file) {
		this.que_file = que_file;
	}
	public int getQue_no() {
		return que_no;
	}
	public void setQue_no(int que_no) {
		this.que_no = que_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getQue_typ() {
		return que_typ;
	}
	public void setQue_typ(String que_typ) {
		this.que_typ = que_typ;
	}
	public String getQue_ttl() {
		return que_ttl;
	}
	public void setQue_ttl(String que_ttl) {
		this.que_ttl = que_ttl;
	}
	public String getQue_dtl() {
		return que_dtl;
	}
	public void setQue_dtl(String que_dtl) {
		this.que_dtl = que_dtl;
	}
	public String getQue_date() {
		return que_date;
	}
	public void setQue_date(String que_date) {
		this.que_date = que_date;
	}
	public String getQue_redate() {
		return que_redate;
	}
	public void setQue_redate(String que_redate) {
		this.que_redate = que_redate;
	}
	@Override
	public String toString() {
		return "QuestionVO [que_no=" + que_no + ", mem_id=" + mem_id + ", que_typ=" + que_typ + ", que_ttl=" + que_ttl
				+ ", que_dtl=" + que_dtl + ", que_date=" + que_date + ", que_redate=" + que_redate + ", que_file="
				+ que_file + "]";
	}
	
	
}
