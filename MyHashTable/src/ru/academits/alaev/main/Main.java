package ru.academits.alaev.main;

import ru.academits.alaev.hashtable.MyHashTable;

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


    }
}
