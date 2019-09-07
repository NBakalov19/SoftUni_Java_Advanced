package exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] rotateData = scanner.nextLine().split("[()]+");
    int rotateAngle = Integer.parseInt(rotateData[1]) % 360;

    ArrayList<String> inputString = new ArrayList<>();

    String line = scanner.nextLine();
    int maxLength = line.length();

    while (!line.equals("END")) {
      inputString.add(line);
      line = scanner.nextLine();
      if (maxLength < line.length()) {
        maxLength = line.length();
      }
    }

    char[][] matrix = new char[inputString.size()][maxLength];

    for (int r = 0; r < inputString.size(); r++) {
      for (int c = 0; c < maxLength; c++) {
        if (c > inputString.get(r).length() - 1) {
          matrix[r][c] = ' ';
        } else {
          matrix[r][c] = inputString.get(r).charAt(c);
        }
      }
    }

    printRotatedMatrix(matrix, maxLength, rotateAngle);
  }

  private static void printRotatedMatrix(char[][] matrix, int maxLength, int rotateAngle) {
    if (rotateAngle == 90) {
      for (int c = 0; c < maxLength; c++) {
        for (int r = matrix.length - 1; r >= 0; r--) {
          System.out.print(matrix[r][c]);
        }
        System.out.println();
      }
    } else if (rotateAngle == 180) {
      for (int r = matrix.length - 1; r >= 0; r--) {
        for (int c = maxLength - 1; c >= 0; c--) {
          System.out.print(matrix[r][c]);
        }
        System.out.println();
      }
    } else if (rotateAngle == 270) {
      for (int c = maxLength - 1; c >= 0; c--) {
        for (char[] chars : matrix) {
          System.out.print(chars[c]);
        }
        System.out.println();
      }
    } else {
      for (char[] chars : matrix) {
        for (int c = 0; c < maxLength; c++) {
          System.out.print(chars[c]);
        }
        System.out.println();
      }
    }
  }
}