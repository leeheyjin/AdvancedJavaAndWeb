package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	private Scanner scanner = new Scanner(System.in);
	private Map<Integer, Room> roomMap = new HashMap<>();;
	private Room room; // 예약자

	public HotelTest() {
		room = new Room(0, null, null);
	}

	public static void main(String[] args) {
		new HotelTest().roomStart();
	}

	private void roomStart() {
		System.out.println("**********************************************");
		System.out.println("         호텔문을 열었습니다. 어서오십시요.");
		System.out.println("**********************************************");
		System.out.println();
		while (true) {
			int menu = displayMenu();
			switch (menu) {
			case 1: // 체크인
				checkIn();
				break;
			case 2: // 체크아웃
				checkOut();
				break;
			case 3: // 객실상태
				showReservation();
				break;
			case 4: // 업무 종료
				System.out.println("**********************************************");
				System.out.println("               호텔문을 닫았습니다.");
				System.out.println("**********************************************");

				return;

			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
				break;
			}

		}
	}

	private int displayMenu() {
		System.out.println("----------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("----------------------------------------------");
		System.out.print("선택 >> ");
		return Integer.parseInt(scanner.nextLine());
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
		try {
			int roomNo = Integer.parseInt(scanner.nextLine()); // 방번호
			if (roomMap.containsKey(roomNo)) {
				System.out.println(roomNo + "호 객실은 이미 손님이 있습니다.");
				return;
			}

			if (!((roomNo >= 201 && roomNo <= 209) || (roomNo >= 301 && roomNo <= 309)
					|| (roomNo >= 401 && roomNo <= 409))) {
				System.out.println(roomNo + "호 객실은 존재하지 않습니다.");
			} else {
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 >> ");
				String name = scanner.nextLine(); // 예약자명

				room.setRoomType(roomNo);
				String roomType = room.getRoomType();
				room = new Room(roomNo, roomType, name);
				roomMap.put(roomNo, room);
				System.out.println("체크인이 완료되었습니다.");
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("다시 입력해주세요.");
			System.out.println();
			return;
		}

	}

	private void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("                  체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃할 방 번호를 입력하세요.");
		System.out.print("방번호 입력 >>");
		int roomNo = Integer.parseInt(scanner.nextLine());
		if (!((roomNo >= 201 && roomNo <= 209) || (roomNo >= 301 && roomNo <= 309)
				|| (roomNo >= 401 && roomNo <= 409))) {
			System.out.println(roomNo + "호 객실은 존재하지 않습니다.");
		} else if (!roomMap.containsKey(roomNo)) { // 예약된 객실번호가 아니라면
			System.out.println(roomNo + "호 객실에는 체크인한 사람이 없습니다.");
		} else {
			System.out.println(roomNo + "호 객실의 " + roomMap.get(roomNo).getCustomerName() + "님 체크아웃을 완료하였습니다.");
			roomMap.remove(roomNo);

		}

		System.out.println();
	}

	// 방이 있으면 예약자 이륾 출력, 없으면 - 출력
	private void showReservation() {
		System.out.println("----------------------------------------------");
		System.out.println("		  현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	           방 종류             투숙객 이름");
		System.out.println("----------------------------------------------");

		Set<Integer> keySet = roomMap.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			Room r = roomMap.get(key);
			System.out.println(room);
		}
	}

}

class Room {
	private int roomNo;
	private String roomType;
	private String customerName;

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(int roomNo, String roomType, String customerName) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.customerName = customerName;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomNo) {
		if (roomNo >= 201 && roomNo <= 209) {
			roomType = "싱글룸";
		} else if (roomNo >= 301 && roomNo <= 309) {
			roomType = "더블룸";
		} else if (roomNo >= 401 && roomNo <= 409) {
			roomType = "스위트룸";
		}
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		if (customerName == null) {
			this.customerName = "-";
		} else {
			this.customerName = customerName;
		}
	}

	@Override
	public String toString() {
		return String.format("%s	            %s	          %s", roomNo, roomType, customerName);
	}

}
