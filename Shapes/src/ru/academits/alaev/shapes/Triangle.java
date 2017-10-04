package ru.academits.alaev.shapes;

public class Triangle {
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
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double c = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        if ((a + b <= c) || (a + c <= b || c + b <= a)) {
            return -1;
        } else {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
    }

    public double getPerimeter() {
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double c = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        return a + b + c;
    }
}
