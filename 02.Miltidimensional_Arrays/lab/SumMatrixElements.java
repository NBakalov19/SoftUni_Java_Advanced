package lab;

import java.util.Scanner;

public class SumMatrixElements {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] sizes = scanner.nextLine().split(", ");
    int rows = Integer.parseInt(sizes[0]);
    int cols = Integer.parseInt(sizes[1]);

    int[][] matrix = new int[rows][cols];

    for (int row = 0; row < rows; row++) {
      String[] colsInput = scanner.nextLine().split(", ");
      for (int col = 0; col < cols; col++) {
        matrix[row][col] = Integer.parseInt(colsInput[col]);
      }
    }

    int sum = 0;
    for (int[] ints : matrix) {
      for (int col = 0; col < matrix[0].length; col++) {
        sum += ints[col];
      }
    }
    System.out.println(rows);
    System.out.println(cols);
    System.out.println(sum);
  }
}
