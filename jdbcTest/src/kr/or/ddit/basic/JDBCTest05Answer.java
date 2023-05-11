package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

public class JDBCTest05Answer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			// lprod_id는 현재의 lprod_id중에서 제일 큰 값보다 1크게 한다
//			String sql = "SELECT NVL(MAX(LPROD_ID), 0) FROM LPROD";
			String sql = "SELECT NVL(MAX(LPROD_ID), 0) MAXID FROM LPROD";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int maxNum = 0;
			if (rs.next()) { // select문을 처리한 결과가 1개의 레코드일 경우에는 while문 대신 if문을 사용해도 된다.
//				maxNum = rs.getInt(1);
//				maxNum = rs.getInt("nvl(max(lprod_id), 0)");
				maxNum = rs.getInt("MAXID");
			}
			maxNum++;

			// 입력받은 lprod_id가 이미 등록되어 있으면 다시 입력받아서 처리한다.
			String lprodGu; // lprod_gu값이 저장될 변수
			int count = 0; // 입력한 상품분류코드가 db에 저장된 개수를 저장할 변수선언

			do {
				System.out.print("상품분류코드(LPROD_ID) 입력 >> ");
				lprodGu = scan.nextLine();

				String sql2 = "SELECT COUNT(*) COUNT FROM LPROD WHERE LPROD_GU = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, lprodGu);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					count = rs.getInt("COUNT");
				}

				if (count > 0) {
					System.out.println("입력한 상품 분류 코드 " + lprodGu + "는 이미 등록된 코드입니다");
					System.out.println("다시 입력하세요");
				}
			} while (count > 0);

			// 상품 분류명(lprod_nm)입력
			System.out.print("상품 분류명(LPROD_NM) 입력 >> ");
			String lprodName = scan.next();

			// db에 insert하기
			String sql3 = "INSERT INTO LPROD VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, maxNum);
			pstmt.setString(2, lprodGu);
			pstmt.setString(3, lprodName);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				scan.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}

	}

}
