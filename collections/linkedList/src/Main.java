public class Main {
    public static void main(String[] args) {
        // test LinkedList
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        // add in list
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(3);
        linkedList.addIndex(1, 7);

        // test size()
        assert linkedList.size() == 4;

        // test get()
        assert linkedList.get(2) == 10;

        // remove
        linkedList.remove(1);

        // test isEmpty()
        assert !linkedList.isEmpty();

        // out
        System.out.println("List items:");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        // sort
        linkedList.sort();

        // test set()
        linkedList.set(1, 15);

        // clear
        linkedList.clear();
        assert linkedList.isEmpty();
        assert linkedList.isEmpty();

        System.out.println("Testing completed successfully.");

    }
}
