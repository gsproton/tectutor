package com.tectutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class Process {
	List<Bank> bank = new ArrayList<>();
	int currentUser = -1;
	Scanner sc = new Scanner(System.in);
	
	public void addUser() {
		Bank bk = new Bank();
		int acct = -1;
		System.out.println("Create an account");
		System.out.println("Enter username:");
  		bk.setName(sc.nextLine());
		if(bank.size() >= 1) {
			Bank bkmax = bank.stream().max(Comparator.comparingInt(Bank::getac)).get();
			acct = bkmax.getac()+1;
 			bk.setAN(acct);
		} else {
			acct = 1;
			bk.setAN(acct);
		}
		bk.deposit(0.0);
		bank.add(bk);
		System.out.println("");
		currentUser = getAcctIndex(acct);
 		if(currentUser >= 0) {
			infoAccount();
		}
		
	}	

	public void fkaddUser(String username) {
		Bank bk = new Bank();
  		bk.setName(username);
		if(bank.size() >= 1) {
			Bank bkmax = bank.stream().max(Comparator.comparingInt(Bank::getac)).get();
 			bk.setAN(bkmax.getac()+1);
		} else {
			bk.actNo = 1;
		}
		bk.deposit(0.0);
		bank.add(bk);
	}	
	
	public void deposit() {
		System.out.println("Enter amount to be deposited:");
		Double amount = sc.nextDouble();
		if(amount > 0) {
			bank.get(currentUser).deposit(amount);
		} else {
			System.out.println("invalid amount");
		}
	}

	public void witdraw() {
		System.out.println("Current amount "+bank.get(currentUser).getBal());
		System.out.println("Enter amount to be withdrawn:");
		Double amount = sc.nextDouble();
		bank.get(currentUser).withdraw(amount);
		System.out.println("");
		System.out.println("New Current amount "+bank.get(currentUser).getBal());
	}

	public int getAcctIndex(int acct_no) {
		int index = -1;
		for(Bank bk : bank) {
 			if(bk.getac() == acct_no) {
				index =  bank.indexOf(bk);
			}
		}
		return index; 
	}
	
	public void getAccount() {
		currentUser = -1;
		System.out.println("Please enter Account No:");
		int index = getAcctIndex(sc.nextInt());
		if(index >= 0) {
			currentUser = index;
			
		} else {
			System.out.println("Account No not found.");
		}
	}

	public void infoAccount() {
		 System.out.println("Account No:" + bank.get(currentUser).getac());
		 System.out.println("Name:" + bank.get(currentUser).getName());
		 System.out.println("Balance:" + bank.get(currentUser).getBal());
	}

	public static void showMenu() {
		System.out.println("");
		System.out.println("1....New Customer/open new act");
		System.out.println("2....Deposit");
		System.out.println("3....Withdraw ");
		System.out.println("4....Get information for particular account" );
	    System.out.println("5....Exit  "); 	
	}
	
	public void process() {
		fkaddUser("glenn");
		fkaddUser("mike");
		int quit = 0;
		int choice = 0;
		while (quit == 0) {
			showMenu();
            int ch=sc.nextInt();
            sc.nextLine();
            if(ch==1)
            {
            	addUser();
            }
            else if (ch==2)
            {
            	getAccount();
            	if(currentUser >= 0) {
            		deposit();	
            	}
            	
            }
            else if(ch==3)
            {
               	getAccount();
            	if(currentUser >= 0) {
            		witdraw();	
            	}

            }
            else if(ch==4)
            {
               	getAccount();
            	if(currentUser >= 0) {
            		infoAccount();	
            	}
            }
            else if(ch==5)
            {
            	quit = 1;
            }
            else{
                 System.out.println("invalid input");

            }		
		}		
	}
	
}
