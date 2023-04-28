package kr.or.ddit.basic;

import java.util.Random;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import javax.swing.JOptionPane;

public class ThreadTest07Answer {
	public static boolean inputCheck = false;

	public static void main(String[] args) {
		GameCount counter = new GameCount();
		String[] data = { "가위", "바위", "보" };

		Random random = new Random();
		int index = random.nextInt(3);
		String com = data[index];

		counter.start();
		String woman = null;
		do {
			woman = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
		} while (!"가위".equals(woman) && !"바위".equals(woman) && !"보".equals(woman));

		inputCheck = false;

		String result = "";
//		if (com.equals(woman)) {
//			result = "무승부입니다.";
//		} else if ((com.equals("가위") && woman.equals("보")) || (com.equals("바위") && woman.equals("가위"))
//				|| (com.equals("보") && woman.equals("바위"))) { // 컴퓨터 승리
//			result = "컴퓨터가 이겼습니다";
//		} else if ((com.equals("가위") && woman.equals("바위")) || (com.equals("바위") && woman.equals("보"))
//				|| (com.equals("보") && woman.equals("가위"))) { // 사용자 승리
//			result = "당신이 이겼습니다";
//		} else {
//			System.out.println("잘못된 입력입니다.");
//			result = null;
//		}

		switch (woman + com) {
		case "가위가위":
		case "바위바위":
		case "보보":
			result = "비겼습니다.";
			break;
		case "가위바위":
		case "바위보":
		case "보가위":
			result = "컴퓨터가 이겼습니다.";
			break;

		default:
			result = "당신이 이겼습니다.";
			break;
		}
		System.out.println("-- 결 과 --");
		System.out.println("컴퓨터: " + com);
		System.out.println("사용자: " + woman);
		System.out.println("결 과: " + result);
	}

}

class GameCount extends Thread {
	@Override
	public void run() {
		System.out.println("카운트다운 시작");
		for (int i = 10; i >= 1; i--) {
			if (ThreadTest07Answer.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("-- 결 과 --");
		System.out.println("시간 초과로 당신이 졌습니다");
		System.exit(0);
	}
}
