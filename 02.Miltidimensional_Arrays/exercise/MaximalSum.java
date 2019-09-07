package exercise;

import java.util.Scanner;

public class MaximalSum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] rowCol = scanner.nextLine().split("\\s+");

    int[][] matrix = fillMatrix(rowCol, scanner);

    int bestSum = Integer.MIN_VALUE;
    int bestRow = -1;
    int bestCol = -1;

    for (int row = 1; row < matrix.length - 1; row++) {
      for (int col = 1; col < matrix[0].length - 1; col++) {
        int currSum = getSumOfSubMatrix3x3(matrix, row, col);
        if (currSum > bestSum) {
          bestSum = currSum;
          bestRow = row;
          bestCol = col;
        }
      }
    }

    System.out.printf("Sum = %d%n", bestSum);
    printSubMatrix(matrix, bestRow, bestCol);

  }

  private static void printSubMatrix(int[][] matrix, int bestRow, int bestCol) {
    System.out.printf("%d %d %d\n" +
                    "%d %d %d\n" +
                    "%d %d %d",
            matrix[bestRow - 1][bestCol - 1], matrix[bestRow - 1][bestCol], matrix[bestRow - 1][bestCol + 1],
            matrix[bestRow][bestCol - 1], matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1],
            matrix[bestRow + 1][bestCol - 1], matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]);
  }

  private static int[][] fillMatrix(String[] rowCol, Scanner scanner) {

    int rows = Integer.parseInt(rowCol[0]);
    int cols = Integer.parseInt(rowCol[1]);

    int[][] matrix = new int[rows][cols];

    for (int row = 0; row < matrix.length; row++) {
      String[] colData = scanner.nextLine().split("\\s+");
      for (int col = 0; col < matrix[0].length; col++) {
        matrix[row][col] = Integer.parseInt(colData[col]);
      }
    }
    return matrix;
  }

  private static int getSumOfSubMatrix3x3(int[][] matrix, int row, int col) {

    int sumOfFirstRow = matrix[row - 1][col - 1] + matrix[row - 1][col] + matrix[row - 1][col + 1];
    int sumOfSecondRow = matrix[row][col - 1] + matrix[row][col] + matrix[row][col + 1];
    int sumOfThirdRow = matrix[row + 1][col - 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

    return sumOfFirstRow + sumOfSecondRow + sumOfThirdRow;
  }
}