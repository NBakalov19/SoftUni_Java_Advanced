package sneaking;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int fieldRows = Integer.parseInt(scanner.nextLine());

    char[][] field = new char[fieldRows][];

    int[] nikolaPosition = new int[2];
    int[] samPosition = new int[2];

    for (int i = 0; i < fieldRows; i++) {
      String line = scanner.nextLine();
      field[i] = line.toCharArray();

      if (line.contains("N")) {
        nikolaPosition[0] = i;
        nikolaPosition[1] = line.indexOf("N");
      }

      if (line.contains("S")) {
        samPosition[0] = i;
        samPosition[1] = line.indexOf("S");
      }

    }

    String commandsArgs = scanner.nextLine();

    for (int i = 0; i < commandsArgs.length(); i++) {

      enemiesMovements(field);

      boolean samIsDead = isSamDead(field, samPosition);
      if (samIsDead) {
        field[samPosition[0]][samPosition[1]] = 'X';
        System.out.printf("Sam died at %d, %d%n", samPosition[0], samPosition[1]);
        break;
      } else {
        samMovements(field, samPosition, commandsArgs.charAt(i));
      }

      if (nikolaPosition[0] == samPosition[0]) {
        System.out.println("Nikoladze killed!");
        field[nikolaPosition[0]][nikolaPosition[1]] = 'X';
        break;
      }
    }

    for (char[] chars : field) {
      for (char aChar : chars) {
        System.out.print(aChar);
      }
      System.out.println();
    }
  }

  private static void samMovements(char[][] field, int[] samPosition, char command) {

    switch (command) {
      case 'U':
        field[samPosition[0]--][samPosition[1]] = '.';
        field[samPosition[0]][samPosition[1]] = 'S';
        break;
      case 'R':
        field[samPosition[0]][samPosition[1]++] = '.';
        field[samPosition[0]][samPosition[1]] = 'S';
        break;
      case 'D':
        field[samPosition[0]++][samPosition[1]] = '.';
        field[samPosition[0]][samPosition[1]] = 'S';
        break;
      case 'L':
        field[samPosition[0]][samPosition[1]--] = '.';
        field[samPosition[0]][samPosition[1]] = 'S';
        break;
      default:
        break;
    }
  }

  private static boolean isSamDead(char[][] field, int[] samPosition) {
    boolean heIsDead = false;
    for (int i = 0; i < samPosition[1]; i++) {
      if (field[samPosition[0]][i] == 'b') {
        heIsDead = true;
        break;
      }
    }

    for (int i = samPosition[1] + 1; i < field[samPosition[0]].length; i++) {
      if (field[samPosition[0]][i] == 'd') {
        heIsDead = true;
        break;
      }
    }

    return heIsDead;
  }

  private static void enemiesMovements(char[][] field) {

    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[i].length; j++) {
        if (field[i][j] == 'b') {
          if (j == field[i].length - 1) {
            field[i][j] = 'd';
          } else {
            field[i][j] = '.';
            field[i][j + 1] = 'b';
            break;
          }
        } else if (field[i][j] == 'd') {
          if (j == 0) {
            field[i][j] = 'b';
          } else {
            field[i][j] = '.';
            field[i][j - 1] = 'd';
            break;
          }
        }
      }
    }
  }
}