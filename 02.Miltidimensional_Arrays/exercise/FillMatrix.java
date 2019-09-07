package exercise;

import java.util.Scanner;

public class FillMatrix {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split(", ");

    int size = Integer.parseInt(input[0]);
    String option = input[1];

    int[][] matrix = fillMatrix(size, option);

    printMatrix(matrix);
  }

  private static void printMatrix(int[][] matrix) {

    for (int row = 0; row < matrix.length; row++) {
      for (int[] ints : matrix) {
        System.out.print(ints[row] + " ");
      }
      System.out.println();
    }

  }

  private static int[][] fillMatrix(int size, String option) {
    int[][] matrix = new int[size][size];
    int value = 0;

    switch (option) {
      case "A":
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            matrix[i][j] = ++value;
          }
        }
        break;
      case "B":
        for (int i = 0; i < size; i++) {
          if (i % 2 == 0) {
            for (int j = 0; j < size; j++) {
              matrix[i][j] = ++value;
            }
          } else {
            for (int j = size - 1; j >= 0; j--) {
              matrix[i][j] = ++value;
            }
          }
        }
        break;
      default:
        break;
    }

    return matrix;
  }

}
