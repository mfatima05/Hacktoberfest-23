package com.Mann;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;


    private class Node {

        private int value;
        private Node next;

        public Node(int item){
            this.value = item;
            this.next = null;
        }
    }

    // isEmpty
    private boolean isEmpty(){
        if (first == null)
            return true;
        return false;
    }

    // addFirst
    public void addFirst(int item){
        Node newNode = new Node(item);
        if (isEmpty()){
            first = last = newNode;
        } else {
        newNode.next = first;
        first = newNode;

        }
        size++;
    }

    // addLast
    public void addLast(int item){
        Node newNode = new Node(item);
        if (isEmpty()){
            first = last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    // deleteFirst
    public void deleteFirst(){
        if (!isEmpty()){
            if(first == last){
                // single item in list
                first = last = null;
            } else {
                var second = first.next;
                first.next = null;
                first = second;
            }
            size--;
        } else {
            throw new NoSuchElementException();
        }
    }

    // deleteLast
    public void deleteLast(){

        if (isEmpty()){
            throw new NoSuchElementException();
        } else if(first == last){
            first = last = null;
        } else{
            Node p = first;
            while(p.next != last){
                p=p.next;
            }
            p.next = null;
            last = p;
        }
        size--;

    }
    // contains
    public boolean contains(int item){
        if(indexOf(item) != -1)
            return true;
        return false;
    }
    // indexOf
    public int indexOf(int item){
        int index = 0;
        for (Node p = first; p != null; p=p.next){
            if (p.value == item)
                return index;
            index++;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var curr = first;
        int index = 0;
        while(curr != null ){
            array[index++] = curr.value;
            curr = curr.next;
        }
        return array;
    }

    // My Implementation of Reversing Linked List
    /* public void reverse(){
        if (isEmpty())
            throw new NoSuchElementException();

        if( first != last){
            Node curr = first;
            Node prev  = null;
            while (curr.next != null){
                if (prev == null){
                    prev = curr;
                    curr = curr.next;
                    prev.next = null;
                } else {
                    var temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }
            }
            curr.next = prev;
        }
        var temp = first;
        first = last;
        last = temp;
    }
    */

    public void reverse(){
        var prev = first;
        var curr = first.next;
        while(curr != null){
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        last = first;
        last.next = null;
        first = prev;
    }

    public int KthFromTheEnd( int k){
        if (isEmpty())
            throw new IllegalStateException();
        if(k<=0){
            return -1;
        } else if(k==1){
            return last.value;
        }
        var x = first;
        var y=first;
        for (int i = 1; i < k; i++){
           y=y.next;
           if (y==null)
               throw new IllegalArgumentException();
        }
        while(y != last){
            x=x.next;
            y=y.next;
        }
        return x.value;
    }

    public static void main(String[] args) {

    }
}
