package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPMultiChatClient {
	public static void main(String[] args) {
		new TCPMultiChatClient().clientStart();
	}

	private void clientStart() {
		try {
			Socket socket = new Socket("192.168.142.26", 7777);
			System.out.println("서버 연결 완");

			// 메시지 전송용 스레드 객체와 수신용 스레드 객체를 생성하고 실행한다
			ClientSender sender = new ClientSender(socket);
			ClientReceiver receiver = new ClientReceiver(socket);

			sender.start();
			receiver.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 메시지 전송용 스레드
	class ClientSender extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;

		private String name;
		private Scanner scanner;

		public ClientSender(Socket socket) {
			this.socket = socket;
			scanner = new Scanner(System.in);

			try {
				din = new DataInputStream(this.socket.getInputStream()); // 수신용
				dout = new DataOutputStream(this.socket.getOutputStream()); // 송신용

				if (dout != null) {
					// 클라이언트용 프로그램은 처음 실행하면 서버에 접속하고 접속에 성공하면 첫번째로 대화명을 입력받아 전송하고 대홤여의 중복여부를 받아서
					// 확인한다

					// 대화명이 중복되지 않ㅇ르 때까지 반복
					while (true) {
						System.out.print("대화명 입력 >> ");
						String name = scanner.nextLine();

						dout.writeUTF(name); // 입력받은 대화명을 서버로 전송한다

						String feedback = din.readUTF(); // 대화명의 중복여부를 응답으로 받는다

						if ("대화명중복".equals(feedback)) {
							System.out.println("[" + name + "]은 이미 존재하는 대화명입니다\n다른 대화명을 입력하세요");
						} else {
							this.name = name;
							System.out.println("[" + name + "] 대화명으로 입장하셨습니다.");
							break;
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (dout != null) {
					// 키보드로 입력한 메시지를 서버로 보낸다
					dout.writeUTF("[" + name + "]: " + scanner.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	// 메시지 수신용 스레드
	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;

		/**
		 * @param socket
		 */
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				din = new DataInputStream(this.socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (din != null) {
					// 서버로부터 받은 메시지를 화면에 출력한다
					System.out.println(din.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
