package book;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
	private static BookRepository repository;
	private List<BookVO> list = new ArrayList<>();

	private BookRepository() {
		BookVO helloCoding = new BookVO();
		helloCoding.setBookId("ISBN1234");
		helloCoding.setName("[Hello Coding] HTML5 + CSS3");
		helloCoding.setUnitprice(19800);
		helloCoding.setAuthor("황재호");
		helloCoding.setDescription("워드나 PPT문서를 만들 수 있나요? 그러면 문제 없습니다. 지금 바로 웹페이지 제작에 도전해보세요. 지금 당장 컴퓨터가 없어도 괜찮습니. 코드와 실행 화면이 바로 보여서 눈으로만 읽어도 어떻게 작동하는지 쉽게 파악할 수 있는 것은 기본이고, 중간중간 퀴즈를 추가하여 재미있게 게임하듯 복습할 수 있습니다. ");
		helloCoding.setPublisher("한빛미디어");
		helloCoding.setCategory("컴퓨터/IT");
		helloCoding.setUnitsInstock(1000);
		helloCoding.setTotalPages(288);
		helloCoding.setReleaseDate("20180302");
		helloCoding.setCondition("NEW");
		helloCoding.setFileName("ISBN1234.jpeg");

		BookVO eashJSP = new BookVO();
		eashJSP.setBookId("ISBN1235");
		eashJSP.setName("쉽게 배우는 JSP 웹 프로그래밍");
		eashJSP.setUnitprice(27000);
		eashJSP.setAuthor("송미영");
		eashJSP.setDescription("객체 지향의 핵심과 자바의 현대적 기능을 충실히 다루면서도 초보자가 쉽게 학습할 수 있게 구성했습니다. 시각화 도구를 활용한 개념 설명과 군더더기 없는 핵심 코드를 통해 개념과 구현...");
		eashJSP.setPublisher("한빛아카데미");
		eashJSP.setCategory("컴퓨터/IT");
		eashJSP.setUnitsInstock(1000);
		eashJSP.setTotalPages(636);
		eashJSP.setReleaseDate("20181008");
		eashJSP.setCondition("NEW");
		eashJSP.setFileName("ISBN1235.jpg");

		BookVO spring4 = new BookVO();
		spring4.setBookId("ISBN1236");
		spring4.setName("스프링4 입문");
		spring4.setUnitprice(30000);
		spring4.setAuthor("하세가와 유이치, 오오노 와타루, 토키 코헤이");
		spring4.setDescription("스프링은 단순히 사용 방법만 익히는 것보다 아키텍처를 어떻게 이해하고 설계하는지가 더 중요합니다. 예제를 복사해 붙여넣는 식으로는 실제 개발에서 스프링을 제대로 활용할 수 없습니다...");
		spring4.setPublisher("한빛미디어");
		spring4.setCategory("컴퓨터/IT");
		spring4.setUnitsInstock(1000);
		spring4.setTotalPages(520);
		spring4.setReleaseDate("20171101");
		spring4.setCondition("NEW");
		spring4.setFileName("ISBN1236.jpg");

		list.add(helloCoding);
		list.add(eashJSP);
		list.add(spring4);
	}

	public static BookRepository getInstance() {
		return repository = new BookRepository();
	}

	public List<BookVO> getAllProducts() {
		return list;
	}

	// select * from product where product_id = ?
	public BookVO getProductById(String bookId) {
		BookVO book = null;
		for (BookVO bookVO : list) {
			if (bookVO.getBookId().equals(bookId)) {
				book = bookVO;
				break;
			}
		}
		return book;
	}

}
