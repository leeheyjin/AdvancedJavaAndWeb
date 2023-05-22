package chapter13;

import java.util.ArrayList;
import java.util.List;

class BoardDao {
	public List<Board> getBoardList() {
		List<Board> title = new ArrayList<>();
		title.add(new Board("제목1", "내용1")); // db에서 읽어오는 코드를 여기 정의.
		title.add(new Board("제목2", "내용2"));
		title.add(new Board("제목3", "내용3"));
		return title;
	}

} // 대박 Dao공포증 극복

class Board {
	private String title;
	private String content;

	public Board(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
}

public class ListExample {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for (Board board : list) {
			System.out.println(board.getTitle() + " - " + board.getContent());
		}
	}
}
