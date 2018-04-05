package intlist;

public class IntListIterator {
    private Element next;

    public IntListIterator(IntList l) {
        next = l.getHead();
    }

    public int next() {
        Element cur = next;
        next = cur.next;
        return cur.getData();
    }

    public boolean hasNext() {
        return next != null;
    }
}
