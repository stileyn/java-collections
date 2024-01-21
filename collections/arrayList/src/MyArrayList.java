import java.util.Arrays;

/**
 * CustomArrayList class represents an implementation of a dynamic array similar to ArrayList in Java.
 *
 * @param <T> the type of elements stored in the list
 */

public class MyArrayList<T> {
    private  static int DEFAULT_CAPACITY = 10;
    private T[] list;
    private int size;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    /**
     * Default constructor, initializes the list with an initial capacity of 10.
     */

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added to the list
     */

    public void add(T element) {
        ensureCapacity();
        list[size++] = element;
    }

    /**
     * Adds an element at the specified index in the list.
     *
     * @param index   the index at which the element should be added
     * @param element the element to be added to the list
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */

    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        ensureCapacity();

        for (int i = size; i > index; i--) {
            list[i] = list[i-1];
        }

        list[index] = element;
        size++;
    }

    /**
     * Retrieves the element at the specified index from the list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        return list[index];
    }

    /**
     * Sets the item at the specified index in the list
     * @param index index The index of the element to be set in the list.
     * @param element element The element to set in the list.
     */
    public void set (int index, T element) {
        list[index] = element;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty and false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the element at the specified index from the list.
     *
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out bounds");
        }

        for (int i = index; i < size; i++) {
            list[i] = list[i+1];
        }
    }

    /**
     * Index remove by key
     *
     * @param element the element to remove
     * If the element is not found, then exit. If the item is found, delete it
     */
    public void remove(T element) {
        int positions = index(element);

        if (positions < 0) {
            return;
        }

        remove(positions);
    }

    /**
     * Clears the entire list, removing all elements.
     */

    public void clear() {
        Arrays.fill(list, null);
    }

    /**
     * Sorts the elements in the list in their natural order.
     */

    public void sort() {
        Arrays.sort(list, 0, size);
    }

    /**
     * Index search by key
     *
     * @param element the element to search
     * @return the index of the given element if it is in the list, otherwise -1
     */
    private int index(T element) {
        if (element == null)
            return -1;

        for (int i = 0; i < size; i++) {
            if (element.equals(list[i]))
                return i;
        }

        return -1;
    }

    /**
     * Private method to ensure the capacity of the list when adding elements.
     */

    private void ensureCapacity() {
        if (size == list.length) {
            int newCapacity = list.length * 2;
            list = Arrays.copyOf(list, newCapacity);
        }
    }

    /**
     * Displays the contents of the list.
     */

    public void printList() {
        System.out.println("List: ");
        for (T elem: list) {
            System.out.print(elem + " ");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}

