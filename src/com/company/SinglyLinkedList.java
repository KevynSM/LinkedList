package com.company;


public class SinglyLinkedList {
    private SingleListNode head;
    private SingleListNode tail;
    private int count;

    SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public Object getFirst() {
        return this.head;
    }

    public Object getLast() {
        return this.tail;
    }
    
}
