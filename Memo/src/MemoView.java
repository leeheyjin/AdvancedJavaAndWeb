import java.util.List;

public class MemoView {

	public void printMemos(List<MemoVO> list) {
		for (MemoVO vo : list) {
			System.out.println(vo);
		}
	}

}
