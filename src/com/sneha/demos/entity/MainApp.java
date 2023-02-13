package com.sneha.demos.entity;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.sneha.demos.exceptions.InvalidChoiceException;

public class MainApp {

	public static void main(String[] args) 
	{
		MainApp app = new MainApp();
		app.execution();
	}
	
	private void execution()
	{
		AccountMgmt obj = new AccountMgmt();
		int ch = 0;
		
		while(ch != 7)
		{
			ch = acceptChoice();
			System.out.println("Your Choice is - " + ch);
			mainMenu(ch,obj);
		}
	}

	private int acceptChoice()
	{
		int ch = 0;
		
		boolean choice = false;
		while(choice == false)
		{
			try 
			{
				System.out.println("-------------------------------------------------------");
				System.out.println("1.Open Account");
				System.out.println("2.Close Account");
				System.out.println("3.Deposit");
				System.out.println("4.Withdraw");
				System.out.println("5.Calculate Interest");
				System.out.println("6.Display All Accounts");
				System.out.println("7.Exit");
				System.out.println("-------------------------------------------------------");
				
				System.out.println("\nEnter Your Choice : ");
				
				Scanner sc = new Scanner(System.in);
				ch = sc.nextInt();
				if(ch < 1 || ch > 7)
				{
					throw new InvalidChoiceException("Invalid Choice...Try again!\n");
				}
				choice = true;
			}
			catch (InputMismatchException ime)
			{
				System.out.println("Wrong DataType...Try again!\n");
			}
			catch (InvalidChoiceException ice) 
			{
				System.out.println(ice.getMessage());
			}
		}
		return ch;
	}
	
	private void mainMenu(int ch,AccountMgmt obj) 
	{	
		switch(ch)
		{
		case 1: obj.OpenAccount();
			break;
			
		case 2: obj.CloseAccount();
			break;
			
		case 3: obj.Deposit();
			break;
			
		case 4: obj.Withdraw();
			break;
			
		case 5: obj.CalculateInterest();
			break;
			
		case 6: obj.DisplayAccounts();
			break;
			
		case 7: 
			break;
		}
	}

}
