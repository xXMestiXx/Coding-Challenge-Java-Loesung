public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

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

    @Override
    public int size() {
        return size;
    }

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

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

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
    }
}