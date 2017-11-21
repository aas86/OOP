package ru.academits.alaev.main;

import ru.academits.alaev.hashtable.MyHashTable;

public class Main {
    public static void main(String[] args) {
        Integer o1 = 2;
        MyHashTable<Integer> table = new MyHashTable<>();
        System.out.println(table.size());
        System.out.println(table.add(o1));
        System.out.println(table.add(o1));
        System.out.println(table.size());


    }
}
