package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil2;
import oracle.net.aso.p;

public class JDBCTest06Answer {
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		new JDBCTest06Answer().memberStart();

	}

	private void memberStart() {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 추가
				insert();
				break;
			case 2: // 삭제
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				displayAll();
				break;
			case 5:
				updateMember2();
				break;
			case 0:
				System.out.println("작업을 마칩니다");
				return;

			default:
				System.out.println("작업 번호를 잘못 입력했습니다. 다시 입력해주세요.");
				break;
			}
		}

	}

	private int displayMenu() {
		System.out.println("--------------------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("0. 작업 끝");
		System.out.println();
		System.out.print("메뉴를 선택하세요 >> ");
		return Integer.parseInt(scanner.nextLine());
	}

	private void insert() {
		System.out.println("--------------------------");
		System.out.println("추가할 회원 정보를 입력하세요");
		String memId;
		int count = 0;
		do {
			System.out.print("회원ID >> ");
			memId = scanner.nextLine();
			count = getMemberCount(memId);
			if (count > 0) {
				System.out.println(memId + "는 이미 등록된 회원ID입니다.");
				System.out.println("다른 회원 ID를 입력하세요");
			}
		} while (count > 0);
		System.out.print("비밀번호 >> ");
		String memPass = scanner.nextLine();
		System.out.print("이름 >> ");
		String memName = scanner.nextLine();
		System.out.print("전화번호 >> ");
		String memTel = scanner.nextLine();
		System.out.print("주소 >> ");
		String memAddr = scanner.nextLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil2.getConnection();
			String sql = "INSERT INTO MYMEMBER VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memId);
			preparedStatement.setString(2, memPass);
			preparedStatement.setString(3, memName);
			preparedStatement.setString(4, memTel);
			preparedStatement.setString(5, memAddr);

			int num = preparedStatement.executeUpdate();

			if (num > 0) {
				System.out.println("회원 정보 추가 완료");
			} else {
				System.out.println("회원 정보 추가 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}

	}

	private int getMemberCount(String memId) {
		int count = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil2.getConnection();
			String sql = "SELECT COUNT(*) COUNT FROM MYMEMBER WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				count = resultSet.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return count;
	}

	private void delete() {
		System.out.println("--------------------------");
		System.out.println("삭제할 회원 정보를 입력하세요");
		System.out.print("회원ID >> ");
		String memId = scanner.nextLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil2.getConnection();
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memId);

			int num = preparedStatement.executeUpdate();
			if (num > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
	}

	private void update() {
		System.out.println("--------------------------");
		System.out.print("수정할 회원 정보를 입력하세요");
		System.out.println("회원ID >> ");
		String memId = scanner.nextLine();
		int count = getMemberCount(memId);
		if (count == 0) {
			System.out.println(memId + "는 없는 회원ID 입니다");
			System.out.println("수정 작업을 종료합니다");
			return;
		}

		System.out.print("새로운 비밀번호 >> ");
		String newMemPass = scanner.nextLine();
		System.out.print("새로운 이름 >> ");
		String newMemName = scanner.nextLine();
		System.out.print("새로운 전화번호 >> ");
		String newMemTel = scanner.nextLine();
		System.out.print("새로운 주소 >> ");
		String newMemAddr = scanner.nextLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil2.getConnection();
			String sql = "UPDATE MYMEMBER SET MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newMemPass);
			preparedStatement.setString(2, newMemName);
			preparedStatement.setString(3, newMemTel);
			preparedStatement.setString(4, newMemAddr);
			preparedStatement.setString(5, memId);
			int num = preparedStatement.executeUpdate();
			if (num > 0) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
			}
		}
	}

	private void displayAll() {
		System.out.println("--------------------------");
		System.out.println("ID\t비밀번호\t이름\t전화번호\t주소");
		System.out.println("--------------------------");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil2.getConnection();
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				System.out.println(memId + "\t" + memPass + "\t" + memName + "\t" + memTel + "\t" + memAddr);
			}
		} catch (SQLException e) {
			// TODO: handle exception
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
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
	}

	private void updateMember2() {
		System.out.println("--------------------------");
		System.out.println("수정할 회원 정보를 입력하세요");
		System.out.print("회원ID >> ");
		String memId = scanner.nextLine();
		int count = getMemberCount(memId);
		if (count == 0) {
			System.out.println(memId + "는 없는 회원ID 입니다");
			System.out.println("수정 작업을 종료합니다");
			return;
		}

		// 쌤답
		int choice; // 수정을 원하는 항목의 선택 번호가 저장될 변수
		String updateField = null; // 수정할 컬럼명이 저장될 변수
		String updateTitle = null; // 입력할 때 보여줄 제목

		do {
			System.out.println("수정할 항목을 선택하세요");
			System.out.println("1. 비밀번호\t2. 회원이름\t3. 전화번호\t4. 회원주소");
			System.out.print("수정할 항목 선택 >> ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				updateField = "MEM_PASS";
				updateTitle = "비밀번호";
				break;
			case 2:
				updateField = "MEM_NAME";
				updateTitle = "회원이름";
				break;
			case 3:
				updateField = "MEM_TEL";
				updateTitle = "전화번호";
				break;
			case 4:
				updateField = "MEM_ADDR";
				updateTitle = "회원주소";

				break;

			default:
				System.out.println("잘못된 입력입니다. 다시 선택하세요 ");
				break;
			}
		} while (choice < 1 || choice > 4);

		System.out.println();
		System.out.println("수정할 " + updateTitle + " >> ");
		String updateData = scanner.nextLine(); // 수정할 데이터 입력

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil2.getConnection();
			String sql = "UPDATE MYMEMBER SET " + updateField + " = ? WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, updateData);
			preparedStatement.setString(2, memId);

			int num = preparedStatement.executeUpdate();
			if (num > 0) {
				System.out.println("수정 작업 완료");
			} else {
				System.out.println("수정 작업 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
			}
		}

		// 내답
//		Connection conn = null;
//		PreparedStatement prepareStatement = null;
//		conn = DBUtil.getConnection();
//
//		try {
//			System.out.println("수정 가능한 항목입니다.");
//			System.out.println("1. 비밀번호");
//			System.out.println("2. 이름");
//			System.out.println("3. 전화번호");
//			System.out.println("4. 주소");
//			System.out.print("수정할 항목을 선택하세요 >> ");
//			String choice = scanner.nextLine();
//			switch (choice) {
//			case "1": // 비밀번호
//				System.out.print("수정할 비밀번호를 입력하세요 >> ");
//				String memPass = scanner.nextLine();
//				String sql = "UPDATE MYMEMBER SET MEM_PASS = ? WHERE MEM_ID = ?";
//				prepareStatement = conn.prepareStatement(sql);
//				prepareStatement.setString(1, memPass);
//				prepareStatement.setString(2, memId);
//				
//				int num = prepareStatement.executeUpdate();
//				if (num > 0) {
//					System.out.println("비밀번호 수정이 완료되었습니다.");
//				} else {
//					System.out.println("비밀번호 수정을 실패했습니다. 이전으로 돌아갑니다.");
//				}
//				return;
//
//			case "2": // 비밀번호
//				System.out.print("수정할 이름을 입력하세요 >> ");
//				String memName = scanner.nextLine();
//				sql = "UPDATE MYMEMBER SET MEM_NAME = ? WHERE MEM_ID = ?";
//				prepareStatement = conn.prepareStatement(sql);
//				prepareStatement.setString(1, memName);
//				prepareStatement.setString(2, memId);
//				num = prepareStatement.executeUpdate();
//				if (num > 0) {
//					System.out.println("이름 수정이 완료되었습니다.");
//				} else {
//					System.out.println("이름 수정을 실패했습니다. 이전으로 돌아갑니다.");
//				}
//				return;
//
//			case "3": // 비밀번호
//				System.out.print("수정할 전화번호를 입력하세요 >> ");
//				String memTel = scanner.nextLine();
//				sql = "UPDATE MYMEMBER SET MEM_TEL = ? WHERE MEM_ID = ?";
//				prepareStatement = conn.prepareStatement(sql);
//				prepareStatement.setString(1, memTel);
//				prepareStatement.setString(2, memId);
//				num = prepareStatement.executeUpdate();
//				if (num > 0) {
//					System.out.println("전화번호 수정이 완료되었습니다.");
//				} else {
//					System.out.println("전화번호 수정을 실패했습니다. 이전으로 돌아갑니다.");
//				}
//				return;
//
//			case "4": // 비밀번호
//				System.out.print("수정할 주소를 입력하세요 >> ");
//				String memAddr = scanner.nextLine();
//				sql = "UPDATE MYMEMBER SET MEM_ADDR = ? WHERE MEM_ID = ?";
//				prepareStatement = conn.prepareStatement(sql);
//				prepareStatement.setString(1, memAddr);
//				prepareStatement.setString(2, memId);
//				num = prepareStatement.executeUpdate();
//				if (num > 0) {
//					System.out.println("주소 수정이 완료되었습니다.");
//				} else {
//					System.out.println("주소 수정을 실패했습니다. 이전으로 돌아갑니다.");
//				}
//				return;
//			default:
//				System.out.println("잘못된 입력입니다. 이전으로 돌아갑니다.");
//				break;
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				if (prepareStatement != null) {
//					prepareStatement.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e2) {
//			}
//		}
	}

}
