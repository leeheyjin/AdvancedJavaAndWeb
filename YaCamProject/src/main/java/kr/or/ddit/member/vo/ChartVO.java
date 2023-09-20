package kr.or.ddit.member.vo;

public class ChartVO {
	private int age;
	private int count;
	private String mem_gender;
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	
	
	@Override
	public String toString() {
		return "ChartAgeVO [age=" + age + ", count=" + count + ", mem_gender=" + mem_gender + "]";
	}
	
	
	
}
