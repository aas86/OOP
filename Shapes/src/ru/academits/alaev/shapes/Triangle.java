package ru.academits.alaev.shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private double getSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public double getWidth() {
        double max = Math.max(Math.max(x1, x2), x3);
        double min = Math.min(Math.min(x1, x2), x3);
        return max - min;
    }

    public double getHeight() {
        double max = Math.max(Math.max(y1, y2), y3);
        double min = Math.min(Math.min(y1, y2), y3);
        return max - min;
    }

    public double getArea() {
        double a = getSide(x1, y1, x2, y2);
        double b = getSide(x3, y3, x2, y2);
        double c = getSide(x3, y3, x1, y1);
        if ((a + b <= c) || (a + c <= b || c + b <= a)) {
            return 0;
        } else {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
    }

    public double getPerimeter() {
        double a = getSide(x1, y1, x2, y2);
        double b = getSide(x3, y3, x2, y2);
        double c = getSide(x3, y3, x1, y1);
        return a + b + c;
    }

    @Override
    public int hashCode() {
        final int prime = 77;
        int hash = 1;
        hash = prime * hash + (int) this.x1;
        hash = prime * hash + (int) this.y1;
        hash = prime * hash + (int) this.x2;
        hash = prime * hash + (int) this.y2;
        hash = prime * hash + (int) this.x3;
        hash = prime * hash + (int) this.y3;
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
        Triangle object = (Triangle) o;

        return object.x1 == this.x1 && object.x2 == this.x2 && object.x3 == this.x3
                && object.y1 == this.y1 && object.y2 == this.y2 && object.y3 == this.y3;
    }

}
