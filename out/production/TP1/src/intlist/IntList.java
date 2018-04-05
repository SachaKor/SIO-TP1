package intlist;

class Element {
    private int data;
    Element next;

    public Element(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}

public class IntList {

    private Element head;

    public IntList() {
        head = null;
    }

    Element getHead() {
        return head;
    }

    public void add(int data) {

        Element tmp = head;
        head = new Element(data);
        head.next = tmp;
    }

    public IntListIterator iterator() {
        return new IntListIterator(this);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int removeFirst() {
        int data = head.getData();
        head = head.next;
        return data;
    }

}
