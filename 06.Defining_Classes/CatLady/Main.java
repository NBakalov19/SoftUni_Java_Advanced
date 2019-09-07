package CatLady;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    ArrayList<Cat> cats = new ArrayList<>();
    Cat cat;
    while (!input.equals("End")) {
      String[] tokens = input.split("\\s+");
      String breed = tokens[0];
      String name = tokens[1];
      double param = Double.parseDouble(tokens[2]);

      switch (breed) {
        case "Siamese":
          cat = new Siamese(name, param);
          break;
        case "Cymric":
          cat = new Cymric(name, param);
          break;
        default:
          cat = new StreetExtraordinaire(name, param);
          break;
      }

      cats.add(cat);
      input = scanner.nextLine();
    }

    String name = scanner.nextLine();

    for (Cat kitten : cats) {
      if (kitten.getName().equals(name)) {
        System.out.println(kitten.toString());
      }
    }
  }
}