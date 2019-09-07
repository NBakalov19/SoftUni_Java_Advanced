package Swap;

import GenericBox.Box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Box<String>> boxOfString = new ArrayList<>();

        while (n > 0) {
            String input = scanner.nextLine();
            Box box = new Box(input);
            boxOfString.add(box);

            n--;
        }
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];

        swap(boxOfString, firstIndex, secondIndex);

        for (Box<String> stringBox : boxOfString) {
            System.out.println(stringBox.toString());
        }
    }

    private static <T> void swap(ArrayList<T> list, int firstIndex, int secondIndex) {
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }
}