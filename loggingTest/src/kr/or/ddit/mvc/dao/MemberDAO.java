package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil;

public class MemberDAO implements IMemberDAO {
	private static MemberDAO dao;
	private static final Logger LOGGER = Logger.getLogger(MemberDAO.class);

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
			connection = DBUtil.getConnection();
			LOGGER.info("Connection객체 생성 완료");
			String sql = "INSERT INTO MYMEMBER VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			LOGGER.info("PreparedStatement객체 생성 완료");
			preparedStatement.setString(1, memVO.getMemId());
			preparedStatement.setString(2, memVO.getMemPass());
			preparedStatement.setString(3, memVO.getMemName());
			preparedStatement.setString(4, memVO.getMemTel());
			preparedStatement.setString(5, memVO.getMemAddr());
			LOGGER.debug("실행 SQL: " + sql);
			LOGGER.debug("사용 데이터 : [" + memVO.getMemId() + ", " + memVO.getMemPass() + ", " + memVO.getMemName() + ", "
					+ memVO.getMemTel() + ", " + memVO.getMemAddr() + "]");

			num = preparedStatement.executeUpdate();
			LOGGER.info("작업 성공");
		} catch (SQLException e) {
			LOGGER.info("작업 실패", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					LOGGER.info("PreparedStatement객체 반납 완료");
				}
				if (connection != null) {
					connection.close();
					LOGGER.info("Connection객체 반납 완료");
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
			connection = DBUtil.getConnection();
			LOGGER.info("Connection객체 생성 완료");
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			LOGGER.info("PreparedStatement객체 생성 완료");
			preparedStatement.setString(1, mem_id);
			LOGGER.debug("실행 SQL: " + sql);
			LOGGER.debug("사용 데이터 : [" + mem_id + "]");
			num = preparedStatement.executeUpdate();
			LOGGER.info("작업 성공");
		} catch (SQLException e) {
			LOGGER.info("작업 실패", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					LOGGER.info("PreparedStatement객체 반납 완료");
				}
				if (connection != null) {
					connection.close();
					LOGGER.info("Connection객체 반납 완료");
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
			connection = DBUtil.getConnection();
			LOGGER.info("Connection객체 생성 완료");
			String sql = "UPDATE MYMEMBER SET MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			LOGGER.info("PreparedStatement객체 생성 완료");
			preparedStatement.setString(1, memVO.getMemPass());
			preparedStatement.setString(2, memVO.getMemName());
			preparedStatement.setString(3, memVO.getMemTel());
			preparedStatement.setString(4, memVO.getMemAddr());
			preparedStatement.setString(5, memVO.getMemId());
			LOGGER.debug("실행 SQL: " + sql);
			LOGGER.debug("사용 데이터 : [" + memVO.getMemPass() + ", " + memVO.getMemName() + ", " + memVO.getMemTel() + ", "
					+ memVO.getMemAddr() + ", " + memVO.getMemId() + "]");

			num = preparedStatement.executeUpdate();
			LOGGER.info("작업 성공");
		} catch (SQLException e) {
			LOGGER.info("작업 실패", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					LOGGER.info("PreparedStatement객체 반납 완료");
				}
				if (connection != null) {
					connection.close();
					LOGGER.info("Connection객체 반납 완료");
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
			connection = DBUtil.getConnection();
			LOGGER.info("Connection객체 생성 완료");
			String sql = "UPDATE MYMEMBER SET " + updateField + " = ? WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			LOGGER.info("PreparedStatement객체 생성 완료");
			preparedStatement.setString(1, updateData);
			preparedStatement.setString(2, memId);
			LOGGER.debug("실행 SQL: " + sql);
			LOGGER.debug("사용 데이터 : [" + updateData + ", " + memId + "]");

			num = preparedStatement.executeUpdate();
			LOGGER.info("작업 성공");
		} catch (SQLException e) {
			LOGGER.info("작업 실패", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					LOGGER.info("PreparedStatement객체 반납 완료");
				}
				if (connection != null) {
					connection.close();
					LOGGER.info("Connection객체 반납 완료");
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
			connection = DBUtil.getConnection();
			LOGGER.info("Connection객체 생성 완료");
			String sql = "UPDATE MYMEMBER SET " + paraMap.get("field") + " = ? WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			LOGGER.info("PreparedStatement객체 생성 완료");
			preparedStatement.setString(1, paraMap.get("data"));
			preparedStatement.setString(2, paraMap.get("memId"));
			LOGGER.debug("실행 SQL: " + sql);
			LOGGER.debug("사용 데이터 : [" + paraMap.get("data") + ", " + paraMap.get("memId") + "]");

			num = preparedStatement.executeUpdate();
			LOGGER.info("작업 성공");
		} catch (SQLException e) {
			LOGGER.info("작업 실패", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					LOGGER.info("PreparedStatement객체 반납 완료");
				}
				if (connection != null) {
					connection.close();
					LOGGER.info("Connection객체 반납 완료");
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
			connection = DBUtil.getConnection();
			LOGGER.info("Connection객체 생성 완료");
			String sql = "select * from mymember";
			preparedStatement = connection.prepareStatement(sql);
			LOGGER.info("PreparedStatement객체 생성 완료");
			resultSet = preparedStatement.executeQuery();
			LOGGER.info("ResultSet객체 생성 완료");
			LOGGER.debug("실행 SQL: " + sql);

			memList = new ArrayList<>();
			while (resultSet.next()) {
				MemberVO memVo = new MemberVO();
				memVo.setMemId(resultSet.getString("MEM_ID"));
				memVo.setMemPass(resultSet.getString("MEM_PASS"));
				memVo.setMemName(resultSet.getString("MEM_NAME"));
				memVo.setMemTel(resultSet.getString("MEM_TEL"));
				memVo.setMemAddr(resultSet.getString("MEM_ADDR"));
				memList.add(memVo);
				LOGGER.info("작업 성공");
			}
		} catch (SQLException e) {
			LOGGER.info("작업 실패", e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
					LOGGER.info("ResultSet객체 반납 완료");
				}
				if (preparedStatement != null) {
					preparedStatement.close();
					LOGGER.info("PreparedStatement객체 반납 완료");
				}
				if (connection != null) {
					connection.close();
					LOGGER.info("Connection객체 반납 완료");
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
			connection = DBUtil.getConnection();
			LOGGER.info("Connection객체 생성 완료");
			String sql = "SELECT COUNT(*) COUNT FROM MYMEMBER WHERE MEM_ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			LOGGER.info("PreparedStatement객체 생성 완료");
			preparedStatement.setString(1, mem_id);
			LOGGER.debug("실행 SQL: " + sql);
			LOGGER.debug("사용 데이터 : [" + mem_id + "]");

			resultSet = preparedStatement.executeQuery();
			LOGGER.info("ResultSet객체 생성 완료");

			if (resultSet.next()) {
				count = resultSet.getInt("COUNT");
			}
			LOGGER.info("작업 성공");
		} catch (SQLException e) {
			LOGGER.info("작업 실패", e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
					LOGGER.info("ResultSet객체 반납 완료");
				}
				if (preparedStatement != null) {
					preparedStatement.close();
					LOGGER.info("PreparedStatement객체 반납 완료");
				}
				if (connection != null) {
					connection.close();
					LOGGER.info("Connection객체 반납 완료");
				}
			} catch (SQLException e2) {

			}
		}
		return count;
	}

}
