class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString(){
        return (" " + this.data);
    }

}
