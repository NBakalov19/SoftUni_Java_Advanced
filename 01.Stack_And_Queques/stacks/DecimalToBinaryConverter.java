package stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int number = Integer.parseInt(scanner.nextLine());

    ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

    if (number == 0) {
      System.out.println(0);
      return;
    }

    while (number > 0) {
      binaryNumber.push(number % 2);
      number /= 2;
    }

    while (!binaryNumber.isEmpty()) {
      System.out.print(binaryNumber.pop());
    }
  }
}