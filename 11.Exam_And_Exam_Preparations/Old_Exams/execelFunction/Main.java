package execelFunction;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int rowCount = Integer.parseInt(scanner.nextLine());

    String[][] matrix = new String[rowCount][];

    for (int i = 0; i < rowCount; i++) {
      matrix[i] = scanner.nextLine().split(", ");
    }

    String[] commandsArgs = scanner.nextLine().split("\\s+");

    if (commandsArgs[0].equals("hide")) {
      hideAndPrint(matrix, commandsArgs[1]);
    } else if (commandsArgs[0].equals("sort")) {
      sortByColumnAndPrint(matrix, commandsArgs[1]);
    } else {
      filterByColumnAndPrint(matrix, commandsArgs[1], commandsArgs[2]);
    }
  }

  private static void filterByColumnAndPrint(String[][] matrix, String filterColumn, String filterValue) {
    int filterColumnIndex = getColumnIndex(matrix[0], filterColumn);

    System.out.println(String.join(" | ", matrix[0]));
    for (String[] strings : matrix) {
      if (strings[filterColumnIndex].equals(filterValue)) {
        System.out.println(String.join(" | ", strings));
      }
    }
  }

  private static void sortByColumnAndPrint(String[][] matrix, String sortColumnName) {
    int sortColumnIndex = getColumnIndex(matrix[0], sortColumnName);

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 1; j < matrix.length - 1 - i; j++) {
        if (matrix[j][sortColumnIndex].compareTo(matrix[j + 1][sortColumnIndex]) > 0) {
          String[] temp = matrix[j];
          matrix[j] = matrix[j + 1];
          matrix[j + 1] = temp;
        }
      }
    }
    for (String[] strings : matrix) {
      for (int j = 0; j < strings.length; j++) {
        System.out.print(strings[j]);
        if (j != strings.length - 1) {
          System.out.print(" | ");
        }
      }
      System.out.println();
    }
  }

  private static void hideAndPrint(String[][] matrix, String hiddenColumn) {
    int hiddenColumnIndex = getColumnIndex(matrix[0], hiddenColumn);

    for (String[] strings : matrix) {
      for (int j = 0; j < strings.length; j++) {
        if (j == hiddenColumnIndex) {
          continue;
        }
        System.out.print(strings[j]);
        if (j < strings.length - 1) {
          if (hiddenColumnIndex != strings.length - 1 || j != strings.length - 2) {
            System.out.print(" | ");
          }
        }
      }
      System.out.println();
    }
  }

  private static int getColumnIndex(String[] matrix, String hiddenColumn) {
    int index = -1;

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i].equals(hiddenColumn)) {
        index = i;
        break;
      }
    }
    return index;
  }
}