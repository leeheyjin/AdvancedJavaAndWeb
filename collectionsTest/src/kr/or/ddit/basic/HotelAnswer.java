package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HotelAnswer {
	private Map<Integer, RoomAns> hotelMap;
	private Scanner scanner;

	// 생성자
	public HotelAnswer() {
		hotelMap = new HashMap<>();
		scanner = new Scanner(System.in);

		// 객실초기화
		for (int i = 2; i <= 4; i++) {
			String type = null;
			switch (i) {
			case 2:
				type = "싱글룸";
				break;
			case 3:
				type = "더블룸";
				break;
			case 4:
				type = "스위트룸";
				break;
			}
			for (int j = 1; j <= 9; j++) {
				int num = i * 100 + j;
				hotelMap.put(num, new RoomAns(num, type));
			}
		}
	}

	public static void main(String[] args) {
		new HotelAnswer().hotelStart();
	}

	// 시작 메서드
	public void hotelStart() {
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		System.out.println();

		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1: // 체크인
				checkIn();
				break;
			case 2: // 체크아웃
				checkOut();
				break;
			case 3: // 객실 상태
				viewRoom();
				break;

			case 4: // 업무 종료
				System.out.println("*********************************************");
				System.out.println("       호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				System.out.println();
				return;

			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
				break;
			}
		}
	}

	private void viewRoom() {
		// 방번호를 순서대로 나오게 하기 위해서 방번호(Map의 키값)만 List에 넣은 후 정렬해서 사용한다.
		List<Integer> roomNoList = new ArrayList<>(hotelMap.keySet()); // hotelMap의 키값을 Set으로 반환해 ArrayList로 바꾼다
		Collections.sort(roomNoList);

		System.out.println("----------------------------------------------");
		System.out.println("                  현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호\t방 종류\t투숙객 이름");

		// List에서 방번호를 하나씩 꺼내와 Map에서 해당 방번호에 대한 Room 객체를 구해서 출력한다
		for (int num : roomNoList) {
			RoomAns ra = hotelMap.get(num);
			System.out.print(ra.getRoomNum() + "\t" + ra.getRoomType() + "\t");

			String name = "-";
			if (ra.getGuestName() != null) {
				name = ra.getGuestName();
			}

			System.out.println(name);
		}
		System.out.println("----------------------------------------------");
		System.out.println();
	}

	private void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("                  체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃할 방 번호를 입력하세요");
		System.out.print("방 번호 입력 >> ");
		int num = Integer.parseInt(scanner.nextLine());
		if (!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
		} else if (hotelMap.get(num).getGuestName() == null) {
			System.out.println(num + "호의 체크인 내역이 존재하지 않습니다.");
		} else { // 체크아웃 작성 진행 -> 해당 객실의 투숙객 이름을 null로 변경하면 된다.
			// 현재 객실의 손님 이름 구하기
			String name = hotelMap.get(num).getGuestName();
			// 투숙객 이름을 null로 변경하기
			hotelMap.get(num).setGuestName(null);
			System.out.println(num + "호 객실의 " + name + "님의 체크아웃이 완료되었습니다.");
		}
	}

	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("                  체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int num = Integer.parseInt(scanner.nextLine());

		// 입력한 방번호가 있는지 검사하기
		if (!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}

		// 입력한 방번호의 객실에 손님이 이미 있는지 검사
		if (hotelMap.get(num).getGuestName() != null) {
			System.out.println(num + "호 객실에는 이미 손님이 있습니다.");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String name = scanner.nextLine(); // 예약자명

		// 입력 받은 투숙객 이름을 해당 실의 투숙객명단에 저장한다
		hotelMap.get(num).setGuestName(name);
		System.out.println(name + "님이 " + num + "호 객실에 체크인 되었습니다.");
	}

	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println("");
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선  택 >> ");
		return Integer.parseInt(scanner.nextLine());
	}
}

class RoomAns {
	private int roomNum; // 방번호
	private String roomType; // 방종류
	private String guestName; // 투숙객 이름

	public RoomAns(int roomNum, String roomType) {
		this.roomNum = roomNum;
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t\t%s", roomNum, roomType, guestName);
	}
}
