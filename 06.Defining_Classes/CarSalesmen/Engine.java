package CarSalesmen;

public class Engine {
  private String model;
  private int power;
  private String displacement;
  private String efficiency;

  public String getModel() {
    return model;
  }

  public String getDisplacement() {
    return displacement;
  }

  public int getPower() {
    return power;
  }

  public String getEfficiency() {
    return efficiency;
  }

  public Engine(String model, int power) {
    this.model = model;
    this.power = power;
    this.displacement = Car.UNDEFINED_VALUE;
    this.efficiency = Car.UNDEFINED_VALUE;
  }

  public Engine(String model, int power, String unknownType) {
    this(model, power);
    if (Car.isNumber(unknownType)) {
      this.displacement = unknownType;
    } else {
      this.efficiency = unknownType;
    }
  }

  public Engine(String model, int power, String displacement, String efficiency) {
    this(model, power);
    this.displacement = displacement;
    this.efficiency = efficiency;
  }
}