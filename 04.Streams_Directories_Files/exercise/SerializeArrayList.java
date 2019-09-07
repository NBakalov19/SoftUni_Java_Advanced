package exercise;

import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList {

  public static void main(String[] args) throws IOException, ClassNotFoundException {

    ArrayList<Double> doubleArrayList = new ArrayList<>() {{
      add(3.14);
      add(2.71);
      add(3.33);
      add(5.6);
    }};

    FileOutputStream outputStream = new FileOutputStream("list.txt");

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

    objectOutputStream.writeObject(doubleArrayList);
    outputStream.close();
    objectOutputStream.close();


    FileInputStream inputStream = new FileInputStream("list.txt");

    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

    ArrayList<Double> newList = (ArrayList<Double>) objectInputStream.readObject();

    for (Double aDouble : newList) {
      System.out.println(aDouble);
    }
  }
}