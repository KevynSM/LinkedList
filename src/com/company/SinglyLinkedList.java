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

    public SingleListNode getHead() {
        return this.head;
    }

    public boolean isEmpty() {
        return (this.count == 0);
    }

    public Object getFirst() {
        if (this.count == 0) {
            throw new Exception("Lista vazia");
        }
        return this.head.getElement();
    }

    public Object getLast() {
        if (this.count == 0) {
            throw new Exception("Lista vazia");
        }
        return this.tail.getElement();
    }

    public Object get(int position) {
        if (this.count == 0) {
            throw new Exception("Lista vazia");
        }
        SingleListNode currentNode = this.head;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getElement();
    }

    public void insertFirst(Object element) {
        SingleListNode newNode = new SingleListNode(element, this.head);
        this.head = newNode;
        if (this.count == 0) {
            this.tail = newNode;
        }
        this.count++;
    }

    public void insertLast(Object element) {
        SingleListNode newNode = new SingleListNode(element, null);
        if (this.count == 0) {
            this.head = newNode;
        }
        else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        this.count++;
    }

    public void insert(Object element, int position) {
        if (position < 0 || position > this.count) {
            throw new Exception("Posição invalida");
        }
        else {
            if (position == 0) {
                this.insertFirst(element);
            }
            else if (position == this.count) {
                this.insertLast(element);
            }
            else {
                SingleListNode previousNode = this.head;
                for (int i = 0; i < position - 1; i++) {
                    previousNode = previousNode.getNext();
                }
                SingleListNode newNode = new SingleListNode(element, previousNode.getNext());
                previousNode.setNext(newNode);
                this.count++;
            }
        }
    }

    public Object removerFirst() {
        if (this.count == 0) {
            throw new Exception("Lista vazia");
        }
        else {
            SingleListNode lastHead = this.head;
            this.head = this.head.getNext();
            this.count--;
            return lastHead.getElement();
        }
    }

    public Object removeLast() {
        if (this.count == 0) {
            throw new Exception("Lista vazia");
        }
        else {
            SingleListNode lastTail = this.tail;
            SingleListNode previousNode = this.head;
            for (int i = 0; i < this.count -  2; i++) {
                previousNode = previousNode.getNext();
            }
            previousNode.setNext(null);
            this.tail = previousNode;
            this.count--;
            return lastTail.getElement();
        }
    }

    public Object remove(int position) {
        if (this.count == 0) {
            throw new Exception("Lista vazia");
        }
        if (position < 0 || position >= this.count) {
            throw new Exception("Posição invalida");
        }
        else {
            if (position == 0) {
                return this.removerFirst();
            }
            else if (position == this.count - 1) {
                return this.removeLast();
            }
            else {
                SingleListNode selectedNode = this.head.getNext();
                SingleListNode previousNode = this.head;
                for (int i = 0; i < position - 1; i++) {
                    selectedNode = selectedNode.getNext();
                    previousNode = previousNode.getNext();
                }
                previousNode.setNext(selectedNode.getNext());
                this.count--;
                return selectedNode.getElement();
            }
        }
    }

    public SinglyLinkedListIterator iterator() {
        return new SinglyLinkedListIterator(this);
    }

}
