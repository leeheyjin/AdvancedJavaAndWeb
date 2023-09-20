package kr.or.ddit.campinfo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.campinfo.service.CampInfoServiceImpl;
import kr.or.ddit.campinfo.service.ICampInfoService;
import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.wishlist.service.IWishlistService;
import kr.or.ddit.wishlist.service.WishlistServiceImpl;
import kr.or.ddit.wishlist.vo.WishlistVo;


@WebServlet("/searchCamp.do")
public class SearchCamp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String region = request.getParameter("region");
		String type1 = request.getParameter("type1");
		String type2 = request.getParameter("type2");
		String search = request.getParameter("search");
		String id = request.getParameter("memid");
		System.out.println("지역 결과 : " + region);
		System.out.println("검색 결과 : " + search);
		Map<String, Object> map = new HashMap<>();
		map.put("region", region);
		map.put("type1", type1);
		map.put("type2", type2);
		map.put("search", search);
	
		//찜모골
		MemberVO membervo = (MemberVO)request.getSession().getAttribute("userinfo");
		
		WishlistVo vo = new WishlistVo();
		vo.setMem_id(membervo.getMem_id());
		vo.setWis_status(1);
		
		IWishlistService wishservice = WishlistServiceImpl.getInstance();
		List<WishlistVo> wishlist = wishservice.Wishlist(membervo.getMem_id());
		
		request.setAttribute("wishlist", wishlist);
//찜목록
		
		
		ICampInfoService service = CampInfoServiceImpl.getInstance();
		
		List<CampInfoVO> searchCamp = service.getSearchCamp(map);
		
		request.setAttribute("searchCamp", searchCamp);
		System.out.println(searchCamp);
		request.getRequestDispatcher("/ksj/searchcampservlet.jsp")
			.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
