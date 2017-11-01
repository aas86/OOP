package ru.academits.alaev.main;
import ru.academits.alaev.arraylistcourse.MyArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();


        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        System.out.println(list1.toString());
        list1.add(0, 1);
        System.out.println(list1.toString());
        System.out.println(list1.get(7));
        list1.set(0,5);
        System.out.println(list1.toString());
        list1.remove(0);
        System.out.println(list1.toString());
        list1.remove(5);
        System.out.println(list1.toString());

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(1);
        list2.add(7);
        list2.add(8);


        list1.containsAll(list2);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        if (list1.containsAll(list2)){
            System.out.println("List1 " + list1.toString() + " contains " + "List2 " + list2.toString());
        } else{
            System.out.println("Not contains");
        }

    }
}
