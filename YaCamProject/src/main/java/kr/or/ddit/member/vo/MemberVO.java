package kr.or.ddit.member.vo;


public class MemberVO {      
	private String mem_id    ;
	private String mem_pass  ;
	private String mem_name  ;
	private String mem_mail  ;
	private String mem_gender;
	private String mem_birth ;
	private String mem_tel   ;
	private String mem_addr  ;
	private String mem_date  ;
	private String mem_grade;
	private String mem_delete;
	private int mem_repcount;
	
	public int getMem_repcount() {
		return mem_repcount;
	}
	public void setMem_repcount(int mem_repcount) {
		this.mem_repcount = mem_repcount;
	}
	public String getMem_delete() {
		return mem_delete;
	}
	public void setMem_delete(String mem_delete) {
		this.mem_delete = mem_delete;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_date() {
		return mem_date;
	}
	public void setMem_date(String mem_date) {
		this.mem_date = mem_date;
	}
	public String getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(String mem_gradeA) {
		this.mem_grade = mem_gradeA;
	}
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_name=" + mem_name + ", mem_mail="
				+ mem_mail + ", mem_gender=" + mem_gender + ", mem_birth=" + mem_birth + ", mem_tel=" + mem_tel
				+ ", mem_addr=" + mem_addr + ", mem_date=" + mem_date + ", mem_grade=" + mem_grade + ", mem_delete="
				+ mem_delete + "]";
	}
	
	
	
	
	
}
