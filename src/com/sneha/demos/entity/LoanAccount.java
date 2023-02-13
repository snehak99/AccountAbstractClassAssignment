package com.sneha.demos.entity;

import java.util.Scanner;

import com.sneha.demos.exceptions.LowBalanceException;

public class LoanAccount extends Account{

	float loanAmount;
	int tenure;
	float repaidAmount;
	
	public LoanAccount()
	{
		
	}
	
	public LoanAccount (int v1, String v2, String v3,float v4, float v5, float v6,int v7)
	{
		super(v1,v2,v3,v4,v5);
		loanAmount=v6;
		tenure=v7;
	}

	
	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public float getRepaidAmount() {
		return repaidAmount;
	}

	public void setRepaidAmount(float repaidAmount) {
		this.repaidAmount = repaidAmount;
	}

	@Override
	public void calcInterest() {
		
		float interest = (float) (10.90/12/100);
		System.out.println("\nInterest calculation on monthly basis   : "+interest+"%");
		
		float emi = this.loanAmount*interest;
		System.out.println("Monthly EMI \t\t\t\t: "+emi+" INR");
		
		float totEmi = loanAmount*interest*this.tenure;
		repaidAmount = loanAmount+totEmi;
		System.out.println("Repaid Amount \t\t\t\t: "+repaidAmount+" INR");
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
		
		if(bal >= amount)
		{
			bal -= amount;
			System.out.println("\nAvailable Balance : "+bal);
		}
		else
		{
			//We need JVM to stop execution here
			throw new LowBalanceException("\nInsufficient Balance");
		}
	}
	public void Display()
	{
		System.out.println("\n--------------------------------------------");
		System.out.println("Account Number \t\t: "+ accountNo);
		System.out.println("Account Holder Name \t: "+acHolderName);
		System.out.println("Mobile Number \t\t: "+mobileNo);
		System.out.println("Interest Rate \t\t: "+intRate+"% p.a");
		System.out.println("Balance \t\t: "+bal+" INR");
		System.out.println("Loan Amount \t\t: "+loanAmount);
		System.out.println("Tenure (in months) \t: "+tenure);
		System.out.println("--------------------------------------------\n");
	}
}
