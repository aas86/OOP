package ru.academits.alaev.singlylinkedlist;

import ru.academits.alaev.ListItem;

public class SinglyLinkedList<T> {
    private ListItem<T> head;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
    }

    public SinglyLinkedList() {

    }
}
