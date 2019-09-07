package JarOfT;

public class Main {
  public static void main(String[] args) {

    Jar<String> jar = new Jar<>();

    jar.add("abab");

    String string = jar.remove();
    System.out.println(string);
  }
}
