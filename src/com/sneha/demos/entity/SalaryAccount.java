
package com.sneha.demos.entity;

import java.util.Date;
import java.util.Scanner;

import com.sneha.demos.exceptions.LowBalanceException;

public class SalaryAccount extends SavingsAccount{

	Date lastTransactionDate;
	
	public SalaryAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public SalaryAccount(int v1, String v2, String v3,float v4, float v5, float v6)
	{
		super(v1,v2,v3,v4,v5,v6);
	}

	public Date getLastTransactionDate() {
		return lastTransactionDate;
	}

	public void setLastTransactionDate(Date lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}
	
	public void Deposit()
	{
		float amount;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Amount to Deposit : ");
		amount = sc.nextFloat();
		
		bal += amount;
		System.out.println("\nAfter Deposit Balance : "+bal);
	}
	
	public void Withdraw() throws LowBalanceException
	{
		float amount;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Amount to Withdraw : ");
		amount = sc.nextFloat();
		
		float totalBal = bal+minBal;
		
		if((totalBal - amount ) >= minBal)
		{
			totalBal -= amount;
			System.out.println("\nAvailable Balance : "+totalBal);
		}
		else
		{
			//We need JVM to stop execution here
			throw new LowBalanceException("\nInsufficient Balance");
		}
	}
	
	@Override
	public void calcInterest() {
		
		float interest = (float) (this.bal*30*3.4/(365));
		System.out.println("\nInterest calculation on monthly basis : "+interest+" INR");
	}
	
	public void Display()
	{
		float totBal = bal+minBal;
		System.out.println("\n--------------------------------------------");
		System.out.println("Account Number \t\t: "+ accountNo);
		System.out.println("Account Holder Name \t: "+acHolderName);
		System.out.println("Mobile Number \t\t: "+mobileNo);
		System.out.println("Interest Rate \t\t: "+intRate+"% p.a");
		System.out.println("Balance \t\t: "+bal+" INR");
		System.out.println("Minimum Balance \t: "+minBal+" INR");
		System.out.println("Total Balance \t\t: "+totBal+" INR");
		System.out.println("--------------------------------------------\n");
	}
}
