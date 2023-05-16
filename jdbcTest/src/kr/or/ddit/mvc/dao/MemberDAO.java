package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDAO implements IMemberDAO {

	@Override
	public int insertMember(MemberVO memVO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int count = 0;
		try {
			connection = DBUtil3.getConnection();
			String sql = "INSERT INTO MYMEMBER VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memVO.getMem_id());
			preparedStatement.setString(2, memVO.getMem_pass());
			preparedStatement.setString(3, memVO.getMem_name());
			preparedStatement.setString(4, memVO.getMem_tel());
			preparedStatement.setString(5, memVO.getMem_addr());

			int num = preparedStatement.executeUpdate();

			if (num > 0) {
				System.out.println("회원 정보 추가 완료");
			} else {
				System.out.println("회원 정보 추가 실패");
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
				e2.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public int deleteMember(String mem_id) {
		return 0;
	}

	@Override
	public int updateMember(MemberVO memVO) {
		return 0;
	}

	@Override
	public List<MemberVO> getAllMember() {
		return null;
	}

	@Override
	public int getMemberCount(String mem_id) {
		return 0;
	}

}
