package socks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ArrayDeque<Integer> leftSocks = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toCollection(ArrayDeque::new));


    ArrayDeque<Integer> rightSocks = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toCollection(ArrayDeque::new));

    ArrayList<Integer> pairs = new ArrayList<>();

    while (leftSocks.size() > 0 && rightSocks.size() > 0) {

      int leftSock = leftSocks.peekLast();
      int rightSock = rightSocks.peekFirst();

      if (leftSock > rightSock) {
        int pair = leftSock + rightSock;
        pairs.add(pair);
        leftSocks.pollLast();
        rightSocks.poll();
      } else if (leftSock < rightSock) {
        leftSocks.pollLast();
      } else {
        leftSocks.pollLast();
        rightSocks.poll();
        leftSocks.add(leftSock + 1);
      }
    }

    System.out.println(pairs.stream().
            max(Integer::compareTo).toString());

    for (Integer pair : pairs) {
      System.out.print(pair + " ");
    }
  }
}