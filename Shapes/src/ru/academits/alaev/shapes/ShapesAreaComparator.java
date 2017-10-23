package ru.academits.alaev.shapes;

import java.util.Comparator;

public class ShapesAreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.getArea() == o2.getArea()) {
            return 0;
        }
        if (o1.getArea() > o2.getArea()) {
            return 1;
        } else {
            return -1;
        }
    }
}
