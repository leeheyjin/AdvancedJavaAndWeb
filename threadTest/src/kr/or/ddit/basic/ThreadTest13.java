package kr.or.ddit.basic;

import java.util.Random;

public class ThreadTest13 {
	public static void main(String[] args) {
		Horse horse = new Horse("1번말");
		horse.start();
		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위: " + Horse.getGrade());
	}

}

class Horse extends Thread implements Comparable<Horse> {
	private String horseName;
	private int nowPosition = 0;
	private static int grade;

	public Horse(String horseName) {
		super();
		this.horseName = horseName;
	}

	@Override
	public void run() {
		System.out.print(horseName + " ");
		String track = ">--------------------------------------------------";
		System.out.print(track);
		for (int i = 1; i <= 50; i++) {
			try {
				track.indexOf(nowPosition++);
				Thread.sleep(new Random().nextInt(400));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getNowPosition() {
		return nowPosition;
	}

	public void setNowPosition(int nowPosition) {
		this.nowPosition = nowPosition;
	}

	public static int getGrade() {
		return grade;
	}

	public static void setGrade(int grade) {
		Horse.grade = grade;
	}

	@Override
	public int compareTo(Horse that) {
		return new Integer(this.getGrade()).compareTo(new Integer(that.getGrade()));
	}

}