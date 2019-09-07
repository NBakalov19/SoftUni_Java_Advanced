package lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int size = Integer.parseInt(scanner.nextLine());

    int[][] squareMatrix = new int[size][size];

    for (int row = 0; row < size; row++) {
      int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+"))
              .mapToInt(Integer::parseInt)
              .toArray();
      squareMatrix[row] = rowData;
    }

    for (int i = 0; i < size; i++) {
      System.out.print(squareMatrix[i][i] + " ");
    }
    System.out.println();
    for (int i = 0; i < size; i++) {
      System.out.print(squareMatrix[size - 1 - i][i] + " ");
    }
    System.out.println();
  }
}