package exercise;

import java.util.Scanner;

public class DiagonalDifference {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int size = Integer.parseInt(scanner.nextLine());

    int[][] matrix = fillMatrix(size, scanner);

    int sumFirstDiagonal = 0;
    int sumSecondDiagonal = 0;

    for (int i = 0; i < size; i++) {
      sumFirstDiagonal += matrix[i][i];
    }
    for (int i = 0; i < size; i++) {
      sumSecondDiagonal += matrix[i][size - 1 - i];
    }

    int diff = Math.abs(sumFirstDiagonal - sumSecondDiagonal);

    System.out.println(diff);
  }

  private static int[][] fillMatrix(int size, Scanner scanner) {
    int[][] matrix = new int[size][size];

    for (int row = 0; row < size; row++) {
      String[] colData = scanner.nextLine().split("\\s+");
      for (int col = 0; col < size; col++) {
        matrix[row][col] = Integer.parseInt(colData[col]);
      }
    }
    return matrix;
  }
}