package kr.or.ddit.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSQLSessionFactory {
	public static SqlSessionFactory sqlSessionFactory;

	static {
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패!");
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// SQLSession객체를 반환하는 메서드
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
