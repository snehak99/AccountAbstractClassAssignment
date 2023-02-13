package com.sneha.demos.entity;

import java.util.Scanner;

import com.sneha.demos.exceptions.LowBalanceException;

public class CurrentAccount extends Account{

	static float maxLimit = 5000000;
	
	public CurrentAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public CurrentAccount(int v1, String v2, String v3,float v4, float v5,float v6)
	{
		super(v1,v2,v3,v4,v5);
		maxLimit = v6;
	}
	
	public float getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(float maxLimit) {
		CurrentAccount.maxLimit = maxLimit;
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
		
		if(amount <= maxLimit)
		{
			bal -= amount;
			System.out.println("\nAvailable Balance : "+bal);
		}
		else
		{
			//We need JVM to stop execution here
			throw new LowBalanceException("\nYour amount is more than your maximum limit");
		}
	}
	
	@Override
	public void calcInterest() {
		
		float interest = (float) (this.bal*30*11.25/(365));
		System.out.println("Interest calculation on monthly basis : "+interest+" INR");
	}
	
	public void Display()
	{
		System.out.println("\n--------------------------------------------");
		System.out.println("Account Number \t\t: "+ accountNo);
		System.out.println("Account Holder Name \t: "+acHolderName);
		System.out.println("Mobile Number \t\t: "+mobileNo);
		System.out.println("Interest Rate \t\t: "+intRate+"% p.a");
		System.out.println("Balance \t\t: "+bal+" INR");
		System.out.println("Maximum Limit \t\t: "+maxLimit+" INR");
		System.out.println("--------------------------------------------\n");
	}
}
