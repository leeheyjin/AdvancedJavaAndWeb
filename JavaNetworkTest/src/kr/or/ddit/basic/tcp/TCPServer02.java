package kr.or.ddit.basic.tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer02 {
	public static void main(String[] args) throws Exception {
		// 서버소켓을 만들고 클라이언트가 접속해오면 소켓을 만들어서 메시지를 받는 스레드와 메시지를 보내는 스레드에 이 소켓을 주입한다
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 준비중입니다");

		Socket socket = server.accept();

		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);

		sender.start();
		receiver.start();
	}

}
