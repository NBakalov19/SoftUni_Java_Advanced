package ListUtilities;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
  public static <T> T getMax(List<T> list) {
    if (list.isEmpty()) {
      throw new IllegalArgumentException();
    }

    list = list.stream()
            .sorted()
            .collect(Collectors.toList());

    return list.get(list.size() - 1);
  }

  public static <T> T getMin(List<T> list) {
    if (list.isEmpty()) {
      throw new IllegalArgumentException();
    }

    list = list.stream().sorted().collect(Collectors.toList());

    return list.get(0);
  }


}
