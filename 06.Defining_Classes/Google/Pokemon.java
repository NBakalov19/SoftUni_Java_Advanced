package Google;

public class Pokemon {
  private String pokemonName;
  private String pokemonType;

  public String getPokemonName() {
    return pokemonName;
  }

  public String getPokemonType() {
    return pokemonType;
  }

  public Pokemon(String pokemonName, String pokemonType) {
    this.pokemonName = pokemonName;
    this.pokemonType = pokemonType;
  }
}
