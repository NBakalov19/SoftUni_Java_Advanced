package exercises;

import java.util.Scanner;

public class RecursiveFibonacci {
  private static long[] MEMORY;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());

    MEMORY = new long[n + 1];

    long fibonacciNumber = calculateFibonacci(n);
    System.out.println(fibonacciNumber);
  }

  private static long calculateFibonacci(int n) {
    if (n < 2) {
      return 1;
    }
    if (MEMORY[n] != 0) {
      return MEMORY[n];
    }
    return MEMORY[n] = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
  }
}