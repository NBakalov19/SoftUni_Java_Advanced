package lab;

import java.util.Scanner;

public class CompareMatrix {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int[][] firstMatrix = readMatrix(scanner);
    int[][] secondMatrix = readMatrix(scanner);

    if (firstMatrix.length != secondMatrix.length ||
            firstMatrix[0].length != secondMatrix[0].length) {
      System.out.println("not equal");
      return;
    }

    for (int row = 0; row < firstMatrix.length; row++) {
      for (int col = 0; col < firstMatrix[row].length; col++) {
        if (firstMatrix[row][col] != secondMatrix[row][col]) {
          System.out.println("not equal");
          return;
        }
      }
    }
    System.out.println("equal");
  }

  private static int[][] readMatrix(Scanner scanner) {

    String[] rowsCols = scanner.nextLine().split("\\s+");
    int rows = Integer.parseInt(rowsCols[0]);
    int cols = Integer.parseInt(rowsCols[1]);

    int[][] matrix = new int[rows][cols];

    for (int row = 0; row < rows; row++) {
      String[] colsInput = scanner.nextLine().split("\\s+");

//            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//            matrix[row] = arr;

      for (int col = 0; col < cols; col++) {
        matrix[row][col] = Integer.parseInt(colsInput[col]);
      }
    }
    return matrix;
  }
}
