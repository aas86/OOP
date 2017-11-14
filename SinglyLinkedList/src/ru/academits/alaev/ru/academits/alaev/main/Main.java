package ru.academits.alaev.ru.academits.alaev.main;

import ru.academits.alaev.singlylinkedlist.ListItem;
import ru.academits.alaev.singlylinkedlist.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        // Создаём объект класса односвязного списка, т.е. объект хранящий ссылку на первый оюъект списка
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(); //аргумент head, т.е ссылка на object1 - теперь head

        //Тут создаём объекты списка
        ListItem<Integer> object0 = new ListItem<>(777);
        ListItem<Integer> object1 = new ListItem<>(555);

        //вставка в начало
        System.out.println(list.getSize());
        list.beginInsert(object0);
        System.out.println(list.getFirstElement());
        System.out.println(list.getSize());
        list.beginInsert(object1);
        System.out.println(list.getFirstElement());
        list.beginInsert(new ListItem<>(888));
        list.beginInsert(new ListItem<>(111));
        System.out.println(list.getFirstElement());
        System.out.println(list.getElement(1));
        System.out.println(list.getSize());

    }
}
