package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyAnswer {
	public static void main(String[] args) {
		File file = new File(
				"/Users/leehyejin/Project/ddit/3.4. AdvancedJavaAndWeb/webpro/src/main/webapp/images/Penguins.jpg");

		if (!file.exists()) {
			System.out.println(file.getPath() + " 파일이 없습니다");
			System.out.println("복사 작업을 중지합니다");
			return;
		}

		try {
			// 원본 파일을 읽어올 스트림 객체 생성
			FileInputStream fIn = new FileInputStream(file);
			BufferedInputStream bIn = new BufferedInputStream(fIn);

			FileOutputStream fOut = new FileOutputStream(
					"/Users/leehyejin/Project/ddit/3.4. AdvancedJavaAndWeb/practice/연습용/PenguinsCopy.jpg");
			BufferedOutputStream bOut = new BufferedOutputStream(fOut);
			int data;
//			while ((data = fIn.read()) != -1) {
//				fOut.write(data);
//			}
//
//			fIn.close();
//			fOut.close();
			while ((data = bIn.read()) != -1) {
				bOut.write(data);
			}

			bIn.close();
			bOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
