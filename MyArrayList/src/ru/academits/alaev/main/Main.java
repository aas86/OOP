package ru.academits.alaev.main;

import ru.academits.alaev.arraylistcourse.MyArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        list1.add(1);
        list1.add(null);
        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(6);
        System.out.println(list1.toString());
        list1.add(0, 1);
        System.out.println(list1.toString());
        System.out.println(list1.get(7));
        list1.set(0, null);
        System.out.println(list1.toString());
        list1.remove(2);
        System.out.println(list1.toString());
        list1.remove(5);
        System.out.println(list1.toString());

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(1);
        list2.add(5);
        list2.add(null);
        list2.add(9);
        System.out.println(list2.toString());
        if (list2.contains(2)) {
            System.out.println("List2 содержит в себе проверяемый объект ");
        } else {
            System.out.println("List2 не содержит в себе проверяемый объект ");
        }

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
        list3.add(2);
        list3.add(5);
        list3.add(null);
        list3.add(null);
        list3.add(1);
        System.out.println(list3.indexOf(2));
        System.out.println(list3.lastIndexOf(null));

        System.out.println("Проверка метода removeAll(Collection<?> c)");
        MyArrayList<Integer> list4 = new MyArrayList<>();
        list4.add(10);
        list4.add(5);
        if (list3.removeAll(list4)) {
            System.out.println("Произошло удаление всей коллекции " + list4 + " из " + list3);
        } else {
            System.out.println("Не было удаления");
        }
        System.out.println("Проверка методов contains add(i,o)");
        MyArrayList<Integer> list5 = new MyArrayList<>();
        list5.add(1);
        list5.add(5);
        list5.add(3);
        list5.add(4);
        list5.add(null);
        list5.add(5);
        list5.add(5);
        list5.add(5);
        list5.add(5);
        list5.add(5);
        System.out.println(list5.size());
        list5.add(6, 8);
        MyArrayList<Integer> list6 = new MyArrayList<>();
        list6.add(3);
        list6.add(67);
        System.out.println(list5);
        System.out.println(list6);
        System.out.println(list5.lastIndexOf(null));
        if (list5.contains(null)) {
            System.out.println("Содержит ");
        } else {
            System.out.println("Не содержит");
        }

        System.out.println("Проверка добавления, поиска и удаления NULLов");

        System.out.println("Проверка addAll");
        MyArrayList<Integer> list7 = new MyArrayList<>();
        list7.add(1);
        list7.add(2);
        list7.add(3);
        list7.add(4);
        list7.add(null);
        MyArrayList<Integer> list8 = new MyArrayList<>();
        list8.add(0);
        list8.add(null);
        list8.add(null);
        System.out.println(list7.addAll(list8));
        System.out.println(list7);

        System.out.println("Проверка addAll по индексу");
        MyArrayList<Integer> list9 = new MyArrayList<>();
        list9.add(1);
        list9.add(1);
        list9.add(null);
        list9.add(4);
        list9.add(5);
        MyArrayList<Integer> list10 = new MyArrayList<>();
        list10.add(110);
        list10.add(120);
        list10.add(130);
        System.out.println(list9.addAll(2, list10));
        list9.add(110);
        list9.add(null);
        System.out.println(list9);

        System.out.println("Проверка remove(Object)");
        System.out.println(list9.remove(null));
        System.out.println(list9);
        System.out.println("Проверка removeAll(Collection<?> c)");
        MyArrayList<Integer> list11 = new MyArrayList<>();
        list11.add(1);
        list11.add(4);
        list11.add(5);
        System.out.println(list9.removeAll(list11));
        System.out.println(list9);
        System.out.println(list9.size());

        System.out.println("Проверка метода retainAll");
        MyArrayList<Integer> list12 = new MyArrayList<>();
        list12.add(1);
        list12.add(2);
        list12.add(3);
        list12.add(4);
        list12.add(2);
        MyArrayList<Integer> list13 = new MyArrayList<>();
        list13.add(1);
        list13.add(2);
        list12.retainAll(list13);
        System.out.println(list12);

        Object[] ar = list13.toArray();
        for (Object e : ar) {
            System.out.println(e);
        }
        MyArrayList<Integer> list14 = new MyArrayList<>();
        list14.add(1);
        list14.add(2);
        list14.add(null);
        list14.add(4);
        list14.add(5);
        System.out.println(list14);
        ListIterator<Integer> iterator = list14.listIterator(3);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasPrevious());
        System.out.println(iterator.next());

        // System.out.println(iterator.previous());
        System.out.println(iterator.nextIndex());
        System.out.println(iterator.previousIndex());
        iterator.remove();
        System.out.println(list14);
        iterator.add(null);
        System.out.println(iterator.nextIndex());
        System.out.println(list14);
        MyArrayList<Double> list15 = new MyArrayList<>();
        list15.add(1.1);
        list15.add(2.2);
        list15.add(null);

        System.out.println("Проверка ListIterator()");
        System.out.println(list5);
        ListIterator<Integer> i = list5.listIterator(1);
        i.hasNext();
        System.out.println(i.previousIndex());
        System.out.println(i.nextIndex());
        i.add(500);
        System.out.println(i.nextIndex());
        System.out.println(list5);
        i.next();
        System.out.println(i.nextIndex());
        i.remove();
        System.out.println(i.nextIndex());
        System.out.println(list5);
        i.next();
        System.out.println(i.nextIndex());
        i.add(999);
        System.out.println(list5);
        i.next();
        i.next();
        i.next();
        i.next();
        System.out.println(list5.size());
        System.out.println(i.nextIndex());

        System.out.println("Проверка  toArray(E[] a)");
        System.out.println(list15);
        Double[] arr = new Double[1];
        arr = list15.toArray(arr);
        for (Double e : arr) {
            System.out.println(e);
        }



    }
}
