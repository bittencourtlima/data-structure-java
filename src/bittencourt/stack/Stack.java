package bittencourt.stack;

public class Stack {

    private Node top;
    private int height;

    public Stack(int value){
        push(value);
    }

    public void push(int value){
        Node newNode = new Node(value);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    public Node pop(){
        Node currentTop = top;
        if(top != null) {
            top = top.next;
            height--;
        }
        return currentTop;
    }

    public int getHeight() {
        return height;
    }

    public void printStack(){
        Node current = top;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    public class Node{
        public int value;
        private Node next;

        Node(int value){
            this.value = value;
        }
    }
}
