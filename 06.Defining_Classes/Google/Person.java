package Google;

import java.util.ArrayList;

public class Person {
  private String name;
  private Company company;
  private Car car;
  private ArrayList<Pokemon> pokemons;
  private ArrayList<Parents> parents;
  private ArrayList<Children> children;

  public Person(String name) {
    this.name = name;
    this.pokemons = new ArrayList<>();
    this.parents = new ArrayList<>();
    this.children = new ArrayList<>();
  }

  public Person(String name, Company company) {
    this(name);
    this.company = company;
  }

  public Person(String name, Car car) {
    this(name);
    this.car = car;
  }

  public Person(String name, ArrayList<?> undefinedType, String typeOfParameter) {
    this(name);
    if (typeOfParameter.equals("pokemon")) {
      this.pokemons = (ArrayList<Pokemon>) undefinedType;
    } else if (typeOfParameter.equals("parents")) {
      this.parents = (ArrayList<Parents>) undefinedType;
    } else {
      this.children = (ArrayList<Children>) undefinedType;
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public void setPokemons(ArrayList<Pokemon> pokemons) {
    this.pokemons = pokemons;
  }


  public String getName() {
    return name;
  }

  public Company getCompany() {
    return company;
  }

  public Car getCar() {
    return car;
  }

  public ArrayList<Pokemon> getPokemons() {
    return this.pokemons;
  }

  public ArrayList<Parents> getParents() {
    return parents;
  }

  public void setParents(ArrayList<Parents> parents) {
    this.parents = parents;
  }

  public ArrayList<Children> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<Children> children) {
    this.children = children;
  }

  public String printPokemons(ArrayList<Pokemon> pokemons) {

    if (!pokemons.isEmpty()) {
      StringBuilder result = new StringBuilder();
      for (Pokemon pokemon : pokemons) {
        result.append(String.format("%s %s%n", pokemon.getPokemonName(), pokemon.getPokemonType()));
      }
      return result.toString();
    } else {
      return "";
    }
  }

  public String printParents(ArrayList<Parents> parents) {
    if (!parents.isEmpty()) {
      StringBuilder result = new StringBuilder();
      for (Parents parent : parents) {
        result.append(String.format("%s %s%n", parent.getParentName(), parent.getParentBirthday()));
      }
      return result.toString();
    } else {
      return "";
    }
  }

  public String printChildren(ArrayList<Children> children) {
    if (!children.isEmpty()) {
      StringBuilder result = new StringBuilder();
      for (Children child : children) {
        result.append(String.format("%s %s%n", child.getChildrenName(), child.getChildrenBirthday()));
      }
      return result.toString();
    } else {
      return "";
    }
  }

  public String printCompany(Company company) {
    String result = "";
    if (company != null) {
      return result = String.format("%s %s %.2f%n",
              getCompany().getCompanyName(), getCompany().getDepartment(), getCompany().getSalary());
    }
    return result;
  }

  public String printCar(Car car) {
    String result = "";
    if (car != null) {
      return result = String.format("%s %d%n", getCar().getCarModel(), getCar().getCarSpeed());
    }
    return result;
  }

  public String getInfo() {
    return String.format("%s%n" +
                    "Company:%n%s" +
                    "Car:%n%s" +
                    "Pokemon:%n%s" +
                    "Parents:%n%s" +
                    "Children:%n%s",
            getName(),
            printCompany(company),
            printCar(car),
            printPokemons(pokemons),
            printParents(parents),
            printChildren(children)
    );
  }
}
