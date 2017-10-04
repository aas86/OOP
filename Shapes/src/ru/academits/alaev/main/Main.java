package ru.academits.alaev.main;

import ru.academits.alaev.shapes.Circle;
import ru.academits.alaev.shapes.Square;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(3);
        System.out.println("Площадь квадрата = " + square.getArea());
        System.out.println("Периметр квадрата = " + square.getPerimeter());
        Circle circle = new Circle(5);
        System.out.println("Площадь окружности = " + circle.getArea());

    }
}