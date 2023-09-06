package com.shinhan.day07;

import java.util.Scanner;

public class BankApplication {
	private static Account[] account_arr = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	static int idx = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			menu();
			int select = scanner.nextInt();
			switch (select) {
			case 1: {
				account_create();
				break;
			}
			case 2: {
				account_list();
				break;
			}
			case 3: {
				deposit();
				break;
			}
			case 4: {
				withdraw();
				break;
			}
			case 5: {
				System.out.println("----- 프로그램 종료 -----");
				run = false; // 라벨 대신 boolean 변수 사용
				break;
			}
			default: {
				System.out.println("잘못된 번호를 선택하셨습니다. 다시 선택해주세요.");
				break;
			}
			}// switch end

		} // while end

	} // main end

	private static void menu() {
		System.out.println("-----------------------------------------------");
		System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
		System.out.println("-----------------------------------------------");
		System.out.print("선택 > ");
	}

	// 계좌 생성
	private static void account_create() {
		System.out.println("------------");
		System.out.println("계좌 생성");
		System.out.println("------------");
		System.out.print("계좌번호 : ");
		String account_number = scanner.next();
		System.out.print("계좌주 : ");
		String account_owner = scanner.next();
		System.out.print("초기 입금액 : ");
		int first_balance = scanner.nextInt();
		if (idx == 0) {
			account_arr[idx] = new Account(account_number, account_owner, first_balance);
			System.out.println("결과: 계좌가 생성되었습니다.");
			idx++;
		}

		// 입력받은 계좌번호 있는지 확인 idx 1부터
		else {
			for (int i = 0; i <= idx; i++) {
				if (account_number.equals(account_arr[i])) {
					System.out.println("이미 있는 계좌입니다. 다시 입력하세요.");
					break;
				} else {
					account_arr[idx] = new Account(account_number, account_owner, first_balance);
					System.out.println("결과: 계좌가 생성되었습니다.");
					idx++;
					break;
				}

			} // for end
		}
	} // account create end

	// 계좌 목록
	private static void account_list() {
		System.out.println("------------");
		System.out.println("계좌 목록");
		System.out.println("------------");

		for (Account acc : account_arr) {
			if (acc == null) {
				break;
			}
			System.out.printf("%s\t %s\t %d\n", acc.getAccount_number(), acc.getAccount_owner(), acc.getBalance());
		}

	} // account list end

	// 예금
	private static void deposit() {
		System.out.println("------------");
		System.out.println("예금");
		System.out.println("------------");
		System.out.print("계좌번호 : ");
		String account_number = scanner.next();

		for (int i = 0; i <= idx; i++) {
			if (account_number.equals(account_arr[i].getAccount_number())) {
				System.out.print("예금액 : ");
				int depsoit_balance = scanner.nextInt();
				int before_balance = account_arr[i].getBalance();
				int after_balance = before_balance + depsoit_balance;
				account_arr[i].setBalance(after_balance);
				break;
			} else {
				break;
			}
		}
	} // deposit end

	// 출금
	private static void withdraw() {
		System.out.println("------------");
		System.out.println("출금");
		System.out.println("------------");
		System.out.print("계좌번호 : ");
		String account_number = scanner.next();
		for (int i = 0; i <= idx; i++) {
			if (account_number.equals(account_arr[i].getAccount_number())) {
				System.out.print("출금액 : ");
				int withdraw_balance = scanner.nextInt();
				int before_balance = account_arr[i].getBalance();
				int after_balance = before_balance - withdraw_balance;
				account_arr[i].setBalance(after_balance);
				break;
			} else {
				break;
			}
		}
	} // withdraw end

}
