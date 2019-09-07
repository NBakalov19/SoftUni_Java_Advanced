package Tuple;

public class Threeuple<F, S, T> {
  private F item1;
  private S item2;
  private T item3;

  public Threeuple(F item1, S item2, T item3) {
    this.item1 = item1;
    this.item2 = item2;
    this.item3 = item3;
  }

  public F getItem1() {
    return this.item1;
  }


  public S getItem2() {
    return this.item2;
  }

  public T getItem3() {
    return item3;
  }

  @Override
  public String toString() {
    return String.format("%s -> %s -> %s", getItem1(), getItem2(), getItem3());
  }
}
