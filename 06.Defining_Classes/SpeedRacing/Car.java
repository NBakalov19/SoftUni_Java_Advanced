package SpeedRacing;

public class Car {
  private String model;
  private double fuel;
  private double consumption;
  private int distanceCovered;

  public Car(String model, double fuel, double consumption) {
    this.model = model;
    this.fuel = fuel;
    this.consumption = consumption;
    this.distanceCovered = 0;
  }

  public boolean drive(int distance) {
    double fuelNeeded = distance * this.consumption;

    if (fuelNeeded <= this.fuel) {
      this.fuel -= fuelNeeded;
      this.distanceCovered += distance;
      return true;
    }
    return false;
  }

  public String carInfo() {
    return String.format("%s %.2f %d",
            this.model, this.fuel, this.distanceCovered);
  }
}
