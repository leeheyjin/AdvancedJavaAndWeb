<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%
String uploadPath = "/Users/leehyejin/Project/ddit/ddit/JSPBook/WebContent/upload";
DiskFileUpload upload = new DiskFileUpload();
upload.setSizeMax(1000000);
upload.setSizeThreshold(4096);
upload.setRepositoryPath(uploadPath);

List items = upload.parseRequest(request);
Iterator params = items.iterator();
while (params.hasNext()) {
	FileItem item = (FileItem) params.next();
	// isFormField(): 요청 파라미터가 일반 데이터인지(true), 파일인지(false) 구분
	if (item.isFormField()) {
		String attributeName = item.getFieldName(); // input type이 file이 아닌 폼필드의 name속성
		String value = item.getString("utf-8");
		out.print("<p>" + attributeName + ": " + value + "</p>");
	} else {
		String attributeName = item.getFieldName(); // input type이 file인 폼필드의 name속성
		String fileName = item.getName(); // 전송된 파일의 이름

		File file = new File(uploadPath + "/" + fileName);
		item.write(file);
		out.print(
				"<p>요청 파라미터 이름: " + attributeName + 
				"<br>저장 파일 이름: " + fileName + 
				"<br>파일 컨텐츠 타입: " + item.getContentType() + 
				"<br>파일 크기: " + item.getSize() + "</p>"
				 );
	}

}
%>