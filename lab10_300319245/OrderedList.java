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
        throw new UnsupportedOperationException( "not implemented yet!" );
    }

    // Calculates the size of the list

    public int size() {
      	// Remove line below and add your implementation.
        throw new UnsupportedOperationException( "not implemented yet!" );
    }


    public Object get( int pos ) {
        // Remove line below and add your implementation.
        throw new UnsupportedOperationException( "not implemented yet!" );
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
        // Remove line below and add your implementation.
        throw new UnsupportedOperationException( "not implemented yet!" );
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