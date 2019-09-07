package GenericCountString;

import GenericBox.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    ArrayList<Box<Double>> boxArrayList = new ArrayList<>();
    Box<Double> box;
    while (n > 0) {
      double numbers = Double.parseDouble(scanner.nextLine());
      box = new Box<>(numbers);
      boxArrayList.add(box);
      n--;
    }

    double numbers = Double.parseDouble(scanner.nextLine());
    Box<Double> compareBox = new Box<>(numbers);

    System.out.println(countGreaterValues(boxArrayList, compareBox));
  }

  private static <T extends Comparable<T>> int countGreaterValues(List<Box<T>> list, Box<T> box) {
    int counter = 0;
    for (Box<T> tBox : list) {
      if (tBox.compareTo(box) > 0) {
        counter++;
      }
    }
    return counter;
  }
}
