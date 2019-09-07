package lab.maps;

import java.util.*;

public class ProductShop {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<String, LinkedHashMap<String, Double>> supermarkets = new TreeMap<>();

    String[] input = scanner.nextLine().split(", ");

    while (!input[0].equals("Revision")) {

      String shop = input[0];
      String product = input[1];
      double price = Double.parseDouble(input[2]);

      if (!supermarkets.containsKey(shop)) {
        LinkedHashMap<String, Double> tempMap = new LinkedHashMap<>();
        tempMap.put(product, price);
        supermarkets.put(shop, tempMap);
      } else {
        if (!supermarkets.get(shop).containsKey(product)) {
          supermarkets.get(shop).put(product, price);
        }
      }
      input = scanner.nextLine().split(", ");
    }

    supermarkets
            .forEach((key, value) -> {
              System.out.println(String.format("%s->", key));
              value.forEach((key1, value1) -> System.out.println(
                      String.format("Product: %s, Price: %.1f", key1
                              , value1)));
            });
  }
}