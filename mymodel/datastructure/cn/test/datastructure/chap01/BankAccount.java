package cn.test.datastructure.chap01;

public class BankAccount {
	
	private double balance;
	
	public BankAccount(double balance){
		this.balance=balance;
	}
	
	public void deposit(double amount){
		balance = balance+amount;
	}
	
	public void withdraw(double amount){
		balance = balance - amount;
	}
	
	public void display(){
		System.out.println("balance = "+balance);
	}
	
	public static void main(String[] args) {
		
		BankAccount account = new BankAccount(1000d);
		
		account.deposit(100);
		account.display();
		
		account.withdraw(200);
		account.display();
		
	}
}
