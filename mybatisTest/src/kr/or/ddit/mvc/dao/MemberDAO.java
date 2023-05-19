package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;
import kr.or.ddit.util.MyBatisSQLSessionFactory;

public class MemberDAO implements IMemberDAO {
	private static MemberDAO dao;
	private SqlSession session;

	private MemberDAO() {
		session = MyBatisSQLSessionFactory.getSqlSession();
	}

	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	@Override
	public int insertMember(MemberVO memVO) {
		int count = session.insert("member.insert", memVO);
		commit(count);
		return count;
	}

	private void commit(int count) {
		if (count > 0) {
			session.commit();
		}
	}

	@Override
	public int deleteMember(String mem_id) {
		int count = session.delete("member.delete", mem_id);
		commit(count);
		return count;
	}

	// 쌤답
	@Override
	public int updateMember2(Map<String, String> paraMap) {
		int count = session.update("member.updateOne", paraMap);
		commit(count);
		return count;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> selectList = session.selectList("member.selectAll");
 		return selectList;
	}

	@Override
	public int getMemberCount(String mem_id) {
		int count = session.selectOne("member.isExists", mem_id);
		return count;
	}

	@Override
	public int updateAllInfo(MemberVO memVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
