package StackIterator;

import java.util.Iterator;

public class StackIter<T> implements Iterable<T> {

  private Node<T> top;

  private static class Node<T> {
    private Node<T> prev;
    private T element;

    private Node(T element) {
      this.prev = null;
      this.element = element;
    }
  }

  public void push(T element) {
    Node<T> node = new Node<>(element);
    if (this.top == null) {
      this.top = node;
    } else {
      node.prev = this.top;
      this.top = node;
    }
  }

  public T pop() {
    if (this.top == null) {
      throw new IndexOutOfBoundsException("No elements");
    }

    T element = this.top.element;
    this.top = this.top.prev;

    return element;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> current = top;

      @Override
      public boolean hasNext() {
        return this.current != null;
      }

      @Override
      public T next() {
        T element = this.current.element;
        this.current = this.current.prev;
        return element;
      }
    };
  }
}