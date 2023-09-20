package kr.or.ddit.blacklist.vo;

public class BlackListVO {
	private String black_no  ;
	private String mem_id    ;
	private String black_date;
	
	
	

	public String getBlack_no() {
		return black_no;
	}




	public void setBlack_no(String black_no) {
		this.black_no = black_no;
	}




	public String getMem_id() {
		return mem_id;
	}




	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}




	public String getBlack_date() {
		return black_date;
	}




	public void setBlack_date(String black_date) {
		this.black_date = black_date;
	}




	@Override
	public String toString() {
		return "BlackListVO [black_no=" + black_no + ", mem_id=" + mem_id + ", black_date=" + black_date + "]";
	}
	
	
	
	
}
