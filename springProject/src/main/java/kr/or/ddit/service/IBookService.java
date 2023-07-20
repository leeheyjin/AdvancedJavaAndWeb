package kr.or.ddit.service;

import kr.or.ddit.vo.BookVO;

import java.awt.print.Book;

public interface IBookService {
    public int insert(BookVO vo);

    public BookVO detail(BookVO vo);
}
