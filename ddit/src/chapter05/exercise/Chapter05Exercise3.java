package codingTest;

import java.util.Random;
import java.util.Scanner;

public class Chapter05Exercise3 {
	public static void main(String[] args) {
		System.out.print("���� ���� ���� �Է��ϼ���: ");

		Scanner scanner = new Scanner(System.in);
		String gamer = scanner.nextLine();
		System.out.println("���̸�: " + gamer);
		
		String[] ai = { "����", "����", "��" };
		String aiPick = ai[new Random().nextInt(3)];
		System.out.print("�ΰ����� ��ǻ��: " + aiPick);

		if(gamer.equals(aiPick)) {
			System.out.println("���: ���º�" );
		} else if (gamer.equals("����")) {
			if (aiPick.equals("����")) {
				System.out.println("�ΰ����� �¸�!");
			} else if (aiPick.equals("��")) {
				System.out.println("���̸� �¸�!");
			}
		} else if (gamer.equals("����")) {
			if (aiPick.equals("��")) {
				System.out.println("�ΰ����� �¸�!");
			} else if (aiPick.equals("����")) {
				System.out.println("���̸� �¸�!");
			}
		} else if (gamer.equals("��")) {
			if (aiPick.equals("����")) {
				System.out.println("�ΰ����� �¸�!");
			} else if (aiPick.equals("����")) {
				System.out.println("���̸� �¸�!");
			}
		}
		scanner.close();
	}

}
