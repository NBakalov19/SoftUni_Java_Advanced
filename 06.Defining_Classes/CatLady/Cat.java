package CatLady;

public abstract class Cat {
  private String name;

  public String getName() {
    return name;
  }

  public Cat(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " " + this.getName();
  }
}