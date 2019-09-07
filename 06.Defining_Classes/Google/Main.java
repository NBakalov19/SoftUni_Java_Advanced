package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] tokens = scanner.nextLine().split("\\s+");
    Person person;
    Map<String, Person> google = new HashMap<>();

    while (!tokens[0].equals("End")) {
      String name = tokens[0];
      String typeInfo = tokens[1];

      switch (typeInfo) {
        case "company":
          String companyName = tokens[2];
          String department = tokens[3];
          double salary = Double.parseDouble(tokens[4]);

          Company company = new Company(companyName, department, salary);

          person = new Person(name, company);

          google.putIfAbsent(name, person);
          google.get(name).setCompany(company);
          break;
        case "pokemon":
          String pokemonName = tokens[2];
          String pokemonType = tokens[3];
          Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
          ArrayList<Pokemon> pokemons = new ArrayList<>();
          person = new Person(name, pokemons, typeInfo);

          google.putIfAbsent(name, person);
          google.get(name).getPokemons().add(pokemon);
          break;
        case "parents":
          String parentName = tokens[2];
          String parentBirthday = tokens[3];

          Parents parents = new Parents(parentName, parentBirthday);
          ArrayList<Parents> parent = new ArrayList<>();
          person = new Person(name, parent, typeInfo);

          google.putIfAbsent(name, person);
          google.get(name).getParents().add(parents);
          break;
        case "children":
          String childrenName = tokens[2];
          String childrenBirthday = tokens[3];

          Children children = new Children(childrenName, childrenBirthday);
          ArrayList<Children> child = new ArrayList<>();
          person = new Person(name, child, typeInfo);

          google.putIfAbsent(name, person);
          google.get(name).getChildren().add(children);
          break;
        default:
          String carModel = tokens[2];
          int carSpeed = Integer.parseInt(tokens[3]);

          Car car = new Car(carModel, carSpeed);
          person = new Person(name, car);

          google.putIfAbsent(name, person);
          google.get(name).setCar(car);
          break;
      }

      tokens = scanner.nextLine().split("\\s+");
    }

    String checkName = scanner.nextLine();

    System.out.println(google.get(checkName).getInfo());
  }
}