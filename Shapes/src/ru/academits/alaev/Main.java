package ru.academits.alaev;

import ru.academits.alaev.shapes.Circle;
import ru.academits.alaev.shapes.Rectangle;
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
        if (triangle.getArea() == 0) {
            System.out.println("Это прямая, а не треугольник");
        } else {
            System.out.println("Площадь треугольника = " + triangle.getArea());
        }
        Rectangle P1 = new Rectangle(5, 10);
        System.out.println("Ширина прямоугольника = " + P1.getWidth());
        System.out.println("Периметр прямоугольника = " + P1.getPerimeter());

        Triangle tr1 = new Triangle(2, 3, 4, 4, 6, 1);
        System.out.println("Площадь треугольника =  " + tr1.getArea());
        System.out.println("Периметр треугольника =  " + tr1.getPerimeter());
        System.out.println("Высота треугольника = " + tr1.getHeight());
    }
}