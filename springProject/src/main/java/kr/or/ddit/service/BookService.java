package kr.or.ddit.service;

import kr.or.ddit.dao.BookDAO;
import kr.or.ddit.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

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

}
