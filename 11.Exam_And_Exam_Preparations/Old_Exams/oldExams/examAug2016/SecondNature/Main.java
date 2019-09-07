package oldExams.examAug2016.SecondNature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayDeque<Integer> flowers = new ArrayDeque<>();
    ArrayDeque<Integer> buckets = new ArrayDeque<>();

    Arrays.stream(reader.readLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .forEach(flowers::offer);

    Arrays.stream(reader.readLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .forEach(buckets::push);

    ArrayDeque<Integer> secondNature = new ArrayDeque<>();

    while (flowers.size() > 0 && buckets.size() > 0) {

      int flower = flowers.poll();
      int bucket = buckets.pop();

      if (flower > bucket) {
        flower -= bucket;
        flowers.offerFirst(flower);
      } else if (flower == bucket) {
        secondNature.offer(flower);
      } else {
        bucket -= flower;
        if (!buckets.isEmpty()) {
          int newBucket = buckets.pop() + bucket;
          buckets.push(newBucket);
        } else {
          buckets.push(bucket);
        }
      }
    }

    if (!flowers.isEmpty()) {
      System.out.println(flowers.stream()
              .map(String::valueOf)
              .collect(Collectors.joining(" ")));
    }

    if (!buckets.isEmpty()) {
      while (!buckets.isEmpty()) {
        System.out.print(buckets.pop() + " ");
      }
      System.out.println();
    }

    if (secondNature.isEmpty()) {
      System.out.println("None");
    } else {
      System.out.println(secondNature.stream()
              .map(String::valueOf)
              .collect(Collectors.joining(" ")));
    }
  }
}