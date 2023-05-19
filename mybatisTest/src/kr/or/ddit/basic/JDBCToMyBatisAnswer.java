package kr.or.ddit.basic;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.MyBatisSQLSessionFactory;
import kr.or.ddit.vo.LprodVO;

public class JDBCToMyBatisAnswer {
	// JDBC예제 중 05.java를 myBatis용으로 변환하시오.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		SqlSession session = null;
		try {
			session = MyBatisSQLSessionFactory.getSqlSession();
			int lprodId = session.selectOne("jdbc.getMaxId");
			lprodId++;

			// LPROD_ID는 현재의 LPROD_ID의 값 중 제일 큰 값보다 1 크게 한다
			String lprodGu;
			int count = 0;
			do {
				System.out.print("상품 분류 코드(LPROD_GU) 입력 >> ");
				lprodGu = scan.nextLine();
				count = session.selectOne("jdbc.getLprodCount", lprodGu);
				if (count > 0) {
					System.out.println("입력한 상품 분류 코드 " + lprodGu + "는 이미 등록된 코드입니다");
					System.out.println("다시 입력하세요");
				}
			} while (count > 0);

			System.out.print("상품 분류명(LPROD_NM) 입력 >> ");
			String lprodNm = scan.nextLine();

			LprodVO vo = new LprodVO();
			vo.setLprodId(lprodId);
			vo.setLprodGu(lprodGu);
			vo.setLprodNm(lprodNm);

			int insertCount = session.insert("jdbc.getMaxId", vo);
			if (insertCount > 0) {
				System.out.println("insert 성공");
				session.commit();
			} else {
				System.out.println("insert 실패");
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
