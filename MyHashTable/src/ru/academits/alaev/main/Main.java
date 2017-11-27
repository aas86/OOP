package ru.academits.alaev.main;

import ru.academits.alaev.hashtable.MyHashTable;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer o1 = 2;
        System.out.println("Создаём таблицу пустым конструктором, там size = 10 ");
        MyHashTable<Integer> table = new MyHashTable<>();
        System.out.println("Размер таблицы = " + table.size());

        System.out.println("Проверяем хэш таблицу пустая ли?");
        if (table.isEmpty()) {
            System.out.println("Да! Хэш таблица пустая");
        } else {
            System.out.println("Нет! В хэш таблице есть объекты");
        }

        System.out.println("Добавляем элемент в хэш таблицу " + table.add(o1));
        System.out.println("Проверяем хэш таблицу пустая ли?");
        if (table.isEmpty()) {
            System.out.println("Да! Хэш таблица пустая");
        } else {
            System.out.println("Нет! В хэш таблице есть объекты");
        }
        System.out.println(table.add(o1));
        System.out.println(table.size());
        System.out.println(table.contains(8));
        Integer o2 = 5;
        table.add(o2);
        System.out.println(table.size());
        for (Iterator<Integer> i = table.iterator(); i.hasNext();){
            System.out.println(i.next());
        }
        System.out.println(table.size());
        System.out.println(table.contains(o2));
        System.out.println(table.remove(5));
        for (Iterator<Integer> i = table.iterator(); i.hasNext();){
            System.out.println(i.next());
        }
        System.out.println(table.size());
        System.out.println(table.contains(o2));
        table.add(1); table.add(1); table.add(1);
        table.add(7); table.add(7);
        for (Iterator<Integer> i = table.iterator(); i.hasNext();){
            System.out.println(i.next());
        }
        System.out.println(table.size());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(1); list.add(1); list.add(1);


        System.out.println(table.containsAll(list));
        System.out.println(table.removeAll(list));

    }
}
