<%@ page import="java.util.List" %>
<%@ page import="kr.or.ddit.dao.ProductDAO" %>
<%@ page import="kr.or.ddit.vo.ProductVO" %><%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/17
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String productId = request.getParameter("productId");
    if (productId == null || productId.trim().equals("")) {
        response.sendRedirect("product.jsp");
        return;
    }

    ProductDAO dao = new ProductDAO();
    ProductVO productById = dao.product(productId);
    if (productById == null) {
        response.sendRedirect("exceptionNoProductId.jsp");
        return;
    }

    // 세션의 장바구니에서 상품이 있는제 체크한후 있다면 장바구니에서 제외처리
    List<ProductVO> cartList = (List<ProductVO>) session.getAttribute("cartlist");
    for (int i = 0; i < cartList.size(); i++) {
        if (cartList.get(i).getProductId().equals(productId)) {
            cartList.remove(cartList.get(i));
        }
    }
    response.sendRedirect("cart.jsp");
%>
