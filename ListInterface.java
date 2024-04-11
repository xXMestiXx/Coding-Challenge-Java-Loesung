/**
 * Interface class that has the following methods
 * @author Philipp Mestenhauser
 * @version 1.2
 */
interface ListInterface<E> {
    /**
     * This Method adds a new node to a LinkedList<E>
     * @param element
     */
    void add(E element);

    /**
     * This Method adds a new node at a selected index to a LinkedList<E>
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * Returns a node from a LinkedList<E> at selected index
     * @param index
     * @return choosenNode
     */
    E get(int index);

    /**
     * Checks if element is part of a LinkedList<E>
     * @param element
     * @return boolean true = if element is part of the LinkedList<E>
     *                 false = if element is not part of the LinkedList<E>
     */
    boolean contains(E element);

    /**
     * Returns the size of a LinkedList<E>
     * @return size
     */
    int size();

    /**
     * Removes node form LinkedList<E> at selected index
     * @param index
     */
    void remove(int index);

    /**
     * Deletes the whole LinkedList<E>
     */
    void clear();

    /**
     * Creates a visual output of a LinkedList<E> to the terminal
     */
    void printList();
}