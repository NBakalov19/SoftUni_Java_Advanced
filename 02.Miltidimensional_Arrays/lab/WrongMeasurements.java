package lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int rows = Integer.parseInt(scanner.nextLine());

    int[][] inputMatrix = new int[rows][];

    for (int row = 0; row < rows; row++) {
      int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
              .mapToInt(Integer::parseInt)
              .toArray();

      inputMatrix[row] = arr;
    }

    String[] coordinates = scanner.nextLine().split("\\s+");

    int x = Integer.parseInt(coordinates[0]);
    int y = Integer.parseInt(coordinates[1]);

    int wrongValue = inputMatrix[x][y];

    int[][] resultMatrix = new int[rows][];
    for (int i = 0; i < rows; i++) {
      resultMatrix[i] = inputMatrix[i].clone();
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < inputMatrix[row].length; col++) {
        if (resultMatrix[row][col] == wrongValue) {
          resultMatrix[row][col] = getSum(inputMatrix, row, col, wrongValue);
        }
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < resultMatrix[row].length; col++) {
        System.out.print(resultMatrix[row][col] + " ");
      }
      System.out.println();
    }
  }

  private static int getSum(int[][] inputMatrix, int row, int col, int wrongValue) {
    int sum = 0;
    if (row - 1 >= 0 && inputMatrix[row - 1][col] != wrongValue) {
      sum += inputMatrix[row - 1][col];
    }
    if (col - 1 >= 0 && inputMatrix[row][col - 1] != wrongValue) {
      sum += inputMatrix[row][col - 1];
    }
    if (row + 1 < inputMatrix.length && inputMatrix[row + 1][col] != wrongValue) {
      sum += inputMatrix[row + 1][col];
    }
    if (col + 1 < inputMatrix[row].length && inputMatrix[row][col + 1] != wrongValue) {
      sum += inputMatrix[row][col + 1];
    }
    return sum;
  }
}