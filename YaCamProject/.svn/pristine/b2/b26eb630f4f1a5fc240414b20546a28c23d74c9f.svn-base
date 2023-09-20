package kr.or.ddit.basic.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory factory;
	
	static {
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
			
			
			
		} catch (Exception e) {
			System.out.println("myBatis 추가 실패");
			e.printStackTrace();
		} finally {
			if(in!=null) try {in.close();} catch(Exception e) {}
		}
	}
	//SqlSesstion 객체를 반환하는 메서드
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}

}
