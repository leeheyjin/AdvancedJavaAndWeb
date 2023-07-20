package kr.or.ddit.dao;

import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Slf4j
@Repository
public class BookDAO {
    // 의존성 주입
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public int insert(BookVO vo) {
        log.info("insert 전: " + vo);
        int result = sqlSessionTemplate.insert("book.insert", vo);
        log.info("insert 후: " + vo);
        log.info("result: " + result);

        return result;
    }

    public BookVO detail(BookVO vo) {
        return this.sqlSessionTemplate.selectOne("book.deatil", vo);
    }
}
