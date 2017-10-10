package ru.academits.alaev;

import ru.academits.alaev.vector.Vector;

public class Main {

    public static void main(String[] args) {
        Vector vector = new Vector(4);

        Vector vector1 = new Vector(vector);

        double[] a = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Vector vector2 = new Vector(a);

        double[] b = new double[]{1, 2, 3, 4, 5};
        Vector vector3 = new Vector(10, b);
    }
}

