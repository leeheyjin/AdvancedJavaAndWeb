package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/*
 * 특정 폴더에 있는 '펭귄.jpg'파일을 연습용 폴더에 '펭귄_복사본.jpg' 파일로 복사하기
 */
public class FileCopy {
	public static void main(String[] args) {
		try {
			FileInputStream in = new FileInputStream(
					"/Users/leehyejin/Project/ddit/3.4. AdvancedJavaAndWeb/webpro/src/main/webapp/images/Penguins.jpg");
			FileOutputStream out = new FileOutputStream(
					"/Users/leehyejin/Project/ddit/3.4. AdvancedJavaAndWeb/practice/연습용/펭귄_복사본.jpg");

			int data = 0;
			while ((data = in.read()) != -1) {
				out.write(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
