package ru.academits.alaev.shapes;

import java.util.Comparator;

public class ShapesPerimeterComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.getPerimeter() == o2.getPerimeter()) {
            return 0;
        }
        if (o1.getPerimeter() > o2.getPerimeter()) {
            return 1;
        } else {
            return -1;
        }
    }
}
