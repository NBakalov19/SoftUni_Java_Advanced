package exercise.theMatrix;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  private static char[][] matrix;
  private static char color;
  private static char tobeColored;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int[] rowCol = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    int rows = rowCol[0];
    int cols = rowCol[1];

    matrix = new char[rows][cols];

    for (int row = 0; row < rows; row++) {
      matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
    }

    color = scanner.nextLine().charAt(0);

    int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    int startRow = indexes[0];
    int startCol = indexes[1];

    tobeColored = matrix[startRow][startCol];

    paintMatrix(startRow, startCol);

//        ArrayDeque<int[]> stack = new ArrayDeque<>();
//
//        stack.push(new int[]{startRow, startCol});
//
//        while (!stack.isEmpty()) {
//            int[] elements = stack.pop();
//            int r = elements[0];
//            int c = elements[1];
//
//            matrix[r][c] = color;
//            if (!isOutOfRange(r + 1, c) && matrix[r + 1][c] == tobeColored && matrix[r + 1][c] != color) {
//                stack.push(new int[]{r + 1, c});
//            }
//            if (!isOutOfRange(r - 1, c) && matrix[r - 1][c] == tobeColored && matrix[r - 1][c] != color) {
//                stack.push(new int[]{r - 1, c});
//            }
//            if (!isOutOfRange(r, c + 1) && matrix[r][c + 1] == tobeColored && matrix[r][c + 1] != color) {
//                stack.push(new int[]{r, c + 1});
//            }
//            if (!isOutOfRange(r, c - 1) && matrix[r][c - 1] == tobeColored && matrix[r][c - 1] != color) {
//                stack.push(new int[]{r, c - 1 });
//            }
//        }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        System.out.print(matrix[row][col]);
      }
      System.out.println();
    }
  }

  private static void paintMatrix(int startRow, int startCol) {
    if (isOutOfRange(startRow, startCol) || matrix[startRow][startCol] == color
            || matrix[startRow][startCol] != tobeColored) {
      return;
    }

    matrix[startRow][startCol] = color;

    paintMatrix(startRow - 1, startCol);
    paintMatrix(startRow, startCol + 1);
    paintMatrix(startRow + 1, startCol);
    paintMatrix(startRow, startCol - 1);
  }

  private static boolean isOutOfRange(int row, int col) {
    return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
  }
}