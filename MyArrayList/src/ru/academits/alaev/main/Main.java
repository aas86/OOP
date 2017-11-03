package ru.academits.alaev.main;

import ru.academits.alaev.arraylistcourse.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(6);
        System.out.println(list1.toString());
        list1.add(0, 1);
        System.out.println(list1.toString());
        System.out.println(list1.get(7));
        list1.set(0, 5);
        System.out.println(list1.toString());
        list1.remove(0);
        System.out.println(list1.toString());
        list1.remove(5);
        System.out.println(list1.toString());

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(1);
        list2.add(5);
        list2.add(8);
        list2.add(9);
        System.out.println(list2.toString());
        if (list2.contains(2)) {
            System.out.println("List2 содержит в себе проверяемый объект ");
        } else {
            System.out.println("List2 не содержит в себе проверяемый объект ");
        }

        System.out.println(list2.indexOf(9));

        System.out.println("Проверка containsAll ");
        System.out.println("List1 :" + list1.toString());
        System.out.println("List2 :" + list2.toString());

        if (list1.containsAll(list2)) {
            System.out.println("List1 " + list1.toString() + " contains " + "List2 " + list2.toString());
        } else {
            System.out.println("Not contains");
        }

        System.out.println("Проверка метода lastIndexOf(Object):");
        MyArrayList<Integer> list3 = new MyArrayList<>();
        list3.add(15);
        list3.add(5);
        list3.add(2);
        list3.add(1);
        list3.add(3);
        list3.add(5);
        list3.add(5);
        list3.add(5);
        list3.add(1);
        System.out.println(list3.lastIndexOf(3));

        System.out.println("Проверка метода removeAll(Collection<?> c)");
        MyArrayList<Integer> list4 = new MyArrayList<>();
        list4.add(10);
        list4.add(5);
        if (list3.removeAll(list4)) {
            System.out.println("Произошло удаление всей коллекции " + list4 + " из " + list3);
        } else {
            System.out.println("Не было удаления");
        }
        System.out.println("Проверка метода retainAll и contains");
        MyArrayList<Integer> list5 = new MyArrayList<>();
        list5.add(1);
        list5.add(5);
        list5.add(3);
        list5.add(4);
        list5.add(null);
        list5.add(5);
        MyArrayList<Integer> list6 = new MyArrayList<>();
        list6.add(3);
        list6.add(67);
        System.out.println(list5);
        System.out.println(list6);
        if(list5.contains(null)){
            System.out.println("Содержит ");
        } else{
            System.out.println("Не содержит");
        }
        list5.retainAll(list6);
        System.out.println(list5);
        System.out.println("Проверка добавления, поиска и удаления NULLов");
        list5.add(null);
        System.out.println(list5);
        System.out.println(list5.indexOf(5));
        System.out.println(list5.lastIndexOf(null));
        list5.add(5);
        list5.add(5);

        System.out.println(list5);
        list5.add(4,null);
        System.out.println(list5);
        System.out.println(list5.lastIndexOf(null));

        System.out.println("Проверка addAll");
        MyArrayList<Integer> list7 = new MyArrayList<>();
        list7.add(1);
        list7.add(2);
        list7.add(3);
        list7.add(4);
        MyArrayList<Integer> list8 = new MyArrayList<>();
        list8.add(0);
        list8.add(0);
        list8.add(0);
        System.out.println(list7.addAll(1,list8));
        System.out.println(list7);


    }
}
