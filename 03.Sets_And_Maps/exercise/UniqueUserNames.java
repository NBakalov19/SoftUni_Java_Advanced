package exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUserNames {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfUserNames = Integer.parseInt(scanner.nextLine());

    Set<String> userNamesList = new LinkedHashSet<>();

    for (int i = 0; i < countOfUserNames; i++) {
      String userName = scanner.nextLine();
      userNamesList.add(userName);
    }
    for (String username : userNamesList) {
      System.out.println(username);
    }
  }
}