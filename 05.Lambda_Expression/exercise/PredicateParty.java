package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
            .collect(Collectors.toList());

    String input = reader.readLine();

    while (!input.equals("Party!")) {
      String[] tokens = input.split("\\s+");

      messingWithList(names, tokens);

      input = reader.readLine();
    }
    if (names.size() == 0) {
      System.out.println("Nobody is going to the party!");
    } else {
      System.out.println(String.join(", ", names) + " are going to the party!");
    }
  }

  private static void messingWithList(List<String> names, String[] tokens) {
    BiPredicate<String, String> startsWith = String::startsWith;
    BiPredicate<String, String> endsWith = String::endsWith;
    BiPredicate<String, String> length = (str, len) -> {
      int size = Integer.parseInt(len);
      return str.length() == size;
    };

    String mainCmd = tokens[0];
    String cmd = tokens[1];
    String identity = tokens[2];

    BiPredicate<String, String> mainPredicate = startsWith;

    if (cmd.equals("EndsWith")) {
      mainPredicate = endsWith;
    } else if (cmd.equals("Length")) {
      mainPredicate = length;
    }
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    if (mainCmd.equals("Double")) {
      for (int i = 0; i < names.size(); i++) {
        if (mainPredicate.test(names.get(i), identity)) {
          stack.push(i);
        }
      }
      for (Integer index : stack) {
        String name = names.get(index);
        names.add(index, name);
      }
    } else {
      for (int i = names.size() - 1; i >= 0; i--) {
        if (mainPredicate.test(names.get(i), identity)) {
          names.remove(names.get(i));
        }
      }
    }
  }
}