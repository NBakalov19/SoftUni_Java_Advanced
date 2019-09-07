package regularExam.heroRepository;

import java.util.ArrayList;
import java.util.Comparator;

public class HeroRepository {
  private ArrayList<Hero> data;

  public HeroRepository() {
    this.data = new ArrayList<>();
  }

  public void add(Hero hero) {
    this.data.add(hero);
  }

  public void remove(String heroName) {
    this.data.removeIf(h -> h.getName().equals(heroName));
  }

  public Hero getHeroWithHighestStrength() {
    return this.data.stream()
            .max(Comparator.comparingInt(h -> h.getItem().getStrength()))
            .get();
  }

  public Hero getHeroWithHighestAgility() {
    return this.data.stream()
            .max(Comparator.comparingInt(h -> h.getItem().getAgility()))
            .get();
  }

  public Hero getHeroWithHighestIntelligence() {
    return this.data.stream()
            .max(Comparator.comparingInt(h -> h.getItem().getIntelligence()))
            .get();
  }

  public int getCount() {
    return this.data.size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (Hero hero : this.data) {
      sb.append(hero.toString()).append(System.lineSeparator());
    }
    return sb.toString();
  }
}