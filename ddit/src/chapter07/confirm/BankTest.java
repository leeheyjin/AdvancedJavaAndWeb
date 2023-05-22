package chapter07.confirm;

import java.util.Arrays;

class BankAccount {
	protected int balance;

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

//------------------------------------------------------------------------------------------------
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
		return String.format("이름: %s %s, 계좌의 개수: %d",firstName,lastName, getNumberOfAccounts());
	}
}

//------------------------------------------------------------------------------------------------
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

//------------------------------------------------------------------------------------------------
class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(int balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}

	public void updateBalance(int period) {
		balance += balance * interestRate * period;
	}
}

// ------------------------------------------------------------------------------------------------
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

}

//------------------------------------------------------------------------------------------------
public class BankTest {
	public static void main(String[] args) {
		Bank bank = new Bank();

		Customer customer1 = new Customer("Tony", "Stark");
		SavingsAccount customer1SavingsAccount = new SavingsAccount(2000, 0.01);
		customer1.addAccount(customer1SavingsAccount);
		customer1.addAccount(new CheckingAccount(3000, customer1SavingsAccount));
		bank.addCustomer(customer1);

		Customer customer2 = new Customer("Peter", "Parker");
		customer2.addAccount(new CheckingAccount(2000));
		bank.addCustomer(customer2);

		Customer customer3 = new Customer("Steve", "Rogers");
		SavingsAccount customer3SavingsAccount = new SavingsAccount(2000, 0.03);
		customer3.addAccount(customer3SavingsAccount);
		customer3.addAccount(new CheckingAccount(1000, customer3SavingsAccount));
		bank.addCustomer(customer3);

		System.out.println(customer3.getFirstName() + "의 SavingsAccount 잔고 - " + customer3.getAccount(0) + "원");
		System.out.println(customer3.getFirstName() + "의 CheckingAccount 잔고 - " + customer3.getAccount(1) + "원");
		System.out.println();
		System.out.println("새로운 withdraw 메소드 실험(1,400원 인출)");
		customer3.getAccount(1).withdraw(1400); 
		System.out.println(customer3.getFirstName() + "의 SavingsAccount 잔고 - " + customer3.getAccount(0) + "원");
		System.out.println(customer3.getFirstName() + "의 CheckingAccount 잔고 -  " + customer3.getAccount(1) + "원");
		System.out.println();

		printCustomers(bank.getCustomers());
		// 10개월 후의 이자 계산
		for (Customer c : bank.getCustomers()) {
			if (c != null) {
				for (int i = 0; i < c.getNumberOfAccounts(); i++) {
					if (c.getAccount(i) instanceof SavingsAccount) {
						((SavingsAccount) c.getAccount(i)).updateBalance(10);
					}
				}
			}
		}
		System.out.println("10개월 후 잔액");
		printCustomers(bank.getCustomers());
	}

	private static void printCustomers(Customer[] customers) {
		for (Customer c : customers) {
			if (c != null) {
				System.out.println(c);
				for (int i = 0; i < c.getNumberOfAccounts(); i++) {
					System.out.println(
							"계좌 종류: " + c.getAccount(i).getClass().getSimpleName() + " 잔고 - " + c.getAccount(i) + "원");
				}
				System.out.println();
			}
		}
	}
}
