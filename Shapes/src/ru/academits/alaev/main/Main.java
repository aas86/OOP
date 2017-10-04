package ru.academits.alaev.main;

import ru.academits.alaev.shapes.Circle;
import ru.academits.alaev.shapes.Square;
import ru.academits.alaev.shapes.Triangle;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(3);
        System.out.println("Площадь квадрата = " + square.getArea());
        System.out.println("Периметр квадрата = " + square.getPerimeter());
        Circle circle = new Circle(5);
        System.out.println("Площадь окружности = " + circle.getArea());
        Triangle triangle = new Triangle(2, 2, 6, 4, 8, 1);
        if (triangle.getArea() == -1) {
            System.out.println("Это прямая, а не треугольник");
        } else {
            System.out.println("Площадь треугольника = " + triangle.getArea());
        }
    }
}