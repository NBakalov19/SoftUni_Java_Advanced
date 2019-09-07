package arena;


import java.util.HashMap;
import java.util.Map;

public class FightingArena {
  private String name;
  private Map<String, Gladiator> gladiators;

  public FightingArena(String name) {
    this.name = name;
    this.gladiators = new HashMap<>();
  }

  public void add(Gladiator gladiator) {
    this.gladiators.put(gladiator.getName(), gladiator);
  }

  public void remove(String gladiatorName) {
    this.gladiators.remove(gladiatorName);
  }

  public Gladiator getGladiatorWithHighestStatPower() {
    return this.gladiators.values()
            .stream().min((f, s) -> s.getStatPower() - f.getStatPower()).get();
  }

  public Gladiator getGladiatorWithHighestWeaponPower() {
    return this.gladiators.values()
            .stream().min((f, s) -> s.getWeaponPower() - f.getWeaponPower()).get();
  }

  public Gladiator getGladiatorWithHighestTotalPower() {
    return this.gladiators.values()
            .stream().min((f, s) -> s.getTotalPower() - f.getTotalPower()).get();
  }

  public int getCount() {
    return this.gladiators.size();
  }

  @Override
  public String toString() {
    return String.format("%s – %d gladiators are participating.", this.name, this.getCount());
  }
}
