package kr.or.ddit.basic;

import java.sql.Statement;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil3;
import oracle.net.aso.r;

/*
 * 회원을 관리하는 프로그램을 작성하시오
 * 아래 메뉴의 기능을 모두 구현하시오
 * 
 * 메뉴 예시)
 * --------------------------
 * 1. 자료 추가		(insert)C
 * 2. 자료 삭제		(delete)D
 * 3. 자료 수정		(update)U
 * 4. 전체 자료 출력	(select)R
 * 0. 작업 끝
 * --------------------------
 * 
 * 조건
 * 1. 1번 메뉴에서 회원ID는 중복되지 않는다(중복되면 다시 입력받기)
 * 2. 자료 삭제는 회원ID를 입력받아 진앵한다.
 * 3. 자료 수정에서 회원ID를 변경할 수 없다
 */
public class JDBCTest06 {
	private Connection connection;
	private Statement statement;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;

	private Scanner scanner;

	public JDBCTest06() {
		connection = DBUtil3.getConnection();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new JDBCTest06().start();
	}

	private void start() {
		while (true) {
			String choice = showMenu();
			switch (choice) {
			case "1": // 자료 추가
				insert();
				break;

			case "2": // 자료 삭제
				delete();
				break;

			case "3": // 자료 수정
				update();
				break;

			case "4": // 전체 자료 출력
				selectAll();
				break;

			case "0":
				System.out.println("작업을 종료합니다");
				new JDBCTest06().closeAll();
				return;

			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요");
				break;
			}
		}

	}

