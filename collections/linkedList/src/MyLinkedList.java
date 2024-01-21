/**
 * A class representing a node of a singly linked list.
 * Contains a reference to the next node and data of the current node.
 */
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * MyLinkedList class implements a single-linked list.
 * Supports basic operations: add, delete, get item, sort, set value by index
 * and checking the list for emptiness.
 * @param <T> type of data stored in the list
 */


public class MyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private int size;

    /**
     * Adds an item to the end of the list.
     * @param data data to add to the list
     */

    public  void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Adds an element at the specified index.
     * @param index index to add the item to
     * @param data data to add to the list
     * @throws IndexOutOfBoundsException if index goes outside the list boundaries
     */

    public void addIndex(int index, T data) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Returns the element at the specified index.
     * @param index index of the item to retrieve
     * @return list item at specified index
     * @throws IndexOutOfBoundsException if index goes outside the list boundaries
     */

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Deletes an element at the specified index.
     * @param index index of the item to delete
     * @throws IndexOutOfBoundsException if index goes outside the list boundaries
     */

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Sets the new element value at the specified index.
     * @param index index of the item to set the value to
     * @param data new data to set
     * @throws IndexOutOfBoundsException if index is out of the list boundaries
     */

    public void set (int index, T data) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, otherwise false
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the list.
     * @return list size
     */

    public int size() {
        return size;
    }

    /**
     * Sorts the list in ascending order (selection sorting is used).
     */

    public void sort() {
        if (size <= 1) {
            return;
        }
        Node<T> current = head;
        while (current != null) {
            Node<T> minNode = current;
            Node<T> temp = current.next;
            while (temp != null) {
                if (temp.data.compareTo(minNode.data) < 0) {
                    minNode = temp;
                }
                temp = temp.next;
            }
            T tempData = current.data;
            current.data = minNode.data;
            minNode.data = tempData;
            current = current.next;
        }
    }

    /**
     * Clears the list by removing all items.
     */

    public void clear() {
        head = null;
        size = 0;
    }
}
