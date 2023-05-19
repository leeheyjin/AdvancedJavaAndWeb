package kr.or.ddit.vo;

public class LprodVO {
	private int lprod_id;
	private String lprod_gu;
	private String lprod_nm;

	public int getLprodId() {
		return lprod_id;
	}

	public void setLprodId(int lprodId) {
		this.lprod_id = lprodId;
	}

	public String getLprodGu() {
		return lprod_gu;
	}

	public void setLprodGu(String lprodGu) {
		this.lprod_gu = lprodGu;
	}

	public String getLprodNm() {
		return lprod_nm;
	}

	public void setLprodNm(String lprodNm) {
		this.lprod_nm = lprodNm;
	}

	@Override
	public String toString() {
		return "LprodVO [lprodId=" + lprod_id + ", lprodGu=" + lprod_gu + ", lprodNm=" + lprod_nm + "]";
	}

}
