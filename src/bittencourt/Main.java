package bittencourt;

import bittencourt.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.append(3);
        list.append(4);

        list.remove(1);

        list.printList();
    }
}
