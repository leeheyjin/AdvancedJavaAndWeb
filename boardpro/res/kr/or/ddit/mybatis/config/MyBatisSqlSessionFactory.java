package kr.or.ddit.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory factory;
	
	static {
		InputStream inputStream = null;
		
		try {
			// 1-1. 환경설정파일을 읽어 올 스트링 객체
			inputStream = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패");  // config에 문제
			e.printStackTrace();
		}finally {
			if(inputStream != null) try {inputStream.close();} catch(IOException e) {}
		}
	}
	
	// SqlSession객체를 반환하는 메서드
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}
	
	
}
