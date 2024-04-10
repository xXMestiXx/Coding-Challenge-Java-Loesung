interface ListInterface<E> {
    void add(E element);
    void add(int index, E element);
    E get(int index);
    boolean contains(E element);
    int size();
    void remove(int index);
    void clear();
    void printList();
}