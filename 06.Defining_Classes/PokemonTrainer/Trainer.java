package PokemonTrainer;

import java.util.ArrayList;

public class Trainer {
  private String trainerName;
  private Integer badges;
  private ArrayList<Pokemon> pokemons;

  public Trainer(String trainerName, ArrayList<Pokemon> pokemons) {
    this.trainerName = trainerName;
    this.badges = 0;
    this.pokemons = pokemons;
  }

  public String getTrainerName() {
    return trainerName;
  }

  public void setTrainerName(String trainerName) {
    this.trainerName = trainerName;
  }

  public int getBadges() {
    return badges;
  }

  public void setBadges(int badges) {
    this.badges = badges;
  }

  public ArrayList<Pokemon> getPokemons() {
    return pokemons;
  }

  public void setPokemons(ArrayList<Pokemon> pokemons) {
    this.pokemons = pokemons;
  }

  public boolean checkPokemonsElement(String element) {
    for (Pokemon pokemon : pokemons) {
      if (pokemon.getPokemonElement().equals(element)) {
        return true;
      }
    }
    return false;
  }

  public void decreasePokemonHealth() {
    for (Pokemon pokemon : pokemons) {
      int pokemonHealth = pokemon.getPokemonHealth();
      pokemon.setPokemonHealth(pokemonHealth - 10);
    }
  }

  public String getInfo() {
    return String.format("%s %d %d", getTrainerName(), getBadges(), getPokemons().size());
  }
}
