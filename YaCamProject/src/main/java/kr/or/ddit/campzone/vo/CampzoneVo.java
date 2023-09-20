package kr.or.ddit.campzone.vo;

public class CampzoneVo {
	private String zone_no        ;
	private String camp_no        ;
	private String zone_type      ;
	private int zone_price     ;
	private int zone_standard  ;
	private int zone_add_price ;
	private int zone_maximum   ;
	
	public String getZone_no() {
		return zone_no;
	}
	public void setZone_no(String zone_no) {
		this.zone_no = zone_no;
	}
	public String getCamp_no() {
		return camp_no;
	}
	public void setCamp_no(String camp_no) {
		this.camp_no = camp_no;
	}
	public String getZone_type() {
		return zone_type;
	}
	public void setZone_type(String zone_type) {
		this.zone_type = zone_type;
	}
	public int getZone_price() {
		return zone_price;
	}
	public void setZone_price(int zone_price) {
		this.zone_price = zone_price;
	}
	public int getZone_standard() {
		return zone_standard;
	}
	public void setZone_standard(int zone_standard) {
		this.zone_standard = zone_standard;
	}
	public int getZone_add_price() {
		return zone_add_price;
	}
	public void setZone_add_price(int zone_add_price) {
		this.zone_add_price = zone_add_price;
	}
	public int getZone_maximum() {
		return zone_maximum;
	}
	public void setZone_maximum(int zone_maximum) {
		this.zone_maximum = zone_maximum;
	}
	@Override
	public String toString() {
		return "CampzoneVo [zone_no=" + zone_no + ", camp_no=" + camp_no + ", zone_type=" + zone_type + ", zone_price="
				+ zone_price + ", zone_standard=" + zone_standard + ", zone_add_price=" + zone_add_price
				+ ", zone_maximum=" + zone_maximum + "]";
	}
	
	
	
	
	
}
