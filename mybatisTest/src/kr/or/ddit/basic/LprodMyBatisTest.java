package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

public class LprodMyBatisTest {
	// myBatis를 이용해 DB자료를 처리하는 순서 및 방법
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 1. myBatis의 환경설정파일(myBatis-config.xml)을 읽어와서 실행한다
		InputStream in = null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			// 1-1. 환경설정 파일을 읽어 올 스트림 객체 생성
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/myBatis-config.xml");
			// 1-2. 환경 설정 파일을 읽어와 환경 설정을 완료한 후 쿼리문을 호출해서 실행할 수 있는 객체를 생성할 수 있는
			// SqlSesscionFactory 객체를 생성한다
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			System.out.println("myBatis 초기화 실패");
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}

		// 2. mapper에 등록된 쿼리문들 중 실행할 쿼리문을 호출해서 원하는 작업을 수행한다
		// 2-1. insert연습
//		System.out.println("insert작업 시작");
//		System.out.print("LPROD_ID: ");
//		int lprodId = Integer.parseInt(scanner.nextLine());
//		System.out.print("LPROD_GU: ");
//		String lprodGu = scanner.nextLine();
//		System.out.print("LPROD_NM: ");
//		String lprodNm = scanner.nextLine();
//
//		// 입력한 데이터를 vo객체에 저장한다
//		LprodVO vo1 = new LprodVO();
//		vo1.setLprodId(lprodId);
//		vo1.setLprodGu(lprodGu);
//		vo1.setLprodNm(lprodNm);
//
//		SqlSession session = null;
//		try {
//			// SqlSessionFactory객체를 이용하여 SqlSession객체를 구한다
//			// openSession(boolean) 사용: 인자가 true면 AutoCommit이 활성화된 상태이고 생략되거나 false이면 AutoCommit이 비활성화된 상태이다
//			session = sqlSessionFactory.openSession();
//			// SqlSession객체를 이용하여 처리할 SQL문을 호출하여 실행한다
//			// int insert("namespace속성값.id속성값", 파라미터클래스(작업할 vo객체)): 작업에 성공한 레코드 수를 반환한다
//			int insertCnt = session.insert("lprod.insert", vo1);
//			if (insertCnt > 0) {
//				System.out.println("insert작업 성공");
//				// SqlSession객체를 생성할 때 AutoCommit이 비활성화된 상태라면 commit을 시켜줘야 한다
//				session.commit();
//			} else {
//				System.out.println("insert작업 실패");
//			}
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}

		// 2-2. update연습
//		System.out.println("update작업 시작");
//		System.out.print("수정할 LPROD_GU 입력: ");
//		String lprodGu2 = scanner.nextLine();
//		System.out.print("새로운 LPROD_ID 입력: ");
//		int lprodId2 = Integer.parseInt(scanner.nextLine());
//		System.out.print("새로운 LPROD_NM 입력: ");
//		String lprodNm2 = scanner.nextLine();
//
//		LprodVO vo2 = new LprodVO();
//		vo2.setLprodGu(lprodGu2);
//		vo2.setLprodId(lprodId2);
//		vo2.setLprodNm(lprodNm2);
//
//		SqlSession session = null;
//		session = sqlSessionFactory.openSession();
//		int updateCnt = session.update("lprod.update", vo2);
//		if (updateCnt > 0) {
//			System.out.println("update 성공");
//			// SqlSession객체를 생성할 때 AutoCommit이 비활성화된 상태라면 commit을 시켜줘야 한다
//			session.commit();
//		} else {
//			System.out.println("update 실패");
//		} 

		// 2-3. delete연습
//		System.out.println("delete작업 시작");
//		System.out.print("삭제할 LPROD_GU 입력 >> ");
//		String lprodGu3 = scanner.nextLine();
//		
//		SqlSession session = sqlSessionFactory.openSession();
//		int deleteCnt = session.delete("lprod.delete", lprodGu3);
//		if (deleteCnt > 0) {
//			System.out.println("delete 성공");
//			// SqlSession객체를 생성할 때 AutoCommit이 비활성화된 상태라면 commit을 시켜줘야 한다
//			session.commit();
//		} else {
//			System.out.println("delete 실패");
//		} 

		// 2-4. select연습
		// 2-4-1. 응답 결과가 여러개일 경우
//		System.out.println("select작업 시작");
//		SqlSession session = null;
//		try {
//			session = sqlSessionFactory.openSession();
//			// 응답 결과가 여러개일 경우 selectList()메서드를 사용하는데 이 메서드는 여러개의 레코드 각각을 vo객체에 담은 후 이 vo데이터를
//			// list에 추가해주는 작업을 자동으로 수행한다
//			List<LprodVO> selectList = session.selectList("lprod.selectAll");
//			for (LprodVO lprodVO : selectList) {
//				System.out.println(lprodVO);
////			System.out.println("LPROD_ID: " + lprodVO.getLprodId());
////			System.out.println("LPROD_GU: " + lprodVO.getLprodGu());
////			System.out.println("LPROD_NM: " + lprodVO.getLprodNm());
//			}
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}

		// 2-4-2. 응답 결과가 한개일 경우
		System.out.println("select 작업 시작");
		System.out.print("검색할 LPROD_GU 입력 >> ");
		String lprodGu = scanner.nextLine();
		SqlSession session = sqlSessionFactory.openSession();
		LprodVO selectOne = session.selectOne("lprod.selectOne", lprodGu);
		System.out.println(selectOne);
	}

}
