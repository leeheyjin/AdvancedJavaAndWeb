package kr.or.ddit.dao;

import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Slf4j
@Repository
public class BookDAO {
    // 의존성 주입
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public int insert(BookVO vo) {
        return sqlSessionTemplate.insert("book.insert", vo);
    }

    public BookVO detail(BookVO vo) {
        return this.sqlSessionTemplate.selectOne("book.detail", vo);
    }

    public List<BookVO> list(String keyword) {
        return this.sqlSessionTemplate.selectList("book.list", keyword);
    }

    public int updatePost(BookVO vo) {
        return this.sqlSessionTemplate.update("book.updatePost", vo);
    }

    public int deletePost(String bookId) {
        return this.sqlSessionTemplate.delete("book.deletePost", bookId);
    }
}
