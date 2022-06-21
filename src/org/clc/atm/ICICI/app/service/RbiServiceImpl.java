package org.clc.atm.ICICI.app.service;


import java.util.Scanner;

import org.clc.atm.ICICI.app.model.Account;
import org.clc.atm.ICICI.app.model.Bank;
import org.clc.atm.ICICI.app.model.Customer;
import org.clc.atm.ICICI.app.utility.ScannerUtility;

public class RbiServiceImpl implements RbiServices {

	
	   Bank bank=null;
	   Customer customer=null;
	   
	   
	@Override
	public void CreateBank() {
		bank=new Bank();
		Scanner sc=ScannerUtility.getScanner();
		
	    System.out.println("Enter Bank Code :");
	    bank.setCode(sc.nextInt());
	    System.out.println("Enter Bank Name :");
	    bank.setBankName(sc.next());
	    System.out.println("Enter Bank Address :");
	    bank.setAddress(sc.next());

	}

	@Override
	public void CreateAccount() {
		
		if(bank!=null) {
			
			Scanner sc=ScannerUtility.getScanner();
			customer=new Customer();
			
			System.out.println("Enter Customer Id :");
			customer.setCustomerId(sc.nextInt());
			System.out.println("Enter Customer Name :");
			customer.setCustomerName(sc.next());
			System.out.println("Enter Customer Address :");
			customer.setAddress(sc.next());
			
			System.out.println("Enter Account no. :");
			Account account=new Account();
			account.setAccountNo(sc.nextInt());
			System.out.println("Enter Account Ifsc Code :");
            account.setIfscCode(sc.next());
            System.out.println("Enter Account Pin");
            account.setAtmPin(sc.nextInt());
            
            account.setBank(bank);
            customer.setAccount(account);
			
			
		}else {
			System.out.println("There is no any bank details found,please add Bank");
            CreateBank();
      }
	}

	@Override
	public void AccountDetails() {
		
		if(customer!=null) {
			System.out.println(customer.getCustomerId()+"\t"+ customer.getCustomerName()+"\t"+ customer.getAddress());
		    System.out.println("\t"+ customer.getAccount().getAccountNo()+"\t"+ customer.getAccount().getIfscCode());
		    System.out.println("\t\t"+ customer.getAccount().getBank().getBankName());
		}
		

	}

	@Override
	public void Deposite() {
		Scanner sc=ScannerUtility.getScanner();
		if(customer!=null) {
		System.out.println("Please Enter Your Atm Pin");
		int userPin=sc.nextInt();
		if(customer.getAccount().getAtmPin() ==userPin) {
			System.out.println("Enter deposite Amount");
			double amount=sc.nextDouble();
			double balance=customer.getAccount().getBalance();
			if(amount> 0) {
				balance=balance+amount;
				customer.getAccount().setBalance(balance);
				
			}else {
				System.out.println("please Enter valid amount");
			}
		}else {
			System.out.println("Invalid ATM Pin, try again!!!");
			
		}
		}else {
			System.out.println("Customer does not exits");
			CreateAccount();
		}

	}

	@Override
	public void Withdrawal() {
		Scanner sc= ScannerUtility.getScanner();
		if(customer!=null) {
			System.out.println("please enter your atm pin");
			int userPin=sc.nextInt();
			if(customer.getAccount().getAtmPin() ==userPin) {
				System.out.println("Enter Withdrawal amount");
				double amount=sc.nextDouble();
				double balance =customer.getAccount().getBalance();
				if(amount>0) {
					if(balance!=0) {
						balance =balance - amount;
						customer.getAccount().setBalance(balance);
						
					}else {
						System.out.println("Bank balance not available");
					}
				}else {
					System.out.println("Please enter Valid amount");
				}
			}else {
				System.out.println("Invalid ATM Pin, try again!!!");
			}
		}else {
			System.out.println("Customer does not exist");
			CreateAccount();
		}

	}

	@Override
	public void CheckBalance() {
		if(customer !=null) {
			System.out.println(customer.getCustomerId()+"\t"+ customer.getCustomerName()+ "\t" + customer.getAddress());
		    System.out.println("\t"+ customer.getAccount().getAccountNo());
		    System.out.println("-------------------------------------");
		    System.out.println("Bank Balance is : "+ customer.getAccount().getBalance());
		    System.out.println("-------------------------------------");
		
		}

	}

	@Override
	public void SimpleInterest() {
		
		System.out.println("Simple interest 4% for 2 years");
		double pamount=customer.getAccount().getBalance();
		double interest=((pamount*4*2)/100);
		System.out.println("Interest is : "+ interest);
		double finalBalance=pamount+interest;
		customer.getAccount().setBalance(finalBalance);
        System.out.println("Bank Balance "+ customer.getAccount().getBalance());
	}

}
