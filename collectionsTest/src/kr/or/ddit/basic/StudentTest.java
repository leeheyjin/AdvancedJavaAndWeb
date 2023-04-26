package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제: 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
 * 이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
 * 이 Student 객체는 List에 저장하여 관리한다
 * List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고, 
 * 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오륾차순으로 정렬되는 위부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오(ㅜ)
 * 등수는 StudentTest클래스에서 처리하는데 List에 전체 데이터가 추가된 후에 구해서 저장되도록 한다
 */
public class StudentTest {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(880818, "권지용", 90, 90, 90));
		students.add(new Student(871104, "최승현", 80, 80, 80));
		students.add(new Student(890426, "강대성", 70, 70, 70));
		students.add(new Student(880518, "동영배", 60, 60, 60));
		students.add(new Student(901212, "이승현", 90, 90, 90));

		System.out.println("등수 부여 후");
		createRank(students);
		printStudents(students);

		System.out.println("정렬 전");
		printStudents(students);

		System.out.println("내부 정렬 후");
		Collections.sort(students);
		printStudents(students);

		System.out.println("외부 정렬 후");
		Collections.sort(students, new TotalDesc());
		printStudents(students);
	}

	// 등수 구하는 메서드
	public static void createRank(List<Student> rankStudentsList) {
		for (Student student1 : rankStudentsList) { // 기존 데이터를 구하기 위한(등수를 구하기 위한) 반복문
			int rank = 1; // 처음에는 등수를 1로 설정해놓고 시작한다.
			for (Student student2 : rankStudentsList) {
				if (student1.getTotalScore() < student2.getTotalScore()) {
					rank++;
				}
			}
			// 구해진 등수를 기존 데이터의 rank변수에 저장한다.
			student1.setRanking(rank);
		}
	}

	private static void printStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}

class TotalDesc implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		Integer studnet1Total = student1.getTotalScore();
		Integer studnet2Total = student2.getTotalScore();

		if (studnet1Total.compareTo(studnet2Total) > 0) {
			return -1;
		} else if (studnet1Total.compareTo(studnet2Total) < 0) {
			return 1;
		} else {
			return student1.compareTo(student2);
		}

	}

}

class Student implements Comparable<Student> {
	private int studentNo;
	private String studentName;
	private int koreanScore;
	private int mathScore;
	private int englishScore;
	private int totalScore;
	private int ranking;

	public Student(int studentNo, String studentName, int koreanScore, int mathScore, int englishScore) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.koreanScore = koreanScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		setTotalScore(getKoreanScore() + getMathScore() + getEnglishScore());
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", koreanScore=" + koreanScore
				+ ", mathScore=" + mathScore + ", englishScore=" + englishScore + ", totalScore=" + totalScore
				+ ", ranking=" + ranking + "]";
	}

	@Override
	public int compareTo(Student student) {
		return new Integer(this.getStudentNo()).compareTo(student.getStudentNo());
	}

}