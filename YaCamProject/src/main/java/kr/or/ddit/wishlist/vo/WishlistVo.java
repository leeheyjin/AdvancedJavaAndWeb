package kr.or.ddit.wishlist.vo;

public class WishlistVo {
	private int wis_no;
	private String mem_id;
	private int wis_status;
	private String camp_no;
	
	public int getWis_no() {
		return wis_no;
	}
	public void setWis_no(int wis_no) {
		this.wis_no = wis_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getWis_status() {
		return wis_status;
	}
	public void setWis_status(int wis_status) {
		this.wis_status = wis_status;
	}
	public String getCamp_no() {
		return camp_no;
	}
	public void setCamp_no(String camp_no) {
		this.camp_no = camp_no;
	}
	@Override
	public String toString() {
		return "WishlistVo [wis_no=" + wis_no + ", mem_id=" + mem_id + ", wis_status=" + wis_status + ", camp_no="
				+ camp_no + "]";
	}
	
	
}
