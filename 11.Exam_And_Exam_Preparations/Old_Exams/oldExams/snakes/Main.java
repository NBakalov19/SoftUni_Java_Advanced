package oldExams.snakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static int snakeLength;
  private static int foodCount;

  static {
    snakeLength = 1;
    foodCount = 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int screenSide = Integer.parseInt(reader.readLine());
    char[][] screen = new char[screenSide][];
    String[] commands = reader.readLine().split(", ");
    loadScreen(screen, screenSide, reader);

    int[] snakePosition = getPositionOfGameSnake(screen);
    foodCount = getFoodInTheGame(screen);

    String resultOfGame = executeGame(snakePosition, commands, screen);
    System.out.println(resultOfGame);
  }

  private static int getFoodInTheGame(char[][] screen) {
    int food = 0;
    for (char[] chars : screen) {
      for (char aChar : chars) {
        if (aChar == 'f') {
          food += 1;
        }
      }
    }
    return food;
  }

  private static String executeGame(int[] snakePosition, String[] commands, char[][] screen) {
    String output = String.format("You lose! There is still %d food to be eaten.", snakeLength);
    for (String command : commands) {
      boolean snakeIsAlive = true;
      switch (command) {
        case "up":
          snakeIsAlive = moveSnakeUp(screen, snakePosition);
          break;
        case "right":
          snakeIsAlive = moveSnakeRight(screen, snakePosition);
          break;
        case "down":
          snakeIsAlive = moveSnakeDown(screen, snakePosition);
          break;
        case "left":
          snakeIsAlive = moveSnakeLeft(screen, snakePosition);
          break;
      }
      if (!snakeIsAlive) {
        output = "You lose! Killed by an enemy!";
        break;
      }
      if (foodCount == 0) {
        output = String.format("You win! Final snake length is %d", snakeLength);
        break;
      }
    }
    return output;
  }

  private static boolean moveSnakeUp(char[][] screen, int[] snakePosition) {
    boolean snakeIsAlive = true;
    if (snakePosition[0] == 0) {
      snakePosition[0] = screen.length - 1;
    } else {
      snakePosition[0]--;
    }

    if (screen[snakePosition[0]][snakePosition[1]] == 'f') {
      snakeLength++;
      foodCount -= 1;
    } else if (screen[snakePosition[0]][snakePosition[1]] == 'e') {
      snakeIsAlive = false;
    }
    return snakeIsAlive;
  }

  private static boolean moveSnakeRight(char[][] screen, int[] snakePosition) {
    boolean snakeIsAlive = true;
    if (snakePosition[1] == screen.length - 1) {
      snakePosition[1] = 0;
    } else {
      snakePosition[1]++;
    }

    if (screen[snakePosition[0]][snakePosition[1]] == 'f') {
      snakeLength++;
      foodCount -= 1;
    } else if (screen[snakePosition[0]][snakePosition[1]] == 'e') {
      snakeIsAlive = false;
    }
    return snakeIsAlive;
  }

  private static boolean moveSnakeDown(char[][] screen, int[] snakePosition) {
    boolean snakeIsAlive = true;
    if (snakePosition[0] == screen.length - 1) {
      snakePosition[0] = 0;
    } else {
      snakePosition[0]++;
    }

    if (screen[snakePosition[0]][snakePosition[1]] == 'f') {
      snakeLength++;
      foodCount -= 1;
    } else if (screen[snakePosition[0]][snakePosition[1]] == 'e') {
      snakeIsAlive = false;
    }
    return snakeIsAlive;
  }

  private static boolean moveSnakeLeft(char[][] screen, int[] snakePosition) {
    boolean snakeIsAlive = true;
    if (snakePosition[1] == 0) {
      snakePosition[1] = screen.length - 1;
    } else {
      snakePosition[1]--;
    }

    if (screen[snakePosition[0]][snakePosition[1]] == 'f') {
      snakeLength++;
      foodCount -= 1;
    } else if (screen[snakePosition[0]][snakePosition[1]] == 'e') {
      snakeIsAlive = false;
    }
    return snakeIsAlive;
  }

  private static int[] getPositionOfGameSnake(char[][] screen) {
    int[] snakePosition = new int[2];

    for (int i = 0; i < screen.length; i++) {
      for (int j = 0; j < screen[i].length; j++) {
        if (screen[i][j] == 's') {
          snakePosition[0] = i;
          snakePosition[1] = j;
        }
      }
    }

    return snakePosition;
  }

  private static void loadScreen(char[][] screen, int screenSide, BufferedReader reader) throws IOException {
    for (int i = 0; i < screenSide; i++) {
      String line = reader.readLine().replaceAll("\\s+", "");
      screen[i] = line.toCharArray();
    }
  }
}
