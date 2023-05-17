package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

public class MemberDAO implements IMemberDAO {
	private static MemberDAO dao;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	@Override
	public int insertMember(MemberVO memVO) {
		int num = 0;
		try {
			connection = DBUtil3.getConnection();
			String sql = "INSERT INTO MYMEMBER VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memVO.getMemId());
			preparedStatement.setString(2, memVO.getMemPass());
			preparedStatement.setString(3, memVO.getMemName());
			preparedStatement.setString(4, memVO.getMemTel());
			preparedStatement.setString(5, memVO.getMemAddr());

			num = preparedStatement.executeUpdate();
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
		return num;
	}

	@Override
	public int deleteMember(String mem_id) {
		int num = 0;
		try {
			connection = DBUtil3.getConnection();
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mem_id);

			num = preparedStatement.executeUpdate();
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
		return num;
	}

	@Override
	public int updateAllInfo(MemberVO memVO) {
		int num = 0;
		try {
			connection = DBUtil3.getConnection();
			String sql = "UPDATE MYMEMBER SET MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memVO.getMemPass());
			preparedStatement.setString(2, memVO.getMemName());
			preparedStatement.setString(3, memVO.getMemTel());
			preparedStatement.setString(4, memVO.getMemAddr());
			preparedStatement.setString(5, memVO.getMemId());

			num = preparedStatement.executeUpdate();
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
		return num;
	}

	@Override
	public int updateOneInfo(String memId, String updateField, String updateData) {
		int num = 0;
		try {
			connection = DBUtil3.getConnection();
			String sql = "UPDATE MYMEMBER SET " + updateField + " = ? WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, updateData);
			preparedStatement.setString(2, memId);

			num = preparedStatement.executeUpdate();
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
		return num;
	}

	// 쌤답
	@Override
	public int updateMember2(Map<String, String> paraMap) {
		int num = 0;
		try {
			connection = DBUtil3.getConnection();
			String sql = "UPDATE MYMEMBER SET " + paraMap.get("field") + " = ? WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, paraMap.get("data"));
			preparedStatement.setString(2, paraMap.get("memId"));

			num = preparedStatement.executeUpdate();
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
		return num;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = null;
		try {
			connection = DBUtil3.getConnection();
			String sql = "select * from mymember";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			memList = new ArrayList<>();
			while (resultSet.next()) {
				MemberVO memVo = new MemberVO();
				memVo.setMemId(resultSet.getString("MEM_ID"));
				memVo.setMemPass(resultSet.getString("MEM_PASS"));
				memVo.setMemName(resultSet.getString("MEM_NAME"));
				memVo.setMemTel(resultSet.getString("MEM_TEL"));
				memVo.setMemAddr(resultSet.getString("MEM_ADDR"));
				memList.add(memVo);
			}
		} catch (SQLException e) {

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

			}
		}
		return memList;
	}

	@Override
	public int getMemberCount(String mem_id) {
		int count = 0;

		try {
			connection = DBUtil3.getConnection();
			String sql = "SELECT COUNT(*) COUNT FROM MYMEMBER WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mem_id);

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

			}
		}
		return count;
	}

}
