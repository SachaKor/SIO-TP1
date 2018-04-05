package intlist;

public class TestIntList {
    public static void main(String[] args) {
        IntList il = new IntList();
        il.add(1);
        il.add(2);
        il.add(3);
        IntListIterator it = il.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }
    }
}
