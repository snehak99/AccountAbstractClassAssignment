package com.sneha.demos.entity;

import com.sneha.demos.exceptions.LowBalanceException;

public abstract class Account {

	int accountNo;
	String acHolderName;
	String mobileNo;
	float bal;
	float intRate;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(int v1,String v2,String v3,float v4, float v5)
	{
		accountNo=v1;
		acHolderName=v2;
		mobileNo=v3;
		bal=v4;
		intRate=v5;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAcHolderName() {
		return acHolderName;
	}

	public void setAcHolderName(String acHolderName) {
		this.acHolderName = acHolderName;
	}

	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public float getBal() {
		return bal;
	}

	public void setBal(float bal) {
		this.bal = bal;
	}

	public double getIntRate() {
		return intRate;
	}

	public void setIntRate(float intRate) {
		this.intRate = intRate;
	}
	
	public void Deposit()
	{
		float amount = 0;
		bal += amount;
		System.out.println("After Deposit Balance : "+bal);
	}
	
	public void Withdraw() throws LowBalanceException
	{
		float amount = 0;
		if(bal >= amount)
		{
			bal -= amount;
			System.out.println("Available Balance : "+bal);
		}
		else
		{
			//We need JVM to stop execution here
			throw new LowBalanceException("\nInsufficient Balance");
		}
	}
	
	public abstract void calcInterest();
	
	public void Display()
	{
		System.out.println("\n--------------------------------------------");
		System.out.println("Account Number \t\t: "+ accountNo);
		System.out.println("Account Holder Name \t: "+acHolderName);
		System.out.println("Mobile Number \t\t: "+mobileNo);
		System.out.println("Interest Rate \t\t: "+intRate+"% p.a");
		System.out.println("Balance \t\t\t: "+bal+" INR");
		System.out.println("--------------------------------------------\n");
	}
}
