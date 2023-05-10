package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * UDP: 비연결 지향. 신뢰성 뒤짐. 데이터가 순서대로 도착한다는 보장도 없음. 그렇지만 TCP방식보다 속도가 빠름. DatagramSocket객체와 DatagramPacket객체를 이용해서 통신한다.
 * DatagramSocket: 데이터의 송수신과 관련된 작업을 수행한다(택배기사)
 * DatagramPacket: 주고 받는 데이터와 관련된 작업을 수행한다(택배). 수신용 생성자와 송신용 생성자를 따로 제공한다. 
 * 
 * TCP방식의 경우 스트림객체를 이용해 송수신을 하지만 UDP방식은 데이터그램을 이용해 송수신한다
 * 
 */
public class UDPServer {
	public static void main(String[] args) {
		try {
			// 통신할 포트번호를 지정하여 소켓을 생성한다
			DatagramSocket socket = new DatagramSocket(8888);
			System.out.println("서버 실행 중");

			while (true) {
				// 클라이언트가 보낸 메시지 받기
				// 데이터가 저장될 byte형 배열 선언
				byte[] bMsg = new byte[512];

				// 수신용 패킷 객체 생성: 수신된 데이터가 저장될 byte형 배열, 배열의 길이를 인자로 지정
				DatagramPacket inPacket = new DatagramPacket(bMsg, bMsg.length);

				// receive(): 데이터를 수신하는 메서드. 데이터가 올 때까지 기다리고 수신된 데이터는 수신용 패킷 객체에 저장된다.
				socket.receive(inPacket);

				// 수신받은 패킷을 이용하여 상대방의 ip주소와 port번호를 알 수 있다
				InetAddress address = inPacket.getAddress();
				int port = inPacket.getPort();
				System.out.println("상대방의 IP주소: " + address + ", 상대방의 포트번호: " + port);
				System.out.println();

				// 상대방이 보낸 메시지 출력
				// 상대방이 보낸 데이터는 '수신용패킷객체'의 getData()메서드로 구할 수 있고, 수신용 패킷을 생성할 때 지정한 byte형 배열에
				// 저장된다. 상대방이 보낸 데이터의 크기는 수신용패킷객체의 getLength()메서드로 구할 수 있다.

				// 수신받은 데이터는 byte형 배열이기 때문에 ㅣㅇ것을 문자열로 변환해야 한다
				// 방법1: 패킷객체 생성할 때 사용한 byte형 배열 이용하기
				String msg = new String(bMsg, 0, inPacket.getLength(), "utf-8");
				// 방법2: getData()메서드 이용하기
				String msg2 = new String(inPacket.getData(), 0, inPacket.getLength(), "utf-8");

				if ("/end".equals(msg)) {
					break;
				}

				System.out.println("상대방이 보낸 메시지: " + msg);

				// 상대방에게 메시지 보내기 (수신된 메시지를 그대로 송신하기)
				// 송신할 메시지를 byte형 배열로 변환한다.
				byte[] sendMsg = msg.getBytes("utf-8");

				// 송신용 패킷 객체 생성: 전송할 데이터가 저장된 byte형 배열, 전송할 데이터의 길이, 상대방 주소 정보, 포트번호를 지정해 생성함
				DatagramPacket outPacket = new DatagramPacket(sendMsg, sendMsg.length, address, port);

				// 데이터 송신하기: send()
				socket.send(outPacket);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
