package ru.academits.alaev;

import ru.academits.alaev.shapes.*;

import java.util.Arrays;

public class Main {
    private static double maxArea(Shape... shape) {
        double maxArea = 0;
        for (Shape e : shape) {
            if (e.getArea() > maxArea) {
                maxArea = e.getArea();
            }
        }
        return maxArea;
    }

    private static double secondPerimeter(Shape... shape) {
        double[] array = new double[shape.length];
        for (int i = 0; i < shape.length; ++i) {
            array[i] = shape[i].getPerimeter();
        }
        Arrays.sort(array);
        return array[array.length - 2];
    }

    public static void main(String[] args) {
        Square square = new Square(3);
        System.out.println("Площадь квадрата = " + square.getArea());
        System.out.println("Периметр квадрата = " + square.getPerimeter());

        Square square1 = new Square(6);
        System.out.println("Площадь квадрата1 = " + square1.getArea());
        System.out.println("Периметр квадрата = " + square1.getPerimeter());

        Circle circle = new Circle(5);
        System.out.println("Площадь окружности = " + circle.getArea());
        System.out.println("Периметр окружности = " + circle.getPerimeter());

        Triangle triangle = new Triangle(2, 2, 6, 4, 8, 1);
        if (triangle.getArea() == 0) {
            System.out.println("Это прямая, а не треугольник");
        } else {
            System.out.println("Площадь треугольника = " + triangle.getArea());
            System.out.println("Периметр треугольника = " + triangle.getPerimeter());
        }

        Rectangle P1 = new Rectangle(5, 10);
        System.out.println("Площадь прямоугольника = " + P1.getArea());
        System.out.println("Периметр прямоугольника = " + P1.getPerimeter());

        Triangle triangle1 = new Triangle(2, 3, 4, 4, 6, 1);
        System.out.println("Площадь треугольника =  " + triangle1.getArea());
        System.out.println("Периметр треугольника =  " + triangle1.getPerimeter());


        System.out.println("Max Square = " + Main.maxArea(square, square1, circle, triangle, P1, triangle1));
        System.out.println("Second Perimeter = " + Main.secondPerimeter(square, square1, circle, triangle, P1, triangle1));

        Triangle triangle2 = new Triangle(2, 2, 6, 4, 8, 1);
        if (triangle.hashCode() != triangle2.hashCode()) {
            System.out.println("Хэши разные => объекты разные!");
        } else if (triangle.equals(triangle2)) {
            System.out.println("Хэши равны и по equals равны => Объекты равны!");
        } else {
            System.out.println("Хэши равны, но по equals не равны!");
        }

        System.out.println(circle.toString());
        System.out.println(square.toString());
        System.out.println(square1.toString());
        System.out.println(P1.toString());
        System.out.println(triangle1.toString());

        Shape[] array = new Shape[]{square, square1, circle, triangle, P1, triangle1};

        Arrays.sort(array, new ShapesAreaComparator());
        System.out.println("Фигура с самой большой площадью - " + array[array.length - 1] + " S = " + array[array.length - 1].getArea());
        System.out.println("Фигура со вторым периметром - " + array[array.length - 2] + " P = " + array[array.length - 2].getPerimeter());
    }

}