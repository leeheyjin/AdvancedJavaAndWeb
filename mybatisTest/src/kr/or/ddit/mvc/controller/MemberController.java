package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberService;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {
	private IMemberService service;
	private Scanner scanner;

	public MemberController() {
		service = MemberService.getInstance();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		MemberController mController = new MemberController();
		mController.memberStart();
	}

	private void memberStart() {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 추가
				insert();
				break;
			case 2: // 삭제
				delete();
				break;
			case 3:
				updateAll();
				break;
			case 4:
				updateOne();
				break;
			case 5:
				displayAll();
				break;
			case 0:
				System.out.println("작업을 마칩니다");
				return;

			default:
				System.out.println("작업 번호를 잘못 입력했습니다. 다시 입력해주세요.");
				break;
			}
		}

	}

	private void insert() {
		System.out.println("--------------------------");
		System.out.println("추가할 회원 정보를 입력하세요");
		String memId = "";

		int count = 0;
		do {
			System.out.print("회원ID >> ");
			memId = scanner.nextLine();
			
			count = service.getMemberCount(memId);
			if (count > 0) {
				System.out.println(memId + "는 이미 등록된 회원ID입니다.");
				System.out.println("다른 회원 ID를 입력하세요");
			}
		} while (count > 0);

		System.out.print("비밀번호 >> ");
		String memPass = scanner.nextLine();
		System.out.print("이름 >> ");
		String memName = scanner.nextLine();
		System.out.print("전화번호 >> ");
		String memTel = scanner.nextLine();
		System.out.print("주소 >> ");
		String memAddr = scanner.nextLine();

		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);

		int num = service.insertMember(memVo);
		if (num > 0) {
			System.out.println("회원 정보 추가 완료");
		} else {
			System.out.println("회원 정보 추가 실패");
		}
	}

	private void delete() {
		System.out.println("--------------------------");
		System.out.println("삭제할 회원 정보를 입력하세요");
		System.out.print("회원ID >> ");
		String memId = scanner.nextLine();

		int num = service.deleteMember(memId);
		if (num > 0) {
			System.out.println("회원 정보 삭제 완료");
		} else {
			System.out.println("회원 정보 삭제 실패");
		}

	}

	private void updateAll() {
		System.out.println("--------------------------");
		System.out.println("수정할 회원 정보를 입력하세요");
		System.out.print("회원ID >> ");
		String memId = scanner.nextLine();
		int count = service.getMemberCount(memId);
		if (count == 0) {
			System.out.println(memId + "는 없는 회원ID 입니다");
			System.out.println("수정 작업을 종료합니다");
			return;
		}

		System.out.print("새로운 비밀번호 >> ");
		String newMemPass = scanner.nextLine();
		System.out.print("새로운 이름 >> ");
		String newMemName = scanner.nextLine();
		System.out.print("새로운 전화번호 >> ");
		String newMemTel = scanner.nextLine();
		System.out.print("새로운 주소 >> ");
		String newMemAddr = scanner.nextLine();

		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(newMemPass);
		memVo.setMem_name(newMemName);
		memVo.setMem_tel(newMemTel);
		memVo.setMem_addr(newMemAddr);

		int num = service.updateAllInfo(memVo);
		if (num > 0) {
			System.out.println("회원 정보 수정 완료");
		} else {
			System.out.println("회원 정보 수정 실패");
		}
	}

