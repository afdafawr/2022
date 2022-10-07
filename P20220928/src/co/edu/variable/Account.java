package co.edu.variable;

public class Account {	
	private String accNo; // 두 단어의 조합: 2번째 첫번째 대문자.
	private String owner;//예금주
	private int balance = 0; // 예금액;	
	
	public String getAccNo() {
		return accNo;
	}
	
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance += balance;
	}
}