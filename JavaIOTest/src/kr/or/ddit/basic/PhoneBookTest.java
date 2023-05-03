package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/*
 * 추가조건
 * 1. '6. 전화번호 저장' 메뉴를 추가하고 구현한다.(파일명: phoneData.dat)
 * 2. 프로그램이 시작될 때 저장된 파일이 있으면 그 파일의 데이터를 읽어와 Map에 세팅한다.
 * 3. 프로그램이 종료될 때 Map의 데이터가 변경(추가, 수정, 삭제)되었으면 저장 후 종료되도록 한다. 
 */
public class PhoneBookTest {
	private Scanner scanner = new Scanner(System.in);
	private Map<String, Phone> phoneMap = new HashMap<>();

	public static void main(String[] args) {
		PhoneBookTest phoneBook = new PhoneBookTest();
		phoneBook.start();

	}

	private void start() {
		File file = new File("./src/phoneData.dat");
		if (file.exists()) {
			try {
				DataInputStream dataIn = new DataInputStream(new FileInputStream("./src/phoneData.dat"));
				String readData = dataIn.readUTF();
				String[] phones = readData.split(",");
				for (String oneOfPhones : phones) {
					String[] person = oneOfPhones.split(" ");
					for (int i = 0; i < person.length; i++) {
						System.out.println(person[i].toString());
					}
					String name = person[0];
					String telNo = person[1];
					String address = person[2];
					phoneMap.put(name, new Phone(name, address, telNo));
				}
				dataIn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				insertPhoneNo();
				break;

			case 2:
				updatePhoneNo();
				break;

			case 3:
				deletePhoneNo();
				break;

			case 4:
				selectPhoneNo();
				break;

			case 5:
				selectAllPhoneNo();
				break;

			case 6:
				saveAllPhoneNo();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다");
				return;

			default:
				System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	private void saveAllPhoneNo() {
		System.out.println("전화번호 목록을 저장합니다");
		try {
			FileOutputStream fileOut = new FileOutputStream("./src/phoneData.dat");
			DataOutputStream dataOut = new DataOutputStream(fileOut);
			dataOut.writeUTF(phoneMap.toString());
			dataOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertPhoneNo() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scanner.nextLine();
		if (phoneMap.containsKey(name)) {
			System.out.println("'" + name + "'은 이미 등록된 사람입니다.");
			return;
		}
		System.out.print("전화번호 >> ");
		String telNo = scanner.nextLine();
		System.out.print("주소 >> ");
		String address = scanner.nextLine();
		System.out.println("'" + name + "' 전화번호 등록 완료");
		phoneMap.put(name, new Phone(name, address, telNo));
	}

	private void updatePhoneNo() {
		while (true) {
			System.out.println("수정할 전화번호의 소유자 이름을 선택하세요");
			System.out.print("이름 >> ");
			String name = scanner.nextLine();
			if (!phoneMap.containsKey(name)) {
				System.out.println("해당 이름이 존재하지 않습니다.");
				break;
			} else {
				if (phoneMap.containsKey(name)) {
					System.out.println(phoneMap.toString().substring(10));
				}
				System.out.println("수정할 항목을 선택하세요");
				System.out.println("1. 이름 | 2. 전화번호 | 3. 주소");
				System.out.print("선택 >> ");
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
				case 1:
					System.out.println("수정할 이름을 입력하세요");
					System.out.print("이름 >> ");
					String changeName = scanner.nextLine();
					if (phoneMap.containsKey(changeName)) {
						System.out.println("이미 존재하는 이름이라 바꿀 수 없습니다. 다른 이름을 입력해주세요.");
					} else {
						phoneMap.get(name).setName(changeName);
						System.out.println("이름 수정이 완료되었습니다.");
					}
					return;
				case 2:
					System.out.println("수정할 전화번호를 입력하세요");
					System.out.println("전화번호 >> ");
					String changeTelNo = scanner.nextLine();

					phoneMap.get(name).setTelNo(changeTelNo);
					System.out.println("전화번호 수정이 완료되었습니다.");
					return;
				case 3:
					System.out.println("수정할 주소를 입력하세요");
					System.out.print("주소 >> ");
					String changeAddress = scanner.nextLine();
					phoneMap.get(name).setAddress(changeAddress);
					System.out.println("주소 수정이 완료되었습니다.");
					return;

				default:
					System.out.println("잘못된 입력입니다. 다시 입력해주세요");
					break;
				}

			}

		}
	}

	private void deletePhoneNo() {
		System.out.println("삭제할 전화번호의 소유자 이름을 입력하세요.");
		System.out.print("이름 >> ");
		String name = scanner.nextLine();
		if (phoneMap.containsKey(name)) {
			phoneMap.remove(name);
		}
		System.out.println("해당 소유자의 전화번호 삭제가 완료되었습니다.");
	}

	private void selectPhoneNo() {
		System.out.println("검색할 전화번호의 소유자 이름을 입력하세요");
		System.out.print("이름 >> ");
		String name = scanner.nextLine();
		if (phoneMap.containsKey(name)) {
			System.out.println("-----------------------------------------------");
			System.out.println("이름         전화번호            주소");
			System.out.println("-----------------------------------------------");
			Phone value = phoneMap.get(name);
			System.out.println(value);
		} else {
			System.out.println("해당 이름의 정보가 존재하지 않습니다.");
		}
	}

	private void selectAllPhoneNo() {
		System.out.println("-----------------------------------------------");
		System.out.println("번호     이름         전화번호            주소");
		System.out.println("-----------------------------------------------");
		Set<String> keySet = phoneMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		int i = 1;
		while (iterator.hasNext()) {
			String key = iterator.next();
			Phone value = phoneMap.get(key);
			System.out.print(i + "     ");
			System.out.println(value);
			i++;
		}
	}

	private int displayMenu() {
		System.out.println("      메  뉴      ");
		System.out.println("=================");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("6. 전화번호 저장");
		System.out.println("0. 프로그램 종료");
		System.out.println("=================");
		System.out.print("번호 입력: ");
		return Integer.parseInt(scanner.nextLine());
	}

}

class Phone {
	private String name;
	private String address;
	private String telNo;

	public Phone(String name, String address, String telNo) {
		super();
		this.name = name;
		this.address = address;
		this.telNo = telNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", name, telNo, address);
	}
}