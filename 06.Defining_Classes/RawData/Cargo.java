package RawData;

public class Cargo {
  private int cargoWeight;
  private String cargoTpe;

  public Cargo(int cargoWeight, String cargoTpe) {
    this.cargoWeight = cargoWeight;
    this.cargoTpe = cargoTpe;
  }

  public int getCargoWeight() {
    return cargoWeight;
  }

  public void setCargoWeight(int cargoWeight) {
    this.cargoWeight = cargoWeight;
  }

  public String getCargoTpe() {
    return cargoTpe;
  }

  public void setCargoTpe(String cargoTpe) {
    this.cargoTpe = cargoTpe;
  }
}
