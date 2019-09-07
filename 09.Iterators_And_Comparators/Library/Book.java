package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
  private String title;
  private int year;
  private List<String> authors;

  public Book(String title, int year, String... authors) {
    this.title = title;
    this.year = year;
    this.authors = new ArrayList<>();

    if (authors.length != 0) {
      this.authors.addAll(Arrays.asList(authors));
    }
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public List<String> getAuthors() {
    return authors;
  }

  public void setAuthors(List<String> authors) {
    this.authors = authors;
  }

  @Override
  public int compareTo(Book other) {
    int titleCompare = this.getTitle().compareTo(other.getTitle());
    return titleCompare != 0 ? titleCompare : this.getYear() - other.getYear();
  }

}