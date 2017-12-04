package ru.academits.alaev.main;

import ru.academits.alaev.hashtable.MyHashTable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer o1 = 2;
        System.out.println("Создаём таблицу пустым конструктором, там size = 10 ");
        MyHashTable<Integer> table = new MyHashTable<>();
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());

        System.out.println("Проверяем хэш таблицу пустая ли?");
        if (table.isEmpty()) {
            System.out.println("Да! Хэш таблица пустая");
        } else {
            System.out.println("Нет! В хэш таблице есть объекты");
        }

        System.out.println("Добавляем элемент в хэш таблицу " + table.add(o1));
        System.out.println("Добавляем элемент в хэш таблицу " + table.add(null));
        System.out.println("Проверяем хэш таблицу пустая ли?");
        if (table.isEmpty()) {
            System.out.println("Да! Хэш таблица пустая");
        } else {
            System.out.println("Нет! В хэш таблице есть объекты");
        }
        System.out.println(table.add(o1));
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());
        System.out.println(table.contains(8));
        Integer o2 = 5;
        table.add(o2);
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());
        for (Iterator<Integer> i = table.iterator(); i.hasNext(); ) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());
        System.out.println(table.contains(o2));
        System.out.println(table.remove(2));
        for (Iterator<Integer> i = table.iterator(); i.hasNext(); ) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());
        System.out.println(table.contains(o2));
        table.add(1);
        table.add(1);
        table.add(1);
        table.add(7);
        table.add(7);
        for (Iterator<Integer> i = table.iterator(); i.hasNext(); ) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(null);


        System.out.println(table.containsAll(list));
        System.out.println(table.removeAll(list));
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());
        for (Integer iterator : table) {
            System.out.print(iterator + " ");
        }
        System.out.println();
        System.out.println("Проверка метода addAll() ");
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(6);
        list1.add(1);
        list1.add(1);
        System.out.println(table.addAll(list1));
        for (Integer iterator : table) {
            System.out.print(iterator + " ");
        }
        System.out.println();
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());

        System.out.println();
        System.out.println("Проверка метода removeAll() ");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(8);
        list2.add(8);
        list2.add(1);
        System.out.println(table.removeAll(list2));
        //   table.add(0);
        //   table.add(0);
        for (Integer iterator : table) {
            System.out.print(iterator + " ");
        }
        System.out.println();
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());

        Object[] array = table.toArray();
        for (Object e : array) {
            System.out.print(e + " ");
        }

        System.out.println();
        System.out.println("Проверка метода retainAll");
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(5);
        System.out.println(table.retainAll(list3));
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());
        for (Integer iterator : table) {
            System.out.print(iterator + " ");
        }
        System.out.println();
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());

        Integer[] a = new Integer[1];
        table.toArray(a);
        for (Integer e : a) {
            System.out.println(e);
        }

        System.out.println("Проверка метода clear");
        table.clear();
        for (Integer iterator : table) {
            System.out.print(iterator + " ");
        }
        System.out.println();
        System.out.println("Количество элементов в Хэш-таблице: " + table.size());
    }
}
