package oldExams.earthquake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
  public static int seimsity = -1;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayDeque<ArrayDeque<Integer>> activities = new ArrayDeque<>();

    int countOfWaves = Integer.parseInt(reader.readLine());

    for (int i = 0; i < countOfWaves; i++) {
      ArrayDeque<Integer> wave = Arrays.stream(reader.readLine().split("\\s+"))
              .mapToInt(Integer::parseInt)
              .boxed()
              .collect(Collectors.toCollection(ArrayDeque::new));

      activities.offer(wave);
    }

    ArrayDeque<Integer> seismicities = new ArrayDeque<>();

    while (activities.size() > 0) {
      ArrayDeque<Integer> currWave = activities.peek();
      if (currWave.size() > 0) {
        seimsity = currWave.poll();
      }
      if (currWave.size() > 0) {
        while (!currWave.isEmpty()) {
          if (seimsity >= currWave.peek()) {
            currWave.poll();
          } else {
            seismicities.offer(seimsity);
            activities.offerLast(currWave);
            activities.poll();
            break;
          }
        }
      } else {
        activities.poll();
        if (seimsity != -1) {
          seismicities.offer(seimsity);
        }
      }
    }

    System.out.println(seismicities.size());
    while (!seismicities.isEmpty()) {
      System.out.print(seismicities.poll() + " ");
    }
  }
}