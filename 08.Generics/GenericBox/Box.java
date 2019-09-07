package GenericBox;

public class Box<T extends Comparable<T>> {
  private T element;

  public void setElement(T element) {
    this.element = element;
  }

  public T getElement() {
    return element;
  }

  public Box(T element) {
    this.element = element;
  }

  public int compareTo(Box<T> otherElement) {
    return this.element.compareTo(otherElement.element);
  }

  @Override
  public String toString() {
    return String.format("%s: %s", this.element.getClass().getName(), getElement());
  }
}