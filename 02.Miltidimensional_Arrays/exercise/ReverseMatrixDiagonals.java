package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split("\\s+");

    int rows = Integer.parseInt(input[0]);
    int cols = Integer.parseInt(input[1]);

    int[][] matrix = new int[rows][cols];

    for (int row = 0; row < rows; row++) {
      matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
              .mapToInt(Integer::parseInt)
              .toArray();
    }

    int row = rows - 1;
    int col = cols - 1;

    while (row > -1) {
      int r = row;
      int c = col;
      while (c < cols && r >= 0) {
        System.out.print(matrix[r--][c++] + " ");
      }
      System.out.println();
      col--;
      if (col == -1) {
        col = 0;
        row--;
      }
    }
  }
}