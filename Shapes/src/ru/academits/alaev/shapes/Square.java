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

    @Override
    public String toString() {
        return "Квадрат со стороной " + side;
    }

    @Override
    public int hashCode() {
        final int prime = 77;
        int hash = 1;
        return prime * hash + (int) this.side;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return square.side == this.side;
    }
}
