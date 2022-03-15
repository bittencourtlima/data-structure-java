package bittencourt.doublylinkedlist;

import bittencourt.linkedlist.LinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

    public Node append(int value){
        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;

        return newNode;
    }

    public boolean removeFirst(){
        if(length == 0) return false;
        if(length == 1) {
            head = null;
            tail = null;
        }else {
            Node current = head;
            head = head.next;
            head.prev = null;
            current.next = null;
        }
        length--;
        return true;
    }

    public boolean removeLast(){
        if(length == 0) return false;
        Node before = tail.prev;
        if(length == 1) {
            head = null;
            tail = null;
        }else {
            before.next = null;
            tail.prev = null;
            tail = before;
        }
        length--;
        return true;
    }

    public Node prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        length++;
        return newNode;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;

        Node current;
        if(index < length / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }else{
            current = tail;
            for (int i = length-1; i > index; i--) {
                current = tail.prev;
            }
        }

        return current;
    }

    public boolean set(int index, int value){
        if(index < 0 || index >= length) return false;

        Node current = get(index);
        current.value = value;
        return true;
    }

    public Node insert(int index, int value){
        if(index < 0 || index > length) return null;
        if(index == 0) return prepend(value);
        if(index == length) return append(value);

        Node newNode = new Node(value);

        Node before = get(index - 1);
        Node after = before.next;
        newNode.next = after;
        newNode.prev = before;
        after.prev = newNode;
        before.next = newNode;

        length++;

        return newNode;
    }

    public boolean remove(int index){
        if(index < 0 || index >= length) return false;
        if(index == 0) return removeFirst();
        if(index == length -1) return removeLast();

        Node before = get(index - 1);
        Node current = before.next;
        Node after = current.next;

        before.next = after;
        current.prev = null;
        current.next = null;
        after.prev = before;

        length--;
        return true;
    }

    public class Node{
        public int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value = value;
        }
    }
}
