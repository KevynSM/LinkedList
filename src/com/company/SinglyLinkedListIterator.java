package com.company;

public class SinglyLinkedListIterator {
    private SinglyLinkedList linkedList;
    private SingleListNode position;

    SinglyLinkedListIterator(SinglyLinkedList linkedList) {
        this.linkedList = linkedList;
        this.rewind();
    }

    public boolean hasNext() {
        return (this.position != null);
    }

    public Object next() {
        if (this.hasNext()) {
            Object element = this.position.getElement();
            this.position = this.position.getNext();
            return element;
        }
        else {
            throw new Exception("Não há elemento");
        }
    }

    public void rewind() {
        if (this.linkedList.isEmpty()) {
            this.position = null;
        }
        else {
            this.position = this.linkedList.getHead();
        }
    }
    
}
