package PokemonTrainer;

public class Pokemon {
  private String pokemonName;
  private String pokemonElement;
  private int pokemonHealth;


  public Pokemon(String pokemonName, String pokemonElement, int pokemonHealth) {
    this.pokemonName = pokemonName;
    this.pokemonElement = pokemonElement;
    this.pokemonHealth = pokemonHealth;
  }

  public String getPokemonName() {
    return pokemonName;
  }

  public void setPokemonName(String pokemonName) {
    this.pokemonName = pokemonName;
  }

  public String getPokemonElement() {
    return pokemonElement;
  }

  public void setPokemonElement(String pokemonElement) {
    this.pokemonElement = pokemonElement;
  }

  public int getPokemonHealth() {
    return pokemonHealth;
  }

  public void setPokemonHealth(int pokemonHealth) {
    this.pokemonHealth = pokemonHealth;
  }

}
