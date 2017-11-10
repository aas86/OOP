package ru.academits.alaev.ru.academits.alaev.main;

import ru.academits.alaev.ListItem;
import ru.academits.alaev.singlylinkedlist.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        ListItem<Integer> head = new ListItem<>();
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(head);
    }
}
