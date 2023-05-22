import java.sql.Date;
import java.util.Objects;

public class MemoVO {
	private int memoId;
	private String memoTitle;
	private String memoContent;
	private Date memoRegiDate;
	private Date memoModiDate;

	/**
	 * INSERT 생성자
	 * 
	 * @param memo_title
	 * @param memo_content
	 */
	public MemoVO(String memoTitle, String memoContent) {
		this.memoTitle = memoTitle;
		this.memoContent = memoContent;
	}

	/**
	 * SELECT 생성자
	 * 
	 * @param memoId
	 * @param memoTitle
	 * @param memoCString
	 * @param memoRegiDate
	 * @param memoModiDate
	 */
	public MemoVO(int memoId, String memoTitle, String memoCString, Date memoRegiDate, Date memoModiDate) { // select용 생성																											// 생성자
		this.memoId = memoId;
		this.memoTitle = memoTitle;
		this.memoContent = memoCString;
		this.memoRegiDate = memoRegiDate;
		this.memoModiDate = memoModiDate;
	}

	public int getMemoId() {
		return memoId;
	}

	public void setMemoId(int memoId) {
		this.memoId = memoId;
	}

	public String getMemoTitle() {
		return memoTitle;
	}

	public void setMemoTitle(String memoTitle) {
		this.memoTitle = memoTitle;
	}

	public String getMemoContent() {
		return memoContent;
	}

	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}

	public Date getMemoRegiDate() {
		return memoRegiDate;
	}

	public void setMemoRegiDate(Date memoRegiDate) {
		this.memoRegiDate = memoRegiDate;
	}

	public Date getMemoModiDate() {
		return memoModiDate;
	}

	public void setMemoModiDate(Date memoModiDate) {
		this.memoModiDate = memoModiDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemoVO other = (MemoVO) obj;
		return memoId == other.memoId;
	}

	@Override
	public String toString() {
		return String.format("%d\t%s\t%s\t%s\t%s", memoId, memoTitle, memoContent, memoRegiDate, memoModiDate);
	}
}
