<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%
// 폼페이지에서 전송된 파일을 저장할 서버의 경로를 작성
String uploadPath = request.getContextPath() + "/upload";
// commons-fileupload 라이브러리 패키지에 포함되어 있는 DiskFileUpload의 인스턴스를 생성
DiskFileUpload upload = new DiskFileUpload();
// 웹브라우저가 전송한 multipart/form유형의 요청 파라미터들을 가져옴
List items = upload.parseRequest(request);
Iterator params = items.iterator();
while (params.hasNext()) {
	FileItem fileItem = (FileItem) params.next();
	// FileItem클래스의 메서드를 사용해 요청 파라미터가 일반 데이터인지(true) 파일인지(false) 분석 및 처리하여 파일을 업로드함
	if(!fileItem.isFormField()) {
		String fileName = fileItem.getName();
		fileName.substring(fileName.lastIndexOf("/") + 1);
		File file = new File(uploadPath + "/" + fileName);
		fileItem.write(file);
	}
	
}
%>