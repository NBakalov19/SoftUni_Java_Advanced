package exercise;

import java.util.Scanner;

public class MatrixOfPalindromes {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] rowCol = scanner.nextLine().split("\\s+");

    int rows = Integer.parseInt(rowCol[0]);
    int cols = Integer.parseInt(rowCol[1]);

    String[][] matrix = new String[rows][cols];

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        String element = "" + (char) ('a' + row) + (char) ('a' + row + col) + (char) ('a' + row);
        matrix[row][col] = element;
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        System.out.print(matrix[row][col] + " ");
      }
      System.out.println();
    }
  }
}