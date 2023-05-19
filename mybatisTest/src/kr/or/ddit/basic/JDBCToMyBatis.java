package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

public class JDBCToMyBatis {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		InputStream in = null;
		SqlSessionFactory sFactory = null;
		try {
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/myBatis-config.xml");
			sFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			System.out.println("myBatis 초기화 실패");
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("insert 작업 시작");
		// lprod_id
		SqlSession session = sFactory.openSession();
		int lprodId = session.selectOne("LPROD.selectMaxLPROD_ID");

		// lprod_gu
		String lprodGu;
		int count = 0;
		do {
			System.out.print("LPROD_GU: ");
			lprodGu = scanner.nextLine();
			count = session.selectOne("LPROD.isExists", lprodGu);
			if (count > 0) {
				if (count > 0) {
					System.out.println("입력한 상품 분류 코드 " + lprodGu + "는 이미 등록된 코드입니다");
					System.out.println("다시 입력하세요");
				}
			}
		} while (count > 0);

		// lprod_nm
		System.out.print("상품 분류명(LPROD_NM) 입력 >> ");
		String lprodNm = scanner.nextLine();
		LprodVO vo = new LprodVO();
		vo.setLprodId(lprodId);
		vo.setLprodGu(lprodGu);
		vo.setLprodNm(lprodNm);

		session = sFactory.openSession();
		int insertCount = session.insert("LPROD.insert", vo);
		if (insertCount > 0) {
			System.out.println("insert 성공");
			session.commit();
		} else {
			System.out.println("insert 실패");
		}
	}

}