//	private void updateOne() {
//		System.out.println("--------------------------");
//		System.out.println("수정할 회원 정보를 입력하세요");
//		System.out.print("회원ID >> ");
//		String memId = scanner.nextLine();
//		int count = service.getMemberCount(memId);
//		if (count == 0) {
//			System.out.println(memId + "는 없는 회원ID 입니다");
//			System.out.println("수정 작업을 종료합니다");
//			return;
//		}
//
//		int choice; // 수정을 원하는 항목의 선택 번호가 저장될 변수
//		String updateField = null; // 수정할 컬럼명이 저장될 변수
//		String updateTitle = null; // 입력할 때 보여줄 제목
//
//		do {
//			System.out.println("수정할 항목을 선택하세요");
//			System.out.println("1. 비밀번호\t2. 회원이름\t3. 전화번호\t4. 회원주소");
//			System.out.print("수정할 항목 선택 >> ");
//			choice = Integer.parseInt(scanner.nextLine());
//
//			switch (choice) {
//			case 1:
//				updateField = "MEM_PASS";
//				updateTitle = "비밀번호";
//				break;
//			case 2:
//				updateField = "MEM_NAME";
//				updateTitle = "회원이름";
//				break;
//			case 3:
//				updateField = "MEM_TEL";
//				updateTitle = "전화번호";
//				break;
//			case 4:
//				updateField = "MEM_ADDR";
//				updateTitle = "회원주소";
//
//				break;
//
//			default:
//				System.out.println("잘못된 입력입니다. 다시 선택하세요 ");
//				break;
//			}
//		} while (choice < 1 || choice > 4);
//
//		System.out.println();
//		System.out.println("수정할 " + updateTitle + " >> ");
//		String updateData = scanner.nextLine(); // 수정할 데이터 입력
//
//		int num = service.updateOneInfo(memId, updateField, updateData);
//		if (num > 0) {
//			System.out.println("회원 정보 수정 완료");
//		} else {
//			System.out.println("회원 정보 수정 실패");
//		}
//	}

	// 쌤답
	private void updateOne() {
		System.out.println("--------------------------");
		System.out.println("수정할 회원 정보를 입력하세요");
		System.out.print("회원ID >> ");
		String memId = scanner.nextLine();
		int count = service.getMemberCount(memId);
		if (count == 0) {
			System.out.println(memId + "는 없는 회원ID 입니다");
			System.out.println("수정 작업을 종료합니다");
			return;
		}

		int choice; // 수정을 원하는 항목의 선택 번호가 저장될 변수
		String updateField = null; // 수정할 컬럼명이 저장될 변수
		String updateTitle = null; // 입력할 때 보여줄 제목

		do {
			System.out.println("수정할 항목을 선택하세요");
			System.out.println("1. 비밀번호\t2. 회원이름\t3. 전화번호\t4. 회원주소");
			System.out.print("수정할 항목 선택 >> ");
			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				updateField = "MEM_PASS";
				updateTitle = "비밀번호";
				break;
			case 2:
				updateField = "MEM_NAME";
				updateTitle = "회원이름";
				break;
			case 3:
				updateField = "MEM_TEL";
				updateTitle = "전화번호";
				break;
			case 4:
				updateField = "MEM_ADDR";
				updateTitle = "회원주소";

				break;

			default:
				System.out.println("잘못된 입력입니다. 다시 선택하세요 ");
				break;
			}
		} while (choice < 1 || choice > 4);

		System.out.print("수정할 " + updateTitle + " >> ");
		String updateData = scanner.nextLine(); // 수정할 데이터 입력

		Map<String, String> updateMap = new HashMap<>();
		updateMap.put("field", updateField);
		updateMap.put("data", updateData);
		updateMap.put("mem_id", memId);
		int num = service.updateMember2(updateMap);
		if (num > 0) {
			System.out.println(updateTitle + " 정보 수정 완료");
		} else {
			System.out.println(updateTitle + " 정보 수정 실패");
		}
	}

	private void displayAll() {
		System.out.println("----------------------------------------------------");
		System.out.println("ID   비밀번호    이름      전화번호      주소    ");
		System.out.println("----------------------------------------------------");

		List<MemberVO> allMember = service.getAllMember();
		if (allMember == null || allMember.size() == 0) {
			System.out.println("등록된 회원이 없습니다");
		} else {
			for (MemberVO memberVO : allMember) {
				System.out.println(memberVO);
			}
		}
	}

	private int displayMenu() {
		System.out.println("--------------------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 전체 자료 수정");
		System.out.println("4. 일부 자료 수정");
		System.out.println("5. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println();
		System.out.print("메뉴를 선택하세요 >> ");
		return Integer.parseInt(scanner.nextLine());
	}

}
