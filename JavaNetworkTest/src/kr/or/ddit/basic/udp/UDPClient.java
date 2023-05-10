package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			// 수신 받은 데이터가 저장될 byte형 배열
			byte[] bMsg = new byte[512];

			// 소켓 객체 생성
			DatagramSocket socket = new DatagramSocket();

			// 접속할 주소 정보 생성
			InetAddress address = InetAddress.getByName("localhost");
			while (true) {
				// 전송할 메시지를 입력받는다
				System.out.print("보낼 메시지를 입력하세요 >> ");
				String msg = scanner.nextLine();

				// 전송용 패킷 객체 생성
				DatagramPacket outPacket = new DatagramPacket(msg.getBytes("utf-8"), msg.getBytes("utf-8").length,
						address, 8888);

				socket.send(outPacket);
				if ("/end".equals(msg)) {
					break;
				}

				// 서버가 보내온 메시지 받아서 화면에 출력하기
				// 수신용 패킷 객체 생성
				DatagramPacket inPacket = new DatagramPacket(bMsg, bMsg.length);

				// 데이터 수신
				socket.receive(inPacket);
				System.out.println();
				System.out.println("서버의 응답 메시지: " + new String(bMsg, 0, inPacket.getLength(), "utf-8"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
