package ru.academits.alaev.ru.academits.alaev.main;

import ru.academits.alaev.ListItem;
import ru.academits.alaev.singlylinkedlist.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        //Сначала просто создаём элементы ссылающиеся друг на друга
        ListItem<Integer> object3 = new ListItem<>(5, null); // 3ий указывает на null => последний элемент
        ListItem<Integer> object2 = new ListItem<>(3, object3); // 2 элемент указывает на 3ий
        ListItem<Integer> object1 = new ListItem<>(1, object2); // 1 элемент указывает на 2ой

        // Создаём объект класса односвязного списка, т.е. объект хранящий ссылку на первый оюъект списка
        SinglyLinkedList<Integer> head = new SinglyLinkedList<>(object1); //аргумент head, т.е ссылка на object1 - теперь head

        // Вставка в начало
        ListItem<Integer> object = new ListItem<>(100); // Создаём какой-то объект(только данные)
        object.setNext(object1);     // Делаем, чтобы теперь он ссылался на 1ый элемент списка
        head.setHead(object);        // Делаем, чтобы на наш объект ссылалась head(т.е. теперь object стал первым)

        // Получение размера списка
        int size = head.listSize();
        System.out.println("Размер списка = " + size);

        //Получение первого узла
        System.out.println(head.getFirstElement());
    }
}
