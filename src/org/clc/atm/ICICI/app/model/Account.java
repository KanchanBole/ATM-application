package org.clc.atm.ICICI.app.model;

public class Account {
	
	private int accountNo;
	private String ifscCode;
	private Bank bank;
	private Customer customer;
	private int atmPin;
	
	public int getAtmPin() {
		return atmPin;
	}
	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	private double balance;
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
