package test.java.test03;

public class MemberVO {
    private String memNo;
    private String memName;
    private int memBirthYear;

    public MemberVO() {

    }

    public MemberVO(String memNo, String memName, int memBirthYear) {
        this.memNo = memNo;
        this.memName = memName;
        this.memBirthYear = memBirthYear;
    }

    public String getMemNo() {
        return memNo;
    }

    public void setMemNo(String memNo) {
        this.memNo = memNo;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public int getMemBirthYear() {
        return memBirthYear;
    }

    public void setMemBirthYear(int memBirthYear) {
        this.memBirthYear = memBirthYear;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "memNo='" + memNo + '\'' +
                ", memName='" + memName + '\'' +
                ", memBirthYear=" + memBirthYear +
                '}';
    }
}
