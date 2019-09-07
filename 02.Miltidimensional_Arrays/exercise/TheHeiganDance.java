package exercise;

import java.util.Scanner;

public class TheHeiganDance {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double damageToHeigan = Double.parseDouble(scanner.nextLine());
    int[][] chamber = new int[15][15];

    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        chamber[i][j] = 0;
      }
    }

    int playerRow = 7;
    int playerCol = 7;

    double heiganBlood = 3000000d;
    int playerBlood = 18500;

    String lastSpell = "";
    String lastOutcome = "";

    while (heiganBlood > 0 && playerBlood > 0) {
      heiganBlood -= damageToHeigan;

      if (heiganBlood <= 0) {
        break;
      }

      if (lastSpell.equals("Cloud") && lastOutcome.equals("Hit")) {
        playerBlood -= 3500;
        if (playerBlood <= 0) {
          break;
        }
      }

      String[] round = scanner.nextLine().split("\\s+");

      String spell = round[0];
      int spellRow = Integer.parseInt(round[1]);
      int spellCol = Integer.parseInt(round[2]);

      chamber = matrixSpell(chamber, spellRow, spellCol, 1);

      if (chamber[playerRow][playerCol] == 1) {
        String outcome = escapedTheHit(chamber, playerRow, playerCol);
        lastOutcome = outcome;
        switch (outcome) {
          case "Hit":
            if (spell.equals("Cloud")) {
              playerBlood -= 3500;
            } else {
              playerBlood -= 6000;
            }
            break;
          case "Up":
            playerRow--;
            break;
          case "Right":
            playerCol++;
            break;
          case "Down":
            playerRow++;
            break;
          case "Left":
            playerCol--;
            break;
          default:
            break;
        }
      }

      lastSpell = spell;

      chamber = matrixSpell(chamber, spellRow, spellCol, 0);

      if (playerBlood <= 0) {
        break;
      }
    }

    // PRINT

    if (lastSpell.equals("Cloud")) {
      lastSpell = "Plague Cloud";
    }

    System.out.print("Heigan: ");

    if (heiganBlood <= 0) {
      System.out.println("Defeated!");
    } else {
      System.out.printf("%.2f\n", heiganBlood);
    }

    System.out.print("Player: ");

    if (playerBlood <= 0) {
      System.out.printf("Killed by %s\n", lastSpell);
    } else {
      System.out.println(playerBlood);
    }

    System.out.println("Final position: " + playerRow + ", " + playerCol);

  }

  private static int[][] matrixSpell(int[][] field, int spellRow, int spellCol, int spell) {
    for (int i = Math.max(0, spellRow - 1); i < Math.min(field.length, spellRow + 2); i++) {
      for (int j = Math.max(0, spellCol - 1); j < Math.min(field[i].length, spellCol + 2); j++) {
        field[i][j] = spell;
      }
    }
    return field;
  }

  private static String escapedTheHit(int[][] field, int playerRow, int playerCol) {
    if (playerRow > 0) {
      if (field[playerRow - 1][playerCol] != 1) {
        return "Up";
      }
    }

    if (playerCol < 14) {
      if (field[playerRow][playerCol + 1] != 1) {
        return "Right";
      }
    }
    if (playerRow < 14) {
      if (field[playerRow + 1][playerCol] != 1) {
        return "Down";
      }
    }
    if (playerCol > 0) {
      if (field[playerRow][playerCol - 1] != 1) {
        return "Left";
      }
    }

    return "Hit";
  }
}