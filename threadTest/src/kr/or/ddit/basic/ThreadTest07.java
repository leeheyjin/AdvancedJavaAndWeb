package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오
 * 컴퓨터의 가위 바위 보는 난수를 이용해 구하고 사용자의 입력은 showInputDialog()를 이용해서 입력받는다
 * 입력시간은 5초로 제한하고 카운트 다운을 진행한다 5초 안에 입력이 없으면 게임에 진 것으로 처리한다
 * 5초 안에 입력이 완료되면 승패를 구해서 결과를 출력한다
 * 
 * 결과예시1 5초 안에 입력을 못했을 경우:
 * -- 결 과 --
 * 시간 초과로 당신이 졌습니다
 * 
 * 결과예시2 5초 안에 입력이 완료됐을 경우: 
 * -- 결 과 --
 * 컴퓨터: 가위
 * 사용자: 바위
 * 결 과: 당신이 이겼습니다
 */

public class ThreadTest07 {

	public static void main(String[] args) {
		Thread thread1 = new RockScissorsPapaer();
		Thread thread2 = new CountDown();
		thread1.start();
		thread2.start();

	}

}

class RockScissorsPapaer extends Thread {
	public static boolean inputCheck = false;

	@Override
	public void run() {
		String[] rockScissorsPaper = { "가위", "바위", "보" };
		int index = new Random().nextInt(3);
		String com = rockScissorsPaper[index];
		String result = "";
		String user = JOptionPane.showInputDialog("가위 바위 보 중 하나를 입력하세요.");

		inputCheck = true;

		if (com.equals(user)) {
			result = "무승부입니다.";
		} else if ((com.equals(rockScissorsPaper[0]) && user.equals("보"))
				|| (com.equals(rockScissorsPaper[1]) && user.equals("가위"))
				|| (com.equals(rockScissorsPaper[2]) && user.equals("바위"))) { // 컴퓨터 승리
			result = "컴퓨터가 이겼습니다";
		} else if ((com.equals(rockScissorsPaper[0]) && user.equals("바위"))
				|| (com.equals(rockScissorsPaper[1]) && user.equals("보"))
				|| (com.equals(rockScissorsPaper[2]) && user.equals("가위"))) { // 사용자 승리
			result = "당신이 이겼습니다";
		}

		System.out.println("-- 결 과 --");
		System.out.println("컴퓨터: " + com);
		System.out.println("사용자: " + user);
		System.out.println("결 과: " + result);
	}
}