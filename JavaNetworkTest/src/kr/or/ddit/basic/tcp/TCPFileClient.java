package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class TCPFileClient {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		File file = new File("./src/Penguins.jpg");
		if (!file.exists()) {
			System.out.println(file.getPath() + " 이름의 파일이 없습니다");
			return;
		}

		String fileName = file.getName();

		try {
			Socket socket = new Socket("localhost", 7777);
			System.out.println("파일 전송 시작");

			// 처음에는 파일명을 문자열로 전송한다
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(fileName);

			// 파일 내용을 읽어서 소켓으로 전송한다
			// 파일 읽기용 스트림 객체 생성
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));

			// 소켓 출력용 스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(dout);

			byte[] temp = new byte[1024];
			int length = 0;
			while ((length = bin.read(temp)) > 0) {
				bout.write(temp, 0, length);
			}
			bout.flush();
			System.out.println("파일 전송 완료");

			bout.close();
			bin.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("파일 전송 실패");
		}
	}
}