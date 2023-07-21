package kr.or.ddit.service;

import kr.or.ddit.vo.BookVO;

import java.awt.print.Book;
import java.util.List;

public interface IBookService {
    public int insert(BookVO vo);

    public BookVO detail(BookVO vo);

    public List<BookVO> list(String keyword);

    public int updatePost(BookVO vo);

    public int deletePost(String bookId);
}
