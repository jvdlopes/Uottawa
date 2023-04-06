//                              -*- Mode: Java -*- 
// BitList.java --- data structure to store a sequence of bits (ints)
// Author          : Marcel Turcotte
// Created On      : Fri Apr  9 09:00:27 2004
// Last Modified By: Marcel Turcotte
// Last Modified On: Fri Mar 24 10:00:36 2006


import java.util.NoSuchElementException;

// Stores the bits in reverse order!

public class BitList {

    // useful constants

    public static final int ZERO = 0;
    public static final int ONE = 1;

    // instance variables

    private Node first;

    // constructors

    public BitList() {  
        first = null;
    }

    public BitList( String s ) {
        BitListIterator list = new BitListIterator();
        if(s.equals("")){
            return;
        }
        char[] charList =s.toCharArray();
        for(char x : charList){
            if(!(x=='1' || x=='0')){
                throw new IllegalArgumentException();
            }
        }
        for(int x = charList.length-1; x>=0; x--){
            if(charList[x] == '1'){
                list.add(1);
            }
            if(charList[x] == '0'){
                list.add(0);
            }
        }
    }

    public void addFirst( int bit ) {

        if ( ( bit != ZERO ) && ( bit != ONE ) ) {
            throw new IllegalArgumentException( Integer.toString( bit ) );
        }

        first = new Node( bit, first );
    }

    public int removeFirst() {

        if ( first == null ) {
            throw new NoSuchElementException();
        }

        int saved = first.bit;

        first = first.next;

        return saved;
    }

    public Iterator iterator() {
        return new BitListIterator();
    }

    public String toString() {

        String str = "";

        if ( first == null ) {

            str += ZERO;

        } else {

            Node p = first;

            while ( p!=null ) {
                str = p.bit + str; // reverses the order!
                p = p.next;
            }

        }
        return str;
    }

    // The implementation of the nodes (static nested class)

    private static class Node {

        private int bit; // <- NEW
        private Node next;

        private Node( int bit, Node next ) { // <- ACCORDINGLY ...
            this.bit = bit;
            this.next  = next;
        }
    }

    // The implementation of the iterators (inner class)

    private class BitListIterator implements Iterator {

        private Node current = null;

        private BitListIterator() {
            current = null;
        }

        public boolean hasNext() {
            return ( ( current == null && first != null )   ||
                     ( current != null && current.next != null ) );
        }

        public int next() {

            if ( current == null ) {
                current = first ;
            } else {
                current = current.next ; // move the cursor forward
            }

            if ( current == null ) {
                throw new NoSuchElementException() ;
            }

            return current.bit ;
        }

        public void add( int bit ) {

            if ( ( bit != ZERO ) && ( bit != ONE ) ) {
                throw new IllegalArgumentException( Integer.toString( bit ) );
            }

            Node newNode;

            if ( current == null ) {
                first = new Node( bit, first );
                current = first;
            } else {
                current.next = new Node( bit, current.next );
                current = current.next;
            }
        }
    }
}