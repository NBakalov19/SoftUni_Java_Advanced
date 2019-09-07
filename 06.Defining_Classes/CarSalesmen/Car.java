package CarSalesmen;

public class Car {
  private String model;
  private Engine engine;
  private String weight;
  private String color;
  public static final String UNDEFINED_VALUE = "n/a";

  public Car(String model, Engine engine) {
    this.model = model;
    this.engine = new Engine(engine.getModel(), engine.getPower(),
            engine.getDisplacement(), engine.getEfficiency());
    this.weight = UNDEFINED_VALUE;
    this.color = UNDEFINED_VALUE;
  }

  public Car(String model, Engine engine, String unknownType) {
    this(model, engine);
    if (isNumber(unknownType)) {
      this.weight = unknownType;
    } else {
      this.color = unknownType;
    }
  }


  public Car(String model, Engine engine, String weight, String color) {
    this(model, engine);
    this.weight = weight;
    this.color = color;
  }

  public String getModel() {
    return model;
  }

  public Engine getEngine() {
    return engine;
  }

  public String getColor() {
    return this.color;
  }

  public String getWeight() {
    return this.weight;
  }

  public String carInfo() {
    return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s",
            getModel(),
            getEngine().getModel(),
            getEngine().getPower(),
            getEngine().getDisplacement(),
            getEngine().getEfficiency(),
            getWeight(),
            getColor());
  }

  public static boolean isNumber(String unknownType) {
    try {
      Integer.parseInt(unknownType);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
