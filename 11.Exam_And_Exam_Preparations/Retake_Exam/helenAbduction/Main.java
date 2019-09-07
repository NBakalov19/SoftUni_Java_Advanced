package retake.helenAbduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int energyOfParis = Integer.parseInt(reader.readLine());
    int fieldSize = Integer.parseInt(reader.readLine());
    char[][] field = new char[fieldSize][fieldSize];
    int[] parisPosition = new int[2];
    int[] helenPosition = new int[2];

    for (int row = 0; row < fieldSize; row++) {
      String line = reader.readLine();
      field[row] = line.toCharArray();

      if (line.contains("P")) {
        parisPosition[0] = row;
        parisPosition[1] = line.indexOf("P");
      }

      if (line.contains("H")) {
        helenPosition[0] = row;
        helenPosition[1] = line.indexOf("H");
      }
    }

    while (energyOfParis != 0) {
      String[] input = reader.readLine().split("\\s+");
      String command = input[0];
      int[] enemyPosition = new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])};
      field[enemyPosition[0]][enemyPosition[1]] = 'S';

      energyOfParis = energyOfParisAfterMovement(field, parisPosition, command, energyOfParis);
      if (parisReachHelen(parisPosition, helenPosition)) {
        field[parisPosition[0]][parisPosition[1]] = '-';
        break;
      }
      if (energyOfParis == 0) {
        field[parisPosition[0]][parisPosition[1]] = 'X';
      }
    }

    if (parisReachHelen(parisPosition, helenPosition)) {
      System.out.println(String.format("Paris has successfully abducted Helen! Energy left: %d", energyOfParis));
    } else {
      System.out.println(String.format("Paris died at %d;%d.", parisPosition[0], parisPosition[1]));
    }

    for (char[] chars : field) {
      for (char aChar : chars) {
        System.out.print(aChar);
      }
      System.out.println();
    }
  }

  private static int energyOfParisAfterMovement(char[][] field, int[] parisPosition, String command, int energyOfParis) {
    int energyAfterMovement = energyOfParis;
    energyAfterMovement -= 1;
    switch (command) {
      case "up":
        if (parisPosition[0] != 0) {
          field[parisPosition[0]--][parisPosition[1]] = '-';
          energyAfterMovement = fightEnemy(field, parisPosition, energyAfterMovement);
        }
        break;
      case "down":
        if (parisPosition[0] != field.length - 1) {
          field[parisPosition[0]++][parisPosition[1]] = '-';
          energyAfterMovement = fightEnemy(field, parisPosition, energyAfterMovement);
        }
        break;
      case "left":
        if (parisPosition[1] != 0) {
          field[parisPosition[0]][parisPosition[1]--] = '-';
          energyAfterMovement = fightEnemy(field, parisPosition, energyAfterMovement);
        }
        break;
      case "right":
        if (parisPosition[1] != field.length - 1) {
          field[parisPosition[0]][parisPosition[1]++] = '-';
          energyAfterMovement = fightEnemy(field, parisPosition, energyAfterMovement);
        }
        break;
    }

    return energyAfterMovement;
  }

  private static int fightEnemy(char[][] field, int[] parisPosition, int energyOfParis) {

    if (haveEnemy(parisPosition, field)) {
      energyOfParis -= 2;
      if (energyOfParis <= 0) {
        field[parisPosition[0]][parisPosition[1]] = 'X';
      } else {
        field[parisPosition[0]][parisPosition[1]] = 'P';
      }
    } else {
      field[parisPosition[0]][parisPosition[1]] = 'P';
    }
    return energyOfParis;
  }

  private static boolean haveEnemy(int[] parisPosition, char[][] field) {
    return field[parisPosition[0]][parisPosition[1]] == 'S';
  }

  private static boolean parisReachHelen(int[] parisPosition, int[] helenPosition) {
    return parisPosition[0] == helenPosition[0] && parisPosition[1] == helenPosition[1];
  }
}