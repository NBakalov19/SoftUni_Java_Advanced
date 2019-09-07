package RawData;

import java.util.ArrayList;

public class Tires {

  private ArrayList<Double> tyrePressure;

  public Tires(ArrayList<Double> tyrePressure) {
    this.tyrePressure = tyrePressure;
  }

  private ArrayList<Double> getTyrePressure() {
    return tyrePressure;
  }

  public boolean isValidPressure() {
    for (int i = 0; i < this.getTyrePressure().size(); i++) {
      if (getTyrePressure().get(i) < 1) {
        return true;
      }
    }
    return false;
  }
}