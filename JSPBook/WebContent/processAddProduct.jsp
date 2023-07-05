<%@page import="java.util.jar.Attributes.Name"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductRepository"%>
<%@page import="vo.ProductVO"%>
<%
request.setCharacterEncoding("utf-8");

String uploadPath = "/Users/leehyejin/Project/ddit/ddit/JSPBook/WebContent/images";
DiskFileUpload upload = new DiskFileUpload();
upload.setSizeMax(1000000);
upload.setSizeThreshold(4096);
upload.setRepositoryPath(uploadPath);
List items = upload.parseRequest(request);
Iterator params = items.iterator();

String productId = "";
String pname = "";
String unitPrice = "";
String description = "";
String manufacturer = "";
String category = "";
String unitsInStock = "";
String condition = "";
String filename = "";

// 폼페이지에서 상품 가격이 입력되지 않은 경우 0으로, 입력된 경우 int로 변경
int price = 0;
// 폼페이지에서 상품 재고수가 입력되지 않은 경우 0으로 입력된 경우 int로 변경
int stock = 0;

while (params.hasNext()) {
	FileItem item = (FileItem) params.next();
	// isFormField(): 요청 파라미터가 일반 데이터인지(true), 파일인지(false) 구분
	if (item.isFormField()) {
		String attributeName = item.getFieldName(); // input type이 file이 아닌 폼필드의 name속성
		if(attributeName.equals("productId")) {
			productId = item.getString("utf-8");
		}
		if(attributeName.equals("pname")) {
			pname = item.getString("utf-8");
		}
		if(attributeName.equals("unitPrice")) {
			price = Integer.parseInt(item.getString("utf-8"));
		}
		if(attributeName.equals("description")) {
			description
			= item.getString("utf-8");
		}
		if(attributeName.equals("productId")) {
			productId = item.getString("utf-8");
		}
		if(attributeName.equals("productId")) {
			productId = item.getString("utf-8");
		}
		if(attributeName.equals("productId")) {
			productId = item.getString("utf-8");
		}
		if(attributeName.equals("productId")) {
			productId = item.getString("utf-8");
		}
	} else {
		String attributeName = item.getFieldName(); // input type이 file인 폼필드의 name속성
		String fileName = item.getName(); // 전송된 파일의 이름

		File file = new File(uploadPath + "/" + fileName);
		item.write(file);
	}

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

vo.setFilename(filename);

ProductRepository dao = ProductRepository.getInstance();
dao.addProduct(vo);

List<ProductVO> list = dao.getAllProducts();
for (ProductVO product : list) {
	out.println(product);
}
response.sendRedirect("products.jsp");
%>