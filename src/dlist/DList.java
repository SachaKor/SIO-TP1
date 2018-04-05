package dlist;

public class DList {
    private Element head;

    public Element getHead() {
        return head;
    }

    public DList() {
        head = null;
    }

    public void add(Element el) {
        Element tmp = head;
        head = el;
        head.prev = null;
        head.next = tmp;

        if(tmp != null) {
            tmp.prev = head;
        }
    }

    public void remove(Element el) {
        Element prev = el.prev;
        Element next = el.next;

        if (el == head) {
            head = head.next;
        }

        if(prev != null) {
            prev.next = next;
        }

        if(next != null) {
            next.prev = prev;
        }

    }

    public boolean isEmpty() {
        return head == null;
    }

}
