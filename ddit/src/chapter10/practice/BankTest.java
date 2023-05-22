package chapter10.practice;

import java.util.Arrays;

abstract class BankAccount {
	protected int balance;

	public abstract String getAccountType();

	public BankAccount(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public boolean withdraw(int amount) {
		if (balance < amount) {
			return true;
		} else {
			balance -= amount;
			return true;
		}
	}

	public boolean transfer(int amount, BankAccount otherAccount) {
		if (amount < 0 || amount > balance) {
			throw new IllegalArgumentException();
		}

		if (otherAccount == null) {
			throw new NullPointerException();
		}

		if (balance - amount < 0) {
			return false;
		} else {
			balance -= amount;
			otherAccount.balance += amount;
			return true;
		}
	}

	@Override
	public String toString() {
		return String.format("잔액: %,d", getBalance());
	}
}

class Customer {
	private String firstName;
	private String lastName;
	private BankAccount[] accounts;
	private int numberOfAccounts;

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		accounts = new BankAccount[5];
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public BankAccount getAccount(int index) {
		return accounts[index];
	}

	public void addAccount(BankAccount bankAccount) {
		accounts[numberOfAccounts] = bankAccount;
		numberOfAccounts++;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	@Override
	public String toString() {
		return String.format(firstName + " " + lastName);
	}
}

class Bank {
	private Customer[] customers;
	private int numberOfCustomers;

	public Bank() {
		customers = new Customer[10];
	}

	public void addCustomer(Customer customer) {
		customers[numberOfCustomers] = customer;
		numberOfCustomers++;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public Customer getCustomer(int index) {
		return customers[index];
	}

	@Override
	public String toString() {
		return Arrays.toString(customers);
	}
}

class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(int balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}

	public void updateBalance(int period) {
		balance += balance * interestRate * period;
	}

	@Override
	public String getAccountType() {
		return "저축예금";
	}
}

class CheckingAccount extends BankAccount {
	SavingsAccount protectedBy;

	public CheckingAccount(int balance) {
		super(balance);
	}

	public CheckingAccount(int balance, SavingsAccount protectedBy) {
		super(balance);
		this.protectedBy = protectedBy;
	}

	public boolean withdraw(int amount) {
		if (amount > balance) {
			protectedBy.balance -= amount - balance;
			balance = 0;
			return true;
		}
		return super.withdraw(amount);
	}

	@Override
	public String getAccountType() {
		return "당좌예금";
	}

}

public class BankTest {
	public static void main(String[] args) {
		CheckingAccount tonyAccount = new CheckingAccount(3000);
		CheckingAccount steveAccount = new CheckingAccount(3000);
		try {
			tonyAccount.transfer(5000, steveAccount);
			System.out.println("송금 완료");
		} catch (NullPointerException e) {
			System.out.println("해당하는 계좌가 없습니다.");
			System.out.println("송금 실패");
		} catch (IllegalArgumentException e) {
			System.out.println("해당하는 금액을 보낼 수 없습니다.");
			System.out.println("송금 실패");
		}
		try {
			tonyAccount.transfer(2000, null);
			System.out.println("송금 완료");
		} catch (NullPointerException e) {
			System.out.println("해당하는 계좌가 없습니다.");
			System.out.println("송금 실패");
		} catch (IllegalArgumentException e) {
			System.out.println("해당하는 금액을 보낼 수 없습니다.");
			System.out.println("송금 실패");
		}
	}
}
