package lab;

import java.util.Scanner;

public class PositionOf {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] rowsCols = scanner.nextLine().split("\\s+");
    int rows = Integer.parseInt(rowsCols[0]);
    int cols = Integer.parseInt(rowsCols[1]);

    int[][] matrix = new int[rows][cols];

    for (int row = 0; row < rows; row++) {
      String[] columns = scanner.nextLine().split("\\s+");
      for (int column = 0; column < cols; column++) {
        matrix[row][column] = Integer.parseInt(columns[column]);
      }
    }

    int numberForSearch = Integer.parseInt(scanner.nextLine());

    boolean isFound = false;
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < cols; column++) {
        if (numberForSearch == matrix[row][column]) {
          System.out.println(String.format("%d %d", row, column));
          isFound = true;
        }
      }
    }
    if (!isFound) {
      System.out.println("not found");
    }
  }
}