package ru.academits.alaev.main;
import ru.academits.alaev.arraylistcourse.MyArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        MyArrayList<Double> list1 = new MyArrayList<>();


        list1.add(1.1);
        list1.add(2.2);
        list1.add(3.3);
        list1.add(4.4);
        list1.add(5.5);
        list1.add(6.6);
        list1.add(7.7);
        list1.add(8.8);
        System.out.println(list1.toString());
        list1.add(0, 100.0);
        System.out.println(list1.toString());
        System.out.println(list1.get(7));
        list1.set(0,5.5555);
        System.out.println(list1.toString());
        list1.remove(0);
        System.out.println(list1.toString());
        list1.remove(5.5);
        System.out.println(list1.toString());

    /*    MyArrayList<Double> list2 = new MyArrayList<>();
        list2.add(7.0);
        list2.add(7.0);
        list2.add(7.0);*/
        Collection<Double> list2 = new Collection<>(new ArrayList<Integer>) ;


        list1.addAll(2, list2);

    }
}
