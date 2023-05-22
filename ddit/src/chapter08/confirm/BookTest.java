package chapter08.confirm;

import java.util.Objects;

abstract class Book {
	private int number;
	private String title;
	private String author;
	private static int countOfBooks = 0;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;

		number = countOfBooks;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public abstract int getLateFee(int lateDays);

	@Override
	public int hashCode() {
		return Objects.hash(author, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return String.format("관리번호 %d번, 제목: %s, 작가: %s(일주일 연체료: " + getLateFee(7) + "원)", ++countOfBooks, title,
				author);
	}
}

class Novel extends Book {

	public Novel(String title, String author) {
		super(title, author);
	}

	@Override
	public int getLateFee(int lateDays) {
		return lateDays * 300;
	}

}

class ScienceFiction extends Book {

	public ScienceFiction(String title, String author) {
		super(title, author);
	}

	@Override
	public int getLateFee(int lateDays) {
		return lateDays * 600;
	}

}

class Poet extends Book {

	public Poet(String title, String author) {
		super(title, author);
	}

	@Override
	public int getLateFee(int lateDays) {
		return lateDays * 200;
	}

}

public class BookTest {
	public static void main(String[] args) {
		System.out.println("<소장 도서 목록>");
		Book[] books = new Book[6];
		books[0] = new Novel("칼의 노래", "김훈");
		books[1] = new Novel("칼의 노래", "김훈");
		books[2] = new Poet("이상한 가역반응", "이상");
		books[3] = new Poet("하늘과 바람과 별과 시", "윤동주");
		books[4] = new ScienceFiction("유년기의 끝", "아서 C. 클라크");
		books[5] = new ScienceFiction("스페이스 오디세이", "아서 C. 클라크");
		for (Book b : books) {
			System.out.println(b);
		}
		System.out.println("1번 책과 2번 책은 같은 책인가요?" + books[0].equals(books[1]));
	}

}
