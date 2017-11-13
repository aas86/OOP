package ru.academits.alaev.singlylinkedlist;

import ru.academits.alaev.ListItem;

public class SinglyLinkedList<T> {
    private ListItem<T> head;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
    }

    public SinglyLinkedList() {

    }

    public ListItem<T> getHead() {

        return head;
    }

    public void setHead(ListItem<T> head) {
        this.head = head;
    }
    public int listSize(){
        int count = 1;
        for (ListItem<T> p = head; p.getNext() != null; p = p.getNext()){
            count++;
        }
        return count;
    }
    public T getFirstElement(){
        return head.getData();
    }
}
