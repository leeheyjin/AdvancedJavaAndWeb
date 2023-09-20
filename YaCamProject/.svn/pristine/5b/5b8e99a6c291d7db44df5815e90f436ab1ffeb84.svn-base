package kr.or.ddit.wishlist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wishlist.dao.WishlistDaoImpl;
import kr.or.ddit.wishlist.service.IWishlistService;
import kr.or.ddit.wishlist.service.WishlistServiceImpl;
import kr.or.ddit.wishlist.vo.WishlistVo;

/**
 * Servlet implementation class Wishlist
 */
@WebServlet("/Wishlist.do")
public class Wishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	public static void main(String[] args) {
//		WishlistDaoImpl impl = new WishlistDaoImpl();
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("memid");
		int status = Integer.parseInt(request.getParameter("status"));
		String campno = request.getParameter("campno");
		System.out.println("설정값"+id);
		System.out.println("설정값"+status);
		System.out.println("설정값"+campno);
		
		
		WishlistVo vo = new WishlistVo();
		vo.setMem_id(id);
		vo.setWis_status(status);
		vo.setCamp_no(campno);
		
		IWishlistService service = WishlistServiceImpl.getInstance();
		
		int set=3;
		
		if(status == 1) {
			System.out.println("등록");
			set = service.insertWishlist(vo);
		}else {
			System.out.println("삭제");
			set = service.deleteWishlist(vo);
		}
		
		request.setAttribute("result", set);
		System.out.println("vo값이뭔닝" + vo);
		
		request.getRequestDispatcher("/pbc/result.jsp").forward(request, response);
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
