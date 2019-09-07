package lab.maps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<String, LinkedHashMap<String, ArrayList<String>>> continentsWithCountries = new LinkedHashMap<>();

    int countOfInputs = Integer.parseInt(scanner.nextLine());

    while (countOfInputs > 0) {
      String[] input = scanner.nextLine().split("\\s+");

      String continent = input[0];
      String country = input[1];
      String city = input[2];

      if (!continentsWithCountries.containsKey(continent)) {
        LinkedHashMap<String, ArrayList<String>> countriesWithCities = new LinkedHashMap<>();
        countriesWithCities.put(country, new ArrayList<>());
        countriesWithCities.get(country).add(city);
        continentsWithCountries.put(continent, countriesWithCities);
      } else {
        if (!continentsWithCountries.get(continent).containsKey(country)) {
          ArrayList<String> cities = new ArrayList<>();
          cities.add(city);
          continentsWithCountries.get(continent).put(country, cities);
        } else {
          continentsWithCountries.get(continent).get(country).add(city);
        }
      }
      countOfInputs--;
    }

    for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> continent : continentsWithCountries
            .entrySet()) {
      System.out.println(String.format("%s:", continent.getKey()));
      continent.getValue()
              .forEach((key, value) -> {
                System.out.printf("\t%s -> ", key);
                System.out.println(String.join(", ", value));
              });
    }
  }
}