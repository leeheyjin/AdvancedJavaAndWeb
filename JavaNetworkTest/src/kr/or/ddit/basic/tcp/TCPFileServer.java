package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer {
	public static void main(String[] args) throws Exception {
		File saveDir = new File("./src/uploadFiles");
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}

		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 준비 완");

			Socket socket = server.accept();
			System.out.println("파일 다운로드 시작");

			// 클라이언트가 보낸 파일명 데이터를 받는다
			DataInputStream din = new DataInputStream(socket.getInputStream());
			String fileName = din.readUTF();

			// 저장할 폴더와 클라이언트가 보낸 파일명을 지정하여 File객체 생성
			File saveFile = new File(saveDir, fileName);

			// 소켓으로 읽어서 파일로 저장하기
			// 데이터를 입출력할 스트림 객체 생성
			BufferedInputStream bin = new BufferedInputStream(din);
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(saveFile));

			// 소켓으로 읽어온 데이터를 파일로 저장하기
			byte[] temp = new byte[1024];
			int length = 0;
			while ((length = bin.read(temp)) > 0) {
				bout.write(temp, 0, length);
			}
			bout.flush();
			System.out.println("파일 송신 완료");

			bout.close();
			bin.close();
			socket.close();
			server.close();
		} catch (Exception e) {
			System.out.println("파일 다운로드 실패");
		}
	}

}
