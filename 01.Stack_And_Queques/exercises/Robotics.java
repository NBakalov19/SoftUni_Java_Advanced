package exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] robotData = scanner.nextLine().split(";");

    String[] robots = new String[robotData.length];
    int[] workingTime = new int[robotData.length];
    int[] processTime = new int[robotData.length];

    for (int i = 0; i < robotData.length; i++) {
      robots[i] = robotData[i].split("-")[0];
      workingTime[i] = Integer.parseInt(robotData[i].split("-")[1]);
    }

    String[] timeData = scanner.nextLine().split(":");

    int hours = Integer.parseInt(timeData[0]);
    int minutes = Integer.parseInt(timeData[1]);
    int seconds = Integer.parseInt(timeData[2]);

    int StartTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

    int time = 0;

    ArrayDeque<String> products = new ArrayDeque<>();

    String currentProduct = scanner.nextLine();

    while (!currentProduct.equals("End")) {
      products.offer(currentProduct);
      currentProduct = scanner.nextLine();
    }

    while (!products.isEmpty()) {
      time++;
      String product = products.poll();
      boolean isAssigned = false;

      for (int i = 0; i < robots.length; i++) {
        if (processTime[i] == 0 && !isAssigned) {
          processTime[i] = workingTime[i];
          printAssignedRobot(robots[i], StartTimeInSeconds + time, product);
          isAssigned = true;
        }
        if (processTime[i] > 0) {
          processTime[i]--;
        }
      }
      if (!isAssigned) {
        products.offer(product);
      }
    }
  }

  private static void printAssignedRobot(String robot, int time, String product) {
    int s = time % 60;
    int m = (time / 60) % 60;
    int h = (time / (60 * 60)) % 24;

    System.out.println(String.format("%s - %s [%02d:%02d:%02d]", robot, product, h, m, s));
  }
}