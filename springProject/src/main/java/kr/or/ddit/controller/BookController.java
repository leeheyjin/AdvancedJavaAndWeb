package kr.or.ddit.controller;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/* Controller 어노테이션
 스프링 프레임워크에게 "이 클래스는 웹 브라우저의 요청(request)를
 받아들이는 컨트롤러야"라고 알려주는 것임
 스프링은 servlet-context.xml의 context:component-scan의 설정에 의해
 이 클래스를 자바빈 객체로 등록(메모리에 바인딩)
 */
@Slf4j
@Controller
public class BookController {
    @Autowired
    BookService service;

    /*
     요청URL : /create
     요청파라미터 : 없음
     요청방식 : get
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
		/*
		 ModelAndView
		 1) Model : Controller가 반환할 데이터(String, int, List, Map, VO..)를 담당
		 2) View : 화면을 담당(뷰(View : JSP)의 경로)
		 */
        ModelAndView mav = new ModelAndView();

        //forwarding : JSP를 처리, 컴파일하여 HTML로 만들어 리턴
        //prefix : /WEB-INF/views/
        mav.setViewName("book/create");
        //suffix : .jsp
        //조립되면 : /WEB-INF/views/book/create.jsp

        return mav;
    }

    /*
     요청URL : /create
      요청파라미터 : {title=개똥이의 모험,category=소설,price=10000}
      요청방식 : post

      BookVO [bookId=0, title=개똥이의 모험, category=소설, price=10000, content=null, insertDate=null]
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createPost(HttpServletRequest request, ModelAndView mav, BookVO bookVO) {
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String price = request.getParameter("price");

        //bookVO : BookVO [bookId=0, title=1, category=2, price=3, content=null, insertDate=null]
        log.info("insert 전 BookVO  : " + bookVO);
        int result = this.service.insert(bookVO);
        log.info("insert result: ", result);
        log.info("insert 후 BookVO  : " + bookVO);

        //forwarding
        mav.setViewName("book/create");

        return mav;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail(BookVO vo, ModelAndView mav) {
        log.info("BookVO 상세보기 전: " + vo);
        vo = this.service.detail(vo);
        log.info("BookVO 상세보기 후: " + vo);
        mav.addObject("vo", vo); // data라는 이름으로 vo객체를 보냄 request.setAttribute("data", vo); 와 동일한듯?
        mav.setViewName("book/detail");
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView mav, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
        log.info("keyword: " + keyword);
        List<BookVO> list = this.service.list(keyword);
        mav.addObject("list", list);
        mav.setViewName("book/list");
        return mav;
    }

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    public ModelAndView updatePost(@ModelAttribute BookVO vo, ModelAndView mav) {
        int result = this.service.updatePost(vo);
        if (result > 0) {
            //redirect: URI를 재요청
            mav.setViewName("redirect:/detail?bookId=" + vo.getBookId());
        } else { //업데이트 실패 시 => 책 목록 페이지(list.jsp)로 이동
            mav.setViewName("redirect:/list");
        }
        return mav;
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    public ModelAndView deletePost(String bookId, ModelAndView mav) {
        int result = this.service.deletePost(bookId);
        if (result > 0) {
            mav.setViewName("redirect:/list");
        } else {
            mav.setViewName("redirect:/detail?bookId=" + bookId);
        }
        return mav;
    }
}

