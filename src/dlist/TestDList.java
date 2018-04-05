package dlist;

public class TestDList {
    public static void main(String[] args) {
        Element one = new Element(1);
        Element two = new Element(2);
        Element three = new Element(3);

        DList dlist = new DList();
        dlist.add(one);
        dlist.add(two);
        dlist.add(three);

        Element cur = dlist.getHead();
        while (cur != null) {
            System.out.println(cur.getData());
            cur = cur.next;
        }

        dlist.remove(three);
        dlist.remove(two);
        dlist.remove(one);


        System.out.println(dlist.isEmpty());

        Element[] arrayOfElements = {one, two, three};

        dlist.add(one);
        dlist.add(two);
        dlist.add(three);

        for (Element e : arrayOfElements) {
            dlist.remove(e);
        }

    }
}
