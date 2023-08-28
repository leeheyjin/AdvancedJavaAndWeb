package test.java.test02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class test02 {
	public static void main(String[] args) throws Exception {
		File file = new File("");
		System.out.println(file.getAbsolutePath());

		String path = "src/test/java/test02/Test02.java";
		FileReader fileReader1 = new FileReader(path);
//		FileReader fileReader2 = new FileReader(new File(path));
		char[] ch = new char[100];

		while (true) {
			int read = fileReader1.read(ch);
			if (read == -1) {
				break;
			}
//			System.out.print((char) read);
			String string = new String(ch, 0, read);
			System.out.println(string);
		}

		fileReader1.close();

		BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
		while (true) {
			String readLine = bufferedReader1.readLine();
			if (readLine == null) {
				break;
			}
			System.out.println(readLine);
		}
		bufferedReader1.close();
	}

}
