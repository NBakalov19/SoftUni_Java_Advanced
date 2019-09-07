package ListUtilities;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(5, 6, 8, 9);

    System.out.println(ListUtils.getMax(list));
    System.out.println(ListUtils.getMin(list));
  }
}
