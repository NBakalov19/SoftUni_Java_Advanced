package PokemonTrainer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    Pokemon pokemon;
    Map<String, Trainer> trainers = new LinkedHashMap<>();

    while (!input.equals("Tournament")) {
      String[] tokens = input.split("\\s+");

      String trainerName = tokens[0];
      String pokemonName = tokens[1];
      String pokemonElement = tokens[2];
      int pokemonHealth = Integer.parseInt(tokens[3]);

      pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

      ArrayList<Pokemon> pokemons = new ArrayList<>();
      pokemons.add(pokemon);
      if (!trainers.containsKey(trainerName)) {
        Trainer trainer = new Trainer(trainerName, pokemons);
        trainers.put(trainerName, trainer);
      } else {
        trainers.get(trainerName).getPokemons().add(pokemon);
      }
      input = scanner.nextLine();
    }

    String element = scanner.nextLine();

    while (!element.equals("End")) {
      tournamentResults(trainers, element);
      element = scanner.nextLine();
    }

    trainers.entrySet().stream()
            .sorted((f, s) -> Integer.compare(s.getValue().getBadges(), f.getValue().getBadges()))
            .forEach(trainer -> System.out.println(trainer.getValue().getInfo()));
  }

  private static LinkedHashMap tournamentResults(Map<String, Trainer> trainers, String element) {
    for (Trainer trainer : trainers.values()) {
      if (trainer.checkPokemonsElement(element)) {
        int trainerBadges = trainer.getBadges();
        trainer.setBadges(++trainerBadges);
      } else {
        trainer.decreasePokemonHealth();

        ArrayList<Pokemon> curr = trainer.getPokemons().stream()
                .filter(pokemon1 -> pokemon1.getPokemonHealth() > 0)
                .collect(Collectors.toCollection(ArrayList::new));
        trainer.setPokemons(curr);
      }
    }
    return (LinkedHashMap) trainers;
  }
}
