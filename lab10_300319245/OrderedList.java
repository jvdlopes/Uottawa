import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
        // Your code here.
        //throw new UnsupportedOperationException( "not implemented yet!" );
    }

    // Calculates the size of the list

    public int size() {
        Node traverse = head;
        int ans = 1;
        if(head == null){
            return 0;
        }
        while(traverse.next != null){
            traverse = traverse.next;
            ans++;
        }
        return ans;
    }


    public Object get( int pos ) {
        Node traverse = head;
        for(int i = 1; i <= pos; i++){
            traverse = traverse.next;
        }
        return traverse;
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
        Node traverse;
        if(head == null){
            head = new Node(o, null, null);
        }
        else{
            int compared = head.value.compareTo(o);
            if(compared < 0){
                traverse = head;
                while(traverse.next != null){
                    if(traverse.next.value.compareTo(o)<0){
                        traverse = traverse.next;
                    }
                    else{
                        break;
                    }
                }
                Node n = new Node(o, null, traverse.next);
                if(traverse.next == null){
                    traverse.next = n;
                    n.previous = traverse;
                    return true;
                }
                else{
                    n.next.previous = n;
                    traverse.next = n;
                    n.previous = traverse;
                    return true;
                }
            }
            else{
                Node n = new Node(o, null, head);
                    n.next.previous = n;
                    head = n;
                    return true;
            }
        }
        return false;
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
      // Remove line below and add your implementation.
      throw new UnsupportedOperationException( "not implemented yet!" );
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
      // Remove line below and add your implementation.
      throw new UnsupportedOperationException( "not implemented yet!" );
    }
}