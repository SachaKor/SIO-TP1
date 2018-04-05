package dlist;

public class Element {
    Element prev;
    Element next;
    private int data;

    public Element(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }
}
