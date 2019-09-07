package BankAccount;

public class BankAccount {

  private static double interestRate = 0.02;
  private static int accountCount = 0;

  private int id;
  private double balance;


  public BankAccount() {
    accountCount++;
    this.id = accountCount;
    this.balance = 0;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void deposit(double amount) {
    this.balance += amount;
  }

  public double getInterestRate(int years) {
    return years * interestRate * this.balance;
  }

  public static void setInterestRate(double interest) {
    BankAccount.interestRate = interest;
  }
}
