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
        ListItem<Integer> object2 = new ListItem<>(111);
        //вставка в начало
        //   System.out.println(list.getSize());
        list.beginInsert(object0);
        System.out.println(list.getFirstElement());
        System.out.println(list.getSize());
        list.beginInsert(object1);
        System.out.println(list.getFirstElement());
        //  list.beginInsert(new ListItem<>(888));
        //list.beginInsert(new ListItem<>(111));
        list.beginInsert(object2);
        System.out.println(list.getFirstElement());
        System.out.printf("%d %d %d ", list.getElement(0), list.getElement(1), list.getElement(2));
        //   System.out.println(list.getElement(1));
        //   System.out.println(list.getElement(2));
        System.out.println();
        System.out.println(list.getSize());
        //  list.insertElement(2, new ListItem<>(7));
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.printf("%d ", list.getElement(i));
        }
      /*  System.out.println();
        System.out.println("Проверка метода удаления элемента по индексу");
        System.out.println("Удалённый элемент : " + list.delete(2));
        for (int i = 0; i < list.getSize(); ++i){
            System.out.printf("%d " , list.getElement(i));
        }
        System.out.println();
        System.out.println("Проверка метода удаления первого элемента:");
        list.deleteFirst();
        for (int i = 0; i < list.getSize(); ++i){
            System.out.printf("%d " , list.getElement(i));
        }*/

        System.out.println();
        System.out.println("Проверка метода удаления элемента по значению:");
        ListItem<Integer> object3 = new ListItem<>(111);
        list.delete(object3);
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.printf("%d ", list.getElement(i));
        }
        System.out.println();
        System.out.println("Проверка метода вставка узла после указанного :");
        ListItem<Integer> object4 = new ListItem<>(444);
        list.insertAfter(1, object4);
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.printf("%d ", list.getElement(i));
        }
        System.out.println("Проверка метода вставка узла после указанного :");
        ListItem<Integer> object5 = new ListItem<>(222);
        list.insertAfter(1, object5);
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.printf("%d ", list.getElement(i));
        }


        list.deleteAfter(1);
        System.out.println();
        System.out.println("Проверка метода удаления узла после указанного :");
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.printf("%d ", list.getElement(i));
        }

        System.out.println();
   /*     System.out.println("Проверка метода изменения значения по индексу (выдает старое значение) :");
        ListItem<Integer> object6 = new ListItem<>(0);
        System.out.println("Старое значение элемента: " + list.setElement(1, object6));
        for (int i = 0; i < list.getSize(); ++i){
            System.out.printf("%d " , list.getElement(i));
        }*/
        ListItem<Integer> object6 = new ListItem<>(0);
        list.beginInsert(object6);
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.printf("%d ", list.getElement(i));
        }
        System.out.println("Разворот ");
        list.reverse();
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.printf("%d ", list.getElement(i));
        }
    }
}
