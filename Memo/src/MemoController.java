import java.util.List;

public class MemoController {
	public void getMemos() throws Exception {
		MemoService service = new MemoService();
		List<MemoVO> list = service.getMemos();
		MemoView view = new MemoView();
		view.printMemos(list);
		
	}

}
