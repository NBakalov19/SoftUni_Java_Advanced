package exercise;

import java.util.Scanner;

public class MatrixShuffling {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] rowCol = scanner.nextLine().split("\\s+");

    String[][] matrix = fillMatrix(rowCol, scanner);
    String[] command = scanner.nextLine().split("\\s+");

    while (!command[0].equals("END")) {

      if (!command[0].equals("swap") || command.length != 5) {
        System.out.println("Invalid input!");
      } else {
        int rowFirstIndex = Integer.parseInt(command[1]);
        int colFirstIndex = Integer.parseInt(command[2]);
        int rowSecondIndex = Integer.parseInt(command[3]);
        int colSecondIndex = Integer.parseInt(command[4]);
        if (rowFirstIndex >= 0 && rowFirstIndex < matrix.length
                && rowSecondIndex >= 0 && rowSecondIndex < matrix.length
                && colFirstIndex >= 0 && colFirstIndex < matrix[0].length
                && colSecondIndex >= 0 && colSecondIndex < matrix[0].length) {

          String temp = matrix[rowFirstIndex][colFirstIndex];
          matrix[rowFirstIndex][colFirstIndex] = matrix[rowSecondIndex][colSecondIndex];
          matrix[rowSecondIndex][colSecondIndex] = temp;

            for (String[] strings : matrix) {
                for (int col = 0; col < matrix[0].length; col++) {
                    System.out.print(strings[col] + " ");
                }
                System.out.println();
            }
        } else {
          System.out.println("Invalid input!");
        }
      }
      command = scanner.nextLine().split("\\s+");
    }
  }

  private static String[][] fillMatrix(String[] rowCol, Scanner scanner) {

    int rows = Integer.parseInt(rowCol[0]);
    int cols = Integer.parseInt(rowCol[1]);

    String[][] matrix = new String[rows][cols];

    for (int row = 0; row < matrix.length; row++) {
      matrix[row] = scanner.nextLine().split("\\s+");
    }
    return matrix;
  }
}
