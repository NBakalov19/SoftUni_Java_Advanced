package RawData;

import java.util.ArrayList;

public class Car {
  private String model;
  private Engine engine;
  private Cargo cargo;
  private Tires tires;

  public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType
          , ArrayList<Double> tires) {
    this.model = model;
    this.engine = new Engine(engineSpeed, enginePower);
    this.cargo = new Cargo(cargoWeight, cargoType);
    this.tires = new Tires(tires);
  }

  public String getModel() {
    return model;
  }

  public Engine getEngine() {
    return engine;
  }


  public Cargo getCargo() {
    return cargo;
  }

  public Tires getTires() {
    return tires;
  }
}