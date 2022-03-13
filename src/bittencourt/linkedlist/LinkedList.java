package bittencourt.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length = 0;

    public LinkedList(int number){
        Node newNode = new Node(number);
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
        }
        tail = newNode;
        length++;

        return newNode;
    }

    public boolean removeLast(){
        if(length == 0) return false;

        Node pre = head;
        Node current = head;
        while (current.next != null){
            pre = current;
            current = current.next;
        }
        pre.next = null;
        tail = pre;
        length--;

        if(length == 0) {
            head = null;
            tail = null;
        }
        return true;
    }

    public Node prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            tail = newNode;
        }else {
            newNode.next = head;
        }
        head = newNode;
        length++;
        return newNode;
    }

    public boolean removeFirst(){
        if(length == 0) return false;

        Node temp = head;
        head = head.next;
        temp.next = null;

        length--;
        if(length == 0){
            tail = null;
        }
        return true;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;

        Node current = head;
        for(int i = 1; i<=index; i++){
            current = current.next;
        }

        return current;
    }

    public Node insert(int index, int value){
        if(index < 0 || index > length) return null;
        if(index == 0) return prepend(value);
        if(index == length) return append(value);

        Node newNode = new Node(value);

        Node before = get(index - 1);

        newNode.next = before.next;
        before.next = newNode;

        length++;

        return newNode;
    }

    public boolean set(int index, int value){
        if(index < 0 || index >= length) return false;

        Node current = get(index);
        current.value = value;
        return true;
    }

    public boolean remove(int index){
        if(index < 0 || index >= length) return false;
        if(index == 0) return removeFirst();
        if(index == length -1) return removeLast();

        Node before = get(index - 1);
        Node current = before.next;
        before.next = current.next;
        current.next = null;

        length--;
        return true;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    public class Node{
        public int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
