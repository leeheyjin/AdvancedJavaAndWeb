package kr.or.ddit.answerboard.vo;

public class AnswerVO {
	private int ans_no  ;
	private int que_no  ;
	private String mem_id  ;
	private String ans_dtl ;
	private String ans_date;
	
	public int getAns_no() {
		return ans_no;
	}
	public void setAns_no(int ans_no) {
		this.ans_no = ans_no;
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
	public String getAns_dtl() {
		return ans_dtl;
	}
	public void setAns_dtl(String ans_dtl) {
		this.ans_dtl = ans_dtl;
	}
	public String getAns_date() {
		return ans_date;
	}
	public void setAns_date(String ans_date) {
		this.ans_date = ans_date;
	}
}
