package ru.academits.alaev.shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public int hashCode() {
        final int prime = 77;
        int hash = 1;
        hash = prime * hash + (int) this.width;
        hash = prime * hash + (int) this.height;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return (rectangle.width == this.width) && (rectangle.height == this.height);
    }

}
