package lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrix {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int rows = Integer.parseInt(scanner.nextLine());
    int cols = Integer.parseInt(scanner.nextLine());


    char[][] firstMatrix = readMatrix(scanner, rows, cols);
    char[][] secondMatrix = readMatrix(scanner, rows, cols);

    for (int row = 0; row < firstMatrix.length; row++) {
      for (int column = 0; column < firstMatrix[0].length; column++) {
        if (firstMatrix[row][column] == secondMatrix[row][column]) {
          System.out.print(firstMatrix[row][column] + " ");
        } else {
          System.out.print("* ");
        }
      }
      System.out.println();
    }

  }

  private static char[][] readMatrix(Scanner scanner, int rows, int cols) {

    char[][] matrix = new char[rows][cols];

    for (char row = 0; row < rows; row++) {
      String[] colsInput = scanner.nextLine().split("\\s+");
      for (int col = 0; col < cols; col++) {
        matrix[row][col] = (colsInput[col].charAt(0));
      }
    }
    return matrix;
  }
}