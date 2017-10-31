package ru.academits.alaev.main;
import ru.academits.alaev.arraylistcourse.MyArrayList;

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
        Collection<Double> list2 = new Collection<Double>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Double> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Double aDouble) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Double> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        list1.addAll(2, list2);

    }
}
