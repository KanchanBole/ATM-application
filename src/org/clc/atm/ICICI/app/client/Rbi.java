package org.clc.atm.ICICI.app.client;

import java.util.Scanner;

import org.clc.atm.ICICI.app.service.RbiServiceImpl;
import org.clc.atm.ICICI.app.service.RbiServices;
import org.clc.atm.ICICI.app.utility.ScannerUtility;




public class Rbi {
	
	public static void main(String[] args) { 
		
		RbiServices service=new RbiServiceImpl();
		
		System.out.println("Welcome to ICICI ATM at Murtizapur");
		
		
		while(true) {
		System.out.println("1) Create Bank");
		System.out.println("2) Account Create");
		System.out.println("3) Account Details");
		System.out.println("4) Deposite");
		System.out.println("5) Withdrawal");
		System.out.println("6) Check Balance");
		System.out.println("7) Simple Intrest");
		System.out.println("8) Exit");
		
		Scanner sc=ScannerUtility.getScanner();
		System.out.println("Please Select Any Above Option");
		int key=sc.nextInt();
		
       switch (key){
       
       case 1:
    	   service.CreateBank();
    	   break;
    	   
       case 2:
    	   service.CreateAccount();
    	   break;
    	   
       case 3:
	       service.AccountDetails();
	       break;
	   
       case 4:
	       service.Deposite();
	       break;
	   
       case 5:
	      service.Withdrawal();
	       break;
	   
       case 6:
	      service.CheckBalance();
	       break;
	   
       case 7:
	      service.SimpleInterest();
	       break;
	   
       case 8:
	        System.out.println("THANK YOU ....Welcome Again!!!!");
	          System.exit(0);
	      break;
	        
	    default:
	    	System.out.println("You Entered Wrong Number...Try Later..!!");
	    	System.exit(1);
	    	
	      break;
       }
		
	}	
  }
}
