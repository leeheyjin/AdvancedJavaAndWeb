package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	public static void main(String[] args) {
		Thread thread1 = new DataInput();
		Thread thread2 = new CountDown();

		thread1.start();
		thread2.start();

	}

}

// 데이터를 입력받는 스레드
class DataInput extends Thread {
	// 입력 여부를 확인하기 위한 변수 선언. 스레드에서 공통으로 사용할 변수. 입력이 완료되면 true가 된다
	public static boolean inputCheck = false;

	@Override
	public void run() {
		String string = JOptionPane.showInputDialog("아무거나 입력하세요");

		inputCheck = true; // 입력이 완료되면 true로 변경

		System.out.println("입력한 값: " + string);

	}
}

// 카운트 다운을 진행하는 스레드
class CountDown extends Thread {
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			// 입력이 완료 여부 검사 후 입력이 완료되면 스레드를 멈춘다
			if (RockScissorsPapaer.inputCheck) {
				return; // run()이 종료되면 스레드도 종료된다.
			}

			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

		System.out.println("-- 결과 --");
		System.out.println("시간 초과로 당신이 졌습니다");
		System.exit(0);
	}
}