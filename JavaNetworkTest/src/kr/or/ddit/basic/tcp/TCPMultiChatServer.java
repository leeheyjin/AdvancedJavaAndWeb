package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TCPMultiChatServer {
	// 접속한 클라이언트 정보를 저장할 Map객체 생성
	// key값: 접속한 사람의 대화명. value값: 접속한 클라이언트의 Socket객체
	private Map<String, Socket> clientMap;

	public TCPMultiChatServer() {
		// clientMap을 동기화처리가 되도록 생성한다
		clientMap = Collections.synchronizedMap(new HashMap<>());
	}

	public static void main(String[] args) {
		new TCPMultiChatServer().serverStart();
	}

	// 서버 시작 메서드
	private void serverStart() {
		ServerSocket server = null;
		Socket socket = null;

		try {
			server = new ServerSocket(7777);
			System.out.println("서버 실행");

			while (true) {
				socket = server.accept();
				System.out.println("[" + socket.getInetAddress() + ": " + socket.getPort() + "]에서 접속했습니다");
				System.out.println();
				ServerReceiver serverThread = new ServerReceiver(socket);
				serverThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// clientMap에 저장된 전체 사용자에게 메시지를 전송하는 메서드
	private void sendToAll(String msg) {
		// clientMap의 데이터 개수만큼 반복
		for (String name : clientMap.keySet()) {
			try {
				// key값과 같이 저장된 Socket객체를 이용하여 출력용 스트림 객체를 생성한다.
				DataOutputStream dout = new DataOutputStream(clientMap.get(name).getOutputStream());
				dout.writeUTF(msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	// 서버에서 클라이언트로 메시지를 전송하는 Thread를 내부 클래스로 작성한다. 이유는 외부 클래스의 멤버들을 자유롭게 사용하려고
	// 그런다(아랏다)
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;

		public ServerReceiver(Socket socket) {
			super();
			this.socket = socket;
			try {
				// 수신용 스트림 객체 생성
				din = new DataInputStream(this.socket.getInputStream());

				// 송신용 스트림 객체 생성
				dout = new DataOutputStream(this.socket.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String name = null; // 대화명이 저장될 변수 선언
			try {
				// 클라이언트와의 연결을 성공하면 첫번째 데이터로 대화명을 입력받아서 서버로 보낸다. 서버에서는 이 대화명을 받아서 중복여부를 판정하여 그
				// 결과를 응답으로 클라이언트에게 보내준다

				// 클라이언트가 보내온 대화명이 중복되지 않을 때까지 반복한다
				while (true) {
					name = din.readUTF();

					if (clientMap.containsKey(name)) {
						dout.writeUTF("이미 존재하는 대화명입니다.");
					} else {
						dout.writeUTF("완.");
						break;
					}
				}

				// 접속한 사람의 대화명을 이용해 이미 접속해있는 다른 클라이언트들에게 대화방 참여 메시지를 보낸다
				sendToAll("[" + name + "]님이 입장하셨습니다.");

				// 대화명과 접속한 클라이언트의 Socket객체를 clientMap에 추가한다
				clientMap.put(name, socket);
				System.out.println("현재 접속자 수: " + clientMap.size() + "명");

				// 한 클라이언트가 보낸 메시지를 받아서 전체 클라이언트에게 보낸다
				while (din != null) {
					sendToAll(din.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				// finally가 실행되면 한 클라이언트가 접속을 종료했다는 의미이다
				sendToAll("[" + name + "]님이 나가셨습니다.");
				System.out.println("[" + socket.getInetAddress() + ": " + socket.getPort() + "]에서 접속을 종료했습니다.");
				clientMap.remove(name);
				System.out.println("현재 접속자수: " + clientMap.size() + "명");
				System.out.println();

			}
		}

	}

}
