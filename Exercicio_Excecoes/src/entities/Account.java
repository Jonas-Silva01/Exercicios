package entities;

import model.Execeptions.DomainExecptions;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {	
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}

	public void withdraw(double amount) {
		if(amount>withdrawLimit) {
			throw new DomainExecptions("Withdraw error: The amount exceeds withdraw limit");
		}
		if(amount>balance) {
			throw new DomainExecptions("Withdraw error: Not enough balance");
		}
		balance -= amount;  
	}

	@Override
	public String toString() {
		return "New balance: "
				+String.format("%.2f",balance);
	}			

	
}
