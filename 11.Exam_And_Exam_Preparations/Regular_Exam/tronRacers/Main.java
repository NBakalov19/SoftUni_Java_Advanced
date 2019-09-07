package regularExam.tronRacers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static final char FIRST_PLAYER_CHARACTER = 'f';
  private static final char SECOND_PLAYER_CHARACTER = 's';

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int sizeOfField = Integer.parseInt(reader.readLine());

    char[][] field = new char[sizeOfField][sizeOfField];

    readField(reader, field);
    int[] firstPlayerPosition = getPlayerPosition(field, FIRST_PLAYER_CHARACTER);
    int[] secondPlayerPosition = getPlayerPosition(field, SECOND_PLAYER_CHARACTER);

    boolean firstIsAlive = true;
    boolean secondIsAlive = true;

    while (secondIsAlive) {
      String[] directions = reader.readLine().split("\\s+");
      firstIsAlive = playerMovement(field, directions[0], firstPlayerPosition, FIRST_PLAYER_CHARACTER);
      if (!firstIsAlive) {
        break;
      }
      secondIsAlive = playerMovement(field, directions[1], secondPlayerPosition, SECOND_PLAYER_CHARACTER);

    }

    printField(field);
  }

  private static void printField(char[][] field) {
    for (char[] chars : field) {
      for (int col = 0; col < field.length; col++) {
        System.out.print(chars[col]);
      }
      System.out.println();
    }
  }


  private static boolean playerMovement(char[][] field, String direction, int[] playerPosition, char playerCharacter) {

    int playerNextRow = playerPosition[0];
    int playerNextCol = playerPosition[1];

    switch (direction) {
      case "up":
        if (playerNextRow == 0) {
          playerNextRow = field.length - 1;
        } else {
          playerNextRow -= 1;
        }
        break;
      case "down":
        if (playerNextRow == field.length - 1) {
          playerNextRow = 0;
        } else {
          playerNextRow += 1;
        }
        break;
      case "left":
        if (playerNextCol == 0) {
          playerNextCol = field.length - 1;
        } else {
          playerNextCol -= 1;
        }
        break;
      case "right":
        if (playerNextCol == field.length - 1) {
          playerNextCol = 0;
        } else {
          playerNextCol += 1;
        }
        break;
      default:
        break;
    }

    if ((field[playerNextRow][playerNextCol] == SECOND_PLAYER_CHARACTER
            && playerCharacter == FIRST_PLAYER_CHARACTER) ||
            (field[playerNextRow][playerNextCol] == FIRST_PLAYER_CHARACTER
                    && playerCharacter == SECOND_PLAYER_CHARACTER)) {
      field[playerNextRow][playerNextCol] = 'x';
      return false;
    }
    field[playerNextRow][playerNextCol] = playerCharacter;
    playerPosition[0] = playerNextRow;
    playerPosition[1] = playerNextCol;
    return true;
  }


  private static int[] getPlayerPosition(char[][] field, char playerCharacter) {
    int[] playerPosition = new int[2];

    for (int fieldRow = 0; fieldRow < field.length; fieldRow++) {
      for (int fieldCol = 0; fieldCol < field.length; fieldCol++) {
        if (field[fieldRow][fieldCol] == playerCharacter) {
          playerPosition[0] = fieldRow;
          playerPosition[1] = fieldCol;
        }
      }
    }
    return playerPosition;
  }

  private static void readField(BufferedReader reader, char[][] field) throws IOException {

    for (int row = 0; row < field.length; row++) {
      field[row] = reader.readLine().toCharArray();
    }
  }
}
