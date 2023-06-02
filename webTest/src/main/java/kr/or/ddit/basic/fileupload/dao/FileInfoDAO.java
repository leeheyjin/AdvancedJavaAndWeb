package kr.or.ddit.basic.fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.vo.FileInfoVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class FileInfoDAO implements IFileInfoDAO {
	private static IFileInfoDAO dao;

	private FileInfoDAO() {
	}

	public static IFileInfoDAO getInstance() {
		if (dao == null) {
			dao = new FileInfoDAO();
		}
		return dao;
	}

	@Override
	public int insert(FileInfoVO vo) {
		SqlSession session = null;
		int count = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			count = session.insert("fileInfo.insert", vo);
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public List<FileInfoVO> getAll() {
		SqlSession session = null;
		List<FileInfoVO> list = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			list = session.selectList("fileInfo.getAll");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public FileInfoVO getOne(int file_no) {
		SqlSession session = null;
		FileInfoVO vo = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			vo = session.selectOne("fileInfo.getOne", file_no);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return vo;
	}

}
