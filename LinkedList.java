/**
 * LinkedList<E> is implementing an self made generic linked list.
 * @author Philipp Mestenhauser
 * @version 1.3
 * @see Node , ListInterface
 */
public class LinkedList<E> implements ListInterface<E> {
    
    /**
     * Is setting the head for the linked List
     */
    private Node<E> head;
    /**
     * Is saving the length of the LinkedList<E>
     */
    private int size;


    /**
     * Constructor for the class LinkedList<E>
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add's new node to LinkedList<E>
     * @param element new node
     */
    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Add's new node at chosen index to LinkedList<E>
     * @param index position where new node is going to be added
     * @param element new node
     * @throws @exception IndexOutOfBoundsException if index is invalid
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            Node<E> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> newNode = new Node<>(element);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Returns node at selected index from LinkedList<E>
     * @param index position of node that is going to be returned
     * @return node
     * @throws @exception IndexOutOfBoundsException if index is invalid
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Checks if element is part of the LinkedList<E>
     * @param element is compared to all nodes of the LinkedList<E>
     * @return true = if element is part of the LinkedList<E>. 
     *         false = if there is no such element in the LinkedList<E>
     */
    @Override
    public boolean contains(E element) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Return the size of the LinkedList<E>
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes node form LinkedList<E> at selected index
     * @param index Index for node which is going to be removed
     * @throws @exception IndexOutOfBoundsException if index is invalid
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Deletes a whole LinkedList<E>
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Creates a visual output of a LinkedList<E> to the terminal
     */
    @Override
    public void printList(){
        Node<E> current = this.head;
        System.out.print("Linked List: ");
        while(current != null){
            System.out.print(current.toString() + ", ");
            current = current.next;
        }
        System.out.println();
    }
    /**
     * Creates a deep clone of a LinkedList<E>
     * @return clone
     */
    @Override
    public LinkedList<E> clone(){
        LinkedList<E> clone = new LinkedList<>();
        Node<E> current = this.head;
        while(current != null){
            clone.add(current.data);
            current = current.next;
        }
        return clone;
    }

    /**
     * Return a LinkedList<E> as an String
     * @return stringList
     */
    @Override
    public String toString(){
        String stringList = "String: (LinkedList: ";
        Node<E> current = head;
        while(current != null){
            stringList = stringList + current.toString() + " " ;
            current = current.next;
        }
        stringList = stringList + ")";
        return stringList;
    }


    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        System.out.println("List size: " + list.size());
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Does list contain 10? " + list.contains(10));

        list.remove(1);
        System.out.println("After removing element at index 1, list size: " + list.size());

        //list.clear();
        //System.out.println("After clearing the list, list size: " + list.size());

        
        list.printList();
        LinkedList<Integer> clone = list.clone();
        clone.printList();
        System.out.println(clone.toString());        
    }
}