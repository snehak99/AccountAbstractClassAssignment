package com.sneha.demos.entity;

import java.util.Scanner;

import com.sneha.demos.exceptions.LowBalanceException;

public class SavingsAccount extends Account{

	float minBal;
	
	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public SavingsAccount(int v1,String v2,String v3,float v4,float v5,float v6)
	{
		super(v1,v2,v3,v4,v5);
		minBal=v6;
	}

	public float getMinBal() {
		return minBal;
	}

	public void setMinBal(float minBal) {
		this.minBal = minBal;
	}

	public void Deposit()
	{
		float amount;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Amount to Deposit : ");
		amount = sc.nextFloat();
		
		bal += amount;
		System.out.println("After Deposit Balance : "+bal);
	}
	
	public void Withdraw() throws LowBalanceException
	{
		float amount;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Amount to Withdraw : ");
		amount = sc.nextFloat();
		
		float totalBal = bal+minBal;
		
		if((totalBal - amount ) >= 10000)
		{
			totalBal -= amount;
			System.out.println("Available Balance : "+totalBal);
		}
		else
		{
			//We need JVM to stop execution here
			throw new LowBalanceException("\nInsufficient Balance");
		}
	}
	
	@Override
	public void calcInterest() {
		
		float interest = (float) (this.bal*30*7.6/(365));
		System.out.println("Interest calculation on monthly basis : "+interest+" INR");
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
