package ru.academits.alaev.shapes;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getWidth() {
        return this.side;
    }

    public double getHeight() {
        return this.side;
    }

    public double getArea() {
        return this.side * this.side;
    }

    public double getPerimeter() {
        return this.side * 4;
    }
}
