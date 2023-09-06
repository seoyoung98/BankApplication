package com.shinhan.day07;

public class Account {
	private String account_number;
	private String account_owner;
	private int balance;
	
	public Account() {}
	
	public Account(String account_number, String account_owner, int balance) {
		super();
		this.account_number = account_number;
		this.account_owner = account_owner;
		this.balance = balance;
	}

	// GETTER, SETTER
	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_owner() {
		return account_owner;
	}

	public void setAccount_owner(String account_owner) {
		this.account_owner = account_owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
