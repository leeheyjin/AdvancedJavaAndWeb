package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.compiler.ast.NewExpr;

import com.google.gson.Gson;

import kr.or.ddit.basic.vo.SampleVO;

@WebServlet("/jsonDataTest.do")
public class JsonDataTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8"); // response데이터: json

		String choice = request.getParameter("choice");
		Gson gson = new Gson();
		String jsonData = null;
		switch (choice) {
		case "string":
			String string = "안녕하세요"; // 응답으로 보낼 데이터
			jsonData = gson.toJson(string); // 응답 데이터를 JSON구조의 문자열로 반환
			break;
		case "array":
			int[] arr = { 10, 20, 30, 40, 50, 60 };
			jsonData = gson.toJson(arr);
			break;
		case "object":
			SampleVO vo = new SampleVO(1, "홍길동");
			jsonData = gson.toJson(vo);
			break;
		case "list":
			List<SampleVO> list = new ArrayList<>();
			list.add(new SampleVO(1, "홍길동"));
			list.add(new SampleVO(2, "최고다"));
			list.add(new SampleVO(3, "이순신"));
			list.add(new SampleVO(4, "아버지가"));
			list.add(new SampleVO(5, "이상해"));
			list.add(new SampleVO(6, "왔다"));
			list.add(new SampleVO(7, "장보리"));
			jsonData = gson.toJson(list);
			break;
		case "map":
			Map<String, String> map = new HashMap<>();
			map.put("name", "홍길동");
			map.put("tel", "010-1111-1111");
			map.put("addr", "오류동");
			jsonData = gson.toJson(map);
			break;
		}
		System.out.println("JSON으로 변환된 문자열: " + jsonData);
		PrintWriter writer = response.getWriter();
		writer.write(jsonData);
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
