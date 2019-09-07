package lab;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
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

    int bestSum = Integer.MIN_VALUE;
    int bestRow = -1;
    int bestColumn = -1;

    for (int row = 0; row < matrix.length - 1; row++) {
      for (int col = 0; col < matrix[0].length - 1; col++) {
        int currentSum = matrix[row][col] +
                matrix[row][col + 1] +
                matrix[row + 1][col] +
                matrix[row + 1][col + 1];

        if (currentSum > bestSum) {
          bestSum = currentSum;
          bestRow = row;
          bestColumn = col;
        }
      }
    }

    System.out.println(String.format("%d %d%n%d %d%n%d",
            matrix[bestRow][bestColumn],
            matrix[bestRow][bestColumn + 1],
            matrix[bestRow + 1][bestColumn],
            matrix[bestRow + 1][bestColumn + 1],
            bestSum));
  }
}