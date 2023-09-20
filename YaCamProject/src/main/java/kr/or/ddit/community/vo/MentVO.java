package kr.or.ddit.community.vo;

public class MentVO {
	private int mt_no     ;
	private String mem_id    ;
	private int comm_no   ;
	private String mt_dtl    ;
	private String mt_date    ;
	private String mt_child  ;
	
	public int getMt_no() {
		return mt_no;
	}
	public void setMt_no(int mt_no) {
		this.mt_no = mt_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getComm_no() {
		return comm_no;
	}
	public void setComm_no(int comm_no) {
		this.comm_no = comm_no;
	}
	public String getMt_dtl() {
		return mt_dtl;
	}
	public void setMt_dtl(String mt_dtl) {
		this.mt_dtl = mt_dtl;
	}
	public String getMt_date() {
		return mt_date;
	}
	public void setMt_date(String mt_date) {
		this.mt_date = mt_date;
	}
	public String getMt_child() {
		return mt_child;
	}
	public void setMt_child(String mt_child) {
		this.mt_child = mt_child;
	}
}
