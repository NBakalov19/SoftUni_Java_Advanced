package GenericCustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
  private List<T> data;

  public CustomList() {
    this.data = new ArrayList<>();
  }

  public void add(T element) {
    this.data.add(element);
  }

  public T remove(int index) {
    return this.data.remove(index);
  }

  public boolean contains(T element) {
    return this.data.contains(element);
  }

  public void swap(int firstIndex, int secondIndex) {
    T temp = this.data.get(firstIndex);
    this.data.set(firstIndex, this.data.get(secondIndex));
    this.data.set(secondIndex, temp);
  }

  public int greaterThan(T element) {
    return this.data.stream()
            .filter(e -> e.compareTo(element) > 0)
            .toArray().length;
  }

  public T getMax() {

    return this.data.stream().max(T::compareTo).get();
  }

  public T getMin() {
    return this.data.stream().min(T::compareTo).get();
  }

//    public void forEach(Consumer<T> consumer) {
//        for (T element : data) {
//            consumer.accept(element);
//        }
//    }

//    public void sort() {
//        this.data = this.data.stream().sorted().collect(Collectors.toList());
//    }

  public int size() {
    return this.data.size();
  }

  public T get(int index) {
    return this.data.get(index);
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return this.index < data.size();
      }

      @Override
      public T next() {
        return data.get(index++);
      }
    };
  }

}