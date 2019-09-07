package BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] line = scanner.nextLine().split("\\s+");
    String command = line[0];

    HashMap<Integer, BankAccount> accounts = new HashMap<>();


    while (!command.equals("End")) {
      String result = "";
      switch (command) {

        case "Create":
          BankAccount currentAccount = new BankAccount();
          accounts.put(currentAccount.getId(), currentAccount);
          result = String.format("Account ID%d created", currentAccount.getId());
          break;
        case "Deposit":
          int accountId = Integer.parseInt(line[1]);
          double amount = Double.parseDouble(line[2]);

          BankAccount currentAcc = accounts.get(accountId);
          if (currentAcc == null) {
            result = "Account does not exist";
            break;
          }
          currentAcc.deposit(amount);
          accounts.put(accountId, currentAcc);
          result = String.format("Deposited %.0f to ID%d", amount, accountId);
          break;
        case "SetInterest":
          double interestRate = Double.parseDouble(line[1]);
          BankAccount.setInterestRate(interestRate);
          break;
        case "GetInterest":
          int accountID2 = Integer.parseInt(line[1]);
          int years = Integer.parseInt(line[2]);

          BankAccount account = accounts.get(accountID2);
          if (account == null) {
            result = "Account does not exist";
            break;
          }

          double currAccInterest = account.getInterestRate(years);

          result = String.format("%.2f", currAccInterest);

          break;
      }
      if (!result.isEmpty()) {
        System.out.println(result);
      }
      line = scanner.nextLine().split("\\s+");
      command = line[0];
    }
  }
}