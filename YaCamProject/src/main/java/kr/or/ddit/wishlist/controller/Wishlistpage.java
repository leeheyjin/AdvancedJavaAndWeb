package kr.or.ddit.wishlist.controller;

import java.io.IOException;
import java.util.ArrayList;
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


@WebServlet("/wishlistpage.do")
public class Wishlistpage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
	   	MemberVO vo =(MemberVO) request.getSession().getAttribute("userinfo");
	   	
	   	String id = vo.getMem_id();
	   	
	   	IWishlistService service = WishlistServiceImpl.getInstance();
	   	ICampInfoService campInfoService = CampInfoServiceImpl.getInstance();
	   	
	   	List<WishlistVo> list = service.Wishlist(id);
	   	
	   	List<CampInfoVO> campInfolist = new ArrayList<>();
	   	CampInfoVO campvo = new CampInfoVO();
	   	for(int i=0; i < list.size(); i++) {
	   		campvo = (CampInfoVO)campInfoService.selectCampName(list.get(i).getCamp_no());
	   		campInfolist.add(campvo);
	   		System.out.println("체크list"+list.get(i).getCamp_no());
	   	}
	   	
	   	request.setAttribute("wishlist", list);
	   	request.setAttribute("campinfolist", campInfolist);
	   	
	   	request.getRequestDispatcher("/Main_KKD/wishlistpage.jsp").forward(request, response);
	   	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
