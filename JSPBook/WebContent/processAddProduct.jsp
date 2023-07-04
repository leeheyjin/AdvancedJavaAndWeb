<%@page import="java.util.List"%>
<%@page import="dao.ProductRepository"%>
<%@page import="vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String productId = request.getParameter("productId");
String pname = request.getParameter("pname");
String unitPrice = request.getParameter("unitPrice");
String description = request.getParameter("description");
String manufacturer = request.getParameter("manufacturer");
String category = request.getParameter("category");
String unitsInStock = request.getParameter("unitsInStock");
String condition = request.getParameter("condition");

// 폼페이지에서 상품 가격이 입력되지 않은 경우 0으로, 입력된 경우 int로 변경
int price;
if (unitPrice.isEmpty()) {
	price = 0;
} else {
	price = Integer.parseInt(unitPrice);
}

// 폼페이지에서 상품 재고수가 입력되지 않은 경우 0으로 입력된 경우 int로 변경
int stock;
if (unitsInStock.isEmpty()) {
	stock = 0;
} else {
	stock = Integer.parseInt(unitsInStock);
}

// 넘어온 파라미터값들을 vo에 저장
ProductVO vo = new ProductVO();
vo.setProductId(productId);
vo.setPname(pname);
vo.setUnitPrice(price);
vo.setDescription(description);
vo.setManufacturer(manufacturer);
vo.setCategory(category);
vo.setUnitsInStock(stock);
vo.setCondition(condition);
vo.setFilename(productId + ".jpeg");

ProductRepository dao = ProductRepository.getInstance();
dao.addProduct(vo);

List<ProductVO> list = dao.getAllProducts();
for(ProductVO product:list){
	out.println(product);
}
response.sendRedirect("products.jsp");
%>