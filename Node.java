/**
 * Node<E> is implementing nodes for a LinkedList<E>
 * @author Philipp Mestenhauser
 * @version 1.3
 * @see LinkedList
 */
class Node<E> {

    /**
     * Stores data inside the node
     */
    E data;
    /**
     * Stores the next Node 
     */
    Node<E> next;

    /**
     * Constructor for the class Node<E>
     * @param data Data which is going to be stored inside the node
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Transforms the stored data into a String
     * @return String
     */
    @Override
    public String toString(){
        return (" " + this.data);
    }

}
