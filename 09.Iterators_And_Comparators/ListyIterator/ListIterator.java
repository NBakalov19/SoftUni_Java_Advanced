package ListyIterator;

import java.util.*;

public class ListIterator implements Iterable<String> {
  public static final int DEFAULT_INDEX_VALUE = -1;

  private List<String> data;
  private int index;


  public ListIterator(ArrayList<String> list) {
    this.data = list;
    this.setIndex();
  }

  public boolean move() {
    if (this.index < data.size() - 1) {
      this.index++;
      return true;
    }
    return false;
  }

  public void setIndex() {
    if (this.data.size() == 0) {
      this.index = ListIterator.DEFAULT_INDEX_VALUE;
    } else {
      this.index = 0;
    }
  }

  public boolean hasNext() {
    return this.index < data.size() - 1;
  }

  public String print() {
    if (this.data.size() == 0) {
      throw new IndexOutOfBoundsException("Invalid Operation!");
    }
    return this.data.get(this.index);
  }

  @Override
  public Iterator<String> iterator() {
    return new Iterator<String>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return this.index < data.size();
      }

      @Override
      public String next() {
        return data.get(this.index++);
      }
    };
  }
}