	private String showMenu() {
		System.out.println("--------------------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println();
		System.out.print("메뉴를 선택하세요 >> ");
		String choice = scanner.nextLine();
		System.out.println("--------------------------");
		return choice;
	}

	private void insert() {
		try {
			System.out.println("추가할 자료의 정보를 입력하세요");

			// 아이디 존재 여부 검사
			int existsNum = 0;
			System.out.print("아이디 >> ");
			String memId = scanner.nextLine();
			String selectIdSQL = "SELECT COUNT(*) COUNT FROM MYMEMBER WHERE MEM_ID = ?";
			prepareStatement = connection.prepareStatement(selectIdSQL);
			prepareStatement.setString(1, memId);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				existsNum = resultSet.getInt("COUNT");
			}
			if (existsNum > 0) {
				System.out.println("입력한 아이디 " + memId + "는 이미 등록된 아이디입니다. 다시 시도해주세요.");
				return;
			}
			// 검사 끝

			System.out.print("비밀번호 >> ");
			String memPass = scanner.nextLine();
			System.out.print("이름 >> ");
			String memName = scanner.nextLine();
			System.out.print("전화번호 >> ");
			String memTel = scanner.nextLine();
			System.out.print("주소 >> ");
			String memAddr = scanner.nextLine();

			String sql = "INSERT INTO MYMEMBER VALUES (?, ?, ?, ?, ?)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, memId);
			prepareStatement.setString(2, memPass);
			prepareStatement.setString(3, memName);
			prepareStatement.setString(4, memTel);
			prepareStatement.setString(5, memAddr);

			int count = prepareStatement.executeUpdate();
			if (count > 0) {
				System.out.println("등록이 완료되었습니다.");
			} else {
				System.out.println("등록을 실패했습니다. 다시 시도해주세요.");
			}
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void delete() {
		try {
			// 아이디 존재 여부 검사
			int existsNum = 0;
			System.out.print("삭제할 정보의 ID를 입력하세요. >> ");
			String memId = scanner.nextLine();
			String selectIdSQL = "SELECT COUNT(*) COUNT FROM MYMEMBER WHERE MEM_ID = ?";
			prepareStatement = connection.prepareStatement(selectIdSQL);
			prepareStatement.setString(1, memId);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				existsNum = resultSet.getInt("COUNT");
			}
			if (existsNum <= 0) {
				System.out.println("입력한 아이디 " + memId + "는 존재하지 않는 아이디입니다. 다시 시도해주세요.");
				return;
			}
			// 검사 끝

			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, memId);
			int count = prepareStatement.executeUpdate();
			if (count > 0) {
				System.out.println("삭제가 완료되었습니다.");
			} else {
				System.out.println("삭제를 실패했습니다. 다시 시도해주세요.");
			}
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void update() {
		try {
			// 아이디 존재 여부 검사
			int existsNum = 0;
			System.out.print("수정할 정보의 ID를 입력하세요. >> ");
			String memId = scanner.nextLine();
			String selectIdSQL = "SELECT COUNT(*) COUNT FROM MYMEMBER WHERE MEM_ID = ?";
			prepareStatement = connection.prepareStatement(selectIdSQL);
			prepareStatement.setString(1, memId);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				existsNum = resultSet.getInt("COUNT");
			}
			if (existsNum <= 0) {
				System.out.println("입력한 아이디 " + memId + "는 존재하지 않는 아이디입니다. 다시 시도해주세요.");
				return;
			}
			// 검사 끝

			System.out.println("수정 가능한 항목입니다.");
			System.out.println("1. 비밀번호");
			System.out.println("2. 이름");
			System.out.println("3. 전화번호");
			System.out.println("4. 주소");
			System.out.print("수정할 항목을 선택하세요 >> ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1": // 비밀번호
				System.out.print("수정할 비밀번호를 입력하세요 >> ");
				String memPass = scanner.nextLine();
				String sql = "UPDATE MYMEMBER SET MEM_PASS = ? WHERE MEM_ID = ?";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, memPass);
				prepareStatement.setString(2, memId);
				int count = prepareStatement.executeUpdate();
				if (count > 0) {
					System.out.println("비밀번호 수정이 완료되었습니다.");
				} else {
					System.out.println("비밀번호 수정을 실패했습니다. 이전으로 돌아갑니다.");
				}
				return;

			case "2": // 비밀번호
				System.out.print("수정할 이름을 입력하세요 >> ");
				String memName = scanner.nextLine();
				sql = "UPDATE MYMEMBER SET MEM_NAME = ? WHERE MEM_ID = ?";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, memName);
				prepareStatement.setString(2, memId);
				count = prepareStatement.executeUpdate();
				if (count > 0) {
					System.out.println("이름 수정이 완료되었습니다.");
				} else {
					System.out.println("이름 수정을 실패했습니다. 이전으로 돌아갑니다.");
				}
				return;

			case "3": // 비밀번호
				System.out.print("수정할 전화번호를 입력하세요 >> ");
				String memTel = scanner.nextLine();
				sql = "UPDATE MYMEMBER SET MEM_TEL = ? WHERE MEM_ID = ?";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, memTel);
				prepareStatement.setString(2, memId);
				count = prepareStatement.executeUpdate();
				if (count > 0) {
					System.out.println("전화번호 수정이 완료되었습니다.");
				} else {
					System.out.println("전화번호 수정을 실패했습니다. 이전으로 돌아갑니다.");
				}
				return;

			case "4": // 비밀번호
				System.out.print("수정할 주소를 입력하세요 >> ");
				String memAddr = scanner.nextLine();
				sql = "UPDATE MYMEMBER SET MEM_ADDR = ? WHERE MEM_ID = ?";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, memAddr);
				prepareStatement.setString(2, memId);
				count = prepareStatement.executeUpdate();
				if (count > 0) {
					System.out.println("주소 수정이 완료되었습니다.");
				} else {
					System.out.println("주소 수정을 실패했습니다. 이전으로 돌아갑니다.");
				}
				return;
			default:
				System.out.println("잘못된 입력입니다. 이전으로 돌아갑니다.");
				break;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	private void selectAll() {
		try {
			String sql = "SELECT * FROM MYMEMBER";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("회원 아이디: " + resultSet.getString(1));
				System.out.println("회원 비밀번호: " + resultSet.getString(2));
				System.out.println("회원 이름: " + resultSet.getString(3));
				System.out.println("회원 전화번호: " + resultSet.getString(4));
				System.out.println("회원 주소: " + resultSet.getString(5));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeAll() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (prepareStatement != null) {
				prepareStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
			scanner.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
