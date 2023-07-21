package kr.or.ddit.service;

import kr.or.ddit.dao.BookDAO;
import kr.or.ddit.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    BookDAO dao;

    @Override
    public int insert(BookVO vo) {
        return this.dao.insert(vo);
    }

    @Override
    public BookVO detail(BookVO vo) {
        return this.dao.detail(vo);
    }

    @Override
    public List<BookVO> list(String keyword) {
        return this.dao.list(keyword);
    }

    @Override
    public int updatePost(BookVO vo) {
        return this.dao.updatePost(vo);
    }

    @Override
    public int deletePost(String bookId) {
        return this.dao.deletePost(bookId);
    }


}
