package Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
  private Book[] books;

  public Library(Book... books) {
    this.books = books;
  }

  @Override
  public Iterator<Book> iterator() {
    return new LibIterator();
  }

  private class LibIterator implements Iterator<Book> {
    private int count;

    @Override
    public boolean hasNext() {
      return this.count < books.length;
    }

    @Override
    public Book next() {
      return books[this.count++];
    }
  }
}