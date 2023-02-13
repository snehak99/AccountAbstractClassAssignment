package com.sneha.demos.entity;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.sneha.demos.exceptions.LowBalanceException;

public class AccountMgmt {
	
	Set<SavingsAccount> savAcc;
	Set<CurrentAccount> curAcc;
	Set<SalaryAccount> salAcc;
	Set<LoanAccount> LoanAcc;
	
	public AccountMgmt() 
	{
		savAcc = new HashSet<SavingsAccount>();
		curAcc = new HashSet<CurrentAccount>();
		salAcc = new HashSet<SalaryAccount>();
		LoanAcc = new HashSet<LoanAccount>();
	}

///////////////////////////////////////////////////////////////////////////////////

public void OpenAccount() 
{
	System.out.println("\n1.Savings Account");
	System.out.println("2.Current Account");
	System.out.println("3.Salary Account");
	System.out.println("4.Loan Account");
	
	System.out.println("\nEnter Your Choice : ");
	
	Scanner sc = new Scanner(System.in);
	
	int choice = sc.nextInt();
	
	switch(choice)
	{
	case 1 : openSavingsAccount();
		break;
		
	case 2 : openCurrentAccount();
		break;
		
	case 3 : openSalaryAccount();
		break;
		
	case 4 : openLoanAccount();
		break;
		
	default : System.out.println("\nInvalid Choice... Try Again");
		break;
	}
}

///////////////////////////////////////////////////////////////////////////////////
	
private void openSavingsAccount() 
{
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	
	int actNo = random.nextInt(50);
	
	System.out.println("Enter Your Name : ");
	String name = sc.next();
	
	System.out.println("Enter Mobile Number : ");
	String mobile = sc.next();
	
	float intRate = 7.6f;
	
	System.out.println("Deposit Minimum Balance (minimum balance should be 10,000Rs): ");
	float minbal = sc.nextFloat();
	if(minbal >= 10000)
	{
		System.out.println("Do you want to deposit money (yes/no): ");
		String ch = sc.next();
		
		if(ch.equals("yes"))
		{
			System.out.println("Deposit Money : ");
			float bal = sc.nextFloat();
			
			Account ref = new SavingsAccount(actNo, name, mobile, bal, intRate, minbal);
			savAcc.add((SavingsAccount) ref);
			
			System.out.println("\nAccount created successfully...");
			ref.Display();
		}
		else
		{
			float bal = 0;
			
			Account ref = new SavingsAccount(actNo, name, mobile, bal, intRate, minbal);
			savAcc.add((SavingsAccount) ref);
			
			System.out.println("\nAccount created successfully...");
			ref.Display();
		}
	}
	else
	{
		System.out.println("\nYour minimum balance is less than 10,000Rs please Deposit at least 10,000rs.");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void openCurrentAccount() 
{

	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	
	int actNo = random.nextInt(50);
	
	System.out.println("Enter Your Name : ");
	String name = sc.next();
	
	System.out.println("Enter Mobile Number : ");
	String mobile = sc.next();
	
	float intRate = 11.25f;
	float maxLimit = 5000000;
	
	System.out.println("Do you want to deposit money (yes/no): ");
	String ch = sc.next();
	
	if(ch.equals("yes"))
	{
		System.out.println("Deposit Money : ");
		float bal = sc.nextFloat();
		
		Account ref = new CurrentAccount(actNo, name, mobile, bal, intRate, maxLimit);
		curAcc.add((CurrentAccount) ref);
		
		System.out.println("\nAccount created successfully...");
		ref.Display();
	}
	else
	{
		float bal = 0;
		
		Account ref = new CurrentAccount(actNo, name, mobile, bal, intRate, maxLimit);
		curAcc.add((CurrentAccount) ref);
		
		System.out.println("\nAccount created successfully...");
		ref.Display();
	}	
}

///////////////////////////////////////////////////////////////////////////////////

private void openSalaryAccount() 
{
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	
	int actNo = random.nextInt(50);
	
	System.out.println("Enter Your Name : ");
	String name = sc.next();
	
	System.out.println("Enter Mobile Number : ");
	String mobile = sc.next();
	
	float intRate = 3.4f;
	
	System.out.println("Deposit Minimum Balance (minimum balance should be 10,000Rs): ");
	float minbal = sc.nextFloat();
	
	if(minbal >= 10000)
	{
		System.out.println("Do you want to deposit money (yes/no): ");
		String ch = sc.next();
		
		if(ch.equals("yes"))
		{
			System.out.println("Deposit Money : ");
			float bal = sc.nextFloat();
			
			Account ref = new SalaryAccount(actNo, name, mobile, bal, intRate, minbal);
			salAcc.add((SalaryAccount) ref);
			
			System.out.println("\nAccount created successfully...");
			ref.Display();
		}
		else
		{
			float bal = 0;
			
			Account ref = new SalaryAccount(actNo, name, mobile, bal, intRate, minbal);
			salAcc.add((SalaryAccount) ref);
			
			System.out.println("\nAccount created successfully...");
			ref.Display();
		}
	}
	else
	{
		System.out.println("\nYour minimum balance is less than 10,000Rs please Deposit at least 10,000rs.");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void openLoanAccount() 
	{
	
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	
	int actNo = random.nextInt(50);
	
	System.out.println("Enter Your Name : ");
	String name = sc.next();
	
	System.out.println("Enter Mobile Number : ");
	String mobile = sc.next();
	
	float bal = 0;
	float intRate = 10.90f;
	
	System.out.println("Enter Principle Loan Amount : ");
	float loanAmount = sc.nextFloat();
	
	System.out.println("Enter tenure (In Months) : ");
	int tenure = sc.nextInt();
	
	Account ref = new LoanAccount(actNo, name, mobile, bal, intRate, loanAmount, tenure);
	LoanAcc.add((LoanAccount) ref);
	ref.Display();
	
}

///////////////////////////////////////////////////////////////////////////////////

public void CloseAccount() 
{
	
	System.out.println("\n1.Savings Account");
	System.out.println("2.Current Account");
	System.out.println("3.Salary Account");
	System.out.println("4.Loan Account");
	
	System.out.println("\nEnter Your Choice : ");
	
	Scanner sc = new Scanner(System.in);
	
	int choice = sc.nextInt();
	
	switch(choice)
	{
	case 1 : closeSavingsAccount();
		break;
		
	case 2 : closeCurrentAccount();
		break;
		
	case 3 : closeSalaryAccount();
		break;
		
	case 4 : closeLoanAccount();
		break;
		
	default : System.out.println("\nInvalid Choice... Try Again");
		break;
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void closeSavingsAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Savings Account Number : ");
	int accNo = sc.nextInt();
	
	for(SavingsAccount ref : savAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.Display();
			System.out.println("Do you want to close this Account(yes/no) : ");
			String ch = sc.next();
			
			if(ch.equals("yes"))
			{
				savAcc.remove(ref);
				System.out.println("Your account has been Closed...");
			}
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void closeCurrentAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Current Account Number : ");
	int accNo = sc.nextInt();
	
	for(CurrentAccount ref : curAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.Display();
			System.out.println("Do you want to close this Account(yes/no) : ");
			String ch = sc.next();
			
			if(ch.equals("yes"))
			{
				savAcc.remove(ref);
				System.out.println("Your account has been Closed...");
			}
		}
	}
	
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void closeSalaryAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Current Account Number : ");
	int accNo = sc.nextInt();
	
	for(CurrentAccount ref : curAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.Display();
			System.out.println("Do you want to close this Account(yes/no) : ");
			String ch = sc.next();
			
			if(ch.equals("yes"))
			{
				savAcc.remove(ref);
				System.out.println("Your account has been Closed...");
			}
		}
	}
	
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void closeLoanAccount() 
{
	
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Loan Account Number : ");
	int accNo = sc.nextInt();
	
	for(LoanAccount ref : LoanAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.Display();
			System.out.println("Do you want to close this Account(yes/no) : ");
			String ch = sc.next();
			
			if(ch.equals("yes"))
			{
				savAcc.remove(ref);
				System.out.println("Your account has been Closed...");
			}
		}
	}
	
	if(!found)
	{
		System.out.println("Account Not Found!");
	}

}

///////////////////////////////////////////////////////////////////////////////////

public void Deposit() 
{
	
	System.out.println("\n1.Savings Account");
	System.out.println("2.Current Account");
	System.out.println("3.Salary Account");
	System.out.println("4.Loan Account");
	
	System.out.println("\nEnter Your Choice : ");
	
	Scanner sc = new Scanner(System.in);
	
	int choice = sc.nextInt();
	
	switch(choice)
	{
	case 1 : depositSavingsAccount();
		break;
		
	case 2 : depositCurrentAccount();
		break;
		
	case 3 : depositSalaryAccount();
		break;
		
	case 4 : depositLoanAccount();
		break;
		
	default : System.out.println("\nInvalid Choice... Try Again");
		break;
	}
}

///////////////////////////////////////////////////////////////////////////////////
	
private void depositSavingsAccount() 
{
	
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Savings Account Number : ");
	int accNo = sc.nextInt();

	for(SavingsAccount ref : savAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.Deposit();
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void depositCurrentAccount() 
{
	
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Current Account Number : ");
	int accNo = sc.nextInt();

	for(CurrentAccount ref : curAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.Deposit();
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void depositSalaryAccount() 
{
	
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Salary Account Number : ");
	int accNo = sc.nextInt();

	for(SalaryAccount ref : salAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.Deposit();
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void depositLoanAccount() 
{

	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Loan Account Number : ");
	int accNo = sc.nextInt();

	for(LoanAccount ref : LoanAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.Deposit();
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

public void Withdraw() 
{
	System.out.println("\n1.Savings Account");
	System.out.println("2.Current Account");
	System.out.println("3.Salary Account");
	System.out.println("4.Loan Account");
	
	System.out.println("\nEnter Your Choice : ");
	
	Scanner sc = new Scanner(System.in);
	
	int choice = sc.nextInt();
	
	switch(choice)
	{
	case 1 : withdrawSavingsAccount();
		break;
		
	case 2 : withdrawCurrentAccount();
		break;
		
	case 3 : withdrawSalaryAccount();
		break;
		
	case 4 : withdrawLoanAccount();
		break;
		
	default : System.out.println("\nInvalid Choice... Try Again");
		break;
	}
	
}

///////////////////////////////////////////////////////////////////////////////////
	
private void withdrawSavingsAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Savings Account Number : ");
	int accNo = sc.nextInt();

	for(SavingsAccount ref : savAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			try 
			{
				ref.Withdraw();
				
			} 
			catch (LowBalanceException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void withdrawCurrentAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Current Account Number : ");
	int accNo = sc.nextInt();

	for(CurrentAccount ref : curAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			try 
			{
				ref.Withdraw();
				
			} 
			catch (LowBalanceException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void withdrawSalaryAccount()
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Salary Account Number : ");
	int accNo = sc.nextInt();

	for(SalaryAccount ref : salAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			try 
			{
				ref.Withdraw();
				
			} 
			catch (LowBalanceException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

private void withdrawLoanAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Loan Account Number : ");
	int accNo = sc.nextInt();

	for(LoanAccount ref : LoanAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			try 
			{
				ref.Withdraw();
			} 
			catch (LowBalanceException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

public void CalculateInterest() 
{
	System.out.println("\n1.Savings Account");
	System.out.println("2.Current Account");
	System.out.println("3.Salary Account");
	System.out.println("4.Loan Account");
	
	System.out.println("\nEnter Your Choice : ");
	
	Scanner sc = new Scanner(System.in);
	
	int choice = sc.nextInt();
	
	switch(choice)
	{
	case 1 : calculateInterestSavingsAccount();
		break;
		
	case 2 : calculateInterestCurrentAccount();
		break;
		
	case 3 : calculateInterestSalaryAccount();
		break;
		
	case 4 : calculateInterestLoanAccount();
		break;
		
	default : System.out.println("\nInvalid Choice... Try Again");
		break;
	}
}

///////////////////////////////////////////////////////////////////////////////////
	
private void calculateInterestSavingsAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Savings Account Number : ");
	int accNo = sc.nextInt();

	for(SavingsAccount ref : savAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.calcInterest();
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////
	
private void calculateInterestCurrentAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Current Account Number : ");
	int accNo = sc.nextInt();

	for(CurrentAccount ref : curAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.calcInterest();
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////
	
private void calculateInterestSalaryAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Salary Account Number : ");
	int accNo = sc.nextInt();

	for(SalaryAccount ref : salAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.calcInterest();
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////
	
private void calculateInterestLoanAccount() 
{
	boolean found = false;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your Loan Account Number : ");
	int accNo = sc.nextInt();

	for(LoanAccount ref : LoanAcc)
	{
		if(accNo == ref.getAccountNo())
		{
			found = true;
			ref.calcInterest();
		}
	}
	if(!found)
	{
		System.out.println("Account Not Found!");
	}
}

///////////////////////////////////////////////////////////////////////////////////

public void DisplayAccounts() 
{
	System.out.println("Account Type : Savings Account");
	if(savAcc.size()==0)
	{
		System.out.println("\nNo Accounts Available");
	}
	else
	{
		System.out.println("\n"+savAcc.size()+" Savings Accounts Available");
		for(SavingsAccount ref : savAcc)
		{
			ref.Display();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	System.out.println("\nAccount Type : Current Account");
	if(curAcc.size()==0)
	{
		System.out.println("\nNo Accounts Available");
	}
	else
	{
		System.out.println("\n"+curAcc.size()+" Current Accounts Available");
		for(CurrentAccount ref : curAcc)
		{
			ref.Display();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	System.out.println("\nAccount Type : Salary Account");
	if(salAcc.size()==0)
	{
	System.out.println("\nNo Accounts Available");
	}
	else
	{
		System.out.println("\n"+salAcc.size()+" Salary Accounts Available");
		for(SalaryAccount ref : salAcc)
		{
		ref.Display();
		}
	}
		
	///////////////////////////////////////////////////////////////////////////
	
	System.out.println("\nAccount Type : Loan Account");
	if(LoanAcc.size()==0)
	{
	System.out.println("\nNo Accounts Available");
	}
	else
	{
		System.out.println("\n"+LoanAcc.size()+" Loan Accounts Available");
		for(LoanAccount ref : LoanAcc)
		{
		ref.Display();
		}
	}
}

///////////////////////////////////////////////////////////////////////////////////

}
