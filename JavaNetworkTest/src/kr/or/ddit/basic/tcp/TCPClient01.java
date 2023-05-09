package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient01 {
	public static void main(String[] args) throws IOException {
		/*
		 * 현재 자신의 컴퓨터를 나타내는 방법 1. 원래 ip주소 2. 지정된 ip주소: 127.0.0.1 3. 원래 컴퓨터 이름 4. 지정된 컴퓨터
		 * 이름: localhost
		 */

		// 연결할 서버의 정보를 이용해 Socket객체를 생성한다. 서버의 ip주소와 포트번호를 지정한다. Socket객체는 생성이 완료되면 해당
		// 서버로 연결 요청 신호를 보낸다.
		Socket socket = new Socket("localhost", 7777);

		// 이 Socket객체를 생성하는 명령 이후는 서버와 연결이 완료된 후 처리할 내용을 기술하면 된다
		System.out.println("서버에 연결되었습니다");

		// 상대방이 보낸 메시지 받기
		// 상대방이 보낸 메시지를 받는다는 의미는 Socket으로 입력을 받는다는 뜻이다
		// Socket의 InputStream객체를 이용하는데 이것은 getInputStream()메서드로 구할 수 있다
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);

		// 상대방이 보낸 메시지를 받아서 화면ㅇ ㅔ출력하기
		System.out.println("서버에서 보낸 메시지: " + din.readUTF());
		System.out.println();
		System.out.println("연결을 종료합니다");

		din.close();
		socket.close();
	}
}
