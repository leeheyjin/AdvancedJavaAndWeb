package kr.or.ddit.campinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.campinfo.service.CampInfoServiceImpl;
import kr.or.ddit.campinfo.service.ICampInfoService;
import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.wishlist.service.IWishlistService;
import kr.or.ddit.wishlist.service.WishlistServiceImpl;
import kr.or.ddit.wishlist.vo.WishlistVo;



@WebServlet("/campInfoSearch.do")
public class CampInfoSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICampInfoService service = CampInfoServiceImpl.getInstance();
		
		List<CampInfoVO> campInfoList = service.getCampInfoList();
		System.out.println(campInfoList);
		
		//찜모골
				MemberVO membervo = (MemberVO)request.getSession().getAttribute("userinfo");
				
				WishlistVo vo = new WishlistVo();
				vo.setMem_id(membervo.getMem_id());
				vo.setWis_status(1);
				
				IWishlistService wishservice = WishlistServiceImpl.getInstance();
				List<WishlistVo> wishlist = wishservice.Wishlist(membervo.getMem_id());
				
				request.setAttribute("wishlist", wishlist);
		//찜목록
		
		request.setAttribute("campInfoList", campInfoList);
		
		request.getRequestDispatcher("/ksj/campInfoSearch.jsp")
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
 