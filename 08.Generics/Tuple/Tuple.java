package Tuple;

public class Tuple<F,S> {
    private F item1;
    private S item2;

    public Tuple(F item1, S item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public F getItem1() {
        return this.item1;
    }

    public S getItem2() {
        return this.item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", getItem1(), getItem2());
    }
}