package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {
	public static void main(String[] args) {
		try {
			// 기반이 되는 스트림 생성: 파일 출력용
			FileOutputStream fileOut = new FileOutputStream(
					"/Users/leehyejin/Project/ddit/3.4. AdvancedJavaAndWeb/practice/연습용/bufferTest.txt");

			// 버퍼의 크기가 5인 buffered스트림 객체 생성
			BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut, 5);

			for (int i = '1'; i <= '9'; i++) {
				bufferOut.write(i);
			}
//			bufferOut.flush(); // 버퍼에 남아 있는 데이터를 모두 출력장치로 출력시킨다
			bufferOut.close(); // 보조 스트림(bufferOut)을 닫으면 보조스트림에서 사용한 기반이 되는 스트림(fileOut)도 자동으로 닫힌다
							   // BufferedOutputStream의 close()에는 flush()도 포함되어 있다

			System.out.println("작업 끝"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
