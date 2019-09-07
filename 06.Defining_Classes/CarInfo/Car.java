package CarInfo;

class Car {
  private String make;
  private String model;
  private int horsePower;

  public static final String undefinedValue = "unknown";


  public Car(String make, String model, int horsePower) {
    this(make, model);
    this.horsePower = horsePower;
  }

  public Car(String make, String model) {
    this(make);
    this.model = model;
  }

  public Car(String make) {
    this();
    this.make = make;
  }

  public Car() {
    this.make = undefinedValue;
    this.model = undefinedValue;
    this.horsePower = -1;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getHorsePower() {
    return horsePower;
  }

  public void setHorsePower(int horsePower) {
    this.horsePower = horsePower;
  }

  public String getInfo() {
    return String.format("The car is: %s %s - %d HP.", getMake(), getModel(), getHorsePower());
  }
}
